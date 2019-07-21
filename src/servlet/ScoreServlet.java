package servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;

import beans.AnswerBean;
import beans.UserBean;
import dao.AnswerDao;
import dao.QuestionDao;
import dao.UserDao;

/**
 * Servlet implementation class ScoreServlet
 */

public class ScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("user");
		String userId = user.getUserId();
		
		boolean qualification = new AnswerDao().selectUserIdByDateTime(userId);
		if (qualification) {
			
			DecimalFormat decimal = new DecimalFormat("00");
			Calendar calendar = Calendar.getInstance();
			
			TimeZone jst = TimeZone.getTimeZone("JST");
			calendar.setTimeZone(jst);
			
			String year = String.valueOf(calendar.get(Calendar.YEAR));
			String month = decimal.format(calendar.get(Calendar.MONTH) + 1);
			String day = decimal.format(calendar.get(Calendar.DATE));
			String hour = decimal.format(calendar.get(Calendar.HOUR_OF_DAY));
			String minute = decimal.format(calendar.get(Calendar.MINUTE));
			String second = decimal.format(calendar.get(Calendar.SECOND));
			
			String dateTime = year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;
			
			int size = Integer.parseInt(request.getParameter("size"));
			for (int i = 0; i < size; i++) {
				
				int answer = Integer.parseInt(request.getParameter("answer" + i));
				String questionId = request.getParameter("question" + i);
				int correct = new QuestionDao().selectCorrectById(questionId);
				
				int correctness;
				if (answer == correct) {
					correctness = 1;
				} else {
					correctness = 0;
				}
				
				new AnswerDao().insertAnswer(dateTime,userId,questionId,answer,correctness);
				
			}
			
			ArrayList<AnswerBean> answerList = new AnswerDao().selectAnswerByDateTime(userId,dateTime);
			
			float denom = answerList.size();
			float numer = 0;
			for (int i = 0; i < denom; i++) {
				AnswerBean ans = (AnswerBean)answerList.get(i);
				if(ans.getCorrectness() == 1){
					numer = numer +1;
				}
			}
			float percentage = numer / denom * 100;
			
			int result;
			if (percentage >= 75.0) {
				result = 1;
			} else {
				result = 0;
			}
			
			BigDecimal bi = new BigDecimal(String.valueOf(percentage));
			double k1 = bi.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
			float k = (float) k1;
			
			String password = RandomStringUtils.randomAlphanumeric(8);
			
			new UserDao().updateUser(userId,password,result,k);
			
			request.setAttribute("percentage", k);
			request.setAttribute("result", result);
			request.setAttribute("answer-list", answerList);
			request.getRequestDispatcher("/jsp/examinee/result.jsp").forward(request, response);
			
		} else {
			session = request.getSession(false);
			
			if (session != null) {
				session.invalidate();
			}
			
			request.getRequestDispatcher("/jsp/examinee/login.jsp").forward(request, response);
		}
	}

}
