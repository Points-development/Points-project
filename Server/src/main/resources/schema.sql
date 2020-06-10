CREATE DATABASE IF NOT EXISTS `pointServiceYongShouXian` default charset utf8 COLLATE utf8_general_ci;
use pointServiceYongShouXian;

CREATE TABLE IF NOT EXISTS `UserProperty` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL UNIQUE,
  PRIMARY KEY (`id`));

/**
 * e10adc3949ba59abbe56e057f20f883e 是123456的md5
 * 21218cca77804d2ba1922c33e0151105 是888888的md5
 */
CREATE TABLE IF NOT EXISTS `User` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_property_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL UNIQUE,
  `realName` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL DEFAULT '21218cca77804d2ba1922c33e0151105',
  `branch` varchar(255) NOT NULL DEFAULT 'NULL',
  `organization` varchar(255) NOT NULL,
  `isAdmin` tinyint(1) DEFAULT 0,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_property_id`) REFERENCES `UserProperty` (`id`));

CREATE TABLE IF NOT EXISTS `OrganBranch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `branch` varchar(255) NOT NULL,
  `organization` varchar(255) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `PaperTest` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL UNIQUE,
  PRIMARY KEY (`id`));
  
CREATE TABLE IF NOT EXISTS `QuestionCategory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) NOT NULL,
  `description` varchar(128) NOT NULL,
  `category_type` varchar(255) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `PaperQuestion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  `user_property_id` int(11) NOT NULL,
  `description` varchar(512) NOT NULL,
  `type` int(11) NOT NULL,
  `test_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`test_id`) REFERENCES `PaperTest` (`id`),
  FOREIGN KEY (`category_id`) REFERENCES `QuestionCategory` (`id`),
  FOREIGN KEY (`user_property_id`) REFERENCES `UserProperty` (`id`));

/**
 * For now the option is certain and later if needed we can add "FOREIGN KEY (`question_id`) REFERENCES `PaperQuestion` (`id`)";
 */
CREATE TABLE IF NOT EXISTS `PaperOption` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(128) NOT NULL,
  `option_id` int(11) NOT NULL,
  `point` int(11) NOT NULL,
  `test_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`test_id`) REFERENCES `PaperTest` (`id`));

CREATE TABLE IF NOT EXISTS `PaperScore` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `scorer` varchar(128) NOT NULL,
  `scoree` varchar(128) NOT NULL,
  `point` int(11) NOT NULL,
  `lastModifiedTime` timestamp NOT NULL,
  `paper_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  constraint PS_UNIQUE unique(scorer, scoree),
  FOREIGN KEY (`paper_id`) REFERENCES `PaperTest` (`id`));
  
CREATE TABLE IF NOT EXISTS `PaperCategoryScore` (
  `score_id` int(128) NOT NULL,
  `category_id` int(11) NOT NULL,
  `point` int(11),
  PRIMARY KEY (`score_id`, `category_id`),
  FOREIGN KEY (`score_id`) REFERENCES `PaperScore` (`id`) on delete cascade,
  FOREIGN KEY (`category_id`) REFERENCES `QuestionCategory` (`id`));

CREATE TABLE IF NOT EXISTS `PaperItemScore` (
  `score_id` int(128) NOT NULL,
  `question_id` int(11) NOT NULL,
  `option_id` int(11),
  `answer` text,
  PRIMARY KEY (`score_id`, `question_id`),
  FOREIGN KEY (`score_id`) REFERENCES `PaperScore` (`id`) on delete cascade,
  FOREIGN KEY (`question_id`) REFERENCES `PaperQuestion` (`id`));
  
CREATE TABLE IF NOT EXISTS `ZuZhiPingJia` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(128) NOT NULL,
  `realName` varchar(128) NOT NULL,
  `liXiangXinNian` int(11),
  `zhengZhiYiShi` int(11),
  `xueXiYiShi` int(11),
  `zuZhiJiLv` int(11),
  `daJuYiShi` int(11),
  `gongZuoZuoFeng` int(11),
  `daoDePinXing` int(11),
  `shengHuoZuoFeng` int(11),
  `fuWuYiShi` int(11),
  `lvXingDangYuanYiWu` int(11),
  `xianFengMoFanZuoYongFaHui` int(11),
  `total` int(11),
  `problem` varchar(1024),
  `lastModifiedTime` timestamp,
  PRIMARY KEY (`id`));
  
  CREATE TABLE IF NOT EXISTS `QunZhongPingYi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(128) NOT NULL,
  `realName` varchar(128) NOT NULL,
  `liXiangXinNian` int(11),
  `zhengZhiYiShi` int(11),
  `xueXiYiShi` int(11),
  `zuZhiJiLv` int(11),
  `daJuYiShi` int(11),
  `gongZuoZuoFeng` int(11),
  `daoDePinXing` int(11),
  `shengHuoZuoFeng` int(11),
  `fuWuYiShi` int(11),
  `lvXingDangYuanYiWu` int(11),
  `xianFengMoFanZuoYongFaHui` int(11),
  `total` int(11),
  `problem` varchar(1024),
  `lastModifiedTime` timestamp,
  PRIMARY KEY (`id`));
  
  CREATE TABLE IF NOT EXISTS `ZiPing` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(128) NOT NULL,
  `realName` varchar(128) NOT NULL,
  `total` int(11),
  `problem` varchar(1024),
  `lastModifiedTime` timestamp,
  PRIMARY KEY (`id`));
  
  CREATE TABLE IF NOT EXISTS `HuPing` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(128) NOT NULL,
  `realName` varchar(128) NOT NULL,
  `total` int(11),
  `problem` varchar(1024),
  `lastModifiedTime` timestamp,
  PRIMARY KEY (`id`));
  
  CREATE TABLE IF NOT EXISTS `DeFenHuiZong` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(128) NOT NULL,
  `realName` varchar(128) NOT NULL,
  `hongXian` varchar(1024),
  `jianKang` varchar(1024),
  `lastModifiedTime` timestamp,
  PRIMARY KEY (`id`));
  
  CREATE TABLE IF NOT EXISTS `BaoGaoDan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(128) NOT NULL,
  `realName` varchar(128) NOT NULL,
  `problem` varchar(1024),
  `tiGao` varchar(1024),
  `lastModifiedTime` timestamp,
  PRIMARY KEY (`id`));
