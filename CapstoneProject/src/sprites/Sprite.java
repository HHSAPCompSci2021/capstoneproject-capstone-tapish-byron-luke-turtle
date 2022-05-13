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
	
	public void applyWindowLimits(int windowWidth, int windowHeight) {
		x = Math.min(x,windowWidth-width);
		y = Math.min(y,windowHeight-height);
		x = Math.max(0,x);
		y = Math.max(0,y);
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		 this.y = y;
	}
	 
	public int getDirection() {
		return facingDirection;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void draw(PApplet g, int x, int y, int width, int height) {
		g.image(new PImage(image), x, y, width, height);
	}
}
