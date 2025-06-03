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
	
	public List<String> getAllArea() throws ClassNotFoundException, SQLException {
		List<String> result = new ArrayList<String>();
		
		String sql = "select * from m_area";
		
		try(Connection con = ConnectionManager.getConnection(postID);
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery(sql)){
			while (res.next()) {
				result.add(res.getString("area_name"));
			}
		}
		
		return result;
	}


	public List<EmployeeBean> selectAllEmp () throws SQLException,ClassNotFoundException {
		List<EmployeeBean> employeeList = new ArrayList<EmployeeBean>();

		String sql = "select\n"
				+ " emp.empID as empID,emp.empPass as empPass, emp.lastName as lastName,emp.firstName as firstName , emp.gender as gender ,emp.startWork as startWork ,emp.photoURL as photo ,area.area_name as areaName,post.postName as postName, emp.workingNow as workingNow   "
				+ "from m_employee emp left join m_area area on emp.areaID = area.areaID left join m_post post on emp.postID = post.postID where postName='飼育員'";
		String sql_type = "select * from medimaldb.keeptype_view where empID = ? ";


		//データベースの接続の取得、Statementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection(postID);
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery(sql)){

			while(res.next()){
				List<String> keeptype = new ArrayList<String>();
				EmployeeBean employeeTmp = new EmployeeBean();
				employeeTmp.setEmpID(res.getString("empID"));
				employeeTmp.setLastName(res.getString("lastName"));
				employeeTmp.setFirstName(res.getString("firstname"));
				employeeTmp.setGender(res.getString("gender"));
				employeeTmp.setAreaName(res.getString("areaName"));
				employeeTmp.setStartWork(getDateUntilMonth(res.getDate("startWork")));
				employeeTmp.setWorkingNow(res.getInt("workingNow"));;
				employeeTmp.setPhotoURL(res.getString("photo"));
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
	
	public String getLoginUserName(String LoginID) throws ClassNotFoundException, SQLException {
		
		String Name = "名無し";
		
		String sql = "select lastName,firstName from m_employee where empID = ?";
		
		try(Connection con = ConnectionManager.getConnection(postID);
				PreparedStatement pstmt =con.prepareStatement(sql)){
			pstmt.setString(1, LoginID);
			
			ResultSet res = pstmt.executeQuery();
			
			if(res.next()) {
				Name = res.getString("lastName") + res.getString("firstName");
			}
			
		}
		
		return Name;
		
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

		List<EmployeeBean> result = new ArrayList<EmployeeBean>();

		EmployeeDAO dao = new EmployeeDAO(postID);

		try {
			List<EmployeeBean> allEmp=dao.selectAllEmp();
			System.out.println(allEmp.size());
			for (EmployeeBean Emp:allEmp) {
				int checkBorder = 0;
				int checkScore 	= 0; 
				if (!(Employee.getEmpID()==null)) {
					checkBorder +=1;
					System.out.println("検索対象:"+Employee.getEmpID());
					System.out.println("データベース側:"+Emp.getEmpID());
					if(Emp.getEmpID().contains(Employee.getEmpID())) {
						checkScore+=1;
					}
				}
				if (!(Employee.getLastName()==null)) {
					checkBorder +=1;
					System.out.println("検索対象:"+Employee.getLastName());
					System.out.println("データベース側:"+Emp.getLastName());
					if(Emp.getLastName().contains(Employee.getLastName())) {
						checkScore+=1;
					}
				}
				if (!(Employee.getFirstName()==null)) {
					checkBorder +=1;
					System.out.println("検索対象:"+Employee.getFirstName());
					System.out.println("データベース側:"+Emp.getFirstName());
					if(Emp.getFirstName().contains(Employee.getFirstName())) {
						checkScore+=1;
					}
				}
				if (!(Employee.getAreaName()==null)) {
					checkBorder +=1;
					System.out.println("検索対象:"+Employee.getAreaName());
					System.out.println("データベース側:"+Emp.getAreaName());
					if(Emp.getAreaName().contains(Employee.getAreaName())) {
						checkScore+=1;
					}
				}
				
				if (checkBorder ==checkScore) {
					result.add(Emp);
				}
				System.out.println("checkBorder="+checkBorder);
				System.out.println("checkScore="+checkScore);
			}
		}catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		System.out.println("検索結果は"+result.size()+"件です");
		return result;

	}


	/**
	 * 従業員の登録
	 * @param employee
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void insertEmp (EmployeeBean employee) throws ClassNotFoundException,SQLException {
		String sql = "insert into m_employee values (?,?,?,?,?,?,?,?,1,?)";
		try (Connection con = ConnectionManager.getConnection(postID);
				PreparedStatement pstmt = con.prepareStatement(sql)){
			//Beanからのデータ取り出し
			String empID = employee.getEmpID();
			String  empPass = employee.getEmpPass();
			String lastName = employee.getLastName();
			String firstName = employee.getFirstName();
			String gender = employee.getGender();
			int postID = employee.getPostID();
			int areaID = employee.getAreaID();
			String startWork = employee.getStartWork();

			String photo = employee.getPhotoURL();


			//プレースホルダーへの値の設定
			pstmt.setString(1,empID);
			pstmt.setString(2,empPass);
			pstmt.setString(3,lastName);
			pstmt.setString(4,firstName);
			pstmt.setString(5,gender);
			pstmt.setInt(6,postID);
			pstmt.setInt(7,areaID);
			pstmt.setString(8,startWork);

			pstmt.setString(9,photo);



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
	public int updateEmp(EmployeeBean employee) {
		int processingNumber = 0; //処理件数

		String sql = "UPDATE m_employee SET lastname = ?, firstName = ?,  gender=?, areaID = ?, photoURL = ? WHERE empID = ?";

		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection(postID);
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// Beanからのデータの取り出し
			String lastName 	= employee.getLastName();
			String firstName 	= employee.getFirstName();
			String gender 		= employee.getGender();
			int	   areaID		= employee.getAreaID();
            String photo 		= employee.getPhotoURL();
            String empID 		= employee.getEmpID();

			// プレースホルダへの値の設定
			pstmt.setString(1, lastName);
			pstmt.setString(2, firstName);
			pstmt.setString(3, gender);
			pstmt.setInt(4, areaID);
            pstmt.setString(5, photo);
            pstmt.setString(6, empID);

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
	 * 
	 * @param ID
	 * @param TFNum
	 * @return
	 */
	public int hiddenEmp(String ID, int TFNum) {
		int count = 0; //処理件数
		
		String sql = "UPDATE m_employee SET livingNow = ? WHERE empID = ?";
	
		// データベースへの接続の取得、PreparedStatementの取得
		try(Connection con = ConnectionManager.getConnection(postID);
				PreparedStatement pstmt=con.prepareStatement(sql)){
	
		// プレースホルダへの値の設定
		pstmt.setInt(1,);
		pstmt.setString(2,);
	
		// SQLステートメントの実行
		count = pstmt.executeUpdate();
	}
	return count;
}
	
	/**
	 * 従業員の削除
	 * @param Employee
	 * @return 処理件数
	 */
	public int deleteEmp(EmployeeBean deleteEmployee) throws ClassNotFoundException,SQLException {
		int count = 0; //処理件数
		
		String sql = "Delete from m_employee WHERE empID = ?";

		// データベースへの接続の取得、PreparedStatementの取得
		try(Connection con = ConnectionManager.getConnection(postID);
			PreparedStatement pstmt=con.prepareStatement(sql)){
			
			// Beanからのデータの取り出し
			String empID = deleteEmployee.getEmpID();
			System.out.println(empID);
			// プレースホルダへの値の設定
			pstmt.setString(1,empID);

			// SQLステートメントの実行
			count = pstmt.executeUpdate();
		}
		return count;
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

		return result;

	}


	public String getDateUntilMonth(Date date) {
		String result;

		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月");
		result = df.format(date);




		return result;

	}


	public String getDateUntilMonth(Timestamp timestamp) {
		String result;

		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月");
		result = df.format(timestamp);




		return result;

	}


}
