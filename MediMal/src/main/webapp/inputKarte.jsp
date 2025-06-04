<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>健康情報追加画面</title>
<link rel ="stylesheet" href="style/insertStyle.css">
</head>
<body>
<%@include file="headerLink.jsp" %>
	
	<%-- 動物ID　:　
	<% session.getAttribute("animalID"); %>
	名　前　:　
	<% session.getAttribute("animalName"); %>
	<br>--%>
	
	
	<form action="inputHealth" method="post">
	
	<div class="A">

	<h3>＜投薬・出産履歴記録＞</h3>
	
	
	
	　　動物ID　:　
	<% session.getAttribute("animalID"); %>
	
	</div>
	
	<br>
	
	<br>
	<div class="karte">
	<div class="drug">
	【投薬内容】<br>
	　投薬時間　:　
	<input type="datetime-local" name="date" class="textbox_time"><br>
	　薬の種類　:　
	<input type="text" name="medicineName" class="textbox"><br>
	　　投薬量　:　
	<input type="number" name="medicineAmount" min="0" class="textbox"
	pattern="[0-9]+" placeholder="数字で入力してください" > g 
	</div>
	
	<div class="birth">
	【出産】<br>
	　　出産日　:　
	<input type="date" name="date" class="textbox_time"><br>
	　　出産数　:　
	<select name="amount"  class="textbox_unit">
		<option value="0">0
		<option value="1">1
		<option value="2">2
		<option value="3">3
		<option value="4">4
		<option value="5">5
	</select>
	<br>
	</div>
	</div>

	
	<input type="submit" value="登録" class="btn_karte">
	
	
	
	</form>
	
	<br>
	<form action="goKarteDetail" method="post">
		<input type="submit" value="キャンセル" class="btn">
	</form>
	<%
		String returnURL = "inputKarte.jsp";
		session.setAttribute("returnURL", returnURL);
	%>
	
</body>
</html>