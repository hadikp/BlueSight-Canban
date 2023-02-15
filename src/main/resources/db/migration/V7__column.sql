create table columns(id bigint auto_increment PRIMARY KEY, name varchar(50), position_number int, card_count int, wip_limit int);
insert into columns(name, position_number, card_count, wip_limit) values ('Backlog', 1, 5, 111);
insert into columns(name, position_number, card_count, wip_limit) values ('Ready to Work', 2, 5, 111);
insert into columns(name, position_number, card_count, wip_limit) values ('Active', 3, 5, 111);
insert into columns(name, position_number, card_count, wip_limit) values ('Closed', 4, 5, 111);