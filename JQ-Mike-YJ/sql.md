
# 用户信息表
CREATE TABLE `user_info` (
`id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
`code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '用户唯一编号',
`name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '姓名',
`login_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '登录名',
`password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '登录密码',
`phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '手机号',
`gender` int NOT NULL DEFAULT '0' COMMENT '性别（0-未知 1-男 2-女）',
`avatar_url` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '用户头像',
`permission_identity` int NOT NULL DEFAULT '0' COMMENT '权限身份（0-普通 1-管理员）',
`login_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登录时间',
`login_status` int NOT NULL DEFAULT '0' COMMENT '登录状态（0-未登录 1-已登录）',
`status` tinyint NOT NULL DEFAULT '1' COMMENT '状态（0-失效 1-有效）',
`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (`id`),
KEY `idx_code` (`code`) USING BTREE COMMENT '用户编号索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户信息表';

# 问题表
CREATE TABLE `question_info` (
`id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
`question_desc` varchar(1024) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '问题描述',
`creator_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建人编号',
`creator_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建人姓名',
`status` tinyint NOT NULL DEFAULT '1' COMMENT '状态（0-失效 1-有效）',
`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='问题表';

# 答案表
CREATE TABLE `answer_info` (
`id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
`question_id` bigint NOT NULL COMMENT '问题ID',
`answer` text COLLATE utf8mb4_general_ci NOT NULL COMMENT '问题解答',
`is_perfect_answer` tinyint NOT NULL DEFAULT '0' COMMENT '完美答案（0-否 1-是）',
`weight` decimal(5,2) NOT NULL DEFAULT '0.00' COMMENT '权重',
`creator_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '创建人编号',
`creator_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '创建人姓名',
`status` tinyint NOT NULL DEFAULT '1' COMMENT '状态（0-失效 1-有效）',
`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='答案表';

