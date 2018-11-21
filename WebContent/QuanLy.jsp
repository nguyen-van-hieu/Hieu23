<%@page import="bean.hoadonbean"%>
<%@page import="bean.accoutbean"%>
<%@page import="bean.loaibean"%>
<%@page import="bean.sachbean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.CoSo"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Đơn hàng</title>
<link rel="icon" type="image/png" href="asset/icon/favicon-32x32.png"
	sizes="32x32" />
<link rel="stylesheet" type="text/css"
	href="asset/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="asset/css/m.css">
<script src="asset/JQuery/jquery.min.js"></script>
<script src="asset/JQuery/bootstrap.min.js"></script>
<style >
.navbar-inverse .navbar-collapse, .navbar-inverse .navbar-form {

    background: #0e1f42;
}
</style>
</head>
<body>
	<%
		
		ArrayList<sachbean> dssach=(ArrayList<sachbean>)request.getAttribute("dssach");
		ArrayList<loaibean> dsloai=(ArrayList<loaibean>)request.getAttribute("dsloai");
		
		
	%>
	

	

					<form action="Quanly" method="post">
		Mã sách :<input type="text" name='txtmasach' value="" ><br>
		Tên sách :<input type="text" name='txttensach' value="" ><br>
				Tác Giả :<input type="text" name='txttacgia' value="" ><br>
					Giá :<input type="number" name='txtgia' value="" ><br>
						Số lượng :<input type="number" name='txtsoluong' value="" ><br>
							Ảnh :<input type="file" name='txtanh' value="" ><br>
								Ngày nhập :<input type="date" name='txtngaynhap' value="" ><br>
								Chọn loại:<select name="txtmaloai">
								<%for(loaibean loai: dsloai){ %>
								<option value=<%=loai.getMaloai()%>>
								<%=loai.getTenloai() %>
								</option>
								<%} %>
								</select><input type="button" name='them' value="Thêm"><input type="button" name='Sua' value="Sửa"><input type="button" name='Xoa' value="Xóa">
		</form>
		
	<table cellpadding="0" cellspacing="0" border="1">
	
	<tr>
	<th>mã sách </th>
	<th>Tên sách  </th>
	<th>Tác giả </th>
	<th>Giá </th>
	<th>Số lượng </th>
	<th>Ảnh</th>
	<th>Ngày nhập </th>
	
	</tr>
	
	<%for(sachbean sach : dssach){ %>
	
	<tr>
	<td><%=sach.getMasach() %></td>
	<td><%=sach.getTensach() %></td>
	<td><%=sach.getTacgia() %></td>
	<td><%=sach.getGia() %></td>
	</tr>
	<%} %>
	
	
	</table>

</body>
</html>