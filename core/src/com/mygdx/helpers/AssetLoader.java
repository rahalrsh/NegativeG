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
    public static TextureRegion jetPack;
    public static TextureRegion ground;
    public static TextureRegion yellowAlien;
    public static TextureRegion greenAlien;
    public static TextureRegion beigeAlien;
    
    public static void load() {
    	
    	basicTextureAtlas = new TextureAtlas(Gdx.files.internal("BasicTextures.txt"),true);
    	SpaceTextureAtlas = new TextureAtlas(Gdx.files.internal("SpaceBackgroundTexture.txt"),true);
        
    	spacemanSwim1 = new TextureRegion();
    	spacemanSwim1 = basicTextureAtlas.findRegion("alienGreen_swim1");
    	
    	spaceBackground = new TextureRegion();
    	spaceBackground = SpaceTextureAtlas.findRegion("space");
    	
    	jetPack = new TextureRegion();
    	jetPack = basicTextureAtlas.findRegion("jetpack");
    	jetPack.flip(true, true);
    	
    	ground = new TextureRegion();
    	ground = basicTextureAtlas.findRegion("groundRock");
    	
    	yellowAlien = new TextureRegion();
    	yellowAlien = basicTextureAtlas.findRegion("shipYellow_manned");
    	
    	greenAlien = new TextureRegion();
    	greenAlien = basicTextureAtlas.findRegion("shipGreen_manned");
    	
    	beigeAlien = new TextureRegion();
    	beigeAlien = basicTextureAtlas.findRegion("shipBeige_manned");
    	
    	
         	
    }

    
    public static void dispose() {
    	basicTextureAtlas.dispose();
    	SpaceTextureAtlas.dispose();
    }
}
