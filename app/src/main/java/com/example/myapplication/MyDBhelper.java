package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDBhelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Contacts_DB";
    private static final int DATABASE_VERSION= 1;
    private static final String TABLE_CONTACT = "contacts";
    private static final String KEY_ID= "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE = "phone";
    public MyDBhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + TABLE_CONTACT +
                      "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME +" TEXT," + KEY_PHONE +" TEXT" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACT);
        onCreate(db);
    }
    public void addcontacts (String name, String phone)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME,name);
        values.put(KEY_PHONE,phone);
        database.insert(TABLE_CONTACT,null,values);
    }
    public ArrayList<Contactmodelstructure> fetchcontacts()
    {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(" SELECT * FROM " + TABLE_CONTACT, null);

        ArrayList<Contactmodelstructure> contactsarray = new ArrayList<>();

        while(cursor.moveToNext())
        {
            Contactmodelstructure model = new Contactmodelstructure();
            model.id = cursor.getInt(0);
            model.name = cursor.getString(1);
            model.phone_no = cursor.getString(2);

            contactsarray.add(model);
        }
        return contactsarray;
    }

    public void updatecontact(Contactmodelstructure contactmodel)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_PHONE,contactmodel.phone_no);
        database.update(TABLE_CONTACT,values,KEY_ID + " = " + contactmodel.id,null);
    }

    public void deletecontact(int id)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(TABLE_CONTACT,KEY_ID + " = ?" , new String[]{String.valueOf(id)});
    }

}
