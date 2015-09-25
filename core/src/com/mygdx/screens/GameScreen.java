package com.mygdx.screens;

import com.badlogic.gdx.Screen;
import com.mygdx.gameworld.GameRenderer;
import com.mygdx.gameworld.GameWorld;

public class GameScreen implements Screen {
	private GameWorld world;
	private GameRenderer renderer;
    private float runTime;
	
	// This is the constructor, not the class declaration
	public GameScreen() {
		System.out.println("GameScreen Attached");
		
		 // float screenWidth = Gdx.graphics.getWidth();
	     // float screenHeight = Gdx.graphics.getHeight();
	     
	     world = new GameWorld();
	     renderer = new GameRenderer(world);
		
	}

	@Override
	public void render(float delta) {
        runTime += delta;
        world.update(delta);
        renderer.render(runTime);
	}

	@Override
	public void resize(int width, int height) {
		System.out.println("GameScreen - resizing");
	}

	@Override
	public void show() {
		System.out.println("GameScreen - show called");
	}

	@Override
	public void hide() {
		System.out.println("GameScreen - hide called");		
	}

	@Override
	public void pause() {
		System.out.println("GameScreen - pause called");		
	}

	@Override
	public void resume() {
		System.out.println("GameScreen - resume called");		
	}

	@Override
	public void dispose() {
		// Leave blank
	}


}
