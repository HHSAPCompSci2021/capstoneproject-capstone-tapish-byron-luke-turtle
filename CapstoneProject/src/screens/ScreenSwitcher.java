package screens;
/**
 * 
 * @author Tapish Singh
 * @version 5/10/22
 * Interface for switching screens
 */
public interface ScreenSwitcher {
	public static final int SPLASH_S = 0;
	public static final int GAME_S = 1;
	public static final int VICTORY_S = 2;
	
	/**
	 * Switches the screen shown to the user
	 * @param i number of the screen 
	 */
	public void switchScreen(int i);
	
	
	
}
