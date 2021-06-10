INSERT INTO `UserProperty`(`name`) values('共性');
INSERT INTO `UserProperty`(`name`) values('农村（社区）党员');
INSERT INTO `UserProperty`(`name`) values('企业和社会组织党员');
INSERT INTO `UserProperty`(`name`) values('机关事业单位党员');
INSERT INTO `UserProperty`(`name`) values('党员领导干部');
INSERT INTO `User`(`user_property_id`, `name`, `realName`, `branch`, `organization`, `isAdmin`) values(3, 'gangpu', 'pugang', 'Shannxi', 'ibm', 1);
INSERT INTO `User`(`user_property_id`, `name`, `realName`, `branch`, `organization`, `isAdmin`) values(4, 'xzgan', 'ganxiangzhen', 'henan', 'google', 1);
INSERT INTO `User`(`user_property_id`, `name`, `realName`, `branch`, `organization`, `isAdmin`) values(2, 'test', 'test', 'Shannxi', 'ibm', 0);
INSERT INTO `User`(`user_property_id`, `name`, `realName`, `branch`, `organization`, `isAdmin`) values(2, 'test1', 'test1', 'Shannxi', 'ibm', 0);


INSERT INTO `PaperTest`(`name`, `attribute`) values('党性体检参考指标', 1);
INSERT INTO `QuestionCategory` (`category_type`, `category_id`, `description`) values ( '共性指标', 1,'把准政治方向');
INSERT INTO `QuestionCategory` (`category_type`, `category_id`, `description`) values ( '共性指标', 2,'加强党的政治领导');
INSERT INTO `QuestionCategory` (`category_type`, `category_id`, `description`) values ( '共性指标', 3,'夯实政治根基');
INSERT INTO `QuestionCategory` (`category_type`, `category_id`, `description`) values ( '共性指标', 4,'涵养政治生态');
INSERT INTO `QuestionCategory` (`category_type`, `category_id`, `description`) values ( '共性指标', 5,'防范政治风险');
INSERT INTO `QuestionCategory` (`category_type`, `category_id`, `description`) values ( '共性指标', 6,'永葆政治本色');
INSERT INTO `QuestionCategory` (`category_type`, `category_id`, `description`) values ( '共性指标', 7,'提高政治能力');
INSERT INTO `QuestionCategory` (`category_type`, `category_id`, `description`) values ( '个性指标', 8,'先锋模范作用发挥');
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (1, 1,1,'一谈到理想信念，总认为是虚的、是唱高调，工作和生活中奉行实用主义，遇到份外工作或其他任务，只讲求经济利益，要补助、提报酬。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (2, 2,1,'共产主义是革命战争年代崇尚追求的，和平年代只要经济发展、过上好日子就行了。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (3, 3,1,'中国特色社会主义到底能干多久，现在谈还为时过早，活好当下便是。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (4, 4,1,'遇到党组织调研或了解情况时，说些冠冕堂皇的就行了，讲实话、道实情吃亏最多。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (5, 5,1,'从宗教迷信中寻找精神寄托，热衷算命看相、烧香拜佛，遇事“问计于神”。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (6, 6,1,'公共场合对党的一些政策决策说三道四、指手画脚，发布不负责任或与身份不符的言论。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (7, 7,1,'表面上爱党爱国，私底下对党和组织口是心非、阳奉阴违，表里不一、欺上瞒下，搞两面派、做两面人。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (8, 8,1,'对上级决策部署不重视、不在乎、喊口号、装样子，表态多调门高、行动少落实差。',1,1);
INSERT INTO `PaperOption` (`option_id`, `description`,`question_id`, `point`) values (1, '没有', 1, 2);
INSERT INTO `PaperOption` (`option_id`, `description`,`question_id`, `point`) values (2, '有',   1, 0);
INSERT INTO `PaperOption` (`option_id`, `description`,`question_id`, `point`) values (1, '没有', 2, 2);
INSERT INTO `PaperOption` (`option_id`, `description`,`question_id`, `point`) values (2, '有',   2, 0);
INSERT INTO `PaperOption` (`option_id`, `description`,`question_id`, `point`) values (1, '没有', 3, 2);
INSERT INTO `PaperOption` (`option_id`, `description`,`question_id`, `point`) values (2, '有',   3, 0);
INSERT INTO `PaperOption` (`option_id`, `description`,`question_id`, `point`) values (1, '没有', 4, 2);
INSERT INTO `PaperOption` (`option_id`, `description`,`question_id`, `point`) values (2, '有',   4, 0);
INSERT INTO `PaperOption` (`option_id`, `description`,`question_id`, `point`) values (1, '没有', 5, 2);
INSERT INTO `PaperOption` (`option_id`, `description`,`question_id`, `point`) values (2, '有',   5, 0);
INSERT INTO `PaperOption` (`option_id`, `description`,`question_id`, `point`) values (1, '没有', 6, 2);
INSERT INTO `PaperOption` (`option_id`, `description`,`question_id`, `point`) values (2, '有',   6, 0);
INSERT INTO `PaperOption` (`option_id`, `description`,`question_id`, `point`) values (1, '没有', 7, 2);
INSERT INTO `PaperOption` (`option_id`, `description`,`question_id`, `point`) values (2, '有',   7, 0);
INSERT INTO `PaperOption` (`option_id`, `description`,`question_id`, `point`) values (1, '没有', 8, 2);
INSERT INTO `PaperOption` (`option_id`, `description`,`question_id`, `point`) values (2, '有',   8, 0);


/* test questions for party history */
INSERT INTO `PaperTest`(`name`, `attribute`) values('党史测评', 0);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (1,1,'一谈到理想信念，总认为是虚的、是唱高调，工作和生活中奉行实用主义，遇到份外工作或其他任务，只讲求经济利益，要补助、提报酬。',1,2);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (2,1,'共产主义是革命战争年代崇尚追求的，和平年代只要经济发展、过上好日子就行了。',1,2);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (3,1,'认为工作就是一份养家糊口的职业而已，没有当成体现人生价值、实现理想抱负的事业来干，整天混日子。',1,2);
INSERT INTO `PaperOption` (`option_id`, `description`,`question_id`, `point`) values (1, '没有', 9, 5);
INSERT INTO `PaperOption` (`option_id`, `description`,`question_id`, `point`) values (2, '有',   9, 0);
INSERT INTO `PaperOption` (`option_id`, `description`,`question_id`, `point`) values (1, '没有', 10, 5);
INSERT INTO `PaperOption` (`option_id`, `description`,`question_id`, `point`) values (2, '有',   10, 0);
INSERT INTO `PaperOption` (`option_id`, `description`,`question_id`, `point`) values (1, '没有', 11, 5);
INSERT INTO `PaperOption` (`option_id`, `description`,`question_id`, `point`) values (2, '有',   11, 0);
