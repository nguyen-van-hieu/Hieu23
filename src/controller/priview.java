package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.accoutbean;
import bean.loaibean;
import bo.giohangbo;
import bo.loaibo;
import bo.sachbo;

/**
 * Servlet implementation class priview
 */
@WebServlet("/priview")
public class priview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public priview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		loaibo lbo = new loaibo();
		sachbo sbo = new sachbo();
		giohangbo g = new giohangbo();
		if(session.getAttribute("account")!=null) {
			accoutbean acbean = (accoutbean)session.getAttribute("account");
			request.setAttribute("tk",acbean);
		}
		if(session.getAttribute("gh")!=null) {
			g = (giohangbo)session.getAttribute("gh");
			request.setAttribute("sl", g.tongSLhang());
		}
		else {
			request.setAttribute("sl",g.tongSLhang());
		}
		try {
			if(request.getParameter("masach")!=null) {
				String masach = request.getParameter("masach");
				request.setAttribute("sach", sbo.getsachtheomasach(masach));
			}
			ArrayList<loaibean> lstloai = lbo.getloai();
			request.setAttribute("lstloai", lstloai);
			RequestDispatcher rd = request.getRequestDispatcher("priview.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
