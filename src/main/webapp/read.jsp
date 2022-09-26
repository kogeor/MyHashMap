<%@ page import="org.gk.MyHashMap" %><%--
  Created by IntelliJ IDEA.
  User: Kogeor
  Date: 26-Sep-22
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Users</title>
</head>

<body>
<div>
  <h1>Super app!</h1>
</div>

<div>
  <div>
    <div>
      <h2>Users</h2>
    </div>
    <%
      MyHashMap myHashMap = MyHashMap.getInstance();
        System.out.println("<ui>");
        for (var s : myHashMap.entrySet()) {
          System.out.println("<li>" + s.toString() + "</li>");
        }
        System.out.println("</ui>");
    %>
  </div>
</div>

<div>
  <button onclick="location.href='/'">Return</button>
</div>
</body>
</html>