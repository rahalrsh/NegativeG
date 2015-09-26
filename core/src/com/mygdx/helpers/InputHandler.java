package com.mygdx.helpers;

import com.badlogic.gdx.InputProcessor;
import com.mygdx.gameobjects.SpaceMan;

public class InputHandler implements InputProcessor{
	
	private SpaceMan mySpaceman;
	
	// Ask for a reference to the SpaceMan when InputHandler is created.
    public InputHandler(SpaceMan spaceman) {
        // myBird now represents the gameWorld's bird.
    	mySpaceman = spaceman;
    }
    
    @Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		//TODO:click to pause the game
    	mySpaceman.onClick();
		return false;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
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
