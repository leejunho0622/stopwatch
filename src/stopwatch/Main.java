package stopwatch;

public class Main {
	public static void main(String[] args) {
		DoubleThread stopwatch = DoubleThread.getInstance();
		stopwatch.run();
	}
}