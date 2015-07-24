/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	
	private static final int SENTINEL = 0;
	
	public void run() {
		println("This program finds the largest and smallest numbers.");
		int smallest = SENTINEL;
		int biggest = SENTINEL;
		int input = SENTINEL;
		input = readInt("Enter a value: ");
		while (input != SENTINEL) {
				if (input > biggest) biggest = input;
				if (input < smallest) smallest = input;
				input = readInt("Enter a value: ");
				}
		if ((input == smallest) && (input == biggest)) {
			println ("You didn't enter any values, exiting");
		} else {
			println("Biggest number: " + biggest);
			println("Smallest number: " + smallest);
		}
	}
}

