drop database if exists customer_tracker;
create database customer_tracker;
use customer_tracker;

-- TODO: Add seperate table for Address
-- drop table if exists address;
-- create table address (
-- id int auto_increment not null primary key,
-- street varchar(30),
-- street_number int,
-- city varchar(30),
-- country varchar(30)
-- ); 

drop table if exists customer_details;
create table customer_details (
id int auto_increment not null primary key,
address varchar(200), 
birthday date,
gender varchar(7),
profile_picture mediumblob
-- foreign key(address_id)
-- 	references address(id)
);

drop table if exists customer;
create table customer (
id int auto_increment not null primary key,
first_name varchar(20), 
last_name varchar(20), 
email varchar(50),
customer_details_id int not null,
foreign key(customer_details_id) 
	references customer_details(id)
);