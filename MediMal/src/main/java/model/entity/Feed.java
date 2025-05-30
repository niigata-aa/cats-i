package model.entity;

public class Feed {
	private String animalID;
	private String feedTime;
	private String empID;
	private String feedContent;
	private int feedAmount;
	private String feedUnit;
	
	public Feed() {
		
	}
	
	//getter setter

	public String getAnimalID() {
		return animalID;
	}

	public void setAnimalID(String animalID) {
		this.animalID = animalID;
	}

	public String getFeedTime() {
		return feedTime;
	}

	public void setFeedTime(String feedTime) {
		this.feedTime = feedTime;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getFeedContent() {
		return feedContent;
	}

	public void setFeedContent(String feedContent) {
		this.feedContent = feedContent;
	}

	public int getFeedAmount() {
		return feedAmount;
	}

	public void setFeedAmount(int feedAmount) {
		this.feedAmount = feedAmount;
	}

	public String getFeedUnit() {
		return feedUnit;
	}

	public void setFeedUnit(String feedUnit) {
		this.feedUnit = feedUnit;
	}

	
	
	
	
	
	
}
