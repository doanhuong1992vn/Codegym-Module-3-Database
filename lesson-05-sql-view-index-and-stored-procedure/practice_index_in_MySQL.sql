USE CLASSICMODELS;
SELECT * FROM CUSTOMERS WHERE CUSTOMERNAME = 'LAND OF TOYS INC.'; 
EXPLAIN SELECT * FROM CUSTOMERS WHERE CUSTOMERNAME = 'LAND OF TOYS INC.'; 
ALTER TABLE CUSTOMERS ADD INDEX INDEX_CUSTOMER_NAME(CUSTOMERNAME);
EXPLAIN SELECT * FROM customers WHERE customerName = 'Land of Toys Inc.'; 
ALTER TABLE CUSTOMERS ADD INDEX INDEX_FULL_NAME(CONTACTFIRSTNAME, CONTACTLASTNAME);
EXPLAIN SELECT * FROM CUSTOMERS WHERE CONTACTFIRSTNAME = "JEAN" OR CONTACTFIRSTNAME = "KING";
ALTER TABLE CUSTOMERS DROP INDEX INDEX_FULL_NAME;