<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<main>
  <div class="container-fluid">
    <h1 class="mt-4">Thống kê nhân viên</h1>
    <div class="card mb-4">
      <div class="card-header">
        <i class="fas fa-chart-area mr-1"></i>
        Tổng quan nhân viên
      </div>
      <div class="card-body"><canvas id="myAreaChart" width="100%" height="30"></canvas></div>
      <div class="card-footer small text-muted">Đã cập nhật lúc 11:59 PM</div>
    </div>
    <div class="row">
      <div class="col-lg-6">
        <div class="card mb-4">
          <div class="card-header">
            <i class="fas fa-chart-bar mr-1"></i>
            Thống kê người dùng
          </div>
          <div class="card-body"><canvas id="myBarChart" width="100%" height="50"></canvas></div>
          <div class="card-footer small text-muted">Đã cập nhật lúc 11:59 PM</div>
        </div>
      </div>
      <div class="col-lg-6">
        <div class="card mb-4">
          <div class="card-header">
            <i class="fas fa-chart-pie mr-1"></i>
            Thống kê loại quyền
          </div>
          <div class="card-body"><canvas id="myPieChart" width="100%" height="50"></canvas></div>
          <div class="card-footer small text-muted">Đã cập nhật lúc at 11:59 PM</div>
        </div>
      </div>
    </div>
  </div>
</main>