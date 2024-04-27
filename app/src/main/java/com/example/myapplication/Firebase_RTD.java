package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Firebase_RTD extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_rtd);

        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference("Copyright");
        databaseReference.setValue("All Rights are reserved under this app");

        DatabaseReference contref=FirebaseDatabase.getInstance().getReference("Contact list");
        String contactID=contref.push().getKey();
        Firebase_cont_model fcm = new Firebase_cont_model("Siddharth Lahoti","7568777573");
        contref.child(contactID).setValue(fcm);

        //receiving data from rtd
        contref.child(contactID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               Firebase_cont_model fcm =  snapshot.getValue(Firebase_cont_model.class);
               Log.d("RTD Data","Name: "+fcm.getName()+" ,MobileNo: "+fcm.getMob_no());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("Errorinrtd",error.toString());
            }
        });
    }
}