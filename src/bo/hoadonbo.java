package bo;

import java.util.ArrayList;

import bean.chitiethoadon;
import bean.hoadonbean;
import dao.hoadondao;

public class hoadonbo {
	public ArrayList<hoadonbean> dsgh;
	hoadondao hddao = new hoadondao();

	public ArrayList<hoadonbean> get_hoadon(long makh) throws Exception {
		dsgh = hddao.get_hoadon(makh);
		return dsgh;
	}
	public ArrayList<chitiethoadon> get_chitiethoadon(String MaHoaDon, long makh) throws Exception{
		get_hoadon(makh);
		for(hoadonbean hd : dsgh ) {
			if(hd.getMaHoaDon().equals(MaHoaDon))
				return hd.getChitiethoadon();
		}
		return null;
	}
	public long taoMaHD() throws Exception{
		return hddao.taoMaHD();
	}
	public long InsertHD(long makh) throws Exception{
		return hddao.InsertHD(makh);
	}
	public void InsertChitietHD(String masach, long soluongmua, long MaHoaDon) throws Exception{
		hddao.InsertChitietHD(masach, soluongmua, MaHoaDon);
	}
	public void DeleteHD(long mahd) throws Exception{
		hddao.DeleteHD(mahd);
	}
	public void ThanhToanHoaDon(long mahd) throws Exception {
		hddao.ThanhToanHoaDon(mahd);
	}
	public boolean KTDaThanhToan(long mahd) throws Exception {
		return hddao.KTDaThanhToan(mahd);
	}
}
