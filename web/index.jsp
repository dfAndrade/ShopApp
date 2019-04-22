<%--
  Created by IntelliJ IDEA.
  User: diogo
  Date: 17/04/2019
  Time: 01:23
--%>
<%@ page import="java.util.List" %>
<%@ page import="com.tvb.app.servlets.Test" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TITEL</title>
</head>
<body>
<%=Test.test() + "2324"%>
<%
    List<String> test = (List<String>) request.getAttribute("test");

    for (String s : test) {
        out.println(s);
    }
%>
</body>
</html>
