package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class getjsonapi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getjsonapi);
        ListView listView = findViewById(R.id.jsonlist);
        ArrayList<String> arrname = new ArrayList<>();

        String url = "https://jsonplaceholder.typicode.com/users";
        AndroidNetworking.initialize(this);
        AndroidNetworking.get(url).setPriority(Priority.HIGH).build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("RESPONSE",response.toString());

                        //Parsing
                        try {

                            for (int i=0; i<response.length();i++)
                            {
                                JSONObject objname = response.getJSONObject(i);
                                String name = objname.getString("name");
                                arrname.add(name);

                                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getjsonapi.this, android.R.layout.simple_list_item_1, arrname);
                                listView.setAdapter(arrayAdapter);
                            }

                        }
                        catch (JSONException e) {
                            throw new RuntimeException(e);
                        }


                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d("Error", anError.toString());
                    }
                });


    }
}