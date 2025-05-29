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
 * Servlet implementation class RegistKeeperCheckServlet
 */
@WebServlet("/registKeeperCheck")
public class RegistKeeperCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistKeeperCheckServlet() {
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
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		 
		EmployeeBean inputEmployee = (EmployeeBean) session.getAttribute("inputEmployee");
		
		String postID = (String) session.getAttribute("postID");
		
		System.out.println(postID);
		//DAOの生成
		EmployeeDAO employeeDao = new EmployeeDAO(postID);
		

		try {
			//DAOの利用
			employeeDao.insertEmp(inputEmployee);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		

		//ログインしてるか
		String url;

		if (session.getAttribute("LoginID")!=null) {
			url = "menu.jsp";
		}else {
			url ="login.jsp";
		}


		//リクエストの転送　従業員登録画面の完了画面へ
		RequestDispatcher rd = request.getRequestDispatcher("doneRegistKeeper.jsp");
		rd.forward(request, response);
	}

}
