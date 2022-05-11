package screens;

import java.awt.event.KeyEvent;

import core.DrawingSurface;

public class FinishScreen extends Screen {

	DrawingSurface surface;
	
	/**
	 * Creates a finish screen (the screen that is displayed after game completion) with preset dimensions. 
	 * @param surface DrawingSurface upon which the finish screen will be created
	 */
	public FinishScreen(DrawingSurface surface) {
		super(900, 700);
		this.surface = surface;
	}
	
	public void setup() {
		
	}
	
	public void draw() {
		surface.background(0, 0, 255);
		
		if(surface.isPressed(KeyEvent.VK_2)) {
			surface.switchScreen(ScreenSwitcher.GAME_S);
		}
		
		if(surface.isPressed(KeyEvent.VK_1)) {
			surface.switchScreen(ScreenSwitcher.SPLASH_S);
		}
	}
}
