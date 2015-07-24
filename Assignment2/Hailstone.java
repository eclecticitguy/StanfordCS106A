/*
 * File: Hailstone.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	public void run() {
		int count = 0;
		int n = readInt("Enter a positive number: ");
		while (n <= 0) {
			n = readInt("Your number has to be a positive integer, please re-input number: ");
		}
		while (n != 1) {
			if (n % 2 == 0) {
				println (n + " is even, so I take half:  " + (n /= 2));
				count++;
			} else {
				println (n + " is odd, so I make 3n+1:  " + (n = (n * 3) + 1));
				count++;
			}
		}
		println ("The process took " + count + " steps to reach 1");
	}
}

