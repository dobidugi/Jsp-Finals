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