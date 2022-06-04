package screens;

import java.awt.event.KeyEvent;

import core.DrawingSurface;
import processing.core.PFont;
import processing.core.PImage;
/**
 * 
 * @author Tapish Singh
 * @version 5/22/22
 * This is the screen that is displayed upon game completion.
 */
public class FinishScreen extends Screen {

	private DrawingSurface surface;
	private PImage beach, turt;
	
	
	/**
	 * Creates a finish screen (the screen that is displayed after game completion) with preset dimensions. 
	 * @param surface DrawingSurface upon which the finish screen will be created
	 */
	public FinishScreen(DrawingSurface surface) {
		super(900, 700);
		this.surface = surface;
	}
	
	/**
	 * Loads images of beach and turtle into Processing utility
	 */
	public void setup() {
		beach = surface.loadImage("img/beach.jpg");
		turt = surface.loadImage("img/turtleVictory.gif");
	}
	
	/**
	 * Displays images called in setup() in Processing window, in addition to displaying the text that tells the player how they did during the game.
	 */
	public void draw() {
		surface.background(0, 0, 255);
		surface.image(beach, 0, 0, 900, 700);
		surface.image(turt, 500, 500, 178, 100);
		
		int min = (int) (surface.getTime()/1000/60);
		int sec = (int) ((surface.getTime()/1000)%60);
		int rem = (int) (surface.getTime()%1000);	
		
		String timePrint = min + " : " + sec + " : " + rem;
		
		surface.textAlign(surface.CENTER);
		surface.fill(0);
		PFont fontBig = surface.createFont("Poor Richard", 50);
		PFont fontReg = surface.createFont("Poor Richard", 30);
		surface.textFont(fontBig);
		surface.text("CONGRATULATIONS!", 450, 200);
		surface.textFont(fontReg);
		surface.text("You escaped!"
				+ "\nScore:  "
				+ surface.getScore()
				+ "\nTime:  "
				+ timePrint
				+ "\nKeys Collected:  "
				+ surface.getKeys(), 450, 250);
		
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
