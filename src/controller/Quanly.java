package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.loaibo;
import bo.sachbo;
import javafx.scene.chart.PieChart.Data;

/**
 * Servlet implementation class Quanly
 */
@WebServlet("/Quanly")
public class Quanly extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Quanly() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    sachbo sach= new sachbo();
    loaibo loai= new loaibo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
	
		//lay ve ma sach ten sach, tac gia...
		String masach =request.getParameter("txtmasach");
		String tensach=request.getParameter("txttensach");
		String tacgia=request.getParameter("txttacgia");
		String gia=request.getParameter("txtgia");
		String soluong=request.getParameter("txtsoluong");
		String ngaynhap=request.getParameter("txtngaynhap");
		String anh=request.getParameter("txtanh");
		String maloai=request.getParameter("txtmaloai");
		SimpleDateFormat dd=new SimpleDateFormat("yyyy-MM-dd");
		if(request.getParameter("them")!=null) {
			 Date nn=dd.parse(ngaynhap);
			 sach.Them(masach, tensach, tacgia,Long.parseLong(soluong),Long.parseLong(gia),nn, anh, maloai);
			
		}else
			if(request.getParameter("Sua")!=null) {
				Date nn= dd.parse(ngaynhap);
				sach.Sua(masach, tensach, tacgia,Long.parseLong(soluong),Long.parseLong(gia), nn, anh, maloai);
				
						
			}else
				if(request.getParameter("Xoa")!=null)
					sach.Xoa(masach);
		request.setAttribute("dsloai", loai.getloai());
		request.setAttribute("dssach", sach.getsach());
		
		RequestDispatcher rd= request.getRequestDispatcher("QuanLy.jsp");
		rd.forward(request, response);
		
	} catch (Exception e) {
		e.printStackTrace();;
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
