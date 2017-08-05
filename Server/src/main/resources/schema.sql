CREATE DATABASE IF NOT EXISTS `pointService`;
use pointService;
CREATE TABLE IF NOT EXISTS `User` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL UNIQUE,
  `password` varchar(255) NOT NULL DEFAULT '123456',
  `branch` varchar(255) NOT NULL DEFAULT '',
  `isAdmin` tinyint(1)  NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`));
  
--INSERT INTO `User`(`name`, `password`, `branch`, `isAdmin`) values('gangpu', 'gangpu', 'Shannxi', 1);
--INSERT INTO `User`(`name`, `password`, `branch`, `isAdmin`) values('ganxiangzhen', 'ganxiangzhen', 'henan', 1);
--INSERT INTO `User`(`name`, `branch`, `isAdmin`) values('test', 'test', 0);