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
 * @version 5/14/22 This is the main screen where the gameplay happens.
 */
public class GameScreen extends Screen {
	private int[][] roomNum = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
	private int i, j, current;
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
	 * Creates a game screen (the screen which the player will primarily interact
	 * with) with preset dimensions.
	 * 
	 * @param surface DrawingSurface upon which the game screen will be created
	 */
	public GameScreen(DrawingSurface surface) {
		super(900, 700);
		this.surface = surface;
		map = new GameMap(surface.getDifficulty());
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
	 * 
	 * @param currentTime the current time (it's in the name!)
	 */
	public void setCurrentTime(long currentTime) {
		start = currentTime;
	}

	/**
	 * Method for drawing things on the Game processing window/screen. Runs the
	 * timer in addition to drawing the Turtle sprite.
	 */
	public void draw() {	
		surface.image(backgr, 0, 0, 900, 700);
		current = roomNum[i][j];
		obstacles = map.getCurrentObstacle(current);
		enemies = map.getCurrentEnemy(current);
		riddles = map.getCurrentChest(current);
		gate = map.getCurrentGate(current);
		long elapsed = System.currentTimeMillis() - start - timePaused;
		long timeLeft = 0;
		int min = 0; 
		int sec = 0; 
		int rem = 0; 

		if (surface.getDifficulty() == true) {
			min = (int) (elapsed / 1000 / 60);
			sec = (int) ((elapsed / 1000) % 60);
			rem = (int) (elapsed % 1000);
		} else if (surface.getDifficulty() == false) {
			timeLeft = 1200000 - elapsed;
			min = (int) (timeLeft / 1000 / 60);
			sec = (int) ((timeLeft / 1000) % 60);
			rem = (int) (timeLeft % 1000);
		}
		if (!gameOver) {
			player.draw(surface, player.getX(), player.getY(), player.getWidth(), player.getHeight());
		}
		ArrayList<Sprite> sprites = new ArrayList<Sprite>();
		sprites.addAll(obstacles);
		sprites.addAll(enemies);
		sprites.addAll(riddles);
		if (gate != null)
			sprites.add(gate);

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
		if (gate != null) {
			gate.draw(surface, gate.getX(), gate.getY(), gate.getWidth(), gate.getHeight());
		}
		if (player.getX() < 100 && j != 0) {
			surface.image(new PImage(new ImageIcon("img/ArrowLeft.png").getImage()), 20, 350, 40, 40);
		} else {
			player.setX(Math.max(0, player.getX()));
		}
		if (player.getY() < 100 && i != 0) {
			surface.image(new PImage(new ImageIcon("img/ArrowUp.png").getImage()), 450, 20, 40, 40);
		} else {
			player.setY(Math.max(0, player.getY()));
		}
		if (player.getY() > 500 && i != 2) {
			surface.image(new PImage(new ImageIcon("img/ArrowDown.png").getImage()), 450, 640, 40, 40);
		} else {
			player.setY(Math.min(player.getY(), 700 - player.getHeight()));
		}
		if (player.getX() > 700 && j != 2) {
			surface.image(new PImage(new ImageIcon("img/ArrowRight.png").getImage()), 840, 350, 40, 40);
		} else {
			player.setX(Math.min(player.getX(), 900 - player.getWidth()));
		}
		if (player.getY() < 0 && i != 0) {
			int temp = roomNum[i-1][j];
			obstacles = map.getCurrentObstacle(temp);
			enemies = map.getCurrentEnemy(temp);
			riddles = map.getCurrentChest(temp);
			
			Turtle fake = new Turtle(player.getX(), 625, player.getWidth(), player.getHeight(), surface);
			if(!checkRoom(fake)) {
				sprites.clear();
				sprites.addAll(obstacles);
				sprites.addAll(enemies);
				sprites.addAll(riddles);
			i--;
			player.setY(625);
			} else {
				player.setY(Math.max(0, player.getY()));
			}
		}
		if (player.getX() < 0 && j != 0) {
			int temp = roomNum[i][j-1];
			obstacles = map.getCurrentObstacle(temp);
			enemies = map.getCurrentEnemy(temp);
			riddles = map.getCurrentChest(temp);
			
			Turtle fake = new Turtle(840, player.getY(), player.getWidth(), player.getHeight(), surface);
			if(!checkRoom(fake)) {
				sprites.clear();
				sprites.addAll(obstacles);
				sprites.addAll(enemies);
				sprites.addAll(riddles);
			j--;
			player.setX(840);
			} else {
				player.setX(Math.max(0, player.getX()));
			}
		}

		if (player.getX() > 840 && j != 2) { 
			int temp = roomNum[i][j+1];
			obstacles = map.getCurrentObstacle(temp);
			enemies = map.getCurrentEnemy(temp);
			riddles = map.getCurrentChest(temp);
			
			Turtle fake = new Turtle(0, player.getY(), player.getWidth(), player.getHeight(), surface);
			if(!checkRoom(fake)) {
				sprites.clear();
				sprites.addAll(obstacles);
				sprites.addAll(enemies);
				sprites.addAll(riddles);
			j++;
			player.setX(0);
			} else {
				player.setX(Math.min(player.getX(), 900 - player.getWidth()));
			}
		}
		if (player.getY() > 625 && i != 2) {
			int temp = roomNum[i+1][j];
			obstacles = map.getCurrentObstacle(temp);
			enemies = map.getCurrentEnemy(temp);
			riddles = map.getCurrentChest(temp);
			
			Turtle fake = new Turtle(player.getX(), 0, player.getWidth(), player.getHeight(), surface);
			if(!checkRoom(fake)) {
				sprites.clear();
				sprites.addAll(obstacles);
				sprites.addAll(enemies);
				sprites.addAll(riddles);
			i++;
			player.setY(0);
			} else {
				player.setY(Math.min(player.getY(), 700 - player.getHeight()));
			}
		}
		surface.textSize(30);
		surface.text(min + ":" + sec + ":" + rem, 5, 30);
		surface.image(new PImage(new ImageIcon("img/key.png").getImage()), 760, 20, 40, 40);
		surface.image(new PImage(new ImageIcon("img/x.png").getImage()), 810, 30, 20, 20);
		surface.text("" + player.getKeysNo(), 845, 50);

		if (timeLeft == 0 && (surface.getDifficulty() == false)) {
			surface.switchScreen(ScreenSwitcher.GAME_OVER_S);
		}

		if (surface.isPressed(KeyEvent.VK_UP)) {
			player.walk(0, sprites);
		}
		if (surface.isPressed(KeyEvent.VK_DOWN)) {
			player.walk(2, sprites);
		}
		if (surface.isPressed(KeyEvent.VK_LEFT)) {
			player.walk(3, sprites);
		}
		if (surface.isPressed(KeyEvent.VK_RIGHT)) {
			player.walk(1, sprites);
		}

		if (surface.isPressed(KeyEvent.VK_3)) {
			if(player.keyGoalReached() == true) {
				surface.setTime(elapsed);
				surface.setKeys((long) player.getKeysNo());
				surface.switchScreen(ScreenSwitcher.VICTORY_S);
			}
		}
	}
	
	private boolean checkRoom(Turtle check) {
		for (int i = 0; i < obstacles.size(); i++) {
			Obstacle obs = obstacles.get(i);
			if(check.doesRectangleSpriteCollide(obs)) return true;
		}
		for (int i = 0; i < enemies.size(); i++) {
			Enemy enemy = enemies.get(i);
			if(check.doesRectangleSpriteCollide(enemy)) return true;
		}
		for (int i = 0; i < riddles.size(); i++) {
			Chest rid = riddles.get(i);
			if(check.doesRectangleSpriteCollide(rid)) return true;
		}
		return false;
	}
	/**
	 * Method for detecting key presses. Different from the key detection in the
	 * draw method as this is not called 60 times a second.
	 */
	public void keyPressed() {

		if (surface.isPressed(KeyEvent.VK_ESCAPE)) {
			long pauseStart = System.currentTimeMillis();
			Object[] options = { "Yes" };
			int answer = JOptionPane.showOptionDialog(null, "Resume game?", "The game is paused",
					JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if (answer == JOptionPane.YES_OPTION) {
				long pauseEnd = System.currentTimeMillis();
				timePaused += (pauseEnd - pauseStart);
				surface.clearKeyInputs();
			}
		}

		if (surface.isPressed(KeyEvent.VK_SPACE)) {
			for (int i = 0; i < riddles.size(); i++) {
				Chest rid = riddles.get(i);
				Chest place = new Chest(rid.getX() - 9, rid.getY() - 9, rid.getWidth() + 18, rid.getHeight() + 18);
				if (player.doesRectangleSpriteCollide(place)) {
					if (!rid.getStatus()) {
						long pauseStart = System.currentTimeMillis();
						RiddleBank temp = rid.returnRiddle();
						String riddleStr = temp.getRiddle();
						String riddleAns = temp.getAnswer();
						String riddleHint = temp.getHint();
						String answer = JOptionPane.showInputDialog(riddleStr
								+ "\nenter the answer as one word, all lowercase.\n\nType the word \"hint\" in the dialog box for a hint, and then reopen this chest.\n");
						if (answer != null && answer.equals("hint") /* surface.isPressed(KeyEvent.VK_) */) {
							Object[] options = { "Thank you, hint popup!" };
							int answer2 = JOptionPane.showOptionDialog(null, riddleHint, "Hint Window",
									JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
							long pauseEnd = System.currentTimeMillis();
							timePaused += (pauseEnd - pauseStart);
							timePaused -= 30000;
						}
						if (answer != null && answer.equals(riddleAns)) {
							player.addToKeys();
							rid.ansStatus(true);
							long pauseEnd = System.currentTimeMillis();
							timePaused += (pauseEnd - pauseStart);
						} else {
							long pauseEnd = System.currentTimeMillis();
							timePaused += (pauseEnd - pauseStart);
							timePaused -= 5000;
						}
						surface.clearKeyInputs();
					}
				}
			}
			if (gate != null) {
				Turtle fake = new Turtle(player.getX() - 9, player.getY() - 9, player.getWidth() + 18,
						player.getHeight() + 18, surface);
				if (fake.doesRectangleSpriteCollide(gate)) {
					if (player.keyGoalReached()) {
						surface.setScore(player.getScore((int)(System.currentTimeMillis() - start - timePaused)));
						surface.setTime(System.currentTimeMillis() - start - timePaused);
						surface.setKeys((long) player.getKeysNo());
						surface.switchScreen(ScreenSwitcher.VICTORY_S);
					} else {
						JOptionPane.showMessageDialog(null, "Sorry, not enough keys! Go get some more!");
						surface.clearKeyInputs();
					}
				}
			}
		}
	}
}
