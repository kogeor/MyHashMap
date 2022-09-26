<%@ page import="org.gk.MyHashMap" %>
<%@ page import="java.io.PrintWriter" %>
Created by IntelliJ IDEA.
  User: Kogeor
  Date: 26-Sep-22
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Keys-Values</title>
</head>

<body>

<div>
  <div>

    <%
      MyHashMap myHashMap = MyHashMap.getInstance();
      PrintWriter output = response.getWriter();
        output.println("<ui>");
        for ( Object key : myHashMap.keySet()) {
          output.println("<li>" + key +" test "+ myHashMap.get(key)+"</li>");
        }
        output.println("</ui>");
    %>
  </div>
</div>

<div>
  <button onclick="location.href='/'">Return</button>
</div>
</body>
</html>