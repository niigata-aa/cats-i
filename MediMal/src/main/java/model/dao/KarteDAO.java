package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.stream.events.Comment;

import java.text.SimpleDateFormat;

import model.entity.Birth;
import model.entity.Drug;
import model.entity.Feed;
import model.entity.Weight;

public class KarteDAO {

	private String postID;


	public KarteDAO(String postID) {
		this.postID = postID;
	}


	/**
	 * 体重を追加する
	 * @param inputWeight　追加したい体重
	 * @return 処理件数
	 */
	public int insertWeight(Weight inputWeight) throws ClassNotFoundException,SQLException {
		int count = 0;
		String url = "insert into t_weight  values (?,?,?,?,?)";

		try(Connection con = ConnectionManager.getConnection(postID);
				PreparedStatement pstmt = con.prepareStatement(url)){

			//Beanからのデータの取り出し
			String animalID = inputWeight.getAnimalID();
			String inputTime = inputWeight.getInputTime();
			String empID = inputWeight.getEmpID();
			int weight = inputWeight.getWeight();
			String weightUnit = inputWeight.getWeightUnit();

			//プレースホルダーへの値の設定	
			pstmt.setString(1, animalID);
			pstmt.setString(2, inputTime);
			pstmt.setString(3,empID);
			pstmt.setInt(4, weight);
			pstmt.setString(5, weightUnit);

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
		String sql = "insert into t_drug  values (?,?,?,?)";

		try(Connection con = ConnectionManager.getConnection(sql);
				PreparedStatement pstmt = con.prepareStatement(sql)){

			//Beanからのデータの取り出し
			String animalID = inputDrug.getAnimalID();
			String date = inputDrug.getDate();
			String medicineName = inputDrug.getMedicineName();
			int medicineAmount = inputDrug.getMedicineAmount();

			//プレースホルダーへの値の設定	
			pstmt.setString(1, animalID);
			pstmt.setString(2, date);
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
		String sql = "insert into t_comment  values (?,?,?,?)";

		try(Connection con = ConnectionManager.getConnection(sql);
				PreparedStatement pstmt = con.prepareStatement(sql)){

			//Beanからのデータの取り出し
			String animalID = wroteComment.getAnimalID();
			String date = wroteComment.getDate();
			String empID = wroteComment.empID();
			String content = wroteComment.content();

			//プレースホルダーへの値の設定	
			pstmt.setString(1,animalID);
			pstmt.setString(2, date);
			pstmt.setString(3,empID);
			pstmt.setString(4,content);

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


	/**
	 *食事履歴を追加する
	 * @param feed　動物ID、食べたもの、食べた量、単位
	 * @return　処理件数
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int insertFeed (Feed inputFeed) throws ClassNotFoundException,SQLException {
		int count;
		String sql = "insert into t-feeding values (?,?,?,?,?)";
		try (Connection con = ConnectionManager.getConnection(sql);
				PreparedStatement pstmt = con.prepareStatement(sql)){
			
			//Beanからのデータ取り出し
			String animalID = inputFeed.getAnimalID();
			String date = inputFeed.getDate();
			String content = inputFeed.getContent();
			int amount = inputFeed.getAmount();
			String unit = inputFeed.getUnit();
			//プレースホルダーへの値の設定
			pstmt.setString(1,animalID);
			pstmt.setString (2,date );
			pstmt.setString(3,content );
			pstmt.setInt(4,amount);
			pstmt.setString(5,unit);
			count = pstmt.executeUpdate();
		}
		return count;
	}




	/**全ての食事履歴を検索する*/
	public List<Feed> selectAllFeed(){
		return
	}


	/**出産履歴を追加する*/
	public int insertBirth (Birth inputBirth) throws ClassNotFoundException,SQLException {
		int count;
		String sql = "insert into t-birthrecode  values (?,?,?)";
		try (Connection con = ConnectionManager.getConnection(sql);
			PreparedStatement pstmt = con.prepareStatement(sql)){
		//Beanからのデータ取り出し
		String animalID = inputBirth.getAnimalID();
		String date = inputBirth.getDate();
		int amount = inputBirth.getAmount();
		//プレースホルダーへの値の設定
		pstmt.setString (1,animalID);
		pstmt.setString(2,date );
		pstmt.setInt(3,amount);
		count = pstmt.executeUpdate();
		}
		return count;
		}



	/**全ての出産履歴を検索する*/
	public List<Birth> selectAllBirth() {
		return
	}
	
	
	//日付
	public String getDateUntilMinute(String string) {
		String result;
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日hh時mm分");
		result = df.format(string);
		
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
