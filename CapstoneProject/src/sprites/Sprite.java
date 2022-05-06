package sprites;

/**
 * This class represents a default sprite.
 * @version 5/6/22
 */
public abstract class Sprite {

	private double x, y;
	private int facingDirection;
	public final static int FACE_RIGHT = 0;
	public final static int FACE_LEFT = 1;
	public final static int NOTAPPLICABLE = 2;
	
	/**
	 * This creates a sprite at a specified place in the coordinate grid and places it facing a certain direction.
	 * @param x the x-coordinate of the sprite
	 * @param y the y-coordinate of the sprite
	 * @param facingDir the initial direction the sprite faces when spawned
	 */
	public Sprite(double x, double y, int facingDir) {
		this.x = x;
		this.y = y;
		facingDirection = facingDir;
	}
}
