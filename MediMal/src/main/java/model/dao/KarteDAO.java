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

import model.entity.AnimalComment;
import model.entity.Birth;
import model.entity.Drug;
import model.entity.Feed;
import model.entity.MedicalExamBean;
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
		String sql = "insert into t_weight  values (?,?,?,?,?)";

		try(Connection con = ConnectionManager.getConnection(postID);
				PreparedStatement pstmt = con.prepareStatement(sql)){

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
	public List<Weight> selectAllWeight(String animalID) throws SQLException, ClassNotFoundException {

		List<Weight> result = new ArrayList<Weight>();

		String sql = "select * from t_weight where animalID = ?";

		try (Connection con = ConnectionManager.getConnection(postID);
				PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setString(1, animalID);
			
			ResultSet res = pstmt.executeQuery();

			List<Weight> TmpAll = new ArrayList<Weight>();

			while (res.next()) {
				Weight TmpWeight = new Weight();
				TmpWeight.setAnimalID(res.getString("animalID"));
				TmpWeight.setInputTime(getDateUntilMinute(res.getDate("inputTime")));
				TmpWeight.setWeight(res.getInt("weight"));
				TmpWeight.setWeightUnit(res.getString("weightUnit"));

				TmpAll.add(TmpWeight);

			}

			if (TmpAll.size()!=0) {
				for (Weight weight :TmpAll) {

					if(weight.getAnimalID().equals(animalID)) {
						result.add(weight);
					}
				}
				return result;
			}else {
				return result;
			}
		}

	}


	/**
	 * 投薬履歴を追加する
	 * @param inputDrug　投薬した薬の、動物ID、日付、名前、量
	 * @return 処理件数
	 */
	public int insertDrug(Drug inputDrug) throws ClassNotFoundException,SQLException {
		int count = 0;
		String sql = "insert into t_drug  values (?,?,?,?)";

		try(Connection con = ConnectionManager.getConnection(postID);
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
	public List<Drug> selectAllDrug(String animalID) throws SQLException, ClassNotFoundException {
		List<Drug> result = new ArrayList<Drug>();
		String sql = "select * from t_drug where animalID = ? ";

		try (Connection con = ConnectionManager.getConnection(postID);
				PreparedStatement pstmt = con.prepareStatement(sql)){

			pstmt.setString(1, animalID);

			ResultSet res = pstmt.executeQuery();
			List<Drug> TmpAll = new ArrayList<Drug>();

			while (res.next()) {
				Drug TmpDrug = new Drug();
				TmpDrug.setAnimalID(res.getString("animalID"));
				TmpDrug.setDate(getDateUntilMinute(res.getDate("drugTime")));
				TmpDrug.setMedicineName(res.getString("drugAbout"));
				TmpDrug.setMedicineAmount(res.getInt("drugAmount"));

				TmpAll.add(TmpDrug);

			}
			if (TmpAll.size()!=0) {
				for (Drug weight :TmpAll) {
					if(weight.getAnimalID().equals(animalID)) {
						result.add(weight);
					}
				}
				return result;
			}else {
				return null;
			}
		}


	}



	/**
	 * コメントを追加する
	 * @param wroteComment
	 * @return 処理件数
	 */
	//あ
	public int insertComment(AnimalComment inputComment) throws ClassNotFoundException,SQLException {
		int count = 0;
		String sql = "insert into t_Comment  values (?,?,?,?)";

		try(Connection con = ConnectionManager.getConnection(postID);
				PreparedStatement pstmt = con.prepareStatement(sql)){

			//Beanからのデータの取り出し
			String animalID = inputComment.getAnimalID();
			String commentTime = inputComment.getCommentTime();
			String empID = inputComment.getEmpID();
			String content = inputComment.getContent();

			//プレースホルダーへの値の設定	
			pstmt.setString(1,animalID);
			pstmt.setString(2, commentTime);
			pstmt.setString(3,empID);
			pstmt.setString(4,content);

			//SQLステートメントの実行
			count = pstmt.executeUpdate();
		}
		return count;
	}


	/**全て（飼育員と獣医師）のコメントを検索する*/
	public List<AnimalComment> selectAllComment(String animalID) throws SQLException, ClassNotFoundException {
		List<AnimalComment> result = new ArrayList<AnimalComment>();
		String sql = "select * from t_birth ";

		try (Connection con = ConnectionManager.getConnection(postID);
				PreparedStatement pstmt = con.prepareStatement(sql)){

			pstmt.setString(1, animalID);

			ResultSet res = pstmt.executeQuery();

			List<AnimalComment> TmpAll = new ArrayList<AnimalComment>();

			while (res.next()) {
				AnimalComment TmpComment = new AnimalComment();
				TmpComment.setAnimalID(res.getString("animalID"));
				TmpComment.setCommentTime(getDateUntilMinute(res.getDate("CommentTime")));
				TmpComment.setEmpID(res.getString("empID"));
				TmpComment.setContent(res.getString("Content"));


				TmpAll.add(TmpComment);

			}
			if (TmpAll.size()!=0) {
				for (AnimalComment weight :TmpAll) {
					if(weight.getAnimalID().equals(animalID)) {
						result.add(weight);
					}
				}
				return result;
			}else {
				return null;
			}
		}
	}


	public List<MedicalExamBean> selectallMedicalExam(String animalID) throws ClassNotFoundException, SQLException{
		String sql = "select * from t_medicalexam where animalID = ?";
		List<MedicalExamBean> result = new ArrayList<MedicalExamBean>();

		try (Connection con = ConnectionManager.getConnection(postID);
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery(sql)){



			while (res.next()) {
				MedicalExamBean TmpWeight = new MedicalExamBean();
				TmpWeight.setAnimalID(res.getString("animalID"));
				TmpWeight.setMedicTime(getDateUntilMinute(res.getDate("inputTime")));
				TmpWeight.setEmpID(res.getString("empID"));
				TmpWeight.setMedicalphoto(res.getString("MedicalphotoURL"));

				result.add(TmpWeight);

			}

			return result;

		}

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
		String sql = "insert into t-feeding values (?,?,?,?,?,?)";
		try (Connection con = ConnectionManager.getConnection(postID);
				PreparedStatement pstmt = con.prepareStatement(sql)){

			//Beanからのデータ取り出し
			String animalID = inputFeed.getAnimalID();
			String feedTime = inputFeed.getFeedTime();
			String empID = inputFeed.getEmpID();
			String feedContent = inputFeed.getFeedContent();
			int feedAmount = inputFeed.getFeedAmount();
			String feedUnit = inputFeed.getFeedUnit();
			//プレースホルダーへの値の設定
			pstmt.setString(1,animalID);
			pstmt.setString (2,feedTime );
			pstmt.setString(3,empID );
			pstmt.setString(4,feedContent);
			pstmt.setInt(5,feedAmount);
			pstmt.setString(6, feedUnit);
			count = pstmt.executeUpdate();
		}
		return count;
	}




	/**全ての食事履歴を検索する
	 * @throws SQLException 
	 * @throws ClassNotFoundException */
	public List<Feed> selectAllFeed(String animalID) throws ClassNotFoundException, SQLException{
		List<Feed> result = new ArrayList<Feed>();

		String sql = "select * from t_feeding where animalID = ?";

		try(Connection con = ConnectionManager.getConnection(postID);
				PreparedStatement pstmt = con.prepareStatement(sql)){

			pstmt.setString(1, animalID);

			ResultSet res = pstmt.executeQuery();

			while(res.next()) {
				Feed tmpFeed = new Feed();

				tmpFeed.setEmpID(res.getString("empID"));
				tmpFeed.setFeedTime(getDateUntilMinute(res.getDate("feedTime")));
				tmpFeed.setFeedContent(res.getString("feedContent"));
				tmpFeed.setFeedAmount(res.getInt("feedAmount"));
				tmpFeed.setFeedUnit(res.getString("feedUnit"));

				result.add(tmpFeed);
			}

		}
		return result;
	}


	/**出産履歴を追加する*/
	public int insertBirth (Birth inputBirth) throws ClassNotFoundException,SQLException {
		int count;
		String sql = "insert into t-birthrecode  values (?,?,?)";
		try (Connection con = ConnectionManager.getConnection(postID);
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
	public List<Birth> selectAllBirth(String animalID) throws SQLException, ClassNotFoundException {
		List<Birth> result = new ArrayList<Birth>();
		String sql = "select * from t_birth ";

		try (Connection con = ConnectionManager.getConnection(postID);
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery(sql)){

			List<Birth> TmpAll = new ArrayList<Birth>();

			while (res.next()) {
				Birth TmpBirth = new Birth();
				TmpBirth.setAnimalID(res.getString("animalID"));
				TmpBirth.setDate(getDateUntilDay(res.getDate("birthdate")));

				TmpBirth.setAmount(res.getInt("birthAmount"));

				TmpAll.add(TmpBirth);

			}
			if (TmpAll.size()!=0) {
				for (Birth weight :TmpAll) {
					if(weight.getAnimalID().equals(animalID)) {
						result.add(weight);
					}
				}
				return result;
			}else {
				return result;
			}
		}	
	}


	//日付
	public static String getDateUntilMinute(Date date) {
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

