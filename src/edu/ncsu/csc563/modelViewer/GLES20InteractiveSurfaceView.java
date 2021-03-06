package edu.ncsu.csc563.modelViewer;

import edu.ncsu.csc563.modelViewer.rendering.GLES20Renderer;
import edu.ncsu.csc563.modelViewer.scene.Scene;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.MotionEvent;

/**
 * SurfaceView that manages an OpenGL ES 2.0 Renderer and can handle
 * touch and accelerometer events
 */
public class GLES20InteractiveSurfaceView extends GLSurfaceView implements SensorEventListener {
	private SensorManager mSensorManager;
    private Sensor mAccelerometer;    
    private float[] mGravity;
    
    public static float xAngle;
    public static float yAngle;
    public static float zAngle;
    
    private float baseRoll;
    private float baseTilt;
    
    public static float roll;
    public static float tilt;
	
    public GLES20InteractiveSurfaceView(Context context) {
        super(context);

        // Create an OpenGL ES 2.0 context.
        setEGLContextClientVersion(2);

        // Set the Renderer for drawing on the GLSurfaceView
        setRenderer(new GLES20Renderer(context));
        
        this.mSensorManager = (SensorManager)context.getSystemService(Context.SENSOR_SERVICE);
        this.mAccelerometer = this.mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
    	switch (e.getAction()) {
        	case MotionEvent.ACTION_DOWN:
            	Scene.instance.switchActor();
        		break;
    	}  	
    	
    	return true;
    }

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {}

	@Override
	public void onSensorChanged(SensorEvent event) {		
		this.handleAccelerometer(event);				
	}
	
	private void handleAccelerometer(SensorEvent event) {		
		if (this.mGravity != null) {
			//xAngle = event.values[0];
			//yAngle = event.values[1];
			//zAngle = event.values[2];
			//zAngle = (float) Math.atan2(event.values[2], this.mGravity[2]);
			
			roll = (float) Math.atan2(event.values[2], event.values[0]) - this.baseRoll;
			tilt = event.values[1] - this.baseTilt;
		} else {
			this.mGravity = event.values;
			
			this.baseRoll = (float) Math.atan2(this.mGravity[2], this.mGravity[0]);
			this.baseTilt = this.mGravity[1];
			
			Log.d("BaseRoll", String.valueOf(this.baseRoll));
		}
		
		//Log.d("zAngle", String.valueOf(Math.atan2(zAngle, xAngle)));
		
		//Log.d("mGravity", String.valueOf(event.values[0]) + ", " + String.valueOf(event.values[1]) + ", " + String.valueOf(event.values[2]));
	}
	
	@Override
	public void onPause() {
		super.onPause();
		this.mSensorManager.unregisterListener(this);
	}
	
	@Override
	public void onResume() {
		super.onResume();
		this.mSensorManager.registerListener(this, this.mAccelerometer, SensorManager.SENSOR_DELAY_GAME);
		this.mGravity = null;
	}	
}