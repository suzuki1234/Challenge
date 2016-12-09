<%-- 
    Document   : review1
    Created on : 2016/12/09, 11:53:31
    Author     : suzuki
--%>


<%@page import="jdbc.SendClass"%>
<%
    SendClass[] sc = (SendClass[])request.getAttribute("senddata");
//    SendClass sc = (SendClass)request.getAttribute("senddata");
    
    

    

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
            int i=0;
            while(sc[i].getName() != null){
                 out.print("<Tr>");
                out.print("<Td>");
                    out.print(sc[i].getId());
                out.print("</Td><Td>");
                    out.print(sc[i].getName());
                out.print("</Td><Td>");
                    out.print(sc[i].getTell());
                out.print("</Td><Td>");
                    out.print(sc[i].getAge());
                out.print("</Td><Td>");
                    out.print(sc[i].getBirthday());
                out.print("</Td>");
                out.print("</Tr>");
                i++;
            }
        %>
        
            </Table>
        <a href="kadai12_1.jsp">戻る</a>
    </body>
</html>
