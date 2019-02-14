drop database contrader;
create database contrader;
create table contrader.users (username varchar(50), password varchar(50));
insert into contrader.users (username, password) values ('pippo', 'paperino');
insert into contrader.users (username, password) values ('ciccio', 'bello');
create table contrader.gomme (model varchar(50), manufacturer varchar(50), price float);
insert into contrader.gomme (model, manufacturer, price) values ('Trelleborg-B50', 'Trelleborg', 321.13);
insert into contrader.gomme (model, manufacturer, price) values ('SuperG-876 ', 'Super Gomme', 213.176);


