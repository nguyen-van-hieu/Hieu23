<%@page import="bean.accoutbean"%>
<%@page import="bean.loaibean"%>
<%@page import="bean.giohangbean"%>
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
<title>Giỏ hàng</title>
<link rel="icon" type="image/png" href="asset/icon/favicon-32x32.png"
	sizes="32x32" />
<link rel="stylesheet" type="text/css"
	href="asset/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="asset/css/m.css">
<script src="asset/JQuery/jquery.min.js"></script>
<script src="asset/JQuery/bootstrap.min.js"></script>
<style>
.navbar-inverse .navbar-collapse, .navbar-inverse .navbar-form {

    background: #0e1f42;
}
 .h3, h3 {
    color: blue;
}
h2{
color:red;
}

</style>
</head>
<body>
	<%
		ArrayList<loaibean> lstloai = (ArrayList<loaibean>) request.getAttribute("lstloai");
		ArrayList<giohangbean> lsthangtronggio = (ArrayList<giohangbean>) request.getAttribute("lsthangtronggio");
		Long thanhtien = (Long) request.getAttribute("thanhtien");
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		accoutbean ac = (accoutbean) request.getAttribute("tk");
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
					} else{
				%>
						<li><a href="" data-toggle="modal" data-target="#myModal">Đăng nhập</a></li>
						<li><a href="dangkytaikhoan">Tạo tài khoản</a></li>
				<%
					}
				%>
				<li><a href="cart">Giỏ hàng <span class="badge"><span
							id="soluong">
								<%
									long sl = (long) request.getAttribute("sl");
									out.print(sl);
								%>
						</span></span></a></li>
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
			<h3 align="center">Loại sách</h3>
				<ul class="list-group">
					<%
						if (lstloai != null) {
					%>
					<%
						for (loaibean l : lstloai) {
					%>
					<li class="list-group-item"><a
						href="index?maloai=<%=l.getMaloai()%>"><%=l.getTenloai()%></a></li>
					<%
						}
						}
					%>
				</ul>
			</div>
			<div class="col-sm-7 text-center">
				<div class="container-fluid">
					<div class="row">
						<table id="giohang" class="table table-striped table-hover"
							style="border-bottom: 1px solid #ddd">
							<tbody>
								<%
									if (lsthangtronggio != null) {
										for (giohangbean g : lsthangtronggio) {
								%>
								<tr>
									<td data-masach="<%=g.getMasach()%>">
										<div class="container-fluid">
											<div class="row">
												<div class="col-sm-2" align="left">
													<img alt="" src="<%=g.getAnh()%>" width="120" height="160">
												</div>
												<div class="col-sm-7" align="left">
													<div class="panel panel-success">
														<div class="panel-heading"><b><%=g.getTensach()%></b></div>
														<div class="panel-body"><b>Giá:<%out.print(formatter.format(g.getGia()));%> VND</b></div>
														<div class="panel-body"><button style="padding: 1px;" class="delitem" data-masach="<%=g.getMasach()%>">Xoá</button></div>
													</div>
												</div>
												<div class="col-sm-3" align="center">
													<ul class="pagination"
														style="padding-top: 32px; padding-bottom: 20px;">
														<li><a class="giam" href="javascript:void(0)"
															data-masach="<%=g.getMasach()%>">-</a></li>
														<li><a href="javascript:void(0)"><span
																data-masach="<%=g.getMasach()%>"><%=g.getSoluongmua()%></span></a></li>
														<li><a class="tang" href="javascript:void(0)"
															data-masach="<%=g.getMasach()%>">+</a></li>
													</ul>
												</div>
											</div>
										</div>
									</td>
								</tr>
								<%
									}
									}
								%>
							</tbody>
						</table>
						<div>
							<button id="xoahet" class="btn btn-primary">Xoá hết</button>
							<a href="index" class="btn btn-primary">Tiếp tục mua hàng</a>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-3 sidenav">
				<div style="position: fixed; width: 23%;">
					<div class="panel panel-primary">
						<div class="panel-heading">Thành tiền</div>
						<div class="panel-body" style="font-size: 25px;"><span id="tt"> <%out.print(formatter.format(thanhtien)); %></span> VND</div>
					</div>
					<%if(ac!=null) {%>
						<a href="donhangmoi" class="btn btn-success" style="width: 100%;">Đặt hàng</a>
					<%}else{ %>
						<a href="dangnhap" class="btn btn-success" style="width: 100%;">Đặt hàng</a>
					<%} %>
				</div>
			</div>
		</div>
	</div>
	<div align="center">
		<ul class="pagination">

		</ul>
	</div>
	<footer class="container-fluid text-center">
		<p></p>
	</footer>
</body>
<script type="text/javascript">
	$("#xoahet").click(function(e) {
		e.preventDefault();
		$.get("xulygiohang", {
			ma : "xoahet"
		}, function(data) {
			$("table[id=giohang]").remove();
			$("#tt").html(data);
		});
	});
	$(".giam").click(function(e) {
		var masach = $(this).attr("data-masach");
		$.get("xulygiohang", {
			masach : masach,
			ma : "giam"
		}, function(data) {
			var s = $("span[data-masach=" + masach + "]").text();
			s = parseInt(s);
			if (s == 1) {
				$("td[data-masach=" + masach + "]").remove();
				$("#tt").html(data);
			} else {
				s--;
				$("span[data-masach=" + masach + "]").html(s);
				$("#tt").html(data);
			}
		});
	});
	$(".tang").click(function() {
		var masach = $(this).attr("data-masach");
		$.get("xulygiohang", {
			masach : masach,
			ma : "tang"
		}, function(data) {
			var s = $("span[data-masach	=" + masach + "]").text();
			s = parseInt(s);
			s++;
			$("span[data-masach=" + masach + "]").html(s);
			$("#tt").html(data);
		});
	});
	$(".delitem").click(function(e) {
		var masach = $(this).attr("data-masach");
		$.get("xulygiohang", {
			masach : masach,
			ma : "xoa"
		}, function(data) {
			$("td[data-masach=" + masach + "]").remove();
			$("#tt").html(data);
		});
	});
	$("#xoahet,.delitem,.giam,.tang").click(function(e) {
		$.get("xulygiohang", {
			ma : "soluong"
		}, function(data) {
			$("#soluong").html(data);
		});
	});
</script>
</html>