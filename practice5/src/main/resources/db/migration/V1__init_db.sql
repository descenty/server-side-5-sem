CREATE TABLE book (
    id UUID DEFAULT gen_random_uuid(),
    title VARCHAR(255),
    author VARCHAR(255),
    type VARCHAR(255),
    price DECIMAL(10, 2),
    seller_id INTEGER
);

CREATE TABLE client (
    id UUID DEFAULT gen_random_uuid(),
    name VARCHAR(255),
    email VARCHAR(255),
    login VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE telephone (
    id UUID DEFAULT gen_random_uuid(),
    title VARCHAR(255),
    type VARCHAR(255),
    price DECIMAL(10, 2),
    battery_capacity INTEGER,
    manufacturer VARCHAR(255),
    seller_id INTEGER
);

CREATE TABLE washing_machine (
    id UUID DEFAULT gen_random_uuid(),
    title VARCHAR(255),
    type VARCHAR(255),
    price DECIMAL(10, 2),
    tank_volume INTEGER,
    manufacturer VARCHAR(255),
    seller_id INTEGER
);