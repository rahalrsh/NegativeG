package com.mygdx.negativeg.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.negativeg.NegativeG;

public class DesktopLauncher {
	 public static void main (String[] arg) {
	        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
	        config.title = "Negative-G";
	        config.width = 800;
	        config.height = 420;
	        new LwjglApplication(new NegativeG(), config);
	    }
}
