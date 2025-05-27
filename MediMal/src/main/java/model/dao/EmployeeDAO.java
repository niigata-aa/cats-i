package model.dao;

import java.sql.Date;
import java.util.List;

import model.entity.EmployeeBean;

public class EmployeeDAO {
	
	/**
	 * 
	 * @param empID
	 * @param Password
	 * @return
	 */
	public boolean loginCheck(String empID,String Password) {
		
		return ;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<EmployeeBean> selectAllEmp(){
		
	}
	
	public List<EmployeeBean> selectEmpByField(EmployeeBean Employee){
		
		return ;
	}
	
	public void insertEmp(EmployeeBean Employee) {
		
	}
	
	public int updateEmp(EmployeeBean Employee) {
		
		return ;
	}
	
	public int hiddenEmp(String ID, int TFNum) {
		
		return ;
	}
	
	public int deleteEmp(EmployeeBean Employee) {
		
		return ;
	}
	
	public int getYearsOfWorking(Date StartYear) {
		
		return ;
	}
}
