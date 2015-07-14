/*
 * File: Pyramid.java
 * Name: 
 * Section Leader: 
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Pyramid extends GraphicsProgram {

/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

/** Width of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;

/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 14;
	
	public void run() {
				drawRow();
			}
	
	// Method to calculate row position of Triangle
	private void drawRow() {
		// Set Y to the height of the screen
		int y = getHeight();
		
		// Starting at the bottom row of triangle, iterate from MAX (BRICK_IN_BASE) to MIN (1)
		for (int i = BRICKS_IN_BASE; i >= 1; i--) {
			// Reduce Y coordinate by BRICK_HEIGHT, otherwise bricks will start off bottom of screen
			y -= BRICK_HEIGHT;
			// Call drawRow method using number of bricks(i) and row height(y) as arguments
			drawBlocks(i, y);
		}
	}
	
	// Method to draw bricks
	private void drawBlocks(int numBlocks, int y) {
		/* Calculate half width of screen minus half the total width of bricks
		   If screen is 800, half the screen is 400
		   If total bricks is 14 and width is 30, total width is 420 and halved is 210
		   Start X coordinate at 400 - 210, or 190
		   Starting value of 190 + total width of 420 = Ending value of 610
		   Total screen of 800 - ending value 610 = 190 remaining, or the same value as starting X coordinate
		 */
		int x = (getWidth() / 2) - ((numBlocks * BRICK_WIDTH) / 2);
		
		// Starting at last brick for particular row, iterate by reducing to one brick per row
		for (int i = numBlocks; i >= 1; i--) {
			// Construct Rectangle using calculated X and Y coordinates, along with WIDTH and HEIGHT constants
			GRect block = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
			add(block);
			// Increase X coordinate by the width of brick before starting next iteration
			x += BRICK_WIDTH;
		}
	}
}

