package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.entity.EmployeeBean;

/**
 * Servlet implementation class GoUpdateKeeperServlet
 */
@WebServlet("/goUpdateKeeper")
public class GoUpdateKeeperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GoUpdateKeeperServlet() {
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
		request.setCharacterEncoding("UTF-8");

		//ログインしてるか
		String url;

		if (session.getAttribute("LoginID")!=null) {
			url = "updateKeeper.jsp";
		}else {
			url ="login.jsp";
		}

		List<EmployeeBean> allEmp = (List<EmployeeBean>) session.getAttribute("employeeList");

		String 	empID 		= request.getParameter("empID");
		System.out.println(empID);
		

		for(EmployeeBean TmpEmployee : allEmp){
			if(TmpEmployee.getEmpID().equals(empID)) {

				
//				
				System.out.println(TmpEmployee.getEmpID());
				
				session.setAttribute("updateEmployee", TmpEmployee);
				
			}
			// リクエストの転送a
			RequestDispatcher rd = request.getRequestDispatcher("updateKeeper.jsp");
			rd.forward(request, response);
		}
	}
}
