INSERT INTO STUDENT (id, email, name, surname, password) values (100, 'rubel@coin.ru', 'Staszek', 'Rubel', 'password');
INSERT INTO STUDENT (id,email,name,surname,password) values (101,'radek@onet.pl','Radek','Dzięcioł','password');
INSERT INTO STUDENT (id,email,name,surname,password) values (102,'drugi@onet.pl','Piotr','Sekuła','password');
INSERT INTO TASK (id,description,subject,difficulty,STUDENT_ID) values (1,'Oblicz ile to a+b','STATYKA',2,100);
INSERT INTO PARAMETER (id,name,value,unit,TASK_ID) values (1,'a',90,'mm',1);
INSERT INTO PARAMETER (id,name,value,unit,TASK_ID) values (2,'b',30,'mm',1);

