package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import gui.MainFrame;


public class DatabaseConn {
	
	//CREATING NEW CONNECTION WITH DB
	private static Connection connect() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/airlines",
	                "root", "root12345");
			return connection;
		} catch (Exception e) {
			System.out.println(e);
			return connection;
		}
	}
	
	//CHECKING DB CONNECTION
	public static void main(String[] args) {
		try {
			Connection connection = connect();
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
	
	//USER REGISTRATION METHOD
	public static int registerNewUser(String username, String password, String email) {
		try {
			Connection connection = connect();
			String registerQuery = "insert into airlines.Users (username, pass, email) values(?, ?, ?);";
			PreparedStatement registerStmt = connection.prepareStatement(registerQuery, Statement.RETURN_GENERATED_KEYS);
			registerStmt.setString(1, username);
			registerStmt.setString(2, password);
			registerStmt.setString(3, email);
			int affectedRows = registerStmt.executeUpdate();
			if (affectedRows>0) {
				ResultSet record = registerStmt.getGeneratedKeys();
				if (record.next()) {
					Long newId = record.getLong(1);
					int buttonResponse = JOptionPane.showOptionDialog(MainFrame.getMainFrame(),"ユーザー登録完成いたしました。\nログイン画面からログインしてください。", "通知" ,JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
					if (buttonResponse == 0) return 1;
				}
			}
			connection.close();
			return 0;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	
	//FETCHING QUERY
	public ResultSet fetchData(String query) {
		try {
			Connection connection = connect();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			resultSet.close();
			statement.close();
			connection.close();
			return resultSet;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
			
		}
	}
	
	//USER AUTHENTICATION METHOD
	public static ResultSet authenticate(String username, String password) {
		try {
			Connection connection = connect();
			String authQuery = "select * from users where username=? and pass=?;";
			PreparedStatement authStmt = connection.prepareStatement(authQuery);
			authStmt.setString(1, username);
			authStmt.setString(2, password);
			ResultSet userData = authStmt.executeQuery();
			if (userData.next()) {
				System.out.println(userData.getLong(1));
				System.out.println(userData.getString("username"));
				System.out.println(userData.getString("pass"));
				return userData;
			}
			return null;
		} catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public static void lookUpUser(String email) {
	}
}
