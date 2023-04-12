USE QUAN_LY_BAN_HANG;
<<<<<<< HEAD
SELECT DISTINCT NAME AS "List of customer bought",
				COUNT(the_order.id) AS "Number of orders"
	FROM CUSTOMER 
		JOIN the_order 
			WHERE the_order.customer_id = customer.id
				GROUP BY NAME;
=======
SELECT DISTINCT CUSTOMER.NAME 
	FROM CUSTOMER 
		JOIN the_order 
			WHERE the_order.customer_id = customer.id
				GROUP BY CUSTOMER.NAME;
SELECT CUSTOMER.NAME 
	FROM CUSTOMER 
		JOIN PRODUCT ON CUSTOMER.ID = PRODUCT.ID;
>>>>>>> 2966d0e72e2349e95db0c19d9c18c945a993b004
