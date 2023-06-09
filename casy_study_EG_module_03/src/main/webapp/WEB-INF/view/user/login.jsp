<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Enjoy Galaxy made by Đoàn Hưởng</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.2.0/mdb.min.css" rel="stylesheet"/>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet"/>
    <style>
        .container {
            position: fixed;
            width: 30%;
            left: 50%;
            top: 20%;
            transform: translate(-50%);
        }
        body {
            background-image: url("https://firebasestorage.googleapis.com/v0/b/module-3-daf70.appspot.com/o/background%2Fbackgound-login.jpg?alt=media&token=b16a4dc8-c450-48de-ba0d-60694b1316ce");
        }
    </style>
</head>
<body>
<%@include file="/WEB-INF/view/common/navbar.jsp"%>
<div class="container">
    <!-- Pills navs -->
    <ul class="nav nav-pills nav-justified mb-3" id="ex1" role="tablist">
        <li class="nav-item" role="presentation">
            <a class="nav-link active btn-dark" id="tab-login" data-mdb-toggle="pill" href="#pills-login" role="tab"
               aria-controls="pills-login" aria-selected="true">Login</a>
        </li>
        <li class="nav-item" role="presentation">
            <a class="nav-link btn-dark" id="tab-register" data-mdb-toggle="pill" href="#pills-register" role="tab"
               aria-controls="pills-register" aria-selected="false">Register</a>
        </li>
    </ul>
    <!-- Pills navs -->

    <!-- Pills content -->
    <div class="tab-content">
        <div class="tab-pane fade show active" id="pills-login" role="tabpanel" aria-labelledby="tab-login">
            <form action="${pageContext.request.contextPath}/logged" method="post">
                <!-- Email or phone number input -->
                <div class="form-outline mb-4">
                    <input required type="text" id="loginName" class="form-control bg-secondary text-white" name="loginName"/>
                    <label class="form-label text-white" for="loginName">Email or phone number</label>
                </div>

                <!-- Password input -->
                <div class="form-outline mb-4">
                    <input required type="password" id="loginPassword" class="form-control bg-secondary text-white" name="password"/>
                    <label class="form-label text-white" for="loginPassword">Password</label>
                </div>

                <!-- Submit button -->
                <button type="submit" class="btn btn-primary btn-block mb-4 btn-light">Sign in</button>

            </form>
        </div>
        <div class="tab-pane fade" id="pills-register" role="tabpanel" aria-labelledby="tab-register">
            <form action="${pageContext.request.contextPath}/register" method="post">
                <!-- Name input -->
                <div class="form-outline mb-4">
                    <input required type="text" id="registerName" class="form-control bg-secondary text-white" name="name"/>
                    <label class="form-label text-white" for="registerName">Name</label>
                </div>

                <!-- Phone Number input -->
                <div class="form-outline mb-4">
                    <input required
                           type="tel"
                           id="registerUsername"
                           class="form-control bg-secondary text-white"
                           name="phoneNumber"
                           pattern="^(84|0[3|5|7|8|9])+([0-9]{8})$"
                           title="Nhập đúng định dạng SĐT 10 số"/>
                    <label class="form-label text-white" for="registerUsername">Phone Number</label>
                </div>

                <!-- Email input -->
                <div class="form-outline mb-4">
                    <input required type="email" id="registerEmail" class="form-control bg-secondary text-white" name="email" placeholder="example@gmail.com"/>
                    <label class="form-label text-white" for="registerEmail">Email</label>
                </div>

                <!-- Password input -->
                <div class="form-outline mb-4">
                    <input required type="password" id="registerPassword" class="form-control bg-secondary text-white" name="password"/>
                    <label class="form-label text-white" for="registerPassword">Password</label>
                </div>

                <!-- Submit button -->
                <button type="submit" class="btn btn-primary btn-block mb-3 btn-light">Register</button>
            </form>
        </div>
    </div>
    <c:if test="${message != null}">
        <p class="bg-danger text-white">${message}</p>
    </c:if>
</div>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.2.0/mdb.min.js"></script>
</body>
</html>
