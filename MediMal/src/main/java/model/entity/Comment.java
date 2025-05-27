package model.entity;

import java.util.Date;


public class Comment {

	private Date date;
	private String empID;
	private String content;
	private String empPost;


	public Comment() {

	}

	//getter setter
	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
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
