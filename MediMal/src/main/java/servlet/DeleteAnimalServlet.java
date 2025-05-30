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
 * Servlet implementation class DeleteAnimalServlet
 */
@WebServlet("/deleteAnimal")
public class DeleteAnimalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAnimalServlet() {
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
				String url = null;
				HttpSession session = request.getSession();
				request.setCharacterEncoding("UTF-8");
				
				
				
				AnimalBean deleteAnimal = new AnimalBean();
				
				deleteAnimal.setAnimalID(request.getParameter("animalID"));
				

				
				
				session.setAttribute("deleteAnimal", deleteAnimal);
				

		if (session.getAttribute("LoginID")!=null) {
			url = "checkDeleteAnimal.jsp";
		}else {
			url ="login.jsp";
		}
		
		//動物情報変更・削除画面（確認画面）に行く
		//このサーブレットでは通過するだけ
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
