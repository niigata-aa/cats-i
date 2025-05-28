package servlet;

import java.io.IOException;
import java.sql.SQLException;
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

/**
 * Servlet implementation class SearchAllKeeperServlet
 */
@WebServlet("/searchAllKeeper")
public class SearchAllKeeperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<EmployeeBean> employeeList;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAllKeeperServlet() {
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

		HttpSession session = request.getSession();

		if (session.getAttribute("LoginID")!=null) {
			url = "menu.jsp";
		}else {
			url ="login.jsp";
		}
		
		//DAOの生成
		EmployeeDAO dao = new EmployeeDAO();
		try {
		//DAOの利用
			employeeList = dao.selectAllEmp();
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		//レクエストスコープへの属性の設定
		request.setAttribute("employeeList", employeeList);
		//リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher("resultSearchKeeper.jsp");
		rd.forward(request, response);
		
		}
	}


