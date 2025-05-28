package model.entity;

import java.text.SimpleDateFormat;

public class Weight {
	
	private String animalID;
	private SimpleDateFormat inputDate;
	private int measureWeight;
	private String unit;
	
	public Weight() {
		
	}


	
	//getter setter
	
	
	public String getAnimalID() {
		return animalID;
	}

	public void setAnimalID(String animalID) {
		this.animalID = animalID;
	}
	
	public SimpleDateFormat getInputDate() {
		return inputDate;
	}

	public void setInputDate(SimpleDateFormat inputDate) {
		this.inputDate = inputDate;
	}

	public int getMeasureWeight() {
		return measureWeight;
	}

	public void setMeasureWeight(int measureWeight) {
		this.measureWeight = measureWeight;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	
	
}
