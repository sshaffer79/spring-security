DROP database IF EXISTS `spring_playground`;
create database spring_playground;

use spring_playground;

DROP TABLE IF EXISTS `spring_users`;
CREATE TABLE `spring_users` (
  `user_name` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `active` INT NULL DEFAULT 1,
  PRIMARY KEY (`user_name`),
  UNIQUE INDEX `user_name_UNIQUE` (`user_name` ASC)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `persistent_logins` (
    `username` varchar(64) not null,
    `series` varchar(64) not null,
    `token` varchar(64) not null,
    `last_used` timestamp not null,
    PRIMARY KEY (series)
);

INSERT INTO `spring_users`(`user_name`,`password`,`active`)
VALUES('user', '$2a$12$ZNOYcndi4Mi7LlLFvh0Fzu844vlOCSTtJzFycTONTnMpF0Av2IsCK', 1);

INSERT INTO `spring_users`(`user_name`,`password`,`active`)
VALUES('user2', '$2a$12$ZNOYcndi4Mi7LlLFvh0Fzu844vlOCSTtJzFycTONTnMpF0Av2IsCK', 0);

INSERT INTO `spring_users`(`user_name`,`password`,`active`)
VALUES('user3', '$2a$12$ZNOYcndi4Mi7LlLFvh0Fzu844vlOCSTtJzFycTONTnMpF0Av2IsCK', 1);