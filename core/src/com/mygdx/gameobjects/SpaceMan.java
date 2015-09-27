package com.mygdx.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class SpaceMan {
	private Vector2 position;
	private Vector2 velocity;
	private Vector2 acceleration;

	private float rotation; // For handling space man's rotation
	private int width;
	private int height;
	
	private float x,y;
	
	private boolean isMovingUp = true;
	private boolean isJetPackOn = false;
	
	private Rectangle collisionRect;

	public SpaceMan(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
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
		
		// y out of bound logic 
		if ( (position.y + height) >= 420){
			Gdx.app.log("y Bound", "out");
			// position.y = 420 - height;
			velocity.y = -100;

		}
		else if(position.y <= 0){
			Gdx.app.log("y Bound", "out");
			// position.y = 0;
			velocity.y = 100;
		}
		
		// x out of bound logic 
		if ( (position.x + width) >= 800){
			Gdx.app.log("x Bound", "out");
			// position.y = 420 - height;
			velocity.x = -100;

		}
		else if(position.x <= 0){
			Gdx.app.log("x Bound", "out");
			// position.y = 0;
			velocity.x = 100;
		}
		
		

		position.add(velocity.cpy().scl(delta));
		
		// Set collision rectangle position
		collisionRect.set(position.x+15, position.y+5, width-40, height-10);
		
	
		// Check which direction the spaceman is moving (Up or Down)
		if (velocity.y < 0){
			isMovingUp = true;
			isJetPackOn = false;
		}
		else{
			isMovingUp = false;
		}
		
		
		// isJetPackOn = false;

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

	public void onkeyDown(int keycode) {
		
		if (keycode == 19){ // 19 is the UP command for libGDx
			//velocity.y = -90;
		}
		if (keycode == 20){ // 20 is the DOWN command for libGDx
			velocity.y = 200;
			isJetPackOn = true;
			
			// set isJetPackOn=false in few seconds (off the jet pack)
			// this will stop the jet pack flame animation from rendering after few seconds
			// turnOff(0.5f);
		}
		if (keycode == 21){ // 21 is the LEFT command for libGDx
			velocity.x = -90;
		}
		if (keycode == 22){ // 22 is the RIGHT command for libGDx
			velocity.x = 90;
		}
		// TODO Auto-generated method stub
		
	}
	
	public void onkeyUp(int keycode) {
		if (keycode == 20){ // 20 is the DOWN command for libGDx
			isJetPackOn = false;
		}
		
	}

	public void restart() {
		isMovingUp = true;
		isJetPackOn = false;
		position.set(x, y);
		
	}

	public boolean isJetPackOn() {
		return isJetPackOn;
	}
	
	// Turn off the jet pack 
	// delay is in seconds
	public void turnOff(float delay){

		Timer.schedule(new Task(){
		    @Override
		    public void run() {
		    	isJetPackOn = false;
		    }
		}, delay);
	}

}
