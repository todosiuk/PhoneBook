
create database phonebook;

use phonebook;

 create table user 
 (id integer not null auto_increment, name varchar(255), 
 login varchar(255), password varchar(255), primary key (id));
 
create table contact
(id integer not null auto_increment, address varchar(255), email varchar(255),
home_phone varchar(255), mobile_phone varchar(255) not null, name varchar(255) 
not null, patronymic varchar(255) not null, surname varchar(255) not null, user_iduser integer, primary key (id));

