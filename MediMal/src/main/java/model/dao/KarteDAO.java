package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class KarteDAO {
	
	
	/**体重を追加する*/
		public int insertWeight(Weight inputWeight) {
		return
	}
	
		
	/**全ての体重履歴を検索する*/
	public List<Weight> selectAllWeight() {
		return
	}
	
	
	/**投薬履歴を追加する*/
	public int insertDrug(Drug inputDrud) {
		int count = 0;
		String url = "insert into t_dosage(dosagedate,doseAbout,doseAmount) values (?,?,?)";
		
		try(Connection con = ConnectionManagerMedical.getConnection();
				PreparedStatement pstmt = con.prepareStatement(url)){
			
			pstmt.setDate(1, date);
			
			
			
		}
		
		return count;
	}
	
	
	/**全ての投薬履歴を検索する*/
	public List<Drug> selectAllDrug() {
		return
	}
	
	
	/**コメントを追加する*/
	public int insertComment(Comment wroteComment) {
		return
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
