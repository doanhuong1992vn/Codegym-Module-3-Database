create DATABASE mock_data;
create table MOCK_DATA (
	id INT,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	email VARCHAR(50),
	gender VARCHAR(50),
	ip_address VARCHAR(20)
);
SELECT * from mock_data ;
SELECT * FROM mock_data WHERE LAST_NAME REGEXP "na";
SELECT * FROM mock_data LIMIT 100, 1000;
CREATE or replace VIEW  DATA_VIEW AS
SELECT * FROM MOCK_DATA 
WHERE ID >= 500 AND LAST_NAME LIKE "%a%" OR "%l%" OR "%h%";
select * FROM data_view;
CREATE or replace VIEW  DATA_VIEW AS
SELECT * FROM MOCK_DATA 
WHERE ID >= 500 AND LAST_NAME IN ("PEAKE", "EAVES");