package edu.ncsu.csc563.modelViewer.scene;

import edu.ncsu.csc563.modelViewer.actors.Actor;
import edu.ncsu.csc563.modelViewer.actors.ActorFactory;

public class Scene {
	//private ArrayList<Actor> mActors;
	public static Scene instance;
	private Actor actor;
	private static boolean paused = false;
	
	private Actor cube;
	private Actor dragon;
	
	private Scene() {
		//this.mActors = new ArrayList<Actor>();
		//this.mActors.add(ActorFactory.cube());
		this.cube = ActorFactory.cube();
		this.dragon = ActorFactory.dragon();
		
		this.actor = this.cube;
	}
	
	public static Scene getInstance() {
		if (instance == null) {
			instance = new Scene();
		}
		return instance;
	}
	
	public void updateScene() {
		//for (Actor actor : this.mActors) {
		//	actor.update();
		//}
		if (!paused) this.actor.update();
	}
	
	public void drawScene() {
		//for (Actor actor : this.mActors) {
		//	actor.draw();
		//}
		this.actor.draw();
	}
	
	public static boolean isPaused() {
		return paused;
	}
	
	public static void pause() {
		paused = true;
	}
	
	public static void unPause() {
		paused = false;
	}
	
	public void switchActor() {
		if (this.actor == this.cube) {
			this.actor = this.dragon;
		} else {
			this.actor = this.cube;
		}
	}
}

