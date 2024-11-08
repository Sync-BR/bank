CREATE DATABASE IF NOT EXISTS bank;
USE bank;

CREATE TABLE login (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       password VARCHAR(100) NOT NULL
);

CREATE TABLE cliente (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         cliente_name VARCHAR(100) NOT NULL,
                         cliente_cpf VARCHAR(11) NOT NULL UNIQUE,
                         cliente_age INT NOT NULL,
                         cliente_email VARCHAR(100) NOT NULL UNIQUE,
                         cliente_telephone VARCHAR(15) NOT NULL,
                         cliente_cep VARCHAR(8) NOT NULL,
                         cliente_house_number INT NOT NULL,
                         cliente_house_letter CHAR(1) NOT NULL,
                         cliente_sex VARCHAR(10) NOT NULL,
                         cliente_photo VARCHAR(255) NOT NULL,
                         login_id INT,
                         CONSTRAINT fk_login_id FOREIGN KEY (login_id) REFERENCES login(id) ON DELETE CASCADE
);
