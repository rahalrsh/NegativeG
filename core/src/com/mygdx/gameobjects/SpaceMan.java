package com.mygdx.gameobjects;

import com.badlogic.gdx.math.Vector2;

public class SpaceMan {
	private Vector2 position;
	private Vector2 velocity;
	private Vector2 acceleration;

	private float rotation; // For handling space man's rotation
	private int width;
	private int height;
	
	public SpaceMan(float x, float y, int width, int height) {
        this.width = width;
        this.height = height;
        position = new Vector2(x, y);
        // Adjust values for better physics
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, 0);
    }
	
	public void update(float delta) {
		
		// update velocity
		velocity.add(acceleration.cpy().scl(delta));

        if (velocity.y > 200) {
            velocity.y = 200;
        }

        // update position
        position.add(velocity.cpy().scl(delta));

    }

    public void onClick() {

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
    
	

}
