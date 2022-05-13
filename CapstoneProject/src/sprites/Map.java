package sprites;

/**
 * This represents the map storing the obstacles and chests. 
 */
public class Map {
	private int room [][] = new int[3][3];
	//true for easy, false for hard
	private boolean difficulty;
	
	public Map(boolean diff) {
		difficulty = diff;
	}
	
	
}
