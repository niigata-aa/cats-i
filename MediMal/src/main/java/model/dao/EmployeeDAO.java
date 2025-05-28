package model.dao;

import java.sql.Date;
import java.util.List;

import model.entity.EmployeeBean;

public class EmployeeDAO {
	
	/**
	 * 入力した内容に不備がないかを判断する
	 * @param empID
	 * @param Password
	 * @return true or false
	 */
	public boolean loginCheck(String empID,String Password) {
		
		return ;
	}
	
	/**
	 * 全ての従業員のリストを返す
	 */
	public List<EmployeeBean> selectAllEmp(){
		
	}
	/**
	 * 検索画面の入力内容に応じた検索を行う
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
