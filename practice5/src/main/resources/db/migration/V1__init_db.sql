CREATE TABLE book
(
    id        BIGINT NOT NULL,
    title     VARCHAR(255),
    author    VARCHAR(255),
    type      VARCHAR(255),
    price     INTEGER,
    seller_id INTEGER,
    CONSTRAINT pk_book PRIMARY KEY (id)
);

CREATE TABLE client
(
    id       BIGINT NOT NULL,
    name     VARCHAR(255),
    email    VARCHAR(255),
    login    VARCHAR(255),
    password VARCHAR(255),
    CONSTRAINT pk_client PRIMARY KEY (id)
);

CREATE TABLE telephone (
    id              BIGINT NOT NULL,
    title           VARCHAR(255),
    type            VARCHAR(255),
    price           INTEGER,
    battery_capacity INTEGER,
    manufacturer    VARCHAR(255),
    seller_id       INTEGER,
    CONSTRAINT pk_telephone PRIMARY KEY (id)
);

CREATE TABLE washing_machine (
    id              BIGINT NOT NULL,
    title           VARCHAR(255),
    type            VARCHAR(255),
    price           INTEGER,
    tank_volume      INTEGER,
    manufacturer    VARCHAR(255),
    seller_id       INTEGER,
    CONSTRAINT pk_washing_machine PRIMARY KEY (id)
);