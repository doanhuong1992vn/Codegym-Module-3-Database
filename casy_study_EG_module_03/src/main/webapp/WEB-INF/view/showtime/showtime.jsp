<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>${sessionScope.get("movie").getName()}</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        #divImage {
            max-width: 75%;
            left: 50%;
            transform: translate(-50%)
        }

        img {
            /*margin-top: 2rem;*/
            width: 25rem;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="card mb-3" id="divImage">
        <div class="row g-0">
            <div class="col-md-6">
                <img src="${sessionScope.get('movie').getUrlImage()}"
                     class="img-fluid rounded-start"
                     alt="${sessionScope.get('movie').getName()}">
            </div>
            <div class="col-md-6" id="divMovie">
                <div class="card-body">
                    <h5 class="card-title">${sessionScope.get('movie').getName()}</h5>
                    <%--                    <p class="card-text">--%>
                    <div class="card" style="width: 18rem;">
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">Đạo diễn: ${sessionScope.get('movie').getDirector()}</li>
                            <li class="list-group-item">Diễn viên: ${sessionScope.get('movie').getActors()}</li>
                            <li class="list-group-item">Thể loại: ${sessionScope.get('movie').getGenre()}</li>
                            <li class="list-group-item">Ngày khởi chiếu: ${sessionScope.get('movie').getPremiereDate()}
<%--                                <fmt:formatDate value=""></fmt:formatDate>--%>
                            </li>
                            <li class="list-group-item">Thời lượng: ${sessionScope.get('movie').getDuration()} phút</li>
                            <li class="list-group-item">Ngôn ngữ: ${sessionScope.get('movie').getLanguage()}</li>
                        </ul>
                    </div>
                    <%--                    </p>--%>
                </div>
            </div>
        </div>
    </div>
    <h2>Nội dung phim</h2>
    <p>${sessionScope.get('movie').getContent()}</p>

    <div class="container">
        <form action="${pageContext.request.contextPath}/showtime">
            <label for="date">Chọn ngày chiếu:</label>
            <input type="date" id="date" name="date" autocomplete="off">
            <input type="hidden" name="idMovie" value="${sessionScope.get('movie').getId()}">
            <input type="submit" value="Chọn ngày">
        </form>
        <h2>Lịch chiếu</h2>
        <c:if test="${message != null}">
            <p>${message}</p>
        </c:if>
        <ul class="list-group">
            <c:forEach items='${requestScope.get("mapShowtime")}' var="entry">
                <li class="list-group-item active">Rạp ${entry.getKey()}</li>
                <c:forEach items='${entry.getValue()}' var="showtime">
                    <button type="button" class="btn btn-outline-info">
                        <a href="<c:url value="/seat?idShowtime=${showtime.getId()}"/>">
                            <li class="list-group-item" style="color: #17a2b8">
                                    ${showtime.getStartTime()}
<%--                                <fmt:formatDate value=""></fmt:formatDate>--%>
                            </li>
                        </a>
                    </button>
                </c:forEach>
            </c:forEach>
        </ul>
    </div>
</div>
</body>
</html>