package P22_JDBC;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class E18_JDBCProperties {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		try(Connection conn = DriverManager.getConnection(Config.get("url"), Config.getProperties())) {
			
			Statement stat = conn.createStatement();
			
			ResultSet result = stat.executeQuery("SELECT * FROM city where CountryCode = 'CHL' LIMIT 10");
			
			while(result.next()) {
				System.out.println("-----------------------------");
				System.out.println("ID: " + result.getInt("ID"));
				System.out.println("Name: " + result.getString("Name"));
				System.out.println("Country Code: " + result.getString("CountryCode"));
				System.out.println("District: " + result.getString("District"));
				System.out.println("Population: " + result.getInt("Population"));
				System.out.println("-----------------------------");
				System.out.println();
			}
			
		}
		
	}
	
	private static class Config {
		
		private static Properties p = new Properties();
		
		static {
			try {
				InputStream in = new FileInputStream("files/config.properties");
				p.load(in);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public static String get(String key) {
			return p.getProperty(key);
		}
		
		public static Properties getProperties() {
			return (Properties) p.clone();
		}
		
	}
	
}
