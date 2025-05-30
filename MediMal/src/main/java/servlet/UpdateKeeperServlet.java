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
 * Servlet implementation class UpdateKeeperServlet
 */
@WebServlet("/updateKeeper")
public class UpdateKeeperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateKeeperServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストの転送
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		EmployeeBean updateEmp = new EmployeeBean();
		
		updateEmp.setEmpID(request.getParameter("empID"));
		
		updateEmp.setLastName(request.getParameter("lastName"));
		
		updateEmp.setFirstName(request.getParameter("firstName"));
		
		updateEmp.setAreaID(Integer.parseInt(request.getParameter("areaID")));
		
		updateEmp.setGender(request.getParameter("gender"));
		
		System.out.println(request.getParameter("workingNow"));
		updateEmp.setWorkingNow(Integer.parseInt(request.getParameter("workingNow")));
		
		session.setAttribute("workingNow", request.getParameter("workingNow"));
		
		session.setAttribute("updateEmployee", updateEmp);
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("checkUpdateKeeper.jsp");
		rd.forward(request, response);
	}

}