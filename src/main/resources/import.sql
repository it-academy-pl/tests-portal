--https://www.browserling.com/tools/bcrypt - use it to generate BCrypt hashes
INSERT INTO STUDENT (id, email, name, surname, password) values (100, 'student@agh.edu.pl', 'Staszek', 'Rubel', '$2a$10$v0kjaRjDUS/GWtEFLXAmieC/WDVipcO58WQ6wkvfn0QGleyHHfv36');
INSERT INTO STUDENT (id,email,name,surname,password) values (101,'radek@onet.pl','Radek','Dzięcioł','password');
INSERT INTO STUDENT (id,email,name,surname,password) values (102,'drugi@onet.pl','Piotr','Sekuła','password');
INSERT INTO STUDENT (id,email,name,surname,password) values (103,'trzeci@onet.pl','Staszek','Gomuła','password');
INSERT INTO TASK (id,description,subject,difficulty,STUDENT_ID) values (100,'Oblicz ile to a+b','STATYKA',2,100);
INSERT INTO PARAMETER (id,name,value,unit,TASK_ID) values (100,'a',90,'mm',100);
INSERT INTO PARAMETER (id,name,value,unit,TASK_ID) values (200,'b',30,'mm',100);
INSERT INTO ADMIN (id,email,password) values (100,'admin@agh.edu.pl','$2a$10$nLyxmsXDEwlRQSZOEManGeX1q.z/dh1wPDHbVkodFuMcmKeYSH5QS');
CREATE OR REPLACE VIEW USERS AS SELECT email, password, 'ROLE_USER' as role from STUDENT UNION ALL select email, password,'ROLE_ADMIN' as role from ADMIN;
