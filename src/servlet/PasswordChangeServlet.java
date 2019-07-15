package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserBean;
import dao.UserDao;

/**
 * Servlet implementation class PasswordChangeServlet
 */

public class PasswordChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordChangeServlet() {
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
		String password = new UserDao().selectPassword(userId);

		String currentPassword = request.getParameter("currentPassword");
		String newPassword = request.getParameter("newPassword");
		String rePassword = request.getParameter("rePassword");
		
		if (!(currentPassword.equals(password))) {
			request.setAttribute("error", "現在のパスワードが正しくありません");
			request.getRequestDispatcher("./passwordChange.jsp").forward(request, response);
		} else if (!(newPassword.equals(rePassword))) {
			request.setAttribute("error", "新しいパスワードと新しいパスワード（確認）が違います");
			request.getRequestDispatcher("./passwordChange.jsp").forward(request, response);
		} else {
			new UserDao().updatePassword(userId, newPassword);
			request.getRequestDispatcher("./passwordChanged.jsp").forward(request, response);
		}
	}

}
