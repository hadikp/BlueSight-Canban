create table squads(id bigint auto_increment PRIMARY KEY, name varchar(50), description varchar(150), start_date date, board_id bigint);
insert into squads(name, description, start_date, board_id) values ('First squad', 'Description of first squad', '2022-12-12', 1);
insert into squads(name, description, start_date, board_id) values ('My test squad', 'Description of my test squad', '2023-01-14', 2);
