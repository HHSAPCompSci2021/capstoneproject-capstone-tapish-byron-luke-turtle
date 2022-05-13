package sprites;

import java.awt.Image;

/**
 * This represents an enemy that hurts the character on contact. 
 * @version 5/6/22
 */
public class Enemy extends Sprite{

	/**
	 * This creates an enemy at a specified place in the coordinate grid and places it facing a certain direction.
	 * @param x the x-coordinate of the enemy 
	 * @param y the y-coordinate of the enemy
	 * @param faceDir the initial direction the enemy faces when spawned
	 */
	public Enemy(int x, int y, int width, int height, int faceDir) {
		super("src/sprites/enemy.png", x, y, width, height, faceDir);
		
	}
	
}
