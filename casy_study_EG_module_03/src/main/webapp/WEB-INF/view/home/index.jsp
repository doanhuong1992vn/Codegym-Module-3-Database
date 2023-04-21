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
<form action="/movie" method="get">
    <c:forEach items='${requestScope.get("movies")}' var="movie">
        <div class="card" style="width: 20rem; float: left; height: 650px; margin: 1rem">
            <button type="submit" class="btn btn-outline-dark"  name="idMovie" value="${movie.getId()}" style="height: 455px; width: 20rem">
                <img src="${movie.getUrlImage()}" class="card-img-top" alt='${movie.getName()}' style="height: 445px; width: 18rem">
            </button>
            <div class="card-body">
                <h5 class="card-title">${movie.getName()}</h5>
                <p class="card-text">
                    Ngày khởi chiếu: <fmt:formatDate value="${movie.getPremiereDate()}"></fmt:formatDate>
                </p>
                <button type="submit" class="btn btn-outline-primary" name="idMovie" value="${movie.getId()}">
                    Mua vé
                </button>
            </div>
        </div>
    </c:forEach>
</form>
</body>
</html>