package bo;

import bean.accoutbean;
import dao.accountdao;

public class accountbo {
	accountdao acdao = new accountdao();
	public accoutbean acount;
	public boolean kiemtradangnhap(String user,String pass) throws Exception{
		acount = acdao.kiemtradangnhap(user, pass);
		if(acount!=null)
			return true;
		else {
			return false;
		}
	}
	public boolean kiemtratontai(String user) throws Exception{
		return acdao.kiemtratontai(user);
	}
	public boolean dangkitaikhoan(String hoten, String diachi, String sodt, String email, String tendn, String matkhau) throws Exception {
		return acdao.dangkytaikhoan(hoten, diachi, sodt, email, tendn, matkhau);
	}
}
