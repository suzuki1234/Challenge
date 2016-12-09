<%-- 
    Document   : jdbcjsp
    Created on : 2016/12/08, 11:03:08
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
        <h1>検索フォーム</h1>
        <br>
        <form action="./kadai8_2" method="post">
        名前:<input type="text" name="txtName">
        <input type="submit" value="送信">
        </form>
    </body>
</html>
