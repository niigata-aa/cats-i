package model.dao;

import java.util.List;

import model.entity.AnimalBean;

public class AnimalDAO {
	
	/**
	 * 動物の一覧表示
	 */
	public List<AnimalBean> selectAllAnimal() {
		
	}
	
	/**
	 * 検索画面の表記内容に検索を実行する
	 * @param animal
	 * @return
	 */
	public List<AnimalBean> selectAnimalByfield(AnimalBean animal){
		
		return;
	}
	
	/**
	 * 動物を登録する
	 * @param animal
	 */
	
	public void insertAnimal(AnimalBean animal) {
	}
	
	/**
	 * 動物情報を編集する
	 * @param animal
	 * @return
	 */
	public int UpdateAnimal(AnimalBean animal) {
		
		return;
	}
	
	/**
	 * 動物の在籍情報
	 * @param animalID
	 * @param TFNum
	 * @return
	 */
	public int HiddenAnimal(String animalID,int TFNum) {
		
		return;
	}
	
	/**
	 * 登録されている動物を削除する
	 * @param animal
	 * @return
	 */
	public int DeleteAnimal(AnimalBean animal) {
		
		return;
	}
	
}

