insert into player (player_name, success_rate, reg_date) values ('Daniel', 1.0, now());
insert into player (player_name, success_rate, reg_date) values ('Juan', 0.67, now());
insert into player (player_name, success_rate, reg_date) values ('Pedro', 0.33, now());

insert into dice_roll (dice_1, dice_2, won, player_id) values (3,4,1,1);
insert into dice_roll (dice_1, dice_2, won, player_id) values (2,5,1,1);
insert into dice_roll (dice_1, dice_2, won, player_id) values (1,6,1,1);
insert into dice_roll (dice_1, dice_2, won, player_id) values (4,3,1,2);
insert into dice_roll (dice_1, dice_2, won, player_id) values (5,2,1,2);
insert into dice_roll (dice_1, dice_2, won, player_id) values (1,1,0,2);
insert into dice_roll (dice_1, dice_2, won, player_id) values (6,1,1,3);
insert into dice_roll (dice_1, dice_2, won, player_id) values (4,4,0,3);
insert into dice_roll (dice_1, dice_2, won, player_id) values (6,5,0,3);

