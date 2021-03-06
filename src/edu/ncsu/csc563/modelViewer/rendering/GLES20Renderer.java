package edu.ncsu.csc563.modelViewer.rendering;

import java.io.IOException;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.util.Log;

import edu.ncsu.csc563.modelViewer.scene.Scene;
import edu.ncsu.csc563.modelViewer.utility.ResourceManager;

/**
 * Renderer for OpenGL ES 2.0
 */
public class GLES20Renderer implements GLSurfaceView.Renderer {
	/** Reference to this activity's context */
	private Context context;
	
	/** Reference to the currently active shader */
	private GLES20Shader mActiveShader;
	
	/** Reference to the game scene */
	private Scene mScene;
	
	public GLES20Renderer(Context context) {
		this.context = context;
	}
	
	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		String modelName;
		
		modelName = "meshes/RoundedCube.vmf";
		try {
			ResourceManager.loadMesh(modelName, this.context.getAssets().open(modelName));
		} catch (IOException e) {
			Log.e("MainActivity", "The file " + modelName + " could not be found.");
		}
		
		modelName = "meshes/Dragon.vmf";
		try {
			ResourceManager.loadMesh(modelName, this.context.getAssets().open(modelName));
		} catch (IOException e) {
			Log.e("MainActivity", "The file " + modelName + " could not be found.");
		}
		
		modelName = "meshes/large_spike_ball.vmf";
		try {
			ResourceManager.loadMesh(modelName, this.context.getAssets().open(modelName));
		} catch (IOException e) {
			Log.e("MainActivity", "The file " + modelName + " could not be found.");
		}
		
		modelName = "meshes/large_sqr_pyr.vmf";
		try {
			ResourceManager.loadMesh(modelName, this.context.getAssets().open(modelName));
		} catch (IOException e) {
			Log.e("MainActivity", "The file " + modelName + " could not be found.");
		}
		
		modelName = "meshes/large_tri_pyr.vmf";
		try {
			ResourceManager.loadMesh(modelName, this.context.getAssets().open(modelName));
		} catch (IOException e) {
			Log.e("MainActivity", "The file " + modelName + " could not be found.");
		}
		
		modelName = "meshes/lg_ell.vmf";
		try {
			ResourceManager.loadMesh(modelName, this.context.getAssets().open(modelName));
		} catch (IOException e) {
			Log.e("MainActivity", "The file " + modelName + " could not be found.");
		}
		
		modelName = "meshes/lg_hplus.vmf";
		try {
			ResourceManager.loadMesh(modelName, this.context.getAssets().open(modelName));
		} catch (IOException e) {
			Log.e("MainActivity", "The file " + modelName + " could not be found.");
		}
		
		modelName = "meshes/lg_plus.vmf";
		try {
			ResourceManager.loadMesh(modelName, this.context.getAssets().open(modelName));
		} catch (IOException e) {
			Log.e("MainActivity", "The file " + modelName + " could not be found.");
		}
		
		modelName = "meshes/lg_step.vmf";
		try {
			ResourceManager.loadMesh(modelName, this.context.getAssets().open(modelName));
		} catch (IOException e) {
			Log.e("MainActivity", "The file " + modelName + " could not be found.");
		}
		
		modelName = "meshes/long_hex_prism.vmf";
		try {
			ResourceManager.loadMesh(modelName, this.context.getAssets().open(modelName));
		} catch (IOException e) {
			Log.e("MainActivity", "The file " + modelName + " could not be found.");
		}
		
		modelName = "meshes/long_rect_prism.vmf";
		try {
			ResourceManager.loadMesh(modelName, this.context.getAssets().open(modelName));
		} catch (IOException e) {
			Log.e("MainActivity", "The file " + modelName + " could not be found.");
		}
		
		modelName = "meshes/rnd_cube_panel.vmf";
		try {
			ResourceManager.loadMesh(modelName, this.context.getAssets().open(modelName));
		} catch (IOException e) {
			Log.e("MainActivity", "The file " + modelName + " could not be found.");
		}
		
		modelName = "meshes/rnd_hex_panel.vmf";
		try {
			ResourceManager.loadMesh(modelName, this.context.getAssets().open(modelName));
		} catch (IOException e) {
			Log.e("MainActivity", "The file " + modelName + " could not be found.");
		}
		
		modelName = "meshes/rnd_tri_panel.vmf";
		try {
			ResourceManager.loadMesh(modelName, this.context.getAssets().open(modelName));
		} catch (IOException e) {
			Log.e("MainActivity", "The file " + modelName + " could not be found.");
		}
		
		modelName = "meshes/token.vmf";
		try {
			ResourceManager.loadMesh(modelName, this.context.getAssets().open(modelName));
		} catch (IOException e) {
			Log.e("MainActivity", "The file " + modelName + " could not be found.");
		}
		
		modelName = "meshes/turd.vmf";
		try {
			ResourceManager.loadMesh(modelName, this.context.getAssets().open(modelName));
		} catch (IOException e) {
			Log.e("MainActivity", "The file " + modelName + " could not be found.");
		}
		
		modelName = "meshes/the_enterprezze.vmf";
		try {
			ResourceManager.loadMesh(modelName, this.context.getAssets().open(modelName));
		} catch (IOException e) {
			Log.e("MainActivity", "The file " + modelName + " could not be found.");
		}
		
		modelName = "meshes/AdorbsShip.vmf";
		try {
			ResourceManager.loadMesh(modelName, this.context.getAssets().open(modelName));
		} catch (IOException e) {
			Log.e("MainActivity", "The file " + modelName + " could not be found.");
		}
		
		GLES20ShaderFactory.diffuseSpecular();
		
		//Create a basic shader and activate it
		this.mActiveShader = GLES20ShaderFactory.getShader("diffuseSpecular");
		this.mActiveShader.use();
		
		//Enable GL states to perform a depth test and cull back facing polygons
		GLES20.glEnable(GLES20.GL_DEPTH_TEST);
		GLES20.glEnable(GLES20.GL_CULL_FACE);
		
		//Set the default color of the background each time a new frame is drawn
		GLES20.glClearColor(0.3f, 0.3f, 0.3f, 1.0f);
		
		//Calculate the value for a view matrix and store that value for this
		//shader on the graphics card
		float view[] = new float[16];		
		Matrix.setLookAtM(view, 0, -5f, 5f, 5f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
		this.mActiveShader.setUniform("view", view);
		
		//Store the value for the light position on the graphics card
		float lightPos[] = {1.0f, 1.0f, 1.0f, 0.0f};
		this.mActiveShader.setUniform("lightPosition", lightPos);
		
		this.mScene = Scene.getInstance();
	}
	
	@Override
	public void onSurfaceChanged(GL10 unused, int width, int height) {        
        //Calculate the value for a projection matrix and store the value for it on 
        //the graphics card
        float proj[] = new float[16];
        float aspect = 1.0f * width / height;        
        Matrix.perspectiveM(proj, 0, 45, aspect, 1.0f, 100.0f);
        this.mActiveShader.setUniform("proj", proj);
	}
	
	@Override
	public void onDrawFrame(GL10 unused) {
		//Reset the values of the color and depth bits in the default frame buffer to what
		//we specified them as (the default for the depth buffer bit is essentially the back of
		//your clipping plane specified in the projection matrix, so there's no need to set that
		//value explicitly in most situations)
		GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);
		
		this.mScene.updateScene();
		this.mScene.drawScene();
	}
}
