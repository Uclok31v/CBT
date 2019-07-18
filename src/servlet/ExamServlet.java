package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.QuestionBean;
import beans.UserBean;
import dao.QuestionDao;

/**
 * Servlet implementation class ExamServlet
 */

public class ExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamServlet() {
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
		
		if (user.getRole1() == 0 && user.getRole2() == 0 && user.getRole3() == 0 && user.getRole4() == 0 && user.getRole5() == 0 && user.getRole6() == 0 && user.getRole7() == 0 && user.getRole8() == 0 && user.getRole9() == 0) {
			request.setAttribute("error", "ロールが設定されていません");
			request.getRequestDispatcher("/jsp/examinee/examineeTop.jsp").forward(request, response);
		} else {
			ArrayList<QuestionBean> questionList = new QuestionDao().selectQuestionByRole(user.getRole1(),user.getRole2(),user.getRole3(),user.getRole4(),user.getRole5(),user.getRole6(),user.getRole7(),user.getRole8(),user.getRole9(),user.getTimes());
			session.setAttribute("question-list", questionList);
			request.getRequestDispatcher("/jsp/examinee/exam.jsp").forward(request, response);
		}
	}

}
