package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.accoutbean;

public class accountdao {
	public accoutbean kiemtradangnhap(String user, String pass) throws Exception {
		accoutbean ac = null;
		CoSo cs = new CoSo(); cs.ketnoi();
		String sql = "SELECT * FROM dbo.KhachHang WHERE tendn =? AND pass =?";
		PreparedStatement cmd = cs.cn.prepareStatement(sql);
		cmd.setString(1, user);
		cmd.setString(2, pass);
		ResultSet rs = cmd.executeQuery();
		if(rs.next())
			ac = new accoutbean(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
		rs.close();
		cs.dongketnoi();
		return ac;
	}
	public boolean kiemtratontai(String user) throws Exception{
		CoSo cs = new CoSo(); cs.ketnoi();
		String s = null;
		String sql = "SELECT * FROM dbo.KhachHang WHERE tendn =?";
		PreparedStatement cmd = cs.cn.prepareStatement(sql);
		cmd.setString(1, user);
		ResultSet rs = cmd.executeQuery();
		if(rs.next())
			s = rs.getString(6);
		rs.close();
		cs.dongketnoi();
		if(s!=null)
			return false;
		else return true;
	}
	public long taomakhachhang() throws Exception{
		CoSo cs = new CoSo(); cs.ketnoi();
		String sql ="SELECT MAX([KhachHang].makh) FROM [KhachHang]";
		PreparedStatement cmd = cs.cn.prepareStatement(sql);
		long makh = 0;
		ResultSet rs = cmd.executeQuery();
		if(rs.next())
			makh = rs.getLong(1);
		rs.close();
		cs.dongketnoi();
		return makh+1;
	}
	public boolean dangkytaikhoan(String hoten, String diachi, String sodt, String email, String tendn, String matkhau) throws Exception{
		long makh = taomakhachhang();
		CoSo cs = new CoSo(); cs.ketnoi();
		String sql = "INSERT [KhachHang]( makh ,hoten ,diachi ,sodt ,email ,tendn ,pass ,quyen) VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement cmd = cs.cn.prepareStatement(sql);
		cmd.setLong(1,makh);
		cmd.setString(2,hoten);
		cmd.setString(3,diachi);
		cmd.setString(4,sodt);
		cmd.setString(5,email);
		cmd.setString(6,tendn);
		cmd.setString(7,matkhau);
		cmd.setString(8,"nv");
		int i = cmd.executeUpdate();
		cs.dongketnoi();
		if(i>0)
			return true;
		else
			return false;
	}
}
