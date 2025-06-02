<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.Drug"import="model.entity.Birth"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>健康情報追加画面(確認画面)</title>
</head>
<body>
<%@include file="header.jsp" %>
	
	<p>※以下の内容で投薬情報・出産情報を記録しますか？</p>
	
	
	
	<%request.setCharacterEncoding("utf-8"); %>
	
	<jsp:useBean id ="inputDrug" scope = "session" class ="model.entity.Drug"/>
	【投薬内容】
	投薬時間　:　<jsp:getProperty name = "inputDrug" property = "date"/><br>
	
	
	薬の種類　:　<jsp:getProperty name = "inputDrug" property = "medicineName"/><br>
	
	投　薬　量:　<jsp:getProperty name = "inputDrug" property = "medicineAmount"/><br>
	
	
	
	<jsp:useBean id ="inputBirth" scope = "session" class ="model.entity.Birth"/>
	【出産】
	出産日　:　<jsp:getProperty name = "inputBirth" property = "date2"/><br>
	
	投　薬　量:　<jsp:getProperty name = "inputBirth" property = "amount"/><br>
	
	
	

	<form action="inputHealthCheck" method="post">
	<input type="submit" value="はい">
	</form>
	<form action="inputHealth" method="post">
	<input type="submit" value="いいえ">
	</form>
	
	
	
</body>
</html>