package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.QuestionBean;
import utility.DriverAccessor;

public class QuestionDao extends DriverAccessor{

	public void insertQuestion(String questionId, String text, String choice1, String choice2, String choice3,
			String choice4, int correct, int role1, int role2, int role3, int role4, int role5, int role6, int role7,
			int role8, int role9, int pattern, String owner) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			String sql = "insert into question(question_id, text, choice_1, choice_2, choice_3, choice_4, correct, role_1, role_2, role_3, role_4, role_5, role_6, role_7, role_8, role_9, pattern, owner) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			connection = createConnection();
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, questionId);
			statement.setString(2, text);
			statement.setString(3, choice1);
			statement.setString(4, choice2);
			statement.setString(5, choice3);
			statement.setString(6, choice4);
			statement.setInt(7, correct);
			statement.setInt(8, role1);
			statement.setInt(9, role2);
			statement.setInt(10, role3);
			statement.setInt(11, role4);
			statement.setInt(12, role5);
			statement.setInt(13, role6);
			statement.setInt(14, role7);
			statement.setInt(15, role8);
			statement.setInt(16, role9);
			statement.setInt(17, pattern);
			statement.setString(18, owner);
			
			statement.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		
	}

	public boolean selectQuestionByQuestionId(String questionId) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			String sql = "select * from question where question_id = ?";
			connection = createConnection();
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, questionId);
			
			ResultSet resultSet = statement.executeQuery();
			
			ArrayList<QuestionBean> questionList = new ArrayList<QuestionBean>();
			while (resultSet.next()) {
				QuestionBean question = new QuestionBean();
				question.setQuestionId(resultSet.getString("question_id"));
				question.setText(resultSet.getString("text"));
				question.setChoice1(resultSet.getString("choice_1"));
				question.setChoice2(resultSet.getString("choice_2"));
				question.setChoice3(resultSet.getString("choice_3"));
				question.setChoice4(resultSet.getString("choice_4"));
				question.setCorrect(resultSet.getInt("correct"));
				question.setRole1(resultSet.getInt("role_1"));
				question.setRole2(resultSet.getInt("role_2"));
				question.setRole3(resultSet.getInt("role_3"));
				question.setRole4(resultSet.getInt("role_4"));
				question.setRole5(resultSet.getInt("role_5"));
				question.setRole6(resultSet.getInt("role_6"));
				question.setRole7(resultSet.getInt("role_7"));
				question.setRole8(resultSet.getInt("role_8"));
				question.setRole9(resultSet.getInt("role_9"));
				question.setPattern(resultSet.getInt("pattern"));
				question.setOwner(resultSet.getString("owner"));
				
				questionList.add(question);
			}
			
			statement.close();
			resultSet.close();
			
			if (questionList.size() != 0) {
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

	public QuestionBean selectQuestionByRegisteredQuestionId(String questionId) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			String sql = "select * from question where question_id = ?";
			connection = createConnection();
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, questionId);
			
			ResultSet resultSet = statement.executeQuery();
			
			QuestionBean question = new QuestionBean();
			
			while (resultSet.next()) {
				question.setQuestionId(resultSet.getString("question_id"));
				question.setText(resultSet.getString("text"));
				question.setChoice1(resultSet.getString("choice_1"));
				question.setChoice2(resultSet.getString("choice_2"));
				question.setChoice3(resultSet.getString("choice_3"));
				question.setChoice4(resultSet.getString("choice_4"));
				question.setCorrect(resultSet.getInt("correct"));
				question.setRole1(resultSet.getInt("role_1"));
				question.setRole2(resultSet.getInt("role_2"));
				question.setRole3(resultSet.getInt("role_3"));
				question.setRole4(resultSet.getInt("role_4"));
				question.setRole5(resultSet.getInt("role_5"));
				question.setRole6(resultSet.getInt("role_6"));
				question.setRole7(resultSet.getInt("role_7"));
				question.setRole8(resultSet.getInt("role_8"));
				question.setRole9(resultSet.getInt("role_9"));
				question.setPattern(resultSet.getInt("pattern"));
				question.setOwner(resultSet.getString("owner"));
				
			}
			
			resultSet.close();
			
			return question;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			closeConnection(connection);
		}
	}

	public ArrayList<QuestionBean> selectQuestion() {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			String sql = "select * from question";
			connection = createConnection();
			statement = connection.prepareStatement(sql);
			
			ResultSet resultSet = statement.executeQuery();
			
			ArrayList<QuestionBean> questionList = new ArrayList<QuestionBean>();
			while (resultSet.next()) {
				QuestionBean question = new QuestionBean();
				question.setQuestionId(resultSet.getString("question_id"));
				question.setText(resultSet.getString("text"));
				question.setChoice1(resultSet.getString("choice_1"));
				question.setChoice2(resultSet.getString("choice_2"));
				question.setChoice3(resultSet.getString("choice_3"));
				question.setChoice4(resultSet.getString("choice_4"));
				question.setCorrect(resultSet.getInt("correct"));
				question.setRole1(resultSet.getInt("role_1"));
				question.setRole2(resultSet.getInt("role_2"));
				question.setRole3(resultSet.getInt("role_3"));
				question.setRole4(resultSet.getInt("role_4"));
				question.setRole5(resultSet.getInt("role_5"));
				question.setRole6(resultSet.getInt("role_6"));
				question.setRole7(resultSet.getInt("role_7"));
				question.setRole8(resultSet.getInt("role_8"));
				question.setRole9(resultSet.getInt("role_9"));
				question.setPattern(resultSet.getInt("pattern"));
				question.setOwner(resultSet.getString("owner"));
				
				questionList.add(question);
			}
			
			statement.close();
			resultSet.close();
			
			return questionList;
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			closeConnection(connection);
		}
	}

	public void updateQuestionById(String questionId, String text, String choice1, String choice2, String choice3,
			String choice4, int correct, int role1, int role2, int role3, int role4, int role5, int role6, int role7,
			int role8, int role9, int pattern, String owner) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			String sql = "update question set text = ?, choice_1 = ?, choice_2 = ?, choice_3 = ?, choice_4 = ?, correct = ?, role_1 = ?, role_2 = ?, role_3 = ?, role_4 = ?, role_5 = ?, role_6 = ?, role_7 = ?, role_8 = ?, role_9 = ?, pattern = ?, owner = ? where question_id = ?";
			connection = createConnection();
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, text);
			statement.setString(2, choice1);
			statement.setString(3, choice2);
			statement.setString(4, choice3);
			statement.setString(5, choice4);
			statement.setInt(6, correct);
			statement.setInt(7, role1);
			statement.setInt(8, role2);
			statement.setInt(9, role3);
			statement.setInt(10, role4);
			statement.setInt(11, role5);
			statement.setInt(12, role6);
			statement.setInt(13, role7);
			statement.setInt(14, role8);
			statement.setInt(15, role9);
			statement.setInt(16, pattern);
			statement.setString(17, owner);
			statement.setString(18, questionId);
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

	public void deleteQuestionById(String questionId) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			String sql = "delete from question where question_id = ?";
			connection = createConnection();
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, questionId);
			
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

	public ArrayList<QuestionBean> selectQuestionByRole(int role1, int role2, int role3, int role4, int role5,
			int role6, int role7, int role8, int role9, int times) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		int n;
		if (times % 2 == 0) {
			n = 2;
		} else {
			n = 1;
		}
		
		try {
			String sql = "select * from question where pattern != " + n;
			int i = 0;
			if (role1 == 1) {
				String condition = " and role_1 = 1";
				sql = sql + condition;
				i = i + 1;
			}
			if (role2 == 1) {
				String condition;
				if (i == 0) {
					condition = " and role_2 = 1";
				} else {
					condition = " or role_2 = 1";
				}
				sql = sql + condition;
				i = i + 1;
			}
			if (role3 == 1) {
				String condition;
				if (i == 0) {
					condition = " and role_3 = 1";
				} else {
					condition = " or role_3 = 1";
				}
				sql = sql + condition;
				i = i + 1;
			}
			if (role4 == 1) {
				String condition;
				if (i == 0) {
					condition = " and role_4 = 1";
				} else {
					condition = " or role_4 = 1";
				}
				sql = sql + condition;
				i = i + 1;
			}
			if (role5 == 1) {
				String condition;
				if (i == 0) {
					condition = " and role_5 = 1";
				} else {
					condition = " or role_5 = 1";
				}
				sql = sql + condition;
				i = i + 1;
			}
			if (role6 == 1) {
				String condition;
				if (i == 0) {
					condition = " and role_6 = 1";
				} else {
					condition = " or role_6 = 1";
				}
				sql = sql + condition;
				i = i + 1;
			}
			if (role7 == 1) {
				String condition;
				if (i == 0) {
					condition = " and role_7 = 1";
				} else {
					condition = " or role_7 = 1";
				}
				sql = sql + condition;
				i = i + 1;
			}
			if (role8 == 1) {
				String condition;
				if (i == 0) {
					condition = " and role_8 = 1";
				} else {
					condition = " or role_8 = 1";
				}
				sql = sql + condition;
				i = i + 1;
			}
			if (role9 == 1) {
				String condition;
				if (i == 0) {
					condition = " and role_9 = 1";
				} else {
					condition = " or role_9 = 1";
				}
				sql = sql + condition;
				i = i + 1;
			}
			
			connection = createConnection();
			statement = connection.prepareStatement(sql);
			
			ResultSet resultSet = statement.executeQuery();
			
			ArrayList<QuestionBean> questionList = new ArrayList<QuestionBean>();
			while (resultSet.next()) {
				QuestionBean question = new QuestionBean();
				question.setQuestionId(resultSet.getString("question_id"));
				question.setText(resultSet.getString("text"));
				question.setChoice1(resultSet.getString("choice_1"));
				question.setChoice2(resultSet.getString("choice_2"));
				question.setChoice3(resultSet.getString("choice_3"));
				question.setChoice4(resultSet.getString("choice_4"));
				question.setCorrect(resultSet.getInt("correct"));
				question.setRole1(resultSet.getInt("role_1"));
				question.setRole2(resultSet.getInt("role_2"));
				question.setRole3(resultSet.getInt("role_3"));
				question.setRole4(resultSet.getInt("role_4"));
				question.setRole5(resultSet.getInt("role_5"));
				question.setRole6(resultSet.getInt("role_6"));
				question.setRole7(resultSet.getInt("role_7"));
				question.setRole8(resultSet.getInt("role_8"));
				question.setRole9(resultSet.getInt("role_9"));
				question.setPattern(resultSet.getInt("pattern"));
				question.setOwner(resultSet.getString("owner"));
				
				questionList.add(question);
			}
			
			statement.close();
			resultSet.close();
			
			return questionList;
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			closeConnection(connection);
		}
	}

}
