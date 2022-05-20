package screens;

import java.awt.event.KeyEvent;

import core.DrawingSurface;
import processing.core.PImage;
/**
 * 
 * @author Luke Yang
 * @version 5/13/22
 * This is the screen that is displayed upon game over.
 */
public class GameOverScreen extends Screen {

	DrawingSurface surface;
	private PImage gameOver;
	
	/**
	 * Creates a finish screen (the screen that is displayed after game completion) with preset dimensions. 
	 * @param surface DrawingSurface upon which the finish screen will be created
	 */
	public GameOverScreen(DrawingSurface surface) {
		super(900, 700);
		this.surface = surface;
	}
	
	/**
	 * Loads images of beach and turtle into Processing utility
	 */
	public void setup() {
		gameOver = surface.loadImage("img/gg.png");
		
	}
	
	/**
	 * Displays images called in setup() in Processing window
	 */
	public void draw() {
		surface.background(0, 0, 255);
		surface.image(gameOver, 0, 0, 900, 700);
		
		/*
		if(surface.isPressed(KeyEvent.VK_2)) {
			surface.switchScreen(ScreenSwitcher.GAME_S);
		}
		
		if(surface.isPressed(KeyEvent.VK_ESCAPE)) {
			surface.switchScreen(ScreenSwitcher.SPLASH_S);
		}
		*/
	}
}
