package sprites;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * This class represents the main character which is controlled by the player using arrowkeys.
 * @version 5/6/22
 */
public class Turtle extends Sprite {
	private int numKeys, secsPassed, score, x, y;
	
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
	public Turtle(int x, int y, int width, int height, int faceDir) {
		super("turtle.png", x, y, width, height, faceDir);
	}
	
	/**
	 * This moves the turtle in the specified direction
	 * @param dir the direction it moves in (up: 0, right: 1, down: 2, left: 3)
	 */
	public void walk(int dir) {
		int speed = 4;
		if(dir == 0) y -= speed;
		if(dir == 1) x += speed;
		if(dir == 2) y += speed;
		if(dir == 3) x -= speed;
	}

	/**
	 * Checks if the turtle can move and if not it stays in place.
	 */
	public void act() {
		
	}
}
