CREATE DATABASE test;

CREATE TABLE Product
(
    product_id int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    product_name VARCHAR(20) NOT NULL,
    product_price int(10) NOT NULL,
    product_count int(10) NOT NULL,
    product_delivery int(10) NOT NULL,
    product_delete boolean NOT NULL default FALSE,
    product_img VARCHAR(20) NOT NULL

)default character set utf8 collate utf8_general_ci;




CREATE TABLE User
(
    id int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    userid VARCHAR(20) NOT NULL,
    name varchar(10) NOT NULL,
    password varchar(30) NOT NULL,
    phone varchar(20) NOT NULL,
    address varchar(100) NOT NULL,
    money int(10) NOT NULL default 0
)default character set utf8 collate utf8_general_ci;

CREATE TABLE `OrderList`
(
    order_id int(10) NOT NULL AUTO_INCREMENT,
    user_id int(10) NOT NULL,
    product_id int(10) NOT NULL,

    order_time DATETIME NOT NULL,
    PRIMARY KEY (order_id, user_id, product_id),
    FOREIGN KEY (user_id) REFERENCES User(id),
    FOREIGN KEY (product_id) REFERENCES  Product(product_id)
)default character set utf8 collate utf8_general_ci;




# Dum Data

insert into user (userid, name, password, phone, address, money) value("testid", "김테스트", "1234", "010-1245-5678", "인천시 부평구 말똥구", 100000);


INSERT INTO Product
(product_name, product_count, product_price, product_delivery, product_img)
VALUES ("달걀", 30, 4900, 2500, "1");

INSERT INTO Product
(product_name, product_count, product_price, product_delivery, product_img)
VALUES ("팩우유", 30, 11900, 2500, "pack_milk");

INSERT INTO Product
(product_name, product_count, product_price, product_delivery, product_img)
VALUES ("팩우유", 15, 19400, 0, "pet_pad");

INSERT INTO Product
(product_name, product_count, product_price, product_delivery, product_img)
VALUES ("샴푸", 4, 15000, 0, "shampoo");

INSERT INTO Product
(product_name, product_count, product_price, product_delivery, product_img)
VALUES ("강아지 장난감", 100, 9000, 0, "dog_toy");