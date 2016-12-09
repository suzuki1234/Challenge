<%-- 
    Document   : review1
    Created on : 2016/12/09, 11:53:31
    Author     : suzuki
--%>


<%@page import="jdbc.SendClass"%>
<%
    SendClass sc = (SendClass)request.getAttribute("senddata");
    
    

    

%>




<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>データ送信結果</h1>

        <% 
            if(sc!=null){
                out.print("ID="+sc.getId()+"のデータは削除されました。");
            }
        %>
        
        <a href="kadai10_1.jsp">戻る</a>
    </body>
</html>
