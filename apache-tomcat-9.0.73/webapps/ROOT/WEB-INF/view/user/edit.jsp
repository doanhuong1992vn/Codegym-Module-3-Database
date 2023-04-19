<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<main>
  <div class="container-fluid">
    <h1 class="mt-4">Sửa thông tin nhân viên</h1>
    <div class="card mb-4">
      <div class="card-header">
        <i class="fas fa-table mr-1"></i> Sửa thông tin nhân viên
      </div>
      <div class="card-body">
        <form action="<c:url value="/user/edit"/>" method="post">
          <div class="row">
            <div class="col-md-6">
              <div class="form-group">
                <input type="hidden" name="id" value="${user.id}"
                       class="form-control" />
              </div>
              <div class="form-group">
                <label>Thư điện tử</label> <input type="text" name="email"
                                                  value="${user.email}" class="form-control" />
              </div>
              <div class="form-group">
                <label>Tài khoản</label> <input type="text" name="username"
                                                value="${user.username}" class="form-control" />
              </div>
              <div class="form-group">
                <label>Mật khẩu</label> <input type="password" name="password"
                                               value="${user.password}" class="form-control"/>
              </div>
              <div class="form-group">
                <label>Họ tên</label> <input type="text" name="fullname"
                                             value="${user.fullname}" class="form-control" />
              </div>
              <div class="form-group">
                <label>Địa chỉ</label> <input type="text" name="address"
                                              value="${user.address}" class="form-control" />
              </div>
              <div class="form-group">
                <label>Điện thoại</label> <input type="text" name="phone"
                                                 value="${user.phone}" class="form-control" />
              </div>
              <div class="form-group">
                <label>Ảnh đại diện</label> <input type="text" name="avatar"
                                                   value="${user.avatar}" class="form-control" />
              </div>
              <div class="form-group">
                <label>Đang hoạt động?</label><br>
                <select name="activated">
                  <option value="true">Có</option>
                  <option value="false">Không</option>
                </select>
              </div>
              <div class="form-group">
                <label>Loại quyền</label><br>
                <select name="roleId">
                  <c:forEach items="${roles}" var="role">
                    <option value="${role.id}">${role.description}</option>
                  </c:forEach>
                </select>
              </div>
            </div>
            <div class="col-12 mt-3">
              <div class="form-group">
                <a class="btn btn-secondary"
                   href="<c:url value="/users"/>">Quay lại</a>
                <button type="submit" class="btn btn-success">Lưu lại</button>
              </div>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</main>