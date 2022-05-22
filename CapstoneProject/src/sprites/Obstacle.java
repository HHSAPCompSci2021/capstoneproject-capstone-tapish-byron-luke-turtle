package sprites;

import java.awt.Image;

/**
 * This class represents an obstacle that prevents the character from moving past. 
 * @version 5/6/22
 * @author Byron Tam
 */
public class Obstacle extends Sprite {
	private int obsType;
	
	/**
	 * This creates an object at a specified coordinate.
	 * @param x the x-coordinate of the obstacle
	 * @param y the y-coordinate of the obstacle
	 * @param obsType the type of obstacle(lethal: 0, non-lethal: 1)
	 */
	public Obstacle(int x, int y, int width, int height, int obsType) {
		super("img/brick.png", x, y, width, height);
		this.obsType = obsType;
		if(obsType == 0) {
			setImage("img/spike.png");
		}
	}
	
	
	/**
	 * Gets the obstacle type(lethal or non-lethal)
	 * @return obstacle type
	 */
	public int getObsType() {
		return obsType;
	}
	
}
