package model.entity;

import java.text.SimpleDateFormat;

public class Birth {
	
	private SimpleDateFormat date;
	
	private int amount;
	
	public Birth() {
		
	}

	public SimpleDateFormat getDate() {
		return date;
	}

	public void setDate(SimpleDateFormat date) {
		this.date = date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}