drop database if exists customer_tracker;
create database customer_tracker;
use customer_tracker;

drop table if exists users;
create table users (
id int not null auto_increment primary key,
first_name varchar(20), 
last_name varchar(20), 
email varchar(50) not null,
password char(200) not null,
enabled tinyint(1) not null default 1,
unique key idx_email (email)
);


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
customer_details_id int not null,
foreign key(id)
	references users(id),
foreign key(customer_details_id) 
	references customer_details(id)
);

drop table if exists project;
create table project (
id int auto_increment not null primary key,
name varchar(50),
component varchar(20)
);

drop table if exists developer;
create table developer (
id int not null auto_increment primary key,
project_id int,
foreign key (id)
	references users(id),
foreign key(project_id)
	references project(id)
);

drop table if exists bug;
create table bug (
id int auto_increment not null primary key,
component varchar(20),
description varchar(256),
priority varchar(20),
status varchar(20),
customer_id int not null,
developer_id int,
foreign key(customer_id)
	references customer(id),
foreign key(developer_id)
	references developer(id)
);

drop table if exists project_bug;
create table project_bug (
project_id int not null,
bug_id int not null,
primary key(project_id, bug_id),
foreign key(project_id) 
	references project(id),
foreign key(bug_id)
	references bug(id)
);

drop table if exists authorities;
create table authorities (
email varchar(50) not null,
authority varchar(50) not null,
unique key authority_idx(email, authority),
foreign key(email)
	references users(email)
);