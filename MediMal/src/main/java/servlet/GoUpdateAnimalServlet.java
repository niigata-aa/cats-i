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
 * Servlet implementation class GoUpdateAnimalServlet
 */
@WebServlet("/goUpdateAnimal")
public class GoUpdateAnimalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoUpdateAnimalServlet() {
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
			url = "updateAnimal.jsp";
		}else {
			url ="login.jsp";
		}
		
		String 	animalID 	= request.getParameter("animalID");
		String  birthday    = request.getParameter("birthday");
		String 	name 		= request.getParameter("name");
		String 	country 	= request.getParameter("country");
		String 	animalKind 	= request.getParameter("animalKind");
		String  area        = request.getParameter("area");
		String  sex         = request.getParameter("sex");
		int 	livingNow	=Integer.parseInt(request.getParameter("livingNow"));
		
		request.setAttribute("animalID",animalID);
		request.setAttribute("birthday",birthday);
		request.setAttribute("name",name);
		request.setAttribute("country",country);
		request.setAttribute("animalKind", animalKind);
		request.setAttribute("area", area);
		request.setAttribute("sex", sex);
		request.setAttribute("livingNow", livingNow);
		
		
		// リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher("updateAnimal.jsp");
		rd.forward(request, response);
	}
}