package com.mygdx.gameworld;

import com.mygdx.gameobjects.SpaceMan;

public class GameWorld {

    private SpaceMan spaceMan;

    public GameWorld() {
        spaceMan = new SpaceMan(0, 0, 50, 75);
    }
    
    public void update(float delta) {
    	spaceMan.update(delta);
    }

    public SpaceMan getSpaceMan() {
		return spaceMan;
	}

}