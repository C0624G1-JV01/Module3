CREATE DATABASE case_module3;
USE case_module3;

-- Bảng cho vai trò người dùng
CREATE TABLE user_role (
                           role_id INT PRIMARY KEY AUTO_INCREMENT,
                           role_name VARCHAR(30) NOT NULL UNIQUE
);

INSERT INTO user_role (role_name) VALUES ('người dùng'), ('quản lý');

-- Bảng người dùng để lưu trữ thông tin cơ bản
CREATE TABLE user (
                      user_id INT PRIMARY KEY AUTO_INCREMENT,
                      name VARCHAR(100),

                      email VARCHAR(50) UNIQUE,
                      phone VARCHAR(30),
                      role_id INT,
                      FOREIGN KEY (role_id) REFERENCES user_role(role_id)
);

INSERT INTO user (name, email, phone, role_id) VALUES
                                                                        ('hiếu',  'hdsshf@gmail.com', '01212271', 1),
                                                                        ('tuyết',  'sadgk@gmail.com', '123129412', 1),
                                                                        ('nguyên', 'fjsgjg@gmail.com', '3123112', 2);

-- Bảng tài khoản để lưu trữ tên đăng nhập và mật khẩu
CREATE TABLE account (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         user_id INT UNIQUE,
                         username VARCHAR(50) NOT NULL UNIQUE,
                         password VARCHAR(255) NOT NULL,
                         FOREIGN KEY (user_id) REFERENCES user(user_id) ON DELETE CASCADE
);
insert into account (user_id, username, password) VALUES (1,'hieushoping','123123asd'),
                                                         (2,'hasadsd','123123123'),
                                                         (3,'quanlycuahang','123123asd');

-- Bảng danh mục sản phẩm
CREATE TABLE product_category (
                                  category_id INT PRIMARY KEY AUTO_INCREMENT,
                                  name VARCHAR(100) NOT NULL,
                                  description VARCHAR(255)
);
insert into product_category (name, description) values ('trái cây','hàng organic'),
                                                        ('hoa quả nhập khẩu ','nhập từ nước ngoài'),
                                                        ('giỏ trái cây','phù hợp cho tặng biếu'),
                                                        ('hoa quả sấy','ko chất bảo quản');




-- Bảng sản phẩm
CREATE TABLE product (
                         product_id INT PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(70) NOT NULL,
                         description VARCHAR(255),
                         price DECIMAL(10, 2) NOT NULL,
                         image VARCHAR(100),
                         category_id INT,
                         FOREIGN KEY (category_id) REFERENCES product_category(category_id)
);
insert into product (name, description, price, image, category_id) values ('cam','hàng hái từ vườn','40000','...',1),
                                                                          ('dâu tây','nhập từ mỹ tho','120000','...',2),
                                                                          ('dưa lưới','còn hàng','80000','...',1),
                                                                          ('dưa gang','còn hàng','80000','...',1),
                                                                          ('boom','còn hàng','80000','...',1),
                                                                          ('kiwwi','nhập khẩu','80000','...',2);




-- Bảng giỏ hàng
CREATE TABLE shopping_cart (
                               shopping_cart_id INT PRIMARY KEY AUTO_INCREMENT,
                               total_price DECIMAL(10, 2),
                               date DATETIME,
                               address VARCHAR(100),
                               user_id INT,
                               status VARCHAR(20),
                               FOREIGN KEY (user_id) REFERENCES user(user_id)
);
insert into shopping_cart (total_price, date, address, user_id, status) values ('112000','2024-12-01','quảng trị',1,' gửi i trong ngày'),
                                                                               ('122000','2024-09-20','huế',2,' gửi i trong ngày'),
                                                                               ('222000','2024-03-23','quảng bình',1,' gửi i trong ngày'),
                                                                               ('422000','2024-10-14','quảng trị',2,' gửi i trong ngày'),
                                                                               ('1232000','2024-11-11','quảng nam',1,' gửi i trong ngày'),
                                                                               ('12000','2024-08-01','quảng trị',2,' gửi i trong ngày');


-- Bảng mặt hàng trong giỏ hàng
CREATE TABLE shopping_cart_item (
                                    id INT PRIMARY KEY AUTO_INCREMENT,
                                    shopping_cart_id INT,
                                    product_id INT,
                                    quantity INT,
                                    FOREIGN KEY (shopping_cart_id) REFERENCES shopping_cart(shopping_cart_id) ON DELETE CASCADE,
                                    FOREIGN KEY (product_id) REFERENCES product(product_id)
);
insert into shopping_cart_item (shopping_cart_id, product_id, quantity) values (7,2,4),
                                                                               (8,3,2),
                                                                               (9,3,1),
                                                                               (9,1,5);

-- Bảng đơn hàng
CREATE TABLE orders (
                        order_id INT PRIMARY KEY AUTO_INCREMENT,
                        user_id INT,
                        shopping_cart_id INT,
                        total_price DECIMAL(10, 2),
                        order_date DATETIME,
                        status VARCHAR(20),
                        FOREIGN KEY (user_id) REFERENCES user(user_id),
                        FOREIGN KEY (shopping_cart_id) REFERENCES shopping_cart(shopping_cart_id)
);
insert into orders (user_id, shopping_cart_id, total_price, order_date, status) values (1,8,'210000','2024-10-02','hàng dễ hư '),
                                                                                       (2,7,'110000','2024-08-02','hàng dễ hư '),
                                                                                       (2,9,'310000','2024-12-02','hàng dễ hư'),
                                                                                       (2,8,'110000','2024-11-02','hàng dễ hư '),
                                                                                       (1,12,'150000','2024-09-02','hàng dễ hư '),
                                                                                       (1,10,'120000','2024-09-02','hàng dễ hư ');

-- Bảng thanh toán
CREATE TABLE payment (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         date DATETIME,
                         method_payment VARCHAR(100),
                         shopping_cart_id INT,
                         user_id INT,
                         total_price DECIMAL(10, 2),
                         transaction_id VARCHAR(50),
                         FOREIGN KEY (shopping_cart_id) REFERENCES shopping_cart(shopping_cart_id) ON DELETE CASCADE,
                         FOREIGN KEY (user_id) REFERENCES user(user_id)
);
insert into payment(date, method_payment, shopping_cart_id, user_id, total_price, transaction_id) values ('2023-11-12','trực tiếp',9,1,'170000',1),
                                                                                                         ('2024-01-12','trực tiếp',9,2,'210000',2),
                                                                                                         ('2023-12-12','trực tiếp',9,2,'160000',3),
                                                                                                         ('2024-09-12','bankking',9,1,'212000',4);


-- Bảng vận chuyển
CREATE TABLE shipping (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          address VARCHAR(100),
                          date DATETIME,
                          total_price DECIMAL(10, 2),
                          order_id INT,
                          FOREIGN KEY (order_id) REFERENCES orders(order_id) ON DELETE CASCADE
);
insert into shipping (address, date, total_price, order_id) VALUES ('đông hà','2024-12-13','240000',6),
                                                                   ('huế','2024-12-13','240000',1),
                                                                   ('quảng bình','2024-12-13','240000',2),
                                                                   ('quảng trị ','2024-12-13','240000',3),
                                                                   ('huế','2024-12-13','240000',2),
                                                                   ('quảng bình','2024-12-13','240000',4),
                                                                   ('đông hà','2024-12-13','240000',1);