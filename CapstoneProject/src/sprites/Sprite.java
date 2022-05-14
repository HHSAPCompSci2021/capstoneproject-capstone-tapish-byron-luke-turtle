package sprites;

import java.awt.Color;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import javax.swing.*;
import core.DrawingSurface;

import javax.swing.ImageIcon;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class represents a default sprite.
 * @version 5/6/22
 * @author Byron Tam, Tapish Singh
 */
public abstract class Sprite {

	private int x, y, width, height;
	private int facingDirection;
	private Image image;
	
	public final static int FACE_RIGHT = 0;
	public final static int FACE_LEFT = 1;
	public final static int NOTAPPLICABLE = 2;
	
	/**
	 * This creates a sprite at a specified place in the coordinate grid and places it facing a certain direction.
	 * @param x the x-coordinate of the sprite
	 * @param y the y-coordinate of the sprite
	 * @param facingDir the initial direction the sprite faces when spawned
	 */
	public Sprite(String img, int x, int y, int width, int height, int facingDir) {
		image = (new ImageIcon(img)).getImage();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		facingDirection = facingDir;
	}
	
	/**
	 * Method for determining whether two sprites are colliding
	 * @param other the other sprite you want to check collision with
	 * @return boolean variable for whether or not they are colliding
	 */
	public boolean doesSpritePixelsCollide(Sprite other) {
		BufferedImage pic = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB); // Make a new image that I can draw on
		Graphics g = pic.getGraphics(); // This Graphics will draw on to the image
		g.setColor(Color.WHITE); 
		g.fillRect(0, 0, pic.getWidth(), pic.getHeight()); // Make the whole image white
		g.drawImage(image,0,0,width,height,null);
		
		int overlapLeft = Math.max(x, other.x); // Find the rectangle of space in which the 2 sprite images overlap with each other
		int overlapTop = Math.max(y, other.y);
		int overlapRight = Math.min(other.width+other.x+10, width+x+10);
		int overlapBottom = Math.min(height+y, other.height+other.y);
		
		for (int i = overlapLeft; i < overlapRight; i++ ) {   // Look at every pixel coordinate in the rectangle
			for (int j = overlapTop; j < overlapBottom; j++ ) {
				if (pic.getRGB(i-x, j-y) != Color.WHITE.getRGB()) {  // If that pixel is not white (you can also look for a specific color instead of any non-white pixel)
					return true;  // There was a collision!
				}
			}  
		}
		
		return false;
	}
	
	/**
	 * Method for setting window limits for movement
	 * @param windowWidth max width sprite can move to
	 * @param windowHeight max height sprite can move to
	 */
	public void applyWindowLimits(int windowWidth, int windowHeight) {
		x = Math.min(x,windowWidth-width);
		y = Math.min(y,windowHeight-height);
		x = Math.max(0,x);
		y = Math.max(0,y);
	}
	
	/**
	 * returns x coordinate of sprite
	 * @return x coordinate of sprite
	 */
	public int getX() {
		return x;
	}

	/**
	 * returns y coordinate of sprite
	 * @return y coordinate of sprite
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * sets the x coordinate of sprite
	 * @param x the x coordinate you want to set the sprite to
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * sets the y coordinate of sprite
	 * @param y the y coordinate you want to set the sprite to
	 */
	public void setY(int y) {
		 this.y = y;
	}
	 
	/**
	 * returns the direction the sprite is facing
	 * @return the direction the sprite is facing
	 */
	public int getDirection() {
		return facingDirection;
	}
	
	/**
	 * returns the width of the sprite
	 * @return the width of the sprite
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * returns the height of the sprite
	 * @return the height of the sprite
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Method for displaying the image of the sprite on the processing window/screen
	 * @param g the PApplet stuff is drawn upon
	 * @param x x coord of imaage
	 * @param y y coord of image
	 * @param width width of the image
	 * @param height height of the image
	 */
	public void draw(PApplet g, int x, int y, int width, int height) {
		g.image(new PImage(image), x, y, width, height);
	}
}
