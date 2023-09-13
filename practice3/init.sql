CREATE DATABASE IF NOT EXISTS appDB;
CREATE USER IF NOT EXISTS 'user'@'%' IDENTIFIED BY 'password';
GRANT SELECT,UPDATE,INSERT ON appDB.* TO 'user'@'%';
FLUSH PRIVILEGES;

USE appDB;

CREATE TABLE IF NOT EXISTS order (
  id INT(11) NOT NULL AUTO_INCREMENT,
  address VARCHAR(100) NOT NULL,
  customer_name VARCHAR(63) NOT NULL,
  status VARCHAR(15) NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
)

CREATE TABLE IF NOT EXISTS good (
  id INT(11) NOT NULL AUTO_INCREMENT,
  title VARCHAR(63) NOT NULL,
  description TEXT NOT NULL,
  price DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS ordered_good (
  id INT(11) NOT NULL AUTO_INCREMENT,
  order_id INT(11) NOT NULL,
  good_id INT(11) NOT NULL,
  quantity INT(11) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (order_id) REFERENCES order(id),
  FOREIGN KEY (good_id) REFERENCES good(id)
)

INSERT INTO order (address, customer_name, status) VALUES
("Moscow, ulitsa Lenina, 1", "Petrov Ivan", "new")
("Moscow, prospekt Mira, 1", "Ivanov Sergey", "new"),
("Kazan, ulitsa Pushkina, 2", "Petrov Petr", "paid"),
("Saint-Petersburg, Nevskiy prospekt, 3", "Sidorov Sidor", "sent"),
("Novosibirsk, ulitsa Lenina, 4", "Vasilev Vasiliy", "delivered"),
("Yekaterinburg, ulitsa Gagarina, 5", "Sergeev Sergey", "delivered"),
("Nizhniy Novgorod, ulitsa Kalinina, 6", "Andreev Andrey", "delivered"),
("Samara, ulitsa Kirova, 7", "Alexeev Alexey", "delivered"),
("Omsk, ulitsa Stalina, 8", "Yakovlev Yakov", "delivered"),
("Kazan, ulitsa Molotova, 9", "Stepanov Stepan", "delivered"),
("Chelyabinsk, ulitsa Kirova, 10", "Fedorov Fedor", "delivered");

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

INSERT INTO ordered_good (order_id, good_id, quantity) VALUES
(1, 1, 1),
(1, 2, 2),
(1, 3, 3),
(2, 4, 4),
(2, 5, 5),
(2, 6, 6),
(3, 7, 7),
(3, 8, 8),
(3, 9, 9),
(4, 10, 10),
(4, 1, 1),
(4, 2, 2),
(5, 3, 3),
(5, 4, 4),
(5, 5, 5),
(6, 6, 6),
(6, 7, 7),
(6, 8, 8),
(7, 9, 9),
(7, 10, 10),
(7, 1, 1),
(8, 2, 2),
(8, 3, 3),
(8, 4, 4),
(9, 5, 5),
(9, 6, 6),
(9, 7, 7),
(10, 8, 8),
(10, 9, 9),
(10, 10, 10),
(11, 1, 1),
(11, 2, 2),
(11, 3, 3);