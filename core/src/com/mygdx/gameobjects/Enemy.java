package com.mygdx.gameobjects;

import java.util.Random;

public class Enemy extends Scrollable {

	private Random r;

	// When Pipe's constructor is invoked, invoke the super (Scrollable)
	// constructor
	public Enemy(float x, float y, int width, int height, float scrollSpeed) {
		super(x, y, width, height, scrollSpeed);
		// Initialize a Random object for Random number generation
		r = new Random();
	}

	@Override
	public void reset(float newX) {
		// Call the reset method in the superclass (Scrollable)
		super.reset(newX);
		// Change the height to a random number
		position.y = r.nextInt(250) + 15;
	}

}
