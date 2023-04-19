<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Management</title>
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
<h1>Product Management</h1>
<form method="get" action="${pageContext.request.contextPath}/search">
    <label>
        <input type="text" name="keyword" placeholder="Search Product">
    </label>
    <button type="submit">Search</button>
</form>
<button><a href="?action=create">Create new product</a></button>
<button><a href="/products">Show all products</a></button>
<br>
<table>
    <tr>
        <th></th>
        <th>NAME</th>
        <th>PRICE</th>
        <th>DESCRIPTION</th>
        <th>PRODUCER</th>
    </tr>
    <c:forEach items='${requestScope["products"]}' var="product">
        <tr>
            <td><button><a href="?action=view&id=${product.getId()}">Detail</a></button></td>
            <td>${product.getName()}</td>
            <td>${product.getPrice()}</td>
            <td>${product.getDescription()}</td>
            <td>${product.getProducer()}</td>
            <td><button><a href="?action=edit&id=${product.getId()}">EDIT</a></button></td>
            <td><button><a href="?action=delete&id=${product.getId()}">DELETE</a></button></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>