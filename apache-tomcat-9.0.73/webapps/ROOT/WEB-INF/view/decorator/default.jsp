<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="dec" %>

<c:set var="commonUrl" value="/WEB-INF/view/common"/>

<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <title>
    <dec:title>Quản lý nhân viên</dec:title>
  </title>
  <link rel="stylesheet" href="<c:url value="/resources/css/styles.css"/>" type="text/css"/>
  <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
  <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
<!-- Start NavBar -->
<jsp:include page="${commonUrl}/navbar.jsp"></jsp:include>
<!-- End NavBar -->

<div id="layoutSidenav">
  <!-- Start SideBar -->
  <jsp:include page="${commonUrl}/sidebar.jsp"></jsp:include>
  <!-- End SideBar -->

  <div id="layoutSidenav_content">
    <!-- Start Content -->
    <dec:body></dec:body>
    <!-- End Content -->

    <!-- Start Footer -->
    <jsp:include page="${commonUrl}/footer.jsp"></jsp:include>
    <!-- End Footer -->
  </div>
</div>
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
