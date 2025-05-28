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

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		request.setCharacterEncoding("UTF-8");
		
		String LoginID	=request.getParameter("LoginID");
		String Password	=request.getParameter("Password");
		String url;
		
		HttpSession session = request.getSession();
		
		try {
			EmployeeDAO empDAO = new EmployeeDAO(LoginID);
			if(empDAO.loginCheck(LoginID, Password)) {
				url = "goMenu";
				System.out.println("ログインには成功してます。");
				session.setAttribute("LoginID", LoginID);
				session.setAttribute("Login", true);
				
				String IDhead = LoginID.substring(0, 2);
				
				session.setAttribute("postID", IDhead);
			}else {
				url ="login.jsp";
				session.setAttribute("Login", false);
				System.out.println("ログインに失敗しています");
			}
		}catch(Exception e) {
			url ="login.jsp";
			session.setAttribute("Login", false);
			System.out.println("接続に失敗しています。");
			
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		
		rd.forward(request, response);
		
	}

}
