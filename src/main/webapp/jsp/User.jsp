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

	<!-- 	<button id="excelImport">����</button> -->
	<!-- 	<button id="excelExport">����</button> -->

	<br>
	<br>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-4">
						<div class="row">
							<div class="col-md-3">

								<button type="button" id="excelImport" class="btn btn-success">Excel����</button>
							</div>
							<div class="col-md-3">

								<button type="button" id="excelExport" class="btn btn-danger">Excel����</button>
							</div>
						</div>
					</div>
					<div class="col-md-4"></div>
					<div class="col-md-4"></div>
				</div>
				<br>
				<table class="table table-bordered table-hover userTable">
					<thead>
						<!-- ������ -->
						<tr>
							<th>�û����</th>
							<th>�û���</th>
							<th>�ǳ�</th>
							<th>�Ա�</th>
							<th>�ֻ���</th>
							<th>���֤</th>
							<th>����</th>
							<th>��������</th>
							<th>��˾����</th>
						</tr>
					</thead>
					<!-- ������� -->
					<tbody id="tableUserInfo">
					</tbody>
				</table>
				<!-- ��ҳ��� -->
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