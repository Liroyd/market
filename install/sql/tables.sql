CREATE database market;

CREATE TABLE `users` (
  `name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`name`));

  CREATE TABLE `roles` (
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`name`));

  CREATE TABLE `user_roles` (
  `user` varchar(20) NOT NULL,
  `role` varchar(20) NOT NULL,
   FOREIGN KEY (user)
   REFERENCES users(name)
   ON DELETE CASCADE,
   FOREIGN KEY (role)
   REFERENCES roles(name));


