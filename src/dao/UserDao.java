package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

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

	public void insertUser(String userId, String userName, String password, int administrator, int role1, int role2, int role3,
			int role4, int role5, int role6, int role7, int role8, int role9, int times, String dateTime) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			String sql = "insert into user(user_id, user_name, password, administrator, role_1, role_2, role_3, role_4, role_5, role_6, role_7, role_8, role_9, times, datetime) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			connection = createConnection();
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, userId);
			statement.setString(2, userName);
			statement.setString(3, password);
			statement.setInt(4, administrator);
			statement.setInt(5, role1);
			statement.setInt(6, role2);
			statement.setInt(7, role3);
			statement.setInt(8, role4);
			statement.setInt(9, role5);
			statement.setInt(10, role6);
			statement.setInt(11, role7);
			statement.setInt(12, role8);
			statement.setInt(13, role9);
			statement.setInt(14, times);
			statement.setString(15, dateTime);
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

	public boolean selectUserByUserId(String userId) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			String sql = "select * from user where user_id = ?";
			connection = createConnection();
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, userId);
			
			ResultSet resultSet = statement.executeQuery();
			
			ArrayList<UserBean> userList = new ArrayList<UserBean>();
			while(resultSet.next()){
				UserBean user = new UserBean();
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
				
				userList.add(user);
			}
			
			statement.close();
			resultSet.close();
			
			if (userList.size() != 0) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		} finally {
			closeConnection(connection);
		}
	}

	public UserBean selectUserByRegisterdUserId(String userId) {
		// TODO Auto-generated method stub
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
			
			return user;
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			closeConnection(connection);
		}

	}


}
