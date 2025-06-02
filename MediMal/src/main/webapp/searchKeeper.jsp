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
		飼育員ID :
		<input type="text" name="empID" placeholder="キーワードを入力" class="Keeper" ><br>
		性 :
		<input type="text" name="keeperLastName" placeholder="キーワードを入力" class="Keeper"><br>
		名 :
		<input type="text" name="keeperFirstName" placeholder="キーワードを入力"class="Keeper" ><br>
		担当エリア :
		<select name="areaName" class="Keeper">
			<% for (int i = 0 ; i<allArea.size();i ++){ %>
			<option value = <%= i %>> <%=allArea.get(i) %> </option> 
			<%} %>
		</select><br>
		担当動物種族 :
		<input type="text" name="animalType" placeholder="キーワードを入力" class="Keeper"></div>
		<input type="submit" value="検索" class="KS">
	</form>	
</body>
</html>