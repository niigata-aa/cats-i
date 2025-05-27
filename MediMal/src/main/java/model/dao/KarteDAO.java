package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	public int insertWeight(Weight inputWeight) {
		return
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
	 * @param inputDrug　投薬した薬の、日付、名前、量
	 * @return 処理件数
	 */
	public int insertDrug(Drug inputDrug) {
		int count = 0;
		String url = "insert into t_dosage(dosagedate,doseAbout,doseAmount) values (?,?,?)";

		try(Connection con = ConnectionManagerMedical.getConnection();
				PreparedStatement pstmt = con.prepareStatement(url)){

			//Beanからのデータの取り出し
			SimpleDateFormat date = inputDrug.getDate();
			String medicineName = inputDrug.getMedicineName();
			int medicineAmount = inputDrug.getMedicineAmount();

			//プレースホルダーへの値の設定	
			pstmt.setSimpleDateFormat(1, date);
			pstmt.setString(2,medicineName);
			pstmt.setInt(3, medicineAmount);

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
	public int insertComment(Comment wroteComment) {
		int count = 0;
		String url = "insert into t_Comment(CommentTime,empID,Comment) values (?,?,?)";

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
