<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Discount Calculator</title>
    <style>
        input {
            width: 250px;
        }
    </style>
</head>
<body>
<h2>Product Discount Calculator</h2>
<form method="get" action="${pageContext.request.contextPath}/DiscountServlet">
    <label>Product Description<br/>
        <input type="text" name="description" placeholder="Mô tả của sản phẩm"/>
    </label><br/><br/>
    <label>List Price<br/>
        <input type="number" name="listPrice" placeholder="Giá niêm yết của sản phẩm"/>
    </label><br/><br/>
    <label>Discount Percent (%)<br/>
        <input type="number" name="discountPercent" placeholder="Tỷ lệ chiết khấu (phần trăm)"/>
    </label><br/><br/><br/>
    <input type="submit" value="Calculate Discount">
</form>
</body>
</html>