<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Enjoy Galaxy</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        .myClass, button {
            position: fixed;
            left: 50%;
            transform: translate(-50%);
            margin-top: 5rem;
        }
        .myColor {
            position: fixed;
            left: 50%;
            transform: translate(-50%);
            margin-top: 5rem;
            top: 60%;
        }
        .miniColor {
            width: 1.2rem;
            height: 1.2rem;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="myClass row">
        <form action="${pageContext.request.contextPath}/booking" method="get">
            <c:if test="${requestScope.get('message') != null}">
                <p style="color: red">Vui lòng chọn ghế trước khi xác nhận</p>
            </c:if>
            <table>
                <c:forEach items='${sessionScope.get("seats")}' var="row">
                    <tr>
                        <c:forEach items='${row}' var="seat">
                            <td>
                                <c:choose>
                                    <c:when test="${!seat.isEmpty()}">
                                        <input disabled type="checkbox" class="btn-check"
                                               id="btn-check-outlined${seat.getCode()}"
                                               name="idSeats" value="${seat.getId()}" checked>
                                        <input type="hidden" class="myHidden" id="${seat.getCode()}"
                                               value="${seat.getPrice()}">
                                        <label class="btn btn-outline-primary"
                                               style="color: black; background-color: crimson"
                                               for="btn-check-outlined${seat.getCode()}">${seat.getCode()}</label>
                                    </c:when>
                                    <c:otherwise>
                                        <input type="checkbox" class="btn-check"
                                               id="btn-check-outlined${seat.getCode()}"
                                               name="idSeats" value="${seat.getId()}" onclick="getInfo()">
                                        <input type="hidden" class="myHidden" id="${seat.getCode()}"
                                               value="${seat.getPrice()}">
                                        <label class="btn btn-outline-primary"
                                               style="color: black; background-color: #EFE4B0"
                                               for="btn-check-outlined${seat.getCode()}">${seat.getCode()}</label>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </c:forEach>
                    </tr>
                </c:forEach>
            </table>
            <button type="submit">Xác nhận</button>
        </form>
    </div>
    <div class="myColor">
        <div class="row">
            <img class="miniColor" src="https://firebasestorage.googleapis.com/v0/b/module-3-daf70.appspot.com/o/seat%2Fcrimson.jpg?alt=media&token=24cbb9b6-7b94-4542-955a-8a847f1e9bbf"
                 alt="Crimson color"><span> Ghế đã bán</span>
        </div>
        <div class="row">
            <img class="miniColor" src="https://firebasestorage.googleapis.com/v0/b/module-3-daf70.appspot.com/o/seat%2Fgreen.jpg?alt=media&token=1917c061-5645-4c07-9376-33a3bb91d21a"
                 alt="Crimson color"><span> Ghế đang chọn</span>
        </div>
        <div class="row">
            <img class="miniColor" src="https://firebasestorage.googleapis.com/v0/b/module-3-daf70.appspot.com/o/seat%2Fchicken.jpg?alt=media&token=e7468fb0-1b99-4285-ac1f-b944873c2d86"
                 alt="Chicken color"><span> Ghế có thể chọn</span>
        </div>
    </div>
</div>
<div class="card" style="position: fixed; width: 25vw; right: 5%">
    <img src="${sessionScope.get('movie').getUrlImage()}" class="card-img-top"
         alt='${sessionScope.get('movie').getName()}'
         style="height: 445px; width: 18rem">
    <div class="card-body">
        <h5 class="card-title">${sessionScope.get('movie').getName()}</h5>
        <div class="card" style="width: 18rem;">
            <ul class="list-group list-group-flush">
                <li class="list-group-item">Rạp: ${sessionScope.get('domainDTO').getCinema().getName()}</li>
                <li class="list-group-item">Địa chỉ: ${sessionScope.get('domainDTO').getCinema().getAddress()}</li>
                <li class="list-group-item">Ngày
                    chiếu: ${sessionScope.get('domainDTO').getShowtime().getDayMonthYearFormat()}</li>
                <li class="list-group-item">
                    Suất chiếu: ${sessionScope.get('domainDTO').getShowtime().getStartTimeFormat24h()}
                </li>
                <li class="list-group-item">Phòng chiếu: ${sessionScope.get('domainDTO').getRoom().getName()}</li>
                <li class="list-group-item">Ghế: <span id="seatCodes" name="seatCodes"></span></li>
                <li class="list-group-item">Tổng thiệt hại: <span id="totalPrice" name="totalPrice"></span> VNĐ</li>
            </ul>
        </div>
    </div>
</div>
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
        document.getElementById("totalPrice").innerHTML = totalPrice.toString();
    }
</script>
</body>
</html>