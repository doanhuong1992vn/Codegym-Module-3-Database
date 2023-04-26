<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<nav class="navbar navbar-dark h-25">
  <div class="container-fluid">
    <form class="d-flex input-group w-auto" action="${pageContext.request.contextPath}/" method="get">
      <input type="search"
             class="form-control rounded"
             placeholder="Search"
             aria-label="Search"
             aria-describedby="search-addon"
             name="search"
             style="background-color: antiquewhite;"/>
      <span class="input-group-text text-white border-0" id="search-addon">
        <button style="background: #332D2D; border: none">
            <i class="fas fa-search" style="color: antiquewhite"></i>
        </button>
      </span>
    </form>
  </div>
  <div class="nav-item navbar-brand ">
    <c:choose>
      <c:when test="${sessionScope.get('user') == null}">
        <form action="${pageContext.request.contextPath}/login" method="get">
          <div class="nav-item navbar-brand" style="position: absolute; right: 0; top: 0.3vh">
            <button type="submit"
                    class="btn btn-outline-dark"
                    data-mdb-ripple-color="dark"
                    style="background-color: antiquewhite">
              Đăng nhập/Đăng ký
            </button>
          </div>
        </form>
      </c:when>
      <c:when test="${sessionScope.get('user') != null}">
        <div style="left: 50%; transform: translate(-50%); position: absolute; top: 1rem">
                    <span style="color: chocolate;
                    font-family: math; position: absolute; top: -1.2vh;
                    left: 50%; transform: translate(-50%);font-size: 1.8rem;">
                        <span style="font-size: 2.5rem;">ENJOY GALAXY</span>
                        xin chào ${sessionScope.get('user').getFullName()} !
                    </span>
        </div>
        <div class="nav-item navbar-brand" style="position: absolute; right: 0; top: 0.3vh;">
          <form action="${pageContext.request.contextPath}/logout" method="get">
            <button type="submit" class="btn btn-outline-dark" data-mdb-ripple-color="dark"
                    style="background-color: antiquewhite">Đăng xuất khỏi trái đất
            </button>
          </form>
        </div>
      </c:when>
    </c:choose>
  </div>
</nav>

