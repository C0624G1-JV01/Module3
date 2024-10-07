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
  <title>Giỏ Hàng</title>
  <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<header>
  <h1>Cửa Hàng Hoa Quả</h1>
  <nav>
    <ul>
      <li><a href="">Trang Chủ</a></li>
      <li><a href="">Sản Phẩm</a></li>
      <li><a href="">Liên Hệ</a></li>
    </ul>
  </nav>
</header>

<main>
  <h2>Giỏ Hàng</h2>
  <table>
    <tr>
      <th>ID</th>
      <th>Giá Tổng</th>
      <th>ID Người Dùng</th>
      <th>Địa Chỉ</th>
      <th>Trạng Thái</th>
      <th>Hành Động</th>
    </tr>
    <c:forEach var="cart" items="${carts}">
      <tr>
        <td>${cart.shopping_cart_id}</td>
        <td>${cart.total_price}</td>
        <td>${cart.user_id}</td>
        <td>${cart.address}</td>
        <td>${cart.status}</td>
        <td>
          <a href="shoppingCart?action=update&id=${cart.shopping_cart_id}">Cập Nhật</a>
          <a href="shoppingCart?action=delete&id=${cart.shopping_cart_id}" onclick="return confirm('Bạn có chắc chắn muốn xóa?');">Xóa</a>
        </td>
      </tr>
    </c:forEach>
  </table>
  <a href="addCart.jsp">Thêm Giỏ Hàng Mới</a>
</main>

<footer>
  <p>&copy; 2024 Cửa Hàng Hoa Quả. Tất cả quyền được bảo lưu.</p>
</footer>
</body>
</html>
