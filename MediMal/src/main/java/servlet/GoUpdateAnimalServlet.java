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

import model.entity.AnimalBean;

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
		
		List<AnimalBean> animalList = (List<AnimalBean>) session.getAttribute("animalList");
		
		String animalID = (String) request.getAttribute("AnimalID");
		
		for(AnimalBean animal : animalList) {
			if (animal.getAnimalID().equals(animalID)) {
				session.setAttribute("animalrecode", animal);
			}
		}

		if (session.getAttribute("LoginID")!=null) {
			url = "updateAnimal.jsp";
		}else {
			url ="login.jsp";
		}
		// リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher("updateAnimal.jsp");
		rd.forward(request, response);
	}
}