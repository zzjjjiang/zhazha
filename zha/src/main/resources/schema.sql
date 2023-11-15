CREATE TABLE IF NOT EXISTS CUSTOMER (customer_number INT NOT NULL PRIMARY KEY, customer_address
VARCHAR(100), customer_name VARCHAR(50), zip int);

CREATE TABLE IF NOT EXISTS CUSTOMER_ORDER (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
employee_id int, customer_id int, date_time TIMESTAMP)

CREATE TABLE IF NOT EXISTS PRODUCT(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
product_name VARCHAR(50), product_description VARCHAR(255), price float)

CREATE TABLE IF NOT EXISTS EMPLOYEE (id INT NOT NULL AUTO_INCREMENT, employee_name VARCHAR(50),
employment_status VARCHAR(50), pin INT, employee_role VARCHAR(50), PRIMARY KEY (id));

