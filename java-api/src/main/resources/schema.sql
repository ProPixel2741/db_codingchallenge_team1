DROP TABLE IF EXISTS book_user;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS trade;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS security;
DROP TABLE IF EXISTS counter_party;


CREATE TABLE book (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(250) NOT NULL
);

CREATE TABLE security (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    isin VARCHAR(250) NOT NULL,
    cusip VARCHAR(250),
    issuer_name VARCHAR(250) NOT NULL,
    maturity_date DATE NOT NULL,
    coupon FLOAT NOT NULL,
    type VARCHAR(250) NOT NULL,
    face_value FLOAT NOT NULL,
    currency VARCHAR(250) NOT NULL,
    status VARCHAR(250) DEFAULT NULL
);
CREATE TABLE counter_party (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(250) NOT NULL
);

CREATE TABLE trade (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    book_id INT NOT NULL,
    security_id INT NOT NULL,
    counter_party_id INT NOT NULL,
    currency VARCHAR(250) NOT NULL,
    quantity INT NOT NULL,
    unit_price FLOAT NOT NULL,
    buy_sell VARCHAR(250) NOT NULL,
    trade_date DATE NOT NULL,
    settlement_date DATE NOT NULL,
    FOREIGN KEY (book_id) REFERENCES book(id),
    FOREIGN KEY (counter_party_id) REFERENCES counter_party(id),
    FOREIGN KEY (security_id) REFERENCES security(id)
);

CREATE TABLE users (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(250) NOT NULL,
    password VARCHAR(250) NOT NULL,
    role VARCHAR(250) NOT NULL
);

CREATE TABLE book_user (
    book_id INT NOT NULL,
    user_id INT NOT NULL,
    FOREIGN KEY (book_id) REFERENCES book(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

