package sprites;

import java.awt.Image;

/**
 * This class represents an obstacle that prevents the character from moving past. 
 * @version 5/6/22
 */
public class Obstacle extends Sprite {
	private int obsType;
	
	/**
	 * This creates an object at a specified coordinate.
	 * @param x the x-coordinate of the obstacle
	 * @param y the y-coordinate of the obstacle
	 * @param obsType the type of obstacle(lethal: 0, non-lethal: 1)
	 */
	public Obstacle(int x, int y, int width, int height) {
		super("obstacle.png", x, y, width, height, 2);
		this.obsType = obsType;
	}
	
	/**
	 * Randomly places obstacles around the map
	 */
	public void decideSpawnPoint() {
		
	}
	
	/**
	 * Gets the obstacle type(lethal or non-lethal)
	 * @return obstacle type
	 */
	public int getObsType() {
		return obsType;
	}
}
