package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.giohangbo;

/**
 * Servlet implementation class xulygiohang
 */
@WebServlet("/xulygiohang")
public class xulygiohang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xulygiohang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(request.getParameter("ma")!=null) {
			giohangbo gh = new giohangbo();
			String ma = request.getParameter("ma");
			DecimalFormat formatter = new DecimalFormat("###,###,###");
			PrintWriter out = response.getWriter();
			if(session.getAttribute("gh") != null){
				gh = (giohangbo)session.getAttribute("gh");
			}
			
			if(ma.equals("xoahet")) {
				gh.xoahet();
				session.setAttribute("giohang", gh);
				out.print(formatter.format(gh.thanhtien()));
			}
			if(ma.equals("giam")) {
				String masach = request.getParameter("masach");
				gh.giam(masach);
				session.setAttribute("gh", gh);
				out.print(formatter.format(gh.thanhtien()));
			}
			if(ma.equals("tang")) {
				String masach = request.getParameter("masach");
				gh.tang(masach);
				session.setAttribute("gh", gh);
				out.print(formatter.format(gh.thanhtien()));
			}
			if(ma.equals("xoa")) {
				String masach = request.getParameter("masach");
				gh.xoa(masach);
				session.setAttribute("gh", gh);
				out.print(formatter.format(gh.thanhtien()));
			}
			if(ma.equals("soluong")) {
				out.print(gh.tongSLhang());
			}
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
