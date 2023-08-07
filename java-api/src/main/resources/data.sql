-- Book Data
INSERT INTO book (id,name) VALUES (1, 'Trading_book_1');
INSERT INTO book (id,name) VALUES (2, 'Trading_book_2');
INSERT INTO book (id,name) VALUES (3, 'Trading_book_3');
INSERT INTO book (id,name) VALUES (4, 'Trading_book_4');
INSERT INTO book (id,name) VALUES (5, 'Trading_book_6');

--Security Data
INSERT INTO security (id,coupon,currency,cusip, face_value, isin, issuer_name, maturity_date,type,status) VALUES (1,4.37,'USD','',1000,'XS1988387210','BNPParibasIssu 4,37% Microsoft Corp (USD)','2021-08-05','CORP','active');
INSERT INTO security (id,coupon,currency,cusip, face_value, isin, issuer_name, maturity_date,type,status) VALUES (2,3.15,'USD','123456780',900,'USN0280EAR64','Airbus 3.15%  USD','2021-07-30','CORP','active');
INSERT INTO security (id,coupon,currency,cusip, face_value, isin, issuer_name, maturity_date,type,status) VALUES (3,2,'USD','123456bh0',900,'A123456111','UBS Facebook (USD)','2021-09-30','CORP','active');
INSERT INTO security (id,coupon,currency,cusip, face_value, isin, issuer_name, maturity_date,type,status) VALUES (4,2.02,'USD','87973RAA8',690,'US87973RAA86','TEMASEK FINL I LTD GLOBAL MEDIUM TERM NTS BOOK ENTRY REG S','2021-08-06','SOVN','active');
INSERT INTO security (id,coupon,currency,cusip, face_value, isin, issuer_name, maturity_date,type,status) VALUES (5,1.23,'USD','87973RAA8',340,'IE00B29LNP31','First Norway Alpha Kl.IV','2030-12-22','SOVN','active');
INSERT INTO security (id,coupon,currency,cusip, face_value, isin, issuer_name, maturity_date,type,status) VALUES (6,0.75,'GBP','BDCHBW8',900,'GB00B6460505','HM Treasury United Kingdon','2021-08-09','GOVN','active');
INSERT INTO security (id,coupon,currency,cusip, face_value, isin, issuer_name, maturity_date,type,status) VALUES (7,0.75,'GBP','BDCHBW8',900,'GB00B6460506','HM Treasury United Kingdon','2021-08-09','GOVN','active');
INSERT INTO security (id,coupon,currency,cusip, face_value, isin, issuer_name, maturity_date,type,status) VALUES (8,0.75,'GBP','BDCHBW8',900,'GB00B6460507','HM Treasury United Kingdon','2021-08-09','GOVN','active');
INSERT INTO security (id,coupon,currency,cusip, face_value, isin, issuer_name, maturity_date,type,status) VALUES (9,0.75,'GBP','BDCHBW8',900,'GB00B6460508','HM Treasury United Kingdon','2021-08-09','GOVN','active');
INSERT INTO security (id,coupon,currency,cusip, face_value, isin, issuer_name, maturity_date,type,status) VALUES (10,0.75,'GBP','BDCHBW8',900,'GB00B6460509','HM Treasury United Kingdon','2021-08-09','GOVN','active');
INSERT INTO security (id,coupon,currency,cusip, face_value, isin, issuer_name, maturity_date,type,status) VALUES (11,0.75,'GBP','BDCHBW8',900,'GB00B6460510','HM Treasury United Kingdon','2021-08-09','GOVN','active');
INSERT INTO security (id,coupon,currency,cusip, face_value, isin, issuer_name, maturity_date,type,status) VALUES (12,0.75,'GBP','BDCHBW8',900,'GB00B6460511','HM Treasury United Kingdon','2021-08-09','GOVN','active');
INSERT INTO security (id,coupon,currency,cusip, face_value, isin, issuer_name, maturity_date,type,status) VALUES (13,0.75,'GBP','BDCHBW8',900,'GB00B6460512','HM Treasury United Kingdon','2021-08-09','GOVN','active');
INSERT INTO security (id,coupon,currency,cusip, face_value, isin, issuer_name, maturity_date,type,status) VALUES (14,0.75,'GBP','BDCHBW8',900,'GB00B6460513','HM Treasury United Kingdon','2021-08-09','GOVN','active');
INSERT INTO security (id,coupon,currency,cusip, face_value, isin, issuer_name, maturity_date,type,status) VALUES (15,0.75,'GBP','BDCHBW8',900,'GB00B6460514','HM Treasury United Kingdon','2021-08-09','GOVN','active');
INSERT INTO security (id,coupon,currency,cusip, face_value, isin, issuer_name, maturity_date,type,status) VALUES (16,0.75,'GBP','BDCHBW8',900,'GB00B6460515','HM Treasury United Kingdon','2021-08-09','GOVN','active');

