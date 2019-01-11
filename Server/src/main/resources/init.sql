INSERT INTO `UserProperty`(`name`) values('共性');
INSERT INTO `UserProperty`(`name`) values('村（社区）党员');
INSERT INTO `UserProperty`(`name`) values('“两新”组织党员');
INSERT INTO `UserProperty`(`name`) values('机关企事业党员');
INSERT INTO `UserProperty`(`name`) values('党员领导干部');
INSERT INTO `User`(`user_property_id`, `name`, `realName`, `branch`, `organization`, `isAdmin`) values(3, 'gangpu', 'pugang', 'Shannxi', 'ibm', 1);
INSERT INTO `User`(`user_property_id`, `name`, `realName`, `branch`, `organization`, `isAdmin`) values(4, 'xzgan', 'ganxiangzhen', 'henan', 'google', 1);
INSERT INTO `User`(`user_property_id`, `name`, `realName`, `branch`, `organization`, `isAdmin`) values(2, 'test', 'test', 'Shannxi', 'ibm', 0);
INSERT INTO `User`(`user_property_id`, `name`, `realName`, `branch`, `organization`, `isAdmin`) values(2, 'test1', 'test1', 'Shannxi', 'ibm', 0);
INSERT INTO `PaperTest`(`name`) values('党性体检参考指标');
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (1,1,'对党不忠诚、不老实，表里不一，阳奉阴违，欺上瞒下，搞两面派、做两面人。',1,1);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (2,1,'工作或生活中遇到挫折和困难有时存在思想迷惘、情绪波动等现象，缺乏干工作的信心和决心。',1,1);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (3,1,'听到家人、亲友、身边工作人员妄议组织的工作决策部署，有视而不见、装聋作哑、听之任之等现象。',1,1);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (4,1,'在贯彻落实组织决策部署时搞上有政策、下有对策，合意就执行，不合意的就折扣、搞变通。',1,1);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (5,1,'存在以会议落实会议，以文件落实文件，工作落实过程中缺乏一抓到底的韧劲。',1,1);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (6,1,'借故工作忙抽不开身等原因，政治理论学习不够经常，存在对党的政策等理论掌握不清。',1,1);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (7,1,'有时存在纪律观念淡薄，上班、开会、学习等活动存在迟到早退现象。',1,1);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (8,1,'在干部调整中，有时老觉着亏了自己，存在动不动就闹情绪等现象。',1,1);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (9,1,'在落实工作中，有时存在不是自己管的事或遇到困难或麻烦事，借故推向别人，不愿担当。',1,1);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (10,1,'工作安排随意性大，有时存在“东一榔头西一棒槌”、想到哪里干到哪，不分轻重缓急等现象。',1,1);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (11,1,'工作中全局意识不够强，有时不能做到用十个手指弹钢琴，存在顾此失彼等现象。',1,1);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (12,1,'工作作风不深入、不扎实，存在深入基层和村组调查研究不够，指导和督查不够深入，工作效果不理想。',1,1);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (13,1,'不关心父母、同事，不能与他人很好沟通交流，造成家庭、邻里或同事间不和谐。',1,1);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (14,1,'社会责任意识淡薄，公德心淡漠麻木，面对突发急难险重事件，与己无关高高挂起。',1,1);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (15,1,'对自己要求不严，有时存在接受吃请等现象。',1,1);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (16,1,'借故家庭困难或身体原因，不愿去艰苦环境、基层一线中锻炼，或者抱着“镀金”心态，或散散心的想法去一线工作。',1,1);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (17,2,'在村（社区）内私搭乱建、乱停车、随意丢弃、倾倒生活垃圾，屋内外环境卫生不整洁现象？',1,1);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (18,2,'在村（社区）换届过程中存在拉票、贿选、吃请、造谣诽谤他人或破坏选举会场等现象？',1,1);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (19,2,'未按照无职党员设岗定责的规定在固定时间进行履职，未及时党员公开承诺进行践诺、评诺，并发挥先锋模范作用？',1,1);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (20,2,'不关心村（社区）内不安定因素，被动调解各类纠纷，未及时收集群众意见并反馈到党组织？',1,1);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (21,3,'不关心维护各方合法权益，未能反映职工诉求及依法维护职工合法权益，协调各方利益关系，未化解矛盾纠纷。',1,1);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (22,3,'在生产经营时，存在不依法经营、诚信经营，不遵守市场经济的规律和规则抓好生产，有时存在“散乱污”，服务不到位现象？',1,1);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (23,3,'在发展生产、新建项目之前，未对项目进行环境和秩序上的考虑，影响周边生态环境、公共秩序的破坏，或者对他人的权益造成侵害。',1,1);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (24,3,'不遵守职业道德，不积极参与丰富多彩的企业文化活动或未在本职岗位上做出优异成绩？',1,1);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (25,4,'在公开场合有时存在口无遮拦，无意识谈论工作机密或“内部消息”，造成工作机密泄露或造成不好影响。',1,1);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (26,4,'工作上执行力不够强，有时存在能拖就拖或推诿扯皮、拈轻怕重、不敢担当等现象。',1,1);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (27,4,'工作中，有时存在团队意识不够强、着眼点不够高、胸怀气度不够大，工作中存在不愿与他人协作、搞内耗等现象。',1,1);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (28,4,'原则性不强、公心不足，没有做到公开、公正、透明，办事有优亲厚友、拉帮结派等现象。',1,1);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (29,5,'在工作中存在得过且过，有时存在不够认真细心，有时存在急躁情绪。',1,1);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (30,5,'工作中思路不够开阔，创新意识不够强，与其他领导、同事沟通不到位，工作力度不大。',1,1);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (31,5,'在干部管理、党员管理、组织谈话、干部推荐等工作中，有“老好人”思想，存在不敢说、不愿说、态度模糊等现象。',1,1);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (32,5,'由于工作忙等原因，“主题党日”活动参加不够经常。',1,1);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (33,1,'你认为你自己或评测对象目前在政治纪律、组织纪律、道德品行、履行义务、模范带头等方面还存在哪些问题？',2,1);
INSERT INTO `PaperTest`(`name`) values('党性体检参考指标互检题');
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (1,1,'对党不忠诚、不老实，表里不一，阳奉阴违，欺上瞒下，搞两面派、做两面人。',1,2);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (2,1,'在公开场合有时存在口无遮拦，无意识谈论工作机密或“内部消息”，造成工作机密泄露或造成不好影响。',1,2);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (3,1,'借故工作忙等原因，存在理论学习不深入不经常，对党的路线方针政策学习不够、了解不深，不能充分有效地将上级精神贯彻到实际工作中。',1,2);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (4,1,'存在以会议落实会议，以文件落实文件，深入基层一线指导较少。',1,2);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (5,1,'工作中，有时存在团队意识不够强、着眼点不够高、胸怀气度不够大，工作中存在不愿与他人协作、搞内耗等现象。',1,2);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (6,1,'工作上执行力不够强，有时存在能拖就拖或推诿扯皮、拈轻怕重、不敢担当等现象。',1,2);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (7,1,'原则性不强、公心不足，没有做到公开、公正、透明，办事有优亲厚友、拉帮结派等现象。',1,2);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (8,1,'民主意识不强，存在急功近利，心浮气躁等现象，不能采纳下属意见，听不进去群众意见和建议。',1,2);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (9,1,'工作和平时生活中，对自己要求不严格，有时存在接受吃请或接受礼物等情况和现象。',1,2);
INSERT INTO `PaperQuestion` (`question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (10,1,'有老好人思想或行为，在贯彻组织生活会、谈心谈话、民主评议党员等组织生活制度过程中，不敢说、不愿说、不敢管等现象。',1,2)
INSERT INTO `PaperOption`(`option_id`, `description`,`test_id`, `point`) values(1, '从来没有', 1, 5);
INSERT INTO `PaperOption`(`option_id`, `description`,`test_id`, `point`) values(2, '偶尔有', 1, 4);
INSERT INTO `PaperOption`(`option_id`, `description`,`test_id`, `point`) values(3,'经常有', 1, 1);
INSERT INTO `PaperOption`(`option_id`, `description`,`test_id`, `point`) values(1, '从来没有', 2, 10);
INSERT INTO `PaperOption`(`option_id`, `description`,`test_id`, `point`) values(2, '偶尔有', 2, 8);
INSERT INTO `PaperOption`(`option_id`, `description`,`test_id`, `point`) values(3,'经常有', 2, 2);
