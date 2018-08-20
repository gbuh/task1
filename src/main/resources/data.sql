drop table USERS if exists;
drop table GROUPS if exists;

create table USERS (
id BIGINT PRIMARY KEY,
fist_name VARCHAR(50),
last_name VARCHAR(50),
email VARCHAR(50),
phone_number VARCHAR(50),
version INT,
create_date DATE,
update_date DATE,
created_user VARCHAR(50),
updated_user VARCHAR(50)
);

create table GROUPS (
id BIGINT PRIMARY KEY,
name VARCHAR(50) NOT NULL,
version INT,
create_date DATE,
update_date DATE,
created_user VARCHAR(50),
updated_user VARCHAR(50)
);

insert into USERS (id, fist_name, last_name, email,                 phone_number,    version, create_date,  update_date,  created_user, updated_user)
values (           1,  'Ihar',    'Lipko',   'ihar_lipko@epam.com', '+375295105305', 1,       '2018-08-20', '2018-08-20', 'Igor',       'Igor');
insert into USERS (id, fist_name, last_name, email,                 phone_number,    version, create_date,  update_date,  created_user, updated_user)
values (           2,  'Ivan',    'Petrov',   'ivan_petrov@epam.com', '+375335105305', 1,       '2018-08-19', '2018-08-20', 'Igor',       'Vanya');
insert into GROUPS (id, name,    version, create_date,  update_date,  created_user, updated_user)
values (            1,  'EPAM',  1,       '2018-08-19', '2018-08-20', 'Vanya',       'Igor');