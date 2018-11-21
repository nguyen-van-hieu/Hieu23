<%@page import="bean.accoutbean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Đăng ký tài khoản</title>
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
		String tt = (String)request.getAttribute("thongbao");
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
							<li class="dropdown-header"><a href=""><%=ac.getHoten()%></a>
							<li align="center"><a href="donhang">Đơn hàng</a>
							<li align="center"><a href="dangxuat">Đăng xuất</a></li>
						</ul>
					</div>
				</li>
				<%
					} 
				%>
				<li><span>&nbsp&nbsp</span></li>
			</ul>
		</div>
	</nav>

	<div class="container-fluid text-center">
		<div class="row content" style="height: 520px;">
			<div class="col-sm-2 sidenav" align="left"></div>
			<div class="col-sm-8 text-left">
				<%if(tt!=null){ %>
				<div class="alert alert-success">
  					<%=tt%>
				</div>
				<%} %>
				<form action="dangkytaikhoan" method="post">
					<div class="form-group">
						<label for="email">Tên đăng nhập:</label> <input type="text" class="form-control" name="user">
					</div>
					<div class="form-group">
						<label for="pwd">Mật khẩu:</label> <input type="password" class="form-control" name="pass">
					</div>
					<div class="form-group">
						<label for="pwd">Họ tên:</label> <input type="text" class="form-control" name="hoten">
					</div>
					<div class="form-group">
						<label for="pwd">Địa chỉ:</label> <input type="text" class="form-control" name="diachi">
					</div>
					<div class="form-group">
						<label for="pwd">Số điện thoại:</label> <input type="text" class="form-control" name="sodt">
					</div>
					<div class="form-group">
						<label for="pwd">Email:</label> <input type="email" class="form-control" name="email">
					</div>
					<button type="submit" class="btn btn-default">Đăng ký</button>
				</form>
			</div>
		</div>
	</div>
	<footer class="container-fluid text-center">
		<p></p>
	</footer>
</body>
</html>