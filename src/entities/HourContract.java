package entities;

import java.util.Date;

public class HourContract {
	
	private Date date;
	private Double valuePerHour;
	private Integer hours;
	
	public HourContract() {
		
	}

	public HourContract(Date date, Double valuePerHour, int hours) {
		this.date = date;
		this.valuePerHour = valuePerHour;
		this.hours = hours;
	}

	public Date getDate() {
		return date;
	}

	public Double getValuePerHour() {
		return valuePerHour;
	}

	public int getHours() {
		return hours;
	}
	public double totalValue() {

		return hours * valuePerHour;
	}
	
}
