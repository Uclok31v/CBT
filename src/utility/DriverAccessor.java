package utility;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DriverAccessor {
	
	private final static String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
	private final static String JDBC_URL="jdbc:mysql://localhost:3306/cbt?useUnicode=true&characterEncoding=UTF-8";
	private final static String USER_NAME="root";
	private final static String PASSWORD="";

	//DBの接続情報を持ったconnectionオブジェクトを返す
	public Connection createConnection(){
	try{
		//JDBCドライバを読み込み
		Class.forName(JDBC_DRIVER);
				
		//DB接続の確立
		Connection connection = DriverManager.getConnection(JDBC_URL, USER_NAME, PASSWORD);
		
		return connection;
		
		}catch(ClassNotFoundException e){
			System.out.println("Can't Find JDBC Driver.\n");
			}catch(SQLException e){
				 System.out.println("Connection Error.\n");
				 }
			return null;
	}
	
	//connectionオブジェクトを使って、DBとの接続を切断する
	public void closeConnection(Connection connection){
		try{
			connection.close();
		}catch(Exception ex){
			
		}
	}

}
