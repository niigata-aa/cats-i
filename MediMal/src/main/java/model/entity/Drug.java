package model.entity;

import java.text.SimpleDateFormat;

public class Drug {
	
	
	private SimpleDateFormat date;
	private int measureWeight;
	private String unit;
	
	public Drug() {
		
	}

	public SimpleDateFormat getDate() {
		return date;
	}
	
	
	//getter setter
	public void setDate(SimpleDateFormat date) {
		this.date = date;
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
