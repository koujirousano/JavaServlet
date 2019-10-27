<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
<%
Siri siri=(Siri)session.getAttribute("siri");
String errorMsg=(String)request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>しりとりゲーム</title>
</head>
<body>
<h1>しりとりゲーム</h1>
<%=siri.getAfter() %>
<%if(siri.isOk()){ %>
<form action="/siri2/Main" method="post">
<input type="text" name="after">
<input type="submit" value="送信">
</form>
<%} %>
<%if (errorMsg != null){ %>
<p><%=errorMsg %></p>
<%}else{ %>
	<p><%=siri.getMsg() %></p>
	<%if(!siri.isOk()){ %>
	<p><a href="/siri2/Main">最初に戻る</a></p>
	<%} %>
<%} %>
</body>
</html>