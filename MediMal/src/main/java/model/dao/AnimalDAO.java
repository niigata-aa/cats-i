package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
	public int HiddenAnimal(String animalID,int TFNum) throws ClassNotFoundException, SQLException {
			int count = 0; //処理件数
			
			String sql = "UPDATE m_animal SET livingNow = ? WHERE animalID = ?";
		
			// データベースへの接続の取得、PreparedStatementの取得
			try(Connection con = ConnectionManager.getConnection(empID);
					PreparedStatement pstmt=con.prepareStatement(sql)){
		
			// プレースホルダへの値の設定
			pstmt.setInt(1,TFNum);
			pstmt.setString(2,animalID);
		
			// SQLステートメントの実行
			count = pstmt.executeUpdate();
		}
		return count;
	}
	
	/**
	 * 登録されている動物を削除する
	 * @param animal
	 * @return
	 */
	public int DeleteAnimal(AnimalBean animal) throws ClassNotFoundException, SQLException {
			int count = 0; //処理件数
		
			String sql = "UPDATE from m_animal WHERE animalID = ?";
	
			// データベースへの接続の取得、PreparedStatementの取得
			try(Connection con = ConnectionManager.getConnection(empID);
				PreparedStatement pstmt=con.prepareStatement(sql)){
				
				// Beanからのデータの取り出し
				String animalID = animal.getAnimalID();
	
				// プレースホルダへの値の設定
				pstmt.setString(1,animalID);
	
				// SQLステートメントの実行
				count = pstmt.executeUpdate();
			}
			return count;
	}
	
}