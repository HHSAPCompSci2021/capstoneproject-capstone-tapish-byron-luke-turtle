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
 * @author Byron Tam, Tapish Singh(Mr. Shelby's collision method)
 */
public abstract class Sprite {

	private int x, y, width, height;
	private PImage pimage;
	private Image image;
	
	/**
	 * This creates a sprite at a specified place in the coordinate grid and places it facing a certain direction.
	 * @param x the x-coordinate of the sprite
	 * @param y the y-coordinate of the sprite
	 */
	public Sprite(String img, int x, int y, int width, int height) {
		image = (new ImageIcon(img)).getImage();
		pimage = new PImage(image);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	
	/**
	 * Method for determining whether two sprites are colliding
	 * @param other the other sprite you want to check collision with
	 * @return boolean variable for whether or not they are colliding
	 */
	public boolean doesRectangleSpriteCollide(Sprite other) {
		return (new Rectangle(x,y,width,height)).intersects(new Rectangle(other.x,other.y,other.width,other.height));
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
	
	public void setImage(String img) {
		image = (new ImageIcon(img)).getImage();
		pimage = new PImage(image);
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
		g.image(pimage, x, y, width, height);
	}
}
