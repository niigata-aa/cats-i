<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.EmployeeBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員登録画面（確認画面）</title>
</head>
<body>

<p>※以下の内容で従業員情報を登録しますか？</p>
	
	<%request.setCharacterEncoding("utf-8"); %>
	
	<%
	String empID = (String)session.getAttribute("empID");
	String empPass = (String)session.getAttribute("empPass");
	String lastName = (String)session.getAttribute("lastName");
	String firstName = (String)session.getAttribute("firstName");
	String gender = (String)session.getAttribute("gender");
	int postID = (int)session.getAttribute("postID");
	int areaID = (int)session.getAttribute("areaID");
	String startWork = (String)session.getAttribute("startWork");
	String photo = (String)session.getAttribute("photo");
	
	%>
	
	
	
	従業員ID　:　<%=empID %><br>
	
	パスワード　:　<%=empPass %><br>
	
	
	名字　:　<%=lastName%><br>
	
	
	名前　:　<%=firstName %><br>
	
	性別　:　<%=gender%><br>
	
	業務種別　:　<%=postID %><br>
	
	
	エリアID　:　<%=areaID%><br>
	
	業務開始日　:　<%=startWork%><br>
	
	写真　:　<%=photo%><br>
	
	

	
	
	<form action="registKeeperCheck" method="post">
		<input type="submit" value="はい">
	</form>
	
	<form action="registKeeper.jsp" method="post">
		<input type="submit" value="いいえ">
	</form>

</body>
</html>