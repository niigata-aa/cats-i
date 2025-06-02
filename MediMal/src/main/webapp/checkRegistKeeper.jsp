<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.EmployeeBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員登録画面（確認画面）</title>
</head>
<body>
	<%@ include file="headerLink.jsp"%>
<p>※以下の内容で従業員情報を登録しますか？</p>
	
	<%request.setCharacterEncoding("utf-8"); %>
	
	<jsp:useBean id ="inputEmployee" scope = "session" class ="model.entity.EmployeeBean"/>
	
	
	
	従業員ID : <jsp:getProperty name = "inputEmployee" property = "empID"/><br>
	
	パスワード　:　<jsp:getProperty name = "inputEmployee" property = "empPass"/><br>
	
	
	名字　:　<jsp:getProperty name = "inputEmployee" property = "lastName"/><br>
	
	
	名前　:　<jsp:getProperty name = "inputEmployee" property = "firstName"/><br>
	
	性別　:　<jsp:getProperty name = "inputEmployee" property = "gender"/><br>
	
	業務種別　:　<jsp:getProperty name = "inputEmployee" property = "postID"/><br>
	
	
	エリアID　:　<jsp:getProperty name = "inputEmployee" property = "areaID"/><br>
	
	業務開始日　:　<jsp:getProperty name = "inputEmployee" property = "startWork"/><br>
	
	写真　:　<jsp:getProperty name = "inputEmployee" property = "photoURL"/><br>
	
	
	
	
	
	<form action="registKeeperCheck" method="post">
		<input type="submit" value="はい">
	</form>
	
	<form action="registKeeper.jsp" method="post">
		<input type="submit" value="いいえ">
	</form>
	<%
		String returnURL = "checkRegistKeeper.jsp";
		session.setAttribute("returnURL", returnURL);
	%>
</body>
</html>