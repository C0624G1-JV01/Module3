<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng Nhập - Cửa Hàng Hoa Quả</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <link rel="stylesheet" href="casetudy.css">
</head>
<body>

<div class="container" style="margin-top: 100px;">
    <h2 class="text-center">Đăng Nhập</h2>
    <form action="/Fruitshop?action=login" method="post" class="mt-4">
        <div class="mb-3">
            <label for="username" class="form-label">Tên Đăng Nhập</label>
            <input type="text" class="form-control" id="username" name="username" required>
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Mật Khẩu</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>
        <button type="submit" class="btn btn-primary">Đăng Nhập</button>

        <div class="mt-3 text-danger">
            <c:forEach var="error" items="${errors}">
                <p>${error}</p>
            </c:forEach>
        </div>
    </form>

    <div class="mt-3 text-center">
        <p>Bạn chưa có tài khoản? <a href="/Fruitshop?action=register">Đăng ký ngay</a></p>
    </div>
</div>

<footer class="text-center text-white" style="background-color: #ff7c2a; position: fixed; bottom: 0; width: 100%;">
    <div class="container p-4">
        <h5>Liên Hệ Chúng Tôi</h5>
        <p>Email: contact@fruitshop.com</p>
        <p>Điện thoại: 0123 456 789</p>
        <p>Địa chỉ: 123 Đường Hoa Quả, TP. HCM</p>
    </div>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
