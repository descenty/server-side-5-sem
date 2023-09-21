CREATE DATABASE IF NOT EXISTS appDB;
CREATE USER IF NOT EXISTS 'user'@'%' IDENTIFIED BY 'password';
GRANT SELECT,UPDATE,INSERT ON appDB.* TO 'user'@'%';
FLUSH PRIVILEGES;

USE appDB;

CREATE TABLE IF NOT EXISTS good (
  id INT(11) NOT NULL AUTO_INCREMENT,
  title VARCHAR(63) NOT NULL,
  description TEXT NOT NULL,
  price DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO good (title, description, price) VALUES
('Jeans', 'Blue jeans', 100.00),
('T-shirt', 'White t-shirt', 50.00),
('Sweater', 'Red sweater', 150.00),
('Shoes', 'Black shoes', 200.00),
('Jacket', 'Green jacket', 250.00),
('Hat', 'Yellow hat', 50.00),
('Gloves', 'Black gloves', 50.00),
('Scarf', 'Red scarf', 50.00),
('Socks', 'White socks', 50.00),
('Underwear', 'Black underwear', 50.00);