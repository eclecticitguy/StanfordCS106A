/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	public void run() {
		putBeeper();
		checkVerticalWall();
		while (frontIsClear()) {
			checkEast();
			checkWest();
		}
	}
	
	private void checkEast() {
		while (facingEast()) {
			move();
			if (frontIsClear()) {
				move();
				putBeeper();
			}
		upEast();
		
		}
	}
	
	private void checkWest() {
		while (facingWest()) {
			move();
			if (frontIsClear()) {
				move();
				putBeeper();
			}
		upWest();
		
		}
	}
	
	private void upEast() {
		if (frontIsBlocked()) {
			if (beepersPresent()) {
				turnLeft();
				if (frontIsClear()) {
					move();
					turnLeft();
					move();
					putBeeper();
				}
			} else {
				turnLeft();
				if (frontIsClear()) {
					move();
					turnLeft();
					putBeeper();
				}
			}
		}
	}
	
	private void upWest() {
		if (frontIsBlocked()) {
			if (beepersPresent()) {
				turnRight();
				if (frontIsClear()) {
					move();
					turnRight();
					move();
					putBeeper();
				}
			} else {
				turnRight();
				if (frontIsClear()) {
					move();
					turnRight();
					putBeeper();
				}
			}
		}
	}
	
	private void checkVerticalWall() {
		if (frontIsBlocked()) {
			turnLeft();
			if (leftIsBlocked()) {
				while (frontIsClear()) {
					move();
					if (frontIsClear()) {
						move();
						putBeeper();
					}
				}
			}
		}
	

	}
}