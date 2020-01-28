<%@page import="com.naver.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
${not empty login ? login.name : ""}
${not empty login ? " 님, 환영합니다.<a href = 'logout.do'>로그 아웃</a>" : "<a href='loginui.do'>로그인</a>"}<br>




 <%--  <%
      Object obj = session.getAttribute("login");
	
      MemberDTO login = null;
       
      if(obj != null){
	  
         login = (MemberDTO)obj;                  
         out.print(login.getName());
         out.print(" 님, 환영합니다.");
         out.print("<a href='logout.do'>로그아웃</a>");
      }else{
         out.print("<a href='loginui.do'>로그인</a>");
      }
   %> --%>
   
   <h1>회원목록</h1>
   <%
   List<MemberDTO> list = (List)request.getAttribute("list");
   
   for (int i=0; i < list.size(); i++){
      MemberDTO dto = list.get(i);
      /* String id = dto.getId();
      String name = dto.getName();
      int age = dto.getAge();
      
      out.print(id);
      out.print(name);
      out.print(age);
      out.print("<br>"); */
      
      out.print(dto.getId());
      out.print(":");
      out.print("<a href='read.do?id="+dto.getId()+"'>");
      out.print(dto.getName());
      out.print("</a>");
      out.print("<br>");
         
   }
   
   %>
   
<%--    <a href="read.do?id=${list.get(0).id }">name</a> --%>
</body>
</html>