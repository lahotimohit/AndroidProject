package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Proximity_Sensor extends AppCompatActivity implements SensorEventListener {

    TextView proxi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity_sensor);

        proxi = findViewById(R.id.proxitxt);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if (sensorManager!=null)
        {
            Sensor proxisensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

            if (proxisensor!=null)
            {
                sensorManager.registerListener(this,proxisensor,sensorManager.SENSOR_DELAY_NORMAL);
            }
            else
            {
                Toast.makeText(this, "The proxisensor is not working......", Toast.LENGTH_SHORT).show();
            }

        }
        else
        {
            Toast.makeText(this, "Sensor not detected in your phone", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER)
        {
            proxi.setText("Value is: "+event.values[0]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}