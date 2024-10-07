<%--
  Created by IntelliJ IDEA.
  User: hieu
  Date: 10/7/2024
  Time: 6:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm Giỏ Hàng</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<header>
    <h1>Cửa Hàng Hoa Quả</h1>
</header>

<main>
    <h2>Thêm Giỏ Hàng Mới</h2>
    <form action="shoppingCart" method="post">
        <input type="hidden" name="action" value="add">
        <div>
            <label for="total_price">Giá Tổng:</label>
            <input type="number" id="total_price" name="total_price" required>
        </div>
        <div>
            <label for="user_id">ID Người Dùng:</label>
            <input type="number" id="user_id" name="user_id" required>
        </div>
        <div>
            <label for="address">Địa Chỉ:</label>
            <input type="text" id="address" name="address" required>
        </div>
        <button type="submit">Thêm</button>
        <a href="shoppingCart">Quay lại Giỏ Hàng</a>
    </form>
</main>

<footer>
    <p>&copy; 2024 Cửa Hàng Hoa Quả. Tất cả quyền được bảo lưu.</p>
</footer>
</body>
</html>
