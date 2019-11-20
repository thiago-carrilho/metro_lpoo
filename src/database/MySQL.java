package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {
		private static Connection conn = null;
		
		private MySQL() {
			
		}
		
		public static Connection getConnection() throws Exception {  
			if(conn==null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/metroprojeto", "root", "root");
			}
			return conn;
		}
		public static void setData(PreparedStatement sql) throws Exception {
	        Connection co = MySQL.getConnection();
	        sql.executeUpdate();
	    }
		public static ResultSet getData(PreparedStatement sql) throws Exception{
			ResultSet rs = sql.executeQuery();
			return rs;
		}
		
	
}
