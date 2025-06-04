<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>飼育員情報編集確認画面2</title>
<link rel ="stylesheet" href="style/insertStyle.css">
</head>
<body>
<%@ include file="headerLink.jsp"%>
<p>※【最終確認】以下の内容で従業員情報を編集しますか？</p>
	
	<%request.setCharacterEncoding("utf-8"); %>
	
	<jsp:useBean id ="updateEmployee" scope = "session" class ="model.entity.EmployeeBean"/>
	
	<!-- 在籍情報は後でやります -->
	
	
	従業員ID : <jsp:getProperty name = "updateEmployee" property = "empID"/>
	
	名前　:　<jsp:getProperty name = "updateEmployee" property = "lastName"/>
			 <jsp:getProperty name = "updateEmployee" property = "firstName"/><br>
	
	性別　:　<jsp:getProperty name = "updateEmployee" property = "gender"/>
	
	担当エリア　:　<jsp:getProperty name = "updateEmployee" property = "areaID"/>
	
	写真　:　<img src="/MediMal/image/<jsp:getProperty name = "updateEmployee" property = "photoURL"/>" width="100" height="100"><br>
	
	<form action="FinalUpdateKeeperCheck" method="post" >
		<input type="submit" value="はい" class="btn_left">
	</form>
	
	<form action="checkUpdateKeeper.jsp" method="post">
		<input type="submit" value="いいえ" class="btn_left">
	</form>
</body>

</body>
</html>