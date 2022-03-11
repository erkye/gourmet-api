# 账号表
CREATE TABLE `base_account`  (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '账号ID',
`user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
`open_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录账号,如手机号等',
`category` tinyint(1) NULL DEFAULT NULL COMMENT '账号类别',
`created` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
`creator` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
`edited` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
`editor` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
`deleted` double(1, 0) UNSIGNED ZEROFILL NULL DEFAULT 0 COMMENT '逻辑删除:0=未删除,1=已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_member_id`(`user_id`) USING BTREE COMMENT '普通索引'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '账号' ROW_FORMAT = Dynamic;

# 用户表
CREATE TABLE `base_user`  (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
`state` tinyint(1) NULL DEFAULT NULL COMMENT '用户状态:0=正常,1=禁用',
`name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
`head_img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像图片地址',
`mobile` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
`salt` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码加盐',
`password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录密码',
`created` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
`creator` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
`edited` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
`editor` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
`deleted` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT 0 COMMENT '逻辑删除:0=未删除,1=已删除',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

# 权限表
CREATE TABLE `base_permission`  (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
`parent_id` bigint(20) NULL DEFAULT NULL COMMENT '所属父级权限ID',
`code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限唯一CODE代码',
`name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名称',
`intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限介绍',
`category` tinyint(1) NULL DEFAULT NULL COMMENT '权限类别',
`uri` bigint(20) NULL DEFAULT NULL COMMENT 'URL规则',
`created` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
`creator` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
`edited` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
`editor` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
`deleted` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT 0 COMMENT '逻辑删除:0=未删除,1=已删除',
PRIMARY KEY (`id`) USING BTREE,
INDEX `parent_id`(`parent_id`) USING BTREE COMMENT '父级权限ID',
INDEX `code`(`code`) USING BTREE COMMENT '权限CODE代码'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限' ROW_FORMAT = Dynamic;

# 角色表
CREATE TABLE `base_role`  (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
`parent_id` bigint(20) NULL DEFAULT NULL COMMENT '所属父级角色ID',
`code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色唯一CODE代码',
`name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
`intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色介绍',
`created` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
`creator` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
`edited` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
`editor` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
`deleted` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT 0 COMMENT '逻辑删除:0=未删除,1=已删除',
PRIMARY KEY (`id`) USING BTREE,
INDEX `parent_id`(`parent_id`) USING BTREE COMMENT '父级权限ID',
INDEX `code`(`code`) USING BTREE COMMENT '权限CODE代码'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色' ROW_FORMAT = Dynamic;

# 用户-角色表
CREATE TABLE `base_user_role`  (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
`user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
`role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
`created` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
`creator` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
`edited` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
`editor` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
`deleted` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT 0 COMMENT '逻辑删除:0=未删除,1=已删除',
PRIMARY KEY (`id`) USING BTREE,
INDEX `member_id`(`user_id`) USING BTREE COMMENT '用户ID',
INDEX `role_id`(`role_id`) USING BTREE COMMENT '角色ID'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色' ROW_FORMAT = Dynamic;

# 角色-权限表
CREATE TABLE `base_role_permission`  (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
`role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
`permission_id` bigint(20) NULL DEFAULT NULL COMMENT '权限ID',
`created` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
`creator` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
`edited` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
`editor` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
`deleted` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT 0 COMMENT '逻辑删除:0=未删除,1=已删除',
PRIMARY KEY (`id`) USING BTREE,
INDEX `role_id`(`role_id`) USING BTREE COMMENT '角色ID',
INDEX `permission_id`(`permission_id`) USING BTREE COMMENT '权限ID'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色权限' ROW_FORMAT = Dynamic;