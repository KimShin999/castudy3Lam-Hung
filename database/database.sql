CREATE DATABASE ice_cream_shop;
use ice_cream_shop;

CREATE TABLE users(
user_id int primary key auto_increment,
user_name varchar(100) NOT NULL,
user_password varchar(100) NOT NULL,
user_email varchar(225) NOT NULL
);

CREATE TABLE category(
category_id int primary Key auto_increment,
category_name varchar(100) NOT NULL
);

CREATE TABLE ice_cream(
ice_cream_id int PRIMARY KEY auto_increment,
category_id int,
name varchar(255) NOT NULL,
discount int,
ice_description text,
price double(10,3) NOT NULL,
scr text,
sold_quantity int,
foreign key (category_id) references category(category_id)
 );
 
 CREATE TABLE orders(
 order_id int primary key auto_increment,
 name_customer varchar(50), 
 address_customer varchar(200),
 numberphone_customer varchar(20),
 total_money double(10,3)
 );
 
 CREATE TABLE item(
 item_id int primary key auto_increment,
 order_id int ,
 ice_cream_id int,
 pice_discount double(10,3) NOT NULL,
 quality int NOT NULL,
 total_money double (10,3)
 foreign key (order_id) references orders (order_id),
 foreign key (ice_cream_id) references ice_cream(ice_cream_id)
 );

--PROCEDURE

DELIMITER $$
CREATE PROCEDURE get_ice_cream_by_category(IN category__id INT)
BEGIN
    SELECT ice_cream.ice_cream_id, ice_cream.category_id ,ice_cream.name ,ice_cream.discount, ice_cream.ice_description, ice_cream.price, ice_cream.sold_quantity, ice_cream.src
    FROM ice_cream
    join category on ice_cream.category_id = category.category_id
	where ice_cream.category_id = category__id;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE sort_ice_cream_by_price()
begin
	SELECT ice_cream.ice_cream_id, ice_cream.category_id ,ice_cream.name ,ice_cream.discount, ice_cream.ice_description, ice_cream.price, ice_cream.sold_quantity, ice_cream.src
	FROM ice_cream
    ORDER BY ice_cream.price;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE sort_ice_cream_by_quantity()
begin
	SELECT ice_cream.ice_cream_id, ice_cream.category_id ,ice_cream.name ,ice_cream.discount, ice_cream.ice_description, ice_cream.price, ice_cream.sold_quantity, ice_cream.src
	FROM ice_cream
    ORDER BY ice_cream.sold_quantity;
END $$
DELIMITER ;

DELIMITER $$

DELIMITER $$
CREATE procedure update_IceCream(in ice_cream_id int, in category_id int,in name varchar(255),in discount int, in ice_description text, in price double(10,3), in scr text, in sold_quantity int)
BEGIN
UPDATE ice_cream
SET category_id = category_id, name = name, discount = discount, ice_description = ice_description, price = price, sold_quantity = sold_quantity, scr = scr
WHERE ice_cream_id = ice_cream_id;
END $$
DELIMITER $$


DELIMITER //
CREATE procedure insert_IceCream(in category_id int,in name varchar(255),in discount int,
in ice_description text, in price double(10,3), in scr text, in sold_quantity int)
BEGIN
INSERT INTO ice_cream(category_id,name,discount,ice_description,price,src,sold_quantity)
VALUES (category_id,name,discount,ice_description,price,src,sold_quantity);
END //
DELIMITER //


DELIMITER //
CREATE PROCEDURE select_all_ice()
BEGIN
SELECT * FROM ice_cream;
END //
DELIMITER //


DELIMITER //
CREATE procedure delete_ice(in id int)
BEGIN
delete from ice_cream where ice_cream.ice_cream_id = id;
END //
DELIMITER //


DELIMITER //
CREATE procedure search_ice_cream_by_id(in id int)
BEGIN
SELECT ice_cream.ice_cream_id, ice_cream.category_id ,ice_cream.name ,ice_cream.discount, ice_cream.ice_description, ice_cream.price, ice_cream.sold_quantity, ice_cream.src
FROM ice_cream
Where ice_cream.ice_cream_id = id;
END //
DELIMITER //

//new
DELIMITER //
CREATE PROCEDURE select_all_ice_by_status()
BEGIN
SELECT * FROM ice_cream
where ice_cream.status = 0;
END //
DELIMITER //

//new
DELIMITER //
CREATE procedure delete_ice_status(in id int)
BEGIN
update ice_cream
set ice_cream.status = 1
where ice_cream.ice_cream_id=id;
END //
DELIMITER //

SELECT * FROM ice_cream_shop.users;


DELIMITER $$
CREATE procedure search_User(in name varchar(100))
BEGIN
SELECT users.user_id, users.user_name, users.user_password, users.user_email
FROM users
WHERE users.user_name = name;
END $$
DELIMITER $$

Call search_User('nguyenduclam196')

DELIMITER $$
CREATE PROCEDURE insert_item(order_id int, ice_cream_id int, pice_discount double, quality int, total_money double)
BEGIN
    INSERT INTO item(order_id,ice_cream_id,pice_discount,quality,total_money)
    VALUES(order_id,ice_cream_id,pice_discount,quality,total_money);
END $$
DELIMITER $$

call insert_item(11, 1,10,2,0);

DELIMITER //
CREATE procedure search_item_by_id_order(in id_order int)
BEGIN
SELECT item.item_id,item.order_id,item.ice_cream_id,item.pice_discount,item.quality,item.total_money
FROM item
Where item.order_id = id_order;
END //
DELIMITER //


DELIMITER //
CREATE procedure select_all_item()
BEGIN
SELECT *
FROM item;
END //
DELIMITER //



DELIMITER //
CREATE procedure sum_money_item_by_id_order(in id_order int)
BEGIN
SELECT sum(item.quality*ice_cream.price)
FROM item
join ice_cream on item.ice_cream_id = ice_cream.ice_cream_id
Where item.order_id = id_order
group by item.order_id;
END //
DELIMITER //

call sum_money_item_by_id_order(15)

DELIMITER $$
CREATE PROCEDURE insert_order(name_customer varchar(50), address_customer varchar(200), numberphone_customer varchar(20), total_money double(10,3) )
BEGIN
    INSERT INTO orders(name_customer , address_customer , numberphone_customer , total_money )
    VALUES(name_customer,address_customer,numberphone_customer,total_money);
END $$
DELIMITER $$


DELIMITER $$
CREATE PROCEDURE select_id_last()
BEGIN
    select  orders.order_id
    From orders
    order by orders.order_id DESC
    LiMit 1;
END $$
DELIMITER $$


DELIMITER $$
CREATE PROCEDURE select_all()
BEGIN
   select * from orders;
END $$
DELIMITER $$

call insert_order('lam', 'hanoi', 0123,0);

alter table ice_cream
add status int DEFAULT 0;

 
 