CREATE DATABASE authentication;
USE authentication;
CREATE TABLE users (user_id INT NOT NULL AUTO_INCREMENT UNIQUE, 
					   name VARCHAR(60) NOT NULL,
                    email VARCHAR(50) NOT NULL UNIQUE,
                    country VARCHAR(60) NOT NULL,
                    country_code_name VARCHAR(2) NOT NULL,
                    country_code INT NOT NULL,
                    phone_number VARCHAR(15) NOT NULL,
                    user_password VARCHAR(15) NOT NULL,
                    PRIMARY KEY(user_id));