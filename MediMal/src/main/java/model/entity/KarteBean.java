package model.entity;

import java.io.Serializable;
import java.util.List;

public class KarteBean implements Serializable {
	
	private AnimalBean animal;
	
	private List<MedicalExamBean> medicaltimes;
	
	private List<String> veterinarian;
	
	private List<Drug> drugLog;
	
	private List<Weight> weightLog;
	
	private List<AnimalComment> commentLog;
	
	private List<Feed> feedLog;
	
	private List <Birth> birthLog;
	
	public KarteBean() {
		
	}

	public AnimalBean getAnimal() {
		return animal;
	}

	public void setAnimal(AnimalBean animal) {
		this.animal = animal;
	}

	public List<MedicalExamBean> getMedicaltimes() {
		return medicaltimes;
	}

	public void setMedicaltimes(List<MedicalExamBean> medicaltimes) {
		this.medicaltimes = medicaltimes;
	}

	public List<String> getVeterinarian() {
		return veterinarian;
	}

	public void setVeterinarian(List<String> veterinarian) {
		this.veterinarian = veterinarian;
	}

	public List<Drug> getDrugLog() {
		return drugLog;
	}

	public void setDrugLog(List<Drug> drugLog) {
		this.drugLog = drugLog;
	}

	public List<Weight> getWeightLog() {
		return weightLog;
	}

	public void setWeightLog(List<Weight> weightLog) {
		this.weightLog = weightLog;
	}

	public List<AnimalComment> getCommentLog() {
		return commentLog;
	}

	public void setCommentLog(List<AnimalComment> commentLog) {
		this.commentLog = commentLog;
	}

	public List<Feed> getFeedLog() {
		return feedLog;
	}

	public void setFeedLog(List<Feed> feedLog) {
		this.feedLog = feedLog;
	}

	public List<Birth> getBirthLog() {
		return birthLog;
	}

	public void setBirthLog(List<Birth> birthLog) {
		this.birthLog = birthLog;
	}
}
