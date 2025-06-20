package servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.entity.AnimalBean;

/**
 * Servlet implementation class RegistAnimalSevlet
 */
@WebServlet("/registAnimal")
@MultipartConfig(
		maxFileSize=10000000,
		maxRequestSize=10000000,
		fileSizeThreshold=10000000
		)
public class RegistAnimalSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistAnimalSevlet() {
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
		
		Map<String, String> allTypes = (Map<String, String>) session.getAttribute("Alltype");
		
		Part part = request.getPart("photo");
		String logo = Paths.get(part.getSubmittedFileName()).getFileName().toString();
		String logo_name = logo.isEmpty() ? "" : logo;
		
		// 画像アップロード
		String path = getServletContext().getRealPath("/image");
		part.write(path + File.separator + logo_name);

		//ログインしてるか
		String url;

		if (session.getAttribute("LoginID")!=null) {
			url = "checkRegistAnimal.jsp";
		}else {
			url ="login.jsp";
		}


		AnimalBean animal = new AnimalBean();

		animal.setAnimalID(request.getParameter("animalID"));
		animal.setName(request.getParameter("name"));
		
		System.out.println(request.getParameter("TypeID"));
		animal.setAnimalType(request.getParameter("TypeID"));
		animal.setType(allTypes.get(request.getParameter("TypeID")));
		animal.setKindID(1);
		animal.setAreaID(Integer.parseInt(request.getParameter("areaID")));
		animal.setBirthDay(request.getParameter("birthDay"));
		animal.setCountry(request.getParameter("country"));
		animal.setSex(request.getParameter("sex"));
		//List
//		animal.setKeepers(request.getParameter("keepers"));
		animal.setPhoto(logo_name);

		//セッションへのデータの登録
		session.setAttribute("inputAnimal", animal);


		//		
		//		String animalID = request.getParameter("animalID");
		//		String name = request.getParameter("name");
		//		String type = request.getParameter("type");
		//		String area = request.getParameter("area");
		//		String birthDay = request.getParameter("birthDay");
		//		String countryOfBirth = request.getParameter("countryOfBirth");
		//		String sex = request.getParameter("sex");
		//		//List<String> keepers = request.getParameter("keepers");
		//		String photo = request.getParameter("photo");
		//	

		//		//セッションへのデータの登録
		//		session.setAttribute("animalID", animalID);
		//		session.setAttribute("name",name );
		//		session.setAttribute("type",type );
		//		session.setAttribute("area",area );
		//		session.setAttribute("birthDay",birthDay );
		//		session.setAttribute("countryOfBirth", countryOfBirth);
		//		session.setAttribute("sex",sex );
		//		session.setAttribute("keepers",keepers);
		//		session.setAttribute("photo",photo );
		
		//登録からカルテ詳細画面への動物IDの取得
				String animalID = request.getParameter("animalID");
				session.setAttribute("animalID", animalID);


		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
