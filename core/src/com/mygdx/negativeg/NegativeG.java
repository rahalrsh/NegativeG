package com.mygdx.negativeg;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.mygdx.helpers.AssetLoader;
import com.mygdx.screens.GameScreen;


public class NegativeG extends Game {
	@Override
    public void create() {
        Gdx.app.log("ZBGame", "created");
        AssetLoader.load();
        setScreen(new GameScreen());
    }
	
	@Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }
}

