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
import model.entity.Feed;

/**
 * Servlet implementation class InputFeedCheckServlet
 */
@WebServlet("/inputFeedCheck")
public class InputFeedCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InputFeedCheckServlet() {
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
		
		String IDhead = (String)session.getAttribute("LoginID");
		
		
		
		Feed inputFeed = (Feed) session.getAttribute("inputFeed");
		
		String postID = IDhead.substring(0, 2);
		
		System.out.println(postID);
		//DAOの生成
		KarteDAO karteDao = new KarteDAO(postID);
		

		try {
			//DAOの利用
			System.out.println("件数:"+karteDao.insertFeed(inputFeed));
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
		RequestDispatcher rd = request.getRequestDispatcher("doneInputFeed.jsp");
		rd.forward(request, response);
		
	}

}
