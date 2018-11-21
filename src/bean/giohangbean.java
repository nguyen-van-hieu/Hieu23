package bean;

public class giohangbean {
	private String masach;
	private String tensach;
	private Long gia;
	private Long soluongmua;
	private Long thanhtien;
	private String anh;
	public giohangbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public giohangbean(String masach, String tensach, Long gia, Long soluongmua, String anh) {
		super();
		this.masach = masach;
		this.tensach = tensach;
		this.gia = gia;
		this.soluongmua = soluongmua;
		this.thanhtien = gia*soluongmua;
		this.anh = anh;
	}
	public String getMasach() {
		return masach;
	}
	public void setMasach(String masach) {
		this.masach = masach;
	}
	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public Long getGia() {
		return gia;
	}
	public void setGia(Long gia) {
		this.gia = gia;
	}
	public Long getSoluongmua() {
		return soluongmua;
	}
	public void setSoluongmua(Long soluongmua) {
		this.soluongmua = soluongmua;
	}
	public Long getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(Long thanhtien) {
		this.thanhtien = thanhtien;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
}
