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
 * Servlet implementation class goKarteDetailServlet
 */
@WebServlet("/goKarteDetail")
public class goKarteDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public goKarteDetailServlet() {
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
		String animalID = null;
		
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("UTF-8");
		
		//動物登録完了画面から詳細カルテに行く場合の動物IDの引き渡し
		if(request.getParameter("animalID")==(null)) {
			request.setCharacterEncoding("UTF-8");
			animalID = (String) session.getAttribute("animalID");
			request.setAttribute("animalID", animalID);
			
		} else {
			 animalID = request.getParameter("animalID");
//			String animalName = request.getParameter("animalName");
//			String typeName = request.getParameter("typeName");
//			String areaName = request.getParameter("areaName");
//			String keeperName = request.getParameter("keeperName");
//			String animalBirth = request.getParameter("animalBirth");
	//		String photo = request.getParameter("photo");
			
//			request.setAttribute("animalID", animalID);
//			request.setAttribute("animalName", animalName);
//			request.setAttribute("typeName", typeName);
//			request.setAttribute("areaName", areaName);
//			request.setAttribute("keeperName", keeperName);
//			request.setAttribute("animalBirth", animalBirth);
	//		request.setAttribute("photo", photo);
		}
		
		if (session.getAttribute("LoginID")!=null) {
			url = "karteDetail.jsp";
		}else {
			url ="login.jsp";
		}
		String postID = (String) session.getAttribute("postID");
		AnimalDAO dao = new AnimalDAO(postID);
		
		try {
			AnimalBean animal = new AnimalBean();
			animal = dao.selectOneRecodeAllAnimal(animalID);
			session.setAttribute("animalrecode", animal);
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		//s
		
		
		RequestDispatcher rd = request.getRequestDispatcher(url);

		rd.forward(request, response);
	}

}
