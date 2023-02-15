create table cards(id bigint auto_increment PRIMARY KEY, title varchar(50), description varchar(150), position_number int,
 priority int, status int, create_date date, opened_at date, closed_at date, due_at date, col_id bigint, user_id bigint, swimlane_id bigint);
insert into cards(title, description, position_number, priority, status, create_date, opened_at, closed_at, due_at, col_id, user_id, swimlane_id)
 values ('Card1', 'Description of card1', 1, 2, 2, '2022-12-20', '2022-12-21', '2023-01-21', '2023-01-30', 1, 1, 1);
insert into cards(title, description, position_number, priority, status, create_date, opened_at, closed_at, due_at, col_id, user_id, swimlane_id)
 values ('Card2', 'Description of card2', 1, 1, 1, '2022-12-21', '2022-12-22', '2023-02-19', '2023-03-11', 1, 1, 1);
insert into cards(title, description, position_number, priority, status, create_date, opened_at, closed_at, due_at, col_id, user_id, swimlane_id)
 values ('Card3', 'Description of card3', 2, 1, 1, '2022-12-29', '2022-12-30', '2023-02-19', '2023-03-12', 2, 1, 1);
insert into cards(title, description, position_number, priority, status, create_date, opened_at, closed_at, due_at, col_id, user_id, swimlane_id)
 values ('Card4', 'Description of card4', 3, 1, 1, '2022-12-30', '2022-12-31', '2023-02-21', '2023-03-15', 3, 1, 1);
insert into cards(title, description, position_number, priority, status, create_date, opened_at, closed_at, due_at, col_id, user_id, swimlane_id)
 values ('Card5', 'Description of card5', 1, 1, 1, '2022-12-31', '2023-01-01', '2023-02-23', '2023-03-22', 4, 1, 1);
insert into cards(title, description, position_number, priority, status, create_date, opened_at, closed_at, due_at, col_id, user_id, swimlane_id)
 values ('Card6', 'Description of card6', 1, 1, 1, '2023-01-01', '2023-01-02', '2023-02-19', '2023-03-11', 1, 1, 2);
insert into cards(title, description, position_number, priority, status, create_date, opened_at, closed_at, due_at, col_id, user_id, swimlane_id)
 values ('Card7', 'Description of card7', 1, 1, 1, '2023-01-11', '2023-01-12', '2023-02-19', '2023-03-11', 1, 1, 2);
insert into cards(title, description, position_number, priority, status, create_date, opened_at, closed_at, due_at, col_id, user_id, swimlane_id)
 values ('Card8', 'Description of card8', 1, 1, 1, '2023-01-21', '2023-01-22', '2023-02-22', '2023-03-15', 1, 1, 2);
