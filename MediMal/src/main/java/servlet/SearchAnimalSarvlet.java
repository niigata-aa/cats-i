package servlet;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class SearchAnimalSarvlet
 */
@WebServlet("/searchAnimal")
public class SearchAnimalSarvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAnimalSarvlet() {
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
			url = "resultSearchAnimal.jsp";
		}else {
			url ="login.jsp";
		}
		
		request.setCharacterEncoding("UTF-8");
		AnimalBean searchAnimal = new AnimalBean();
		
		searchAnimal.setAnimalID(request.getParameter("animalID"));
		searchAnimal.setName(request.getParameter("animalName"));
		searchAnimal.setAnimalType(request.getParameter("typeName"));
		searchAnimal.setArea(request.getParameter("areaName"));
//		searchAnimal.setKeepers(request.getParameter("keeperName"));
		
		List<AnimalBean> animalList = new ArrayList<AnimalBean>();
		
		//DAOの生成
		AnimalDAO dao = new AnimalDAO(postID);
//		try {
//			//DAOの利用
			animalList = dao.selectAnimalByfield(searchAnimal);
//		}catch(SQLException | ClassNotFoundException e) {
//			e.printStackTrace();
//		}
		
		
		//レクエストスコープへの属性の設定
		session.setAttribute("animalList", animalList);
		//リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
