/*
 * File: democracyKarel
 * ----------------------------
 */

import stanford.karel.*;

public class democracyKarel extends SuperKarel {

	public void run() {
		move();
		while (frontIsClear()) {
			moveKarel();
			if (frontIsClear()) {
				checkBallot();
			}
		}
	}

	private void moveKarel() {
		moveIfClear();
		moveIfClear();
	}
	
	private void checkBallot() {
		if (noBeepersPresent()) {
			fixBallot();
		}
	}
	
	private void fixBallot() {
		turnLeft();
		move();
		turnAround();
		removeChad();
		returnHome();
		}
	
	private void removeChad() {
		while (frontIsClear()) {
			if (beepersPresent()) {
				while (beepersPresent()) {
					pickBeeper();
				}
			}
			move();
			}
		if (beepersPresent()) {
			while (beepersPresent()) {
				pickBeeper();
			}
		}
	}
	
	private void returnHome() {
		turnAround();
		move();
		turnRight();
	}
	
	private void moveIfClear() {
		if (frontIsClear()) {
			move();
		}
	}
}