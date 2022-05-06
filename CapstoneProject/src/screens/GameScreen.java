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
	
	
	public GameScreen(DrawingSurface surface) {
		super(900, 700);
		this.surface = surface;
	}
	
	public void setup() {
		
	}
	
	public void draw() {
		
	}
}
