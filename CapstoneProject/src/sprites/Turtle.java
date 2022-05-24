package sprites;

import java.util.ArrayList;

import core.DrawingSurface;
import screens.ScreenSwitcher;

/**
 * This class represents the main character which is controlled by the player using arrowkeys.
 * @version 5/6/22
 */
public class Turtle extends Sprite {

	private static int numKeys, score;

	private DrawingSurface surface;

	
	/* SET THIS VARIABLE TO TRUE WHEN THE TURTLE GETS ENOUGH KEYS TO WIN
	 * screen switching depends on this
	 * CHANGE THIS VARIABLE TO TRUE AS VERY LAST THING AT GAME CONCLUSION
	 */
	private static boolean hasEnoughKeys;
	
	
	
	/**
	 * This creates a turtle at a specified place in the coordinate grid and places it facing a certain direction.
	 * @param x the x-coordinate of the sprite
	 * @param y the y-coordinate of the sprite
	 * @param facingDir the initial direction the sprite faces when spawned
	 */
	public Turtle(int x, int y, int width, int height, DrawingSurface drawingSurface) {
		super("img/turtleLeft.png", x, y, width, height);
		numKeys = 0;
		score = 0;
		hasEnoughKeys = false;
		surface = drawingSurface;
	}
	
	/**
	 * This moves the turtle in the specified direction
	 * @param dir the direction it moves in (up: 0, right: 1, down: 2, left: 3)
	 */
	public void walk(int dir, ArrayList<Sprite> sprites) {
		int speed = 9;
		boolean blockedRight = false;
		boolean blockedLeft = false;
		boolean blockedUp = false;
		boolean blockedDown = false;
		for (Sprite sprite : sprites) {
			if (sprite != this) {
				int x = dir == 1 ? getX() + speed : getX();
				x = dir == 3 ? getX() - speed : x;
				int y = dir == 0 ? getY() - speed : getY();
				y = dir == 2 ? getY() + speed : y;
				Turtle temp = new Turtle(x, y, getWidth(), getHeight(), surface);
				if(temp.doesRectangleSpriteCollide(sprite)) {	
					if (dir == 0) {
						blockedUp = true;

					}
					if (dir == 1) {
						blockedRight = true;

					}
					if (dir == 2) {
						blockedDown = true;

					}
					if (dir == 3) {
						blockedLeft = true;

					}
					if (sprite instanceof Enemy) {
						surface.switchScreen(ScreenSwitcher.GAME_OVER_S);
					}
					if (sprite instanceof Obstacle) {
						if(((Obstacle)sprite).getLethality() == 0) { 
						surface.switchScreen(ScreenSwitcher.GAME_OVER_S);
						}
					}
					
					/*if(sprite.getX() >= getX()+getWidth()-speed) {
						blockedRight = true;
						setX(sprite.getX()-getWidth());	
					}
					if(sprite.getX() + sprite.getWidth() <= getX()+speed) {
						blockedLeft = true;
						//setX(sprite.getX()+sprite.getWidth());
					}
					if(sprite.getY() >= getY()+getHeight()-speed) {
						blockedDown = true;
						//setY(sprite.getY() - getHeight());
					}
					if(sprite.getY() +sprite.getHeight() <= getY()+speed) {
						blockedUp = true;
						//setY(sprite.getY()+sprite.getHeight());
					}
					*/
				}
			}
		}
		if(dir == 0 && !blockedUp) setY(getY() - speed);
		if(dir == 1 && !blockedRight) {
			setX(getX() + speed);
			setImage("img/turtleRight.png");
		}
		if(dir == 2 && !blockedDown) setY(getY() + speed);
		if(dir == 3 && !blockedLeft) {
			setX(getX() - speed);
			setImage("img/turtleLeft.png");
		}

	}

	/**
	 * returns the current score of the turtle
	 * @return the current score of the turtle
	 */
	public int getScore(int time) {
		score = (int)((20000000-time)*1.5) + 100000*numKeys;
		return score;
	}
	
	
	/**
	 * adds the specified number of keys to the overall key count
	 * @param add the number of keys you want to add
	 */
	public void addToKeys(int add) {
		numKeys += add;
	}
	
	/**
	 * Returns the current total number of keys
	 * @return the current total number of keys
	 */
	public int getKeysNo() {
		return numKeys;
	}
	
	/**
	 * Sets the score to a specific value
	 * @param sc value you want score to be set to
	 */
	public void setScore(int sc) {
		score = sc;
	}
	
	/**
	 * returns the status of the player, i.e. whether or not they have reached the goal
	 * @return the status of completion
	 */
	public boolean keyGoalReached() {
		if(surface.getDifficulty() == true) {
			if(numKeys == 8) {
				return true;
			}
		}
		else if(surface.getDifficulty() == false) {
			if(numKeys == 12) {
				return true;
			}
		}
		return false;
	}

}
