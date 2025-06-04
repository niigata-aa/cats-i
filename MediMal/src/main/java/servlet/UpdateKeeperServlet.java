package servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.entity.EmployeeBean;

/**
 * Servlet implementation class UpdateKeeperServlet
 */
@WebServlet("/updateKeeper")
@MultipartConfig(
		maxFileSize=10000000,
		maxRequestSize=10000000,
		fileSizeThreshold=10000000
		)
public class UpdateKeeperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateKeeperServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストの転送
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		
		
		
		
		EmployeeBean updateEmp = new EmployeeBean();
		
		updateEmp.setEmpID(request.getParameter("empID"));
		
		System.out.println(request.getParameter("lastName"));
		updateEmp.setLastName(request.getParameter("lastName"));
		updateEmp.setFirstName(request.getParameter("firstName"));
		
		updateEmp.setGender(request.getParameter("gender"));
	
		
		updateEmp.setAreaID(Integer.parseInt(request.getParameter("area")));
		
		System.out.println(request.getPart("photo"));
		
		if(request.getPart("photo")!=null) {
		Part part = request.getPart("photo");
		String logo = Paths.get(part.getSubmittedFileName()).getFileName().toString();
		String logo_name = logo.isEmpty() ? "" : logo;

		// 画像アップロード
		String path = getServletContext().getRealPath("/image");
		part.write(path + File.separator + logo_name);
		
		updateEmp.setPhotoURL(logo_name);
		}
		
		updateEmp.setWorkingNow(Integer.parseInt(request.getParameter("workingNow")));
		
		session.setAttribute("workingNow", request.getParameter("workingNow"));
		
		session.setAttribute("updateEmployee", updateEmp);
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("checkUpdateKeeper.jsp");
		rd.forward(request, response);
	}

}