--Counter Party data
INSERT INTO counter_party (id,name) VALUES (1, 'AZ Holding Inc');
INSERT INTO counter_party (id,name) VALUES (2, 'Acme Co.');
INSERT INTO counter_party (id,name) VALUES (3, 'Sovereign investments');
INSERT INTO counter_party (id,name) VALUES (4, 'Astra Trading Ltd');
INSERT INTO counter_party (id,name) VALUES (5, 'Muncipal Gov Of Orange County');
INSERT INTO counter_party (id,name) VALUES (6, 'Goldman Sachs');
INSERT INTO counter_party (id,name) VALUES (7, 'UBS');
INSERT INTO counter_party (id,name) VALUES (8, 'Barclays');
INSERT INTO counter_party (id,name) VALUES (9, 'British Telecom');
INSERT INTO counter_party (id,name) VALUES (10, 'Pension Holdings');
INSERT INTO counter_party (id,name) VALUES (11, 'Zurich Pension fund 4');

--Trade data
INSERT INTO trade(id,buy_sell,currency,quantity,settlement_date,trade_date,unit_price,book_id,counter_party_id,security_id) VALUES (1,'buy','USD',50,'2021-08-04','2021-05-13',90,1,1,1);
INSERT INTO trade(id,buy_sell,currency,quantity,settlement_date,trade_date,unit_price,book_id,counter_party_id,security_id) VALUES (2,'sell','GBP',40,'2021-08-04','2021-02-04',89.56,1,1,1);
INSERT INTO trade(id,buy_sell,currency,quantity,settlement_date,trade_date,unit_price,book_id,counter_party_id,security_id) VALUES (3,'buy','USD',1000,'2021-08-23','2021-05-13',105.775,2,2,2);
INSERT INTO trade(id,buy_sell,currency,quantity,settlement_date,trade_date,unit_price,book_id,counter_party_id,security_id) VALUES (4,'sell','GBP',900,'2021-09-10','2021-02-04',105.775,2,2,2);
INSERT INTO trade(id,buy_sell,currency,quantity,settlement_date,trade_date,unit_price,book_id,counter_party_id,security_id) VALUES (5,'buy','USD',50,'2021-08-23','2021-05-13',90,3,3,3);
INSERT INTO trade(id,buy_sell,currency,quantity,settlement_date,trade_date,unit_price,book_id,counter_party_id,security_id) VALUES (6,'buy','USD',1000,'2021-08-23','2021-05-13',105.775,2,4,2);
INSERT INTO trade(id,buy_sell,currency,quantity,settlement_date,trade_date,unit_price,book_id,counter_party_id,security_id) VALUES (7,'sell','USD',50,'2021-08-23','2021-05-13',90,2,3,3);
INSERT INTO trade(id,buy_sell,currency,quantity,settlement_date,trade_date,unit_price,book_id,counter_party_id,security_id) VALUES (8,'buy','GBP',60,'2021-09-27','2021-02-04',98.56,4,5,2);
INSERT INTO trade(id,buy_sell,currency,quantity,settlement_date,trade_date,unit_price,book_id,counter_party_id,security_id) VALUES (9,'buy','USD',50,'2021-08-23','2021-08-23',98.56,4,5,2);
INSERT INTO trade(id,buy_sell,currency,quantity,settlement_date,trade_date,unit_price,book_id,counter_party_id,security_id) VALUES (10,'buy','GBP',1100,'2021-09-27','2021-09-27',110.35,5,6,6);
INSERT INTO trade(id,buy_sell,currency,quantity,settlement_date,trade_date,unit_price,book_id,counter_party_id,security_id) VALUES (11,'sell','GBP',900,'2021-09-28','2021-09-28',110.35,5,6,7);
INSERT INTO trade(id,buy_sell,currency,quantity,settlement_date,trade_date,unit_price,book_id,counter_party_id,security_id) VALUES (12,'buy','GBP',2000,'2021-09-29','2021-09-29',110.35,5,7,8);
INSERT INTO trade(id,buy_sell,currency,quantity,settlement_date,trade_date,unit_price,book_id,counter_party_id,security_id) VALUES (13,'sell','GBP',2000,'2021-09-30','2021-09-30',110.35,5,7,9);
INSERT INTO trade(id,buy_sell,currency,quantity,settlement_date,trade_date,unit_price,book_id,counter_party_id,security_id) VALUES (14,'buy','GBP',1000,'2021-10-01','2021-10-01',110.35,5,8,10);
INSERT INTO trade(id,buy_sell,currency,quantity,settlement_date,trade_date,unit_price,book_id,counter_party_id,security_id) VALUES (15,'buy','GBP',900,'2019-10-02','2019-10-02',110.35,5,8,11);
INSERT INTO trade(id,buy_sell,currency,quantity,settlement_date,trade_date,unit_price,book_id,counter_party_id,security_id) VALUES (16,'sell','GBP',1900,'2019-10-03','2019-10-03',110.35,5,8,12);
INSERT INTO trade(id,buy_sell,currency,quantity,settlement_date,trade_date,unit_price,book_id,counter_party_id,security_id) VALUES (17,'buy','GBP',600,'2018-10-04','2018-10-04',110.35,5,9,13);
INSERT INTO trade(id,buy_sell,currency,quantity,settlement_date,trade_date,unit_price,book_id,counter_party_id,security_id) VALUES (18,'buy','GBP',600,'2019-10-05','2019-10-05',110.35,5,10,14);
INSERT INTO trade(id,buy_sell,currency,quantity,settlement_date,trade_date,unit_price,book_id,counter_party_id,security_id) VALUES (19,'buy','GBP',700,'2021-06-06','2021-06-06',110.35,5,10,15);
INSERT INTO trade(id,buy_sell,currency,quantity,settlement_date,trade_date,unit_price,book_id,counter_party_id,security_id) VALUES (20,'sell','GBP',1300,'2021-10-07','2011-10-07',110.35,5,10,16);
INSERT INTO trade(id,buy_sell,currency,quantity,settlement_date,trade_date,unit_price,book_id,counter_party_id,security_id) VALUES (21,'buy','USD',60,'2021-09-27','2012-02-04',100.13,4,11,4);
INSERT INTO trade(id,buy_sell,currency,quantity,settlement_date,trade_date,unit_price,book_id,counter_party_id,security_id) VALUES (22,'buy','USD',50,'2021-08-23','2012-08-23',100.13,4,11,4);
INSERT INTO trade(id,buy_sell,currency,quantity,settlement_date,trade_date,unit_price,book_id,counter_party_id,security_id) VALUES (23,'buy','USD',75,'2021-09-27','2013-02-04',100.13,4,11,4);
INSERT INTO trade(id,buy_sell,currency,quantity,settlement_date,trade_date,unit_price,book_id,counter_party_id,security_id) VALUES (24,'buy','USD',50,'2021-08-23','2014-08-23',100.13,4,11,4);
INSERT INTO trade(id,buy_sell,currency,quantity,settlement_date,trade_date,unit_price,book_id,counter_party_id,security_id) VALUES (25,'buy','USD',300,'2021-09-27','2016-02-04',98.76,4,11,5);
INSERT INTO trade(id,buy_sell,currency,quantity,settlement_date,trade_date,unit_price,book_id,counter_party_id,security_id) VALUES (26,'buy','USD',300,'2021-08-23','2012-08-23',98.76,4,11,5);
INSERT INTO trade(id,buy_sell,currency,quantity,settlement_date,trade_date,unit_price,book_id,counter_party_id,security_id) VALUES (27,'buy','USD',300,'2021-09-27','2013-02-04',98.76,4,11,5);
INSERT INTO trade(id,buy_sell,currency,quantity,settlement_date,trade_date,unit_price,book_id,counter_party_id,security_id) VALUES (28,'sell','USD',300,'2021-08-23','2015-08-23',98.76,4,11,5);

INSERT INTO users(id, username, password, role) VALUES (0, 'DEV', '$2a$10$q/ejSAjpbtScNCXyZbdQOOUcbDUvbwDvqqVFBYZ7RQoF8g4MrPazq', 'ADMIN');
INSERT INTO users(id, username, password, role) VALUES (1, 'TestUser1', '$2a$10$sqi7jUQfCgWXPm1IOmHI0el2yOXMyEsRB9SHKqeYleJe5vo9G.Yp6', 'USER');
INSERT INTO users(id, username, password, role) VALUES (2, 'TestUser2', '$2a$10$r6KTKs2GvjRAmk4R0NW5f.vD.pwXzpcP02.9oxugBA8nJfxkKQ/Bi', 'USER');

INSERT INTO book_user(user_id, book_id) VALUES (1, 1);
INSERT INTO book_user(user_id, book_id) VALUES (1, 3);
INSERT INTO book_user(user_id, book_id) VALUES (2, 2);
INSERT INTO book_user(user_id, book_id) VALUES (2, 4);

