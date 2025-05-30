package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.entity.EmployeeBean;

/**
 * Servlet implementation class DeleteKeeperServlet
 */
@WebServlet("/deleteKeeper")
public class DeleteKeeperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteKeeperServlet() {
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
		// リクエストの転送
		String url = null;
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		
		
		
		EmployeeBean deleteEmp = new EmployeeBean();
		
		deleteEmp.setEmpID(request.getParameter("empID"));
		
//		deleteEmp.setLastName(request.getParameter("lastName"));
//		
//		deleteEmp.setFirstName(request.getParameter("firstName"));
//		
//		deleteEmp.setAreaID(Integer.parseInt(request.getParameter("areaID")));
//		
//		deleteEmp.setGender(request.getParameter("gender"));
		
		
		session.setAttribute("deleteEmployee", deleteEmp);
		
		
	

		if (session.getAttribute("LoginID")!=null) {
			url = "checkDeleteKeeper.jsp";
			
		}else {
			url = "login.jsp";
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
