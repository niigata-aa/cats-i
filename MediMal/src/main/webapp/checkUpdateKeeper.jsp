<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>飼育員情報編集確認画面1</title>
</head>
<body>
	<%@ include file="headerLink.jsp"%>
<p>※以下の内容で従業員情報を編集しますか？</p>
	
	<%request.setCharacterEncoding("utf-8"); %>
	
	<jsp:useBean id ="updateEmployee" scope = "session" class ="model.entity.EmployeeBean"/>
	
	<!-- 在籍情報は後でやります -->
	飼育員在籍情報 :
	<%if (Integer.parseInt((String)session.getAttribute("workingNow"))==1){ %>
	復職により従業員として再登録します。<br>
	<%}else{ %>
	離職中として登録します。<br>
	<%} %>
	従業員ID : <jsp:getProperty name = "updateEmployee" property = "empID"/>
	
	名前　:　<jsp:getProperty name = "updateEmployee" property = "lastName"/>
	
			 <jsp:getProperty name = "updateEmployee" property = "firstName"/><br>
	
	性別　:　<jsp:getProperty name = "updateEmployee" property = "gender"/>
	
	担当エリア　:　<jsp:getProperty name = "updateEmployee" property = "areaID"/>
	
	写真　: <img src="/MediMal/image/<jsp:getProperty name = "updateEmployee" property = "photoURL"/>" width="100" height="100">
	<br>
	
	<form action="updateKeeperCheck" method="post">
		<input type="submit" value="はい">
	</form>
	
	<form action="updateKeeper.jsp" method="post">
		<input type="submit" value="いいえ">
	</form>
	<%
		String returnURL = "checkUpdateKeeper.jsp";
		session.setAttribute("returnURL", returnURL);
	%>
</body>
</html>