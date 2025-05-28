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
	
	private String empID;
	
	public EmployeeDAO(String LoginID) {
		this.empID=LoginID;
	}
	
	public List<EmployeeBean> selectAllEmp () throws SQLException,ClassNotFoundException {
		List<EmployeeBean> employeeList = new ArrayList<EmployeeBean>();
		
		//データベースの接続の取得、Statementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManagerKeeper.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery("SELECT * FROM m_employee")){
		
		while(res.next()){
			String empID = res.getString("empID");
			String lastName = res.getString("lastName");
			String firstName = res.getString("firstname");
			String gernder = res.getString("gender");
			String post = res.getString("post");
			String area = res.getString("area");
			String startWork = getTimestamp(res.getTimestamp("startWork"));
			String password = res.getString("password");
			int workingNow = res.getInt("workingNow");
			String photo = res.getString("photo");
			
			EmployeeBean employee = new EmployeeBean();
			employee.setEmpID(empID);
			employee.setLastName(lastName);
			employee.setFirstName(firstName);
			employee.setGender(gernder);
			employee.setPost(post);
			employee.setArea(area);
			employee.setStartWork(startWork);
			employee.setPhoto(photo);
			
			
			}
		}
	return employeeList;
	}
	 public static String getTimestamp(Timestamp date){ 
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		 return sdf.format(date);
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
		String sql = "select empID ,Password from m_employee where empID= ? and Password = ?";
		
		try(Connection con = ConnectionManager.getConnection(empID);
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
	public List<EmployeeBean> selectAllEmp(){
		
	}
	/**
	 * 検索画面の入力内容に応じた検索を行う.
	 * @param Employee
	 * @return
	 */
	public List<EmployeeBean> selectEmpByField(EmployeeBean Employee){
		
		return ;
	}
	
	/**
	 * 従業員の登録を行う
	 * @param Employee
	 */
	public void insertEmp(EmployeeBean Employee) {
		
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
}
