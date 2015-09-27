package com.mygdx.gameworld;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.gameobjects.ScrollHandler;
import com.mygdx.gameobjects.SpaceMan;

public class GameWorld {

	private SpaceMan spaceMan;
	private Vector2 PlanetGravity_acceleration;
	private ScrollHandler scroller;

	private GameState currentGameState;

	private int score = 0;

	public GameWorld(int midPointY) {

		// Set current game state to player READY
		currentGameState = GameState.READY;

		// Set acceleration
		PlanetGravity_acceleration = new Vector2(0, -250);
		spaceMan = new SpaceMan(53, midPointY, 75, 100);
		spaceMan.setAcceleration(PlanetGravity_acceleration);

		scroller = new ScrollHandler(this, 370);
	}

	public enum GameState {
		READY, RUNNING, GAMEOVER
	}

	public void update(float delta) {

		switch (currentGameState) {

		case READY:
			updateReady(delta);
			break;

		case RUNNING:
			updateRunning(delta);
			break;
			
		case GAMEOVER:
			updateGameOver(delta);
			break;	
			
		default:
			break;

		}

	}


	// Update methods for RUNNING state
	public void updateRunning(float delta) {
		spaceMan.update(delta);
		scroller.update(delta);

		// Check if objects in scroller collides with spaceman
		if (scroller.collideWith(spaceMan)) {
			currentGameState = GameState.GAMEOVER;
		}
	}
	
	// Update method for READY state
	public void updateReady(float delta) {

	}
	
	// Update method for READY state
	public void updateGameOver(float delta) {

	}

	public SpaceMan getSpaceMan() {
		return spaceMan;
	}

	public ScrollHandler getScroller() {
		return scroller;
	}

	// Game state helper functions
	// Return true if current game state is ready
	public boolean isReady() {
		return currentGameState == GameState.READY;
	}

	public void startGame() {
		currentGameState = GameState.RUNNING;
	}
	
	public boolean isGameOver(){
		return currentGameState == GameState.GAMEOVER;
	}
	
	public void restart(){
		score = 0;
		spaceMan.restart();
		scroller.restart();
		currentGameState = GameState.READY;
	}

	//  Display Score helper functions 
	public int getScore() {
		return score;
	}

	public void addScore(int increment) {
		score += increment;
	}

}