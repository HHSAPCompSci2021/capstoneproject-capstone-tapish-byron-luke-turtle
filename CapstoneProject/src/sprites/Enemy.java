package sprites;

import java.awt.Image;
import java.util.ArrayList;

/**
 * This represents an enemy that hurts the character on contact. 
 * @version 5/6/22
 */
public class Enemy extends Sprite{
	private boolean direction;
	int speed;
	/**
	 * This creates an enemy at a specified place in the coordinate grid and places it facing a certain direction.
	 * @param x the x-coordinate of the enemy 
	 * @param y the y-coordinate of the enemy
	 * @param faceDir the initial direction the enemy faces when spawned
	 * @param direction the direction the enemy moves(true: vertical, false: horizontal)
	 */

	public Enemy(int x, int y, int width, int height, boolean direction) {
		super("img/krab.png", x, y, width, height, 1);
		this.direction = direction; 
		speed = 3;
	}
	
	/**
	 * Sets the direction of movement of the enemy
	 * @param dir the direction of movement of the enemy
	 */
	public void move(ArrayList<Sprite> sprites) { 
		if (direction) {
			setY(getY() + speed);
		}
		else if(super.getX() == 0) {
			setX(-getX());
		}
		else {
			setX(getX() + speed);
		}
		for (Sprite sprite : sprites) {
			if (sprite != this) {
				if(doesSpritePixelsCollide(sprite)|| getX() <= 0 || getY() <= 0 || getX()+getWidth() >=  900 || getY()+getHeight() >= 700) {
					applyWindowLimits(900, 700);
					speed *= -1;
					if (direction) {
						setY(getY() + speed);
					}
					else {
						setX(getX() + speed);
					}
				}
				
			}
		}
		
		
	}
}
