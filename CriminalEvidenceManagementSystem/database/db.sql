-- Create Database Structure --
DROP DATABASE criminal_evidence_management_system;
CREATE DATABASE criminal_evidence_management_system;

CREATE TABLE `criminal_evidence_management_system`.`storage` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `version` INT NULL,
  `name` NVARCHAR(128) NULL,
  `location` NVARCHAR(500) NULL,
  `created_at` TIMESTAMP NULL,
  `modified_at` TIMESTAMP NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE `criminal_evidence_management_system`.`track_entry` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `version` INT NULL,
  `date` TIMESTAMP NULL,
  `action` NVARCHAR(45) NULL,
  `reason`  NVARCHAR(500) NULL,
  `detective_id` BIGINT NULL,
  `evedence_id` BIGINT NULL,
  `created_at` TIMESTAMP NULL,
  `modified_at` TIMESTAMP NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE `criminal_evidence_management_system`.`detective` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `version` INT NULL,
  `username` NVARCHAR(45) NULL,
  `first_name` NVARCHAR(45) NULL,
  `last_name` NVARCHAR(45) NULL,
  `password`  NVARCHAR(45) NULL,
  `hiring_date` TIMESTAMP NULL,
  `badge_number` NVARCHAR(45) NULL,
  `rank` NVARCHAR(10) NULL,
  `armed` BOOLEAN NULL,
  `status` NVARCHAR(20) NULL,
  `created_at` TIMESTAMP NULL,
  `modified_at` TIMESTAMP NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE `criminal_evidence_management_system`.`evidence` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `version` INT NULL,
  `number` NVARCHAR(45) NULL,
  `item_name` NVARCHAR(45) NULL,
  `notes` TEXT NULL,
  `archived` BOOLEAN NULL,
  `criminal_case_id` BIGINT NULL,
  `storage_id` BIGINT NULL,
  `created_at` TIMESTAMP NULL,
  `modified_at` TIMESTAMP NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE `criminal_evidence_management_system`.`criminal_case` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `version` INT NULL,
  `number` NVARCHAR(45) NULL,
  `type` NVARCHAR(45) NULL,
  `short_description` TEXT NULL,
  `detailed_description` TEXT NULL,
  `status` NVARCHAR(45) NULL,
  `notes` TEXT NULL,  
  `lead_investigator` BIGINT NULL,
  `created_at` TIMESTAMP NULL,
  `modified_at` TIMESTAMP NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE `criminal_evidence_management_system`.`working_detective_case` (
  `detective_id` BIGINT NULL,
  `criminal_case_id` BIGINT NULL
);
  
-- Import Data --
-- Criminal Case --
INSERT INTO `criminal_evidence_management_system`.`criminal_case` (`version`, `number`, `type`, `short_description`, `detailed_description`, `status`, `notes`, `lead_investigator`) VALUES ('1', 'CS001', 'INFRACTION', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s', 'Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.', 'SUBMITED', 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using \'Content here, content here\', making it look like readable English', '1');
INSERT INTO `criminal_evidence_management_system`.`criminal_case` (`version`, `number`, `type`, `short_description`, `detailed_description`, `status`, `notes`, `lead_investigator`) VALUES ('1', 'CS002', 'FELONY', 'The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.', 'There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don\'t look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn\'t anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.', 'IN_COURT', 'Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for \'lorem ipsum\' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).', '2');
INSERT INTO `criminal_evidence_management_system`.`criminal_case` (`version`, `number`, `type`, `short_description`, `detailed_description`, `status`, `notes`, `lead_investigator`) VALUES ('1', 'CS003', 'MISDEMEANOR', 'Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old.', 'Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.', 'CLOSED', 'The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.', '2');
UPDATE `criminal_evidence_management_system`.`criminal_case` SET `created_at` = '2020-12-12', `modified_at` = '2020-12-12' WHERE (`id` = '1');
UPDATE `criminal_evidence_management_system`.`criminal_case` SET `created_at` = '2020-12-12', `modified_at` = '2020-12-12' WHERE (`id` = '2');
UPDATE `criminal_evidence_management_system`.`criminal_case` SET `created_at` = '2020-12-12', `modified_at` = '2020-12-12' WHERE (`id` = '3');
UPDATE `criminal_evidence_management_system`.`criminal_case` SET `status` = 'SUBMITTED' WHERE (`id` = '1');

