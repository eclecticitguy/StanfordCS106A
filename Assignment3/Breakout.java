/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;

import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;

/** The last mouse position */
	private double mX;
	
/** Paddle constant to use in multiple methods */
	private GRect paddle;
	

/* Method: run() */
/** Runs the Breakout program. */
	public void run() {
		setupBoard();
		addPaddle();
		addMouseListeners();
	}
	
	public void setupBoard() {
		int y = BRICK_Y_OFFSET;
		for (int i = 1; i <= NBRICK_ROWS; i++) {
			int x = ((NBRICKS_PER_ROW * BRICK_WIDTH) + (NBRICKS_PER_ROW * BRICK_SEP + BRICK_SEP) - WIDTH) / 2;
			for (int j = 1; j <= NBRICKS_PER_ROW; j++) {
				GRect brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
				if (i == 1 || i == 2) {
					brick.setColor(Color.red);
					brick.setFilled(true);
				} else if (i == 3 || i == 4) {
					brick.setColor(Color.orange);
					brick.setFilled(true);
				} else if (i == 5 || i == 6) {
					brick.setColor(Color.yellow);
					brick.setFilled(true);
				} else if (i == 7 || i == 8) {
					brick.setColor(Color.green);
					brick.setFilled(true);
				} else {
					brick.setColor(Color.cyan);
					brick.setFilled(true);
				}
				add(brick);
				x += (BRICK_WIDTH + BRICK_SEP); 
			}
			y += (BRICK_HEIGHT + BRICK_SEP);
		}
	}
	
	public void addPaddle() {
		paddle = new GRect(mX, HEIGHT - PADDLE_Y_OFFSET, PADDLE_WIDTH, PADDLE_HEIGHT);
		paddle.setFilled(true);
		add(paddle);
	}
	
	public void mouseMoved(MouseEvent e) {
        mX = e.getX();
        // Determine whether current position of cursor and width of paddle would be longer than screen width
        // If not, set X position of paddle the same as the cursor
        if (mX + PADDLE_WIDTH <= WIDTH) {
        	paddle.setLocation(mX, HEIGHT - PADDLE_Y_OFFSET);
        // Otherwise, set X position of the paddle to the furthest right it can go without going off the screen
        } else {
        	paddle.setLocation(WIDTH - PADDLE_WIDTH, HEIGHT - PADDLE_Y_OFFSET);
        }
    }
	
}
