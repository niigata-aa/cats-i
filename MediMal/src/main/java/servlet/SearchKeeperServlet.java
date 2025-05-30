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

import model.dao.EmployeeDAO;
import model.entity.EmployeeBean;
	//拒否られて

/**
 * Servlet implementation class SearchKeeperServlet
 */
@WebServlet("/SearchKeeper")
public class SearchKeeperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<EmployeeBean> employeeList;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchKeeperServlet() {
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
		String url ;
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		
		String postID = (String) session.getAttribute("postID");
		

		if (session.getAttribute("LoginID")!=null) {
			url = "resultSearchKeeper.jsp";
		}else {
			url ="login.jsp";
		}
		
		//DAOの生成
		EmployeeDAO dao = new EmployeeDAO(postID);
		EmployeeBean searchEmpData = new EmployeeBean();
		searchEmpData.setEmpID(request.getParameter("EmpID"));
		searchEmpData.setLastName(request.getParameter("keeperLastName"));
		searchEmpData.setFirstName(request.getParameter("keeperFirstName"));
		searchEmpData.setAreaName(request.getParameter("areaName"));
//DAOの利用
		employeeList = dao.selectEmpByField(searchEmpData);
		//レクエストスコープへの属性の設定
		request.setAttribute("employeeList", employeeList);
		//リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		
	}

}
