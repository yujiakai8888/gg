<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
 <%
 request.setCharacterEncoding("utf-8");
 String s;	
 ServletContext context=this.getServletContext();
 s=(String)context.getAttribute("url");
 		
 %>
 
 <a href="<%=s%>">进入网站</a>
</body>
</html>