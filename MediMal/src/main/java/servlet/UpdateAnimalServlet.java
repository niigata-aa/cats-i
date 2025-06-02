package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.entity.AnimalBean;

/**
 * Servlet implementation class UpdateAnimalServlet
 */
@WebServlet("/updateAnimal")
public class UpdateAnimalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAnimalServlet() {
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
		// リクエストの転送
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		AnimalBean updateAnimal = new AnimalBean();
		
		updateAnimal.setAnimalID(request.getParameter("animalID"));
		
		updateAnimal.setBirthDay(request.getParameter("birthDay"));
		
		updateAnimal.setName(request.getParameter("name"));
		
		updateAnimal.setCountry(request.getParameter("country"));
		
		updateAnimal.setAnimalKind(request.getParameter("animalKind"));
		
		updateAnimal.setSex(request.getParameter("sex"));
		
		updateAnimal.setArea(request.getParameter("area"));
		
		updateAnimal.setPhoto(request.getParameter("photo"));
		
		System.out.println(request.getParameter("livingNow"));
		updateAnimal.setLivingNow(Integer.parseInt(request.getParameter("livingNow")));
		
		session.setAttribute("livingNow", request.getParameter("livingNow"));
		
		session.setAttribute("updateAnimal", updateAnimal);
		
		RequestDispatcher rd = request.getRequestDispatcher("checkUpdateAnimal.jsp");
		rd.forward(request, response);
	}

}
