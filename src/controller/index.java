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
import bean.sachbean;
import bo.giohangbo;
import bo.loaibo;
import bo.sachbo;

/**
 * Servlet implementation class index
 */
@WebServlet("/index")
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public index() {
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
			ArrayList<loaibean> lstloai = lbo.getloai();
			ArrayList<sachbean> lstsach = sbo.getsach();
			String maloai = request.getParameter("maloai");
			String keyword = request.getParameter("keyword");
			String page = request.getParameter("page");
			if(page==null)
				request.setAttribute("page",1);
			else {
				request.setAttribute("page",Integer.parseInt(page));
			}
			if(page==null||Integer.parseInt(page)<1) {
				request.setAttribute("maxpage",lstsach.size()/12+1);
				request.setAttribute("lstsach",sbo.getpage(1,sbo.getsach()));
			}
			else {
				request.setAttribute("maxpage",lstsach.size()/12+1);
				request.setAttribute("lstsach",sbo.getpage(Integer.parseInt(page),lstsach));
			}
			if(maloai!=null) {
				ArrayList<sachbean> ls = sbo.getsachtheoloai(maloai);
				request.setAttribute("maloai", maloai);
				request.setAttribute("maxpage",ls.size()/12 +1);
				if(page==null) {
					request.setAttribute("lstsach",sbo.getpage(1,ls));
				}else {
					request.setAttribute("lstsach",sbo.getpage(Integer.parseInt(page),ls));
				}
			}
			if(keyword!=null&&maloai==null) {
				ArrayList<sachbean> lstk = sbo.timkiem(keyword);
				request.setAttribute("keyword", keyword);
				request.setAttribute("maxpage",lstk.size()/12 +1);
				if(page==null) {
					request.setAttribute("lstsach",sbo.getpage(1,lstk));
				}else {
					request.setAttribute("lstsach",sbo.getpage(Integer.parseInt(page),lstk));
				}
			}
			request.setAttribute("lstloai", lstloai);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
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
