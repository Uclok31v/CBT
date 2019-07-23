package servlet;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserBean;
import dao.UserDao;

/**
 * Servlet implementation class UserUpdateServlet
 */

public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateServlet() {
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
		int role1 = 0;
		int role2 = 0;
		int role3 = 0;
		int role4 = 0;
		int role5 = 0;
		int role6 = 0;
		int role7 = 0;
		int role8 = 0;
		int role9 = 0;
		
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
		
		new UserDao().updateUserById(userId,userName,role1,role2,role3,role4,role5,role6,role7,role8,role9,dateTime);
		UserBean user = new UserDao().selectUserByRegisteredUserId(userId);
		request.setAttribute("user_id", user.getUserId());
		request.setAttribute("user_name", user.getUserName());
		request.setAttribute("role_1", user.getRole1());
		request.setAttribute("role_2", user.getRole2());
		request.setAttribute("role_3", user.getRole3());
		request.setAttribute("role_4", user.getRole4());
		request.setAttribute("role_5", user.getRole5());
		request.setAttribute("role_6", user.getRole6());
		request.setAttribute("role_7", user.getRole7());
		request.setAttribute("role_8", user.getRole8());
		request.setAttribute("role_9", user.getRole9());
		request.getRequestDispatcher("/jsp/admin/userUpdated.jsp").forward(request, response);
	}

}
