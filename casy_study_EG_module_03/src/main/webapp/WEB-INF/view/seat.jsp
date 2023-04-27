<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>Enjoy Galaxy made by Đoàn Hưởng</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.2.0/mdb.min.css" rel="stylesheet"/>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet"/>
    <style>
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
            box-shadow: inset 2px 2px 2px 0px rgba(255, 255, 255, .5),
            7px 7px 20px 0px rgba(0, 0, 0, .1),
            4px 4px 5px 0px rgba(0, 0, 0, .1);
            outline: none;
        }

        .btn-12 {
            position: relative;
            right: 20px;
            bottom: 20px;
            border: none;
            box-shadow: none;
            width: 130px;
            height: 40px;
            line-height: 42px;
            -webkit-perspective: 230px;
            perspective: 230px;
        }

        .btn-12 span {
            background: rgb(0, 172, 238);
            background: linear-gradient(0deg, rgba(0, 172, 238, 1) 0%, rgba(2, 126, 251, 1) 100%);
            display: block;
            position: absolute;
            width: 130px;
            height: 40px;
            box-shadow: inset 2px 2px 2px 0px rgba(255, 255, 255, .5),
            7px 7px 20px 0px rgba(0, 0, 0, .1),
            4px 4px 5px 0px rgba(0, 0, 0, .1);
            border-radius: 5px;
            margin: 0;
            text-align: center;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
            -webkit-transition: all .3s;
            transition: all .3s;
        }

        .btn-12 span:nth-child(1) {
            box-shadow: -7px -7px 20px 0px #fff9,
            -4px -4px 5px 0px #fff9,
            7px 7px 20px 0px #0002,
            4px 4px 5px 0px #0001;
            -webkit-transform: rotateX(90deg);
            -moz-transform: rotateX(90deg);
            transform: rotateX(90deg);
            -webkit-transform-origin: 50% 50% -20px;
            -moz-transform-origin: 50% 50% -20px;
            transform-origin: 50% 50% -20px;
        }

        .btn-12 span:nth-child(2) {
            -webkit-transform: rotateX(0deg);
            -moz-transform: rotateX(0deg);
            transform: rotateX(0deg);
            -webkit-transform-origin: 50% 50% -20px;
            -moz-transform-origin: 50% 50% -20px;
            transform-origin: 50% 50% -20px;
        }

        .btn-12:hover span:nth-child(1) {
            box-shadow: inset 2px 2px 2px 0px rgba(255, 255, 255, .5),
            7px 7px 20px 0px rgba(0, 0, 0, .1),
            4px 4px 5px 0px rgba(0, 0, 0, .1);
            -webkit-transform: rotateX(0deg);
            -moz-transform: rotateX(0deg);
            transform: rotateX(0deg);
        }

        .btn-12:hover span:nth-child(2) {
            box-shadow: inset 2px 2px 2px 0px rgba(255, 255, 255, .5),
            7px 7px 20px 0px rgba(0, 0, 0, .1),
            4px 4px 5px 0px rgba(0, 0, 0, .1);
            color: transparent;
            -webkit-transform: rotateX(-90deg);
            -moz-transform: rotateX(-90deg);
            transform: rotateX(-90deg);
        }
    </style>
