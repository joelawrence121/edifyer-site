ALTER TABLE `edifyer_db`.`company`
ADD COLUMN `count` INT NULL DEFAULT 0 AFTER `category`;

CREATE TABLE `edifyer_db`.`ratingLog` (
  `rating_id` INT NOT NULL,
  `date` DATETIME NOT NULL,
  PRIMARY KEY (`rating_id`, `date`),
  CONSTRAINT `fk_ratingLog_id`
    FOREIGN KEY (`rating_id`)
    REFERENCES `edifyer_db`.`rating` (`rating_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE INDEX idx_company_name ON company (name);
