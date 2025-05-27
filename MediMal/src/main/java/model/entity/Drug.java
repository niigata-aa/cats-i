package model.entity;

import java.sql.Date;

public class Drug {
	
	
	private Date date;
	private int measureWeight;
	private String unit;
	
	public Drug() {
		
	}

	public Date getDate() {
		return date;
	}
	
	
	//getter setter
	public void setDate(Date date) {
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
