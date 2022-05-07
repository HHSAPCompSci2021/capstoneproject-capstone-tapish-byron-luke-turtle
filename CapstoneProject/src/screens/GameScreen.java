package screens;

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
		
	}
}
