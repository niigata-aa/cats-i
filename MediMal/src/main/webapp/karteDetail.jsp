<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" 
	import="java.util.List,java.util.ArrayList,
			model.entity.AnimalBean,model.dao.AnimalDAO,
			java.sql.SQLException,java.io.IOException"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カルテ詳細画面</title>
</head>
<body>

	<%@include file="headerLink.jsp" %>
	<h1>カルテ詳細画面</h1>
	基本情報
	
	<%
	String idhead = (String) session.getAttribute("postID");
	if (idhead.equals("20")) {
	%>
	<form action="goUpdateAnimal" method="post">
		<input type="submit" value="動物情報編集・削除">
	</form>
	<%
	}
	%>
	
	<%
		request.setCharacterEncoding("UTF-8");
		String animalID = request.getParameter("animalID");
		String postID = (String) session.getAttribute("postID");
		
		//DAOの生成
		AnimalDAO dao = new AnimalDAO(postID);
		try{
		//DAOの利用
			List<AnimalBean> animalList = new ArrayList<AnimalBean>();
			animalList = dao.selectAllAnimal();
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if(animalList.getAnimalID)
	%>
	
	<form action="goInputWeight" method="post">
	<input type="submit" value="体重記録ボタン">
	</form>
	
	<form action="goInputFeed" method="post">
	<input type="submit" value="食事記録ボタン">
	</form>
	
	<form action="goInputComment" method="post">
	<input type="submit" value="コメント記入ボタン">
	</form>
	
<!--	<form action="goInputKarte" method="post">-->
<!--	<input type="submit" value="カルテ情報(投薬・出産)記録ボタン">-->
<!--	</form>-->

	<form action="goInputFeed" method="post">
	<input type="submit" value="記録食事記録ボタン">
	</form>
</body>
</html>