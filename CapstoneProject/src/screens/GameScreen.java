package screens;

import java.util.ArrayList;

import core.DrawingSurface;
import processing.core.PImage;
import sprites.*;
/**
 * 
 * @author Luke, Tapish, Byron
 * GameScreen 
 */
public class GameScreen extends Screen {
	
	int difficulty;
	DrawingSurface surface;
	PImage key;
	Turtle player;
	ArrayList<Obstacle> obstacles;
	ArrayList<RiddleMarker> riddles;
	
	
	public GameScreen(DrawingSurface surface) {
		super(900, 700);
		this.surface = surface;
	}
	
	public void setup() {
		
	}
	
	public void draw() {
		
	}
}
