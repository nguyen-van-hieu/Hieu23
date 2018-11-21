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
import bean.giohangbean;
import bo.giohangbo;
import bo.loaibo;

/**
 * Servlet implementation class cart
 */
@WebServlet("/cart")
public class cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			giohangbo gh = new giohangbo();
			loaibo lsach = new loaibo();
			ArrayList<giohangbean> lstgh = null;
			request.setAttribute("lstloai",lsach.getloai());
			if(session.getAttribute("account")!=null) {
				accoutbean acbean = (accoutbean)session.getAttribute("account");
				request.setAttribute("tk",acbean);
			}
			if(session.getAttribute("gh")!=null) {
				gh = (giohangbo)session.getAttribute("gh");
				lstgh = gh.getgh();
				Long thanhtien = gh.thanhtien();
				request.setAttribute("lsthangtronggio",lstgh);
				request.setAttribute("thanhtien",thanhtien);
				request.setAttribute("sl",gh.tongSLhang());
			}
			else {
				session.setAttribute("gh", gh);
				request.setAttribute("lsthangtronggio",lstgh);
				Long thanhtien = gh.thanhtien();
				request.setAttribute("thanhtien",thanhtien);
				request.setAttribute("sl",gh.tongSLhang());
			}
			RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
			rd.forward(request, response);
		}catch (Exception e) {
			response.getWriter().println(e.getMessage());;
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
