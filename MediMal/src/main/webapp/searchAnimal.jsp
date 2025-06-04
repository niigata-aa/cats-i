<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>動物検索画面</title>
<link rel ="stylesheet" href="style/searchAnimalStyle.css">
</head>
<body>
	<%@ include file="headerLink.jsp"%>
	
	<%List<String> allArea = (List<String>)session.getAttribute("area");  %>
	
	<h1>動物検索画面</h1>

	<form action="searchAllAnimal" method="post">
		<input type="submit" value="動物一覧表示" class="btn">
	</form>
	
	<div class="A"><form action="searchAnimal" method="post">
	<div class="test-con">
	<table style="margin-left :auto; margin-right: auto;">
	
		<tr align="right"><td>名前 :</td>
		<td><input type="text" name="animalName"placeholder="キーワードを入力" class="Animal"></td></tr>
		<tr align="right"><td>種族 :</td>
		<td><input type="text" name="typeName"placeholder="キーワードを入力" class="Animal"></td></tr>
		<tr align="right"><td>所属エリア :</td>
		<td><select name="areaName" class="Animal">
			<% for (String area:allArea){ %>
			<option value = <%= area %> > <%=area %> </option> 
			<%} %></select></td>
		</tr>
		</table></div>
		<!--  
		担当飼育員 :
		<input type="text" name="keeperName">キーワードを入力してください
		-->
		
		<input type="submit" value="検索" class="AS">
	</form>	</div>
	<%
		String returnURL = "searchAnimal.jsp";
		session.setAttribute("returnURL", returnURL);
	%>
</body>
</html>