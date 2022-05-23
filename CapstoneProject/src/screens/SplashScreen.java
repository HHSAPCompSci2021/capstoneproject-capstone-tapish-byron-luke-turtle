package screens;


import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import g4p_controls.*;
import processing.core.*;
import core.DrawingSurface;
/**
 * This class represents the home screen when you start the game. 
 * @author Tapish Singh
 * @version 5/6/22
 */
public class SplashScreen extends Screen {
	DrawingSurface surface;
	private GDropList diff;
	public GButton controls, startGame;
	private PImage splash;
	
	/**
	 * Creates a splash screen with preset dimensions. 
	 * @param surface DrawingSurface upon which the splash screen will be created
	 */
	public SplashScreen(DrawingSurface surface) {
		super(900, 700);
		this.surface = surface;
	}
	
	/**
	 * Getter method for returning the Control Gbutton object
	 * @return the Gbutton object for the control button
	 */
	public GButton getControlB() {
		return controls;
	}
	
	/**
	 * Getter method for returning the Play Gbutton object
	 * @return the Gbutton object for the play button
	 */
	public GButton getStButton() {
		return startGame;
	}
	
	/**
	 * Sets up the splash screen. Instatiates the GButton objects in addition to the GDropList.
	 */
	public void setup() {
		surface.setDifficulty(true);
		splash = surface.loadImage("img/SplashScreenImg.PNG");
		G4P.setInputFont("Poor Richard", G4P.PLAIN, 14); // New for G4P V4.3
		G4P.setDisplayFont("Poor Richard", G4P.PLAIN, 35);
		G4P.setGlobalColorScheme(GCScheme.GREEN_SCHEME);
		// Some start text
		  
		diff = new GDropList(surface, 385, 175, 130, 200, 0);
		  
		diff.setItems(new String[] {"Easy", "Hard"}, 0);

		controls = new GButton(surface, 100, 150, 250, 100, "Controls");
		startGame = new GButton(surface, 550, 150, 250, 100, "Play");
	}
	
	/**
	 * Method for setting the visibility of the drop down menu. true for visible, false for invisible
	 * @param vis the visibility you want to set the drop down menu to
	 */
	public void setMenuVis(boolean vis) {
			diff.setVisible(vis);
	}
	
	/**
	 * Method for setting the visibility of the buttons. true for visible, false for invisible
	 * @param vis the visibility you want to set the buttons to
	 */
	public void setButtonVis(boolean vis) {
		controls.setVisible(vis);
		startGame.setVisible(vis);
	}
	
	
	/**
	 * Method for drawing the objects on the Processing screen. Because the G4P elements are entirely handled in the setup() method, only the color of the window is set here.
	 */
	public void draw() {
		surface.background(255, 200, 200);
		surface.image(splash, 0, 0, 900, 700);
		
	}
	
	
	
}
