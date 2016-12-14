<%-- 
    Document   : home
    Created on : 2016/12/13, 10:12:15
    Author     : suzuki
--%>

<%@page import="jdbc.UserClass"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>        
        <h1>ホーム画面</h1>
        <%
        HttpSession s = request.getSession();
        UserClass u = (UserClass)s.getAttribute("user");
        
        out.print(u.getName() + "さん　ログイン中");
        
        %>
        <h3>行動を選択してください。</h3>
        <form action="./Szaiko" method="post">
            商品登録<br>
            名前<input type="text" name="name" value="">
            値段<input type="text" name="price" value="">
            個数<input type="text" name="kazu" value="">
            <input type="hidden" name="action" value="set">
            <input type="submit" value="登録">
        </form><br>
        <form action="./Szaiko" method="post">
            一覧表示<br>
            <input type="hidden" name="action" value="view">
            <input type="submit" value="一覧表示">
        </form><br>
        <form action="./Szaiko" method="post">
            ログアウト<br>
            <input type="hidden" name="action" value="logout">
            <input type="submit" value="ログアウト">
        </form>
    </body>
</html>
