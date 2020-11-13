insert into player (player_name, password, success_rate, reg_date) values ('Daniel', '$2a$10$eT5VCdY5fKLRyXIUbiUYI.EGTOjryydm4l84sahvCSTyXrNH.I3jO', 1.0, now());
insert into player (player_name, password, success_rate, reg_date) values ('Juan', '$2a$10$LBJmlVSQyyCxURP4QtTLyubYBuFRzb7iiHj7bel0icPormMVd3mNO', 0.67, now());
insert into player (player_name, password, success_rate, reg_date) values ('Pedro', '$2a$10$vQj0WXqVkRAaDOc1lfwlu.pVSribeGaHxfvMC2K2I67DkvXw6cHva', 0.33, now());

insert into dice_roll (dice_1, dice_2, won, player_id) values (3,4,1,1);
insert into dice_roll (dice_1, dice_2, won, player_id) values (2,5,1,1);
insert into dice_roll (dice_1, dice_2, won, player_id) values (1,6,1,1);
insert into dice_roll (dice_1, dice_2, won, player_id) values (4,3,1,2);
insert into dice_roll (dice_1, dice_2, won, player_id) values (5,2,1,2);
insert into dice_roll (dice_1, dice_2, won, player_id) values (1,1,0,2);
insert into dice_roll (dice_1, dice_2, won, player_id) values (6,1,1,3);
insert into dice_roll (dice_1, dice_2, won, player_id) values (4,4,0,3);
insert into dice_roll (dice_1, dice_2, won, player_id) values (6,5,0,3);