-- Storage --
INSERT INTO `criminal_evidence_management_system`.`storage` (`version`, `name`, `location`, `created_at`, `modified_at`) VALUES ('1', 'Document Storage Room 001', '7 Fieldstone Drive Findlay, OH 45840', '2020-12-12', '2020-12-12');
INSERT INTO `criminal_evidence_management_system`.`storage` (`version`, `name`, `location`, `created_at`, `modified_at`) VALUES ('1', 'Document Storage Room 002', '7760 S. Wood Court Madison Heights, MI 48071', '2020-12-12', '2020-12-12');
INSERT INTO `criminal_evidence_management_system`.`storage` (`version`, `name`, `location`, `created_at`, `modified_at`) VALUES ('1', 'Document Storage Room 003', '9654 North Augusta Street West Haven, CT 06516', '2020-12-12', '2020-12-12');

-- Detective --
INSERT INTO `criminal_evidence_management_system`.`detective` (`version`, `username`, `first_name`, `last_name`, `password`, `hiring_date`, `badge_number`, `rank`, `armed`, `status`, `created_at`, `modified_at`) VALUES ('1', 'ja001', 'Jaylan', 'Arias', '123', '2021-09-03', '254254', 'TRAINEE', '0', 'ACTIVE', '2022-06-06', '2022-06-06');
INSERT INTO `criminal_evidence_management_system`.`detective` (`version`, `username`, `first_name`, `last_name`, `password`, `hiring_date`, `badge_number`, `rank`, `armed`, `status`, `created_at`, `modified_at`) VALUES ('1', 'bjb001', 'Billie-Jo', 'Beck', '123', '2003-08-09', '756847', 'SENIOR', '1', 'VACATION', '2022-06-06', '2022-06-06');
INSERT INTO `criminal_evidence_management_system`.`detective` (`version`, `username`, `first_name`, `last_name`, `password`, `hiring_date`, `badge_number`, `rank`, `armed`, `status`, `created_at`, `modified_at`) VALUES ('1', 'mh001', 'Montgomery', 'Harrington', '123', '2012-06-03', '452255', 'JUNIOR', '0', 'ACTIVE', '2022-06-06', '2022-06-06');

-- Evidence --
INSERT INTO `criminal_evidence_management_system`.`evidence` (`version`, `number`, `item_name`, `notes`, `archived`, `criminal_case_id`, `storage_id`, `created_at`, `modified_at`) VALUES ('1', 'E001', 'Unknown Item\'s Name', 'The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.', '0', '1', '3', '2022-06-06', '2022-06-06');
INSERT INTO `criminal_evidence_management_system`.`evidence` (`version`, `number`, `item_name`, `notes`, `archived`, `criminal_case_id`, `storage_id`, `created_at`, `modified_at`) VALUES ('1', 'E002', 'Unknown Item\'s Name', 'All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.', '1', '2', '2', '2022-06-06', '2022-06-06');
INSERT INTO `criminal_evidence_management_system`.`evidence` (`version`, `number`, `item_name`, `notes`, `archived`, `criminal_case_id`, `storage_id`, `created_at`, `modified_at`) VALUES ('1', 'E003', 'Unknown Item\'s Name', 'Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for \'lorem ipsum\' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).', '1', '2', '1', '2022-06-06', '2022-06-06');

