package stopwatch;

public class Stopwatch {
	private static Stopwatch instance = new Stopwatch();
	private Stopwatch() {}
	public static Stopwatch getInstance() {
		return instance;
	}
}
