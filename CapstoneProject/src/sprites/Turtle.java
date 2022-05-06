package sprites;

/**
 * This class represents the main character which is controlled by the player using arrowkeys.
 * @version 5/6/22
 */
public class Turtle extends Sprite {
	private int numKeys, secsPassed, score;
	/**
	 * This creates a turtle at a specified place in the coordinate grid and places it facing a certain direction.
	 * @param x the x-coordinate of the sprite
	 * @param y the y-coordinate of the sprite
	 * @param facingDir the initial direction the sprite faces when spawned
	 */
	public Turtle(double x, double y, int faceDir) {
		super(x, y, faceDir);
	}
	
	/**
	 * This moves the turtle in the specified direction
	 * @param dir the direction it moves in (up: 0, right: 1, down: 2, left: 3)
	 */
	public void walk(int dir) {
		
	}
	
	/**
	 * Checks if the turtle can move and if not it stays in place.
	 */
	public void act() {
		
	}
}
