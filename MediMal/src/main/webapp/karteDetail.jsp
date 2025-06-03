<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" 
	import="java.util.List,java.util.ArrayList,
			model.entity.AnimalBean,model.dao.AnimalDAO,
			model.entity.KarteBean,model.entity.Weight,
			model.entity.Birth,model.entity.Drug,
			model.entity.Feed,model.entity.MedicalExamBean,
			model.entity.AnimalComment,
			java.sql.SQLException,java.io.IOException"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カルテ詳細画面</title>
<link rel ="stylesheet" href="style/karteDetailStyle.css">
</head>
<body>

	<%@include file="headerLink.jsp" %>
	<h1>カルテ詳細画面</h1>
	基本情報
	
	<%
	
	KarteBean Karte = (KarteBean)session.getAttribute("KarteInfo");
	String idhead = (String) session.getAttribute("postID");
	if (idhead.equals("20")) {
	%>
	<form action="goUpdateAnimal" method="post">
		<input type="submit" value="動物情報編集・削除">
	</form>
	<%
	}
	%>
	<jsp:useBean id="animalrecode" class="model.entity.AnimalBean" scope="session"/>
	動物ID :<jsp:getProperty property="animalID" name="animalrecode"/><br>
	名前 :<jsp:getProperty property="name" name="animalrecode"/><br>
	生年月日 :<jsp:getProperty property="birthDay" name="animalrecode"/><br>
	性別 :<jsp:getProperty property="sex" name="animalrecode"/><br>
	種族 :<jsp:getProperty property="animalType" name="animalrecode"/><br>
	動物エリア :<jsp:getProperty property="area" name="animalrecode"/><br>
	在籍情報 :<jsp:getProperty property="livingNow" name="animalrecode"/><br>
	
	体重記録<br>
	<% if (Karte.getWeightLog()!=null){
		for (Weight weight:Karte.getWeightLog()){%>
		<%=weight.getInputTime() %>:<%=weight.getWeight()%><%=weight.getWeightUnit() %><br>
	<%} }else{%>
		記録が存在していません。<br>
	<%} %>
	
	
	食事記録<br>
	<% if (!Karte.getFeedLog().isEmpty()){
		for (Feed feed : Karte.getFeedLog()){%>
		日時:<%= feed.getFeedTime() %>  食事内容:<%=feed.getFeedContent()%><%=feed.getFeedAmount() %><%=feed.getFeedUnit() %><br>
	<%} }else{%>
		記録が存在していません。<br>
	<%} %>
	
	投薬履歴<br>
	<% if (Karte.getDrugLog().size()!=0){
		for (Drug drug : Karte.getDrugLog()) {%>
		日時:<%= drug.getDate() %>薬名:<%=drug.getMedicineName() %> 投薬量:<%= drug.getMedicineAmount() %>g<br>
	<% }}else{ %>
		記録が存在していません。<br>
	<%} %>
	
	
	
	
	
	所見<br>
	
	
	<% if (!Karte.getCommentLog().isEmpty()){
		for (AnimalComment comment : Karte.getCommentLog()) {%>
		日時:<%= comment.getCommentTime() %>記録者:<%=comment.getEmpID() %> 内容:<%= comment.getContent() %><br>
	<% }}else{ %>
		記録が存在していません。<br>
	<%} %>
	
	<form action="goInputWeight" method="post">
	<input type="submit" value="体重記録ボタン">
	</form>
	
	<form action="goInputFeed" method="post">
	<input type="submit" value="食事記録ボタン">
	</form>
	
	<form action="goInputComment" method="post">
	<input type="submit" value="コメント記入ボタン">
	</form>

	<form action="goInputKarte" method="post">
	<input type="submit" value="投薬・出産記録ボタン">
	</form>
</body>
</html>