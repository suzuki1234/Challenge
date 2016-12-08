<%-- 
    Document   : cookie
    Created on : 2016/12/06, 10:35:59
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
        <h1>クッキー</h1>
        <%
    // ユーザーの１回目の訪問
    Date time = new Date();
    Cookie c = new Cookie("LastLogin", time.toString());
    response.addCookie(c);


    // 次の訪問で。。。
    Cookie cs[] = request.getCookies();
    if (cs != null) {
        for (int i=0; i<cs.length; i++) {
            if (cs[i].getName().equals("LastLogin")) {
                out.print("最後のログインは、"+cs[i].getValue());
                out.print("<br>");
                break;
            }
        }
    }
    

    // すべてのクッキーを得る
    if (cs != null) {
                out.print("すべてのクッキーを表示");
                out.print("<br>");
        for (int i=0; i<cs.length; i++) {
                out.print(i*1+1 + "番目"+cs[i].getValue());
                out.print("<br>");
            
        }
    }


    %>
    <br>
    <a href="index.jsp">戻る</a>
    </body>
</html>
