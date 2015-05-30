package br.com.pongwear.pongwear;
import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;


public class SensorActivity extends Activity implements SensorEventListener {
    Sensor accelerometer;
    SensorManager sensorManager;
    TextView acceleration;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.motion_main);
        sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this,accelerometer,SensorManager.SENSOR_DELAY_NORMAL);
        acceleration =(TextView) findViewById(R.id.acceleration);
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int arg1) {
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        acceleration.setText("X: " + event.values[0] +
                "\ny: " + event.values[1] +
                "\nZ: " + event.values[2]);
    }
}
