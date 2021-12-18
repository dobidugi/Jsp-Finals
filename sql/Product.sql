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


# Dum Data
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