package model.entity;

import java.text.SimpleDateFormat;

public class Birth {
	
	private String animalID;
	
	private SimpleDateFormat date;
	
	private int amount;
	
	
	public Birth() {
		
	}
	
	
	

	public String getAnimalID() {
		return animalID;
	}

	public void setAnimalID(String animalID) {
		this.animalID = animalID;
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