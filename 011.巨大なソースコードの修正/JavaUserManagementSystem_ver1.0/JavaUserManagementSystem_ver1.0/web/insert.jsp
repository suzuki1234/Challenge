<%@page import="jums.UserDataBeans"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%
    HttpSession hs = request.getSession();
    //UDBをセッションから取得し、存在したら格納、存在しないなら何もしないか
    //生年月日の"----"を入力
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("UDB");
    String n="",y="",m="",d="",t="",tel="",c="";
    if(udb!=null && udb.getName()!=""){n=udb.getName();}
    if(udb!=null && udb.getYear()!=""){y=udb.getYear();}else{y="----";}
    if(udb!=null && udb.getMonth()!=""){m=udb.getMonth();}else{m="--";}
    if(udb!=null && udb.getDay()!=""){d=udb.getDay();}else{d="--";}
    if(udb!=null && udb.getType()!=""){t=udb.getType();}else{t="1";}
    if(udb!=null && udb.getTell()!=""){tel=udb.getTell();}
    if(udb!=null && udb.getComment()!=""){c=udb.getComment();}
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>
    <form action="insertconfirm" method="POST">
        名前:
        <input type="text" name="name" value="<%=n%>">
        <br><br>

        生年月日:　
        <select name="year">
            <option value="<%=y%>"><%=y%></option>
            <%
            for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>"> <%=i%> </option>
            <% } %>
        </select>年
        <select name="month">
            <option value="<%=m%>"><%=m%></option>
            <%
            for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
        </select>月
        <select name="day">
            <option value="<%=d%>"><%=d%></option>
            <%
            for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
        </select>日
        <br><br>

        種別:
        <br>
        <input type="radio" name="type" value="1" <%if(t.equals("1")){out.print("checked");}%>>エンジニア<br>
        <input type="radio" name="type" value="2" <%if(t.equals("2")){out.print("checked");}%>>営業<br>
        <input type="radio" name="type" value="3" <%if(t.equals("3")){out.print("checked");}%>>その他<br>
        <br>

        電話番号:
        <input type="text" name="tell" value="<%=tel%>">
        <br><br>

        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%=c%></textarea><br><br>
        
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
