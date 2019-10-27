<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*" trimDirectiveWhitespaces="true"%>
<%
Jyanken jk=(Jyanken)session.getAttribute("jk");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ジャンケンゲーム</title>
</head>
<body>
<h1>ジャンケンゲーム！</h1>
<form action="/jyankenapp/Main" method="post">
<label><input type="radio" name="handNo" value="0" <%=jk!=null && jk.getUserHand().equals("グー")? "checked":"" %>>グー</label>
<label><input type="radio" name="handNo" value="1" <%=jk!=null && jk.getUserHand().equals("チョキ")? "checked":"" %>>チョキ</label>
<label><input type="radio" name="handNo" value="2" <%=jk!=null && jk.getUserHand().equals("パー")? "checked":"" %>>パー</label>
<input type="submit" value="送信">
</form>
<%if (jk != null){%>
<p>あなたは<%=jk.getUserHand() %></p>
<p>PCは<%=jk.getPcHand() %></p>
<p><%=jk.getResult() %></p>
<p>Win:<%=jk.getWin() %></p>
<p>Lose:<%=jk.getLose() %></p>
<a href="/jyankenapp/Main?mode=reset">カウントをリセットする</a>
<% }%>
</body>
</html>