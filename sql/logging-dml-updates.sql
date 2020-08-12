ALTER TABLE `edifyer_db`.`company`
DROP count;

DROP TABLE ratingLog;

CREATE TABLE `edifyer_db`.`companyLog` (
  `company_id` INT NOT NULL,
  `date` DATETIME NOT NULL,
  PRIMARY KEY (`company_id`, `date`),
  CONSTRAINT `fk_companyLog`
    FOREIGN KEY (`company_id`)
    REFERENCES `edifyer_db`.`company` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE INDEX idx_company_name ON company (name);
