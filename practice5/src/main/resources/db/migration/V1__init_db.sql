CREATE TABLE book (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255),
    author VARCHAR(255),
    type VARCHAR(255),
    price INTEGER,
    seller_id INTEGER
);
CREATE TABLE client (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    login VARCHAR(255),
    password VARCHAR(255)
);
CREATE TABLE telephone (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255),
    type VARCHAR(255),
    price INTEGER,
    battery_capacity INTEGER,
    manufacturer VARCHAR(255),
    seller_id INTEGER
);
CREATE TABLE washing_machine (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255),
    type VARCHAR(255),
    price INTEGER,
    tank_volume INTEGER,
    manufacturer VARCHAR(255),
    seller_id INTEGER
);