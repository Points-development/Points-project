INSERT INTO `Organization`(`name`, `description`) values('testOrgan', 'test dang jian organ');
INSERT INTO `Branch`(`name`, `organization_id`, `description`) values('testBranch', 1, 'test dang jian branch');
INSERT INTO `User`(`user_property_id`, `name`, `realName`, `branch_id`) values(3, 'gangpu', 'pugang', 1);
INSERT INTO `User`(`user_property_id`, `name`, `realName`, `branch_id`) values(4, 'xzgan', 'ganxiangzhen', 1);
INSERT INTO `User`(`user_property_id`, `name`, `realName`, `branch_id`) values(2, 'test', 'test', 1);
INSERT INTO `User`(`user_property_id`, `name`, `realName`, `branch_id`) values(2, 'test1', 'test1', 1);
INSERT INTO `UserRole`(`user_id`, `role_id`) values(1,  1);
INSERT INTO `UserRole`(`user_id`, `role_id`) values(2,  2);