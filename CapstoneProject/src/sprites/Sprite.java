package sprites;

public abstract class Sprite {

	double x, y;
	int facingDirection;
	
	public final static int FACE_RIGHT = 0;
	public final static int FACE_LEFT = 1;
	public final static int NOTAPPLICABLE = 2;
	
	public Sprite(double x, double y, int facingDir) {
		this.x = x;
		this.y = y;
		facingDirection = facingDir;
	}
}
