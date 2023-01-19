create table swimlanes(id bigint auto_increment PRIMARY KEY, name varchar(50), position_number int, wip_limit int, board_id bigint);
insert into swimlanes(name, position_number, wip_limit, board_id) values ('Portfolio', 1, 110, 1);
insert into swimlanes(name, position_number, wip_limit, board_id) values ('Major feature', 2, 110, 1);
insert into swimlanes(name, position_number, wip_limit, board_id) values ('Minor feature', 3, 110, 1);