package com.mygdx.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.mygdx.gameobjects.Enemy;
import com.mygdx.gameobjects.Ground;
import com.mygdx.gameobjects.ScrollHandler;
import com.mygdx.gameobjects.SpaceMan;
import com.mygdx.helpers.AssetLoader;

public class GameRenderer {

	private GameWorld myWorld;
	private OrthographicCamera cam;
	private SpaceMan spaceMan;
	private ScrollHandler scroller;
	private Ground frontGround, backGround;
	private Enemy enemy1, enemy2, enemy3;
	private ShapeRenderer shapeRenderer;
	private boolean drawCollitionShapes = false;

	private SpriteBatch batcher;

	public GameRenderer(GameWorld world) {
		myWorld = world;

		cam = new OrthographicCamera();
		cam.setToOrtho(true, 800, 420);

		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(cam.combined);

		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);

		this.spaceMan = myWorld.getSpaceMan();
		scroller = myWorld.getScroller();
		frontGround = scroller.getFrontGround();
		backGround = scroller.getBackGround();

		enemy1 = scroller.getEnemy1();
		enemy2 = scroller.getEnemy2();
		enemy3 = scroller.getEnemy3();

	}

	private void drawGround() {
		// Draw the ground
		batcher.draw(AssetLoader.ground, frontGround.getX(),
				frontGround.getY(), frontGround.getWidth() + 1,
				frontGround.getHeight());
		batcher.draw(AssetLoader.ground, backGround.getX(), backGround.getY(),
				backGround.getWidth(), backGround.getHeight());
	}

	private void drawEnemies() {
		batcher.draw(AssetLoader.yellowAlien, enemy1.getX(), enemy1.getY(),
				enemy1.getWidth(), enemy1.getHeight());
		batcher.draw(AssetLoader.greenAlien, enemy2.getX(), enemy2.getY(),
				enemy2.getWidth(), enemy2.getHeight());
		batcher.draw(AssetLoader.beigeAlien, enemy3.getX(), enemy3.getY(),
				enemy3.getWidth(), enemy3.getHeight());
	}

	public void render(float runTime) {

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

		// Needs transparency, so we enable that again.
		batcher.enableBlending();

		// Draw the ground/planet surface
		drawGround();

		// Set the jet pack of the space man relative to his position
		batcher.draw(AssetLoader.jetPack, spaceMan.getX() - 15,
				spaceMan.getY() + 10, spaceMan.getWidth() / 2,
				spaceMan.getHeight() / 2, spaceMan.getWidth(),
				spaceMan.getHeight(), 0.7f, 0.7f, 160.0f);

		// Pass in the runTime variable to get the current frame.
		if (spaceMan.isMovingUp())
			batcher.draw(AssetLoader.alienGreen_jump, spaceMan.getX(),
					spaceMan.getY(), spaceMan.getWidth(), spaceMan.getHeight());
		else
			batcher.draw(AssetLoader.spacemanDown.getKeyFrame(runTime),
					spaceMan.getX(), spaceMan.getY(), spaceMan.getWidth(),
					spaceMan.getHeight());

		
		// draw Enemies
		drawEnemies();

		// draw GET READY
		if (myWorld.isReady())
			drawGetReady();
		
		// End SpriteBatch
		batcher.end();

		// Draw collision shapes
		if (drawCollitionShapes) {
			shapeRenderer.begin(ShapeType.Filled);
			shapeRenderer.setColor(Color.RED);
			shapeRenderer.rect(spaceMan.getCollisionRect().x,spaceMan.getCollisionRect().y, spaceMan.getWidth(),spaceMan.getHeight());
			shapeRenderer.rect(enemy1.getCollisionRect().x,enemy1.getCollisionRect().y, enemy1.getWidth(),enemy1.getHeight());
			shapeRenderer.rect(enemy2.getCollisionRect().x,enemy2.getCollisionRect().y, enemy2.getWidth(),enemy2.getHeight());
			shapeRenderer.rect(enemy3.getCollisionRect().x,enemy3.getCollisionRect().y, enemy3.getWidth(),enemy3.getHeight());
			shapeRenderer.end();
		}

	}

	private void drawGetReady() {
		batcher.draw(AssetLoader.getReady, 200,200, 400, 60);
		//batcher.draw(AssetLoader.tapTick, 350,200, 80, 80);
	}

}
