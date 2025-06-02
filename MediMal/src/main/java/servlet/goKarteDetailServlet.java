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

import model.dao.KarteDAO;
import model.entity.AnimalBean;
import model.entity.KarteBean;

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
		}
		
		if (session.getAttribute("LoginID")!=null) {
			url = "karteDetail.jsp";
		}else {
			url ="login.jsp";
		}
		String postID = (String) session.getAttribute("postID");
		//KarteDAO dao = new KarteDAO(postID);
		
		KarteDAO dao = new KarteDAO(postID);
		
		
		KarteBean Karte = new KarteBean();
		
		try {
			
			
			Karte.setWeightLog(dao.selectAllWeight(animalID));
			Karte.setCommentLog(dao.selectAllComment(animalID));
			Karte.setBirthLog(dao.selectAllBirth(animalID));
			Karte.setDrugLog(dao.selectAllDrug(animalID));
			
			System.out.println(dao.selectAllBirth(animalID).size());
			Karte.setFeedLog(dao.selectAllFeed(animalID));
			Karte.setMedicaltimes(dao.selectallMedicalExam(animalID));
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		
		for (AnimalBean TmpAnimal :(List<AnimalBean>) session.getAttribute("animalList")) {
			if(TmpAnimal.getAnimalID().equals(animalID)){
				Karte.setAnimal(TmpAnimal);
				session.setAttribute("animalrecode", TmpAnimal);
				break;
			}
		}
		
		session.setAttribute("animalID",animalID);
		session.setAttribute("KarteInfo",Karte);
		
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher(url);

		rd.forward(request, response);
	}

}
