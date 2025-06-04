package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.AnimalDAO;
import model.entity.AnimalBean;

/**
 * Servlet implementation class FinalUpdateAnimalCheckServlet
 */
@WebServlet("/finalUpdateAnimalCheck")
public class FinalUpdateAnimalCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalUpdateAnimalCheckServlet() {
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
		 
		AnimalBean updateAnimal = (AnimalBean) session.getAttribute("updateAnimal");
		
		String postID =(String) session.getAttribute("postID");

		//DAOの生成
		AnimalDAO animalDao = new AnimalDAO(postID);
		
		//DAOの利用
		animalDao.updateAnimal(updateAnimal);
		
		session.setAttribute("animalrecode", updateAnimal);
		
		//a

		//ログインしてるか
		String url;

		if (session.getAttribute("LoginID")!=null) {
			url = "menu.jsp";
		}else {
			url ="login.jsp";
		}
		
		session.removeAttribute("livingNow");

		//リクエストの転送　従業員登録画面の完了画面へ
		RequestDispatcher rd = request.getRequestDispatcher("doneUpdateAnimal.jsp");
		rd.forward(request, response);
	}

}
