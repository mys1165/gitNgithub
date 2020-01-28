<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>
<%
application.setAttribute("a", "a1");
session.setAttribute("s", "s1");
request.setAttribute("r", "r1"); 
pageContext.setAttribute("p", "p1"); //해당페이지에서만 값을 갖고있다.
%>

${a}<br>
${s}<br>
${r}<br>
${p}

<jsp:forward page="b.jsp"/>


</body>
</html>