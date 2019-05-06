<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<body>
<title>Login Success Page</title>
</head>
<body>
<%
String message = null;
String sessionID = null;
Cookie[] cookies = request.getCookies();
if(cookies != null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("message")) message = cookie.getValue();
	if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
}
}
%>
<h3>Login Success</h3>
<h4><%=message%></h4>
<h4>Session ID = <%=sessionID %></h4>
<br><br>
<form action="LogoutServlet" method="post">
<input type="submit" value="Logout" >
</form>
</body>
</html>
