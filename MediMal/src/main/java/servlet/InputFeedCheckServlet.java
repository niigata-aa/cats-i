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

		String animalID = request.getParameter("animalID");
		//SimpleDateFormatを型変換？
		//		SimpleDateFormat Date = SimpleDateFormat.request.getParameter("Date");
		String date = request.getParameter("date");
		String content = request.getParameter("content");
		int amount = Integer.parseInt(request.getParameter("amount"));
		String unit = request.getParameter("unit");


		Feed inputFeed = new Feed();
		inputFeed.setAnimalID(animalID);
		//		inputWeight.setInputDate(inputDate);
		inputFeed.setContent(content);
		inputFeed.setAmount(amount);
		inputFeed.setUnit(unit);


		//DAOの生成
		KarteDAO karteDao = new KarteDAO();
		int count = 0; //処理件数

		try {
			HttpSession session = request.getSession();
			//DAOの利用
			count = karteDao.insertFeed(inputFeed);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute(animalID, "animalID");
		request.setAttribute(date, "date");
		request.setAttribute(content, content);
		request.setAttribute(amount,"amount");
		request.setAttribute(unit, "unit");
		
		
		
		//ログインしてるか
		String url;

		HttpSession session = request.getSession();

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
