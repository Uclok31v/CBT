package dao;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


import beans.UserBean;
import utility.DriverAccessor;

public class UserDao extends DriverAccessor{
	
	public UserBean selectUserByIdPass (String userId,String password) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			String sql = "select * from user where user_id = ?";
			connection = createConnection();
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, userId);
			
			ResultSet resultSet = statement.executeQuery();
			
			UserBean user = new UserBean();
			
			while(resultSet.next()){
				user.setUserId(resultSet.getString("user_id"));
				user.setUserName(resultSet.getString("user_name"));
				user.setPassword(resultSet.getString("password"));
				user.setAdministrator(resultSet.getInt("administrator"));
				user.setRole1(resultSet.getInt("role_1"));
				user.setRole2(resultSet.getInt("role_2"));
				user.setRole3(resultSet.getInt("role_3"));
				user.setRole4(resultSet.getInt("role_4"));
				user.setRole5(resultSet.getInt("role_5"));
				user.setRole6(resultSet.getInt("role_6"));
				user.setRole7(resultSet.getInt("role_7"));
				user.setRole8(resultSet.getInt("role_8"));
				user.setRole9(resultSet.getInt("role_9"));
				user.setTimes(resultSet.getInt("times"));
				user.setResult(resultSet.getInt("result"));
				user.setPercentage(resultSet.getFloat("percentage"));
				user.setDateTime(resultSet.getString("datetime"));
				
			}
			
			resultSet.close();
			
			if (password.equals(user.getPassword())) {
				return user;
			} else {
				return null;
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			closeConnection(connection);
		}
		
	}


}
