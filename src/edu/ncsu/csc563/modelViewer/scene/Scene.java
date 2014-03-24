package edu.ncsu.csc563.modelViewer.scene;

import edu.ncsu.csc563.modelViewer.actors.Actor;
import edu.ncsu.csc563.modelViewer.actors.ActorFactory;

public class Scene {
	public static Scene instance;
	private Actor actor;
	private static boolean paused = false;
	
	private Actor cube;
	private Actor large_spike_ball;
	private Actor large_sqr_pyr;
	private Actor large_tri_pyr;
	private Actor lg_ell;
	private Actor lg_hplus;
	private Actor lg_plus;
	private Actor lg_step;
	private Actor long_hex_prism;
	private Actor long_rect_prism;
	private Actor rnd_cube_panel;
	private Actor rnd_hex_panel;
	private Actor rnd_tri_panel;
	private Actor token;
	private Actor turd;
	private Actor the_enterprezze;
	private Actor adorbs;
	
	private Scene() {
		this.cube = ActorFactory.cube();
		this.large_spike_ball = ActorFactory.large_spike_ball();
		this.large_sqr_pyr = ActorFactory.large_sqr_pyr();
		this.large_tri_pyr = ActorFactory.large_tri_pyr();
		this.lg_ell = ActorFactory.lg_ell();
		this.lg_hplus = ActorFactory.lg_hplus();
		this.lg_plus = ActorFactory.lg_plus();
		this.lg_step = ActorFactory.lg_step();
		this.long_hex_prism = ActorFactory.long_hex_prism();
		this.long_rect_prism = ActorFactory.long_rect_prism();
		this.rnd_cube_panel = ActorFactory.rnd_cube_panel();
		this.rnd_hex_panel = ActorFactory.rnd_hex_panel();
		this.rnd_tri_panel = ActorFactory.rnd_tri_panel();
		this.token = ActorFactory.token();
		this.turd = ActorFactory.turd();
		this.the_enterprezze = ActorFactory.the_enterprezze();
		this.adorbs = ActorFactory.adorbs();
		
		this.actor = this.cube;
	}
	
	public static Scene getInstance() {
		if (instance == null) {
			instance = new Scene();
		}
		return instance;
	}
	
	public void updateScene() {
		if (!paused) this.actor.update();
	}
	
	public void drawScene() {
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
			this.actor = this.large_spike_ball;
		} else if (this.actor == this.large_spike_ball) {
			this.actor = this.large_sqr_pyr;
		} else if (this.actor == this.large_sqr_pyr) {
			this.actor = this.large_tri_pyr;
		} else if (this.actor == this.large_tri_pyr) {
			this.actor = this.lg_ell;
		} else if (this.actor == this.lg_ell) {
			this.actor = this.lg_hplus;
		} else if (this.actor == this.lg_hplus) {
			this.actor = this.lg_plus;
		} else if (this.actor == this.lg_plus) {
			this.actor = this.lg_step;
		} else if (this.actor == this.lg_step) {
			this.actor = this.long_hex_prism;
		} else if (this.actor == this.long_hex_prism) {
			this.actor = this.long_rect_prism;
		} else if (this.actor == this.long_rect_prism) {
			this.actor = this.rnd_cube_panel;
		} else if (this.actor == this.rnd_cube_panel) {
			this.actor = this.rnd_hex_panel;
		} else if (this.actor == this.rnd_hex_panel) {
			this.actor = this.rnd_tri_panel;
		} else if (this.actor == this.rnd_tri_panel) {
			this.actor = this.token;
		} else if (this.actor == this.token) {
			this.actor = this.turd;
		} else if (this.actor == this.turd) {
			this.actor = this.the_enterprezze;
		} else if (this.actor == this.the_enterprezze) {
			this.actor = this.adorbs;
		} else {
			this.actor = this.cube;
		}
	}
}

