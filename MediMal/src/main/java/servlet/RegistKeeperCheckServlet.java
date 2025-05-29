package sevlet;

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

		
		String empID = request.getParameter("EmpID");
		String  empPass = request.getParameter("EmpPass");
		String lastName = request.getParameter("LastName");
		String firstName = request.getParameter("FirstName");
		String gender = request.getParameter("Gender");
		int postID = Integer.parseInt(request.getParameter("Post"));
		int areaID = Integer.parseInt(request.getParameter("Area"));
		String startWork = request.getParameter("StartWork");
		int livingNow = Integer.parseInt(request.getParameter("LivingNow"));
		String photoURL = request.getParameter("Photo");
		
		

		
		EmployeeBean employee = new EmployeeBean();
		employee.setEmpID(empID);
		employee.setEmpPass(empPass);
		employee.setLastName(lastName);
		employee.setFirstName(firstName);
		employee.setGender(gender);
		employee.setPost(postID);
		employee.setArea(areaID);
		employee.setStartWork(startWork);
		employee.setLivingNow(livingNow);
		employee.setPhoto(photoURL);
		
		
		
	



		//DAOの生成
		EmployeeDAO employeeDao = new EmployeeDAO();
		int count = 0; //処理件数

		try {
			//DAOの利用
			employeeDao.insertEmp(employee);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute(empID, "empID");
		request.setAttribute(empPass, "empPass");
		request.setAttribute(lastName, "lastName");
		request.setAttribute(firstName, "firstName");
		request.setAttribute(gender, "gender");
		request.setAttribute(postID, "postID");
		request.setAttribute(areaID, "areaID");
		request.setAttribute(startWork, "startWork");
		request.setAttribute(livingNow, "livingNow");
		request.setAttribute(photoURL, "photoURL");



		//ログインしてるか
		String url;

		if (session.getAttribute("LoginID")!=null) {
			url = "menu.jsp";
		}else {
			url ="login.jsp";
		}


		//リクエストの転送　体重記録の完了画面へ
		RequestDispatcher rd = request.getRequestDispatcher("doneRegistKeeper.jsp");
		rd.forward(request, response);
	}

}
