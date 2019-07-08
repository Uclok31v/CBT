package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserDeleteComfirmServlet
 */

public class UserDeleteComfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDeleteComfirmServlet() {
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
		String userName = request.getParameter("user_name");
		int role1 = Integer.parseInt(request.getParameter("role_1"));
		int role2 = Integer.parseInt(request.getParameter("role_2"));
		int role3 = Integer.parseInt(request.getParameter("role_3"));
		int role4 = Integer.parseInt(request.getParameter("role_4"));
		int role5 = Integer.parseInt(request.getParameter("role_5"));
		int role6 = Integer.parseInt(request.getParameter("role_6"));
		int role7 = Integer.parseInt(request.getParameter("role_7"));
		int role8 = Integer.parseInt(request.getParameter("role_8"));
		int role9 = Integer.parseInt(request.getParameter("role_9"));
		
		request.setAttribute("user_id", userId);
		request.setAttribute("user_name", userName);
		request.setAttribute("role_1", role1);
		request.setAttribute("role_2", role2);
		request.setAttribute("role_3", role3);
		request.setAttribute("role_4", role4);
		request.setAttribute("role_5", role5);
		request.setAttribute("role_6", role6);
		request.setAttribute("role_7", role7);
		request.setAttribute("role_8", role8);
		request.setAttribute("role_9", role9);
		
		request.getRequestDispatcher("/jsp/admin/userDeleteComfirm.jsp").forward(request, response);
	}

}
