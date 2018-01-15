<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>user</title>
</head>

<link rel="stylesheet" type="text/css"
	href="/springmvc_mybatis/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet"
	href="/springmvc_mybatis/css/user/userList.css" />
<!-- 	http://localhost:8080/springmvc_mybatis/user -->

<body>

	<!-- 	<button id="excelImport">导入</button> -->
	<!-- 	<button id="excelExport">导出</button> -->

	<br>
	<br>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-4">
						<div class="row">
							<div class="col-md-3">

								<button type="button" id="excelImport" class="btn btn-success">Excel导入</button>
							</div>
							<div class="col-md-3">

								<button type="button" id="excelExport" class="btn btn-danger">Excel导出</button>
							</div>
						</div>
					</div>
					<div class="col-md-4"></div>
					<div class="col-md-4"></div>
				</div>
				<br>
				<table class="table table-bordered table-hover userTable">
					<thead>
						<!-- 表格标题 -->
						<tr>
							<th>用户编号</th>
							<th>用户名</th>
							<th>昵称</th>
							<th>性别</th>
							<th>手机号</th>
							<th>身份证</th>
							<th>邮箱</th>
							<th>出生年月</th>
							<th>公司名称</th>
						</tr>
					</thead>
					<!-- 表格内容 -->
					<tbody id="tableUserInfo">
					</tbody>
				</table>
				<!-- 分页插件 -->
				<div id="tablePaginator"></div>
				
			</div>
		</div>
	</div>



</body>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.12.4.min.js"></script>
<script src="/springmvc_mybatis/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="/springmvc_mybatis/bootstrap-3.3.7-dist/paginator/bootstrap-paginator.js"></script>
<script type="text/javascript" src="/springmvc_mybatis/js/user/userList.js"></script>
</html>