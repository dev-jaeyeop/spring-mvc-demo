create database spring_mvc_demo;
use spring_mvc_demo;

CREATE TABLE customer
(
    id         INT(11) PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(45),
    last_name  VARCHAR(50),
    email      VARCHAR(45)
);

insert into customer
values ('first', 'last', 'email'),
       ('first1', 'last1', 'email1'),
       ('first2', 'last2', 'email2'),
       ('first3', 'last3', 'email3'),
       ('first4', 'last4', 'email4');