CREATE TABLE person (
	emp_id BIGINT PRIMARY KEY,
	first_name VARCHAR(100) NOT NULL,
	last_name VARCHAR(100) NOT NULL,
	gender CHAR(1)  NOT NULL,
	phone_number INTEGER(15) NOT NULL,
	pin_code INTEGER(8) NOT NULL,
	user_type VARCHAR(10) NOT_NULL,
	admin_id VARCHAR(10) NOT_NULL,
	covid_result CHAR(2) NOT_NULL

);

CREATE SEQUENCE seq_emp_id AS BIGINT;
