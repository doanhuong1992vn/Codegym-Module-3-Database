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
    </style>
</head>
<body>

<div class="container">
    <div class="myClass">
        <form action="${pageContext.request.contextPath}/booking" method="get">
            <c:if test="${requestScope.get('message') != null}">
                <p style="color: red">Vui lòng chọn ghế trước khi xác nhận</p>
            </c:if>
            <table>
                <c:forEach items='${sessionScope.get("seats")}' var="row">
                    <tr>
                        <c:forEach items='${row}' var="seat">
                            <td>
                                <input type="checkbox" class="btn-check" id="btn-check-outlined${seat.getCode()}"
                                       name="idSeats" value="${seat.getId()}" onclick="getInfo()">
                                <input type="hidden" id="${seat.getCode()}" value="${seat.getCode()}">
                                <label class="btn btn-outline-primary"
                                       for="btn-check-outlined${seat.getCode()}">${seat.getCode()}</label>
                            </td>
                        </c:forEach>
                    </tr>
                </c:forEach>
            </table>
            <button type="submit">Xác nhận</button>
        </form>
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
                <li class="list-group-item">
                    Suất chiếu: ${sessionScope.get('domainDTO').getShowtime().getStartTime()}
                </li>
                <li class="list-group-item">Phòng chiếu: ${sessionScope.get('domainDTO').getRoom().getName()}</li>
                <li class="list-group-item">Ghế: <span id="seatCode"></span></li>
                <li class="list-group-item">Tổng thiệt hại: <span id="totalPrice"></span></li>
            </ul>
        </div>
    </div>
</div>
<script>
    function getInfo() {
        let inputElements = document.querySelectorAll("input");
        for (let i = 0; i < inputElements.length; i++) {
            if (inputElements[i].checked) {
                let id = inputElements[i].value;
                <c:forEach items='${sessionScope.get("seats")}' var="row">
                <c:forEach items='${row}' var="seat">
                let seat = ${seat};
                if (seat.getId() === id) {
                    document.getElementById("seatCode").innerHTML = ${seat.getCode()};
                    document.getElementById("totalPrice").innerHTML = ${seat.getCode()};
                }
                </c:forEach>
                </c:forEach>
            }
        }
    }
</script>
</body>
</html>