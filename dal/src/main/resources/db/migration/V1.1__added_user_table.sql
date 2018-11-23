CREATE SEQUENCE user_seq START 1;

CREATE TABLE user
(
  id              BIGSERIAL PRIMARY KEY NOT NULL,
  login            VARCHAR(40)        NOT NULL,
  password VARCHAR(200) NOT NULL,
  name VARCHAR(200)        NOT NULL,
  role VARCHAR(40)        NOT NULL,
  deleted boolean NOT NULL DEFAULT false
);

INSERT into user (id, login, password, name, role) VALUE (1, 'admin', 'password', 'administrator', 'ADMIN')