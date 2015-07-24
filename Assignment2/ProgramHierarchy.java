/*
 * File: ProgramHierarchy.java
 * Name: 
 * Section Leader: 
 * ---------------------------
 * This file is the starter file for the ProgramHierarchy problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class ProgramHierarchy extends GraphicsProgram {	
	
	private static final double BOX_HEIGHT = 60;
	private static final double BOX_WIDTH = 150;
	
	private double x;
	private double y;
	private double twoSpacesHorizontal;
	private double threeSpacesHorizontal;
	private double twoSpacesVertical;
	private double halfBoxHeight;
	private double halfBoxWidth;
	private double doubleBoxWidth;
	
	public void run() {
		draw();
	}
	
	private void draw () {
		/* The calculations x and y effectively divide the screen into quadrants.  X takes the screen width and subtracts the value of 3 box widths to determine the amount of 
		   screen size used horizontally by the 3 boxes.  The remaining free space is divided by 4 to find the equal amount of space needed on the outside of each box, as well as 
		   between the boxes.  Y does the same calculation with the vertical space for two boxes and divides the remaining free space by 3.  
		   Example:
		   Screen Size = 800
		   Box Width = 120 (As set by class constant)
		   Used horizontal space = 3 * 120 = 360
		   Free horizontal space = 800 - 360 = 440
		   Equal free-space between each box = 440 / (3 boxes + 1 for fence-post problem) = 110
		   If re-assembled at the second row that contains the 3 boxes, this would look like:
		   Free-Space + Box_Width + Free-Space + Box_Width + Free-Space + Box_Width + Free-Space or
		   110 + 120 + 110 + 120 + 110 + 120 + 110 = 800 (Original screen size)
		 */
		x = ((getWidth() - (3 * BOX_WIDTH)) / 4);
		y = ((getHeight() - (2 * BOX_HEIGHT)) / 3);
		twoSpacesHorizontal = (2 * x);
		threeSpacesHorizontal = (3 * x);
		twoSpacesVertical = (2 * y);
		halfBoxHeight = BOX_HEIGHT / 2;
		halfBoxWidth = BOX_WIDTH / 2;
		doubleBoxWidth = BOX_WIDTH * 2;
		
		drawBox();
		drawLine();
		drawLabel();
	}
	
	private void drawBox() {
		GRect programBox = new GRect(twoSpacesHorizontal + BOX_WIDTH, y, BOX_WIDTH, BOX_HEIGHT);
		GRect graphicsBox = new GRect(x, twoSpacesVertical + halfBoxHeight, BOX_WIDTH, BOX_HEIGHT);
		GRect consoleBox = new GRect(twoSpacesHorizontal + BOX_WIDTH, twoSpacesVertical + halfBoxHeight, BOX_WIDTH, BOX_HEIGHT);
		GRect dialogBox = new GRect(threeSpacesHorizontal + doubleBoxWidth, twoSpacesVertical + halfBoxHeight, BOX_WIDTH, BOX_HEIGHT);
		
		add(programBox);
		add(graphicsBox);
		add(consoleBox);
		add(dialogBox);
	}

	private void drawLine () {
		GLine graphicsLine = new GLine(x + (halfBoxWidth), twoSpacesVertical + (halfBoxHeight), twoSpacesHorizontal + BOX_WIDTH + (halfBoxWidth), y + BOX_HEIGHT);
		GLine consoleLine = new GLine(twoSpacesHorizontal + BOX_WIDTH + (halfBoxWidth), twoSpacesVertical + (halfBoxHeight), twoSpacesHorizontal + BOX_WIDTH + (halfBoxWidth), y + BOX_HEIGHT);
		GLine dialogLine = new GLine(threeSpacesHorizontal + doubleBoxWidth + (halfBoxWidth), twoSpacesVertical + (halfBoxHeight), twoSpacesHorizontal + BOX_WIDTH + (halfBoxWidth), y + BOX_HEIGHT);
		
		add(graphicsLine);
		add(consoleLine);
		add(dialogLine);
	}
	
	private void drawLabel() {
		GLabel programLabel = new GLabel("Program");
		GLabel graphicsLabel = new GLabel("GraphicsProgram");
		GLabel consoleLabel = new GLabel("ConsoleProgram");
		GLabel dialogLabel = new GLabel("DialogProgram");
		
		programLabel.setFont("SansSerif-14");
		graphicsLabel.setFont("SansSerif-14");
		consoleLabel.setFont("SansSerif-14");
		dialogLabel.setFont("SansSerif-14");
		
		double progWidth = programLabel.getWidth();
		double graphWidth = graphicsLabel.getWidth();
		double conWidth = consoleLabel.getWidth();
		double dialWidth = dialogLabel.getWidth();
		
		double progHeight = programLabel.getAscent();
		double graphHeight = graphicsLabel.getAscent();
		double conHeight = consoleLabel.getAscent();
		double dialHeight = dialogLabel.getAscent();
		
		programLabel.setLocation(twoSpacesHorizontal + BOX_WIDTH + ((BOX_WIDTH - progWidth) / 2), y + halfBoxHeight + (progHeight / 2));
		graphicsLabel.setLocation(x + ((BOX_WIDTH - graphWidth) / 2), twoSpacesVertical + BOX_HEIGHT + (graphHeight / 2));
		consoleLabel.setLocation(twoSpacesHorizontal + BOX_WIDTH + ((BOX_WIDTH - conWidth) / 2), twoSpacesVertical + BOX_HEIGHT + (conHeight / 2));
		dialogLabel.setLocation(threeSpacesHorizontal + doubleBoxWidth + ((BOX_WIDTH - dialWidth) / 2), twoSpacesVertical + BOX_HEIGHT + (dialHeight / 2));
		
		add(programLabel);
		add(graphicsLabel);
		add(consoleLabel);
		add(dialogLabel);
	}
}

