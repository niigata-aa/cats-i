package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.AnimalDAO;

/**
 * Servlet implementation class goKarteHomeServlet
 */
@WebServlet("/goKarteHome")
public class goKarteHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public goKarteHomeServlet() {
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
		String url = null;

		HttpSession session = request.getSession();
		AnimalDAO dao = new AnimalDAO((String) session.getAttribute("postID"));
		
		try {
			Map<String,String> animalTypes = dao.getAllType();
			session.setAttribute("Alltype", animalTypes);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		if (session.getAttribute("LoginID")!=null) {
			url = "karteHome.jsp";
			
		}else {
			url = "login.jsp";
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher(url);

		rd.forward(request, response);

	}

}
