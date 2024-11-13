package stopwatch;

import java.util.Scanner;

public class Stopwatch extends Timer{
	private Scanner scan = new Scanner(System.in);
	private DoubleThread stopwatch = DoubleThread.getInstance();
	
	private boolean isRun = true;
	
	private void printMain() {
		System.err.println("[q] STOP");
		System.err.println("[h] HOLD");
		System.err.println("[a] RERUN");
	}
	
	private void option(char select) {
		try {
			if (select == 'q') {
				Thread.sleep(100);
				stopwatch.thread1.interrupt();
				stopwatch.thread2.interrupt();
				printEnd();
			} else if (select == 'h') {

			} else if (select == 'a') {

			}
		} catch (Exception e) {
			isRun = false;
		}
	}
	
	public void printEnd() {
		System.out.println(">> "+ endTime+ "소요됨");
		
	}
	
	public void run() {
		printMain();
		while(isRun) {
			option(scan.nextLine().charAt(0));
		}
	}
}
