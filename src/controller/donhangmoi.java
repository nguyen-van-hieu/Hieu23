package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.accoutbean;
import bean.giohangbean;
import bo.giohangbo;
import bo.hoadonbo;
/**
 * Servlet implementation class donhangmoi
 */
@WebServlet("/donhangmoi")
public class donhangmoi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public donhangmoi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			hoadonbo hdbo = new hoadonbo();
			long makh = 0;
			long mahd = 0;
			if(session.getAttribute("account")!=null) {
				accoutbean ac = (accoutbean)session.getAttribute("account");
				makh = ac.getMakh();
			}
			if(session.getAttribute("gh")!=null) {
				giohangbo ghbo = (giohangbo)session.getAttribute("gh");
				if(ghbo.dshang.size()>0) {
					mahd = hdbo.InsertHD(makh);
					for(giohangbean g : ghbo.dshang) {
						hdbo.InsertChitietHD(g.getMasach(),g.getSoluongmua(),mahd);
					}
					session.removeAttribute("gh");
				}else {
					response.sendRedirect("cart");
				}
			}
			response.sendRedirect("chitiethoadon?mahoadon="+mahd);
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
