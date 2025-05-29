package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		//ログインしてるか
		String url;

		if (session.getAttribute("LoginID")!=null) {
			url = "menu.jsp";
		}else {
			url ="login.jsp";
		}
		
		
		String empID = request.getParameter("empID");
		String  empPass = request.getParameter("empPass");
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String gender = request.getParameter("gender");
		System.out.println(request.getParameter("postID"));
		int postID = Integer.parseInt(request.getParameter("postID"));
		int areaID = Integer.parseInt(request.getParameter("areaID"));
		String startWork = request.getParameter("startWork");
		String photo = request.getParameter("photo");
		
//		EmployeeBean employee = new EmployeeBean();
		
		//セッションへのデータの登録
		session.setAttribute("empID", empID);
		session.setAttribute("empPass",empPass );
		session.setAttribute("lastName",lastName );
		session.setAttribute("firstName",firstName );
		session.setAttribute("gender",gender );
		session.setAttribute("postID", postID);
		session.setAttribute("areaID",areaID );
		session.setAttribute("startWork",startWork);
		session.setAttribute("photo",photo );
		
		
		
//		.setEmpID("empID");
//		employee.setEmpID("empPass");
//		employee.setEmpID("lastName");
//		employee.setEmpID("firstName");
//		employee.setEmpID("gender");
//		employee.setEmpID("postID");
//		employee.setEmpID("areaID");
//		employee.setEmpID("startWork");
//		employee.setEmpID("livingNow");
//		employee.setEmpID("photo");
//		employee.setEmpID("empID");	
//		
//		request.setAttribute("empID",empID );
//		request.setAttribute("empPass",empPass );
//		request.setAttribute("lastName",lastName );
//		request.setAttribute("firstName",firstName );
//		request.setAttribute("gender",gender );
//		request.setAttribute("postID",postID );
//		request.setAttribute("areaID",areaID );
//		request.setAttribute("startWork",startWork );
//		request.setAttribute("livingNow",livingNow );
//		request.setAttribute("photo",photo );
		
		

		//リクエストの転送　飼育員登録の完了画面へ
		RequestDispatcher rd = request.getRequestDispatcher("checkRegistKeeper.jsp");
		rd.forward(request, response);
	}

}
