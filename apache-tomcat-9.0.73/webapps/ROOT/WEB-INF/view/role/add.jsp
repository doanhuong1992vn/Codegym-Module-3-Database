<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<main>
  <div class="container-fluid">
    <h1 class="mt-4">Thêm loại quyền mới</h1>
    <div class="card mb-4">
      <div class="card-header">
        <i class="fas fa-table mr-1"></i> Thêm loại quyền mới
      </div>
      <div class="card-body">
        <form action="<c:url value="/role/add"/>" method="post">
          <div class="row">
            <div class="col-md-6">
              <div class="form-group">
                <label>Tên quyền</label> <input type="text" name="name"
                                                value="${role.name}" class="form-control" />
              </div>
              <div class="form-group">
                <label>Mô tả quyền</label> <input type="text" name="description"
                                                  value="${role.description}" class="form-control" />
              </div>
            </div>
            <div class="col-12 mt-3">
              <div class="form-group">
                <a class="btn btn-secondary"
                   href="<c:url value="/roles"/>">Quay lại</a>
                <button type="submit" class="btn btn-success">Lưu lại</button>
              </div>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</main>