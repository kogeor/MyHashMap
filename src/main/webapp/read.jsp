<%@ page import="org.gk.MyHashMap" %>
<%@ page import="java.io.PrintWriter" %>
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
            for (Object key : myHashMap.keySet()) {
                output.println("<li>" + key + "  " + myHashMap.get(key) + "</li>");
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