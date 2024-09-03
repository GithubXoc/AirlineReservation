package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConn {
	public static void main(String[] args) {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/airlines",
	                "root", "root12345");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM users;");
			System.out.println(resultSet);
			int code;
			String title;
			while(resultSet.next()) {
				System.out.println(resultSet);
				code = resultSet.getInt("id");
                title = resultSet.getString("username").trim();
                System.out.println("Code : " +code
                                   + " Title : " + title);
			}
			resultSet.close();
			statement.close();
			connection.close();
			
			
		} catch (Exception e) {
			System.out.println(e);
			
		}
	}
	
	public static void registerNewUser(String username, String password) {
		Connection connection = null;
		try {
			String registerQuery = "insert into airlines.Users (username, pass) values(?, ?);";
			@SuppressWarnings("null")
			PreparedStatement registerStmt = connection.prepareStatement(registerQuery);
			registerStmt.setString(1, username);
			registerStmt.setString(2, password);
			registerStmt.executeQuery();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public ResultSet fetchData(String query) {
		try {
			Connection connection = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/airlines",
	                "root", "root12345");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			System.out.println(resultSet);
			resultSet.close();
			statement.close();
			connection.close();
			return resultSet;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
			
		}
	}

}
