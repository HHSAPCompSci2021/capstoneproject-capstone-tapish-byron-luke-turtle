package screens;

public interface ScreenSwitcher {
	public static final int SPLASH_S = 0;
	public static final int GAME_S = 1;
	public static final int VICTORY_S = 2;
	
	public void switchScreen(int i);
	
}
