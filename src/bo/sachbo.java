package bo;

import java.util.ArrayList;
import java.util.Date;

import bean.sachbean;
import dao.sachdao;

public class sachbo {
	sachdao sdao = new sachdao();
	public static ArrayList<sachbean> ds=new ArrayList<sachbean>();
	public int Them(String masach, String tensach,String tacgia,long soluong,long gia, Date ngaynhap,String anh, String maloai)throws Exception {
		for(sachbean ss: ds) {
			if(ss.getMasach().trim().toLowerCase().equals(masach.trim().toLowerCase()));
		return 0;
		}
	
		return sdao.Them(masach, tensach, tacgia, soluong, gia, ngaynhap, anh, maloai);
	}
	public int Sua(String masach, String tensach,String tacgia,long soluong,long gia, Date ngaynhap,String anh, String maloai)throws Exception {
		for(sachbean ss: ds) {
			if(ss.getMasach().trim().toLowerCase().equals(masach.trim().toLowerCase()));
			{
				ss.setTensach(tensach);
				ss.setSoluong(soluong);
				ss.setGia(gia);
				ss.setAnh(anh);
				ss.setMaloai(maloai);
				return sdao.Sua(masach, tensach, tacgia, soluong, gia, ngaynhap, anh, maloai);
			}
		}
		return 0;
	}
	public int Xoa(String masach) throws Exception{
		for(sachbean ss:ds) 
			//neu tim thay ma sach thi xoa
			if(ss.getMasach().trim().toLowerCase().equals(masach.trim().toLowerCase())) {
				ds.remove(ss);// xoa trong bo nho
				return sdao.Xoa(masach);
			}
		return 0;
	}
	
	public ArrayList<sachbean> getsach() throws Exception{
		return sdao.getsach();
	}
	public ArrayList<sachbean> getsachtheoloai(String maloai) throws Exception{
		return sdao.getsachtheoloai(maloai);
	}
	
	public ArrayList<sachbean> timkiem(String key) throws Exception{
		return sdao.timkiem(key);
	}
	public ArrayList<sachbean> getpage(int page, ArrayList<sachbean> ls) throws Exception{
		int s = ls.size();
		ArrayList<sachbean> lst = new ArrayList<sachbean>();
		int min = page*12 - 11;
		int max = page*12;
		if(max>s)
			max=s;
		for(int i = min;i<=max;i++) {
			lst.add(ls.get(i-1));
		}
		return lst;
	}
	public sachbean getsachtheomasach(String masach) throws Exception{
		return sdao.getsachtheomasach(masach);
	}
}
