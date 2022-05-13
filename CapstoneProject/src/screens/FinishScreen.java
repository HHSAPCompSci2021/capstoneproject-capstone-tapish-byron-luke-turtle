package screens;

import java.awt.event.KeyEvent;

import core.DrawingSurface;
import processing.core.PImage;
/**
 * 
 * @author Luke, Tapish, Byron
 * this is the finishscreen
 */
public class FinishScreen extends Screen {

	DrawingSurface surface;
	private PImage beach, turt;
	
	/**
	 * Creates a finish screen (the screen that is displayed after game completion) with preset dimensions. 
	 * @param surface DrawingSurface upon which the finish screen will be created
	 */
	public FinishScreen(DrawingSurface surface) {
		super(900, 700);
		this.surface = surface;
	}
	
	public void setup() {
		beach = surface.loadImage("img/beach.jpg");
		turt = surface.loadImage("img/turtleVictory.gif");
	}
	
	public void draw() {
		surface.background(0, 0, 255);
		surface.image(beach, 0, 0, 900, 700);
		surface.image(turt, 500, 500, 178, 100);
		
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
