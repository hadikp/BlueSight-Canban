create table cards(id bigint auto_increment PRIMARY KEY, title varchar(50), description varchar(150), position_number int,
 priority int, status varchar(50), create_date date, opened_at date, closed_at date, due_at date, col_id bigint, user_id bigint, swimlane_id bigint);
insert into cards(title, description, position_number, priority, status, create_date, opened_at, closed_at, due_at, col_id, user_id, swimlane_id)
 values ('Card1', 'Description of card1', 1, 2, 'ACTIVE', '2022-12-20', '2022-12-21', '2023-01-21', '2023-01-30', 1, 1, 1);
insert into cards(title, description, position_number, priority, status, create_date, opened_at, closed_at, due_at, col_id, user_id, swimlane_id)
 values ('Card2', 'Description of card2', 1, 1, 'ACTIVE', '2022-12-21', '2022-12-22', '2023-02-19', '2023-03-11', 1, 1, 2);
