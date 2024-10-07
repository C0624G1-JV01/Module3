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
    <title>Lỗi</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<header>
    <h1>Cửa Hàng Hoa Quả</h1>
    <nav>
        <ul>
            <li><a href="../index.jsp">Trang Chủ</a></li>
            <li><a href="productList.jsp">Sản Phẩm</a></li>
            <li><a href="contact.jsp">Liên Hệ</a></li>
        </ul>
    </nav>
</header>

<main>
    <h2>Đã xảy ra lỗi!</h2>
    <p>${error}</p>
    <a href="shoppingCart">Quay lại Giỏ Hàng</a>
</main>

<footer>
    <p>&copy; 2024 Cửa Hàng Hoa Quả. Tất cả quyền được bảo lưu.</p>
</footer>
</body>
</html>
