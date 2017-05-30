CREATE DATABASE  IF NOT EXISTS phonebook;
USE phonebook;

CREATE TABLE role (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(45) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO role VALUES (1,'ROLE_USER');

CREATE TABLE users (
id int(11)  NOT NULL auto_increment,
login varchar(255), 
password varchar(255),
fullName varchar (255),
primary key (id)
)ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT INTO users VALUES (1,'user1', '12345','Tom Crus');

CREATE TABLE user_role (
  user_id int(11) NOT NULL,
  role_id int(11) NOT NULL,
  PRIMARY KEY (user_id,role_id),
  KEY fk_user_role_roleid_idx (role_id),
  CONSTRAINT fk_user_role_roleid FOREIGN KEY (role_id) REFERENCES role (id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT fk_user_role_userid FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO user_role VALUES(1,1);

CREATE TABLE contact (
id int(11)  NOT NULL auto_increment, 
address varchar(255),
email varchar(255),
home_phone varchar(255), 
mobile_phone varchar(255) not null,
name varchar(255) not null, 
patronymic varchar(255) not null,
surname varchar(255) not null, 
users_idusers int(11),
 PRIMARY KEY (id));
 
 INSERT INTO contact VALUES (1,'Alma-At','v.todosiuk@gmail.com','044-568-99-78',
 '+38097-817-56-15','Arnold','Stallone','Vitalievich',1);