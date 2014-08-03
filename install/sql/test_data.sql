INSERT INTO users VALUES('admin','admin'),('user','user'),('seller','seller');

INSERT INTO roles VALUES('ROLE_ADMIN'),('ROLE_USER'),('ROLE_SELLER');

INSERT INTO user_roles VALUES('admin','ROLE_ADMIN'),('admin','ROLE_SELLER'),('user','ROLE_USER'),('seller', 'ROLE_SELLER');