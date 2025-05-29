package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.entity.EmployeeBean;

public class EmployeeDAO {

	private String postID;

	public EmployeeDAO(String postID) {
		this.postID=postID;
	}





	public List<EmployeeBean> selectAllEmp () throws SQLException,ClassNotFoundException {
		List<EmployeeBean> employeeList = new ArrayList<EmployeeBean>();
<<<<<<< HEAD

		String sql = "select empID,lastName,firstName,gender,area.area_name,gender,post.postName, startWork from m_employee emp Left join m_area area on emp.areaID =area.areaID left join m_post post on emp.postID =post.postID";


=======
		
		String sql = "select * from medimaldb.employee_view3 where postName='飼育員'";
		String sql_type = "select * from medimaldb.keeptype_view where empID = ? ";
				
		
>>>>>>> branch 'master' of https://github.com/niigata-aa/cats-i.git
		//データベースの接続の取得、Statementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection(postID);
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery(sql)){
<<<<<<< HEAD

			while(res.next()){

				EmployeeBean employeeTmp = new EmployeeBean();
				employeeTmp.setEmpID(res.getString("empID"));
				employeeTmp.setLastName(res.getString("lastName"));
				employeeTmp.setFirstName(res.getString("firstname"));
				employeeTmp.setGender(res.getString("gender"));
				employeeTmp.setPost(res.getInt("post"));
				//employee.setAnimalIDs(animalIDs);
				employeeTmp.setArea(res.getInt("area"));
				employeeTmp.setStartWork(getDateUntilMonth(res.getTimestamp("startWork")));
				employeeTmp.setPhoto(res.getString("photo"));

				employeeList.add(employeeTmp);

=======
		
		while(res.next()){
			List<String> keeptype = new ArrayList<String>();
			EmployeeBean employeeTmp = new EmployeeBean();
			employeeTmp.setEmpID(res.getString("empID"));
			employeeTmp.setLastName(res.getString("lastName"));
			employeeTmp.setFirstName(res.getString("firstname"));
			employeeTmp.setGender(res.getString("gender"));
			employeeTmp.setArea(res.getString("areaName"));
			employeeTmp.setStartWork(getDateUntilMonth(res.getDate("startWork")));
//			employeeTmp.setPhotoURL(res.getString("photo"));
//			
//			try(PreparedStatement pstmt = con.prepareStatement(sql_type)){
//				pstmt.setString(1,res.getString("empID"));
//				ResultSet res_type = pstmt.executeQuery();
//				while(res.next()) {
//					keeptype.add(res_type.getString("animalType"));
//				}
//			}
//			employeeTmp.setAnimalIDs(keeptype);
			employeeList.add(employeeTmp);
>>>>>>> branch 'master' of https://github.com/niigata-aa/cats-i.git
			}


		}
		return employeeList;
	}



	/**
	 * 入力した内容に不備がないかを判断する(ログインの可否)
	 * @param empID
	 * @param Password
	 * @return true or false
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * 
	 * 更新1.1
	 */
	public boolean loginCheck(String LoginID,String Password) throws ClassNotFoundException, SQLException {
		String sql = "select empID ,empPass from m_employee where empID= ? and empPass = ?";

		try(Connection con = ConnectionManager.getConnection(postID);
				PreparedStatement pstmt=con.prepareStatement(sql)){

			pstmt.setString(1, LoginID);
			pstmt.setString(2, Password);

			ResultSet res = pstmt.executeQuery();

			if(res.next()) {
				return true;
			}
		}

		return false ;
	}

	/**
	 * 全ての従業員のリストを返す
	 */

	/**
	 * 検索画面の入力内容に応じた検索を行う.
	 * @param Employee
	 * @return
	 */
	public List<EmployeeBean> selectEmpByField(EmployeeBean Employee){

		return ;
	}


	/**
	 * 従業員の登録
	 * @param employee
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void insertEmp (EmployeeBean employee) throws ClassNotFoundException,SQLException {
		String sql = "insert into m_employee values (?,?,?,?,?,?,?,?,1,?)";
		try (Connection con = ConnectionManager.getConnection(sql);
				PreparedStatement pstmt = con.prepareStatement(sql)){
			//Beanからのデータ取り出し
			String empID = employee.getEmpID();
			String  empPass = employee.getEmpPass();
			String lastName = employee.getLastName();
			String firstName = employee.getFirstName();
			String gender = employee.getGender();
			int postID = employee.getPost();
			int areaID = employee.getArea();
			String startWork = getDateUntilMonth(employee.getStartWork());
			int livingNow = employee.getLivingNow();
			String photo = employee.getPhoto();


			//プレースホルダーへの値の設定
			pstmt.setString(1,empID);
			pstmt.setString(2,empPass);
			pstmt.setString(3,lastName);
			pstmt.setString(4,firstName);
			pstmt.setString(5,gender);
			pstmt.setInt(6,postID);
			pstmt.setInt(7,areaID);
			pstmt.setString(8,startWork);
			pstmt.setInt(9,livingNow);
			pstmt.setString(10,photo);



			//		Listはわかんないwhile?
			//		pstmt.setList(4,animalIDs );
			//		List<String>animalIDs = new ArrayList<String>( Employee.getPost());?


			//SQLステートメントの実行
			pstmt.executeUpdate();
		}
	}


	/**
	 * 
	 * @param Employee
	 * @return
	 */
	public int updateEmp(EmployeeBean Employee) {

		return ;
	}

	/**
	 * 
	 * @param ID
	 * @param TFNum
	 * @return
	 */
	public int hiddenEmp(String ID, int TFNum) {

		return ;
	}

	/**
	 * 
	 * @param Employee
	 * @return
	 */
	public int deleteEmp(EmployeeBean Employee) {

		return ;
	}

	/**
	 * 
	 * @param StartYear
	 * @return
	 */
	public int getYearsOfWorking(Date StartYear) {

		return ;
	}

	public String getDateUntilMinute(Timestamp date) {
		String result;

		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日hh時mm分");
		result = df.format(date);




		return result;

	}

	public String getDateUntilDay(Timestamp date) {
		String result;

		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
		result = df.format(date);

<<<<<<< HEAD
=======
		
		
		
		return result;
		
	}
	
	
	public String getDateUntilMonth(Date date) {
		String result;
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月");
		result = df.format(date);
>>>>>>> branch 'master' of https://github.com/niigata-aa/cats-i.git



		return result;

	}


	public String getDateUntilMonth(Timestamp timestamp) {
		String result;

		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月");
		result = df.format(timestamp);




		return result;

	}


}
