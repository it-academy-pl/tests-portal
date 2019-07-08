INSERT INTO GROUPS (id,name,subject) values (100,'G02','Statyka');
INSERT INTO STUDENT (index,email, name, surname, password,group_id) values (100, 'admin', 'Staszek', 'Rubel', '$2a$10$v0kjaRjDUS/GWtEFLXAmieC/WDVipcO58WQ6wkvfn0QGleyHHfv36',100);
INSERT INTO STUDENT (index,email,name,surname,password,group_id) values (101,'radek@onet.pl','Radek','Dzięcioł','password',100);
INSERT INTO STUDENT (index,email,name,surname,password,group_id) values (102,'drugi@onet.pl','Piotr','Sekuła','password',100);
INSERT INTO TASK (id,description,type,difficulty,student_id) values (100,'Oblicz ile to a+b','STATYKA',2,100);
INSERT INTO PARAMETER (id,name,value,unit,TASK_ID) values (100,'a',90,'mm',100);
INSERT INTO PARAMETER (id,name,value,unit,TASK_ID) values (200,'b',30,'mm',100);
INSERT INTO ADMIN (id,email,password) values (100,'admin','$2a$10$nLyxmsXDEwlRQSZOEManGeX1q.z/dh1wPDHbVkodFuMcmKeYSH5QS');
CREATE OR REPLACE VIEW USERS AS SELECT email, password from STUDENT UNION ALL select email, password from ADMIN;