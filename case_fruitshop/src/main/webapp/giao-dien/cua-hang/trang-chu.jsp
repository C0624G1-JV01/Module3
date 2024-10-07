<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cửa Hàng Hoa Quả</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <link rel="stylesheet" href="casetudy.css">
</head>
<body>

<header style="background-color: #ffd2ab;">
    <div class="container d-flex align-items-center justify-content-between fixed-top" style="top: 0;">
        <a href="/Fruitshop?action=home">
            <img src="https://free.vector6.com/wp-content/uploads/2020/07/KhoThietKe-0000000184.jpg" alt="Logo" class="logo" style="height: 80px;">
        </a>
        <form class="d-flex ms-3" action="/fruit-shop" method="get">
            <input class="form-control me-2" type="search" name="keyword" placeholder="Tìm sản phẩm" aria-label="Search">
            <button class="btn btn-outline-light" style="color: lavenderblush; background: #ff7c2a;" type="submit" name="action" value="search">Tìm</button>
        </form>

        <div class="user-cart ms-3">
            <a href="/fruitshop?action=viewCart" class="btn btn-warning position-relative">
                <i class="fas fa-shopping-cart"></i> Giỏ Hàng
                <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                    <c:out value="${sessionScope.cartSize != null ? sessionScope.cartSize : 0}"/>
                </span>
            </a>
        </div>

        <div class="user-options ms-3">
            <c:if test="${not empty sessionScope.currentUser}">
                <span>Xin chào, ${sessionScope.currentUser.name}!</span>
                <div class="dropdown">
                    <button class="btn btn-light dropdown-toggle" type="button" id="settingsDropdown" data-bs-toggle="dropdown" aria-expanded="false">
                        Cài đặt
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="settingsDropdown">
                        <li><a class="dropdown-item" href="/Fruitshop?action=edit">Sửa thông tin</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="/Fruitshop?action=logout">Đăng xuất</a></li>
                    </ul>
                </div>
            </c:if>

            <c:if test="${empty sessionScope.currentUser}">
                <button class="btn btn-primary" onclick="window.location.href='/Fruitshop?action=login'">Đăng nhập</button>
            </c:if>
        </div>
    </div>
</header>

<nav class="navbar navbar-expand-lg navbar-light bg-light" style="margin-top: 100px;">
    <div class="container-fluid justify-content-center">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav mx-auto">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">Sản Phẩm</a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#">Trái Cây</a></li>
                        <li><a class="dropdown-item" href="#">Giỏ Trái Cây</a></li>
                        <li><a class="dropdown-item" href="#">Hoa Quả Nhập Khẩu</a></li>
                        <li><a class="dropdown-item" href="#">Hoa Quả Sấy</a></li>
                        <li><a class="dropdown-item" href="#">Hoa Quả Tươi</a></li>
                    </ul>
                </li>
                <li class="nav-item"><a class="nav-link" href="#">Giới Thiệu</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Tin Tức</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Liên Hệ</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="banner text-center text-white py-5">
    <div class="container">
        <div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active" data-bs-interval="2000">
                    <img src="https://tfruit.com.vn/wp-content/uploads/2023/04/Voucher-50k.jpg" class="d-block w-100" alt="Voucher 50k">
                </div>
                <div class="carousel-item" data-bs-interval="2000">
                    <img src="https://tfruit.com.vn/wp-content/uploads/2020/11/GV2-1.jpg" class="d-block w-100" alt="Hình ảnh sản phẩm 2">
                </div>
                <div class="carousel-item" data-bs-interval="2000">
                    <img src="https://www.thietkewebchuanseo.com/images/bai-viet-quang-cao-ban-trai-cay-4942.jpg" class="d-block w-100" alt="Hình ảnh sản phẩm 3">
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
    </div>
</div>

<div class="container mt-5">
    <h3 class="text-center mb-5">Sản Phẩm Nổi Bật</h3>
    <div class="row">
        <c:forEach var="product" items="${products}">
            <div class="col-lg-3 col-md-4 col-sm-6 mb-4">
                <div class="card shadow-sm">
                    <img src="${product.image}" alt="${product.name}" class="card-img-top" style="max-height: 200px;">
                    <div class="card-body">
                        <h5 class="card-title"><c:out value="${product.name}"/></h5>
                        <p class="card-text"><c:out value="${product.description}"/></p>
                        <p class="text-danger"><c:out value="${product.price}"/> VND</p>
                        <div class="actions">
                            <a href="fruit-shop?action=search&id=${product.product_id}" class="btn btn-info">Xem</a>
                            <a href="fruit-shop?action=add&id=${product.product_id}" class="btn btn-success" onclick="return confirm('Bạn có chắc chắn muốn mua sản phẩm này?');">Mua</a>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<footer class="text-center text-white" style="background-color: #ff7c2a;">
    <div class="container p-4">
        <h5>Liên Hệ Chúng Tôi</h5>
        <p>Email: contact@fruitshop.com</p>
        <p>Điện thoại: 0123 456 789</p>
        <p>Địa chỉ: 123 Đường Hoa Quả, TP. HCM</p>
    </div>
    <div class="contact-links">
        <a href="mailto:contact@fruitshop.com" class="contact-item">
            <i class="fas fa-envelope"></i>
        </a>
        <a href="tel:0123456789" class="contact-item">
            <i class="fas fa-phone"></i>
        </a>
        <a href="https://www.facebook.com/messages/e2ee/t/7946518635382626?locale=vi_VN" class="contact-item">
            <i class="fab fa-facebook"></i>
        </a>
    </div>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
