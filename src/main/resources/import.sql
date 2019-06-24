--https://www.browserling.com/tools/bcrypt - use it to generate BCrypt hashes
INSERT INTO STUDENT (id, email, name, surname, password) values (100, 'rubel@coin.ru', 'Staszek', 'Rubel', '$2a$10$nLyxmsXDEwlRQSZOEManGeX1q.z/dh1wPDHbVkodFuMcmKeYSH5QS');
INSERT INTO STUDENT (id,email,name,surname,password) values (101,'radek@onet.pl','Radek','Dzięcioł','password');
INSERT INTO STUDENT (id,email,name,surname,password) values (102,'drugi@onet.pl','Piotr','Sekuła','password');

INSERT INTO ADMIN (id,email,password) values (100,'admin','$2a$10$nLyxmsXDEwlRQSZOEManGeX1q.z/dh1wPDHbVkodFuMcmKeYSH5QS');

CREATE OR REPLACE VIEW USERS AS SELECT email, password from STUDENT UNION ALL select email, password from ADMIN;