package servlet;

import java.io.IOException;

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
 * Servlet implementation class FinalUpdateKeeperCheckServlet
 */
@WebServlet("/FinalUpdateKeeperCheck")
public class FinalUpdateKeeperCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalUpdateKeeperCheckServlet() {
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
		 
		EmployeeBean updateEmployee = (EmployeeBean) session.getAttribute("updateEmployee");
		
		String postID =(String) session.getAttribute("postID");

		//DAOの生成
		EmployeeDAO employeeDao = new EmployeeDAO(postID);
		
		//DAOの利用
		employeeDao.updateEmp(updateEmployee);

		

		//ログインしてるか
		String url;

		if (session.getAttribute("LoginID")!=null) {
			url = "menu.jsp";
		}else {
			url ="login.jsp";
		}


		//リクエストの転送　従業員登録画面の完了画面へ
		RequestDispatcher rd = request.getRequestDispatcher("doneUpdateKeeper.jsp");
		rd.forward(request, response);
	}
}
