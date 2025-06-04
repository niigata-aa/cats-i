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

		

		String 	empID 		= request.getParameter("empID");
		System.out.println(empID);
		//		String 	lastName 	= request.getParameter("lastName");
		//		String 	firstName 	= request.getParameter("firstName");
		//		String 	getArea 	= request.getParameter("area");
		//		
		//		int 	workingNow	=Integer.parseInt(request.getParameter("workingNow"));
		//		
		//		request.setAttribute("empID",empID);
		//		request.setAttribute("lastName",lastName);
		//		request.setAttribute("firstName",firstName);
		//		request.setAttribute("getArea",getArea);
		//		request.setAttribute("workingNow", workingNow);

		for(EmployeeBean TmpEmployee : (List<EmployeeBean>) session.getAttribute("employeeList")){
			if(TmpEmployee.getEmpID().equals(empID)) {

				
//				empID= (String) session.getAttribute("empID");
//				String 	lastName 	= (String) session.getAttribute("lastName");
//				String 	firstName 	= (String) session.getAttribute("firstName");
////				int 	areaID 	= (int) session.getAttribute("areaID");
//				String  gender  = (String) session.getAttribute("gender");
////				int 	workingNow	=Integer.parseInt(request.getParameter("workingNow"));
//				int		workingNow	= (int) session.getAttribute("workingNow");
//				String  photoURL	= (String) session.getAttribute("photoURL");
//
//				updateEmp.setEmpID(empID);
//
//				updateEmp.setLastName(lastName);
//
//				updateEmp.setFirstName(firstName);
//
////				updateEmp.setAreaID(areaID);
//
//				updateEmp.setGender(gender);
//
//				System.out.println(workingNow);
//				updateEmp.setWorkingNow(workingNow);
//				
//				updateEmp.setPhotoURL(photoURL);
//
//				session.setAttribute("workingNow", workingNow);

				
				session.setAttribute("updateEmployee", TmpEmployee);
				
			}
			// リクエストの転送a
			RequestDispatcher rd = request.getRequestDispatcher("updateKeeper.jsp");
			rd.forward(request, response);
		}
	}
}
