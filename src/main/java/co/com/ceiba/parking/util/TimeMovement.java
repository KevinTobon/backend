package co.com.ceiba.parking.util;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class TimeMovement {

	public long days;
	public long hours;
	public long minutes;
	public long seconds;
	
	public TimeMovement() {
	}
	
	public TimeMovement(long days, long hours, long minutes, long seconds) {
		super();
		this.days = days;
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}
	
	public void calculateVehicleTime(Date entryDate, Date exitDate) {
		
		long period = exitDate.getTime() - entryDate.getTime();
		
		long formatSeconds = 1000;
		long formatMinutes = formatSeconds * 60;
		long formatHours = formatMinutes * 60;
		long formatDays = formatHours * 24;
		
		this.days = period / formatDays;
		period = period % formatDays;
		
		this.hours = period / formatHours;
		period = period % formatHours;
		
		this.minutes = period / formatMinutes;
		period = period % formatMinutes;
		
		this.seconds = period / formatSeconds;
		

        roundOut();
        
	}
	
	private void roundOut() {
		this.minutes += (this.seconds > 0 ? 1 : 0);
		this.hours += (this.minutes > 0 ? 1 : 0);
	}
}
