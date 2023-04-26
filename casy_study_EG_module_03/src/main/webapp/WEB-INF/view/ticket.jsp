<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title>Enjoy Galaxy made by Đoàn Hưởng</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.2.0/mdb.min.css" rel="stylesheet"/>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet"/>
    <style>
        @import url("https://fonts.googleapis.com/css?family=Nunito+Sans:300,400,600,700,800");

        * {
            margin: 0;
            padding: 0;
            margin-block-start: 0;
            margin-block-end: 0;
        }

        :root {
            --bg: #0d0b5b;
            --font-color: #333333;
            --point-color: #237fff;
        }

        body {
            background: var(--bg);
            font-family: "Nunito Sans", sans-serif;
        }

        .strong {
            color: var(--point-color);
        }

        div.ticket {
            position: relative;
            margin: 0 auto;
            margin-top: 10px;
            width: 330px;
            height: 540px;
            background: #291710;
            transition: transform 0.4s;
            transform-style: preserve-3d;
        }

        .ticket:hover {
            transform: rotateY(180deg);
        }

        .ticket:hover div.back {
            z-index: 100;
        }

        .ticket:hover div.front {
            opacity: 0;
        }

        div.side {
            position: absolute;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;

            backface-visibility: hidden;
        }

        div.side img {
            object-fit: cover;
            width: 100%;
            height: 370px;
        }

        div.bottom {
            position: absolute;
            height: 170px;
            background: #ffffff;
            bottom: 0px;
            width: 100%;
            padding: 35px 23px;
            box-sizing: border-box;
        }

        div.back div.bottom {
        }

        div.front {
        }

        div.front {
        }

        div.back {
            transform: rotateY(180deg);
        }

        div.side:before,
        div.side:after {
            content: "";
            width: 1px;
            height: 1px;
            position: absolute;
            box-shadow: var(--bg) 0 0 0 21px;
            background: var(--bg);
            border-radius: 25%;
            top: 367px;
            z-index: 1;
        }

        div.side:after {
            right: 0px;
        }

        div.side h1 {
            font-size: 16px;
            text-transform: uppercase;
            color: #0a4faf;
            font-weight: 800;
            margin: 0;
            margin-bottom: -5px;
        }

        div.front span.address {
            font-size: 13px;
            color: var(--font-color);
            letter-spacing: -0.3px;
        }

        div.front dl {
            position: relative;
            width: 100%;
        }

        div.front dl:after {
            content: "";
            display: block;
            clear: both;
        }

        div.front dl dt {
            display: inline-block;
            width: 33%;
            float: left;
            text-align: center;
            top: 50px;
            font-size: 12px;
            position: relative;
        }

        div.front dl dd {
            margin-top: 14px;
            display: inline-block;
            left: 0px;
            width: 33%;
            position: absolute;
            color: var(--font-color);
            text-align: center;
            font-size: 26px;
            font-weight: 300;
        }

        div.front dl dd:nth-of-type(2) {
            left: 33%;
        }

        div.front dl dd:nth-of-type(3) {
            left: 66%;
        }

        div.side span.floating {
            display: block;
            position: absolute;
            width: 60px;
            right: 40px;
            top: -30px;
            height: 60px;
            box-sizing: border-box;
            padding: 18px 5px;
            border-radius: 50%;
            color: #ffffff;
            text-align: center;
            background: var(--point-color);
        }

        span.strong {
            font-weight: 600;
        }

        div.back span.floating:before {
            content: "";
            width: 20px;
            height: 11px;
            border-left: 4px solid var(--point-color);
            border-bottom: 4px solid var(--point-color);
            display: block;
            transform: rotate(-50deg) translate(7px, 12px);
        }

        div.back div.bottom {
            background: var(--point-color);
        }

        div.back h1 {
            color: #ffffff;
        }

        div.back span.floating {
            background: #ffffff;
            color: var(--point-color);
        }

        .clearfix:after {
            content: "";
            display: block;
            clear: both;
        }

        div.back table {
            color: #ffffff;
        }

        div.back {
        }

        div.back div.span {
            color: #ffffff;
        }

        div.back div.top div.span + div.span {
            margin-top: 20px;
        }

        div.back div.top h2 {
            font-size: 12px;
            opacity: 0.7;
            font-weight: 300;
            text-transform: uppercase;
        }

        div.back div.span span {
            font-size: 19px;
        }

        div.back div.span.span8 {
            float: left;
            width: 66.66666%;
        }

        div.back div.span.span4 {
            float: left;
            width: 33.33333%;
        }

        div.back div.top {
            padding: 60px 40px;
        }

        div.payment div.row {
            margin-top: 15px;
        }

        div.card-num {
            border-bottom: 1px solid #ffffff;
        }

        div.payment input {
            background: transparent;
            border: 0;
            width: 20%;
            font-size: 16px;
            padding: 4px 0px;
            color: #ffff;
            letter-spacing: 0.2px;
        }

        ::placeholder {
            color: #ffffff;
            opacity: 0.7;
        }

        div.payment div.row div.span4 {
            width: 30%;
            float: left;
            border-bottom: 1px solid #ffffff;
        }

        div.payment div.row div.span4 + div.span4 {
            margin-left: 5%;
        }

        div.payment div.span input {
            width: 100%;
        }

        p.msg {
            text-align: center;
            color: #ffffff;
            margin-top: 10px;
        }

    </style>
