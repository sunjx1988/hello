use procedure_test;
SET sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));

drop table if exists `user`;

create table `user` (
  `id` int(10) not null auto_increment,
  `name` varchar(64) not null default '',
  `dept` varchar(254) not null default '',
  `website` varchar(254) default '',
  `phone` varchar(16) not null default '',
  primary key (`id`)
) engine=innodb auto_increment=1;

-- ----------------------------
-- records of user
-- ----------------------------
insert into `user` values ('1', 'yiibai', 'tech', 'http://www.yiibai.com', '13800009988');

SELECT * from user;