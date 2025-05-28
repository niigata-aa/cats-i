package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.entity.EmployeeBean;

public class EmployeeDAO {
	
	private String empID;
	
	public EmployeeDAO(String LoginID) {
		this.empID=LoginID;
	}
	
	/**
	 * 入力した内容に不備がないかを判断する
	 * @param empID
	 * @param Password
	 * @return true or false
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
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
