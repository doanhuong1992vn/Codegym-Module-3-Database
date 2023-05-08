CREATE DATABASE SHOPPING_CART_MANAGEMENT;
CREATE TABLE PRODUCT (
	ID_PRODUCT INT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(50),
    PRICE FLOAT,
    DESCRIPTION TEXT,
    IMAGE_URL VARCHAR(1000)
);
CREATE TABLE SHOPPING_CART (
	ID_CART INT AUTO_INCREMENT PRIMARY KEY,
    TITTLE VARCHAR(100),
    IMAGE VARCHAR(500),
    PRICE FLOAT
);
CREATE TABLE DETAIL_CART_LINE (
	ID_PRODUCT INT,
    ID_CART INT,
    QUANTITY INT,
    FOREIGN KEY (ID_PRODUCT) REFERENCES PRODUCT(ID_PRODUCT),
    FOREIGN KEY (ID_CART) REFERENCES SHOPPING_CART(ID_CART)
    );
    TRUNCATE DETAIL_CART_LINE;