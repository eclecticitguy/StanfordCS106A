/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

	public void run() {
		while (frontIsClear()) {
			ascend();
			decend();
			moveFour();
		}
		ascend();
		decend();
	}		
	
	private void checkBeeper() {
		if (noBeepersPresent()) {
			putBeeper();
		}
	}
	
	private void ascend() {
		turnLeft();
		while (frontIsClear()) {
			checkBeeper();
			move();
		}
		checkBeeper();
	}
	
	private void decend() {
		turnRight();
		turnRight();
		while (frontIsClear()) {
			move();
		}
		turnLeft();
	}
	
	private void moveFour() {
		for (int i=0; i<4; i++)
			if (frontIsClear()) {
				move();
			}
	}

}