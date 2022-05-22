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
	private int [][] roomNum = {{1, 2, 3} , {4, 5, 6}, {7, 8, 9}};
	private int difficulty, i, j, current;
	private DrawingSurface surface;
	private Sprite gate;
	private boolean gameOver;
	private Turtle player;
	private ArrayList<Sprite> sprites;
	private ArrayList<Obstacle> obstacles;
	private ArrayList<Enemy> enemies;
	private ArrayList<Chest> riddles;
	private long start, timePaused;
	private PImage backgr;
	private GameMap map;
	
	
	/**
	 * Creates a game screen (the screen which the player will primarily interact with) with preset dimensions. 
	 * @param surface DrawingSurface upon which the game screen will be created
	 */
	public GameScreen(DrawingSurface surface) {
		super(900, 700);
		this.surface = surface;
		map = new GameMap();
		sprites = new ArrayList<Sprite>();
		obstacles = new ArrayList<Obstacle>();
		enemies = new ArrayList<Enemy>();
		riddles = new ArrayList<Chest>();
		player = new Turtle(250, 200, 60, 75, surface);
		i = j = 1;
		int current = roomNum[i][j];
		obstacles = map.getCurrentObstacle(current);
		enemies = map.getCurrentEnemy(current);
		riddles = map.getCurrentChest(current);
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
		current = roomNum[i][j];
		obstacles = map.getCurrentObstacle(current);
		enemies = map.getCurrentEnemy(current);
		riddles = map.getCurrentChest(current);
		long elapsed = System.currentTimeMillis() - start - timePaused;
		int min = (int) (elapsed/1000/60);
		int sec = (int) ((elapsed/1000)%60);
		int rem = (int) (elapsed%1000);	
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
		
		if(player.getX() < 100 && j !=0) {
			surface.image(new PImage(new ImageIcon("img/ArrowLeft.png").getImage()), 20, 350, 40, 40);
		} else {
			player.setX(Math.max(0,player.getX()));
		}
		if(player.getY() < 100 && i !=0) {
			surface.image(new PImage(new ImageIcon("img/ArrowUp.png").getImage()), 450, 20, 40, 40);
		} else {
			player.setY(Math.max(0,player.getY()));
		}
		if(player.getY() > 500 && i != 2) {
			surface.image(new PImage(new ImageIcon("img/ArrowDown.png").getImage()), 450, 640, 40, 40);
		} else {
			player.setY(Math.min(player.getY(),700-player.getHeight()));;
		}
		if(player.getX() > 700 && j != 2) {
			surface.image(new PImage(new ImageIcon("img/ArrowRight.png").getImage()), 840, 350, 40, 40);
		} else {
			player.setX(Math.min(player.getX(),900-player.getWidth()));;
		}
		if(player.getY() < 0 && i!=0) {
			i--; 
			player.setY(625);
		}
		if(player.getX() < 0 && j!=0) {
			j--; 
			player.setX(840);
		}	
		
		if(player.getX() > 840 && j!=2) {
			j++; 
			player.setX(0);
		}	
		if(player.getY() > 625 && i!=2) {
			i++; 
			player.setY(0);
		}
		surface.textSize(30);
		surface.text(min+":"+sec+":"+rem, 5, 30);
		surface.image(new PImage(new ImageIcon("img/key.png").getImage()), 760, 20, 40, 40);
		surface.image(new PImage(new ImageIcon("img/x.png").getImage()), 810, 30, 20, 20);
		surface.text(""+player.getKeysNo(), 845, 50);
		
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
						long pauseStart = System.currentTimeMillis();
						RiddleBank temp = rid.returnRiddle();
						String riddleStr = temp.getRiddle();
						String riddleAns = temp.getAnswer();
						String answer = JOptionPane.showInputDialog(riddleStr);
						if(answer != null && answer.equals(riddleAns)) {
							player.addToKeys(1);
							rid.ansStatus(true);
							long pauseEnd = System.currentTimeMillis();
							timePaused += (pauseEnd - pauseStart);
						}
						else {
							long pauseEnd = System.currentTimeMillis();
							timePaused += (pauseEnd - pauseStart);
							timePaused -= 5000;
						}
						surface.clearKeyInputs();
					}
				}
			}
		
	}
}
}
