package screens;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
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
	private int numKeys;
	private boolean gameOver;
	private Turtle player;
	private ArrayList<Obstacle> obstacles;
	private ArrayList<Enemy> enemies;
	private ArrayList<Chest> riddles;
	private long start, timePaused;
	private PImage backgr;
	
	
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
		player = new Turtle(250, 200, 60, 75, surface);
		obstacles.add(new Obstacle(600, 450, 50, 50, 1));
		obstacles.add(new Obstacle(300, 450, 50, 50, 1));
		obstacles.add(new Obstacle(100, 450, 50, 50, 1));
		obstacles.add(new Obstacle(200, 240, 50, 50, 1));
		obstacles.add(new Obstacle(500, 280, 50, 50, 1));
		obstacles.add(new Obstacle(250, 450, 50, 50, 1));
		obstacles.add(new Obstacle(270, 450, 50, 50, 1));
		obstacles.add(new Obstacle(600, 450, 50, 50, 1));
		obstacles.add(new Obstacle(360, 450, 50, 50, 1));
		obstacles.add(new Obstacle(750, 450, 50, 50, 1));
		enemies.add(new Enemy(500, 500, 50, 50, true));
		enemies.add(new Enemy(700, 200, 50, 50, false));
		enemies.add(new Enemy(300, 100, 50, 50, true));
		enemies.add(new Enemy(400, 300, 50, 50, false));
		enemies.add(new Enemy(600, 700, 50, 50, false));
		obstacles.add(new Obstacle(500, 200, 50, 50, 1));
		riddles.add(new Chest(700, 550, 80, 60));
		numKeys = 0;
	}
	
	/**
	 * Starts the timer
	 */
	public void setup() {
		start = System.currentTimeMillis();
		backgr = surface.loadImage("img/gameBackground.jpg");
	}
	
	/**
	 * Method for setting the current time.
	 * @param currentTime the current time (it's in the name!)
	 */
	public void setCurrentTime(long currentTime) {
		start = currentTime;
	}
	
	
	/**
	 * Method for drawing things on the Game processing window/screen. Runs the timer in addition to drawing the Turtle sprite.
	 */
	public void draw() {

		surface.image(backgr, 0, 0, 900, 700);
	//	numKeys = player.getScore();
		
		long elapsed = System.currentTimeMillis() - start - timePaused;
		int min = (int) (elapsed/1000/60);
		int sec = (int) ((elapsed/1000)%60);
		int rem = (int) (elapsed%1000);	
	//	surface.background(0, 0, 0);
		player.applyWindowLimits(900,700);
		if(!gameOver) {
		player.draw(surface, player.getX(), player.getY(), player.getWidth(), player.getHeight());
		}
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
			rid.chooseRiddle(i);
			rid.draw(surface, rid.getX(), rid.getY(), rid.getWidth(), rid.getHeight());
		}
		
		if(player.getX() < 100) {
			surface.image(new PImage(new ImageIcon("img/ArrowLeft.png").getImage()), 20, 350, 40, 40);
		}
		if(player.getY() < 100) {
			surface.image(new PImage(new ImageIcon("img/ArrowUp.png").getImage()), 450, 20, 40, 40);
		}
		if(player.getY() > 500) {
			surface.image(new PImage(new ImageIcon("img/ArrowDown.png").getImage()), 450, 640, 40, 40);
		}
		if(player.getX() > 700) {
			surface.image(new PImage(new ImageIcon("img/ArrowRight.png").getImage()), 840, 350, 40, 40);
		}
		surface.textSize(30);
		surface.text(min+":"+sec+":"+rem, 5, 30);
		surface.image(new PImage(new ImageIcon("img/key.png").getImage()), 760, 20, 40, 40);
		surface.image(new PImage(new ImageIcon("img/x.png").getImage()), 810, 30, 20, 20);
	//	surface.text(""+player.getKeysNo(), 845, 50);
		surface.text(""+numKeys, 845, 50);

		/* this CANNOT be in draw method, as it will be called over and over again. Moved to keyPressed method.
		if (surface.isPressed(KeyEvent.VK_SPACE)) {
			for (int i = 0; i < riddles.size(); i++) {
				Chest rid = riddles.get(i);
				if (player.doesRectangleSpriteCollide(rid)) {
					RiddleBank temp = rid.returnRiddle();
					String riddleStr = temp.getRiddle();
					String riddleAns = temp.getAnswer();
					String answer = JOptionPane.showInputDialog(riddleStr);
					if(answer == riddleAns) 
						player.addToScore(1);
				}
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
	
	
	
	/**
	 * Method for detecting key presses.
	 * Different from the key detection in the draw method as this is not called 60 times a second.
	 */
	public void keyPressed() {
		
		if(surface.isPressed(KeyEvent.VK_ESCAPE)) {
			long pauseStart = System.currentTimeMillis();
			Object[] options = {"Yes"};
			int answer = JOptionPane.showOptionDialog(null, "Resume game?", "The game is paused", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if(answer == JOptionPane.YES_OPTION) {
				long pauseEnd = System.currentTimeMillis();
				timePaused += (pauseEnd - pauseStart);
				surface.clearKeyInputs();
			}	
		}
		
		
		if (surface.isPressed(KeyEvent.VK_SPACE)) {
			for (int i = 0; i < riddles.size(); i++) {
				Chest rid = riddles.get(i);
				if (player.doesRectangleSpriteCollide(rid)) {
					if(!rid.getStatus()) {
						RiddleBank temp = rid.returnRiddle();
						String riddleStr = temp.getRiddle();
						String riddleAns = temp.getAnswer();
						String answer = JOptionPane.showInputDialog(riddleStr);
						if(answer != null && answer.equals(riddleAns)) {
							//player.addToKeys(1);
							numKeys++;
							rid.ansStatus(true);
						}
						surface.clearKeyInputs();
					}
				}
			}
		}
		
		
	}
}
