package stopwatch;

import java.util.Scanner;

public class Stopwatch extends Timer {
	private Scanner scan = new Scanner(System.in);
	private DoubleThread stopwatch = DoubleThread.getInstance();

	private boolean isRun = true;

	private void printMain() {
		System.err.println("[q] STOP");
		System.err.println("[h] HOLD");
		System.err.println("[a] RERUN");
	}

	private void option(char select) {
		if (select == 'q' && holding) {
			isRun = false;
			stopwatch.thread1.interrupt();
			stopwatch.thread2.interrupt();
			printEnd();
		} else if (select == 'h')
			holding = false;
		else if (select == 'a')
			holding = true;
	}

	public void printEnd() {
		System.out.println(">> " + endTime + " 소요됨");
	}

	public void run() {
		printMain();
		while (isRun) {
			String input = scan.nextLine();
			if (input.equals(""))
				continue;
			option(input.charAt(0));
		}
	}
}
