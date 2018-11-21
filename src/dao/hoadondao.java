package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.chitiethoadon;
import bean.hoadonbean;

public class hoadondao {
	public ArrayList<chitiethoadon> get_chitiet(String mahoadon) throws Exception{
		ArrayList<chitiethoadon> ds = new ArrayList<chitiethoadon>();
		CoSo cs = new CoSo();
		cs.ketnoi();
		String sql = "SELECT * FROM [View_Chitiethoadon] WHERE MaHoaDon = ?";
		PreparedStatement cmd = cs.cn.prepareStatement(sql);
		cmd.setString(1, mahoadon);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			ds.add(new chitiethoadon(rs.getLong(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getLong(5),rs.getString(6)));
		}
		rs.close();
		cs.dongketnoi();
		return ds;
	}
	
	public ArrayList<hoadonbean> get_hoadon(long makh) throws Exception{
		ArrayList<hoadonbean> dshoadon = new ArrayList<hoadonbean>();
		CoSo cs = new CoSo();
		cs.ketnoi();
		String sql = "SELECT * FROM [hoadon] WHERE makh = ?";
		PreparedStatement cmd = cs.cn.prepareStatement(sql);
		cmd.setLong(1, makh);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			hoadonbean c = new hoadonbean();
			c.setMakh(rs.getLong(2));
			c.setMaHoaDon(rs.getString(1));
			c.setNgayMua(rs.getDate(3));
			c.setDamua(rs.getBoolean(4));
			c.setChitiethoadon(null);
			dshoadon.add(c);
		}
		rs.close();
		cs.dongketnoi();
		for(hoadonbean c : dshoadon) {
			c.setChitiethoadon(get_chitiet(c.getMaHoaDon()));
		}
		return dshoadon;
	}
	public long taoMaChitietHD() throws Exception{
		CoSo cs = new CoSo(); cs.ketnoi();
		String sql="SELECT MAX(MaChiTietHD) FROM [ChiTietHoaDon]";
		PreparedStatement cmd = cs.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery(); long MaChiTietHD = 1;
		if(rs.next())
			MaChiTietHD = rs.getLong(1)+1;
		rs.close();
		cs.dongketnoi();
		return MaChiTietHD;
	}
	public long taoMaHD() throws Exception{
		CoSo cs = new CoSo(); cs.ketnoi();
		String sql="SELECT MAX(MaHoaDon) FROM [hoadon]";
		PreparedStatement cmd = cs.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery(); long MaHD = 1;
		if(rs.next())
			MaHD = rs.getLong(1);
		rs.close();
		cs.dongketnoi();
		return MaHD;
	}
	public boolean kiemtraMaHD(long mahd) throws Exception {
		CoSo cs = new CoSo(); cs.ketnoi();
		String sql="SELECT * FROM [hoadon] WHERE MaHoaDon = ?";
		PreparedStatement cmd = cs.cn.prepareStatement(sql);
		cmd.setLong(1,mahd);
		ResultSet rs = cmd.executeQuery(); int i = 0;
		if(rs.next())
			i++;
		if(i>0)
			return true;
		return false;
	}
	public long InsertHD(long makh) throws Exception{
		CoSo cs = new CoSo(); cs.ketnoi();
		String sql = "INSERT [hoadon](makh, NgayMua, damua )VALUES  (?,GETDATE(),0)";
		PreparedStatement cmd = cs.cn.prepareStatement(sql);
		cmd.setLong(1,makh);
		cmd.executeUpdate();
		cs.dongketnoi();
		return taoMaHD();
	}
	public void InsertChitietHD(String masach, long soluongmua, long MaHoaDon) throws Exception{
		CoSo cs = new CoSo(); cs.ketnoi();
		String sql = "INSERT [ChiTietHoaDon](MaSach,SoLuongMua,MaHoaDon) VALUES (?,?,?)";
		PreparedStatement cmd = cs.cn.prepareStatement(sql);
		//cmd.setLong(1,taoMaChitietHD()); 
		cmd.setString(1,masach);
		cmd.setLong(2,soluongmua); cmd.setLong(3,MaHoaDon);
		cmd.executeUpdate();
		cs.dongketnoi();
	}
	public void DeleteHD(long mahd) throws Exception{
		CoSo cs = new CoSo(); cs.ketnoi();
		String sql = "DELETE [hoadon] WHERE MaHoaDon = ?";
		PreparedStatement cmd = cs.cn.prepareStatement(sql);
		cmd.setLong(1,mahd);
		cmd.executeUpdate();
		cs.dongketnoi();
	}
	public void ThanhToanHoaDon(long mahd) throws Exception {
		CoSo cs = new CoSo(); cs.ketnoi();
		String sql="UPDATE dbo.hoadon SET damua = ? WHERE MaHoaDon = ?";
		PreparedStatement cmd = cs.cn.prepareStatement(sql);
		cmd.setLong(1,1);
		cmd.setLong(2,mahd);
		cmd.executeUpdate();
		cs.dongketnoi();
	}
	public boolean KTDaThanhToan(long mahd) throws Exception {
		CoSo cs = new CoSo(); cs.ketnoi();
		String sql="SELECT * FROM dbo.hoadon WHERE MaHoaDon = ? AND damua = 1";
		PreparedStatement cmd = cs.cn.prepareStatement(sql);
		cmd.setLong(1,mahd);
		ResultSet rs = cmd.executeQuery(); int i = 0;
		if(rs.next())
			i++;
		if(i>0)
			return true;
		return false;
	}
}
