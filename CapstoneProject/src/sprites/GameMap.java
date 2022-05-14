package sprites;

/**
 * This represents the map storing the obstacles and chests. 
 * @author Byron Tam, Tapish Singh
 * @version 5/14/22
 */
public class GameMap {
	private int room [][] = new int[3][3];
	//true for easy, false for hard
	private static boolean difficulty;
	
	/**
	 * constructor for creating the map. Sets the difficulty upon instantiation (true = easy, false = hard)
	 * @param diff difficulty
	 */
	public GameMap(boolean diff) {
		difficulty = diff;
	}
	
	/**
	 * Method for setting the difficulty (true = easy, false = hard)
	 * @param diff difficulty
	 */
	public void setMapDiff(boolean diff) {
		difficulty = diff;
	}
	
	
}
