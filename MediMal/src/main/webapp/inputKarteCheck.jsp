<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.Drug" import="model.entity.Birth"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>健康情報追加画面(確認画面)</title>
<link rel ="stylesheet" href="style/insertStyle.css">
</head>
<body>
<%@include file="headerLink.jsp" %>
	
	
	<div class="A">
	<h3>＜投薬・出産履歴記録＞</h3>
	<p>※以下の内容で投薬情報・出産情報を記録しますか？</p>
	<jsp:useBean id ="inputDrug" scope = "session" class ="model.entity.Drug"/>
	<jsp:useBean id ="inputBirth" scope = "session" class ="model.entity.Birth"/>
	
	　動物ID　:　
	<jsp:getProperty name = "inputDrug" property = "animalID"/><br>
	
	<%request.setCharacterEncoding("utf-8"); %>
	
	
	【投薬内容】<br>
	投薬時間　:　<jsp:getProperty name = "inputDrug" property = "date"/><br>
	
	
	薬の種類　:　<jsp:getProperty name = "inputDrug" property = "medicineName"/><br>
	
	　投薬量　:　<jsp:getProperty name = "inputDrug" property = "medicineAmount"/><br>
	
	
	

	【出産】<br>
	　出産日　:　<jsp:getProperty name = "inputBirth" property = "date"/><br>
	
	　投薬量　:　<jsp:getProperty name = "inputBirth" property = "amount"/><br>
	
	</div>
	

	<form action="inputHealthCheck" method="post">
	<input type="submit" value="はい" class="btn_left">
	</form>
	<form action="inputHealth" method="post">
	<input type="submit" value="いいえ" class="btn_right">
	</form>
	<%
		String returnURL = "inputKarteCheck.jsp";
		session.setAttribute("returnURL", returnURL);
	%>
	
	
</body>
</html>