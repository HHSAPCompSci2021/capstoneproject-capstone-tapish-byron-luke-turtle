package core;
import java.util.*;
import java.awt.*;
import screens.SplashScreen;
import screens.GameScreen;
import screens.ScreenSwitcher;
import screens.FinishScreen;
import screens.Screen;

import processing.core.*;

/**
 * 
 * @author Tapish Singh
 * This is the main class for the Processing drawing utlility
 * @version 5/6/22
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
	
	// no args const.
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
	}

	/**
	 * Switches to a different screen based on parameter passed through
	 * @param i the screen number you want to switch to
	 */
	public void switchScreen(int i) {
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
	
	public boolean isPressed(Integer code) {
		return keyInputs.contains(code);
	}
}
