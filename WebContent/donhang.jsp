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
		accoutbean ac = (accoutbean) request.getAttribute("tk");
		ArrayList<hoadonbean> ds = (ArrayList<hoadonbean>)request.getAttribute("ds");
	%>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="nav navbar-nav">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index">Book Store</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li>
					<form class="navbar-form navbar-right" action="index"
						style="padding-right: 30px;">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Tìm kiếm tên sách, tác giả ..."
								name="keyword" size="60px">
						</div>
						<button type="submit" class="btn btn-default">Tìm kiếm</button>
					</form>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<%
					if (ac != null) {
				%>
				<li>
					<div class="dropdown" style="padding-top: 8px;">
						<button class="btn btn-link dropdown-toggle"
							data-toggle="dropdown"><%=ac.getTendn()%></button>
						<span class="caret"></span>
						<ul class="dropdown-menu">
							<li class="dropdown-header"><a href="thongtincanhan"><%=ac.getHoten()%></a>
							<li align="center"><a href="donhang">Đơn hàng</a>
							<li align="center"><a href="dangxuat">Đăng xuất</a></li>
						</ul>
					</div>
				</li>
				<%
					} 
				%>
				<%
					long sl = (long) request.getAttribute("sl");
				%>
				<li><a href="cart" data-toggle="tooltip"
					data-placement="bottom" title="Giỏ hàng có <%=sl%> quyển sách!">Giỏ
						hàng <span class="badge"><%=sl%></span>
				</a></li>
				<li><span>&nbsp&nbsp</span></li>
			</ul>
		</div>
	</nav>

	<div class="container-fluid text-center">
		<div class="row content" style="height: 520px;">
			<div class="col-sm-2 sidenav" align="left"></div>
			<div class="col-sm-8 text-left">
				<table class="table table-hover" style="border-bottom: 1px solid #ddd">
					<tr>
						<td>Mã hoá đơn</td>
						<td>Ngày đặt mua</td>
						<td>Trạng thái đơn hàng</td>
						<td></td>
					</tr>
					<%
					if(ds!=null){
						for (hoadonbean c : ds) {
					%>
					<tr>
						<td><%=c.getMaHoaDon()%></td>
						<td><%=c.getNgayMua()%></td>
						<td><%if(c.isDamua()) out.print("Đã thanh toán"); else{ out.print("Chưa thanh toán");}%></td>
						<td>
							<a href="chitiethoadon?mahoadon=<%=c.getMaHoaDon()%>">Xem chi tiết</a> - 
							<a href="xoahoadon?mahoadon=<%=c.getMaHoaDon()%>">Xoá đơn hàng</a>
						</td>
					</tr>
					<%} }%>
				</table>
			</div>
			<div class="col-sm-2 sidenav"></div>
		</div>
	</div>
	<footer class="container-fluid text-center">
		<p></p>
	</footer>
</body>
</html>