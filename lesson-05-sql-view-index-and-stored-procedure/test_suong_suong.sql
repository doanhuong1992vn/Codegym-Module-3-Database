USE QUAN_LY_BAN_HANG;
SELECT DISTINCT NAME AS "List of customer bought",
				COUNT(the_order.id) AS "Number of orders"
	FROM CUSTOMER 
		JOIN the_order 
			WHERE the_order.customer_id = customer.id
				GROUP BY NAME;
