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
<title>Chi tiết</title>
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
		ArrayList<loaibean> lstloai = (ArrayList<loaibean>) request.getAttribute("lstloai");
		accoutbean ac = (accoutbean) request.getAttribute("tk");
		String maloai = (String)request.getAttribute("maloai");
		String keyword = (String)request.getAttribute("keyword");
		sachbean sbean = (sachbean)request.getAttribute("sach");
		DecimalFormat formatter = new DecimalFormat("###,###,###");
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
			<%
				long sl = (long) request.getAttribute("sl");
			%>
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
					} else {
				%>
						<li><a href="" data-toggle="modal" data-target="#myModal">Đăng nhập</a></li>
						<li><a href="dangkytaikhoan">Tạo tài khoản</a></li>
				<%
					}
				%>
				<li><a href="cart" data-toggle="tooltip"
					data-placement="bottom" title="Giỏ hàng có <%=sl%> quyển sách!">Giỏ
						hàng <span class="badge"><%=sl%></span>
				</a></li>
				<li><span>&nbsp&nbsp</span></li>
			</ul>
		</div>
	</nav>
	<div id="myModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Đăng nhập</h4>
				</div>
				<div class="modal-body">
					<div class="dang-nhap">
						<form action="kiemtradangnhap" method="post">
							<div class="form-group">
								<label for="email">Tên đăng nhập:</label> <input type="text"
									class="form-control" name="user">
							</div>
							<div class="form-group">
								<label for="pwd">Password:</label> <input type="password"
									class="form-control" name="pass">
							</div>
							<button type="submit" class="btn btn-default">Đăng nhập</button>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>


	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav" align="left">
				<ul class="list-group">
					<%if (lstloai != null) {%>
					<%for (loaibean l : lstloai) {%>
					<li class="list-group-item"><a
						href="index?maloai=<%=l.getMaloai()%>"><%=l.getTenloai()%></a></li>
					<%}}%>
				</ul>
			</div>
			<div class="col-sm-8 text-center">
				<%if(sbean!=null){ %>
				<div class="panel panel-success text-left">
					<div class="panel-heading text-center">
						<b>Thông tin chi tiết</b>
					</div>
					<div class="container-fuild">
						<div class="row">
							<div class="col-sm-3">
								<img src="<%=sbean.getAnh()%>" style="padding: 10px; width: 180px; height: 200px;">
							</div>
							<div class="col-sm-9">
								<div class="panel-body">
									<b>Tên sách: <%=sbean.getTensach()%></b>
								</div>
								<div class="panel-body">
									<b>Tác giả: <%=sbean.getTacgia()%></b>
								</div>
								<div class="panel-body">
									<b>Số lượng: <%=sbean.getSoluong()%></b>
								</div>
								<div class="panel-body">
									<b>Giá: <%out.print(formatter.format(sbean.getGia()));%> VND</b>
								</div>
							</div>
						</div>
					</div>
					<div class="panel-body">
						<a class="btn btn-success btn-sm" style="width: 100%;" href="themmoi?masach=<%=sbean.getMasach()%>&tensach=<%=sbean.getTensach() %>&gia=<%=sbean.getGia()%>&slmua=1&img=<%=sbean.getAnh()%>">Thêm vào giỏ hàng</a>
					</div>
				</div>
				<%} %>
			</div>
			<div class="col-sm-2 sidenav">
			</div>
		</div>
	</div>
	<footer class="container-fluid text-center">
		<p></p>
	</footer>
</body>
</html>