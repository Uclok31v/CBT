package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.AnswerBean;
import utility.DriverAccessor;

public class AnswerDao extends DriverAccessor{

	public void insertAnswer(String dateTime, String userId, String questionId, int answer, int correctness) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			String sql = "insert into answer(datetime, user_id, question_id, answer, correctness) values(?,?,?,?,?)";
			connection = createConnection();
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, dateTime);
			statement.setString(2, userId);
			statement.setString(3, questionId);
			statement.setInt(4, answer);
			statement.setInt(5, correctness);
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		
	}

	public ArrayList<AnswerBean> selectAnswerByDateTime(String userId, String dateTime) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			String sql = "select * from answer where user_id = ? and datetime = ?";
			connection = createConnection();
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, userId);
			statement.setString(2, dateTime);
			
			ResultSet resultSet = statement.executeQuery();
			
			ArrayList<AnswerBean> answerList = new ArrayList<AnswerBean>();
			while (resultSet.next()) {
				AnswerBean answer = new AnswerBean();
				answer.setAnswerId(resultSet.getInt("answer_id"));
				answer.setDateTime(resultSet.getString("datetime"));
				answer.setUserId(resultSet.getString("user_id"));
				answer.setQuestionId(resultSet.getString("question_id"));
				answer.setAnswer(resultSet.getInt("answer"));
				answer.setCorrectness(resultSet.getInt("correctness"));
				answerList.add(answer);
			}
			
			statement.close();
			resultSet.close();
			
			return answerList;
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			closeConnection(connection);
		}
	}

	public boolean selectUserIdByDateTime(String userId) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			String sql = "select * from answer where user_id = ? and datetime >= (now() - interval 20 day)";
			connection = createConnection();
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, userId);
			
			ResultSet resultSet = statement.executeQuery();
			
			ArrayList<AnswerBean> answerList = new ArrayList<AnswerBean>();
			while (resultSet.next()) {
				AnswerBean answer = new AnswerBean();
				answer.setAnswerId(resultSet.getInt("answer_id"));
				answer.setDateTime(resultSet.getString("datetime"));
				answer.setUserId(resultSet.getString("user_id"));
				answer.setQuestionId(resultSet.getString("question_id"));
				answer.setAnswer(resultSet.getInt("answer"));
				answer.setCorrectness(resultSet.getInt("correctness"));
				answerList.add(answer);
			}
			
			statement.close();
			resultSet.close();
			
			if (answerList.size() !=0) {
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
	
	

}
