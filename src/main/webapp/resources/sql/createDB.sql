drop database if exists customer_tracker;
create database customer_tracker;
use customer_tracker;

drop table if exists customer;
create table customer (
id int auto_increment not null primary key,
first_name varchar(20), 
last_name varchar(20), 
email varchar(50)
);
	   
