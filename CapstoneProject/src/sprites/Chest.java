package sprites;

/**
 * This class represents the chests the character can interact with to answer riddles.
 * @version 5/6/22
 */
public class Chest extends Sprite {
	private RiddleBank riddle;
	
	/**
	 * This creates a chest at the specified place in the coordinate grid and places it facing a certain direction.
	 * @param x the x-coordinate of the sprite
	 * @param y the y-coordinate of the sprite
	 */
	public Chest(double x, double y) {
		super(x, y, 2);
	}
	
	/**
	 * Chooses a riddle out of the riddle bank
	 * @param num the number for the riddle chosen(riddles are numbered)
	 */
	public void chooseRiddle(int num) {
		riddle = new RiddleBank(num);
	}
}
