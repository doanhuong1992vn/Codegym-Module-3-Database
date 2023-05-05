<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Shopping Cart Management</title>
</head>
<body>
<h1>Shopping Cart</h1>
<a href="/products">Back to Products</a>
<form action="/update" method="get">
    <table>
        <tr>
            <td>Description</td>
            <td>Quantity</td>
            <td>Price</td>
            <td>Total</td>
        </tr>
        <c:forEach var="cartLine" items="${cartLines}">
            <tr>
                <td><c:out value="${cartLine.nameProduct}"></c:out></td>
                <td>
                    <input type="number" name="quantity" value="${cartLine.quantity}"><br>
                    <a href="/products?action=remove&id=${cartLine.idProduct}">Remove</a>
                </td>
                <td><c:out value="${cartLine.price}"></c:out></td>
                <td><c:out value="${cartLine.totalPrice}"></c:out></td>
            </tr>
        </c:forEach>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td>${totalPrice}</td>
        </tr>
    </table>
    <button>Update Cart</button>
</form>
</body>
</html>
