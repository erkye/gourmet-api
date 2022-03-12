/*
 Navicat Premium Data Transfer

 Source Server         : local-mysql
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : gourmet

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 12/03/2022 15:12:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for base_account
-- ----------------------------
DROP TABLE IF EXISTS `base_account`;
CREATE TABLE `base_account` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '账号ID',
`user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
`open_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '登录账号,如手机号等',
`category` char(3) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '账号类别',
`create_time` datetime DEFAULT NULL COMMENT '创建时间',
`creator` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
`update_time` datetime DEFAULT NULL COMMENT '修改时间',
`editor` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
`deleted` tinyint(1) unsigned zerofill DEFAULT '0' COMMENT '逻辑删除:0=未删除,1=已删除',
PRIMARY KEY (`id`) USING BTREE,
KEY `idx_member_id` (`user_id`) USING BTREE COMMENT '普通索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='账号';

-- ----------------------------
-- Table structure for base_permission
-- ----------------------------
DROP TABLE IF EXISTS `base_permission`;
CREATE TABLE `base_permission` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
`parent_id` bigint(20) DEFAULT NULL COMMENT '所属父级权限ID',
`code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限唯一CODE代码',
`name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限名称',
`intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限介绍',
`category` char(3) DEFAULT NULL COMMENT '权限类别',
`uri` varchar(32) DEFAULT NULL COMMENT 'URL规则',
`create_time` datetime DEFAULT NULL COMMENT '创建时间',
`creator` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
`update_time` datetime DEFAULT NULL COMMENT '修改时间',
`editor` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
`deleted` tinyint(1) unsigned zerofill DEFAULT '0' COMMENT '逻辑删除:0=未删除,1=已删除',
PRIMARY KEY (`id`) USING BTREE,
KEY `parent_id` (`parent_id`) USING BTREE COMMENT '父级权限ID',
KEY `code` (`code`) USING BTREE COMMENT '权限CODE代码'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='权限';

-- ----------------------------
-- Table structure for base_role
-- ----------------------------
DROP TABLE IF EXISTS `base_role`;
CREATE TABLE `base_role` (
 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
 `parent_id` bigint(20) DEFAULT NULL COMMENT '所属父级角色ID',
 `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色唯一CODE代码',
 `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色名称',
 `intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色介绍',
 `create_time` datetime DEFAULT NULL COMMENT '创建时间',
 `creator` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
 `update_time` datetime DEFAULT NULL COMMENT '修改时间',
 `editor` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
 `deleted` tinyint(1) unsigned zerofill DEFAULT '0' COMMENT '逻辑删除:0=未删除,1=已删除',
 PRIMARY KEY (`id`) USING BTREE,
 KEY `parent_id` (`parent_id`) USING BTREE COMMENT '父级权限ID',
 KEY `code` (`code`) USING BTREE COMMENT '权限CODE代码'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='角色';

-- ----------------------------
-- Table structure for base_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `base_role_permission`;
CREATE TABLE `base_role_permission` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
`role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
`permission_id` bigint(20) DEFAULT NULL COMMENT '权限ID',
`create_time` datetime DEFAULT NULL COMMENT '创建时间',
`creator` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
`update_time` datetime DEFAULT NULL COMMENT '修改时间',
`editor` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
`deleted` tinyint(1) unsigned zerofill DEFAULT '0' COMMENT '逻辑删除:0=未删除,1=已删除',
PRIMARY KEY (`id`) USING BTREE,
KEY `role_id` (`role_id`) USING BTREE COMMENT '角色ID',
KEY `permission_id` (`permission_id`) USING BTREE COMMENT '权限ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='角色权限';

-- ----------------------------
-- Table structure for base_user
-- ----------------------------
DROP TABLE IF EXISTS `base_user`;
CREATE TABLE `base_user` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
`state` tinyint(1) DEFAULT NULL COMMENT '用户状态:0=正常,1=禁用',
`name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '姓名',
`head_img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像图片地址',
`mobile` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机号码',
`salt` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码加盐',
`password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '登录密码',
`create_time` datetime DEFAULT NULL COMMENT '创建时间',
`creator` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
`update_time` datetime DEFAULT NULL COMMENT '修改时间',
`editor` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
`deleted` tinyint(1) unsigned zerofill DEFAULT '0' COMMENT '逻辑删除:0=未删除,1=已删除',
PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户';

-- ----------------------------
-- Table structure for base_user_role
-- ----------------------------
DROP TABLE IF EXISTS `base_user_role`;
CREATE TABLE `base_user_role` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
`user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
`role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
`create_time` datetime DEFAULT NULL COMMENT '创建时间',
`creator` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
`update_time` datetime DEFAULT NULL COMMENT '修改时间',
`editor` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
`deleted` tinyint(1) unsigned zerofill DEFAULT '0' COMMENT '逻辑删除:0=未删除,1=已删除',
PRIMARY KEY (`id`) USING BTREE,
KEY `member_id` (`user_id`) USING BTREE COMMENT '用户ID',
KEY `role_id` (`role_id`) USING BTREE COMMENT '角色ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户角色';

SET FOREIGN_KEY_CHECKS = 1;
