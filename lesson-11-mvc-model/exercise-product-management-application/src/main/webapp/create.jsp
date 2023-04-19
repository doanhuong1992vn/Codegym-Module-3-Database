<%@ page import="model.entity.Product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Create new product</title>
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
        .message {
            color: green;
        }
    </style>
</head>
<body>
<h1>Create new product</h1>
<button><a href="/products">Back</a></button><br>
<p>
<%--    <c:if test='${requestScope["message"] != null}'>--%>
<%--        <span class="message">${requestScope["message"]}</span>--%>
<%--    </c:if>--%>
    <c:if test='${requestScope.get("message") != null}'>
        <span class="message">${requestScope.get("message")}</span>
    </c:if>
</p>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><input type="number" name="price"></td>
            </tr>
            <tr>
                <td>Description: </td>
                <td><input type="text" name="description"></td>
            </tr>
            <tr>
                <td>Producer: </td>
                <td><input type="text" name="producer"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create Product"></td>
            </tr>
        </table>
    </fieldset>
</form>



</body>
</html>
