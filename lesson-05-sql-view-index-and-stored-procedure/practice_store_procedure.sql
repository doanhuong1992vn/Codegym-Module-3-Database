USE CLASSICMODELS;
DELIMITER //
CREATE PROCEDURE FIND_ALL_CUSTOMERS()
BEGIN
	SELECT * FROM CUSTOMERS;
END 
// DELIMITER ;
CALL FIND_ALL_CUSTOMERS();
DROP PROCEDURE IF EXISTS FIND_ALL_CUSTOMERS;

DELIMITER //
CREATE PROCEDURE FIND_CUSTOMER_NUMBER_175()
BEGIN
	SELECT * FROM CUSTOMERS WHERE CUSTOMERNUMBER = 175;
END 
// DELIMITER ;
CALL FIND_CUSTOMER_NUMBER_175();
DROP PROCEDURE IF EXISTS FIND_CUSTOMER_NUMBER_175;