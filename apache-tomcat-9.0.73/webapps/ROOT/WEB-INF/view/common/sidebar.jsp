<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="layoutSidenav_nav">
  <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
    <div class="sb-sidenav-menu">
      <div class="nav">
        <a class="nav-link" href="<c:url value="/home"/>">
          <div class="sb-nav-link-icon">
            <i class="fas fa-chart-area mr-1"></i>
            Thống kê nhân viên
          </div>
        </a>
        <a class="nav-link" href="<c:url value="/users"/>">
          <div class="sb-nav-link-icon">
            <i class="fas fa-user-alt"></i>
            Quản lý nhân viên
          </div>
        </a>
        <a class="nav-link" href="<c:url value="/roles"/>">
          <div class="sb-nav-link-icon">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-shield-fill-check" viewBox="0 0 16 16">
              <path fill-rule="evenodd" d="M8 0c-.69 0-1.843.265-2.928.56-1.11.3-2.229.655-2.887.87a1.54 1.54 0 0 0-1.044 1.262c-.596 4.477.787 7.795 2.465 9.99a11.777 11.777 0 0 0 2.517 2.453c.386.273.744.482 1.048.625.28.132.581.24.829.24s.548-.108.829-.24a7.159 7.159 0 0 0 1.048-.625 11.775 11.775 0 0 0 2.517-2.453c1.678-2.195 3.061-5.513 2.465-9.99a1.541 1.541 0 0 0-1.044-1.263 62.467 62.467 0 0 0-2.887-.87C9.843.266 8.69 0 8 0zm2.146 5.146a.5.5 0 0 1 .708.708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 1 1 .708-.708L7.5 7.793l2.646-2.647z"/>
            </svg>
            Quản lý phân quyền
          </div>
        </a>
        <a class="nav-link" href="<c:url value="/logout"/>">
          <div class="sb-nav-link-icon">
            <i class="fas fa-door-open"></i>
            Đăng xuất chương trình
          </div>
        </a>
      </div>
    </div>
    <div class="sb-sidenav-footer">
      <div class="small">Đã đăng nhập bởi:</div>
      CG Admin
    </div>
  </nav>
</div>