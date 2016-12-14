<%-- 
    Document   : setmiss
    Created on : 2016/12/13, 15:14:24
    Author     : suzuki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登録失敗</title>
    </head>
    <body>
        <h3>入力に不備があります。</h3>
        お手数ですが再度入力してください。
        <br>
        <form action="./Szaiko" method="post">
            <input type="hidden" name="action" value="modoru">
            <input type="submit" value="戻る">
        </form>
    </body>
</html>