-- Track Entry --
INSERT INTO `criminal_evidence_management_system`.`track_entry` (`version`, `date`, `action`, `reason`, `detective_id`, `evedence_id`, `created_at`, `modified_at`) VALUES ('1', '2022-01-02', 'SUBMITTED', 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.', '1', '2', '2022-05-05', '2022-05-05');
INSERT INTO `criminal_evidence_management_system`.`track_entry` (`version`, `date`, `action`, `reason`, `detective_id`, `evedence_id`, `created_at`, `modified_at`) VALUES ('1', '2022-05-05', 'RETURNED', 'There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words.', '2', '2', '2022-05-05', '2022-05-05');
INSERT INTO `criminal_evidence_management_system`.`track_entry` (`version`, `date`, `action`, `reason`, `detective_id`, `evedence_id`, `created_at`, `modified_at`) VALUES ('1', '2022-05-05', 'RETRIEVED', 'The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32.', '3', '1', '2022-05-05', '2022-05-05');

-- WDC --
INSERT INTO `criminal_evidence_management_system`.`working_detective_case` (`detective_id`, `criminal_case_id`) VALUES ('1', '2');
INSERT INTO `criminal_evidence_management_system`.`working_detective_case` (`detective_id`, `criminal_case_id`) VALUES ('1', '3');
INSERT INTO `criminal_evidence_management_system`.`working_detective_case` (`detective_id`, `criminal_case_id`) VALUES ('2', '2');
INSERT INTO `criminal_evidence_management_system`.`working_detective_case` (`detective_id`, `criminal_case_id`) VALUES ('2', '1');
INSERT INTO `criminal_evidence_management_system`.`working_detective_case` (`detective_id`, `criminal_case_id`) VALUES ('3', '2');

-- Create Relationship --
ALTER TABLE `criminal_evidence_management_system`.`criminal_case` 
ADD INDEX `criminalcase_detective_leader_idx` (`lead_investigator` ASC);
;
ALTER TABLE `criminal_evidence_management_system`.`criminal_case` 
ADD CONSTRAINT `criminalcase_detective_leader`
  FOREIGN KEY (`lead_investigator`)
  REFERENCES `criminal_evidence_management_system`.`detective` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
ALTER TABLE `criminal_evidence_management_system`.`evidence` 
ADD INDEX `evidence_of_criminalcase_idx` (`criminal_case_id` ASC),
ADD INDEX `evidence_in_storage_idx` (`storage_id` ASC);
;
ALTER TABLE `criminal_evidence_management_system`.`evidence` 
ADD CONSTRAINT `evidence_of_criminalcase`
  FOREIGN KEY (`criminal_case_id`)
  REFERENCES `criminal_evidence_management_system`.`criminal_case` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `evidence_in_storage`
  FOREIGN KEY (`storage_id`)
  REFERENCES `criminal_evidence_management_system`.`storage` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
ALTER TABLE `criminal_evidence_management_system`.`track_entry` 
ADD INDEX `trackentry_detective_access_idx` (`detective_id` ASC),
ADD INDEX `trackentr_evidence_beaccessed_idx` (`evedence_id` ASC);
;
ALTER TABLE `criminal_evidence_management_system`.`track_entry` 
ADD CONSTRAINT `trackentry_detective_access`
  FOREIGN KEY (`detective_id`)
  REFERENCES `criminal_evidence_management_system`.`detective` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `trackentr_evidence_beaccessed`
  FOREIGN KEY (`evedence_id`)
  REFERENCES `criminal_evidence_management_system`.`evidence` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
ALTER TABLE `criminal_evidence_management_system`.`working_detective_case` 
ADD INDEX `detective_criminalcase_idx` (`detective_id` ASC),
ADD INDEX `criminalcase_detective_idx` (`criminal_case_id` ASC);
;
ALTER TABLE `criminal_evidence_management_system`.`working_detective_case` 
ADD CONSTRAINT `detective_criminalcase`
  FOREIGN KEY (`detective_id`)
  REFERENCES `criminal_evidence_management_system`.`detective` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `criminalcase_detective`
  FOREIGN KEY (`criminal_case_id`)
  REFERENCES `criminal_evidence_management_system`.`criminal_case` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

  
  
  
  
  
  
  
  