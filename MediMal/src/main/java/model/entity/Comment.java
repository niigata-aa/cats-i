package model.entity;

import java.text.SimpleDateFormat;


public class Comment {

	private String animalID;
	private SimpleDateFormat date;
	private String empID;
	private String content;
	private String empPost;


	public Comment() {

	}

	//getter setter
	
	public String getAnimalID() {
		return animalID;
	}
	
	public void setAnimalID(String animalID) {
		this.animalID = animalID;
	}
	
	
	
	public SimpleDateFormat getDate() {
		return date;
	}


	public void setDate(SimpleDateFormat date) {
		this.date = date;
	}


	public String getEmpID() {
		return empID;
	}


	public void setEmpID(String empID) {
		this.empID = empID;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getEmpPost() {
		return empPost;
	}


	public void setEmpPost(String empPost) {
		this.empPost = empPost;
	}



}
