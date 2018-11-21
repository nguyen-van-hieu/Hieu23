package bo;

import java.util.ArrayList;

import bean.chitiethoadon;

public class chitiethoadonbo {
	public long tongthanhtien(ArrayList<chitiethoadon> dschitietHD) {
		long tongtt = 0;
		for(chitiethoadon cthd : dschitietHD)
			tongtt += cthd.getSoLuongMua()*cthd.getGia();
		return tongtt;
	}
}
