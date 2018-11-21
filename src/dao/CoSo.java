package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CoSo {
	public Connection cn;
	public void ketnoi() throws Exception {
		//Xác định hệ quản trị CSDL
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//System.out.println("Da xac dinh HQTCSDL");
		cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSach;user=sa; password=123");
		//System.out.println("Da ket noi");
	}
	public ResultSet getbang(String tb) throws Exception {
		String sql = "SELECT * FROM ["+tb+"]";
		PreparedStatement cmd = cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		return rs;
	}
	public void dongketnoi() throws Exception {
		cn.close();
	}
}
