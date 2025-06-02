package model.entity;

public class Birth {
	
	private String animalID;
	
	private String date;
	
	private int amount;
	
	
	public Birth() {
		
	}
	
	
	

	public String getAnimalID() {
		return animalID;
	}

	public void setAnimalID(String animalID) {
		this.animalID = animalID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}