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
        body {
            background-color: #22254b;
        }
        .list-group-item {
            background-color: #363b69;
        }
        .custom-btn {
            width: 130px;
            height: 40px;
            color: #fff;
            border-radius: 5px;
            padding: 10px 25px;
            font-family: 'Lato', sans-serif;
            font-weight: 500;
            background: transparent;
            cursor: pointer;
            transition: all 0.3s ease;
            position: relative;
            display: inline-block;
            box-shadow:inset 2px 2px 2px 0px rgba(255,255,255,.5),
            7px 7px 20px 0px rgba(0,0,0,.1),
            4px 4px 5px 0px rgba(0,0,0,.1);
            outline: none;
        }
        .btn-7 {
            background: linear-gradient(0deg, rgba(255,151,0,1) 0%, rgba(251,75,2,1) 100%);
            line-height: 42px;
            padding: 0;
            border: none;
        }
        .btn-7 span {
            position: relative;
            display: block;
            width: 100%;
            height: 100%;
        }
        .btn-7:before,
        .btn-7:after {
            position: absolute;
            content: "";
            right: 0;
            bottom: 0;
            background: rgba(251,75,2,1);
            box-shadow:
                    -7px -7px 20px 0px rgba(255,255,255,.9),
                    -4px -4px 5px 0px rgba(255,255,255,.9),
                    7px 7px 20px 0px rgba(0,0,0,.2),
                    4px 4px 5px 0px rgba(0,0,0,.3);
            transition: all 0.3s ease;
        }
        .btn-7:before{
            height: 0%;
            width: 2px;
        }
        .btn-7:after {
            width: 0%;
            height: 2px;
        }
        .btn-7:hover{
            color: rgba(251,75,2,1);
            background: transparent;
        }
        .btn-7:hover:before {
            height: 100%;
        }
        .btn-7:hover:after {
            width: 100%;
        }
        .btn-7 span:before,
        .btn-7 span:after {
            position: absolute;
            content: "";
            left: 0;
            top: 0;
            background: rgba(251,75,2,1);
            box-shadow:
                    -7px -7px 20px 0px rgba(255,255,255,.9),
                    -4px -4px 5px 0px rgba(255,255,255,.9),
                    7px 7px 20px 0px rgba(0,0,0,.2),
                    4px 4px 5px 0px rgba(0,0,0,.3);
            transition: all 0.3s ease;
        }
        .btn-7 span:before {
            width: 2px;
            height: 0%;
        }
        .btn-7 span:after {
            height: 2px;
            width: 0%;
        }
        .btn-7 span:hover:before {
            height: 100%;
        }
        .btn-7 span:hover:after {
            width: 100%;
        }
    </style>
</head>
<body>
<div class="card border-light container border-0" style="background-color: #363b69;">
    <div class="row col-12">
        <div class="col-6">
            <img src="${sessionScope.get('movie').getUrlImage()}"
                 class="img-fluid rounded-start m-2 ml-5 pl-3 bg-image hover-zoom" style="height: 55vh"
                 alt="${sessionScope.get('movie').getName()}">
        </div>
        <div class="card-body col-6 text-white">
            <h5 class="card-title">${sessionScope.get('movie').getName()}</h5>
            <div class="card border-0" style="width: 18rem;">
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">Đạo diễn: ${sessionScope.get('movie').getDirector()}</li>
                    <li class="list-group-item">Diễn viên: ${sessionScope.get('movie').getActors()}</li>
                    <li class="list-group-item">Thể loại: ${sessionScope.get('movie').getGenre()}</li>
                    <li class="list-group-item">
                        Ngày khởi chiếu: ${sessionScope.get('movie').getPremiereDateFormat()}
                    </li>
                    <li class="list-group-item">Thời lượng: ${sessionScope.get('movie').getDuration()} phút</li>
                    <li class="list-group-item">Ngôn ngữ: ${sessionScope.get('movie').getLanguage()}</li>
                </ul>
            </div>
        </div>
    </div>
</div>
<div class="container col-8 text-white mt-4">
    <h2>Nội dung phim</h2>
    <p>${sessionScope.get('movie').getContent()}</p>

    <div class="container mt-4">
        <form action="${pageContext.request.contextPath}/showtime">
            <label for="date">Chọn ngày chiếu:</label>
            <input type="date" id="date" name="date" autocomplete="off">
            <input type="hidden" name="idMovie" value="${sessionScope.get('movie').getId()}">
            <input type="submit" value="Chọn ngày">
        </form>
        <h2>Lịch chiếu</h2>
        <h5>${requestScope.get('message')}</h5>
        <ul class="list-group">
            <c:forEach items='${requestScope.get("mapShowtime")}' var="entry">
                <li class="list-group-item active">Rạp ${entry.getKey()}</li>
                <c:forEach items='${entry.getValue()}' var="showtime">
                    <button class="custom-btn btn-7"><span>
                        <a href="<c:url value="/seat?idShowtime=${showtime.getId()}"/>">
<%--                            <li class="list-group-item text-white">--%>


                                    ${showtime.getStartTimeFormat24h()}
<%--                            </li>--%>
                        </a>
                    </span></button>
                </c:forEach>
            </c:forEach>
        </ul>
    </div>
</div>
</body>
</html>