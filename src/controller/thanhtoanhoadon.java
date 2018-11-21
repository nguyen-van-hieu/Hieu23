package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.hoadonbo;

/**
 * Servlet implementation class thanhtoanhoadon
 */
@WebServlet("/thanhtoanhoadon")
public class thanhtoanhoadon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public thanhtoanhoadon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			hoadonbo hdbo = new hoadonbo();
			if(request.getParameter("mahoadon")!=null) {
				long mahd = Long.parseLong(request.getParameter("mahoadon"));
				hdbo.ThanhToanHoaDon(mahd);
			}
			response.sendRedirect("thanhtoanthanhcong");
		}catch (Exception e) {
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
