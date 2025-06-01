package model.entity;

import java.io.Serializable;

public class MedicalExamBean implements Serializable {
	
	private String animalID;
	private String medicTime;
	private String empID;
	private String medicalphoto;
	public String getAnimalID() {
		return animalID;
	}
	public String getMedicTime() {
		return medicTime;
	}
	public String getEmpID() {
		return empID;
	}
	public String getMedicalphoto() {
		return medicalphoto;
	}
	public void setAnimalID(String animalID) {
		this.animalID = animalID;
	}
	public void setMedicTime(String medicTime) {
		this.medicTime = medicTime;
	}
	public void setEmpID(String empID) {
		this.empID = empID;
	}
	public void setMedicalphoto(String medicalphoto) {
		this.medicalphoto = medicalphoto;
	}
	
}
