package com.mygdx.helpers;

import com.badlogic.gdx.InputProcessor;
import com.mygdx.gameobjects.SpaceMan;
import com.mygdx.gameworld.GameWorld;

public class InputHandler implements InputProcessor{
	
	private SpaceMan mySpaceman;
	private GameWorld myWorld;
	
	// Ask for a reference to the SpaceMan when InputHandler is created.
    public InputHandler(GameWorld world) {
        // myBird now represents the gameWorld's bird.
    	mySpaceman = world.getSpaceMan();
    	myWorld = world;
    }
    
    @Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		//TODO:click to pause the game
    	//mySpaceman.onClick();
		return false;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		mySpaceman.onkeyDown(keycode);
		
		// If game is in get READY state, start the game by setting the game state to RUNNING
		if(myWorld.isReady())
			myWorld.startGame();
		if(myWorld.isGameOver() && keycode==62)
			myWorld.restart();
		
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
