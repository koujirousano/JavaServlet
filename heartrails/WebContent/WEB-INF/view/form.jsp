<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%
List<String> list=(List<String>)request.getAttribute("list");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/heartrails/Main" method="post">
<select name="rail">
<%for(String s:list){ %>
<option value="<%=s %>"><%=s %></option>
<%} %>

</select>
<button type="submit">送信</button>
</form>


</select>
</body>
</html>