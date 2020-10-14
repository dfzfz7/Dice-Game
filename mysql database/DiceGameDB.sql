CREATE SCHEMA IF NOT EXISTS `dice_game` DEFAULT CHARACTER SET utf8mb4 ;
USE `dice_game` ;


CREATE TABLE IF NOT EXISTS `player` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `player_name` VARCHAR(45) NULL DEFAULT NULL,
  `success_rate` DOUBLE NULL DEFAULT NULL,
  `reg_date` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
  
);


CREATE TABLE IF NOT EXISTS `dice_roll` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `dice_1` INT(11) NULL DEFAULT NULL,
  `dice_2` INT(11) NULL DEFAULT NULL,
  `won` TINYINT(4) NULL DEFAULT NULL,
  `player_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  
  CONSTRAINT `dice_roll_fk`
    FOREIGN KEY (`player_id`)
    REFERENCES `player` (`id`)
);
