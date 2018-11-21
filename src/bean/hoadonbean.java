package bean;

import java.util.ArrayList;
import java.util.Date;

public class hoadonbean {
	private long makh;
	private String MaHoaDon;
	private Date NgayMua;
	private boolean damua;
	private ArrayList<chitiethoadon> chitiethoadon;
	public hoadonbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public hoadonbean(long makh, String maHoaDon, Date ngayMua, boolean damua, ArrayList<chitiethoadon> chitiethoadon) {
		super();
		this.makh = makh;
		MaHoaDon = maHoaDon;
		NgayMua = ngayMua;
		this.damua = damua;
		this.chitiethoadon = chitiethoadon;
	}
	public long getMakh() {
		return makh;
	}
	public void setMakh(long makh) {
		this.makh = makh;
	}
	public String getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		MaHoaDon = maHoaDon;
	}
	public Date getNgayMua() {
		return NgayMua;
	}
	public void setNgayMua(Date ngayMua) {
		NgayMua = ngayMua;
	}
	public boolean isDamua() {
		return damua;
	}
	public void setDamua(boolean damua) {
		this.damua = damua;
	}
	public ArrayList<chitiethoadon> getChitiethoadon() {
		return chitiethoadon;
	}
	public void setChitiethoadon(ArrayList<chitiethoadon> chitiethoadon) {
		this.chitiethoadon = chitiethoadon;
	}
}
