-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8mb3 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Lecture`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Lecture` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `numerLecture` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `numerLecture_UNIQUE` (`numerLecture` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`Path`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Path` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(90) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`User` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`login` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`Meeting`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Meeting` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idPath` INT NOT NULL,
  `idLecture` INT NOT NULL,
  `idUser` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Meeting_Path_idx` (`idPath` ASC) VISIBLE,
  INDEX `fk_Meeting_Lecture1_idx` (`idLecture` ASC) VISIBLE,
  INDEX `fk_Meeting_User1_idx` (`idUser` ASC) VISIBLE,
  CONSTRAINT `fk_Meeting_Lecture1`
    FOREIGN KEY (`idLecture`)
    REFERENCES `mydb`.`Lecture` (`id`),
  CONSTRAINT `fk_Meeting_Path`
    FOREIGN KEY (`idPath`)
    REFERENCES `mydb`.`Path` (`id`),
  CONSTRAINT `fk_Meeting_User1`
    FOREIGN KEY (`idUser`)
    REFERENCES `mydb`.`User` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