</head>
<%--<body style="background-image:  url('https://wallpaper-mania.com/wp-content/uploads/2018/09/High_resolution_wallpaper_background_ID_77701249339.jpg')">--%>
<body style="background-color: #22254b">
<%@include file="/WEB-INF/view/common/navbar.jsp" %>
<main>
    <div class="container col-12">
        <div class="col-6 float-left">
            <form action="${pageContext.request.contextPath}/booking" method="get">
                <div class="col-12 justify-content-center d-flex mb-5 text-danger mt-5">
                    <c:if test="${requestScope.get('message') == null}">
                        <img style="width: 25vw; height: 15vh"
                             src="https://firebasestorage.googleapis.com/v0/b/module-3-daf70.appspot.com/o/background%2Ftheater3.jpg?alt=media&token=6c5d3f7c-7352-4c2b-8da1-106531ca6e7e">
                    </c:if>
                    <c:if test="${requestScope.get('message') != null}">
                        <img style="width: 25vw; height: 15vh"
                             src="https://firebasestorage.googleapis.com/v0/b/module-3-daf70.appspot.com/o/background%2Ftheater3%20-%20Copy.jpg?alt=media&token=b03791bd-e1ab-479e-b7b5-0f961c28e288">
                    </c:if>
                </div>
                <div class="col-12 justify-content-center d-flex mb-5 mt-5">
                    <table>
                        <c:forEach items='${sessionScope.get("seats")}' var="row">
                            <c:if test='${sessionScope.get("seats")[4] == row}'>
                                <tr>
                                    <td>&nbsp;</td>
                                </tr>
                            </c:if>
                            <tr>
                                <c:forEach items='${row}' var="seat">
                                    <c:if test='${seat == row[3]}'>
                                        <td>
                                            <div class="m-3"></div>
                                        </td>
                                    </c:if>
                                    <td>
                                        <div class="m-2">
                                            <c:choose>
                                                <c:when test="${!seat.isEmpty()}">
                                                    <input disabled type="checkbox" class="btn-check"
                                                           id="btn-check-outlined${seat.getCode()}"
                                                           name="idSeats" value="${seat.getId()}" checked>
                                                    <label class="btn btn-outline-primary"
                                                           style="color: black; background-color: crimson;"
                                                           for="btn-check-outlined${seat.getCode()}">
                                                            ${seat.getCode()}</label>
                                                    <input type="hidden" class="myHidden" id="${seat.getCode()}"
                                                           value="${seat.getPrice()}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input type="checkbox" class="btn-check"
                                                           id="btn-check-outlined${seat.getCode()}"
                                                           name="idSeats" value="${seat.getId()}" onclick="getInfo()">
                                                    <label class="btn btn-outline-primary"
                                                           style="color: black; background-color: #EFE4B0;"
                                                           for="btn-check-outlined${seat.getCode()}">
                                                            ${seat.getCode()}</label>
                                                    <input type="hidden" class="myHidden" id="${seat.getCode()}"
                                                           value="${seat.getPrice()}">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                    </td>
                                </c:forEach>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div class="text-white col-12 justify-content-between d-flex mb-5">
                    <span><img width="20" height="20" alt="Crimson color"
                               src="https://firebasestorage.googleapis.com/v0/b/module-3-daf70.appspot.com/o/seat%2Fcrimson.jpg?alt=media&token=24cbb9b6-7b94-4542-955a-8a847f1e9bbf">
                        Ghế đã bán</span>
                    <span><img width="20" height="20" alt="Crimson color"
                               src="https://firebasestorage.googleapis.com/v0/b/module-3-daf70.appspot.com/o/seat%2Fgreen.jpg?alt=media&token=1917c061-5645-4c07-9376-33a3bb91d21a">
                        Ghế đang chọn</span>
                    <span><img width="20" height="20" alt="Chicken color"
                               src="https://firebasestorage.googleapis.com/v0/b/module-3-daf70.appspot.com/o/seat%2Fchicken.jpg?alt=media&token=e7468fb0-1b99-4285-ac1f-b944873c2d86">
                        Ghế có thể chọn</span>
                </div>
                <div class="justify-content-center d-flex col-12 mt-5">
                    <button class="custom-btn btn-12"><span>Click!</span><span>Xác nhận</span></button>
                </div>

            </form>
        </div>
        <div class="card col-4 float-right myBg" style="background: rgba(0,0,0,0.1);">
            <img src="${sessionScope.get('movie').getUrlImage()}" class="card-img-top ml-5"
                 alt='${sessionScope.get('movie').getName()}' style="height: 445px; width: 18rem">
            <div class="card-body">
                <ul class="list-group">
                    <li class="list-group-item list-group-item-secondary"><h5 class="card-title text-primary">
                        ${sessionScope.get('movie').getName()}</h5></li>
                    <li class="list-group-item list-group-item-warning">
                        Rạp: ${sessionScope.get('domainDTO').getCinema().getName()}</li>
                    <li class="list-group-item list-group-item-secondary">
                        Địa chỉ: ${sessionScope.get('domainDTO').getCinema().getAddress()}</li>
                    <li class="list-group-item list-group-item-warning">
                        Ngày chiếu: ${sessionScope.get('domainDTO').getShowtime().getDayMonthYearFormat()}</li>
                    <li class="list-group-item list-group-item-secondary">
                        Suất chiếu: ${sessionScope.get('domainDTO').getShowtime().getStartTimeFormat24h()}</li>
                    <li class="list-group-item list-group-item-warning">Phòng
                        chiếu: ${sessionScope.get('domainDTO').getRoom().getName()}</li>
                    <li class="list-group-item list-group-item-secondary">
                        Ghế: <span id="seatCodes" name="seatCodes"></span></li>
                    <li class="list-group-item list-group-item-warning">
                        Tổng thiệt hại: <span id="totalPrice" name="totalPrice"></span></li>
                </ul>
            </div>
        </div>
    </div>
</main>
<%@include file="/WEB-INF/view/common/footer.jsp" %>
<script>
    function getInfo() {
        let checkboxElements = document.querySelectorAll(".btn-check");
        let myHiddenElements = document.querySelectorAll(".myHidden")
        let myLabels = document.querySelectorAll(".btn-outline-primary");
        let seatCodes = "";
        let totalPrice = 0;
        for (let i = 0; i < checkboxElements.length; i++) {
            let checkboxElement = checkboxElements[i];
            if (checkboxElement.checked && !checkboxElement.hasAttribute('disabled')) {
                myLabels[i].style.backgroundColor = "#27E621";
                myLabels[i].style.color = "white";
                let seatCode = checkboxElements[i].id.substring(18);
                let price = myHiddenElements[i].value;
                if (myHiddenElements[i].id === seatCode) {
                    seatCodes += seatCode += " ";
                    totalPrice += Number.parseFloat(price);
                }
            } else if (!checkboxElement.hasAttribute('disabled')) {
                myLabels[i].style.backgroundColor = "#EFE4B0";
                myLabels[i].style.color = "black";
            }
        }
        document.getElementById("seatCodes").innerHTML = seatCodes;
        document.getElementById("totalPrice").innerHTML = new Intl.NumberFormat('vi-VN', {
            style: 'currency',
            currency: 'VND',
        }).format(totalPrice);
    }
</script>
</body>
</html>
