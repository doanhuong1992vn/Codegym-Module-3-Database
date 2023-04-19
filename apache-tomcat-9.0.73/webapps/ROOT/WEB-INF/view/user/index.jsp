<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<main>
    <div class="container-fluid">
        <h1 class="mt-4">Quản lý nhân viên</h1>
        <div class="card mb-4">
            <div class="card-header">
                <i class="fas fa-table mr-1"></i>
                Danh sách nhân viên
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%">
                        <thead>
                        <tr>
                            <th>Mã số</th>
                            <th>Tài khoản</th>
                            <th>Thư điện tử</th>
                            <th>Họ tên</th>
                            <th>Địa chỉ</th>
                            <th>Điện thoại</th>
                            <th>Ảnh đại diện</th>
                            <th>Đang hoạt động?</th>
                            <th>Loại quyền</th>
                            <th>#</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${users}" var="user">
                            <tr>
                                <td>${user.id}</td>
                                <td>${user.username}</td>
                                <td>${user.email}</td>
                                <td>${user.fullname}</td>
                                <td>${user.address}</td>
                                <td>${user.phone}</td>
                                <td>${user.avatar}</td>
                                <td>${user.activated}</td>
                                <td>${user.roleDesc}</td>
                                <td>
                                    <a href="<c:url value="/user/detail"/>?id=${user.id}" class="btn btn-sm btn-success">
                                        <i class="fas fa-file-alt"></i> Xem
                                    </a>
                                    <a href="<c:url value="/user/edit"/>?id=${user.id}" class="btn btn-sm btn-primary">
                                        <i class="fas fa-pen-square"></i> Sửa
                                    </a>
                                    <a href="<c:url value="/user/remove"/>?id=${user.id}" class="btn btn-sm btn-danger">
                                        <i class="fas fa-trash"></i> Xóa
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div class="text-right" style="padding-top: 5px;">
                        <a class="btn btn-secondary" href="<c:url value="/users"/>">Quay lại</a>
                        <a href="<c:url value="/user/add"/>" class="btn btn-primary">Thêm mới</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>