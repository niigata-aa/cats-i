package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.entity.Feed;

/**
 * Servlet implementation class InputFeedServlet
 */
@WebServlet("/inputFeed")
public class InputFeedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InputFeedServlet() {
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
		request.setCharacterEncoding("utf-8"); 
		String postID = (String) session.getAttribute("postID");

		//ログインしてるか
		String url;

		if (session.getAttribute("LoginID")!=null) {
			url = "checkInputFeed.jsp";
		}else {
			url ="login.jsp";
		}
		
		Feed feed = new Feed();
		
		feed.setAnimalID(request.getParameter("animalID"));
		feed.setFeedTime(request.getParameter("feedTime"));
		feed.setEmpID(request.getParameter("empID"));
		feed.setFeedContent(request.getParameter("feedContent"));
		feed.setFeedAmount(Integer.parseInt(request.getParameter("feedAmount")));
		feed.setFeedUnit(request.getParameter("feedUnit"));
		
		
		
		//セッションへのデータの登録
		session.setAttribute("inputFeed", feed);
		
		
		//食事記録画面（確認画面）に行く
		//このサーブレットでは通過するだけ
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		
		
		
		
	}

}
