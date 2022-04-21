use customer_tracker;

-- TODO: Populate Address table
-- populate address
-- insert into address
-- values(1, 'Bulevar umetnosti', 31, 'Belgrade', 'Serbia');

-- insert into address
-- values(2, 'Dunavska', 24, 'Novi Sad', 'Serbia');

-- insert into address
-- values(3, 'Javorska', 18, 'Nis', 'Serbia');

-- insert into address
-- values(4, 'Richmond Road', 9193, 'London', 'UK');

-- insert into address
-- values(5, 'Diesel Strasse', 101, 'Frankfurt', 'Germany');

-- populate customer_details
insert into customer_details
values(1, 'Bulevar umetnosti 31, Belgrade, Serbia', '1987-06-16', 'MALE', null);

insert into customer_details
values(2, 'Dunavska 24, Novi Sad, Serbia', '1997-02-15', 'MALE', null);

insert into customer_details
values(3, 'Javorska 18, Nis, Serbia', '1994-10-04', 'MALE', null);

insert into customer_details
values(4, 'Richmond Road 9193, London, UK', '1996-11-11', 'MALE', null);

insert into customer_details
values(5, 'Diesel Strasse 101, Frankfurt, Germany', '1992-07-31', 'MALE', null);

-- populate customer
insert into customer
values(1, 'Pera', 'Peric', 'pera@gmail.com', 1);

insert into customer
values(2, 'Zika', 'Zikic', 'zika@gmail.com', 2);

insert into customer
values(3, 'Marko', 'Markovic', 'pera@gmail.com', 3);

insert into customer
values(4, 'Boba', 'Bobic', 'boba@gmail.com', 4);

insert into customer
values(5, 'Mile', 'Milic', 'mile@gmail.com', 5);
