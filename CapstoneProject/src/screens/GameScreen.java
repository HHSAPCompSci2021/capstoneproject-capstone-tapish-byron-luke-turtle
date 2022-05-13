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
	ArrayList<Enemy> enemies;
	ArrayList<Chest> riddles;
	private boolean pause = false;
	private long start, timePaused;
	
	
	/**
	 * Creates a game screen (the screen which the player will primarily interact with) with preset dimensions. 
	 * @param surface DrawingSurface upon which the game screen will be created
	 */
	public GameScreen(DrawingSurface surface) {
		super(900, 700);
		this.surface = surface;
		player = new Turtle(100, 100, 100, 75, 1);
		//obstacles.add(new Obstacle(200, 200, 20, 20));
		//enemies.add(new Enemy(150, 20, 50, 50, true));
		//riddles.add(new Chest(20, 150, 50, 50));
	}
	
	public void setup() {
		start = System.currentTimeMillis();
	}
	
	public boolean getPauseStatus() {
		return pause;
	}
	
	public void draw() {
		long elapsed = System.currentTimeMillis() - start - timePaused;
		int min = (int) (elapsed/1000/60);
		int sec = (int) ((elapsed/1000)%60);
		int rem = (int) (elapsed%1000);
		
		surface.background(0, 0, 0);
		player.applyWindowLimits(900,700);
		player.draw(surface, player.getX(), player.getY(), player.getWidth(), player.getHeight());
		/*
		for (int i = 0; i < obstacles.size(); i++) {
			Obstacle obs = obstacles.get(i);
			obs.draw(surface, obs.getX(), obs.getY(), obs.getWidth(), obs.getHeight());
		}
		for (int i = 0; i < enemies.size(); i++) {
			Enemy enemy = enemies.get(i);
			enemy.draw(surface, enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
		}
		for (int i = 0; i < riddles.size(); i++) {
			Chest rid = riddles.get(i);
			rid.draw(surface, rid.getX(), rid.getY(), rid.getWidth(), rid.getHeight());
		}
		*/
		surface.textSize(30);
		surface.text(min+":"+sec+":"+rem, 5, 30);
		if(surface.isPressed(KeyEvent.VK_ESCAPE)) {
			int answer = JOptionPane.showConfirmDialog(null, "Resume game?");
			if(answer == JOptionPane.YES_OPTION) {
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
