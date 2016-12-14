<%-- 
    Document   : view
    Created on : 2016/12/13, 12:47:28
    Author     : suzuki
--%>

<%@page import="jdbc.ProductClass"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>一覧表示</title>
    </head>
    <body>
        <h1>一覧表示画面</h1>
        <%
        ProductClass[] pc =(ProductClass[])request.getAttribute("productdata");
        
        
        out.print("name price amount <br>");
        int i=0;
        while(pc[i].getName()!=null){
            out.print(pc[i].getName());
            out.print("  ");
            out.print(pc[i].getPrice());
            out.print("  ");
            out.print(pc[i].getAmount());
            out.print("<br>");
            i++;
        }
        %>
        
        <form action="./Szaiko" method="post">
            <input type="hidden" name="action" value="modoru">
            <input type="submit" value="戻る">
        </form>
    </body>
</html>
