<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.Drug"import="model.entity.Birth"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>健康情報追加画面(確認画面)</title>
</head>
<body>
	
	<p>※以下の内容で体重を記録しますか？</p>
	
	<%request.setCharacterEncoding("utf-8"); %>
	<% Drug inputDrug = (Drug)request.getAttribute("inputDrug"); %>
	
	動物ID　:　
	<% session.getAttribute("animalID"); %><br>
	名　前　:　
	<% session.getAttribute("animalName"); %>
	診察時間:　
	
	【投薬内容】
	投薬時間:　
	<%=inputDrug.getDate() %>
	投薬量　:　
	<%=inputDrug.getMedicineAmount() %><br>
	薬の種類:
	<%=inputDrug.getMedicineName() %><br>
	
	【出産】
	出産日　:　
	<%=inputBirth.getDate() %><br>
	<%=inputBirth.getAmount() %>
	
	

	<form action="inputHealthCheck" method="post">
	<input type="submit" value="はい">
	</form>
	<form action="inputHealth" method="post">
	<input type="submit" value="いいえ">
	</form>
	
	
	
</body>
</html>