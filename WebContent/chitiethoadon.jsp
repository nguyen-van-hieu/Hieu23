<%@page import="bo.sachbo"%>
<%@page import="bean.chitiethoadon"%>
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
<title>Chi tiết hoá đơn</title>
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
		ArrayList<chitiethoadon> ds = (ArrayList<chitiethoadon>)request.getAttribute("chitiethoadon");
		long tongtt = (long)request.getAttribute("tongtt");
		String mahd = (String)request.getAttribute("MaHD");
		boolean ttdh = (boolean)request.getAttribute("trangthaidonhang");
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
				<table class="table table-striped" style="border-bottom: 1px solid #ddd">
					<tr>
						<td></td>
						<td>Tên sách</td>
						<td>Đơn giá</td>
						<td>Số lượng mua</td>
					</tr>
					<%
					DecimalFormat formatter = new DecimalFormat("###,###,###");
					if(ds!=null){
						for (chitiethoadon c : ds) {
					%>
					<tr>
						<td><img src="<%=c.getAnh()%>" width="80" height="110"></td>
						<td><%=c.getTensach()%></td>
						<td><% out.print(formatter.format(c.getGia()));%> VND</td>
						<td><%=c.getSoLuongMua()%></td>
					</tr>
					<%} }%>
					<%if(ttdh==false) {%>
						<tr><td></td><td></td><td>Tổng: <%out.print(formatter.format(tongtt));%> VND</td>
						<td><a class="btn btn-success" href="thanhtoanhoadon?mahoadon=<%=mahd%>">Thanh Toán</a></td>
					<%}else{ %>
						<tr><td></td><td></td><td colspan="2">Tổng: <%out.print(formatter.format(tongtt));%> VND</td>
					<%} %>
					</tr>
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