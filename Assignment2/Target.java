/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {
	
	public void run() {
		firstCircle();
		secondCircle();
		thirdCircle();
	}

	private void firstCircle() {
		double radius = 72;
		double x = (getWidth() / 2) - (radius / 2);
		double y = (getHeight() / 2) - (radius / 2);
		GOval circle = new GOval(x, y, radius, radius);
		circle.setColor(Color.red);
		circle.setFilled(true);
		add(circle);
	}
	
	private void secondCircle() {
		double radius = .65 * 72;
		double x = (getWidth() / 2) - (radius / 2);
		double y = (getHeight() / 2) - (radius / 2);
		GOval circle = new GOval(x, y, radius, radius);
		circle.setColor(Color.white);
		circle.setFilled(true);
		add(circle);
	}
	
	private void thirdCircle() {
		double radius = .3 * 72;
		double x = (getWidth() / 2) - (radius / 2);
		double y = (getHeight() / 2) - (radius / 2);
		GOval circle = new GOval(x, y, radius, radius);
		circle.setColor(Color.red);
		circle.setFilled(true);
		add(circle);
	}
}
