<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>動物登録確認画面</title>
</head>
<body>
	<p>※以下の内容で従業員情報を登録しますか？</p>

	<%request.setCharacterEncoding("utf-8"); %>
	
	
	<%
	String animalID = (String)session.getAttribute("animalID");
	String name = (String)session.getAttribute("name");
	String type = (String)session.getAttribute("type");
	String area = (String)session.getAttribute("area");
	String birthDay = (String)session.getAttribute("birthDay");
	String countryOfBirth = (String)session.getAttribute("countryOfBirth");
	String sex = (String)session.getAttribute("sex");
	List<String> keepers = List<String>session.getAttribute("keepers");
	String photo = (String)session.getAttribute("photo");
	
	%>
	
	動物ID　:　<%=animalID %><br>
	
	名前　:　<%=name %><br>
	
	種族　:　<%=type%><br>
	
	所属エリア　:　<%=area %><br>
	
	誕生日　:　<%=birthDay%><br>
	
	出身　:　<%=countryOfBirth%><br>
	
	性別　:　<%=sex%><br>
	
	担当飼育員　:　<%=keepers%><br>
	
	写真　:　<%=photo%><br>
	
	
	<form action="registKeeperCheck" method="post">
		<input type="submit" value="はい">
	</form>
	
	<form action="registKeeper.jsp" method="post">
		<input type="submit" value="いいえ">
	</form>
	
</body>
</html>