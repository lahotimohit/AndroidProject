package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Afragment extends Fragment {
    private static final String Arg1 = "argument1";
    private static final String Arg2 = "argument2";
    public Afragment() {
    }

    public static Afragment getInstance(String value1, int value2)
    {
        Afragment afragment = new Afragment();
        Bundle bundle = new Bundle();
        bundle.putString(Arg1,value1);
        bundle.putInt(Arg2, value2);
        afragment.setArguments(bundle);
        return afragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (getArguments()!=null)
        {
            String name = getArguments().getString(Arg1);
            int rn = getArguments().getInt(Arg2);

            Log.d("Values from activity is: ","Name is: "+name+" Roll No is "+rn);
        }
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afragment, container, false);
        TextView txtfrag = view.findViewById(R.id.fragtxt);

        ((fragmentactivity)getActivity()).callfromfragment();

        //Now perform set of instructions here
        return view;
    }
}