package screens;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import core.DrawingSurface;
import processing.core.PImage;
import sprites.*;
/**
 * 
 * @author Tapish, Byron
 * @version 5/14/22
 * This is the main screen where the gameplay happens. 
 */
public class GameScreen extends Screen {
	
	private int difficulty;
	private DrawingSurface surface;
	private PImage key;
	private Turtle player;
	private ArrayList<Obstacle> obstacles;
	private ArrayList<Enemy> enemies;
	private ArrayList<Chest> riddles;
	private boolean pause;
	private long start, timePaused;
	
	
	/**
	 * Creates a game screen (the screen which the player will primarily interact with) with preset dimensions. 
	 * @param surface DrawingSurface upon which the game screen will be created
	 */
	public GameScreen(DrawingSurface surface) {
		super(900, 700);
		this.surface = surface;
		obstacles = new ArrayList<Obstacle>();
		enemies = new ArrayList<Enemy>();
		riddles = new ArrayList<Chest>();
		player = new Turtle(250, 200, 60, 75);
		obstacles.add(new Obstacle(600, 450, 50, 50, 0));
		enemies.add(new Enemy(500, 500, 50, 50, true));
		enemies.add(new Enemy(700, 200, 50, 50, false));
		obstacles.add(new Obstacle(500, 200, 50, 50, 1));
		riddles.add(new Chest(700, 550, 80, 60));
	}
	
	/**
	 * Starts the timer
	 */
	public void setup() {
		start = System.currentTimeMillis();
	}
	
	/**
	 * Method for setting the current time.
	 * @param currentTime the current time (it's in the name!)
	 */
	public void setCurrentTime(long currentTime) {
		start = currentTime;
	}
	
	/*
	 * old method no longer in use
	public boolean getPauseStatus() {
		return pause;
	}
	*/
	
	/**
	 * Method for drawing things on the Game processing window/screen. Runs the timer in addition to drawing the Turtle sprite.
	 */
	public void draw() {

		long elapsed = System.currentTimeMillis() - start - timePaused;
		int min = (int) (elapsed/1000/60);
		int sec = (int) ((elapsed/1000)%60);
		int rem = (int) (elapsed%1000);
		
	/*	if(pause = true) {
			min = tempMin;
			sec = tempSec;
			rem = tempRem;
		}	*/
		
		
		surface.background(0, 0, 0);
		player.applyWindowLimits(900,700);
		player.draw(surface, player.getX(), player.getY(), player.getWidth(), player.getHeight());
		ArrayList<Sprite> sprites = new ArrayList<Sprite>();
		sprites.addAll(obstacles);
		sprites.addAll(enemies);
		sprites.addAll(riddles);
		
		for (int i = 0; i < obstacles.size(); i++) {
			Obstacle obs = obstacles.get(i);
			obs.draw(surface, obs.getX(), obs.getY(), obs.getWidth(), obs.getHeight());
		}
		for (int i = 0; i < enemies.size(); i++) {
			Enemy enemy = enemies.get(i);
			enemy.draw(surface, enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
			enemy.move(sprites);
		}
		for (int i = 0; i < riddles.size(); i++) {
			Chest rid = riddles.get(i);
			rid.draw(surface, rid.getX(), rid.getY(), rid.getWidth(), rid.getHeight());
		}
		
		
		surface.textSize(30);
		surface.text(min+":"+sec+":"+rem, 5, 30);
		
		
	/*	
	 * 
	 * note to self: don't put this in draw method.
	 * if(surface.isPressed(KeyEvent.VK_ESCAPE)) {
			int minTemp = min;
			int secTemp = sec;
			int remTemp = rem;
			Object[] options = {"Yes"};
			int answer = JOptionPane.showOptionDialog(null, "Resume game?", "The game is paused", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if(answer == JOptionPane.YES_OPTION) {
				min = minTemp;
				sec = secTemp;
				rem = remTemp;
			}
		}
		*/
		
		
		
		if(surface.isPressed(KeyEvent.VK_UP)) {
			player.walk(0, sprites);
		}
		if(surface.isPressed(KeyEvent.VK_DOWN)) {
			player.walk(2, sprites);
		}
		if(surface.isPressed(KeyEvent.VK_LEFT)) {
			player.walk(3, sprites);
		}
		if(surface.isPressed(KeyEvent.VK_RIGHT)) {
			player.walk(1, sprites);
		}

		if(surface.isPressed(KeyEvent.VK_3)) {
			surface.switchScreen(ScreenSwitcher.VICTORY_S);
		}
		
		if(player.keyGoalReached() == true) {
			surface.switchScreen(ScreenSwitcher.VICTORY_S);
		}
	}
	
	public void keyPressed() {
		if(surface.isPressed(KeyEvent.VK_ESCAPE)) {
			long pauseStart = System.currentTimeMillis();
			pause = true;
			Object[] options = {"Yes"};
			int answer = JOptionPane.showOptionDialog(null, "Resume game?", "The game is paused", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if(answer == JOptionPane.YES_OPTION) {
				long pauseEnd = System.currentTimeMillis();
				timePaused += (pauseEnd - pauseStart);
			}	
		}
	}
}
