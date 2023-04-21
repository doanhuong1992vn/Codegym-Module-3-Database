<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Enjoy Galaxy</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        input:checked {
            color: green;
        }
    </style>
</head>
<body>
<form action="" method="get">
    <table>
        <c:forEach items='${requestScope.get("seats")}' var="row">
            <tr>
                <c:forEach items='${row}' var="seat">
                    <td>
                        <label for="${seat.getId()}" ><input type="checkbox" id="${seat.getId()}" autocomplete="off"> ${seat.getCode()}</label>
                        <div class="btn-group btn-group-toggle" data-toggle="buttons">
                            <label class="btn btn-secondary ">
                                <input type="checkbox" id="${seat.getId()}" autocomplete="off"> ${seat.getCode()}
                            </label>
                        </div>
                    </td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>
</form>
<script>

</script>
</body>
</html>