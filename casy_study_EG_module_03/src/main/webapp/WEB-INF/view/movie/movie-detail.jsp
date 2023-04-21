<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>${requestScope.get("movie").getName()}</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="card mb-3" style="max-width: 75%; left: 50%; transform: translate(-50%)">
    <div class="row g-0">
        <div class="col-md-4">
            <img style="margin-top: 100px; width: 25rem;" src="${movie.getUrlImage()}" class="img-fluid rounded-start"
                 alt="${movie.getName()}">
        </div>
        <div class="col-md-8">
            <div class="card-body">
                <h5 class="card-title">${movie.getName()}</h5>
                <p class="card-text">
                <div class="card" style="width: 18rem;">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">Đạo diễn: ${movie.getDirector()}</li>
                        <li class="list-group-item">Diễn viên: ${movie.getActors()}</li>
                        <li class="list-group-item">Thể loại: ${movie.getGenre()}</li>
                        <li class="list-group-item">Ngày khởi chiếu:
                            <fmt:formatDate value="${movie.getPremiereDate()}"></fmt:formatDate>
                        </li>
                        <li class="list-group-item">Thời lượng: ${movie.getDuration()} phút</li>
                        <li class="list-group-item">Ngôn ngữ: ${movie.getLanguage()}</li>
                    </ul>
                </div>
                </p>
            </div>
        </div>
    </div>
</div>
<h2>Nội dung phim</h2>
<p>${movie.getContent()}</p>

<div class="container">
    <h2>Lịch chiếu</h2>
    <ul class="list-group">
        <c:forEach items='${requestScope.get("mapShowtime")}' var="entry">
            <li class="list-group-item active">Rạp ${entry.getKey()}</li>
            <c:forEach items='${entry.getValue()}' var="showtime">
                <button type="button" class="btn btn-outline-info">
                    <a href="<c:url value="/booking?idShowtime=${showtime.getId()}"/>">
                        <li class="list-group-item" style="color: #17a2b8">
                                ${showtime.getStartTime()}
                        </li>
                    </a>
                </button>
            </c:forEach>
        </c:forEach>
    </ul>
</div>


</body>
</html>