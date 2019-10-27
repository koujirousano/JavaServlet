<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*"%>
<%
List<Member> list=(List<Member>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%if(list !=null && list.size()>0){ %>
<table border="1">
<tr><th>Name</th><th>Age</th></tr>
<%for(Member m:list){ %>
<tr><td><%=m.getName() %></td><td><%=m.getAge() %></td></tr>
<%} %>
</table>
<%} %>
</body>
</html>