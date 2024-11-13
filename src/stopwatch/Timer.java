package stopwatch;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Timer extends Thread{
	private Calendar cal = Calendar.getInstance();
	private SimpleDateFormat watch = new SimpleDateFormat("kk:mm:ss");
	private StringBuilder buffer = new StringBuilder();
	
	private int hour;
	private int minute;
	private int second;
	
	protected void timeStop() {
		
	}
	
	protected void timeHold() {
		
	}
	
	protected void timeReRun() {
		
	}
	
	protected void nowTime() {
		String time = watch.format(cal.getTime());
	}
}
