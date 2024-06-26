package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class light_sensor extends AppCompatActivity implements SensorEventListener {

    TextView tlight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_sensor);

        tlight = findViewById(R.id.txtlight);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        if(sensorManager!=null)
        {
            Sensor lightsensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
            if(lightsensor!=null)
            {
                sensorManager.registerListener(this,lightsensor,SensorManager.SENSOR_DELAY_NORMAL);
            }
            else
            {
                Toast.makeText(this, "Light Sensor not detected.", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(this, "Sensor not working", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()==Sensor.TYPE_LIGHT)
        {
            tlight.setText("Value is: "+event.values[0]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}