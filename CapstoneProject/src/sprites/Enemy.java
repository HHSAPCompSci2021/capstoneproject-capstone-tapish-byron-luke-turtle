package sprites;

import java.awt.Image;

/**
 * This represents an enemy that hurts the character on contact. 
 * @version 5/6/22
 */
public class Enemy extends Sprite{
	private boolean direction;
	/**
	 * This creates an enemy at a specified place in the coordinate grid and places it facing a certain direction.
	 * @param x the x-coordinate of the enemy 
	 * @param y the y-coordinate of the enemy
	 * @param faceDir the initial direction the enemy faces when spawned
	 * @param direction the direction the enemy moves(true: vertical, false: horizontal)
	 */
	public Enemy(int x, int y, int width, int height, boolean direction) {
		super("src/sprites/krab.png", x, y, width, height, 1);
		this.direction = direction; 
	}
	
	
}
