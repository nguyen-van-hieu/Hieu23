package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.accoutbean;
import bo.giohangbo;
import bo.hoadonbo;

@WebServlet("/donhang")
public class donhang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public donhang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			if(session.getAttribute("gh")!=null) {
				giohangbo ghbo = (giohangbo)session.getAttribute("gh");
				request.setAttribute("sl",ghbo.tongSLhang());
			}
			else
				request.setAttribute("sl",(long)0);
			if(session.getAttribute("account")!=null) {
				accoutbean acbean = (accoutbean)session.getAttribute("account");
				request.setAttribute("tk",acbean);
				long makh = acbean.getMakh();
				hoadonbo cbo = new hoadonbo();
				request.setAttribute("ds", cbo.get_hoadon(makh));
			}
			RequestDispatcher rd = request.getRequestDispatcher("donhang.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			response.getWriter().println(e.getMessage());
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
