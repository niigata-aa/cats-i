package servlet;

import java.io.IOException;
import java.sql.SQLException;

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
 * Servlet implementation class FinalDeleteAnimalCheckServlet
 */
@WebServlet("/finalDeleteAnimalCheck")
public class FinalDeleteAnimalCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalDeleteAnimalCheckServlet() {
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

		AnimalBean deleteAnimal = (AnimalBean) session.getAttribute("deleteAnimal");

		String postID =(String) session.getAttribute("postID");

		//DAOの生成
		AnimalDAO animalDao = new AnimalDAO(postID);

		//DAOの利用
		try {
			animalDao.DeleteAnimal(deleteAnimal);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		//ログインしてるか
		String url;
		if (session.getAttribute("LoginID")!=null) {
			url = "doneCheckDeleteAnimals.jsp";

		}else {
			url = "login.jsp";
		}


		RequestDispatcher rd = request.getRequestDispatcher(url);

		rd.forward(request, response);
		
		
		
	}

}
