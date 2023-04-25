<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Enjoy Galaxy</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.2.0/mdb.min.css" rel="stylesheet"/>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet"/>
    <style>
        body {
            background-color: #22254b;
        }
        nav {
            background-color: #363b69;
        }
        .message {
            color: #EEEEEE;
            font-size: 2rem;
            font-family: "Cormorant Garamond", serif;
        }
        .h-75 {
            color: #EEEEEE;
        }
        .custom-btn {
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
            box-shadow:inset 2px 2px 2px 0 rgba(255,255,255,.5),
            7px 7px 20px 0 rgba(0,0,0,.1),
            4px 4px 5px 0 rgba(0,0,0,.1);
            outline: none;
        }
        .btn-14 {
            background: rgb(255,151,0);
            border: none;
            z-index: 1;
        }
        .btn-14:after {
            position: absolute;
            content: "";
            width: 100%;
            height: 0;
            top: 0;
            left: 0;
            z-index: -1;
            border-radius: 5px;
            background-color: #eaf818;
            background-image: linear-gradient(315deg, #eaf818 0%, #f6fc9c 74%);
            box-shadow:inset 2px 2px 2px 0 rgba(255,255,255,.5),
            7px 7px 20px 0 rgba(0,0,0,.1),
            4px 4px 5px 0 rgba(0,0,0,.1);
            transition: all 0.3s ease;
        }
        .btn-14:hover {
            color: #000;
        }
        .btn-14:hover:after {
            top: auto;
            bottom: 0;
            height: 100%;
        }
        .btn-14:active {
            top: 2px;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-dark h-25">
    <div class="container-fluid">
        <form class="d-flex input-group w-auto" action="${pageContext.request.contextPath}/" method="get">
            <input type="search"
                   class="form-control rounded"
                   placeholder="Search"
                   aria-label="Search"
                   aria-describedby="search-addon"
                   name="search"
                   style="background-color: antiquewhite;"/>
            <span class="input-group-text text-white border-0" id="search-addon">
        <button style="background: #332D2D; border: none">
            <i class="fas fa-search" style="color: antiquewhite"></i>
        </button>
      </span>
        </form>
    </div>
    <div class="nav-item navbar-brand">
        <c:choose>
            <c:when test="${sessionScope.get('user') == null}">
                <form action="${pageContext.request.contextPath}/login" method="get">
                    <div class="nav-item navbar-brand" style="position: absolute; right: 0; top: 0.3vh">
                        <button type="submit"
                                class="btn btn-outline-dark"
                                data-mdb-ripple-color="dark"
                                style="background-color: antiquewhite">
                            Đăng nhập/Đăng ký
                        </button>
                    </div>
                </form>
            </c:when>
            <c:when test="${sessionScope.get('user') != null}">
                <div style="left: 50%; transform: translate(-50%); position: absolute; top: 1rem">
                    <span style="color: chocolate;
                    font-family: math; position: absolute; top: -1.2vh;
                    left: 50%; transform: translate(-50%);font-size: 1.8rem;">
                        <span style="font-size: 2.5rem;">ENJOY GALAXY</span>
                        xin chào ${sessionScope.get('user').getFullName()} !
                    </span>
                </div>
                <div class="nav-item navbar-brand" style="position: absolute; right: 0; top: 0.3vh;">
                    <form action="${pageContext.request.contextPath}/logout" method="get">
                        <button type="submit" class="btn btn-outline-dark" data-mdb-ripple-color="dark"
                                style="background-color: antiquewhite">Đăng xuất khỏi trái đất
                        </button>
                    </form>
                </div>
            </c:when>
        </c:choose>
    </div>
</nav>
<div id="carouselBasicExample" class="carousel slide carousel-fade" data-mdb-ride="carousel">
    <!-- Indicators -->
    <div class="carousel-indicators">
        <button
                type="button"
                data-mdb-target="#carouselBasicExample"
                data-mdb-slide-to="0"
                class="active"
                aria-current="true"
                aria-label="Slide 1"
        ></button>
        <button
                type="button"
                data-mdb-target="#carouselBasicExample"
                data-mdb-slide-to="1"
                aria-label="Slide 2"
        ></button>
        <button
                type="button"
                data-mdb-target="#carouselBasicExample"
                data-mdb-slide-to="2"
                aria-label="Slide 3"
        ></button>
    </div>

    <!-- Inner -->
    <div class="carousel-inner">
        <!-- Single item -->
        <div class="carousel-item active">
            <img src="https://firebasestorage.googleapis.com/v0/b/module-3-daf70.appspot.com/o/banner%2F1.jpg?alt=media&token=93ccc929-e6ec-4db5-b078-14eeab13c260"
                 class="d-block w-100" alt="Banner phim Con mót nhót chồng"/>
        </div>

        <!-- Single item -->
        <div class="carousel-item">
            <img src="https://firebasestorage.googleapis.com/v0/b/module-3-daf70.appspot.com/o/banner%2F4.jpg?alt=media&token=f5046a20-746b-4780-afe2-e6cbdea2298a"
                 class="d-block w-100" alt="Banner phim Anh em super mario"/>
        </div>

        <!-- Single item -->
        <div class="carousel-item">
            <img src="https://firebasestorage.googleapis.com/v0/b/module-3-daf70.appspot.com/o/banner%2F3.jpg?alt=media&token=0e9d932c-9019-47f8-b2ce-635baae5bf9f"
                 class="d-block w-100" alt="Banner phim Khắc tinh của quỷ"/>
        </div>
    </div>
    <!-- Inner -->

    <!-- Controls -->
    <button class="carousel-control-prev" type="button" data-mdb-target="#carouselBasicExample"
            data-mdb-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-mdb-target="#carouselBasicExample"
            data-mdb-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>
<div class="container-fluid col-10">
    <c:if test="${requestScope.get('message') != null}">
        <h5 class="message">${requestScope.get('message')}</h5>
    </c:if>
    <form action="${pageContext.request.contextPath}/showtime" method="get">
        <c:forEach items='${requestScope.get("movies")}' var="movie">
            <div class="card col-3 float-left mt-5 bg-image hover-zoom" style="background-color: #363b69;">
                <button class="card-header p-0 border-0" style="height: 50vh"
                        name="idMovie" value="${movie.getId()}">
                    <img class="col-12 mt-2" style="height: 47vh" src="${movie.getUrlImage()}" alt='${movie.getName()}'>
                </button>
                <div class="card-body" style="height: 18vh">
                    <div class="h-75">
                        <h5 class="card-title">${movie.getName()}</h5>
                        <p class="card-text">Ngày khởi chiếu: ${movie.getPremiereDateFormat()}</p>
                    </div>
                    <div class="frame">
                        <button class="btn custom-btn btn-14" style="margin-left: 30%"
                                name="idMovie" value="${movie.getId()}">Mua vé</button>
                    </div>
                </div>
            </div>
        </c:forEach>
    </form>
</div>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.2.0/mdb.min.js"></script>
</body>
</html>