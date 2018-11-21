package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.accountbo;

/**
 * Servlet implementation class dangkytaikhoan
 */
@WebServlet("/dangkytaikhoan")
public class dangkytaikhoan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangkytaikhoan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String hoten = request.getParameter("hoten");
		String diachi = request.getParameter("diachi");
		String sodt = request.getParameter("sodt");
		String email = request.getParameter("email");
		try {
			if(user!=null&&pass!=null&&hoten!=null&&diachi!=null&&sodt!=null&&email!=null) {
				accountbo acbo = new accountbo();
				if(acbo.kiemtratontai(user)) {
					if(acbo.dangkitaikhoan(hoten, diachi, sodt, email, user, pass))
						response.sendRedirect("index");
					else
						request.setAttribute("thongbao","Tạo tài khoản thất bại");
				}else {
					request.setAttribute("thongbao","Đã tồn tại tên tài khoản: "+user);
				}
			}
			RequestDispatcher rd = request.getRequestDispatcher("dangkytaikhoan.jsp");
			rd.forward(request, response);
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
