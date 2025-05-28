package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;

import model.entity.Drug;

public class KarteDAO {



	/**
	 * 体重を追加する
	 * @param inputWeight　追加したい体重
	 * @return 処理件数
	 */
	public int insertWeight(Weight inputWeight) throws ClassNotFoundException,SQLException {
		int count = 0;
		String url = "insert into t_BodyWeight  values (?,?,?,?)";

		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(url)){

			//Beanからのデータの取り出し
			String animalID = inputWeight.getAnimalID();
			SimpleDateFormat inputDate = inputWeight.getInputDate();
			int measureWeight = inputWeight.getMeasureWeight();
			String unit = inputWeight.getUnit();

			//プレースホルダーへの値の設定	
			pstmt.setString(1, animalID);
			pstmt.SimpleDateFormat(2, inputDate);
			pstmt.setInt(3,measureWeight);
			pstmt.setString(4, unit);

			//SQLステートメントの実行
			count = pstmt.executeUpdate();
		}
		return count;
	}











	/**
	 * 全ての体重履歴を検索する
	 * @return
	 */
	public List<Weight> selectAllWeight() {
		return
	}


	/**
	 * 投薬履歴を追加する
	 * @param inputDrug　投薬した薬の、動物ID、日付、名前、量
	 * @return 処理件数
	 */
	public int insertDrug(Drug inputDrug) throws ClassNotFoundException,SQLException {
		int count = 0;
		String url = "insert into t_dosage  values (?,?,?,?)";

		try(Connection con = ConnectionManagerMedical.getConnection();
				PreparedStatement pstmt = con.prepareStatement(url)){

			//Beanからのデータの取り出し
			String animalID = inputDrug.getAnimalID();
			SimpleDateFormat date = inputDrug.getDate();
			String medicineName = inputDrug.getMedicineName();
			int medicineAmount = inputDrug.getMedicineAmount();

			//プレースホルダーへの値の設定	
			pstmt.setString(1, animalID);
			pstmt.setSimpleDateFormat(2, date);
			pstmt.setString(3,medicineName);
			pstmt.setInt(4, medicineAmount);

			//SQLステートメントの実行
			count = pstmt.executeUpdate();
		}
		return count;
	}



	/**全ての投薬履歴を検索する*/
	public List<Drug> selectAllDrug() {
		return
	}



	/**
	 * コメントを追加する
	 * @param wroteComment
	 * @return 処理件数
	 */
	public int insertComment(Comment wroteComment) throws ClassNotFoundException,SQLException {
		int count = 0;
		String url = "insert into t_comment  values (?,?,?,?)";

		try(Connection con = ConnectionManager ? .getConnection();
				PreparedStatement pstmt = con.prepareStatement(url)){

			//Beanからのデータの取り出し
			SimpleDateFormat date = wroteComment.getDate();
			String empID = wroteComment.empID();
			String content = wroteComment.content();

			//プレースホルダーへの値の設定	
			pstmt.setSimpleDateFormat(1, date);
			pstmt.setString(2,empID);
			pstmt.setString(3,content);

			//SQLステートメントの実行
			count = pstmt.executeUpdate();
		}
		return count;
	}


	/**全て（飼育員と獣医師）のコメントを検索する*/
	public List<Comment> selectAllComment() {
		return
	}


	/**飼育員のコメントを検索する*/
	public List<Comment> selectkeeperComment() {
		return
	}


	/**獣医師のコメントを検索する*/
	public List<Comment> selectMedicalComment() {
		return
	}


	/**食事履歴を追加する*/
	public int insertFeed(Feed feed) {
		return
	}


	/**全ての食事履歴を検索する*/
	public List<Feed> selectAllFeed(){
		return
	}


	/**出産履歴を追加する*/
	public int insertBirth(Birth birth) {
		return
	}


	/**全ての出産履歴を検索する*/
	public List<Birth> selectAllBirth() {
		return
	}




}
