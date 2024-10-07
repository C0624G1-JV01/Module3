<%--
  Created by IntelliJ IDEA.
  User: hieu
  Date: 10/7/2024
  Time: 11:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sửa sản phẩm</title>
</head>
<body>
<h1>Sửa thông tin sản phẩm</h1>

<form action="fruit-shop" method="post">
    <%--@declare id="category_id"--%><%--@declare id="name"--%><%--@declare id="description"--%><%--@declare id="price"--%><%--@declare id="image"--%><input type="hidden" name="action" value="edit">
    <input type="hidden" name="id" value="${product.product_id}">
    <label for="name">Tên sản phẩm:</label>
    <input type="text" name="name" value="${product.name}" required>
    <br>
    <label for="description">Mô tả:</label>
    <input type="text" name="description" value="${product.description}">
    <br>
    <label for="price">Giá:</label>
    <input type="number" step="1.0" name="price" value="${product.price}" required>
    <br>
    <label for="image">Hình ảnh:</label>
    <input type="text" name="image" value="${product.image}">
    <br>
    <label for="category_id">ID danh mục:</label>
    <input type="number" name="category_id" value="${product.category_id}" required>
    <br>
    <input type="submit" value="Cập nhật sản phẩm">
</form>
<a href="fruit-shop">Trở về danh sách sản phẩm</a>
</body>
</html>