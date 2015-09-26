package com.mygdx.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
	// texture atlas for Player, Alien space ships, explosion, tap, GET READY, GAME OVER, gray surface
	public static TextureAtlas basicTextureAtlas;
	// texture atlas for Background space 
    public static TextureAtlas SpaceTextureAtlas;
     
    public static TextureRegion spacemanSwim1;
    public static TextureRegion spaceBackground;
    
    public static void load() {
    	
    	basicTextureAtlas = new TextureAtlas(Gdx.files.internal("BasicTextures.txt"),true);
    	SpaceTextureAtlas = new TextureAtlas(Gdx.files.internal("SpaceBackgroundTexture.txt"),true);
        
    	spacemanSwim1 = new TextureRegion();
    	spacemanSwim1 = basicTextureAtlas.findRegion("alienGreen_swim1");
    	
    	spaceBackground = new TextureRegion();
    	spaceBackground = SpaceTextureAtlas.findRegion("space");
    	
    	
         	
    }

    
    public static void dispose() {
    	basicTextureAtlas.dispose();
    	SpaceTextureAtlas.dispose();
    }
}
