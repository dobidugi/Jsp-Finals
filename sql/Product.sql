CREATE TABLE Product
(
    product_id int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    product_name VARCHAR(20) NOT NULL,
    product_price int(10) NOT NULL,
    product_count int(10) NOT NULL,
    product_delivery int(10) NOT NULL,
    product_delete boolean NOT NULL,
    product_img VARCHAR(20) NOT NULL

)default character set utf8 collate utf8_general_ci;