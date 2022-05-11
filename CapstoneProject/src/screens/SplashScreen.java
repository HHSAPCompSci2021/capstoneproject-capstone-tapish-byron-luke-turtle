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
	private Rectangle controls, startGame;
	private GDropList diff;
	
	/**
	 * Creates a splash screen with preset dimensions. 
	 * @param surface DrawingSurface upon which the splash screen will be created
	 */
	public SplashScreen(DrawingSurface surface) {
		super(900, 700);
		this.surface = surface;
		controls = new Rectangle(900/2-100,200,200,100);
		startGame = new Rectangle(900/2-100,400,200,100);
	}
	
	
	public void setup() {
		G4P.setInputFont("Times New Roman", G4P.PLAIN, 14); // New for G4P V4.3
		G4P.setGlobalColorScheme(GCScheme.PURPLE_SCHEME);
		// Some start text
		  
		diff = new GDropList(surface, 100, 100, 100, 100, 0);
		  
		diff.setItems(new String[] {"Easy", "Hard"}, 0);

	}
	
	
	// methods for setting visibility
	
	
	/*
	public void handleDropListEvents(GDropList list, GEvent event) {
		System.out.println("Item selected:" + list.getSelectedText());
	}
	*/
	
	public void draw() {
		surface.background(255, 255, 255);
		
		surface.rect(controls.x, controls.y, controls.width, controls.height);
		surface.fill(255);
		surface.rect(startGame.x, startGame.y, startGame.width, startGame.height);
		surface.fill(0);
		
		String str1 = "Controls";
		float w = surface.textWidth(str1);
		surface.text(str1, controls.x+controls.width/2-w/2, controls.y+controls.height/2);
		
		String str2 = "Start game";
		float w2 = surface.textWidth(str2);
		surface.text(str2, startGame.x+startGame.width/2-w2/2, startGame.y+startGame.height/2);
		

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
