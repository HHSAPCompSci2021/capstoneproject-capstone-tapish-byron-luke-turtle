package sprites;

import java.awt.Image;
import java.util.ArrayList;

import screens.Screen;

/**
 * This represents the main objective of the game, the gate that requires a certain amount of keys in order to be opened.
 * @version 5/23/22
 */
public class Gate extends Sprite{
	
	/**
	 * This creates the gate that is preventing the turtle from escaping to the outside world.
	 * @param x the x-coordinate of the gate 
	 * @param y the y-coordinate of the gate
	 * @param width the width of the gate
	 * @param heigh the height of the gate
	 */
	public Gate(int x, int y, int width, int height) {
		super("img/door.png", x, y, width, height);
	}
	
}
