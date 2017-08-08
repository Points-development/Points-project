CREATE DATABASE IF NOT EXISTS `pointService` default charset utf8 COLLATE utf8_general_ci;
use pointService;

CREATE TABLE IF NOT EXISTS `UserProperty` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL UNIQUE,
  PRIMARY KEY (`id`));

--e10adc3949ba59abbe56e057f20f883e 是123456的md5
CREATE TABLE IF NOT EXISTS `User` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_property_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL UNIQUE,
  `password` varchar(255) NOT NULL DEFAULT 'e10adc3949ba59abbe56e057f20f883e',
  `branch` varchar(255) NOT NULL DEFAULT 'NULL',
  `isAdmin` tinyint(1) DEFAULT 0,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_property_id`) REFERENCES `UserProperty` (`id`));

CREATE TABLE IF NOT EXISTS `PaperTest` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL UNIQUE,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `PaperQuestion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_property_id` int(11) NOT NULL,
  `description` varchar(512) NOT NULL,
  `test_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`test_id`) REFERENCES `PaperTest` (`id`),
  FOREIGN KEY (`user_property_id`) REFERENCES `UserProperty` (`id`));

--For now the option is certain and later if needed we can add "FOREIGN KEY (`question_id`) REFERENCES `PaperQuestion` (`id`)";
CREATE TABLE IF NOT EXISTS `PaperOption` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(128) NOT NULL,
  `test_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`test_id`) REFERENCES `PaperTest` (`id`));

CREATE TABLE IF NOT EXISTS `PaperScore` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `scorer` varchar(128) NOT NULL,
  `scoree` varchar(128) NOT NULL,
  `lastModifiedTime` timestamp NOT NULL,
  `paper_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`paper_id`) REFERENCES `PaperTest` (`id`));

CREATE TABLE IF NOT EXISTS `PaperItemScore` (
  `score_id` int(128) NOT NULL,
  `question_id` int(11) NOT NULL,
  `option_id` int(11) NOT NULL,
  PRIMARY KEY (`score_id`, `question_id`, `option_id`),
  FOREIGN KEY (`score_id`) REFERENCES `PaperScore` (`id`),
  FOREIGN KEY (`question_id`) REFERENCES `PaperQuestion` (`id`),
  FOREIGN KEY (`option_id`) REFERENCES `PaperOption` (`id`));
