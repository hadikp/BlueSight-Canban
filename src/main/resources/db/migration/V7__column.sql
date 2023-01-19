create table columns(id bigint auto_increment PRIMARY KEY, name varchar(50), position_number int, card_count int, wip_limit int, swimlane_id bigint);
insert into columns(name, position_number, card_count, wip_limit, swimlane_id) values ('Backlog', 1, 5, 111, 1);
insert into columns(name, position_number, card_count, wip_limit, swimlane_id) values ('Ready to Work', 2, 5, 111, 1);
insert into columns(name, position_number, card_count, wip_limit, swimlane_id) values ('Active', 3, 5, 111, 1);
insert into columns(name, position_number, card_count, wip_limit, swimlane_id) values ('Closed', 4, 5, 111, 1);