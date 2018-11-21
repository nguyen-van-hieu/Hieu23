package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.giohangbo;

/**
 * Servlet implementation class themmoi
 */
@WebServlet("/themmoi")
public class themmoi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public themmoi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(request.getParameter("masach") != null && request.getParameter("tensach") != null && request.getParameter("gia") != null && request.getParameter("slmua") != null && request.getParameter("img") != null){
			giohangbo gh = new giohangbo();
			String masach = request.getParameter("masach");
			String tensach = request.getParameter("tensach");
			String slmua = request.getParameter("slmua");
			String gia = request.getParameter("gia");
			String img = request.getParameter("img");
			if(session.getAttribute("gh") != null){
				gh = (giohangbo)session.getAttribute("gh");
				gh.them(masach, tensach, gia, slmua,img);
				session.setAttribute("gh", gh);
			}
			else {
				gh.them(masach, tensach, gia, slmua,img);
				session.setAttribute("gh", gh);
			}
		}
		response.sendRedirect("cart");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
