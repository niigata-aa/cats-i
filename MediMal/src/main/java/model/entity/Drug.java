package model.entity;

import java.text.SimpleDateFormat;

public class Drug {
	
	
	private SimpleDateFormat date;
	private String medicineName;
	private int medicineAmount;
	
	
	public Drug() {
		
	}


	public SimpleDateFormat getDate() {
		return date;
	}


	public void setDate(SimpleDateFormat date) {
		this.date = date;
	}


	public String getMedicineName() {
		return medicineName;
	}


	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}


	public int getMedicineAmount() {
		return medicineAmount;
	}


	public void setMedicineAmount(int medicineAmount) {
		this.medicineAmount = medicineAmount;
	}

	
	
}
