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
 * Servlet implementation class RegistAnimalSevlet
 */
@WebServlet("/RegistAnimalSevlet")
public class RegistAnimalSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistAnimalSevlet() {
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
		
		
		String animalID = request.getParameter("animalID");
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String area = request.getParameter("area");
		String birthDay = request.getParameter("birthDay");
		String countryOfBirth = request.getParameter("countryOfBirth");
		String sex = request.getParameter("sex");
		//List<String> keepers = request.getParameter("keepers");
		String photo = request.getParameter("photo");
		
//		EmployeeBean employee = new EmployeeBean();
		
		//セッションへのデータの登録
		session.setAttribute("animalID", animalID);
		session.setAttribute("name",name );
		session.setAttribute("type",type );
		session.setAttribute("area",area );
		session.setAttribute("birthDay",birthDay );
		session.setAttribute("countryOfBirth", countryOfBirth);
		session.setAttribute("sex",sex );
		session.setAttribute("keepers",keepers);
		session.setAttribute("photo",photo );
		
		
		RequestDispatcher rd = request.getRequestDispatcher("checkRegistKeeper.jsp");
		rd.forward(request, response);
	}

}
