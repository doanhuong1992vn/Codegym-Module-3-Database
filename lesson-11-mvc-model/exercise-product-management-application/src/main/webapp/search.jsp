<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/18/2023
  Time: 10:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Product</title>
    <style>
        a {
            text-decoration: none;
        }
        a:active {
            text-decoration: blue;
        }
        table, th, td {
            border: 1px solid black;

            border-collapse: collapse;
        }
    </style>
</head>
<body>
<button><a href="/products?action=all">Show all products</a></button>
<br>
<table>
    <tr>
        <th></th>
        <th>NAME</th>
        <th>PRICE</th>
        <th>DESCRIPTION</th>
        <th>PRODUCER</th>
    </tr>
    <c:forEach items='${requestScope["productsSearch"]}' var="product">
        <tr>
            <td><button><a href="/products?action=view&id=${product.getId()}">Detail</a></button></td>
            <td>${product.getName()}</td>
            <td>${product.getPrice()}</td>
            <td>${product.getDescription()}</td>
            <td>${product.getProducer()}</td>
            <td><button><a href="/products?action=edit&id=${product.getId()}">EDIT</a></button></td>
            <td><button><a href="/products?action=delete&id=${product.getId()}">DELETE</a></button></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
