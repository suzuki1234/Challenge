<%-- 
    Document   : ouyou
    Created on : 2016/12/06, 11:01:47
    Author     : suzuki
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<%  
    HttpSession hs = request.getSession(true);
    String[] info ;
    //初回は初期の初期値を入力
    if(hs.getAttribute("Login") == null){
        String[] test = {"田中","男","映画"};
        info = (String[])test.clone();
    }else{
        //初回以降は前回の内容を初期値とする
        info=(String[])hs.getAttribute("Login");
    }
    
%>
        <h1>応用課題</h1>
        
        
               <div>アンケートにご協力ください！</div>
        <form action="ouyou2.jsp" method="post">
        名前
        <br>
        <input type="text" name="txtName" <% out.print("value ="+info[0]); %>>
        
        <br><br>
        性別<br>
        男<input type="radio" name="gender" value="男" <%if(info[1].equals("男")){out.print("checked");}%> > 女<input type="radio" name="gender" value="女" <%if(info[1].equals("女")){out.print("checked");}%>>
  
        <br><br>
        
        趣味<br>
        <textarea name="syumi" cols="50" rows="10"><% out.print(info[2]);%></textarea>
        <input type="submit" value="送信"  >
        </form>
    </body>
</html>
