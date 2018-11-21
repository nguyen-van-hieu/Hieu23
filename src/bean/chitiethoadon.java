package bean;

public class chitiethoadon {
	private long MaChiTietHD;
	private String MaSach;
	private long SoLuongMua;
	private String tensach;
	private long gia;
	private String anh;
	public chitiethoadon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public chitiethoadon(long maChiTietHD, String maSach, long soLuongMua, String tensach, long gia, String anh) {
		super();
		MaChiTietHD = maChiTietHD;
		MaSach = maSach;
		SoLuongMua = soLuongMua;
		this.tensach = tensach;
		this.gia = gia;
		this.anh = anh;
	}

	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public long getMaChiTietHD() {
		return MaChiTietHD;
	}
	public void setMaChiTietHD(long maChiTietHD) {
		MaChiTietHD = maChiTietHD;
	}
	public String getMaSach() {
		return MaSach;
	}
	public void setMaSach(String maSach) {
		MaSach = maSach;
	}
	public long getSoLuongMua() {
		return SoLuongMua;
	}
	public void setSoLuongMua(long soLuongMua) {
		SoLuongMua = soLuongMua;
	}
}
