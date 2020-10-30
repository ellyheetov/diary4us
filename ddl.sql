CREATE TABLE `diarydb`.`diaryboard` (
  `id` INT NOT NULL auto_increment,
  `diary_title` VARCHAR(45) NOT NULL,
  `diary_content` VARCHAR(1023) NULL,
  `create_date` DATETIME NULL,
  `modify_date` DATETIME NULL,
  PRIMARY KEY (`id`));