package stopwatch;

// Release v1.0.0
public class Main {
	public static void main(String[] args) {
		DoubleThread stopwatch = DoubleThread.getInstance();
		stopwatch.run();
	}
}