import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class RobotFace extends GraphicsProgram {
	
	private static final double HEAD_WIDTH = 250;
	private static final double HEAD_HEIGHT = 400;
	private static final double MOUTH_WIDTH = 175;
	private static final double MOUTH_HEIGHT = 50;
	private static final double EYE_RADIUS = 50;
	
	private double x;
	private double y;
	
	public void run() {
		drawRobot();
	}
	
	private void drawRobot() {
		// Determine center of screen based on width and height of head
		x = (getWidth() / 2) - (HEAD_WIDTH / 2);
		y = (getHeight() / 2) - (HEAD_HEIGHT / 2);
		
		drawHead();
		drawMouth();
		drawEyes();
		}
	
	private void drawHead() {
		GRect head = new GRect(x, y, HEAD_WIDTH, HEAD_HEIGHT);
		head.setFillColor(Color.GRAY);
		head.setFilled(true);
		add(head);
	}
	
	private void drawMouth() {
		double centerMouthY = ((HEAD_HEIGHT - MOUTH_HEIGHT) / 4);
		double centerMouthX = ((HEAD_WIDTH - MOUTH_WIDTH) / 2);
		GRect mouth = new GRect (x + centerMouthX, (4 * centerMouthY) - (MOUTH_HEIGHT / 2), MOUTH_WIDTH, MOUTH_HEIGHT);
		mouth.setColor(Color.WHITE);
		mouth.setFilled(true);
		add(mouth);
	}
	
	private void drawEyes() {
		double centerEyesX = HEAD_WIDTH / 4;
		double centerEyesY = HEAD_HEIGHT / 4;
		double centerEyesMiddle = EYE_RADIUS / 2;
		
		GOval leftEye = new GOval((x + centerEyesX - centerEyesMiddle), centerEyesY, EYE_RADIUS, EYE_RADIUS);
		GOval rightEye = new GOval((x + (3 * centerEyesX) - centerEyesMiddle), centerEyesY, EYE_RADIUS, EYE_RADIUS);
		
		leftEye.setColor(Color.YELLOW);
		leftEye.setFilled(true);
		rightEye.setColor(Color.YELLOW);
		rightEye.setFilled(true);
		
		add(leftEye);
		add(rightEye);
	}
}