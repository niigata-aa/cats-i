<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員登録画面（完了画面）</title>
</head>
<body>
	<%@ include file="headerLink.jsp"%>
	従業員の登録が完了しました。
	<%
		String returnURL = "doneRegistKeeper.jsp";
		session.setAttribute("returnURL", returnURL);
	%>
</body>
</html>