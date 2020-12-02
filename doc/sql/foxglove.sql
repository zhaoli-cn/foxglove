-- ----------------------------
-- Table structure for base_dept
-- ----------------------------
DROP TABLE IF EXISTS `base_dept`;
CREATE TABLE `base_dept`  (
  `id` bigint(64) NOT NULL COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '部门名称',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  `create_user` bigint(64) DEFAULT NULL COMMENT '创建人',
  `create_dept` bigint(64) DEFAULT NULL COMMENT '创建部门',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_user` bigint(64) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `status` int(2) DEFAULT NULL COMMENT '业务状态',
  `is_deleted` int(2) DEFAULT 0 COMMENT '是否已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for base_role
-- ----------------------------
DROP TABLE IF EXISTS `base_role`;
CREATE TABLE `base_role`  (
  `id` bigint(64) NOT NULL COMMENT '主键id',
  `code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色编码',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `create_user` bigint(64) DEFAULT NULL COMMENT '创建人',
  `create_dept` bigint(64) DEFAULT NULL COMMENT '创建部门',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_user` bigint(64) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `status` int(2) DEFAULT NULL COMMENT '业务状态',
  `is_deleted` int(2) DEFAULT 0 COMMENT '是否已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of base_role
-- ----------------------------
INSERT INTO `base_role` VALUES (1, 'ROLE_ADMIN', '超级管理员', NULL, NULL, NULL, '2020-03-13 14:47:40', NULL, '2020-03-13 14:47:40', NULL, 0);
INSERT INTO `base_role` VALUES (2, 'ROLE_QUERY', '查询员', NULL, NULL, NULL, '2020-03-13 17:30:27', NULL, '2020-03-13 17:30:27', NULL, 0);

-- ----------------------------
-- Table structure for base_user
-- ----------------------------
DROP TABLE IF EXISTS `base_user`;
CREATE TABLE `base_user`  (
  `id` bigint(64) NOT NULL COMMENT '主键id',
  `openid` varchar(28) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '小程序用户的openid',
  `account` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户账号',
  `nick_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户昵称',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户姓名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '加密后的密码',
  `avatarurl` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户头像',
  `gender` tinyint(2) DEFAULT NULL COMMENT '性别  0-未知、1-男、2-女',
  `country` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所在国家',
  `province` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '省份',
  `city` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '城市',
  `mobile` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机号码',
  `identity` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '身份证',
  `union_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '微信用户唯一编码',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `create_user` bigint(64) DEFAULT NULL COMMENT '创建人',
  `create_dept` bigint(64) DEFAULT NULL COMMENT '创建部门',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_user` bigint(64) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `status` int(2) DEFAULT NULL COMMENT '业务状态',
  `is_deleted` int(2) DEFAULT 0 COMMENT '是否已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `USER_OPENID_INDEX`(`openid`) USING BTREE COMMENT '小程序用户的openid索引',
  INDEX `USER_NAME_INDEX`(`name`) USING BTREE COMMENT '姓名索引',
  INDEX `USER_MOBILE_INDEX`(`mobile`) USING BTREE COMMENT '手机号索引',
  INDEX `USER_IDENTITY_INDEX`(`mobile`) USING BTREE COMMENT '身份证索引'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of base_user
-- ----------------------------
INSERT INTO `base_user` VALUES (1, '1', 'admin', '小超', '测试', '123456', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-03-13 14:47:18', NULL, '2020-03-13 17:19:59', NULL, 0);

-- ----------------------------
-- Table structure for base_user_dept
-- ----------------------------
DROP TABLE IF EXISTS `base_user_dept`;
CREATE TABLE `base_user_dept`  (
  `id` bigint(64) NOT NULL COMMENT '主键id',
  `userid` bigint(64) NOT NULL COMMENT '用户ID',
  `deptid` bigint(64) NOT NULL COMMENT '部门ID',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `create_user` bigint(64) DEFAULT NULL COMMENT '创建人',
  `create_dept` bigint(64) DEFAULT NULL COMMENT '创建部门',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_user` bigint(64) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `status` int(2) DEFAULT NULL COMMENT '业务状态',
  `is_deleted` int(2) DEFAULT 0 COMMENT '是否已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `USERDEPT_USERID_INDEX`(`userid`) USING BTREE COMMENT '用户部门表用户ID索引'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for base_user_role
-- ----------------------------
DROP TABLE IF EXISTS `base_user_role`;
CREATE TABLE `base_user_role`  (
  `id` bigint(64) NOT NULL COMMENT '主键id',
  `userid` bigint(64) NOT NULL COMMENT '用户ID',
  `roleid` bigint(64) NOT NULL COMMENT '角色ID',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `create_user` bigint(64) DEFAULT NULL COMMENT '创建人',
  `create_dept` bigint(64) DEFAULT NULL COMMENT '创建部门',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_user` bigint(64) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `status` int(2) DEFAULT NULL COMMENT '业务状态',
  `is_deleted` int(2) DEFAULT 0 COMMENT '是否已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `USERRLOLE_USERID_INDEX`(`userid`) USING BTREE COMMENT '用户角色表用户ID索引'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of base_user_role
-- ----------------------------
INSERT INTO `base_user_role` VALUES (1, 1, 1, NULL, NULL, NULL, '2020-03-13 14:47:52', NULL, '2020-03-13 14:47:52', NULL, 0);
INSERT INTO `base_user_role` VALUES (2, 1, 2, NULL, NULL, NULL, '2020-03-13 17:30:39', NULL, '2020-03-13 17:30:39', NULL, 0);

-- ----------------------------
-- Table structure for biz_comment
-- ----------------------------
DROP TABLE IF EXISTS `biz_comment`;
CREATE TABLE `biz_comment`  (
  `id` bigint(64) NOT NULL COMMENT 'ID',
  `topic_id` bigint(64) DEFAULT NULL COMMENT '主题id',
  `content_type` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '评论类型(0:消费者评论,1:发布者评论)',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '评论内容',
  `from_uid` bigint(64) DEFAULT NULL COMMENT '评论用户id',
  `to_uid` bigint(64) DEFAULT NULL COMMENT '评论目标用户id',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  `create_user` bigint(64) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_user` bigint(64) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `status` int(2) DEFAULT NULL COMMENT '业务状态',
  `is_deleted` int(2) DEFAULT 0 COMMENT '是否已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for biz_goods
-- ----------------------------
DROP TABLE IF EXISTS `biz_goods`;
CREATE TABLE `biz_goods`  (
  `id` bigint(64) NOT NULL COMMENT 'ID',
  `name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '商品名称',
  `goods_type` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '所属类别编码',
  `goods_type_name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '所属类别名称',
  `company_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '公司编码',
  `company_name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '公司名称',
  `download_url` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '下载地址',
  `pic_url` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图片地址',
  `more_person` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '1' COMMENT '支持多人共享(0:不支持,1:支持)',
  `max_number` int(4) DEFAULT NULL COMMENT '允许最多共享人数',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  `create_user` bigint(64) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_user` bigint(64) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `status` int(2) DEFAULT NULL COMMENT '业务状态',
  `is_deleted` int(2) DEFAULT 0 COMMENT '是否已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for biz_information
-- ----------------------------
DROP TABLE IF EXISTS `biz_information`;
CREATE TABLE `biz_information`  (
  `id` bigint(64) NOT NULL COMMENT 'ID',
  `topic` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '主题',
  `goods_id` bigint(64) DEFAULT NULL COMMENT '商品ID',
  `person_number` int(4) DEFAULT NULL COMMENT '参团人数',
  `price` double DEFAULT NULL COMMENT '总价',
  `use_day` int(6) DEFAULT -1 COMMENT '可使用天数',
  `use_type` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '1' COMMENT '使用类型(1:共同购买,2:出租,3:免费)',
  `expiry_time` datetime(0) DEFAULT NULL COMMENT '截止时间',
  `info` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '详细描述',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  `create_user` bigint(64) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_user` bigint(64) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `status` int(2) DEFAULT NULL COMMENT '业务状态',
  `is_deleted` int(2) DEFAULT 0 COMMENT '是否已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '信息发布表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cnf_dict
-- ----------------------------
DROP TABLE IF EXISTS `cnf_dict`;
CREATE TABLE `cnf_dict`  (
  `id` bigint(64) NOT NULL COMMENT 'ID',
  `code` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '编码',
  `name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '名称',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  `create_user` bigint(64) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_user` bigint(64) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `status` int(2) DEFAULT NULL COMMENT '业务状态',
  `is_deleted` int(2) DEFAULT 0 COMMENT '是否已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '字典表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cnf_dict_detail
-- ----------------------------
DROP TABLE IF EXISTS `cnf_dict_detail`;
CREATE TABLE `cnf_dict_detail`  (
  `id` bigint(64) NOT NULL COMMENT 'ID',
  `dict_id` bigint(64) NOT NULL COMMENT '字典ID',
  `parent_id` bigint(64) DEFAULT NULL COMMENT '父节点ID',
  `code` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '编码',
  `name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '名称',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  `create_user` bigint(64) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_user` bigint(64) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `status` int(2) DEFAULT NULL COMMENT '业务状态',
  `is_deleted` int(2) DEFAULT 0 COMMENT '是否已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '字典详情表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for demo
-- ----------------------------
DROP TABLE IF EXISTS `demo`;
CREATE TABLE `demo`  (
  `id` bigint(64) NOT NULL COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '名称',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  `create_user` bigint(64) DEFAULT NULL COMMENT '创建人',
  `create_dept` bigint(64) DEFAULT NULL COMMENT '创建部门',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_user` bigint(64) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `status` int(2) DEFAULT NULL COMMENT '业务状态',
  `is_deleted` int(2) DEFAULT 0 COMMENT '是否已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'Demo表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of demo
-- ----------------------------
INSERT INTO `demo` VALUES (1237760713412628481, '测试', NULL, 1, 1, '2020-03-11 23:22:05', 1, '2020-03-11 23:39:19', 1, 1);
INSERT INTO `demo` VALUES (1237763147757277185, '测试', NULL, 1, 1, '2020-03-11 23:31:46', 1, '2020-03-11 23:47:21', 1, 1);
INSERT INTO `demo` VALUES (1237767134669778946, '测试', NULL, 1, 1, '2020-03-11 23:47:36', 1, '2020-03-11 23:47:36', 1, 0);
INSERT INTO `demo` VALUES (1238437136838189057, '测试token赋值用户', NULL, -1, 1, '2020-03-13 20:13:03', -1, '2020-03-13 20:13:03', 1, 0);
INSERT INTO `demo` VALUES (1238438179718324226, '测试token赋值用户', NULL, 1, 1, '2020-03-13 20:14:58', 1, '2020-03-13 20:14:58', 1, 0);

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details`  (
  `client_id` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `resource_ids` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `client_secret` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `scope` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `authorized_grant_types` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `authorities` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `autoapprove` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`client_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO `oauth_client_details` VALUES ('order-client', NULL, '$2a$10$GoIOhjqFKVyrabUNcie8d.ADX.qZSxpYbO6YK4L2gsNzlCIxEUDlW', 'all', 'authorization_code,refresh_token,password', NULL, NULL, 3600, 36000, NULL, '1');
INSERT INTO `oauth_client_details` VALUES ('user-client', NULL, '$2a$10$o2l5kA7z.Caekp72h5kU7uqdTDrlamLq.57M1F6ulJln9tRtOJufq', 'all', 'authorization_code,refresh_token,password', NULL, NULL, 3600, 36000, NULL, '1');

-- ----------------------------
-- Table structure for testt
-- ----------------------------
DROP TABLE IF EXISTS `testt`;
CREATE TABLE `testt`  (
  `id` bigint(64) NOT NULL COMMENT '主键',
  `name` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '姓名',
  `kecheng` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '课程',
  `fenshu` int(8) DEFAULT NULL COMMENT '分数'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '测试表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of testt
-- ----------------------------
INSERT INTO `testt` VALUES (1, '张三', '语文', 81);
INSERT INTO `testt` VALUES (2, '张三', '数学', 75);
INSERT INTO `testt` VALUES (3, '张三', '英语', 82);
INSERT INTO `testt` VALUES (4, '李四', '语文', 76);
INSERT INTO `testt` VALUES (5, '李四', '数学', 90);
INSERT INTO `testt` VALUES (6, '李四', '英语', 65);
INSERT INTO `testt` VALUES (7, '王五', '语文', 81);
INSERT INTO `testt` VALUES (8, '王五', '数学', 100);
INSERT INTO `testt` VALUES (9, '王五', '英语', 90);