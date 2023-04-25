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

</head>
<body>
<nav class="navbar navbar-dark bg-dark">
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
<!-- Carousel wrapper -->
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
<div class="container-fluid">

    <!-- Carousel wrapper -->
    <div class="col-2"></div>
    <div class="col-8">
        <div class="row p-2 justify-content-center">
            <c:if test="${requestScope.get('message') != null}">
                <br><br>
                <p>${requestScope.get('message')}</p>
            </c:if>
            <form action="${pageContext.request.contextPath}/showtime" method="get">
                <c:forEach items='${requestScope.get("movies")}' var="movie">
                    <div class="card col-3" style="width: 15rem; float: left; height: 650px; margin: 1rem">
                        <button type="submit" class="btn btn-outline-dark" name="idMovie" value="${movie.getId()}"
                                style="height: 455px; width: 20rem; border: none">
                            <img src="${movie.getUrlImage()}" class="card-img-top" alt='${movie.getName()}'
                                 style="height: 445px; width: 18rem">
                        </button>
                        <div class="card-body">
                            <h5 class="card-title">${movie.getName()}</h5>
                            <p class="card-text">
                                Ngày khởi chiếu: ${movie.getPremiereDateFormat()}
                            </p>
                            <button type="submit" class="btn btn-outline-primary" name="idMovie"
                                    value="${movie.getId()}">
                                Mua vé
                            </button>
                        </div>
                    </div>
                </c:forEach>
            </form>
        </div>
    </div>
    <div class="col-2"></div>
</div>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.2.0/mdb.min.js"></script>
</body>
</html>