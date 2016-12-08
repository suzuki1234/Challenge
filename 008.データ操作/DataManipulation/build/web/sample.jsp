<%-- 
    Document   : sample
    Created on : 2016/12/05, 14:30:04
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
        <h1>送られてきたデータの処理</h1>
        <%
        // 受け取るパラメータの文字コード
        request.setCharacterEncoding("UTF-8");
        %>
        名前は
        <%
        String a = request.getParameter("txtName");
        out.print(a);
        %>
        <br>
        性別は
        <%
        String b = request.getParameter("gender");
        out.print(b);
        %>
        <br>
        趣味は
        <%
        String c = request.getParameter("syumi");
        out.print(c);
        %>
        <br>
        <a href="index.jsp">戻る</a>
    </body>
</html>
