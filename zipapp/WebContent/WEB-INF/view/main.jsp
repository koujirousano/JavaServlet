<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.*"%>
<%
String zipcode=(String)request.getAttribute("zipcode");
zipcode=zipcode==null?"":zipcode;
List<Address> list=(List<Address>)request.getAttribute("list");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/zipapp/Main" method="post">
zipcode<input type="text" name="zipcode" value="<%=zipcode%>">
<button type="submit">送信</button>
</form>
<%if (list != null && list.size()>0){ %>
<% for (Address add:list){ %>
<table border="1">
<tr><td><%=add.getAddress1()%></td></tr>
<tr><td><%=add.getAddress2()%></td></tr>
<tr><td><%=add.getAddress3()%></td></tr>
</table>
<br>
<%} %>
<%} %>
</body>
</html>