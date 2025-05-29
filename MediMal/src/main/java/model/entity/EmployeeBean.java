package model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EmployeeBean implements Serializable {

	private String 			empID;
	private String 			empPass;
	private String 			lastName;
	private String 			firstName;
	private String 			gender;
	private List<String>	animalIDs = new ArrayList<String>();
	private String 			area ;
	private String 			startWork;
	private int 			livingNow;
	private String 			photoURL;
	
	
	public EmployeeBean() {
		
	}


	public String getEmpID() {
		return empID;
	}


	public void setEmpID(String empID) {
		this.empID = empID;
	}


	public String getEmpPass() {
		return empPass;
	}


	public void setEmpPass(String empPass) {
		this.empPass = empPass;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public List<String> getAnimalIDs() {
		return animalIDs;
	}


	public void setAnimalIDs(List<String> animalIDs) {
		this.animalIDs = animalIDs;
	}


	

	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public String getStartWork() {
		return startWork;
	}


	public void setStartWork(String startWork) {
		this.startWork = startWork;
	}


	public int getLivingNow() {
		return livingNow;
	}


	public void setLivingNow(int livingNow) {
		this.livingNow = livingNow;
	}


	public String getPhotoURL() {
		return photoURL;
	}


	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}


	
}
