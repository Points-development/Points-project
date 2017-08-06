CREATE DATABASE IF NOT EXISTS `pointService` default charset utf8 COLLATE utf8_general_ci;
use pointService;
--e10adc3949ba59abbe56e057f20f883e 是123456的md5
CREATE TABLE IF NOT EXISTS `User` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL UNIQUE,
  `password` varchar(255) NOT NULL DEFAULT 'e10adc3949ba59abbe56e057f20f883e',
  `branch` varchar(255) NOT NULL DEFAULT '',
  `isAdmin` tinyint(1) DEFAULT 0,
  PRIMARY KEY (`id`));

--INSERT INTO `User`(`name`, `password`, `branch`, `isAdmin`) values('gangpu', 'gangpu', 'Shannxi', 1);
--INSERT INTO `User`(`name`, `password`, `branch`, `isAdmin`) values('ganxiangzhen', 'ganxiangzhen', 'henan', 1);
--INSERT INTO `User`(`name`, `branch`, `isAdmin`) values('test', 'test', 0);

CREATE TABLE IF NOT EXISTS `PaperTest` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL UNIQUE,
  PRIMARY KEY (`id`));

--INSERT INTO `PaperTest`(`name`) values('党性体检参考指标');

CREATE TABLE IF NOT EXISTS `PaperQuestion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(512) NOT NULL,
  `test_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`test_id`) REFERENCES `PaperTest` (`id`));
