package stopwatch;

import java.util.Scanner;

public class Stopwatch{
	private Scanner scan = new Scanner(System.in);
	private static Stopwatch instance = new Stopwatch();
	
	private Stopwatch() {}
	public static Stopwatch getInstance() {
		return instance;
	}
	
	private void printMain() {
		System.err.println("[q] STOP");
		System.err.println("[h] HOLD");
		System.err.println("[*] RERUN");
		option(scan.nextLine().charAt(0));
	}
	
	private void option(char select) {
		if(select == 'q') {
			stop();
		}else if(select == 'h') {
			hold();
		}else if(select == '*') {
			reRun();
		}
	}
	
	public void run() {
		printMain();
	}
}
