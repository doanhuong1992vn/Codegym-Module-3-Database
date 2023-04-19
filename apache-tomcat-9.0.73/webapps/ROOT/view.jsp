<%@ page import="model.entity.Product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>View Product</title>
    <style>
        a {
            text-decoration: none;
        }
        a:active {
            text-decoration: blue;
        }
    </style>
</head>
<body>
<h1>Product Detail</h1>
<button><a href="/products">Back</a></button><br>
<table>
    <%Product product = (Product) request.getAttribute("product");%>
    <tr>
        <td>Name: </td>
        <td><%=product.getName()%></td>
    </tr>
    <tr>
        <td>Price: </td>
        <td><%=product.getPrice()%></td>
    </tr>
    <tr>
        <td>Description: </td>
        <td><%=product.getDescription()%></td>
    </tr>
    <tr>
        <td>Producer: </td>
        <td><%=product.getProducer()%></td>
    </tr>
</table>
</body>
</html>
