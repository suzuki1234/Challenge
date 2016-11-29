<%@ page import="java.util.HashMap" %>

<%
    HashMap<String, String> hMap = new HashMap<String, String>();


    hMap.put("1", "AAA");
    hMap.put("hello", "world");
    hMap.put("soneda", "33");
    hMap.put("20", "20");


    out.println(hMap.get("hello"));

%>

