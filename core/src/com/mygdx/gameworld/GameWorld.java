package com.mygdx.gameworld;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.gameobjects.ScrollHandler;
import com.mygdx.gameobjects.SpaceMan;

public class GameWorld {

    private SpaceMan spaceMan;
    private Vector2 PlanetGravity_acceleration;
    private ScrollHandler scroller;

    public GameWorld(int midPointY) {
        // Set acceleration
        PlanetGravity_acceleration = new Vector2(0, -50);
        spaceMan = new SpaceMan(53, midPointY, 75, 125);
        spaceMan.setAcceleration(PlanetGravity_acceleration);
        
        scroller = new ScrollHandler(370);
    }
    
    public void update(float delta) {
    	spaceMan.update(delta);
    	scroller.update(delta);
    }

    public SpaceMan getSpaceMan() {
		return spaceMan;
	}
    
    public ScrollHandler getScroller(){
    	return scroller;
    }

}