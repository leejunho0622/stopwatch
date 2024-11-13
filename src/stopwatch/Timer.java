package stopwatch;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Timer extends Thread{
	private Calendar cal = Calendar.getInstance();
	private SimpleDateFormat watch = new SimpleDateFormat("kk:mm:ss");
	private StringBuilder buffer = new StringBuilder();
	private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private int hour;
	private int minute;
	private int second;
	
	protected void timeStop() {
		
	}
	
	protected void timeHold() {
		
	}
	
	protected void timeReRun() {
		
	}
	
	protected void calculateTime() {
		if(second == 60) {
			second = 0;
			minute++;
		}
		if(minute == 60) {
			minute = 0;
			hour++;
		}
			
		if(hour > 0)
			buffer.append(hour+"h ");
		if(minute > 0) 
			buffer.append(minute+"m ");
		if(second > 0) 
			buffer.append(second+"s");
	}
	
	protected void nowTime() {
		calculateTime();
		
		String time = watch.format(cal.getTime());
		
		buffer.append(time+" ["+buffer.toString()+"]");
		
		try {
			writer.append(buffer);
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
