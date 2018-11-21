package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import bean.loaibean;

public class loaidao {
	public ArrayList<loaibean> getloai() throws Exception{
		ArrayList<loaibean> lstloai = new ArrayList<loaibean>();
		CoSo s = new CoSo(); s.ketnoi();
		ResultSet rs = s.getbang("loai");
		while(rs.next()) {
			lstloai.add(new loaibean(rs.getString(1),rs.getString(2)));
		}
		rs.close();
		s.dongketnoi();
		return lstloai;
	}
}
