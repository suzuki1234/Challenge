<%-- 
    Document   : session
    Created on : 2016/12/06, 10:45:20
    Author     : suzuki
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Session!</h1>
        
        <%
            // ユーザーの１回目の訪問
    Date time = new Date();
    HttpSession hs = request.getSession(true);
    
    if(hs.getAttribute("LastLogin") == null){
        out.print("初回です。");
        out.print("<br>");
    }else{
        out.print("最後のログインは、"+hs.getAttribute("LastLogin"));  
    }
    
    hs.setAttribute("LastLogin", time.toString());
        %>
        <br >
        <a href="index.jsp">戻る</a>
    </body>
</html>
