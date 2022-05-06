package core;
import java.util.*;
import java.awt.*;
import screens.SplashScreen;
import screens.GameScreen;
import screens.ScreenSwitcher;
import screens.FinishScreen;
import screens.Screen;

import processing.core.*;

public class DrawingSurface extends PApplet implements ScreenSwitcher {
	
	public float ratioX, ratioY;
	
	private ArrayList<Integer> keyInputs;
	
	private Screen activeScreen;
	private ArrayList<Screen> screens;
	
	// no args const.
	public DrawingSurface() {
		screens = new ArrayList<Screen>();
		keyInputs = new ArrayList<Integer>();
		
		SplashScreen screen1 = new SplashScreen(this);
		GameScreen screen2 = new GameScreen(this);
		FinishScreen screen3 = new FinishScreen(this);
		
		screens.add(screen1);
		screens.add(screen2);
		screens.add(screen3);
		
		activeScreen = screens.get(0);
	}

	@Override
	public void switchScreen(int i) {
		activeScreen = screens.get(i);
	}
	
	public void setup() {
		for(Screen s : screens) {
			s.setup();
		}
	}
	
	public void draw() {
		ratioX = (float)width/activeScreen.DRAWING_WIDTH;
		ratioY = (float)height/activeScreen.DRAWING_HEIGHT;

		push();
		
		scale(ratioX, ratioY);
		
		activeScreen.draw();
		
		pop();
	}
	
	public void keyPressed() {
		
	}
	
	public void keyReleased() {
		
	}
}
