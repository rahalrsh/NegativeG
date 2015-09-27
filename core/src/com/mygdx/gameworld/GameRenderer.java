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
	
	String story = 
  		  "For the first time humans have discoverd a planet with negative gravity.\n"
  		+ "           Use your special jet pack to survive in this planet.\n\n\n\n"
  		+ "                     press acrrow keys to continue.";
	
	String gameOverText = "Press SPACE to continue\n\n";
	
    String creditsText = "Credits: Rahal R     Nisal P                 "
			+ "Art: kenney.nl        "
			+ "Music: soundimage.org";

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
		batcher.draw(AssetLoader.beigeAlien, enemy1.getX(), enemy1.getY(),
				enemy1.getWidth(), enemy1.getHeight());
		batcher.draw(AssetLoader.pinkAlien, enemy2.getX(), enemy2.getY(),
				enemy2.getWidth(), enemy2.getHeight());
		batcher.draw(AssetLoader.yellowAlien, enemy3.getX(), enemy3.getY(),
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
		
		// Draw the fire coming out from the jet pack
		if (spaceMan.isJetPackOn()){
			batcher.draw(AssetLoader.flame, spaceMan.getX() - 15,
					spaceMan.getY()-20, spaceMan.getWidth()/3,
					spaceMan.getHeight()/3, spaceMan.getWidth()/2,
					spaceMan.getHeight(), 0.65f, 0.55f, 160.0f);
			batcher.draw(AssetLoader.flame, spaceMan.getX() - 40,
					spaceMan.getY()-15, spaceMan.getWidth()/3,
					spaceMan.getHeight()/3, spaceMan.getWidth()/2,
					spaceMan.getHeight(), 0.65f, 0.55f, 160.0f);
			}

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
		
		// draw player score
		// show score at upper left corner of the screen for all the states except for GAMEOVER state
		// for game over state we want to show it at the middle (as the player score)
		if (!myWorld.isGameOver())
			drawScore(136, 15);
	
		// set font size
		AssetLoader.font.getData().setScale(0.60f, -0.60f);
		
		// draw GET READY
		if (myWorld.isReady()){
			drawGetReady();
			displayText(story, 250, 250);
		}
		
		// draw GAME OVER
		if (myWorld.isGameOver()){
			drawGameOver();
			displayText(gameOverText, 300, 300);
			displayText(creditsText, 100, 400);
		}
		
		// End SpriteBatch
		batcher.end();

		// Draw collision shapes
		if (drawCollitionShapes) {
			shapeRenderer.begin(ShapeType.Filled);
			shapeRenderer.setColor(Color.RED);
			shapeRenderer.rect(spaceMan.getCollisionRect().x,spaceMan.getCollisionRect().y, spaceMan.getCollisionRect().getWidth(),spaceMan.getCollisionRect().getHeight());
			shapeRenderer.rect(enemy1.getCollisionRect().x,enemy1.getCollisionRect().y, enemy1.getCollisionRect().getWidth(),enemy1.getCollisionRect().getHeight());
			shapeRenderer.rect(enemy2.getCollisionRect().x,enemy2.getCollisionRect().y, enemy2.getCollisionRect().getWidth(),enemy2.getCollisionRect().getHeight());
			shapeRenderer.rect(enemy3.getCollisionRect().x,enemy3.getCollisionRect().y, enemy3.getCollisionRect().getWidth(),enemy3.getCollisionRect().getHeight());
			
			shapeRenderer.rect(enemy1.getCollisionRect2().x,enemy1.getCollisionRect2().y, enemy1.getCollisionRect2().getWidth(),enemy1.getCollisionRect2().getHeight());
			shapeRenderer.rect(enemy2.getCollisionRect2().x,enemy2.getCollisionRect2().y, enemy1.getCollisionRect2().getWidth(),enemy1.getCollisionRect2().getHeight());
			shapeRenderer.rect(enemy3.getCollisionRect2().x,enemy3.getCollisionRect2().y, enemy1.getCollisionRect2().getWidth(),enemy1.getCollisionRect2().getHeight());
			
			shapeRenderer.end();
		}
		
	

	}

	private void drawGetReady() {
		batcher.draw(AssetLoader.getReady, 200,100, 400, 60);
		//batcher.draw(AssetLoader.tapTick, 350,200, 80, 80);
	}
	
	private void drawGameOver() {
		batcher.draw(AssetLoader.gameOver, 200,100, 400, 60);
		AssetLoader.font.getData().setScale(1.00f, -1.00f);
		drawScore(800, 200);
	}
	
	private void drawScore(int x, int y) {
		// Convert integer into String
        String score = myWorld.getScore() + "";

        // Draw score text
        AssetLoader.font.draw(batcher, "" + myWorld.getScore(), (x / 2) - (30* score.length() - 1), y);
	}
	
	private void displayText(String text, int x, int y) {
		AssetLoader.font.getData().setScale(0.25f, -0.25f);
        AssetLoader.font.draw(batcher, text, x - (text.length() - 1), y);
        AssetLoader.font.getData().setScale(0.60f, -0.60f);
	}

}
