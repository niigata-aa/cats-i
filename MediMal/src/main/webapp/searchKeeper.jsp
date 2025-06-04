<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>飼育員検索画面</title>
<link rel ="stylesheet" href="style/seaechKeeperStyle.css">
</head>
<body>
	<%@ include file="headerLink.jsp"%>
	
	
	<%List<String> allArea = (List<String>)session.getAttribute("area");  %>
	
	<h1>飼育員検索画面</h1>
	
	<form action="searchAllKeeper" method="post">
		<input type="submit" value="一覧表示" class="button">
	</form>
	
	<div class="K"><form action="SearchKeeper" method="post">
	<div class="test-cont">
	<table style="margin-left :auto; margin-right: auto;">
	
		
		<tr align="right"><td>性 :</td>
		<td><input type="text" name="keeperLastName" placeholder="キーワードを入力" class="Keeper"></td></tr>
		<tr align="right"><td>名 :</td>
		<td><input type="text" name="keeperFirstName" placeholder="キーワードを入力"class="Keeper" ></td></tr>
		<tr align="right"><td>担当エリア :</td>
		<td align="left"><select name="areaName" class="Keeper">
			<option value ="">選択してください
			<% for (String area:allArea){ %>
			<option value = <%= area %>> <%=area %> </option> 
			<%} %></td>
		</select><br>
		<tr align="right"><td>担当動物種族 :</td>
		<td><input type="text" name="animalType" placeholder="キーワードを入力" class="Keeper"></td></tr></table></div>
		<input type="submit" value="検索" class="KS">
	</form>	
	<%
		String returnURL = "searchKeeper.jsp";
		session.setAttribute("returnURL", returnURL);
	%>
</body>
</html>