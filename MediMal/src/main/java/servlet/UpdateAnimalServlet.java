package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
@MultipartConfig(
		maxFileSize=10000000,
		maxRequestSize=10000000,
		fileSizeThreshold=10000000
		)
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

		AnimalBean updateAnimal = (AnimalBean) session.getAttribute("animalrecode");




		updateAnimal.setSex("おす");


		updateAnimal.setArea(request.getParameter("area"));

		updateAnimal.setPhoto(request.getParameter("photo"));


		updateAnimal.setLivingNow(Integer.parseInt(request.getParameter("livingNow")));

		session.setAttribute("livingNow", request.getParameter("livingNow"));
//
		session.setAttribute("updateAnimal", updateAnimal);

		RequestDispatcher rd = request.getRequestDispatcher("checkUpdateAnimal.jsp");
		rd.forward(request, response);
	}

}
