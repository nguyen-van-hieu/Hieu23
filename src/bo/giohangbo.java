package bo;

import java.util.ArrayList;

import bean.giohangbean;

public class giohangbo {
	public ArrayList<giohangbean> dshang = new ArrayList<giohangbean>();
	public ArrayList<giohangbean> getgh(){
		return dshang;
	}
	public int kiemtra(String masach) {
		int n = dshang.size();
		for(int i=0;i<n;i++) {
			if(dshang.get(i).getMasach().equals(masach))
				return i;
		}
		return -1;
	}
	public void them(String masach,String tensach, String gia, String soluongmua,String anh) {
		int index = kiemtra(masach);
		if(index!=-1) {
			Long sl = dshang.get(index).getSoluongmua() + 1;
			Long tt = dshang.get(index).getThanhtien() * sl;
			dshang.get(index).setSoluongmua(sl);
			dshang.get(index).setThanhtien(tt);
		}else {
			dshang.add(new giohangbean(masach,tensach,Long.parseLong(gia),Long.parseLong(soluongmua),anh));
		}
	}
	public void xoahet() {
		dshang.clear();
	}
	public Long thanhtien() {
		Long tongthanhtien = (long)0;
		for(giohangbean g : dshang) {
			tongthanhtien+= g.getThanhtien();
		}
		return tongthanhtien;
	}
	public void giam(String masach) {
		int n = dshang.size();
		for(int i=0;i<n;i++) {
			if(masach.equals(dshang.get(i).getMasach()))
			{
				if(dshang.get(i).getSoluongmua()>=1)
				{	
					Long sl = dshang.get(i).getSoluongmua() - 1; 
					dshang.get(i).setSoluongmua(sl);
					dshang.get(i).setThanhtien(sl*dshang.get(i).getGia());
				}
				if(dshang.get(i).getSoluongmua()==0) {
					dshang.remove(i);
				}
			}
		}
	}
	public void tang(String madt) {
		int n = dshang.size();
		for(int i=0;i<n;i++) {
			if(madt.equals(dshang.get(i).getMasach()))
			{
				Long sl = dshang.get(i).getSoluongmua() + 1; 
				dshang.get(i).setSoluongmua(sl);
				dshang.get(i).setThanhtien(sl*dshang.get(i).getGia());
			}
		}
	}
	public void xoa(String ma) {
		int n = dshang.size();
		for(int i=0;i<n;i++) {
			if(dshang.get(i).getMasach().equals(ma))
			{	
				dshang.remove(i);
				thanhtien();
				return;
			}
		}
	}
	public long tongSLhang() {
		if(dshang == null)
			return 0;
		else {
			long tong = 0;
			for(giohangbean g : dshang) {
				tong += g.getSoluongmua();
			}
			return tong;
		}
	}
}
