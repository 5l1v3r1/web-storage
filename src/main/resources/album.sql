DROP DATABASE IF EXISTS album;
CREATE DATABASE album;

USE album;

create table users (
id INT NOT NULL AUTO_INCREMENT,
login VARCHAR(100) NOT NULL,
pass VARCHAR(100) NOT NULL,
role VARCHAR(100) NOT NULL,
active BOOLEAN NOT NULL DEFAULT 0,
PRIMARY KEY (id)
) ENGINE=InnoDB;

create table activation_token (
token_id INT NOT NULL AUTO_INCREMENT,
token VARCHAR(100) NOT NULL,
expire TIMESTAMP NOT NULL,
verified BOOLEAN NOT NULL DEFAULT 0,
PRIMARY KEY (token_id),
CONSTRAINT FKUSR FOREIGN KEY (token_id) REFERENCES users(id)
) ENGINE=InnoDB;

create table pictures (
id INT AUTO_INCREMENT,
pic_owner VARCHAR(100) NOT NULL,
filename VARCHAR(100) NOT NULL,
description VARCHAR(100),
path VARCHAR(100),
thumbnail VARCHAR(100) NOT NULL,
created TIMESTAMP NOT NULL,
userid INT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (userid)
REFERENCES users(id)
ON DELETE CASCADE 
) ENGINE=InnoDB;