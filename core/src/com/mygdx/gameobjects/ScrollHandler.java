package com.mygdx.gameobjects;

public class ScrollHandler {
	private Ground frontGround, backGround;
    public static final int SCROLL_SPEED = -59;
    public static final int PIPE_GAP = 49;

    public ScrollHandler(float yPos) {
    	frontGround = new Ground(0, yPos, 800, 50, SCROLL_SPEED);
    	backGround = new Ground(frontGround.getTailX(), yPos, 800, 50,
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
    }

	public Ground getFrontGround() {
		return frontGround;
	}

	public Ground getBackGround() {
		return backGround;
	}


}
