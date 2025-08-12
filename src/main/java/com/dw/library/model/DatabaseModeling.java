//package com.dw.library.model;
//
//public class DatabaseModeling {

//    create database library;
//
//
//
//    grant all privileges
//
//    on library.*
//
//    to dydmin@localhost identified
//
//    by '1234';
//
//    flush privileges;
//
//
//
//    create table member (
//
//            member_id bigint primary key auto_increment,
//
//            email varchar(255) not null,
//
//    password varchar(255) not null,
//
//    name varchar(255) not null,
//
//    phone varchar(20) not null,
//
//    address varchar(255) not null,
//
//    member_type enum ('student', 'teacher', 'general'),
//
//    created_at timestamp not null ,
//
//    update_at timestamp );
//
//
//
//    create table book(
//
//            book_id bigint primary key auto_increment,
//
//            isbn  varchar(20) not null unique,
//
//    title varchar(255) not null,
//
//    author varchar(255) not null,
//
//    publisher varchar(255) not null,
//
//    publication_year int  not null,
//
//    category  enum ('general_works', 'philosophy' , 'religion', 'social_sciences', 'natural_sciences', 'applied_sciences', 'arts', 'language', 'literature', 'history'),
//
//    total_quantity int not null,
//
//    available_quantity int not null,
//
//    location varchar(255) not null,
//
//    timestamp created_at timestamp not null);
//
//
//
//    create table loan(
//
//            loan_id bigint primary key auto_increment,
//
//            member_id bigint not null,
//
//            book_id bigint not null,
//
//            loan_date date not null,
//
//            due_date date not null,
//
//            return_date date not null,
//
//            status enum ('active','returned', 'overdue'),
//
//    fine_amount decimal(10, 2) not null,
//
//    created_at timestamp not null,
//
//    FOREIGN KEY (member_id) REFERENCES member(member_id),
//
//    FOREIGN KEY (book_id) REFERENCES book(book_id)
//
//            );
//}
