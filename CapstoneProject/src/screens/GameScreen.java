package screens;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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
	ArrayList<Chest> riddles;
	private boolean pause = false;
	
	
	/**
	 * Creates a game screen (the screen which the player will primarily interact with) with preset dimensions. 
	 * @param surface DrawingSurface upon which the game screen will be created
	 */
	public GameScreen(DrawingSurface surface) {
		super(900, 700);
		this.surface = surface;
		player = new Turtle(10, 10, 100, 75, 1);
	}
	
	public void setup() {

	}
	
	public boolean getPauseStatus() {
		return pause;
	}
	
	public void draw() {
		surface.background(0, 0, 0);
		player.draw(surface, player.getX(), player.getY(), player.getWidth(), player.getHeight());
		
		if(surface.isPressed(KeyEvent.VK_ESCAPE)) {
			// PUT STUFF HERE THAT WILL PAUSE THE TIMER
			int answer = JOptionPane.showConfirmDialog(null, "Resume game?");
			if(answer == JOptionPane.YES_OPTION) {
			// PUT STUFF HERE THAT WILL RESUME THE TIMER
			}
		}
		
		if(surface.isPressed(KeyEvent.VK_UP)) {
			player.walk(0);
		}
		if(surface.isPressed(KeyEvent.VK_DOWN)) {
			player.walk(2);
		}
		if(surface.isPressed(KeyEvent.VK_LEFT)) {
			player.walk(3);
		}
		if(surface.isPressed(KeyEvent.VK_RIGHT)) {
			player.walk(1);
		}

		if(surface.isPressed(KeyEvent.VK_3)) {
			surface.switchScreen(ScreenSwitcher.VICTORY_S);
		}
	}
}
