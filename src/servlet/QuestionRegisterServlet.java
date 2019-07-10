package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.QuestionBean;
import dao.QuestionDao;

/**
 * Servlet implementation class QuestionRegisterServlet
 */

public class QuestionRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionRegisterServlet() {
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
		int role1 = 0;
		int role2 = 0;
		int role3 = 0;
		int role4 = 0;
		int role5 = 0;
		int role6 = 0;
		int role7 = 0;
		int role8 = 0;
		int role9 = 0;
		int pattern = Integer.parseInt(request.getParameter("pattern"));
		String owner = request.getParameter("owner");
		
		if (request.getParameter("role_1") != null) {
			role1 = Integer.parseInt(request.getParameter("role_1"));
		}
		if (request.getParameter("role_2") != null) {
			role2 = Integer.parseInt(request.getParameter("role_2"));
		}
		if (request.getParameter("role_3") != null) {
			role3 = Integer.parseInt(request.getParameter("role_3"));
		}
		if (request.getParameter("role_4") != null) {
			role4 = Integer.parseInt(request.getParameter("role_4"));
		}
		if (request.getParameter("role_5") != null) {
			role5 = Integer.parseInt(request.getParameter("role_5"));
		}
		if (request.getParameter("role_6") != null) {
			role6 = Integer.parseInt(request.getParameter("role_6"));
		}
		if (request.getParameter("role_7") != null) {
			role7 = Integer.parseInt(request.getParameter("role_7"));
		}
		if (request.getParameter("role_8") != null) {
			role8 = Integer.parseInt(request.getParameter("role_8"));
		}
		if (request.getParameter("role_9") != null) {
			role9 = Integer.parseInt(request.getParameter("role_9"));
		}
		
		boolean checkQuestion = new QuestionDao().selectQuestionByQuestionId(questionId);
		
		if (checkQuestion) {
			new QuestionDao().insertQuestion(questionId,text,choice1,choice2,choice3,choice4,correct,role1,role2,role3,role4,role5,role6,role7,role8,role9,pattern,owner);
			
			QuestionBean question = new QuestionDao().selectQuestionByRegisteredQuestionId(questionId);
			request.setAttribute("question_id", question.getQuestionId());
			request.setAttribute("text", question.getText());
			request.setAttribute("choice_1", question.getChoice1());
			request.setAttribute("choice_2", question.getChoice2());
			request.setAttribute("choice_3", question.getChoice3());
			request.setAttribute("choice_4", question.getChoice4());
			request.setAttribute("correct", question.getCorrect());
			request.setAttribute("role_1", question.getRole1());
			request.setAttribute("role_2", question.getRole2());
			request.setAttribute("role_3", question.getRole3());
			request.setAttribute("role_4", question.getRole4());
			request.setAttribute("role_5", question.getRole5());
			request.setAttribute("role_6", question.getRole6());
			request.setAttribute("role_7", question.getRole7());
			request.setAttribute("role_8", question.getRole8());
			request.setAttribute("role_9", question.getRole9());
			request.setAttribute("pattern", question.getPattern());
			request.setAttribute("owner", question.getOwner());
			request.getRequestDispatcher("/jsp/admin/questionRegistered.jsp").forward(request, response);
		} else {
			request.setAttribute("error", "既に登録されている設問IDです");
			request.getRequestDispatcher("/jsp/admin/goToQuestionRegister").forward(request, response);
		}
		
		
	}

}
