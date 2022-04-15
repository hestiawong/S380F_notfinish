CREATE TABLE users (
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    fullname VARCHAR(50) NOT NULL,
    phone VARCHAR(8) NOT NULL,
    address VARCHAR(50) NOT NULL,
    roles VARCHAR(50) NOT NULL,
    PRIMARY KEY (username)
);


INSERT INTO users VALUES ('keith', '{noop}keithpw','keithlee','12345678','HKMU','ROLE_LECTURER');
INSERT INTO users VALUES ('john', '{noop}johnpw','johnchan','12345678','HKMU','ROLE_LECTURER');

