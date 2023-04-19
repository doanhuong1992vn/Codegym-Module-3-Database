<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<main>
    <div class="container-fluid">
        <h1 class="mt-4">Quản lý phân quyền</h1>
        <div class="card mb-4">
            <div class="card-header">
                <i class="fas fa-table mr-1"></i>
                Danh sách phân quyền
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                        <tr>
                            <th>Mã quyền</th>
                            <th>Tên quyền</th>
                            <th>Mô tả quyền</th>
                            <th>#</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${roles}" var="role">
                            <tr>
                                <td>${role.id}</td>
                                <td>${role.name}</td>
                                <td>${role.description}</td>
                                <td>
                                    <a href="<c:url value="/role/detail"/>?id=${role.id}" class="btn btn-sm btn-success">
                                        <i class="fas fa-file-alt"></i> Xem
                                    </a>
                                    <a href="<c:url value="/role/edit"/>?id=${role.id}" class="btn btn-sm btn-primary">
                                        <i class="fas fa-pen-square"></i> Sửa
                                    </a>
                                    <a href="<c:url value="/role/remove"/>?id=${role.id}" class="btn btn-sm btn-danger">
                                        <i class="fas fa-trash"></i> Xóa
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div class="text-right" style="padding-top: 5px;">
                        <a class="btn btn-secondary" href="<c:url value="/roles"/>">Quay lại</a>
                        <a href="<c:url value="/role/add"/>" class="btn btn-primary">Thêm mới</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>