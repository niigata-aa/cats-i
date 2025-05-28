package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.entity.AnimalBean;

public class AnimalDAO {
	
	/**
	 * 動物の一覧表示
	 */
	public List<AnimalBean> selectAllAnimal() throws SQLException,ClassNotFoundException {
		List<AnimalBean> animalList = new ArrayList<AnimalBean>();

		//データベースの接続の取得、Statementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManagerKeeper.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery("SELECT * FROM m_animal")){
			
			while(res.next()){
				String animalID = res.getString("animalID");
				String name = res.getString("name");
				String animalType = res.getString("animalType");
				String animalKind = res.getString("animalKind");
				String area = res.getString("area");
				List<String> keepers = res.List<String>("keeper");
				String country = res.getString("country");
				String sex = res.getString("sex");
				String photo = res.getString("photo");

				AnimalBean animal = new AnimalBean();
				animal.setAnimalID(animalID);
				animal.setName(name);
				animal.setAnimalType(animalType);
				animal.setAnimalKind(animalKind);
				animal.setArea(area);
				animal.setKeepers(keepers);
				animal.setCountry(country);
				animal.setPhoto(photo);


			}
		}
		return animalList;
		
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
	public String getDateUntilMinute(Date date) {
		String result;
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日hh時mm分");
		result = df.format(date);

		
		
		
		return result;
		
	}
	
	public String getDateUntilDay(Date date) {
		String result;
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
		result = df.format(date);

		
		
		
		return result;
		
	}
	
	
	public String getDateUntilMonth(Date date) {
		String result;
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月");
		result = df.format(date);

		
		
		
		return result;
		
	}
	
	
	
}