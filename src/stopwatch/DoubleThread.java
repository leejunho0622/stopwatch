package stopwatch;

public class DoubleThread {
	private DoubleThread() {}
	private static DoubleThread instance = new DoubleThread();
	public static DoubleThread getInstance() {
		return instance;
	}
	
	void run() {
		Timer timer = new Timer();
		Thread thread1 = new Thread(timer);
		thread1.start();
		
		Stopwatch watch = new Stopwatch();
		Thread thread2 = new Thread(watch);
		thread2.start();
	}
}
