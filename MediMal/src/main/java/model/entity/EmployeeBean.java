package model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class EmployeeBean implements Serializable {



	private String 			empID		="null";
	private String 			empPass		="null";
	private String 			lastName	="null";
	private String 			firstName	="null";
	private String 			gender		="null";
	private List<String>	animalIDs = new ArrayList<String>();
	private int				postID;
	private int 			areaID;
	
	private String			postName;
	private String			areaName;
	private String 			startWork;
	private int 			workingNow;
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



	


	public String getStartWork() {
		return startWork;
	}



	public void setStartWork(String startWork) {
		this.startWork = startWork;
	}



	



	public String getPhotoURL() {
		return photoURL;
	}



	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}



	public int getPostID() {
		return postID;
	}



	public void setPostID(int postID) {
		this.postID = postID;
	}



	public int getAreaID() {
		return areaID;
	}



	public void setAreaID(int areaID) {
		this.areaID = areaID;
	}



	public String getPostName() {
		return postName;
	}



	public void setPostName(String postName) {
		this.postName = postName;
	}



	public String getAreaName() {
		return areaName;
	}



	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}



	public int getWorkingNow() {
		return workingNow;
	}



	public void setWorkingNow(int workingNow) {
		this.workingNow = workingNow;
	}




}
