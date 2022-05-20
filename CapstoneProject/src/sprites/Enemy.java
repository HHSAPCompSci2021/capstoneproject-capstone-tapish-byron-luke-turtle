package sprites;

import java.awt.Image;
import java.util.ArrayList;

import screens.Screen;

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
		super("img/krab.png", x, y, width, height);
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
			setX(-1 * getX());
		}
		else {
			setX(getX() + speed);
		}
		for (int i = 0; i < sprites.size(); i+=1) {
			if (sprites.get(i) != this) {
				if(doesRectangleSpriteCollide(sprites.get(i))|| getX() <= 0 ||
						getY() <= 0 || getX()+getWidth() >= 
						900 || getY()+getHeight() >= 700) {
					applyWindowLimits(900, 700);
	
				
					speed *= -1;
					setY((direction ? getY() + speed : getY()));
					setX((!direction ? getX() + speed : getX()));
					
				}
			}
		}

		
	}
}
