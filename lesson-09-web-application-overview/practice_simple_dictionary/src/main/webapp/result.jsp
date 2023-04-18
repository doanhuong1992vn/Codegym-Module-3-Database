
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<%
    String search = request.getParameter("txtSearch");
    String result = request.getAttribute("result").toString();
    if (result.equalsIgnoreCase("Không tìm thấy ")) {
    result += search + " trong từ điển";
    }
%>
<h1>Word: <%=search%></h1>
<h1>Result: <%=result%></h1>
</body>
</html>
