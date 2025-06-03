<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員編集画面(完了画面)</title>
</head>
<body>
	<%@ include file="headerLink.jsp"%>
	従業員情報の編集が完了しました。
	<form action="SearchKeeper" method="post" >
	<input type="submit" value="従業員検索画面へ">
	</form>
	<%
		String returnURL = "doneUpdateKeeper.jsp";
		session.setAttribute("returnURL", returnURL);
	%>
</body>
</html>