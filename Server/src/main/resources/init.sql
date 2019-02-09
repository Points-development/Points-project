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
INSERT INTO `QuestionCategory` (`category_type`, `category_id`, `description`) values ( '共性指标', 1,'理想信念');
INSERT INTO `QuestionCategory` (`category_type`, `category_id`, `description`) values ( '共性指标', 2,'政治意识');
INSERT INTO `QuestionCategory` (`category_type`, `category_id`, `description`) values ( '共性指标', 3,'学习意识');
INSERT INTO `QuestionCategory` (`category_type`, `category_id`, `description`) values ( '共性指标', 4,'遵守组织纪律');
INSERT INTO `QuestionCategory` (`category_type`, `category_id`, `description`) values ( '共性指标', 5,'大局意识');
INSERT INTO `QuestionCategory` (`category_type`, `category_id`, `description`) values ( '共性指标', 6,'工作作风');
INSERT INTO `QuestionCategory` (`category_type`, `category_id`, `description`) values ( '共性指标', 7,'道德品行');
INSERT INTO `QuestionCategory` (`category_type`, `category_id`, `description`) values ( '共性指标', 8,'生活作风');
INSERT INTO `QuestionCategory` (`category_type`, `category_id`, `description`) values ( '共性指标', 9,'服务奉献意识');
INSERT INTO `QuestionCategory` (`category_type`, `category_id`, `description`) values ( '共性指标', 10,'履行党员义务');
INSERT INTO `QuestionCategory` (`category_type`, `category_id`, `description`) values ( '个性指标', 11,'先锋模范作用发挥');
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (1, 1,1,'存在一定程度的思想迷惘、淡化、动摇甚至丧失了对党的信仰，缺乏对建设中国特色社会主义的信心。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (1, 2,1,'不信马列信鬼神，从封建迷信中寻求精神寄托，遇事“问计于神”。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (1, 3,1,'误认为市场经济就是追求效益最大化，工作中只追求个人利益而丢掉国家、集体和他人利益，淡化为人民服务宗旨。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (2, 4,1,'听到家人、亲友、身边工作人员妄议组织的工作决策部署，视而不见、装聋作哑、听之任之。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (2, 5,1,'缺乏进取精神，缺乏原则立场，事不关己，高高挂起，好事不点头，坏事不摇头。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (2, 6,1,'在贯彻落实组织决策部署时搞上有政策、下有对策，合意就执行，不合意的就折扣、搞变通，甚至出台“土政策”。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (3, 7,1,'没有把学习放在重要位置，把经济工作和其他业务工作当作硬任务，时常出现硬任务挤压软任务现象，使理论学习落不到实处。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (3, 8,1,'学习以听读为主，发言讨论往往是脱离实际的空议论，常常出现跑题，起不到讨论的目的。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (3, 9,1,'用理论学习装点门面，不能做到学原文、悟原理，所学理论与实际工作脱节，起不到理论指导实践的应有效果。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (4, 10,1,'对重大问题事前不请示、事后不报告，搞先斩后奏、边斩边奏、甚至斩而不奏；对个人报告事项瞒而不报。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (4, 11,1,'自己意见未被组织采纳，牢骚满腹，散布不满情绪，甚至在公开场合发表与党组织的决议相反的言论。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (4, 12,1,'对工作麻木不仁，上班迟到早退，上网聊天、玩游戏，浏览网页，甚至无故溜之大吉，逛街、会友、办私事。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (5, 13,1,'一事当前，先替自己打算。组织任命的职务，老觉着亏了自己，动不动就闹情绪；组织做的决定，执行时做“选择题”，讨价还价。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (5, 14,1,'团队意识不够强、着眼点不够高、胸怀气度不够大，在工作中不愿与他人协作。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (5, 15,1,'工作安排没有大局意识，随意性大，“东一榔头西一棒槌”，想到哪里干到哪，轻重缓急不分。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (6, 16,1,'在工作上缺乏紧迫感、危机感，工作拖沓，心不在焉，甚至擅离职守，影响了本职工作的完成。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (6, 17,1,'用会议贯彻会议，就文件落实文件，提不出具体而又切合实际的意见，致使工作浮于表面，没有实效。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (6, 18,1,'工作中存在指令式生、冷、硬态度，对待群众没有耐心，甚至发生口角，激化干群矛盾，不能热情服务群众。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (7, 19,1,'对社会发展现状的了解不够，看社会的阴暗面较多，对社会主流和积极因素认识不清，从而对党的事业丧失信心，甚至满腹牢骚，缺乏基本政治品德。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (7, 20,1,'社会公德心淡漠麻木，公共场所高声喧哗、随地吐痰、无烟场所吸烟等，不注重公共秩序，突发急难险重事件不挺身而出，不能为百姓树立好榜样。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (7, 21,1,'违背孝道，不关心父母、不赡养老人。个人私生活不检点，损害家庭和谐，伤害亲人情感。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (8, 22,1,'借工作关系增进“友谊”，经常相互宴请、互通有无，今天我请你，明天你请我，以各种名义拉拉扯扯。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (8, 23,1,'骄气有余，谦虚不够，听不进别人意见，不能正确对待他人的批评和意见。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (8, 24,1,'喜庆节宴或日常生活中铺张浪费，盲目跟风攀比，讲排场比阔气。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (9, 25,1,'不愿去艰难环境、基层一线中锻炼，或者抱着“镀金”心态。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (9, 26,1,'不很好利用自己的岗位职责做更多的贡献，满足于工作任务的一般完成，不注重工作质量的提高。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (9, 27,1,'将自己混同于一般群众，在没有经济激励和报酬的前提下，对于志愿活动、义务劳动能逃则逃、能避则避。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (10, 28,1,'不积极参加组织生活，党费缴纳不主动、不及时、不足额。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (10, 29,1,'不忠实地向党组织汇报思想和工作，对党组织隐瞒自己的观点和行动。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (10, 30,1,'对党的工作不提出合理化建议和倡议，不通过参加党的有关会议和活动阐述自己对党的政策的观点。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (11, 31,4,'在社区或村内私搭乱建、随意停车、丢弃倾倒生活垃圾。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (11, 32,2,'不按时参加党组织开展的公益活动或义务劳动。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (11, 33,2,'认为村居文化建设、产业发展、环境保护、纠纷调节都是村干部的事情，与自己无关，不参与不配合。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (11, 31,3,'满足于现有成绩，不积极创新，不主动开拓市场。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (11, 32,3,'在从事生产经营时，不能做到依法经营、诚信经营，存在偷税避税、以假充真、哄抬市场等不法经营行为。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (11, 33,3,'在发展生产、新建项目之前，只在乎经济效益，不考虑对周边生态环境、公共秩序的破坏以及他人的权益造成侵害。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (11, 31,4,'首问负责制落实不到位，上班时间串岗闲聊，遇到群众咨询不热情、不解释、不引荐。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (11, 32,4,'向所在社区党组织报到不积极、不主动，不愿参加社区党组织开展的志愿服务活动。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (11, 33,4,'不能积极客观真实反映社情民意，不主动参与化解各类矛盾纠纷。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (11, 31,5,'遇事接待讲排场，偶尔也讲个人感情，工作中存在喜好大于原则的情形。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (11, 32,5,'对群众没感情，不关心群众疾苦，坐等上门多、主动问需少，特别是在联系服务对象、困难党员、群众等方面有差距。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (11, 33,5,'工作中急功近利，心浮气躁，不采纳下属意见，不听取群众需求。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (11, 34,1,'你认为你自己或评测对象目前在政治纪律、组织纪律、道德品行、履行义务、模范带头等方面还存在哪些问题？',2,1);
INSERT INTO `PaperOption` (`option_id`, `description`,`test_id`, `point`) values (1, '从来没有', 1, 5);
INSERT INTO `PaperOption` (`option_id`, `description`,`test_id`, `point`) values (2, '偶尔有', 1, 3);
INSERT INTO `PaperOption` (`option_id`, `description`,`test_id`, `point`) values (3,'经常有', 1, 0);
