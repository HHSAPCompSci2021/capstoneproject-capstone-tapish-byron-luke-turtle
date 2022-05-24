package core;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import g4p_controls.GButton;
import g4p_controls.GDropList;
import g4p_controls.GEvent;
import processing.core.PApplet;
import screens.FinishScreen;
import screens.GameOverScreen;
import screens.GameScreen;
import screens.Screen;
import screens.ScreenSwitcher;
import screens.SplashScreen;
import sprites.GameMap;

/**
 * 
 * @author Tapish Singh
 * This is the main class for the Processing drawing utlility
 * @version 5/23/22
 */
public class DrawingSurface extends PApplet implements ScreenSwitcher {
	/*
	 * ratioX and ratioY found in gamePhysDemoAP lab and implemented in the draw method
	 * but looked up scale method and found it changes scale of shape?
	 * doesn't seem to be needed in this project
	 * */
	public float ratioX, ratioY;
	
	private ArrayList<Integer> keyInputs;
	private boolean diff;
	private Screen activeScreen;
	private ArrayList<Screen> screens;
	// need this for G4P stuff
	private SplashScreen buttonVar;
	private static boolean gameDifficulty;
	
	private GameMap diffVar;
	private GameScreen timerVar;
	
	// having this in drawingsurface makes victoryscreen text fetching so much easier
	private static long time, score, keys;
	
	/**
	 * Method that returns difficulty set by user
	 * @return difficulty set by user. true means easy, false means hard.
	 */
	public boolean getDifficulty() {
		return gameDifficulty;
	}
	
	/**
	 * Method that sets the game difficulty
	 * @param diff difficulty desired. true means easy, false means hard.
	 */
	public void setDifficulty(boolean diff) {
		gameDifficulty = diff;
	}
	
	/**
	 * Sets time variable in DrawingSurface to a specific value. Used to display time elapsed on victory screen.
	 * @param var value time variable is desired to be
	 */
	public void setTime(long var) {
		time = var;
	}
	
	/**
	 * Returns the time variable in this class. Used to display time elapsed on victory screen.
	 * @return time time value stored in the form of a long
	 */
	public long getTime() {
		return time;
	}
	
	/**
	 * Sets the score. Used in Victory Screen.
	 * @param scr value you want score to be set to.
	 */
	public void setScore(long scr) {
		score = scr;
	}
	
	/**
	 * Returns the score. Used in victory screen.
	 * @return the current score.
	 */
	public long getScore() {
		return score;
	}
	
	/**
	 * Sets the number of keys the player has
	 * @param key the number of keys the player has
	 */
	public void setKeys(long key) {
		keys = key;
	}
	
	/**
	 * Returns the number of keys the player has
	 * @return the number of keys the player has
	 */
	public long getKeys() {
		return keys;
	}
	
	/**
	 * No args constructor for DrawingSurface object
	 * Initializes all of the screens and adds them to the array of screens. Inspired by screen switching mechanism in physicsDemoAP
	 */
	public DrawingSurface() {
		// initializes all of the screens and adds them to the array of screens. Inspired by screen switching mechanism in physicsDemoAP
		screens = new ArrayList<Screen>();
		
		// NOT to be confused w/ number of Keys turtle has!
		keyInputs = new ArrayList<Integer>();
		
		SplashScreen screen1 = new SplashScreen(this);
		GameScreen screen2 = new GameScreen(this);
		FinishScreen screen3 = new FinishScreen(this);
		GameOverScreen screen4 = new GameOverScreen(this);
		
		screens.add(screen1);
		screens.add(screen2);
		screens.add(screen3);
		screens.add(screen4);
		
		activeScreen = screens.get(0);
		buttonVar = screen1;
		timerVar = screen2;
		diffVar = new GameMap(true);
	}

	/**
	 * Clears all of the keys in the keyInputs arraylist.
	 * In other words, makes processing think no keys are pressed after call
	 */
	public void clearKeyInputs() {
		keyInputs = new ArrayList<Integer>();
	}
	
