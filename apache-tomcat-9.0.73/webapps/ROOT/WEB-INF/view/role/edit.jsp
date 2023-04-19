<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<main>
  <div class="container-fluid">
    <h1 class="mt-4">Sửa thông tin loại quyền</h1>
    <div class="card mb-4">
      <div class="card-header">
        <i class="fas fa-table mr-1"></i> Sửa thông tin loại quyền
      </div>
      <div class="card-body">
        <form action="<c:url value="/role/edit"/>" method="post">
          <div class="row">
            <div class="col-md-6">
              <div class="form-group">
                <input type="hidden" name="id" value="${role.id}"
                       class="form-control" />
              </div>
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