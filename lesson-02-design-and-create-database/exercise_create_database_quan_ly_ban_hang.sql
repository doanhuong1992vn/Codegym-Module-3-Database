CREATE DATABASE IF NOT EXISTS quan_ly_ban_hang;
USE quan_ly_ban_hang;
CREATE TABLE IF NOT EXISTS customer (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    age INT NOT NULL
);
CREATE TABLE IF NOT EXISTS the_order (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    order_date DATE,
    order_total_price DOUBLE,
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);
CREATE TABLE IF NOT EXISTS product (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    price DOUBLE NOT NULL
);
CREATE TABLE IF	NOT EXISTS order_detail (
	order_id INT,
    product_id INT,
    quantity INT NOT NULL,
    PRIMARY KEY (order_id , product_id),
    FOREIGN KEY (order_id) REFERENCES the_order(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);