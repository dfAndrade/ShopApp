<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: diogo
  Date: 21/04/2019
  Time: 02:41
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>List Products</title>
</head>
<body>
<table>
    <jsp:useBean id="products" scope="request" type="java.util.List"/>
    <c:forEach var="p" items="${products}">
        <tr>
            <td><c:out value="${p.toL}"/></td>
            <td><c:out value="${customer.firstName}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
