package com.mygdx.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.gameobjects.ScrollHandler;
import com.mygdx.gameobjects.SpaceMan;

public class GameWorld {

    private SpaceMan spaceMan;
    private Vector2 PlanetGravity_acceleration;
    private ScrollHandler scroller;
    private GameState currentGameState; 

    public GameWorld(int midPointY) {
    	// Set current game state to player READY
    	currentGameState = GameState.READY;
    	
        // Set acceleration
        PlanetGravity_acceleration = new Vector2(0, -50);
        spaceMan = new SpaceMan(53, midPointY, 75, 100);
        spaceMan.setAcceleration(PlanetGravity_acceleration);
        
        scroller = new ScrollHandler(370);
    }
    
    public enum GameState {
        READY, RUNNING, GAMEOVER
    }
   
    public void update(float delta) {
    	
    	switch(currentGameState){
    	
    	case READY:
    		updateReady(delta);
    		break;
    		
    	case RUNNING:
    		updateRunning(delta);
    		break;
    	
    	}
    	
    }
    
    // Update method for READY state
    public void updateReady(float delta) {
    	
    }
    
    // Update methods for RUNNING state
    public void updateRunning(float delta) {
    	spaceMan.update(delta);
    	scroller.update(delta);
    	
    	// Check if objects in scroller collides with spaceman 
    	if(scroller.collideWith(spaceMan)){
    		Gdx.app.log("Collides", "Boom!!");
    	}
    }

    
    public SpaceMan getSpaceMan() {
		return spaceMan;
	}
    
    public ScrollHandler getScroller(){
    	return scroller;
    }
    
    // Game state helper functions
    // Return true if current game state is ready
    public boolean isReady() {
        return currentGameState == GameState.READY;
    }
    
    public void startGame(){
    	currentGameState = GameState.RUNNING;
    }
    
    

}