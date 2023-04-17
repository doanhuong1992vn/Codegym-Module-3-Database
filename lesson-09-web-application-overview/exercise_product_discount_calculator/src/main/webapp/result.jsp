<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Discount Information</title>
</head>
<body>
  <h1>Product Description: <%=request.getParameter("description")%></h1>
  <h1>List Price: <%=request.getParameter("listPrice")%> VNĐ</h1>
  <h1>Discount Percent: <%=request.getParameter("discountPercent")%>%</h1>
  <h1>Discount Amount: <%=request.getAttribute("discountAmount")%> VNĐ</h1>
  <h1>Discount Price: <%=request.getAttribute("discountPrice")%> VNĐ</h1>
</body>
</html>
