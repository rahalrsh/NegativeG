package com.mygdx.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
	// texture atlas for Player, Alien space ships, explosion, tap, GET READY, GAME OVER, gray surface
	public static TextureAtlas basicTextureAtlas;
	// texture atlas for Background space 
    public static TextureAtlas SpaceTextureAtlas;
     
    public static TextureRegion spaceBackground;
    public static TextureRegion jetPack;
    public static TextureRegion ground;
    public static TextureRegion yellowAlien;
    public static TextureRegion blueAlien;
    public static TextureRegion beigeAlien;
    public static TextureRegion pinkAlien;
    public static TextureRegion getReady;
    public static TextureRegion gameOver;
    public static TextureRegion flame;
    
    // for animations
    public static TextureRegion alienGreen_swim1;
    public static TextureRegion alienGreen_swim2;
    public static TextureRegion alienGreen_hit;
    public static TextureRegion alienGreen_jump;
    
    public static Sound  coin;
    public static Music themeMusic;
    
    public static Animation spacemanUp;
    public static Animation spacemanDown;
    
    public static BitmapFont font;
    
    public static void load() {
    	
    	basicTextureAtlas = new TextureAtlas(Gdx.files.internal("BasicTextures.txt"),true);
    	SpaceTextureAtlas = new TextureAtlas(Gdx.files.internal("SpaceBackgroundTexture.txt"),true);

    	
    	// Animations Assets loading start
    	alienGreen_swim1 = new TextureRegion();
    	alienGreen_swim1 = basicTextureAtlas.findRegion("alienGreen_swim1");
    	alienGreen_swim2 = new TextureRegion();
    	alienGreen_swim2 = basicTextureAtlas.findRegion("alienGreen_swim2");
    	alienGreen_hit = new TextureRegion();
    	alienGreen_hit = basicTextureAtlas.findRegion("alienGreen_hit");
    	alienGreen_jump = new TextureRegion();
    	alienGreen_jump = basicTextureAtlas.findRegion("alienGreen_jump");
    	
    	TextureRegion[] spacemanDownArray = {alienGreen_hit, alienGreen_jump};
    	spacemanUp = new Animation(0.2f, spacemanDownArray);
    	spacemanUp.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
    	
    	TextureRegion[] spacemanUpArray = {alienGreen_swim1, alienGreen_swim2};
    	spacemanDown = new Animation(0.2f, spacemanUpArray);
    	spacemanDown.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
    	
    	// Animations Assets loading end
    	
    	
    	spaceBackground = new TextureRegion();
    	spaceBackground = SpaceTextureAtlas.findRegion("space");
    	
    	jetPack = new TextureRegion();
    	jetPack = basicTextureAtlas.findRegion("jetpack");
    	jetPack.flip(true, true);
    	
    	ground = new TextureRegion();
    	ground = basicTextureAtlas.findRegion("groundRock");
    	
    	yellowAlien = new TextureRegion();
    	yellowAlien = basicTextureAtlas.findRegion("shipYellow_manned");
    	
    	blueAlien = new TextureRegion();
    	blueAlien = basicTextureAtlas.findRegion("shipBlue_manned");
    	
    	beigeAlien = new TextureRegion();
    	beigeAlien = basicTextureAtlas.findRegion("shipBeige_manned");
    	
    	pinkAlien = new TextureRegion();
    	pinkAlien = basicTextureAtlas.findRegion("shipPink_manned");
    	
    	getReady = new TextureRegion();
    	getReady = basicTextureAtlas.findRegion("textGetReady");
    	
    	gameOver = new TextureRegion();
    	gameOver = basicTextureAtlas.findRegion("textGameOver");
    	
    	flame = new TextureRegion();
    	flame = basicTextureAtlas.findRegion("flame");

    	coin = Gdx.audio.newSound(Gdx.files.internal("coin.wav"));
 
    	themeMusic = Gdx.audio.newMusic(Gdx.files.internal("Electric_Rain.mp3"));// credit http://soundimage.org/
    	font = new BitmapFont(Gdx.files.internal("text.fnt"));
        font.getData().setScale(.60f, -.60f);
         	
    }

    
    public static void dispose() {
    	basicTextureAtlas.dispose();
    	SpaceTextureAtlas.dispose();
    	
    	font.dispose();
    }
}
