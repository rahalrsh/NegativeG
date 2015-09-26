package com.mygdx.gameworld;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.gameobjects.SpaceMan;

public class GameWorld {

    private SpaceMan spaceMan;
    private Vector2 PlanetGravity_acceleration;

    public GameWorld() {
    	// Set acceleration
    	PlanetGravity_acceleration = new Vector2(0, -50);
        spaceMan = new SpaceMan(0, 300, 50, 75);
        spaceMan.setAcceleration(PlanetGravity_acceleration);
    }
    
    public void update(float delta) {
    	spaceMan.update(delta);
    }

    public SpaceMan getSpaceMan() {
		return spaceMan;
	}

}