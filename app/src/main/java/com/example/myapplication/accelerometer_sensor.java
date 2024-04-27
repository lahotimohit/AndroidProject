package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class accelerometer_sensor extends AppCompatActivity implements SensorEventListener {

    TextView asensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer_sensor);

        asensor = findViewById(R.id.asensor);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if (sensorManager!=null)
        {
            Sensor accelerosensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

            if (accelerosensor!=null)
            {
                sensorManager.registerListener(this,accelerosensor,sensorManager.SENSOR_DELAY_NORMAL);
            }
            else
            {
                Toast.makeText(this, "The accelerosensor is not working......", Toast.LENGTH_SHORT).show();
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
            asensor.setText("X: "+event.values[0]+" Y: "+event.values[1]+" Z: "+event.values[2]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}