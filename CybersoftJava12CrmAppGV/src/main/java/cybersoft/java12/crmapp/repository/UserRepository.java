package cybersoft.java12.crmapp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import cybersoft.java12.crmapp.dbconnection.MySqlConnection;
import cybersoft.java12.crmapp.model.User;


public class UserRepository {
		

	public int checkUserRepositry(String email, String password) {
		int rs = -1;
		try {
			Connection connection = MySqlConnection.getConnection();
			String query = "SELECT email, password FROM user WHERE email = ? and password = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setNString(1, email);
			statement.setNString(2, password);
			
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				if(email.equals(result.getString("email")) && password.equals(result.getString("password"))) {
					return 1;
				}
			}
		} catch (Exception e) {
			System.out.println("Connection to databse is fail");
			e.printStackTrace();
			
		}
		return rs;
}
}
