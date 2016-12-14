<%-- 
    Document   : set
    Created on : 2016/12/13, 14:06:25
    Author     : suzuki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登録完了</title>
    </head>
    <body>
        <h1>登録完了しました。</h1>
        <br>
        
        <form action="./Szaiko" method="post">
            <input type="hidden" name="action" value="modoru">
            <input type="submit" value="戻る">
        </form>
    </body>
</html>
