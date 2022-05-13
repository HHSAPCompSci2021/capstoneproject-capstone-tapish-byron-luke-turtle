package screens;


import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import g4p_controls.*;
import processing.core.*;

import core.DrawingSurface;
/**
 * This class represents the home screen when you start the game. 
 * @version 5/6/22
 */
public class SplashScreen extends Screen {
	DrawingSurface surface;
	private GDropList diff;
	public GButton controls, startGame;
	
	/**
	 * Creates a splash screen with preset dimensions. 
	 * @param surface DrawingSurface upon which the splash screen will be created
	 */
	public SplashScreen(DrawingSurface surface) {
		super(900, 700);
		this.surface = surface;
	}
	
	public GButton getControlB() {
		return controls;
	}
	
	public GButton getStButton() {
		return startGame;
	}
	
	
	public void setup() {
		G4P.setInputFont("Times New Roman", G4P.PLAIN, 14); // New for G4P V4.3
		G4P.setGlobalColorScheme(GCScheme.PURPLE_SCHEME);
		// Some start text
		  
		diff = new GDropList(surface, 400, 300, 100, 100, 0);
		  
		diff.setItems(new String[] {"Easy", "Hard"}, 0);

		controls = new GButton(surface, 350, 200, 200, 60, "Controls");
		startGame = new GButton(surface, 350, 350, 200, 60, "Play");
	}
	
	
	public void setMenuVis(boolean vis) {
			diff.setVisible(vis);
	}
	
	public void setButtonVis(boolean vis) {
		controls.setVisible(vis);
		startGame.setVisible(vis);
	}
	
	
	
	public void draw() {
		surface.background(255, 200, 200);
		
		
	}
	
	
	
}
