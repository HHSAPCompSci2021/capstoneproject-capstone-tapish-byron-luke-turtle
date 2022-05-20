package sprites;

import java.awt.Image;

/**
 * This class represents the chests the character can interact with to answer riddles.
 * @version 5/14/22
 */
public class Chest extends Sprite {
	private RiddleBank riddle;
	boolean hasAnswered;
	
	/**
	 * This creates a chest at the specified place in the coordinate grid and places it facing a certain direction.
	 * @param x the x-coordinate of the sprite
	 * @param y the y-coordinate of the sprite
	 */
	public Chest(int x, int y, int width, int height) {
		super("img/chest.png", x, y, width, height);
		hasAnswered = false;
	}
	

	/**
	 * sets the status of the chest, i.e. if chest has been opened, its status is changed to "true
	 * @param hasAns the boolean status of the chest you want to set
	 */
	public void ansStatus(boolean hasAns) {
		hasAnswered = hasAns;
	}
	
	/**
	 * returns the boolean status of the chest. True if it was opened, false if not
	 * @return the answered boolean status of the chest
	 */
	public boolean getStatus() {
		return hasAnswered;
	}
	
	/**
	 * Chooses a riddle out of the riddle bank
	 * @param num the number for the riddle chosen(riddles are numbered)
	 */
	public void chooseRiddle(int num) {
		int choose = (int) (Math.random()*15);
		riddle = new RiddleBank(choose);
	}
	
	/**
	 * returns the riddle object within the chest
	 * @return the specific riddle object of the chest
	 */
	public RiddleBank returnRiddle() {
		return riddle;
	}
}
