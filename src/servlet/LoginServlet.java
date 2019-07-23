package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserBean;
import dao.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		String userId = request.getParameter("user_id");
		String password = request.getParameter("password");
		
		UserBean user = new UserDao().selectUserByIdPass(userId, password);
		
		if (null != user) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			if (user.getAdministrator() == 1) {
				ArrayList<UserBean> beginnerList = new UserDao().selectUserByTimes();
				ArrayList<UserBean> failureList = new UserDao().selectUserByResult();
				request.setAttribute("beginner-list", beginnerList);
				request.setAttribute("failure-list", failureList);
				request.getRequestDispatcher("/jsp/admin/adminTop.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/jsp/examinee/examineeTop.jsp").forward(request, response);
			}
			
		} else {
			request.setAttribute("error", "ユーザIDまたはパスワードが正しくありません");
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
		}
	}

}
