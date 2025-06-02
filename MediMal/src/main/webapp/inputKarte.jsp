<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>健康情報追加画面</title>
</head>
<body>
<%@include file="headerLink.jsp" %>
	
	<%-- 動物ID　:　
	<% session.getAttribute("animalID"); %>
	名　前　:　
	<% session.getAttribute("animalName"); %>
	<br>--%>
	
	
	<form action="inputHealth" method="post">
	動物ID　:　
	<input type="text" name="animalID">
	
	
	
	<br>
	
	<br>
	【投薬内容】<br>
	投薬時間　:　
	<input type="datetime-local" name="date"><br>
	薬の種類　:　
	<input type="text" name="medicineName"><br>
	投　薬　量:　
	<input type="number" name="medicineAmount">g<br>
	
	【出産】<br>
	出　産　日:　
	<input type="date" name="date"><br>
	出　産　数:　
	<select name="amount">
		<option value="1">1
		<option value="2">2
		<option value="3">3
		<option value="4">4
		<option value="5">5
	</select>
	<br>
	
	<input type="submit" value="登録">
	
	</form>
	
	
</body>
</html>