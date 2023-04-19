<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>403 - Không có quyền truy cập trang này</title>

    <link href="<c:url value="/resources/css/styles.css"/>" rel="stylesheet" type="text/css"/>
    <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js" crossorigin="anonymous"></script>
</head>

<body>
<!-- Preloader -->
<div class="preloader">
    <div class="cssload-speeding-wheel"></div>
</div>
<section id="wrapper" class="error-page mt-5">
    <div class="error-box">
        <div class="error-body text-center">
            <h1>403</h1>
            <h3 class="text-uppercase">Page Not Found !</h3>
            <p class="text-muted m-t-30 m-b-30">BẠN KHÔNG CÓ QUYỀN TRUY CẬP !</p>
            <a href="<c:url value="/home"/>" class="btn btn-info btn-rounded waves-effect waves-light m-b-40">Back to home</a> </div>
        <footer class="footer text-center">2021 © VU FastTrack Program.</footer>
    </div>
</section>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="<c:url value="/resources/js/scripts.js"/>"></script>
<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
<script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<script src="<c:url value="/resources/assets/demo/datatables-demo.js"/>"></script>
<script src="<c:url value="/resources/assets/demo/chart-area-demo.js"/>"></script>
<script src="<c:url value="/resources/assets/demo/chart-bar-demo.js"/>"></script>
<script src="<c:url value="/resources/assets/demo/chart-pie-demo.js"/>"></script>
</body>

</html>
