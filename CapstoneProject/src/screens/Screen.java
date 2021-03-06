package screens;
/**
 * 
 * @author Tapish Singh
 * @version 5/10/22
 * Superclass for all of the three screens.
 */
public abstract class Screen {
	int width, height;
	public final int DRAWING_WIDTH, DRAWING_HEIGHT;
	
	/**
	 * Superclass constructor for initializing the width and height of the screen being displayed.
	 * @param width the width of the screen being initialized
	 * @param height the height of the screen being initialized
	 */
	public Screen(int width, int height) {
		this.DRAWING_WIDTH = width;
		this.DRAWING_HEIGHT = height;
	}
	
	/**
	 * Sets up the screen.
	 */
	public void setup() {
		
	}
	
	/**
	 * Draws upon the screen, i.e. displaying all relevant entities/objects in graphical format.
	 */
	public void draw() {
		
	}
	
	/**
	 * Superclass method for detecting key presses
	 */
	public void keyPressed() {
		
	}
}
