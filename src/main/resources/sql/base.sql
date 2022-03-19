SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for base_file_upload_record
-- ----------------------------
DROP TABLE IF EXISTS `base_file_upload_record`;
CREATE TABLE `base_file_upload_record` (
`id` bigint(20) NOT NULL COMMENT '主键',
`user_id` bigint(20) NOT NULL COMMENT '上传用户ID',
`origin_file_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '原文件名',
`file_type` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '文件类型',
`fresh_file_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '新文件名',
`fresh_file_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '新文件路径',
`status` char(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '上传状态(EnumFileUploadStatus)',
`url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'url路径',
`file_size` int(10) DEFAULT NULL COMMENT '文件大小',
`create_time` datetime NOT NULL COMMENT '创建时间',
`update_time` datetime NOT NULL COMMENT '修改时间',
                                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件上传记录';

SET FOREIGN_KEY_CHECKS = 1;