--
--INSERT INTO `PaperQuestion`(`description`, `test_id`) values('我能不能够做到始终不忘记、不动摇、不怀疑对党的信仰，始终按照党的决策和要求积极提升自己的党性修养？', 1);
--INSERT INTO `PaperQuestion`(`description`, `test_id`) values('作为一名共产党员，我能不能关键时刻站得出，危险时刻豁得出，如有危难降临，能否随时准备为党和人民牺牲一切？', 1);
--INSERT INTO `PaperQuestion`(`description`, `test_id`) values('当我听到周围的党员群众妄议组织的工作决策部署时，我能不能够做到出面制止他们，并加以正确引导？', 1);
--INSERT INTO `PaperQuestion`(`description`, `test_id`) values('作为一名共产党员，每一次的组织生活能否认真参加？党章诵读一遍做到了没有？能不能按时足额亲自交纳党费？能不能够做到按照《党章》的要求履行党员的义务？', 1);
--INSERT INTO `PaperQuestion`(`description`, `test_id`) values('在日常生活物质需求上，我能不能够做到勤俭节约、艰苦朴素、量力而行，不跟风攀比、大操大办？', 1);
--INSERT INTO `PaperQuestion`(`description`, `test_id`) values('在考虑问题的时候，我能不能够做到站在集体的角度、发展的角度来思考和解决问题，并做到言行一致、表里如一？ ', 1);
--INSERT INTO `PaperQuestion`(`description`, `test_id`) values('在日常生产生活过程中，我能不能主动维护党的形象，不说与党员身份不相符的话，在公众场合能不能管住自己的言行举止？', 1);
--INSERT INTO `PaperQuestion`(`description`, `test_id`) values('我能不能够做到与各种不文明行为作斗争，不参与封建迷信、赌博等?', 1);
--INSERT INTO `PaperQuestion`(`description`, `test_id`) values('在日常生产生活中与他人产生纠纷时，我能不能够做到按照国家法律法规、社会公德的标准和要求自行妥善处理？', 1);
--INSERT INTO `PaperQuestion`(`description`, `test_id`) values('我能不能够时时处处规范自己的言行，注意自身形象的示范、导向作用，用自己的模范言行为身边的人做出榜样？', 1);
--INSERT INTO `PaperQuestion`(`description`, `test_id`) values('当个人及家庭的事业有所成就的时候，我能不能够做到谦虚谨慎、低调为人、真诚待人?', 1);
--INSERT INTO `PaperQuestion`(`description`, `test_id`) values('正确理解“孝”的含义，我能不能够做到按照“你把我养大，我陪你变老”的理念待好自己家里的老人和父母?', 1);
--INSERT INTO `PaperQuestion`(`description`, `test_id`) values('党员应该吃苦在前，享受在后，工作上我是不是始终坚持积极主动高标准？', 1);
--INSERT INTO `PaperQuestion`(`description`, `test_id`) values('党组织开展各项公益活动、志愿服务时，在没有经济激励和报酬的前提下，我能不能够做到积极参加？', 1);
--INSERT INTO `PaperQuestion`(`description`, `test_id`) values('遇到困难群体时，能不能尽自己力量奉献我的一份爱心？', 1);
--INSERT INTO `PaperQuestion`(`description`, `test_id`) values('在人民群众生命财产安全受到威胁时，我能不能够挺身而出？', 1);
--INSERT INTO `PaperQuestion`(`description`, `test_id`) values('我能不能够做到在社区内不私搭乱建、不乱停车、不随意丢弃、倾倒生活垃圾？', 1);
--INSERT INTO `PaperQuestion`(`description`, `test_id`) values('在村居换届过程中，我能不能严守换届纪律、正确行使党员权利，做到不拉票、不贿选、不吃请、不造谣诽谤他人、不破坏选举会场等？', 1);
--INSERT INTO `PaperQuestion`(`description`, `test_id`) values('我能不能够做到及时、主动的向身边的群众宣传党的路线方针政策？', 1);
--INSERT INTO `PaperQuestion`(`description`, `test_id`) values('我能不能够做到及时排查社区内不安定因素，调解居民各类纠纷，收集群众居民意见并反馈到党组织？', 1);
--INSERT INTO `PaperQuestion`(`description`, `test_id`) values('我能不能够做到利用自身的创业基础，积极捕捉市场信息，拓展自己的事业再上一层楼？', 1);
--INSERT INTO `PaperQuestion`(`description`, `test_id`) values('在生产经营时，我能不能够做到依法经营、诚信经营，按照市场经济的规律和规则抓好生产，做好服务？', 1);
--INSERT INTO `PaperQuestion`(`description`, `test_id`) values('作为一名党员，在发展生产、新建项目之前，我能不能够做到对项目进行环境和秩序上的考虑，以避免周边生态环境、公共秩序的破坏，或者对他人的权益造成侵害？', 1);
--INSERT INTO `PaperQuestion`(`description`, `test_id`) values('是否具有强烈的事业心和责任感，埋头苦干、开拓创新、无私奉献，我能不能够带头在本职岗位上做出优异成绩？', 1);
--INSERT INTO `PaperQuestion`(`description`, `test_id`) values('我能不能够带头贯彻执行党组织各项决策部署，服从组织分配，积极完成党组织交给的任务？', 1);
--INSERT INTO `PaperQuestion`(`description`, `test_id`) values('在接待群众上是否缺乏耐心热情的态度，不愿做深入细致的思想工作，怕同信访群众打交道?', 1);
--INSERT INTO `PaperQuestion`(`description`, `test_id`) values('我是否有利己主义，跟组织讲条件、讨价还价，在名与利、得与失等问题上，不能正确对待？', 1);
--INSERT INTO `PaperQuestion`(`description`, `test_id`) values('我是否有缺乏问题意识、问题导向，不熟悉情况，不掌握数据，不研究问题，主动解决问题的自觉性不强，能力不够？', 1);
--INSERT INTO `PaperQuestion`(`description`, `test_id`) values('我能不能以上率下，首先做到树立服务意识，工作中能不能耐心听取下属和群众的意见和建议？', 1);
--INSERT INTO `PaperQuestion`(`description`, `test_id`) values('我是否存在遇事接待讲排场，偶尔也讲个人感情，工作中存在喜好大于原则的情形？', 1);
--INSERT INTO `PaperQuestion`(`description`, `test_id`) values('是否存在不按照有关规定或者工作要求，向组织请示报告重大问题、重要事项的情形？', 1);
--INSERT INTO `PaperQuestion`(`description`, `test_id`) values('我是否对群众没感情，不关心群众疾苦，坐等上门多、主动问需少，特别是在联系服务对象、困难党员、群众等方面有差距？', 1);



--For now the option is certain and later if needed we can add "FOREIGN KEY (`question_id`) REFERENCES `PaperQuestion` (`id`)";
CREATE TABLE IF NOT EXISTS `PaperOption` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(128) NOT NULL,
  `test_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`test_id`) REFERENCES `PaperTest` (`id`));

--INSERT INTO `PaperOption`(`description`,`test_id`) values('优秀', 1);
--INSERT INTO `PaperOption`(`description`,`test_id`) values('良好', 1);
--INSERT INTO `PaperOption`(`description`,`test_id`) values('一般', 1);
--INSERT INTO `PaperOption`(`description`,`test_id`) values('较差', 1);

--DROP TABLE `User` CASCADE;
--DROP TABLE `PaperItemScore` CASCADE;
--DROP TABLE `PaperScore` CASCADE;
--DROP TABLE `PaperOption` CASCADE;
--DROP TABLE `PaperQuestion` CASCADE;
--DROP TABLE `PaperTest` CASCADE;
--DROP DATABASE `pointService`;

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
