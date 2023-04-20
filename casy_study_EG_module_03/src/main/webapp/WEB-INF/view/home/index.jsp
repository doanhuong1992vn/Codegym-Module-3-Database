<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Enjoy Galaxy</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<c:forEach items='${requestScope.get("movies")}' var="movie">
    <div class="card" style="width: 20rem;">
        <a href="${pageContext.request.contextPath}/booking?idMovie=${movie.getId()}"><img src="${movie.getUrlImage()}" class="card-img-top" alt='${movie.getName()}'></a>
        <div class="card-body">
            <h5 class="card-title">${movie.getName()}</h5>
            <p class="card-text"><fmt:formatDate value="${movie.getPremiereDate()}"></fmt:formatDate></p>
            <a href="${pageContext.request.contextPath}/booking?idMovie=${movie.getId()}" class="btn btn-primary">Mua vé</a>
        </div>
    </div>
</c:forEach>
</body>
</html>