package core;
import java.util.*;

import javax.swing.JOptionPane;

import g4p_controls.*;
import g4p_controls.GDropList;
import g4p_controls.GEvent;

import java.awt.*;
import screens.SplashScreen;
import sprites.GameMap;
import sprites.Turtle;
import screens.GameScreen;
import screens.ScreenSwitcher;
import screens.FinishScreen;
import screens.Screen;

import processing.core.*;

/**
 * 
 * @author Tapish Singh
 * This is the main class for the Processing drawing utlility
 * @version 5/14/22
 */
public class DrawingSurface extends PApplet implements ScreenSwitcher {
	/*
	 * ratioX and ratioY found in gamePhysDemoAP lab and implemented in the draw method
	 * but looked up scale method and found it changes scale of shape?
	 * doesn't seem to be needed in this project
	 * */
	public float ratioX, ratioY;
	
	private ArrayList<Integer> keyInputs;
	
	private Screen activeScreen;
	private ArrayList<Screen> screens;
	// need this for G4P stuff
	private SplashScreen buttonVar;
	
	
	private GameMap diffVar = new GameMap(true);
	private GameScreen timerVar;
	
	
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
		
		screens.add(screen1);
		screens.add(screen2);
		screens.add(screen3);
		
		activeScreen = screens.get(0);
		buttonVar = screen1;
		timerVar = screen2;
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
		System.out.println("Item selected:" + list.getSelectedText());
		if(list.getSelectedText().equals("Easy")) 
			diffVar.setMapDiff(true);
		if(list.getSelectedText().equals("Hard"))
			diffVar.setMapDiff(false);
	}
	
	/**
	 * Method for handling clicking of buttons on the splash screen.\nClicking the Controls button will bring up a pop up window, while clicking the Play button will start the game.
	 * @param button The specific button in question
	 * @param event The specific interaction with said button
	 */
	public void handleButtonEvents(GButton button, GEvent event) {
		if(button == buttonVar.getControlB() && event == GEvent.CLICKED) {
			JOptionPane.showMessageDialog(null, "CONTROLS:\n" + "- Use the arrow keys to move the sprite\n"
					+ "- To interact with chests, press the spacebar when you are in its vicinity.\nEnter the response to the riddle when prompted.\n"
					+ "- Press the Esc key at any time to pause the game.\n\n"
					+ "BETA RELEASE NOTE: the guy who does this GUI is separate from the gameplay people.\n"
					+ "so if you wanna see the final victory screen as described in the readme, press the\n"
					+ "number 3 key to bring up the victory screen when you are on the gameplay screen.\n"
					+ "the gameplay screen's j a green screen as a placeholder at the moment.");
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
		if(key == ESC) 
			key = 0;
		
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
