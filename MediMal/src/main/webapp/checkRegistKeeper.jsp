<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.EmployeeBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員登録画面（確認画面）</title>
</head>
<body>

<p>※以下の内容で従業員情報を登録しますか？</p>
	
	<%request.setCharacterEncoding("utf-8"); %>
	<%EmployeeBean employee = (EmployeeBean)request.getAttribute("employee");%>
	
	
	
	従業員ID　:　
	<%=employee.getEmpID() %>
	
	パスワード　:　
	
	
	名字　:　
	<% String lastName = request.getParameter("lastName"); %><br>
	
	名前　:　
	<% String firstName = request.getParameter("firstName"); %><br>
	
	性別　:　
	<% String gender = request.getParameter("gender"); %><br>
	
	業務種別　:　
	<% String postID = request.getParameter("postID"); %><br>
	
	エリアID　:　
	<% String areaID = request.getParameter("areaID"); %><br>
	
	業務開始日　:　
	<% String startWork = request.getParameter("startWork"); %><br>
	
	在籍情報　:　
	<% String livingNow = request.getParameter("livingNow"); %><br>
	
	写真　:　
	<% String photo = request.getParameter("photo"); %><br>
	
	

	
	
	<form action="registKeeperCheck" method="post">
		<input type="submit" value="はい">
	</form>
	
	<form action="registKeeper.jsp" method="post">
		<input type="submit" value="いいえ">
	</form>

</body>
</html>