package stopwatch;

public class DoubleThread implements Runnable{
	private DoubleThread() {}
	private static DoubleThread instance = new DoubleThread();
	public static DoubleThread getInstance() {
		return instance;
	}
	
	Thread thread1;
	Thread thread2;

	public void run() {
		Timer timer = new Timer();
		thread1 = new Thread(timer);
		thread1.start();

		Stopwatch watch = new Stopwatch();
		thread2 = new Thread(watch);
		thread2.start();
	}
}
