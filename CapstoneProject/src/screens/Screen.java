package screens;

public abstract class Screen {
	int width, height;
	public final int DRAWING_WIDTH, DRAWING_HEIGHT;
	
	public Screen(int width, int height) {
		this.DRAWING_WIDTH = width;
		this.DRAWING_HEIGHT = height;
	}
	public void setup() {
		
	}
	
	public void draw() {
		
	}
}
