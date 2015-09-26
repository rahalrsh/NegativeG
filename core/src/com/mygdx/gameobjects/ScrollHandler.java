package com.mygdx.gameobjects;

import com.mygdx.helpers.AssetLoader;
import com.mygdx.gameworld.GameWorld;

public class ScrollHandler {

	private Ground frontGround, backGround;
	private Enemy enemy1, enemy2, enemy3;

	public static final int SCROLL_SPEED = -59;
	public static final int ENEMY_GAP = 200;
	
	 private GameWorld gameWorld;

	public ScrollHandler(GameWorld gameWorld,float yPos) {
		this.gameWorld = gameWorld;
		
		frontGround = new Ground(0, yPos, 800, 50, SCROLL_SPEED);
		backGround = new Ground(frontGround.getTailX(), yPos, 800, 50,
				SCROLL_SPEED);

		enemy1 = new Enemy(210, 50, 120, 120, SCROLL_SPEED);
		enemy2 = new Enemy(enemy1.getTailX() + ENEMY_GAP, 0, 120, 120,
				SCROLL_SPEED);
		enemy3 = new Enemy(enemy2.getTailX() + ENEMY_GAP, 0, 120, 120,
				SCROLL_SPEED);

	}

	public void update(float delta) {
		// Update our objects
		frontGround.update(delta);
		backGround.update(delta);

		// Check if Ground has scrolled left,
		if (frontGround.isScrolledLeft()) {
			frontGround.reset(backGround.getTailX());

		} else if (backGround.isScrolledLeft()) {
			backGround.reset(frontGround.getTailX());
		}

		enemy1.update(delta);
		enemy2.update(delta);
		enemy3.update(delta);

		// Check if any of the enemies have scrolled left,
		// and reset accordingly
		if (enemy1.isScrolledLeft()) {
			enemy1.reset(enemy3.getTailX() + ENEMY_GAP);
		} else if (enemy2.isScrolledLeft()) {
			enemy2.reset(enemy1.getTailX() + ENEMY_GAP);
		} else if (enemy3.isScrolledLeft()) {
			enemy3.reset(enemy2.getTailX() + ENEMY_GAP);
		}
	}

	// check if enemies collide with spaceMan
	public boolean collideWith(SpaceMan spaceMan) {

		// scoring logic
		if (!enemy1.isScored()
				&& enemy1.getX() + (enemy1.getWidth() / 2) < spaceMan.getX()
						+ spaceMan.getWidth()) {
			addScore(1);
			enemy1.setScored(true);
			AssetLoader.coin.play(0.3f);
		} else if (!enemy2.isScored()
				&& enemy2.getX() + (enemy2.getWidth() / 2) < spaceMan.getX()
						+ spaceMan.getWidth()) {
			addScore(1);
			enemy2.setScored(true);
			AssetLoader.coin.play(0.3f);

		} else if (!enemy3.isScored()
				&& enemy3.getX() + (enemy3.getWidth() / 2) < spaceMan.getX()
						+ spaceMan.getWidth()) {
			addScore(1);
			enemy3.setScored(true);
			AssetLoader.coin.play(0.3f);

		}

		return (enemy1.collides(spaceMan) || enemy2.collides(spaceMan) || enemy3
				.collides(spaceMan));
	}

	private void addScore(int increment) {
        gameWorld.addScore(increment);
    }

	public Ground getFrontGround() {
		return frontGround;
	}

	public Ground getBackGround() {
		return backGround;
	}

	public Enemy getEnemy1() {
		return enemy1;
	}

	public Enemy getEnemy2() {
		return enemy2;
	}

	public Enemy getEnemy3() {
		return enemy3;
	}

}