</head>
<body>
<%@include file="/WEB-INF/view/common/navbar.jsp"%>
<c:set var="domainDTO" value="${sessionScope.get('domainDTO')}" scope="session"/>
<c:set var="cinema" value="${domainDTO.getCinema()}" scope="session"/>
<c:set var="showtime" value="${domainDTO.getShowtime()}" scope="session"/>
<c:set var="movie" value="${sessionScope.get('movie')}" scope="session"/>
<main>
<!-- https://www.behance.net/gallery/34319771/Movie-Ticket-Checkout -->
<div class="container-fluid col-md-8">

    <div class="col-12 mt-5">
        <c:forEach items="${sessionScope.get('seatAndTicketMap').entrySet()}" var="entry">
            <c:set var="seat" value="${entry.getKey()}" scope="request"/>
            <c:set var="ticket" value="${entry.getValue()}" scope="request"/>
            <div class="ticket float-left mb-5 col-4 m-3">
                <div class="side front">
                    <img src="${movie.getUrlImage()}" alt="${movie.getName()}">
                    <div class="info bottom">
                        <h1>${movie.getName()}</h1>
                        <h5 class="title address">Rạp ${cinema.getName()}</h5>
                        <dl>
                            <dt>Ngày</dt>
                            <dd style="font-size: 1rem; font-weight: bold">${showtime.getDayMonthFormat()}</dd>
                            <dt>Giờ chiếu</dt>
                            <dd style="font-size: 1rem; font-weight: bold">${showtime.getStartTimeFormat24h()}</dd>
                            <dt>Kết thúc</dt>
                            <dd style="font-size: 1rem; font-weight: bold">${showtime.getEndTimeFormat24h()}</dd>
                        </dl>
                        <span class="floating price">${seat.getCode()}</span>
                    </div>
                </div>
                <div class="side back">
                    <div class="top">
                        <div class="span">
                            <h2>Rạp</h2>
                            <span>${cinema.getName()}</span>
                        </div>
                        <div class="span">
                            <h2>Địa chỉ</h2>
                            <span>${cinema.getAddress()}</span>
                        </div>
                        <div class="span span8">
                            <h2>Ghế</h2>
                            <span>${seat.getCode()}</span>
                        </div>
                        <div class="span span4">
                            <h2>Loại ghế</h2>
                            <span>${seat.getType()}</span>
                        </div>
                        <div class="span span8">
                            <h2>Dành cho</h2>
                            <span>${seat.getCapacity()} người</span>
                        </div>
                        <div class="span span4">
                            <h2>Giá vé</h2>
                            <span class="strong">${ticket.getPriceFormat()}</span>
                        </div>
                    </div>

                    <div class="payment bottom">
                        <h1>Kinh phí hạn hẹp nên chưa có chức năng thanh toán. Vui lòng thanh toán tại quầy</h1>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="col-12 m-5 d-flex justify-content-center h1">
        <span style="color: chocolate; font-family: math">
            ENJOY GALAXY xin chân thành cảm ơn!
        </span>
    </div>
</div>
</main>
<%@include file="/WEB-INF/view/common/footer.jsp"%>
</body>
</html>
