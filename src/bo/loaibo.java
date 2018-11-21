package bo;

import java.util.ArrayList;

import bean.loaibean;
import dao.loaidao;

public class loaibo {
	loaidao ldao = new loaidao();
	public ArrayList<loaibean> lstbean = new ArrayList<loaibean>();
	public ArrayList<loaibean> getloai() throws Exception{
		lstbean = ldao.getloai();
		return lstbean;
	}
}
