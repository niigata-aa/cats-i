package model.entity;

import java.text.SimpleDateFormat;

public class Feed {
	
	private SimpleDateFormat date;
	private String content;
	private int amount;
	private String unit;
	
	public Feed() {
		
	}

	//getter setter
	public SimpleDateFormat getDate() {
		return date;
	}

	public void setDate(SimpleDateFormat date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	
	
}
