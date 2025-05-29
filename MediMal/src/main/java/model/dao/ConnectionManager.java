package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ConnectionManagerの仕様について
 * 
 * 今回のシステムでは権限が三つあるので,その権限に応じたUSER,PASSWORDを利用したgetConnectionが必要になります。
 * 
 * そのために今回はログインするときの従業員IDを参照する形にします。
 * 
 * 具体的には下のほうにもコメントを残しましたが、getConnectionの引数にセッションスコープ内に保存したLoginIDという値を与えて、
 * その中の頭文字２文字を切り出してその値に応じてデータベースへの接続をチャレンジします。
 * 
 * なので、これ以降try(){
 * の中で、Connection con を必要とするメソッドの引数には必ずString LoginIDを設定する必要が生まれます。
 * 更新版
 * 
 */



public class ConnectionManager {
	/*データベースURL*/
	private static final String URL = "jdbc:mysql://localhost:3306/MedimalDB";
	
	/*人事用USERとPASSWORD*/
	private static final String USER_PERSONAL 		= "personal"		;
	private static final String PASSWORD_PERSONAL 	= "human_resources"	;
	/*飼育員用USERとPASSWORD*/
	private static final String USER_KEEPER			= "keeper"			;
	private static final String PASSWORD_KEEPER		= "zookeepers"		;
	/*獣医用のUSERとPASS*/
	private static final String USER_MEDICAL		= "medical"			;
	private static final String PASSWORD_MEDICAL	= "meidcalStaff"	;
	/*入力エラー用のUSERとPASSWORD(これを使うと設定してないユーザーなので多分接続失敗してくれるはず)*/
	private static final String USER_ERROR			= "ERROR_USER"			;
	private static final String PASSWORD_ERROR		= "Error_PASS"			;
	
	
	public static Connection getConnection(String LoginID) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		/**
		 * 返り値用のConnection
		 * */
		Connection result;
		
		/**
		 * IDhead -従業員IDの頭二文字を切り出し
		 * 例:100011なら「10」0011
		 */
		
		String IDhead = LoginID.substring(0, 2);
		
		System.out.println(IDhead);
		
		/**
		 * 上で切り出した値で分岐10,20,30ならそれぞれの権限で接続が試みられて、それ以外なら接続失敗するUSER,PASSで接続チャレンジされる。
		 */
		
		if (IDhead.equals("10")) {
			result=DriverManager.getConnection(URL, USER_PERSONAL, PASSWORD_PERSONAL);
		}else if (IDhead.equals("20")) {
			result=DriverManager.getConnection(URL, USER_KEEPER, PASSWORD_KEEPER);
		}else if (IDhead.equals("30")) {
			result=DriverManager.getConnection(URL, USER_MEDICAL, PASSWORD_MEDICAL);
		}else {
			result=DriverManager.getConnection(URL, USER_ERROR, PASSWORD_ERROR);
		}
		
		return result;
	}

}
