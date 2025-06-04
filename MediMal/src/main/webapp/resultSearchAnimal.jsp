<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,model.entity.AnimalBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>動物検索結果画面</title>
<link rel ="stylesheet" href="style/resultSearchStyle.css">
</head>
<body>
	<%@ include file="headerLink.jsp"%>
	<form action="goSearchAnimal" method="post">
		<input type="submit" value="再検索" class="btn">
	</form>

	<%
	request.setCharacterEncoding("UTF-8");
	List<AnimalBean> animalList = (List<AnimalBean>) session.getAttribute("animalList");
	System.out.println("すべての動物数は"+animalList.size()+"件です");
	%>
	
	
	<% if(animalList.size()!=0){ %>
	<div class="result">
	<table>
		<tr>
			<th>写真</th>
			<th>詳細情報</th>
			<th></th>
		</tr>
		<%
		for (AnimalBean animal : animalList) {
			
		%>
		<tr>
			<td><img src="/MediMal/image/<%=animal.getPhoto()%>" width="100" height="100"></td>

			<td><%=animal.getAnimalID()%> <%=animal.getName()%> <%=animal.getAnimalType()%>
				<%=animal.getArea()%> <!-- a担当動物個体の表示とそこから詳細カルテに飛ぶ方法が分かりません --> <!--  =employee.get() %>-->
				<%=animal.getBirthDay()%>
			</td>	
				
			<td>	
				<form action="goKarteDetail" method="post">
					<input type="hidden" name="animalID" value=<%=animal.getAnimalID()%>> 
					
					<input type="submit" value="詳細カルテへ">
				</form> 
				<%String idhead = (String) session.getAttribute("postID");%>
 				<%if (idhead.equals("20")) {%>
 				
 				
				
				 <%}%>
				 
				 </td>
		</tr>

		<%	
	}
	%>
	</table>
	</div>
	<%} else{%>
	検索結果がありませんでした。再度検索してください。<br>
	<%} %>
	<%
		String returnURL = "resultSearchAnimal.jsp";
		session.setAttribute("returnURL", returnURL);
	%>
</body>
</html>