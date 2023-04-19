<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Deleting Product</title>
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
<h1>Delete Product</h1>
<button><a href="${pageContext.request.contextPath}/products">Back</a></button>
<form method="post">
  <h3>Are you sure?</h3>
  <fieldset>
    <legend>Product information</legend>
    <table>
      <tr>
        <td>Name: </td>
        <td>${product.getName()}</td>
      </tr>
      <tr>
        <td>Price: </td>
        <td>${product.getPrice()}</td>
      </tr>
      <tr>
        <td>Description: </td>
        <td>${product.getDescription()}</td>
      </tr>
      <tr>
        <td>Producer: </td>
        <td>${product.getProducer()}</td>
      </tr>
      <tr>
        <td><input type="submit" value="Delete product"></td>
        <td><button><a href="${pageContext.request.contextPath}/products">Back</a></button></td>
      </tr>
    </table>
  </fieldset>
</body>
</html>
