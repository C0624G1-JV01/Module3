<%--
  Created by IntelliJ IDEA.
  User: hieu
  Date: 10/7/2024
  Time: 9:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng Ký Tài Khoản</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <h2 class="text-center">Đăng Ký Tài Khoản</h2>

    <!-- Hiển thị thông báo lỗi hoặc thành công -->
    <c:if test="${not empty requestScope.error}">
        <div class="alert alert-danger">${requestScope.error}</div>
    </c:if>
    <c:if test="${not empty requestScope.message}">
        <div class="alert alert-success">${requestScope.message}</div>
    </c:if>

    <form action="/Fruitshop?action=register" method="post">
        <div class="mb-3">
            <label for="name" class="form-label">Họ Tên</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="email" class="form-control" id="email" name="email" required>
        </div>
        <div class="mb-3">
            <label for="phone" class="form-label">Số Điện Thoại</label>
            <input type="text" class="form-control" id="phone" name="phone" required>
        </div>
        <div class="mb-3">
            <label for="regUsername" class="form-label">Tên Đăng Nhập</label>
            <input type="text" class="form-control" id="regUsername" name="regUsername" required>
        </div>
        <div class="mb-3">
            <label for="regPassword" class="form-label">Mật Khẩu</label>
            <input type="password" class="form-control" id="regPassword" name="regPassword" required>
        </div>
        <button type="submit" class="btn btn-primary">Đăng Ký</button>
    </form>
    <p class="mt-3">Đã có tài khoản? <a href="/Fruitshop?action=login">Đăng nhập tại đây</a>.</p>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
