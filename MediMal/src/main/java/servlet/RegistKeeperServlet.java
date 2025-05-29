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
 * Servlet implementation class RegistKeeperServlet
 */
@WebServlet("/registKeeper")
public class RegistKeeperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistKeeperServlet() {
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
		request.setCharacterEncoding("utf-8"); 
		String postID = (String) session.getAttribute("postID");

		//ログインしてるか
		String url;

		if (session.getAttribute("LoginID")!=null) {
			url = "checkRegistKeeper.jsp";
		}else {
			url ="login.jsp";
		}
		
		EmployeeBean employee = new EmployeeBean();
		
		employee.setEmpID(request.getParameter("inputEmpID"));
		employee.setEmpPass(request.getParameter("inputEmpPass"));
		employee.setLastName(request.getParameter("inputLastName"));
		employee.setFirstName(request.getParameter("inputFirstName"));
		employee.setGender(request.getParameter("inputGender"));
		employee.setPostID(Integer.parseInt(request.getParameter("inputPostID")));
		employee.setAreaID(Integer.parseInt(request.getParameter("inputAreaID")));
		employee.setStartWork(request.getParameter("inputStartWork"));
		employee.setPhotoURL(request.getParameter("inputPhoto"));
		
		
		//セッションへのデータの登録
		session.setAttribute("inputEmployee", employee);
		
		

		//リクエストの転送　飼育員登録の完了画面へ
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
