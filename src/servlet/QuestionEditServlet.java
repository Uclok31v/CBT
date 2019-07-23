package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserBean;
import dao.UserDao;

/**
 * Servlet implementation class QuestionEditServlet
 */

public class QuestionEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionEditServlet() {
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
		
		String questionId = request.getParameter("question_id");
		String text = request.getParameter("text");
		String choice1 = request.getParameter("choice_1");
		String choice2 = request.getParameter("choice_2");
		String choice3 = request.getParameter("choice_3");
		String choice4 = request.getParameter("choice_4");
		int correct = Integer.parseInt(request.getParameter("correct"));
		int role1 = Integer.parseInt(request.getParameter("role_1"));
		int role2 = Integer.parseInt(request.getParameter("role_2"));
		int role3 = Integer.parseInt(request.getParameter("role_3"));
		int role4 = Integer.parseInt(request.getParameter("role_4"));
		int role5 = Integer.parseInt(request.getParameter("role_5"));
		int role6 = Integer.parseInt(request.getParameter("role_6"));
		int role7 = Integer.parseInt(request.getParameter("role_7"));
		int role8 = Integer.parseInt(request.getParameter("role_8"));
		int role9 = Integer.parseInt(request.getParameter("role_9"));
		int pattern = Integer.parseInt(request.getParameter("pattern"));
		String owner = request.getParameter("owner");
		
		request.setAttribute("question_id", questionId);
		request.setAttribute("text", text);
		request.setAttribute("choice_1", choice1);
		request.setAttribute("choice_2", choice2);
		request.setAttribute("choice_3", choice3);
		request.setAttribute("choice_4", choice4);
		request.setAttribute("correct", correct);
		request.setAttribute("role_1", role1);
		request.setAttribute("role_2", role2);
		request.setAttribute("role_3", role3);
		request.setAttribute("role_4", role4);
		request.setAttribute("role_5", role5);
		request.setAttribute("role_6", role6);
		request.setAttribute("role_7", role7);
		request.setAttribute("role_8", role8);
		request.setAttribute("role_9", role9);
		request.setAttribute("pattern", pattern);
		request.setAttribute("owner", owner);
		
		ArrayList<UserBean> adminList = new UserDao().selectAdministrator();
		request.setAttribute("admin-list", adminList);
		
		request.getRequestDispatcher("/jsp/admin/questionEdit.jsp").forward(request, response);
	}

}
