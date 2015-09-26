package com.mygdx.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class SpaceMan {
	private Vector2 position;
	private Vector2 velocity;
	private Vector2 acceleration;

	private float rotation; // For handling space man's rotation
	private int width;
	private int height;
	
	private boolean isMovingUp = true;
	
	private Rectangle collisionRect;

	public SpaceMan(float x, float y, int width, int height) {
		this.width = width;
		this.height = height;
		position = new Vector2(x, y);
		// Adjust values for better physics
		velocity = new Vector2(0, 0);
		acceleration = new Vector2(0, 0);
		collisionRect = new Rectangle();
	}

	public void update(float delta) {

		// update velocity
		velocity.add(acceleration.cpy().scl(delta));

		if (velocity.y > 200) {
			velocity.y = 200;
		}
		
		if ( (position.y + height) >= 420){
			Gdx.app.log("Bound", "out");
			// position.y = 420 - height;
			velocity.y = -100;

		}
		else if(position.y <= 0){
			Gdx.app.log("Bound", "out");
			// position.y = 0;
			velocity.y = 100;
		}

		position.add(velocity.cpy().scl(delta));
		
		// Set collision rectangle position
		collisionRect.set(position.x, position.y, width, height);
		
	
		// Check which direction the spaceman is moving (Up or Down)
		if (velocity.y < 0)
			isMovingUp = true;
		else
			isMovingUp = false;

	}

	public void onClick() {
		velocity.y = 140;
	}

	public float getX() {
		return position.x;
	}

	public float getY() {
		return position.y;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public float getRotation() {
		return rotation;
	}

	public void setAcceleration(Vector2 acceleration) {
		this.acceleration = acceleration;
	}

	public boolean isMovingUp() {
		return isMovingUp;
	}
	
	public Rectangle getCollisionRect(){
		return collisionRect;
	}

}
