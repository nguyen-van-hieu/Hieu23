package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.sachbean;

public class sachdao {
	//them sach
	public int Them(String masach, String tensach,String tacgia,long soluong,long gia, Date ngaynhap,String anh, String maloai)throws Exception {
		CoSo cs=new CoSo();
		cs.ketnoi();
		String sql="insert into sach(masach,tensach,tacgia,soluong,gia,ngaynhap,anh,"+ "maloai) values(?,?,?,?,?,?,?,?)";
		PreparedStatement cmd=cs.cn.prepareStatement(sql);
		cmd.setString(1, masach);
		cmd.setString(2, tensach);
		cmd.setString(3, tacgia);
		cmd.setLong(4, soluong);
		cmd.setLong(4, gia);
		cmd.setDate(6, new java.sql.Date(ngaynhap.getTime())); //chuyen tu ngay util sang ngay sql 
		cmd.setString(7, anh);
		cmd.setString(8, maloai);
		int kq=cmd.executeUpdate();
		cs.cn.close();
				
		
		
		return kq;
	}
	//sua sach
	public int Sua(String masach, String tensach,String tacgia,long soluong,long gia, Date ngaynhap,String anh, String maloai)throws Exception {
		CoSo cs=new CoSo();
		cs.ketnoi();
		String sql="update sach set tensach=?,tacgia=?,soluong=?,gia=?,"+"ngaynhap=?,anh=?,maloai=? where masach=?";
		PreparedStatement cmd=cs.cn.prepareStatement(sql);
		cmd.setString(8, masach);
		cmd.setString(1, tensach);
		cmd.setString(2, tacgia);
		cmd.setLong(3, soluong);
		cmd.setLong(4, gia);
		cmd.setDate(5, new java.sql.Date(ngaynhap.getTime())); //chuyen tu ngay util sang ngay sql 
		cmd.setString(6, anh);
		cmd.setString(7, maloai);
		
		
		int kq=cmd.executeUpdate();
		cs.cn.close();
				
		
		
		return kq;
	}
	//xoa sach
	public int Xoa(String masach) throws Exception{
		CoSo cs=new CoSo();
		cs.ketnoi();
		String sql="delete from sach where masach=?";
		PreparedStatement cmd=cs.cn.prepareStatement(sql);
		cmd.setString(1, masach);
		int kq=cmd.executeUpdate();
		cs.cn.close();
				
		
		
		return kq;
	}
	
	public ArrayList<sachbean> getsach() throws Exception {
		ArrayList<sachbean> lstsach = new ArrayList<sachbean>();
		CoSo s = new CoSo();
		s.ketnoi();
		ResultSet rs = s.getbang("sach");
		while (rs.next()) {
			lstsach.add(new sachbean(rs.getString(1), rs.getString(2), rs.getLong(3), rs.getLong(4), rs.getString(5),
					rs.getString(6), rs.getString(7), rs.getDate(8), rs.getString(9)));
		}
		rs.close();
		s.dongketnoi();
		return lstsach;
	}
	public sachbean getsachtheomasach(String masach) throws Exception{
		CoSo cs = new CoSo();
		cs.ketnoi();
		sachbean s = null;
		String sql = "SELECT * FROM [sach] WHERE masach = ?";
		PreparedStatement cmd = cs.cn.prepareStatement(sql);
		cmd.setString(1, masach);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			String maloai = rs.getString("maloai");
			String tensach = rs.getString("tensach");
			Long soluong = rs.getLong("soluong");
			Long gia = rs.getLong("gia");
			String sotap = rs.getString("sotap");
			String anh = rs.getString("anh");
			Date NgayNhap = rs.getDate("NgayNhap");
			String tacgia = rs.getString("tacgia");
			s = new sachbean(masach, tensach, soluong, gia, maloai, sotap, anh, NgayNhap, tacgia);
		}
		rs.close();
		cs.dongketnoi();
		return s;
	}
	public ArrayList<sachbean> getsachtheoloai(String maloai) throws Exception {
		CoSo cs = new CoSo();
		cs.ketnoi();
		ArrayList<sachbean> lstsach = new ArrayList<sachbean>();
		String sql = "SELECT * FROM [sach] WHERE maloai = ?";
		PreparedStatement cmd = cs.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			String masach = rs.getString("masach");
			String tensach = rs.getString("tensach");
			Long soluong = rs.getLong("soluong");
			Long gia = rs.getLong("gia");
			String sotap = rs.getString("sotap");
			String anh = rs.getString("anh");
			Date NgayNhap = rs.getDate("NgayNhap");
			String tacgia = rs.getString("tacgia");
			lstsach.add(new sachbean(masach, tensach, soluong, gia, maloai, sotap, anh, NgayNhap, tacgia));
		}
		rs.close();
		cs.dongketnoi();
		return lstsach;
	}
	public ArrayList<sachbean> timkiem(String key) throws Exception{
		CoSo cs = new CoSo();
		cs.ketnoi();
		ArrayList<sachbean> lstsach = new ArrayList<sachbean>();
		String sql = "SELECT * FROM [sach] WHERE tensach LIKE ? OR tacgia LIKE ?";
		PreparedStatement cmd = cs.cn.prepareStatement(sql);
		cmd.setString(1,"%"+key+"%");
		cmd.setString(2,"%"+key+"%");
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			String masach = rs.getString("masach");
			String tensach = rs.getString("tensach");
			Long soluong = rs.getLong("soluong");
			Long gia = rs.getLong("gia");
			String maloai = rs.getString("maloai");
			String sotap = rs.getString("sotap");
			String anh = rs.getString("anh");
			Date NgayNhap = rs.getDate("NgayNhap");
			String tacgia = rs.getString("tacgia");
			lstsach.add(new sachbean(masach, tensach, soluong, gia, maloai, sotap, anh, NgayNhap, tacgia));
		}
		rs.close();
		cs.dongketnoi();
		return lstsach;
	}
}
