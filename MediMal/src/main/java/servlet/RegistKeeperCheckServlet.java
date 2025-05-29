package servlet;

import java.io.IOException;
import java.sql.Date;
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


		String empID = (String) session.getAttribute("empID");
		String  empPass = (String)session.getAttribute("empPass");
		String lastName = (String)session.getAttribute("lastName");
		String firstName = (String)session.getAttribute("firstName");
		String gender = (String)session.getAttribute("gender");
		int postID = (int)session.getAttribute("postID");
		int areaID = (int)session.getAttribute("areaID");
		Date startWork = (Date)session.getAttribute("startWork");
		String photo = (String)session.getAttribute("photo");


		EmployeeBean employee = new EmployeeBean();
		employee.setEmpID(empID);
		employee.setEmpPass(empPass);
		employee.setLastName(lastName);
		employee.setFirstName(firstName);
		employee.setGender(gender);
		employee.setPost(postID);
		employee.setArea(areaID);
		employee.setStartWork(startWork);
		employee.setPhotoURL(photo);


		//DAOの生成
		EmployeeDAO employeeDao = new EmployeeDAO((String) session.getAttribute("postID"));
		int count = 0; //処理件数

		try {
			//DAOの利用
			employeeDao.insertEmp(employee);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		
		
		request.setAttribute("employee", employee);



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
