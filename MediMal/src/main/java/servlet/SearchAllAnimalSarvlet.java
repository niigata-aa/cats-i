package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
 * Servlet implementation class SearchAllAnimalSarvlet
 */
@WebServlet("/searchAllAnimal")
public class SearchAllAnimalSarvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<AnimalBean> animalList;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchAllAnimalSarvlet() {
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
		String url ;

		HttpSession session = request.getSession();

		String postID = (String) session.getAttribute("postID");


		if (session.getAttribute("LoginID")!=null) {
			url = "resultSearchKeeper.jsp";
		}else {
			url ="login.jsp";
		}

		//DAOの生成
		AnimalDAO dao = new AnimalDAO(postID);
		try {
			//DAOの利用
			animalList = dao.selectAllAnimal();
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		//レクエストスコープへの属性の設定
		request.setAttribute("employeeList", animalList);
		//リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
