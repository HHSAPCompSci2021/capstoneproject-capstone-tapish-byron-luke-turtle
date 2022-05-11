package screens;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import core.DrawingSurface;
import processing.core.PImage;
import sprites.*;

public class GameScreen extends Screen {
	
	int difficulty;
	DrawingSurface surface;
	PImage key;
	Turtle player;
	ArrayList<Obstacle> obstacles;
	ArrayList<Chest> riddles;
	
	
	/**
	 * Creates a game screen (the screen which the player will primarily interact with) with preset dimensions. 
	 * @param surface DrawingSurface upon which the game screen will be created
	 */
	public GameScreen(DrawingSurface surface) {
		super(900, 700);
		this.surface = surface;
	}
	
	public void setup() {
		
	}
	
	public void draw() {
		surface.background(0, 255, 0);
		
		if(surface.isPressed(KeyEvent.VK_1)) {
			surface.switchScreen(ScreenSwitcher.SPLASH_S);
		}
		
		if(surface.isPressed(KeyEvent.VK_3)) {
			surface.switchScreen(ScreenSwitcher.VICTORY_S);
		}
	}
}
