package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.accountbo;

/**
 * Servlet implementation class kiemtradangnhap
 */
@WebServlet("/kiemtradangnhap")
public class kiemtradangnhap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public kiemtradangnhap() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		if(user!=null&&pass!=null) {
			accountbo acbo = new accountbo();
			try {
				response.setCharacterEncoding("utf-8");
				request.setCharacterEncoding("utf-8");
				if(acbo.kiemtradangnhap(user, pass)) {
					session.setAttribute("account", acbo.acount);
					response.sendRedirect("index");
				}
				request.setAttribute("tb","Đăng nhập thất bại");
				response.sendRedirect("dangnhap");
			} catch (Exception e) {
				response.getWriter().println(e.getMessage());
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
