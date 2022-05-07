package core;

// import java.awt.Dimension;
/*
 * COMMAND FOR JAVADOCS (copy and paste safe)
 * javadoc -author -version -tag pre:cm:"Precondition:" -tag post:cm:"Postcondition:" -d doc -classpath ./lib/* -sourcepath ./src/ <PACKAGE NAME>
 * 
 * COMMAND FOR JARS (copy and paste safe)
 * jar cvf testing.jar core screens sprites
 * NOTE: jar packaging continues w/o error, but it doesn't appear to run as jar, even with eclipse main method working
 */

import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

/**
 * This is the main runner class for this project
 * @author Tapish Singh
 * @version 5/6/22
 *
 */
public class Main {

	/**
	 * Main method for the project. Opens up the splash screen on start up.
	 * @param args
	 */
	public static void main(String[] args) {

		// standard DrawingSurface main method found in other labs. This one is a slightly modified version of the one found in GamePhysicsDemoAP.
		// as expected, with project progression, the method below may be further modified.
		DrawingSurface drawing = new DrawingSurface();
		PApplet.runSketch(new String[]{""}, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame)canvas.getFrame();

		window.setSize(900, 700);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);

		window.setVisible(true);
		
		
		canvas.requestFocus();
	}

}
