package com.mygdx.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.gameobjects.SpaceMan;
import com.mygdx.helpers.AssetLoader;


public class GameRenderer {

	private GameWorld myWorld;
    private OrthographicCamera cam;
    private SpaceMan spaceMan;

    private SpriteBatch batcher;

    public GameRenderer(GameWorld world) {
    	myWorld = world;

        cam = new OrthographicCamera();
        cam.setToOrtho(true, 800, 420);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);

        
        this.spaceMan = myWorld.getSpaceMan();
    }

    public void render(float runTime) {
        Gdx.app.log("GameRenderer", "render");

        // We will move these outside of the loop for performance later.
        // SpaceMan spaceMan = myWorld.getSpaceMan();

        // Fill the entire screen with black, to prevent potential flickering.
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        // Begin SpriteBatch
        batcher.begin();
        // Disable transparency
        // This is good for performance when drawing images that do not require
        // transparency.
        batcher.disableBlending();
        batcher.draw(AssetLoader.spaceBackground, 0, 0, 800, 420);

        // The bird needs transparency, so we enable that again.
        batcher.enableBlending();

        // Draw bird at its coordinates. Retrieve the Animation object from
        // AssetLoader
        // Pass in the runTime variable to get the current frame.
        batcher.draw(AssetLoader.spacemanSwim1,
                spaceMan.getX(), spaceMan.getY(), spaceMan.getWidth(), spaceMan.getHeight());

        // End SpriteBatch
        batcher.end();
    }
}

