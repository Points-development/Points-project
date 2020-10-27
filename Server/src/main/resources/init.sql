INSERT INTO `UserProperty`(`name`) values('共性');
INSERT INTO `UserProperty`(`name`) values('主要领导干部');
INSERT INTO `UserProperty`(`name`) values('其他领导干部');
INSERT INTO `User`(`user_property_id`, `name`, `realName`, `branch`, `organization`, `isAdmin`) values(3, 'gangpu', 'pugang', 'Shannxi', 'ibm', 1);
INSERT INTO `User`(`user_property_id`, `name`, `realName`, `branch`, `organization`, `isAdmin`) values(3, 'xzgan', 'ganxiangzhen', 'Shannxi', 'google', 1);
INSERT INTO `User`(`user_property_id`, `name`, `realName`, `branch`, `organization`, `isAdmin`) values(2, 'test', 'test', 'Shannxi', 'ibm', 0);
INSERT INTO `User`(`user_property_id`, `name`, `realName`, `branch`, `organization`, `isAdmin`) values(2, 'guest', 'guest', 'ibm', 'guest', 0);
INSERT INTO `PaperTest`(`name`) values('政治体检指标');
INSERT INTO `QuestionCategory` (`category_type`, `category_id`, `description`) values ( '共性指标', 1,'把准政治方向');
INSERT INTO `QuestionCategory` (`category_type`, `category_id`, `description`) values ( '共性指标', 2,'加强党的政治领导');
INSERT INTO `QuestionCategory` (`category_type`, `category_id`, `description`) values ( '共性指标', 3,'夯实政治根基');
INSERT INTO `QuestionCategory` (`category_type`, `category_id`, `description`) values ( '共性指标', 4,'涵养政治生态');
INSERT INTO `QuestionCategory` (`category_type`, `category_id`, `description`) values ( '共性指标', 5,'防范政治风险');
INSERT INTO `QuestionCategory` (`category_type`, `category_id`, `description`) values ( '共性指标', 6,'永葆政治本色');
INSERT INTO `QuestionCategory` (`category_type`, `category_id`, `description`) values ( '共性指标', 7,'提高政治能力');
INSERT INTO `QuestionCategory` (`category_type`, `category_id`, `description`) values ( '个性指标', 8,'政治体检个性指标');
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (1, 1,1,'信仰信念是虚无渺茫的、是唱高调，实惠、报酬才是看得见、摸得着的。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (1, 2,1,'共产主义是革命战争年代崇尚追求的，和平年代只要经济发展、过上好日子就行了。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (1, 3,1,'中国特色社会主义到底能干多久，现在谈还为时过早，活好当下便是。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (1, 4,1,'遇到党组织调研或了解情况时，说些冠冕堂皇的就行了，讲实话、道实情吃亏最多。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (1, 5,1,'从宗教迷信中寻找精神寄托，热衷算命看相、烧香拜佛，遇事“问计于神”。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (2, 6,1,'公共场合对党的一些政策决策说三道四、指手画脚，发布不负责任或与身份不符的言论。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (2, 7,1,'表面上爱党爱国，私底下对党和组织口是心非、阳奉阴违，表里不一、欺上瞒下，搞两面派、做两面人。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (2, 8,1,'对上级决策部署不重视、不在乎、喊口号、装样子，表态多调门高、行动少落实差。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (2, 9,1,'对“两个维护”，表面尊崇、心里不以为然，觉得离自己太远。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (2, 10,1,'认为只要把工作做好、任务落实就行了，讲不讲政治都不是什么大事。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (3, 11,1,'我自小农村长大，群众心里咋想，我心里一本账，没必要深入群众。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (3, 12,1,'下乡调研就那么回事，无非就是出发一车子、开会一屋子、发言念稿子么，走走程序、做个样子就行了。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (3, 13,1,'我是领导，下属为我服务，写个调研报告什么的，是他分内的事。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (3, 14,1,'和农民打成一片、做朋友，有失干部身份，不划算。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (3, 15,1,'群众说好不算好，只要领导说好就行了。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (4, 16,1,'党内不称同志，以兄弟姐妹相称，抬高官衔戴高帽，称呼“老大”“老板”等。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (4, 17,1,'现在这请示那请示，管得太死太严了不好，不利于推动工作。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (4, 18,1,'要想当官，就得拉关系、跑门路，不跑不送不行。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (4, 19,1,'领导干部只要开好民主生活会就行了，组织生活会是普通党员的事，没必要再参加，如果参加也是象征性的照个相、留个痕。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (4, 20,1,'所谓政绩，就是做给上级看的，只要上级看得到、能认可，就是好政绩。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (5, 21,1,'对社会上、网络上出现的一些政治谣言和错误言论，不揭露、不批评、不斗争，甚至随声附和。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (5, 22,1,'想问题、作决策、办事情不能从整体和全局利益出发，随意性大，“东一榔头西一棒槌”，想到哪干到哪。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (5, 23,1,'遇到问题绕着走，对一些“刺头”和恶势力不敢动真碰硬，习惯于睁一只眼闭一只眼。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (5, 24,1,'举办大型户外活动或群众性聚会活动，只要维持好现场秩序就行了，没必要提预案、搞演练。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (5, 25,1,'基层主要任务就是抓落实，至于防范化解风险，那是上级考虑的事。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (6, 26,1,'认为只要不花公家钱，花自己钱吃吃喝喝不算啥事。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (6, 27,1,'红白喜事是个人的家事，怎么操办，家里人坐商量一下就行了，没必要向组织报备。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (6, 28,1,'平时工作任务重、压力大，节假日和朋友一起聚聚，喝个酒、打个牌，放松放松，不算个啥。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (6, 29,1,'都到啥年代了，穿名牌、用名牌再也正常不过了，没什么大不了的。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (6, 30,1,'一事当前，先自己打算。组织安排的事情，于己有利抢着干；组织任命的职务，老觉着亏了自己，动不动就闹情绪；组织作的决定，执行时做“选择题”，讨价还价。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (7, 31,1,'基层工作千头万绪，抓不抓学习都一样，学不学理论政策影响不大。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (7, 32,1,'对上级部署的工作任务开会一传达、文件一转发就等于落实了。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (7, 33,1,'对职责范围内的事胸中无数，上级检查时“支支吾吾”，群众咨询时“含糊其辞”，稀里糊涂抓落实。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (7, 34,1,'热衷于利用媒体造势揽功，甚至到处拉功绩，推诿过失。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (7, 35,1,'把完成任务定为工作目标，时常将“基本上完成、差不多干好”挂在嘴边。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (8, 36,2,'组织派我负责单位工作，单位大小事就应由我说了算，不然还算什么“一把手”。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (8, 37,2,'拉帮结派、争权夺利，搞团团伙伙，制造矛盾、破坏团结。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (8, 38,2,'亲属利用职务影响，“提篮子”“当掮客”“空手套白狼”，在本人工作地或分管领域违规经商办企业。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (8, 39,2,'私底下与私营企业主称兄道弟，认为在一起吃饭聚会很正常。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (8, 40,2,'工作推进中，上级看得见的工作做得多，上级看不见的工作做得少，甚至干脆不做。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (8, 41,3,'认为管党治党是“一把手”、党组织书记的事，自己只要干好本职工作、业务上争创一流就行了。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (8, 42,3,'以“一把手”的意图为意图，既不动脑子，也不担责任，“三会一课”等党内生活不严格、走形式、做样子。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (8, 43,3,'工作时间串岗溜岗、处理私事、闲聊打游戏；办公室门开着不见人，唱“空城计”，间歇性“失联”。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (8, 44,3,'对群众反映的内容不重视、不上心，能推则推，能避则避，生怕惹祸上身。',1,1);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (8, 45,3,'产生船到码头车到站思想，工作上当一天和尚撞一天钟，满足于不出事，习惯于当“守摊子”的太平官。',1,1);
INSERT INTO `PaperOption` (`option_id`, `description`,`test_id`, `point`) values (1, '没有', 1, 2);
INSERT INTO `PaperOption` (`option_id`, `description`,`test_id`, `point`) values (2, '有', 1, 0);
INSERT INTO `PaperTest`(`name`) values('领导干部政治体检点评指标');
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (1, 1,1,'发挥政治指南针作用，引导全党坚定理想信念、坚定“四个意识”，把全党智慧和力量凝聚到中国特色社会主义伟大事业上；经常对标对表，及时校准偏差，坚决纠正偏离和违背党的政治方向的行为；把党组织建设成坚强战斗堡垒，对有问题党员、干部进行严肃批评教育，问题严重的要依照党纪进行处理。',1,2);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (2, 2,1,'健全党的组织体系、制度体系、工作机制，切实把党的领导落实到改革发展稳定、内政外交国防、治党治国治军等各领域各方面各环节；坚持党中央权威和集中统一领导；是否引导全党增强“四个意识”，自觉在思想上政治上行动上同党中央保持高度一致，确保党中央一锤定音、定于一尊的权威；在履职尽责过程中自觉在大局下行动，为全党做好表率。',1,2);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (3, 3,1,'把赢得民心民意、汇集民智民力作为重要着力点；是否坚定人民立场，贯彻党的群众路线，坚决反对“四风”特别是形式主义、官僚主义；教育和激励广大党员、干部着力解决群众最关心最直接最现实的利益问题上；为敢抓敢管、真抓实干、勇于担当的干部加油鼓劲、撑腰壮胆，对尸位素餐、光说不练、热衷于评头论足甚至诬告陷害的人严肃批评问责。',1,2);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (4, 4,1,'将营造良好政治生态作为党的政治建设的基础性、经常性工作；树立正确选人用人导向，突出政治标准；贯彻落实新形势下党内政治生活的若干准则，让党员、干部在党内政治生活中经常接受政治体检，打扫政治灰尘，净化政治灵魂，增强政治免疫力；加强党内政治文化建设，让党所倡导的理想信念、价值理念、优良传统深入党员、干部思想和心灵；弘扬社会主义核心价值观，弘扬和践行忠诚老实、公道正派、实事求是、清正廉洁等价值观，以良好政治文化涵养风清气正的政治生态。',1,2);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (5, 5,1,'教育引导干部增强政治敏锐性和政治鉴别力，对容易诱发政治问题特别是重大突发事件的敏感因素、苗头性倾向性问题，做到眼睛亮、见事早、行动快，及时消除各种政治隐患；高度重视并及时阻断不同领域风险的转化通道，避免各领域风险产生交叉感染，防止非公共性风险扩大为公共性风险、非政治性风险蔓延为政治风险；增强斗争精神，敢于亮剑、敢于斗争，坚决防止和克服嗅不出敌情、分不清是非、辨不明方向的政治麻痹症。',1,2);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (6, 6,1,'持续保持高压态势，坚持无禁区、全覆盖、零容忍，坚持重遏制、强高压、长震慑，坚持受贿行贿一起查；坚决防止党内形成利益集团；坚决防范各种利益集团“围猎”和绑架领导干部；做到织密监督的“天网”，扎紧制度的篱笆，发挥巡视利剑作用，推动全面从严治党向基层延伸，让人民群众真正感受到清正干部、清廉政府、清明政治就在身边、就在眼前。',1,2);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (7, 7,1,'做到不断提升把握方向、把握大势、把握全局的能力，辨别政治是非、保持政治定力、驾驭政治局面、防范政治风险的能力；是否做到善于从政治上分析问题、解决问题；做到炼就一双政治慧眼，不畏浮云遮望眼，切实担负起党和人民赋予的政治责任。',1,2);
INSERT INTO `PaperQuestion` (`category_id`, `question_id`, `user_property_id`, `description`, `type`, `test_id`) VALUES (8, 8,1,'其他问题',2,2);
INSERT INTO `PaperOption` (`option_id`, `description`,`test_id`, `point`) values (1, '优秀', 2, 10);
INSERT INTO `PaperOption` (`option_id`, `description`,`test_id`, `point`) values (2, '良好', 2, 8);
INSERT INTO `PaperOption` (`option_id`, `description`,`test_id`, `point`) values (3, '一般', 2, 5);
INSERT INTO `PaperOption` (`option_id`, `description`,`test_id`, `point`) values (4, '较差', 2, 2);












