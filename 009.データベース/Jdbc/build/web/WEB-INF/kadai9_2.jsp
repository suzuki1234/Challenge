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
        <Table Border="1" Bordercolor="#0F0" Cellspacing="0">
            <Tr>
            <Td>ID</Td><Td>名前</Td><Td>電話番号</Td><Td>年齢</Td><Td>誕生日</Td> </Tr>
        <% 
            if(sc!=null){
             out.print("<Tr>");
            out.print("<Td>");
                out.print(sc.getId());
            out.print("</Td><Td>");
                out.print(sc.getName());
            out.print("</Td><Td>");
                out.print(sc.getTell());
            out.print("</Td><Td>");
                out.print(sc.getAge());
            out.print("</Td><Td>");
                out.print(sc.getBirthday());
            out.print("</Td>");
            out.print("</Tr>");
            out.print("</Table>");
            }else{
                out.print("入力ミスです。");
            }
        %>
        
        <a href="kadai9_1.jsp">戻る</a>
    </body>
</html>
