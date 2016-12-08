<%-- 
    Document   : ouyou2
    Created on : 2016/12/06, 12:38:54
    Author     : suzuki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%request.setCharacterEncoding("UTF-8");%>
        <h1>入力結果</h1>
        名前:
        <%out.print(request.getParameter("txtName"));%>
        <br>
        性別:
        <%out.print(request.getParameter("gender"));%>
        <br>
        趣味:
        <%out.print(request.getParameter("syumi"));%>
        
        <%
        HttpSession hs = request.getSession(true);
        String[] info={request.getParameter("txtName"),request.getParameter("gender"),request.getParameter("syumi")};
        hs.setAttribute("Login", info);
        %>
        <br>
        <a href="index.jsp">戻る</a>
    </body>
</html>
