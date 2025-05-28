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
		
		String animalID = session.getAttribute("animalID");
		//SimpleDateFormatを型変換？
//		SimpleDateFormat inputDate = SimpleDateFormat.request.getParameter("inputDate");
		String inputDate = request.getParameter("inputDate");
		int measureWeight = Integer.parseInt(request.getParameter("measureWeight"));
		String unit = request.getParameter("unit");
		
		
		Weight inputWeight = new Weight();
		inputWeight.setAnimalID(animalID);
//		inputWeight.setInputDate(inputDate);
		inputWeight.setMeasureWeight(measureWeight);
		inputWeight.setUnit(unit);
		
		
		//DAOの生成
		KarteDAO karteDao = new KarteDAO();
		int count = 0; //処理件数
		
		try {
			HttpSession session = request.getSession();
			//DAOの利用
			count = karteDao.insertWeight(inputWeight);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute(animalID, "animalID");
		request.setAttribute(inputDate, "inputDate");
		request.setAttribute(measureWeight,"measureWeight");
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
		RequestDispatcher rd = request.getRequestDispatcher("doneInputWeight.jsp");
		rd.forward(request, response);
	}

}
