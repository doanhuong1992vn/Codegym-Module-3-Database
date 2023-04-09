USE QUAN_LY_BAN_HANG;
INSERT INTO CUSTOMER (NAME, AGE) VALUES 
("Minh Quan", 10),
("Ngoc Oanh", 20),
("Hong Ha", 50);
INSERT INTO THE_ORDER (CUSTOMER_ID, ORDER_DATE, ORDER_TOTAL_PRICE) VALUES
(1, "2006-3-26", NULL),
(2, "2006-03-23", NULL),
(1, "2006-3-16", NULL);
INSERT INTO PRODUCT (NAME, PRICE) VALUES
("MAY GIAT", 3),
("TU LANH", 5),
("DIEU HOA", 7),
("QUAT", 1),
("BEP DIEN", 2);
INSERT INTO ORDER_DETAIL (ORDER_ID, PRODUCT_ID, QUANTITY) VALUES
(1, 1, 3),
(1, 3, 7),
(1, 4, 2),
(2, 1, 1),
(3, 1, 8),
(2, 5, 4),
(2, 3, 3);
SELECT * FROM THE_ORDER;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
SELECT DISTINCT C.NAME AS NAME_OF_CUSTOMER, P.NAME AS NAME_OF_PRODUCT
FROM CUSTOMER C 
JOIN THE_ORDER O ON C.ID = O.CUSTOMER_ID 
JOIN ORDER_DETAIL OD ON O.ID = OD.ORDER_ID 
JOIN PRODUCT P ON P.ID = OD.PRODUCT_ID;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
SELECT CUS.NAME 
FROM CUSTOMER AS CUS 
LEFT JOIN THE_ORDER AS ORD ON CUS.ID = ORD.CUSTOMER_ID
WHERE ORD.CUSTOMER_ID IS NULL;

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)
SELECT O.ID AS "ORDER ID", O.ORDER_DATE AS "ORDER DAE", SUM(OD.QUANTITY*P.PRICE) AS "TOTAL PRICE" 
FROM THE_ORDER AS O
JOIN ORDER_DETAIL AS OD ON O.ID = OD.ORDER_ID
JOIN PRODUCT AS P ON P.ID = OD.PRODUCT_ID	
GROUP BY ORDER_ID;