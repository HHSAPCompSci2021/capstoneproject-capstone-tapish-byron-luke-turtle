package screens;

import java.awt.event.KeyEvent;

import core.DrawingSurface;
/**
 * This class represents the home screen when you start the game. 
 * @version 5/6/22
 */
public class SplashScreen extends Screen {
	DrawingSurface surface;
	
	/**
	 * Creates a splash screen with preset dimensions. 
	 * @param surface DrawingSurface upon which the splash screen will be created
	 */
	public SplashScreen(DrawingSurface surface) {
		super(900, 700);
		this.surface = surface;
	}
	
	/*
	public void setup() {
		
	}
	*/
	
	public void draw() {
		surface.background(255, 0, 0);
		
		if(surface.isPressed(KeyEvent.VK_2)) {
			surface.switchScreen(ScreenSwitcher.GAME_S);
		}
		
		/*
		 * for testing purposes
		if(surface.isPressed(KeyEvent.VK_3)) {
			surface.switchScreen(ScreenSwitcher.VICTORY_S);
		}
		*/
	}
}
