<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh sách sản phẩm</title>
    <link rel="stylesheet" href="styles.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        form {
            display: flex;
            justify-content: center;
            margin-bottom: 20px;
        }
        input[type="text"] {
            padding: 10px;
            margin-right: 10px;
            width: 300px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            padding: 10px 15px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #218838;
        }
        a {
            display: block;
            margin: 10px 0;
            text-align: center;
            color: #007bff;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ddd;
        }
        th {
            background-color: #f8f9fa;
            color: #333;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        img {
            max-width: 50px;
            height: auto;
        }
        .actions a {
            margin-right: 10px;
            color: #007bff;
        }
        .actions a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<h1>Danh sách sản phẩm</h1>
<form method="get" action="fruit-admin">
    <input type="text" name="keyword" placeholder="Tìm kiếm sản phẩm...">
    <input type="submit" name="action" value="Tìm kiếm">
</form>

<a href="fruit-admin?action=create">Thêm sản phẩm mới</a>

<table>
    <tr>
        <th>ID</th>
        <th>Tên sản phẩm</th>
        <th>Mô tả</th>
        <th>Giá</th>
        <th>Hình ảnh</th>
        <th>Thao tác</th>
    </tr>
    <c:if test="${empty products}">
        <tr>
            <td colspan="6" style="text-align: center;">Không có sản phẩm nào.</td>
        </tr>
    </c:if>
    <c:forEach var="product" items="${products}">
        <tr>
            <td><c:out value="${product.product_id}"/></td>
            <td><c:out value="${product.name}"/></td>
            <td><c:out value="${product.description}"/></td>
            <td><c:out value="${product.price}"/> VNĐ</td>
            <td><img src="${product.image}" alt="${product.name}" style="max-width: 100px; max-height: 100px;"></td>
            <td class="actions">
                <a href="/fruit-admin?action=edit&id=${product.product_id}">Sửa</a>
                <a href="/fruit-admin?action=delete&id=${product.product_id}" onclick="return confirm('Bạn có chắc chắn muốn xóa sản phẩm này?');">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="http://localhost:8080/">Trở về trang chủ</a>
</body>
</html>
