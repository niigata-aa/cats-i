package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerKeeper {
	/*接続設定の定義*/
	private static final String URL = "jdbc:mysql://localhost:3306/データベース";
	private static final String USER = "ユーザ名";
	private static final String PASSWORD = "パスワード";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

}
