package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class fragmentactivity extends AppCompatActivity {
;
    Button fragA, fragB, fragC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmentactivity);
        fragA = findViewById(R.id.fragbtn1);
        fragB = findViewById(R.id.fragbtn2);
        fragC = findViewById(R.id.fragbtn3);
        loadfrag(new Afragment(), true);
        fragA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadfrag(new Afragment(),true);
                //loadfrag(Afragment.getInstance("Siddharth lahoti", 789), false);
            }
        });

        fragB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadfrag(new Bfragment(),false);
            }
        });
        fragC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadfrag(new Cfragment(), false);
            }
        });
    }
    public void loadfrag(Fragment fragment, boolean flag)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

//        Bundle bundle = new Bundle();
//        bundle.putString("Name","Mohit Lahoti");
//        bundle.putInt("Roll No",143);
//        fragment.setArguments(bundle);

        if(flag==true) {
            ft.add(R.id.framecontainer, fragment);
//            fm.popBackStack(ROOT_FRAGMENT_TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE);
//            ft.addToBackStack(ROOT_FRAGMENT_TAG);
        }
        else {
            ft.replace(R.id.framecontainer, fragment);
        }
        ft.addToBackStack(null);
        ft.commit();
    }

    public void callfromfragment()
    {
        Log.d("inAct","The function is calling from activity to fragment....");
    }

}