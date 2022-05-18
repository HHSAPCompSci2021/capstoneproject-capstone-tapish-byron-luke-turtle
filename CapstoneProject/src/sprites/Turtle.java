package sprites;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * This class represents the main character which is controlled by the player using arrowkeys.
 * @version 5/6/22
 */
public class Turtle extends Sprite {
	private int numKeys, secsPassed, score;
	
	/* SET THIS VARIABLE TO TRUE WHEN THE TURTLE GETS ENOUGH KEYS TO WIN
	 * screen switching depends on this
	 * CHANGE THIS VARIABLE TO TRUE AS VERY LAST THING AT GAME CONCLUSION
	 */
	private static boolean hasEnoughKeys = false;
	/**
	 * This creates a turtle at a specified place in the coordinate grid and places it facing a certain direction.
	 * @param x the x-coordinate of the sprite
	 * @param y the y-coordinate of the sprite
	 * @param facingDir the initial direction the sprite faces when spawned
	 */
	public Turtle(int x, int y, int width, int height) {
		super("img/turtleLeft.png", x, y, width, height);
	}
	
	/**
	 * This moves the turtle in the specified direction
	 * @param dir the direction it moves in (up: 0, right: 1, down: 2, left: 3)
	 */
	public void walk(int dir, ArrayList<Sprite> sprites) {
		int speed = 5;
		boolean blockedRight = false;
		boolean blockedLeft = false;
		boolean blockedUp = false;
		boolean blockedDown = false;
		for (Sprite sprite : sprites) {
			if (sprite != this) {
				if(doesRectangleSpriteCollide(sprite)) {
					if(sprite.getX() > getX()) {
						blockedRight = true;
					}
					if(sprite.getX() < getX()) {
						blockedLeft = true;
					}
					if(sprite.getY() > getY()) {
						blockedDown = true;
					}
					if(sprite.getY() > getY()) {
						blockedUp = true;
					}
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
}
