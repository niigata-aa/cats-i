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

import model.dao.KarteDAO;
import model.entity.Weight;

/**
 * Servlet implementation class InputWeightCheckServlet
 */
@WebServlet("/inputWeightCheck")
public class InputWeightCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InputWeightCheckServlet() {
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
		
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		Weight inputWeight = (Weight) session.getAttribute("inputWeight");
		
		String postID = (String) session.getAttribute("postID");
		
		System.out.println(postID);
		//DAOの生成
		KarteDAO karteDao = new KarteDAO(postID);
		

		try {
			//DAOの利用
			karteDao.insertWeight(inputWeight);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		

		//ログインしてるか
		String url;

		if (session.getAttribute("LoginID")!=null) {
			url = "menu.jsp";
		}else {
			url ="login.jsp";
		}
		
		
		//リクエストの転送　体重記録の完了画面へ
		RequestDispatcher rd = request.getRequestDispatcher("doneInputWeight.jsp");
		rd.forward(request, response);
	}

}
