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
		
		SplashScreen screen1 = new SplashScreen();
		GameScreen screen2 = new GameScreen();
		FinishScreen screen3 = new FinishScreen();
		
		screens.add(screen1);
		screens.add(screen2);
		screens.add(screen3);
		
		activeScreen = screens.get(0);
	}

	@Override
	public void switchScreen(int i) {
		// TODO Auto-generated method stub
		
	}
	
}
