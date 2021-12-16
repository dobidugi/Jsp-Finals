CREATE TABLE User
(
    id int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    userid VARCHAR(20) NOT NULL,
    name varchar(10) NOT NULL,
    password varchar(30) NOT NULL,
    phone varchar(20) NOT NULL,
    address varchar(100) NOT NULL,
    money int(10) NOT NULL
)default character set utf8 collate utf8_general_ci;