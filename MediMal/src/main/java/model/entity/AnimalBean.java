package model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AnimalBean implements Serializable {
	
	private String animalID;
	
	private String animalType;
	
	private String animalKind;
	
	private String name;
	
	private String birthDay;
	
	private String area;
	
	private List<String> keepers = new ArrayList<String>();
	
	private String country;
	
	private String sex;
	
	private String photo;
	
	public AnimalBean() {

	}

	public String getAnimalID() {
		return animalID;
	}

	public void setAnimalID(String animalID) {
		this.animalID = animalID;
	}

	public String getAnimalType() {
		return animalType;
	}

	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}

	public String getAnimalKind() {
		return animalKind;
	}

	public void setAnimalKind(String animalKind) {
		this.animalKind = animalKind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public List<String> getKeepers() {
		return keepers;
	}

	public void setKeepers(List<String> keepers) {
		this.keepers = keepers;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}	
}


