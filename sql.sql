CREATE TABLE `article` (
 `id` varchar(32) NOT NULL COMMENT '博文ID',
 `user_id` varchar(32) NOT NULL COMMENT '发表用户ID',
 `title` text NOT NULL COMMENT '博文标题',
 `content` longtext NOT NULL COMMENT '博文内容',
 `views` bigint(20) default 0 COMMENT '浏览量',
 `comment_count` bigint(20) default 0 COMMENT '评论总数',
 `publish_date` datetime DEFAULT NULL COMMENT '发表时间',
 `like_count` bigint(20) default 0 COMMENT "点赞数",
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment="博文表" ;

CREATE TABLE `blog_user`(
 `id` varchar(32) NOT NULL  COMMENT '用户ID',
 `ip` varchar(20) NULL COMMENT '用户IP',
 `name` varchar(20) NOT NULL COMMENT '用户名',
 `password` varchar(15) NOT NULL COMMENT '用户密码',
 `email` varchar(30) NOT NULL COMMENT '用户邮箱',
 `photo` varchar(255) NULL COMMENT '用户头像',
 `regist_time` datetime DEFAULT NULL COMMENT '注册时间',
 `age` tinyint(4) DEFAULT NULL COMMENT '用户年龄',
 `phone` int(11) NOT NULL COMMENT '用户手机号',
 `nickname` varchar(20) NOT NULL COMMENT '用户昵称',
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment="用户信息表";
