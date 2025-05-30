package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.EmployeeDAO;
import model.entity.EmployeeBean;

/**
 * Servlet implementation class FinalDeleteKeeperCheckServlet
 */
@WebServlet("/finalDeleteKeeperCheck")
public class FinalDeleteKeeperCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FinalDeleteKeeperCheckServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		EmployeeBean deleteEmployee = (EmployeeBean) session.getAttribute("deleteEmployee");

		String postID =(String) session.getAttribute("postID");

		//DAOの生成
		EmployeeDAO employeeDao = new EmployeeDAO(postID);

		//DAOの利用
		try {
			int x = employeeDao.deleteEmp(deleteEmployee);
			System.out.println(x);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		//ログインしてるか
		String url;
		if (session.getAttribute("LoginID")!=null) {
			url = "doneCheckDeleteKeeper.jsp";

		}else {
			url = "login.jsp";
		}


		RequestDispatcher rd = request.getRequestDispatcher(url);

		rd.forward(request, response);
	}

}
