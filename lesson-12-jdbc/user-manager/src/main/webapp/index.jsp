<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Shopping Cart Management</title>
</head>
<body>
<h1>T-Shirts</h1>
<div align="center">
    <table border="1" cellpadding="5">
        <tr>
            <th>Title</th>
            <th>Product</th>
            <th>Price</th>
            <th>Rating</th>
            <th></th>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td><c:out value="${product.name}"></c:out></td>
                <td><c:out value="${product.imageUrl}"></c:out></td>
                <td><c:out value="${product.price}"></c:out></td>
                <td></td>
                <td>
                    <a href="/products?action=buy&id=${product.id}">Buy now</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>