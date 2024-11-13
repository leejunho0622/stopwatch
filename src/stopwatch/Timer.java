package stopwatch;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Calendar;

public class Timer extends Thread{
	private Calendar cal = Calendar.getInstance();
	static StringBuffer timeBuffer = new StringBuffer();
	private StringBuffer buffer = new StringBuffer();
	private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private boolean isRun = true;
	static boolean holding = true;
	
	static String endTime;
	
	private String time;
	private int timeHour;
	private int timeMinute;
	private int timeSecond;
	
	private int hour;
	private int minute;
	private int second;
	
	private void setStartTime() {
		timeHour = cal.getTime().getHours();
		timeMinute = cal.getTime().getMinutes();
		timeSecond = cal.getTime().getSeconds();
	}
	
	private void calculateTime() {
		if(second == 60) {
			second = 0;
			minute++;
		}
		if(minute == 60) {
			minute = 0;
			hour++;
		}
		if(timeSecond == 60) {
			timeSecond = 0;
			timeMinute++;
		}
		if(timeMinute == 60) {
			timeMinute = 0;
			timeHour++;
		}
	}
	
	private void setTime() {
		if(hour > 0)
			timeBuffer.append(hour+"h");
		if(minute > 0) 
			timeBuffer.append(minute+"m");
		if(second > 0) 
			timeBuffer.append(second+"s");
	}
	
	private void nowTime() {
		calculateTime();
		setTime();
		
		time = String.format("%d:%d:%d", timeHour, timeMinute, timeSecond);
		buffer.append(time+" ["+timeBuffer+"]");
		
		endTime = timeBuffer.toString();
		
		try {
			writer.append(buffer+"\n");
			writer.flush();
			buffer.setLength(0);
			timeBuffer.setLength(0);
			Thread.sleep(1000);
		} catch(IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e2) {
			isRun = false;
			holding = false;
		} 
		timeSecond++;
		second++;
	}
	
	public void closeWriter() {
		try {
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		setStartTime();
		while (isRun) {
			try {
				while (holding) {
					nowTime();
				}
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
		closeWriter();
	}
}
