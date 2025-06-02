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
	//キレそう
	private String postID;

	public AnimalDAO(String postID) {
		this.postID = postID;
	}

	/**
	 * 動物の一覧表示
	 */
	public List<AnimalBean> selectAllAnimal() throws SQLException,ClassNotFoundException {
		List<AnimalBean> animalList = new ArrayList<AnimalBean>();
		String sql = "select animalID,animalName,birthday,area_name,sex,country,AnimalType,KindName,photoURL,livingNow from m_animal oneanimal" 
				+" left join m_animaltype atype on oneanimal.TypeID = atype.TypeID" 
				+" left join m_animalkind kind on oneanimal.kindID = kind.kindID And oneanimal.TypeID = kind.TypeID"
				+" left join m_area area on oneanimal.areaID = area.areaID";


		//データベースの接続の取得、Statementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection(postID);
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery(sql)){

			while(res.next()){
				String animalID 	= res.getString("animalID");
				String name 		= res.getString("animalName");
				String animalType 	= res.getString("AnimalType");
				String animalKind 	= res.getString("KindName");
				String area 		= res.getString("area_name");
				String BirthDay 	= getDateUntilDay(res.getDate("birthday"));
				String country 		= res.getString("country");
				String sex 			= res.getString("sex");
				String photo 		= res.getString("photoURL");
				int	   livingNow 	= res.getInt("livingNow");

				AnimalBean animal = new AnimalBean();
				animal.setAnimalID(animalID);
				animal.setName(name);
				animal.setAnimalType(animalType);
				animal.setAnimalKind(animalKind);
				animal.setArea(area);
				animal.setCountry(country);
				animal.setPhoto(photo);
				animal.setSex(sex);
				animal.setBirthDay(BirthDay);
				animal.setLivingNow(livingNow);
				animalList.add(animal);
			}
		}
		return animalList;

	}
	
	//動物IDから動物情報を取得
	public AnimalBean selectOneRecodeAllAnimal(String animalID) throws SQLException,ClassNotFoundException {
		
		String sql = "select animalID,animalName,birthday,area_name,sex,country,AnimalType,KindName,photoURL,livingNow from m_animal oneanimal" 
				+" left join m_animaltype atype on oneanimal.TypeID = atype.TypeID" 
				+" left join m_animalkind kind on oneanimal.kindID = kind.kindID And oneanimal.TypeID = kind.TypeID"
				+" left join m_area area on oneanimal.areaID = area.areaID"
				+" where animalID= ?";


		//データベースの接続の取得、Statementの取得、SQLステートメントの実行
		try(Connection con = ConnectionManager.getConnection(postID);
				PreparedStatement pstmt=con.prepareStatement(sql)){

			pstmt.setString(1, animalID);

			ResultSet res = pstmt.executeQuery();
			
			
			AnimalBean animalrecode = new AnimalBean();
			
			animalrecode.setAnimalID(res.getString("animalID"));
			animalrecode.setName(res.getString("animalName"));
			animalrecode.setBirthDay(getDateUntilDay(res.getDate("birthday")));
			animalrecode.setArea(res.getString("area_name"));
//			animalrecode.setKeepers(res.getString("animalID"));
			animalrecode.setCountry(res.getString("country"));
			animalrecode.setSex(res.getString("sex"));
			animalrecode.setPhoto(res.getString("photoURL"));
			animalrecode.setLivingNow(res.getInt("livingNow"));
			animalrecode.setAnimalType(res.getString("AnimalType"));
			animalrecode.setAnimalKind(res.getString("KindName"));
			
			
				return animalrecode;
			}
		}

	/**
	 * 検索画面の表記内容に検索を実行する
	 * @param animal
	 * @return
	 */
	public List<AnimalBean> selectAnimalByfield(AnimalBean searchanimal){

		List<AnimalBean> result = new ArrayList<AnimalBean>();

		AnimalDAO dao = new AnimalDAO(postID);

		try {
			List<AnimalBean> allanimal=dao.selectAllAnimal();
			System.out.println(allanimal.size());
			for (AnimalBean animal:allanimal) {
				int checkBorder = 0;
				int checkScore 	= 0; 
				if(!searchanimal.getAnimalID().isEmpty()) {
					checkBorder +=1;
					System.out.println("検索対象:"+searchanimal.getAnimalID());
					System.out.println("データベース側:"+animal.getAnimalID());
					if (animal.getAnimalID().contains(searchanimal.getAnimalID())) {
						checkScore+=1;
					}
				}
				if(!searchanimal.getName().isEmpty()) {
					checkBorder +=1;
					System.out.println("検索対象:"+searchanimal.getName());
					System.out.println("データベース側:"+animal.getName());
					if (animal.getName().contains(searchanimal.getName())){
						checkScore +=1;
					}
				}
				if(!searchanimal.getAnimalType().isEmpty()) {
					checkBorder +=1;
					System.out.println("検索対象:"+searchanimal.getAnimalType());
					System.out.println("データベース側:"+animal.getAnimalType());
					if (animal.getAnimalType().contains(searchanimal.getAnimalType())){
						checkScore +=1;
					}
				}
				if(!searchanimal.getArea().isEmpty()) {
					checkBorder +=1;
					System.out.println("検索対象:"+searchanimal.getArea());
					System.out.println("データベース側:"+animal.getArea());
					if (animal.getArea().contains(searchanimal.getArea())){
						checkScore +=1;
					}
				}
				if (checkBorder ==checkScore) {
					result.add(animal);
				}
				System.out.println("checkBorder="+checkBorder);
				System.out.println("checkScore="+checkScore);

			}


		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}



		return result;
	}

	/**
	 * 動物の登録
	 * @param animal
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void insertAnimal (AnimalBean animal) throws ClassNotFoundException,SQLException {
		String sql = "insert into m_animal values (?,?,?,?,?,?,?,?,?,1)";
		try (Connection con = ConnectionManager.getConnection(postID);
				PreparedStatement pstmt = con.prepareStatement(sql)){
			//Beanからのデータ取り出し
			String animalID = animal.getAnimalID();
			String name = animal.getName();
			String birthDay = animal.getBirthDay();
			int areaID = animal.getAreaID();
			String sex = animal.getSex();
			String country = animal.getCountry();
			String  animalType = animal.getAnimalType();
			int kindID = animal.getKindID();
			String photo = animal.getPhoto();


			//プレースホルダーへの値の設定
			pstmt.setString(1,animalID);
			pstmt.setString(2,name);
			pstmt.setString(3,birthDay);
			pstmt.setInt(4,areaID);
			pstmt.setString(5, sex);
			pstmt.setString(6,country);
			pstmt.setString(7,animalType);
			pstmt.setInt(8,kindID);
			pstmt.setString(9,photo);


			//SQLステートメントの実行
			pstmt.executeUpdate();
		}
	}






	/**
	 * 動物情報を編集する
	 * @param animal
	 * @return
	 */
	public int updateAnimal(AnimalBean animal) {
		int processingNumber = 0; //処理件数

		String sql = "UPDATE m_animal SET animalName = ?, sex = ?,   photoURL = ? WHERE animalID = ?";

		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection(postID);
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// Beanからのデータの取り出し
			String name      	= animal.getName();
			String sex 			= animal.getSex();
			String area 		= animal.getArea();
			String photo		= animal.getPhoto();
            String animalID 	= animal.getAnimalID();

			// プレースホルダへの値の設定
			pstmt.setString(1, name);
			pstmt.setString(2, sex);
			//pstmt.setString(3, area);
			pstmt.setString(3, photo);
            pstmt.setString(4, animalID);

			// SQLステートメントの実行
			processingNumber = pstmt.executeUpdate();
			
			System.out.println(processingNumber);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return processingNumber;
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
		try(Connection con = ConnectionManager.getConnection(postID);
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

		String sql = "Delete from m_animal WHERE animalID = ?";

		// データベースへの接続の取得、PreparedStatementの取得
		try(Connection con = ConnectionManager.getConnection(postID);
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