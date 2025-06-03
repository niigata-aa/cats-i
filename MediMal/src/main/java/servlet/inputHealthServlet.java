package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.entity.Birth;
import model.entity.Drug;

/**
 * Servlet implementation class inputHealthServlet
 */
@WebServlet("/inputHealth")
public class inputHealthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inputHealthServlet() {
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
			url = "inputKarteCheck.jsp";
		}else {
			url ="login.jsp";
		}
		
		Drug drug = new Drug();
		
		drug.setAnimalID((String) session.getAttribute("animalID"));
		drug.setDate(request.getParameter("date"));
		drug.setMedicineName(request.getParameter("medicineName"));
		drug.setMedicineAmount(Integer.parseInt(request.getParameter("medicineAmount")));
		session.setAttribute("inputDrug", drug);
		
		if(!request.getParameter("amount").equals("0")) {
		Birth birth = new Birth();
		
		birth.setAnimalID((String)session.getAttribute("animalID"));
        birth.setDate(request.getParameter("date"));
        birth.setAmount(Integer.parseInt(request.getParameter("amount")));
		
		
		
		//セッションへのデータの登録
		
		
		session.setAttribute("inputBirth",birth);
		
		}
		//カルテ記録画面（確認画面）に行く"inputKarteCheck.jsp"
		//このサーブレットでは通過するだけ
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		
	}

}
