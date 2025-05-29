package model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EmployeeBean implements Serializable {

	private String empID;
	private String empPass;
	private String lastName;
	private String firstName;
	private String gender;
	private List<String>animalIDs = new ArrayList<String>();
	private int post;
	private int area;
	private String startWork;
	private int livingNow;
	private String photo;
	
	
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


	public int getPost() {
		return post;
	}


	public void setPost(int post) {
		this.post = post;
	}


	public int getArea() {
		return area;
	}


	public void setArea(int area) {
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


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	
}
