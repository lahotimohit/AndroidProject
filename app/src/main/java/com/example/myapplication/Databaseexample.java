package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class Databaseexample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_databaseexample);

        MyDBhelper myDBhelper = new MyDBhelper(this);
//        myDBhelper.addcontacts("Mohit Lahoti", "7568777573");
//        myDBhelper.addcontacts("Siddharth Lahoti", "7073130553");
//        myDBhelper.addcontacts("Sunita Lahoti","9468833900");
//        myDBhelper.addcontacts("Pawan Lahoti","9414417573");

//        Contactmodelstructure contactmodel = new Contactmodelstructure();
//        contactmodel.id = 1;
//        contactmodel.phone_no="1231234560";
//        myDBhelper.updatecontact(contactmodel);

        myDBhelper.deletecontact(1);

        ArrayList<Contactmodelstructure> contactsarray = myDBhelper.fetchcontacts();

        for (int i=0; i<contactsarray.size(); i++)
        {
            Log.d("CONTACTS_INFO", "Name: " + contactsarray.get(i).name + ", " + contactsarray.get(i).phone_no);
        }

    }
}