	/**
	 * Switches to a different screen based on parameter passed through
	 * @param i the screen number you want to switch to
	 */
	public void switchScreen(int i) {
		// use vis method in splashscreen to hide dropwdown, setvisibility
		
		
		activeScreen = screens.get(i);
		
	}
	
	/**
	 * Sets up all of the screens
	 * Loops through all screens stored in an ArrayList and sets them up with their own setup method
	 */
	public void setup() {
		for(Screen s : screens) {
			s.setup();
		}
	}
	
	/**
	 * method for displaying things on the Processing window
	 */
	public void draw() {
		ratioX = (float)width/activeScreen.DRAWING_WIDTH;
		ratioY = (float)height/activeScreen.DRAWING_HEIGHT;
	//	once again, ratio dynamics don't appear to be needed.
	//	preserved them here in comment form if we need them down the line.

		push();
		
		
		scale(ratioX, ratioY);
		
		activeScreen.draw();
		
		pop();
	}
	
	/**
	 * Method for handling selection of options in difficulty drop down menu on splash screen. Sends selection result of dropdown menu to GameMap class to set difficulty.
	 * @param list The dropdown list
	 * @param event The specific interaction with the drop down list
	 */
	public void handleDropListEvents(GDropList list, GEvent event) {
		System.out.println("DIFFICULTY SET TO: " + list.getSelectedText());
		if(list.getSelectedText().equals("Easy")) {
			gameDifficulty = true;
		}
		if(list.getSelectedText().equals("Hard")) {
			gameDifficulty = false;
		}
	}
	
	/**
	 * Method for handling clicking of buttons on the splash screen.\nClicking the Controls button will bring up a pop up window, while clicking the Play button will start the game.
	 * @param button The specific button in question
	 * @param event The specific interaction with said button
	 */
	public void handleButtonEvents(GButton button, GEvent event) {
		if(button == buttonVar.getControlB() && event == GEvent.CLICKED) {
			JOptionPane.showMessageDialog(null, "CONTROLS:\n" + "- Use the arrow keys to move the sprite\n"
					+ "- To interact with chests, press the spacebar when you are touching it.\n---> Enter the response to the riddle when prompted.\n"
					+ "- Stuck on a riddle? No worries! You can get a hint to that specific riddle by typing \"hint\" into the textbox and clicking \"OK\".\n"
					+ "---> However, you think it'd be that easy? Once you get a hint, you have to remember what that hint will correspond to, as the chest will populate with a new riddle after the hint!\n"
					+ "---> Oh, also 30 seconds will be added to your total elapsed time after taking the hint. I know, this is tough, but life's tough.\n"
					+ "- Press the Esc key at any time to pause the game.\n"
					+ "- Head to the gate once you think you have enough keys.\n\n"
					+ "Playing this game during demo time in class and have some questions? Call either Tapish, Byron, or Luke to help, we'd be happy to answer questions.");
		}
		else if(button == buttonVar.getStButton() && event == GEvent.CLICKED) {
			buttonVar.setButtonVis(false);
			buttonVar.setMenuVis(false);
			switchScreen(1);
			timerVar.setCurrentTime(System.currentTimeMillis());
		}
	}
	
	/**
	 * Method that is called when a key is pressed
	 */
	public void keyPressed() {
		keyInputs.add(keyCode);
		if(key == ESC) {
			key = 0;
		}
		if(activeScreen == screens.get(1)) {
			activeScreen.keyPressed();
		}
		
	}
	
	
	/**
	 * Method that is called when a key is released
	 */
	public void keyReleased() {
		while(keyInputs.contains(keyCode))
			keyInputs.remove(new Integer(keyCode));
	}
	
	/**
	 * Method for checking whether a key is still pressed
	 * @param code the code of the key pressed
	 * @return Whether or not the key is still pressed
	 */
	public boolean isPressed(Integer code) {
		return keyInputs.contains(code);
	}
}
