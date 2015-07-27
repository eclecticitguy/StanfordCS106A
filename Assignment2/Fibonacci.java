import acm.program.ConsoleProgram;

public class Fibonacci extends ConsoleProgram {
	
	// Define the maximum number to compute
	private static final double MAX_TERM_VALUE = 10000;
	
	public void run() {
		int a = 0;
		int b = 1;
		println("This program lists the Fibonacci sequence.");
		while (a < MAX_TERM_VALUE) {
			println(a);
			a = a + b;
			// This break is required in case the Fibonacci sequence 
			// exceeds the MAX_TERM_VALUE before the end of the while loop
			if (b > MAX_TERM_VALUE) break;
			println(b);
			b = b + a;
		}
	}
}