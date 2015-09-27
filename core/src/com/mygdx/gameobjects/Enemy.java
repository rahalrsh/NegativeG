package com.mygdx.gameobjects;

import java.util.Random;

import com.badlogic.gdx.math.Intersector;
import com.mygdx.gameworld.GameWorld;

public class Enemy extends Scrollable {

	private Random r;
	private boolean isScored = false;
	GameWorld gameWorld;

	// When Pipe's constructor is invoked, invoke the super (Scrollable)
	// constructor
	public Enemy(float x, float y, int width, int height, float scrollSpeed, GameWorld gameWorld) {
		super(x, y, width, height, scrollSpeed);
		// Initialize a Random object for Random number generation
		r = new Random();
		this.gameWorld = gameWorld;
	}

	@Override
	public void reset(float newX) {
		// Call the reset method in the superclass (Scrollable)
		super.reset(newX);
		// Change the height to a random number
		position.y = r.nextInt(250) + 15;
		isScored = false;
	}
	
	@Override
	public void update(float delta) {
		super.update(delta);
		EnemyAI();
	}
	
	public void EnemyAI(){
		// First try to catch the player
		if (position.x > gameWorld.getSpaceMan().getX()){
			if ( (position.y - height/2) > (gameWorld.getSpaceMan().getY() - gameWorld.getSpaceMan().getHeight()/2)){
				velocity.y = -20;
			}
			else{
				velocity.y = 20;
			}
		}
		else{
			velocity.y = 20;
		}
	}

	// check if enemies collide with spaceman
	public boolean collides(SpaceMan spaceman) {
		return (Intersector.overlaps(spaceman.getCollisionRect(), collisionRect) 
				|| Intersector.overlaps(spaceman.getCollisionRect(), collisionRect2));

	}

	public boolean isScored() {
		return isScored;
	}

	public void setScored(boolean b) {
		isScored = b;
	}

	/**
	 * // Returns true if two rectangles (l1, r1) and (l2, r2) overlap boolean
	 * doOverlap(Point l1, Point r1, Point l2, Point r2) { // If one rectangle
	 * is on left side of other if (l1.x > r2.x || l2.x > r1.x) return false; //
	 * If one rectangle is above other if (l1.y < r2.y || l2.y < r1.y) return
	 * false; return true; }
	 **/


}
