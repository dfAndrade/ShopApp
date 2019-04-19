<%@ page import="com.tvb.app.Test" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: diogo
  Date: 17/04/2019
  Time: 01:23
  To change this template use File | Settings | File Templates.
--%>
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
