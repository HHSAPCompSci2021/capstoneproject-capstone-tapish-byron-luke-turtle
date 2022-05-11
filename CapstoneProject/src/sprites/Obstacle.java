package sprites;

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
	 */
	public Obstacle(double x, double y) {
		super(x, y, 2);
	}
	
	// method below is only if we decide to make obst spawning random
	public void decideSpawnPoint() {
		
	}
}
