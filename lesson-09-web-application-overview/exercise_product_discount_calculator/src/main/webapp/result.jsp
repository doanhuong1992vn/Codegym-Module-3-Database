<%@ page import="utils.Converter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Discount Information</title>
</head>
<body>
  <h1></h1>
  <h1>Product Description: <%=request.getParameter("description")%></h1>
  <h1>List Price: <%=Converter.formatPrice(Double.parseDouble(request.getParameter("listPrice")))%></h1>
  <h1>Discount Percent: <%=request.getParameter("discountPercent")%>%</h1>
  <h1>Discount Amount: <%=Converter.formatPrice((Double) request.getAttribute("discountAmount"))%></h1>
  <h1>Discount Price: <%=Converter.formatPrice((Double) request.getAttribute("discountPrice"))%></h1>
</body>
</html>
