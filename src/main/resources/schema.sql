CREATE TABLE STUDENTS (
  student_id int AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  surname varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  last_login date DEFAULT NULL,
  PRIMARY KEY (`student_id`)
);