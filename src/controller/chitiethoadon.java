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
import bo.chitiethoadonbo;
import bo.giohangbo;
import bo.hoadonbo;

/**
 * Servlet implementation class chitiethoadon
 */
@WebServlet("/chitiethoadon")
public class chitiethoadon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public chitiethoadon() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			if(session.getAttribute("account")!=null) {
				accoutbean acbean = (accoutbean)session.getAttribute("account");
				request.setAttribute("tk",acbean);
				String MaHoaDon = request.getParameter("mahoadon");
				request.setAttribute("MaHD",MaHoaDon);
				hoadonbo hdbo = new hoadonbo();
				boolean ttdh = hdbo.KTDaThanhToan(Long.parseLong(MaHoaDon));
				request.setAttribute("trangthaidonhang",ttdh);
				long makh = acbean.getMakh();
				if (session.getAttribute("gh") != null) {
					giohangbo ghbo = (giohangbo) session.getAttribute("gh");
					request.setAttribute("sl", ghbo.tongSLhang());
				} else
					request.setAttribute("sl", (long) 0);
				if (MaHoaDon != null) {
					request.setAttribute("chitiethoadon", hdbo.get_chitiethoadon(MaHoaDon,makh));
					chitiethoadonbo cthdbo = new chitiethoadonbo();
					request.setAttribute("tongtt", cthdbo.tongthanhtien(hdbo.get_chitiethoadon(MaHoaDon,makh)));
				}
			}
			RequestDispatcher rs = request.getRequestDispatcher("chitiethoadon.jsp");
			rs.forward(request, response);
		} catch (Exception e) {
			response.getWriter().println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
