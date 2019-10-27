<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
<%
Siri siri=(Siri)request.getAttribute("siri");
String before=siri==null? "ごりら":siri.getAfter();
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
<%=before %>
<%if(siri==null || !siri.getMsg().contains("NG")){ %>
<form action="/siri/Main" method="post">
<input type="text" name="after">
<input type="hidden" name="before" value="<%=before%>">
<input type="submit" value="送信">
</form>
<%} %>
<%if (errorMsg != null){ %>
<p><%=errorMsg %></p>
<%} %>
<p><%=siri==null?"":siri.getMsg() %></p>
<%if(siri !=null &&siri.getMsg().contains("NG")){ %>
<p><a href="/siri/Main">最初に戻る</a></p>
<%} %>
</body>
</html>