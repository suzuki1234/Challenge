<%-- 
    Document   : review1
    Created on : 2016/12/09, 11:53:31
    Author     : suzuki
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>データ送信</h1>
        <%
        //<!--DB現在情報を表示-->
        Connection db_con = null;
        PreparedStatement db_st =null;
        ResultSet db_data = null;
        
        try{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","suzuki","minorin");
        
        
        db_st = db_con.prepareStatement("select * from profiles");               
        db_data = db_st.executeQuery(); //検索系で利用
        
        %>
        
        <h3>現在のデータ</h3>
        <Table Border="1" Bordercolor="#0F0" Cellspacing="0">
            <Tr>
            <Td>ID</Td><Td>名前</Td><Td>電話番号</Td><Td>年齢</Td><Td>誕生日</Td> </Tr>
            
        <%
        while(db_data.next()){
            out.print("<Tr>");
            out.print("<Td>");
            out.print(db_data.getString("profilesID"));
            out.print("</Td><Td>");
            out.print(db_data.getString("name"));
            out.print("</Td><Td>");
            out.print(db_data.getString("tell"));
            out.print("</Td><Td>");
            out.print(db_data.getString("age"));
            out.print("</Td><Td>");
            out.print(db_data.getString("birthday"));
            out.print("</Td>");
            out.print("</Tr>");
        }
        
        //データベースをクローズする。
        db_con.close();
        
        }catch (SQLException ex) {
            out.println("sqlエラー");
        }finally{
            if(db_con != null){
                try {
                    db_con.close();
                } catch (SQLException ex) {
                    out.println("エラー");
                    
                }
            }
        }
        %>

            </Table>
        
        <br>
        <br>
        <br>
        <br>
        <h3>上書きフォーム</h3>
        <form action="./kadai11" method="post">
            <Table Border="1" Bordercolor="#F00" Cellspacing="0">
            <Tr>
                <Td>ID</Td>       <Td><input type="text" name="txtId" value=""></Td> </Tr>
            <Tr>
                <Td>名前</Td>       <Td><input type="text" name="txtName" value="野村"></Td> </Tr>
            <Tr>
            <Td>電話番号</Td>   <Td><input type="text" name="txtTell" value="0123-123-456"></Td> </Tr>
            <Tr>
            <Td>年齢</Td>       <Td><input type="text" name="txtAge" value="22"></Td> </Tr>
            <Tr>
            <Td>誕生日</Td>     <Td><input type="text" name="txtBirthday" value="1979-9-8"></Td> </Tr>
            </Table>
            <input type="submit" value="上書き">
        </form>
        

    </body>
</html>
