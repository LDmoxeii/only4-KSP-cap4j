/*
 Navicat Premium Data Transfer

 Source Server         : only4-ksp-capj4
 Source Server Type    : MySQL
 Source Server Version : 50742
 Source Host           : localhost:3306
 Source Schema         : only4-ksp-cap4j

 Target Server Type    : MySQL
 Target Server Version : 50742
 File Encoding         : 65001

 Date: 15/11/2024 14:24:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for __achrived_event
-- ----------------------------
DROP TABLE IF EXISTS `__achrived_event`;
CREATE TABLE `__achrived_event`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `event_uuid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '事件uuid',
  `svc_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '服务',
  `event_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '事件类型',
  `data` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '事件数据',
  `data_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '事件数据类型',
  `exception` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '事件发送异常',
  `expire_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '过期时间',
  `create_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `event_state` int(11) NOT NULL DEFAULT 0 COMMENT '分发状态',
  `last_try_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '上次尝试时间',
  `next_try_time` datetime(0) NOT NULL DEFAULT '0001-01-01 00:00:00' COMMENT '下次尝试时间',
  `tried_times` int(11) NOT NULL DEFAULT 0 COMMENT '已尝试次数',
  `try_times` int(11) NOT NULL DEFAULT 0 COMMENT '尝试次数',
  `version` int(11) NOT NULL DEFAULT 0,
  `db_created_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `db_updated_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_db_created_at`(`db_created_at`) USING BTREE,
  INDEX `idx_db_updated_at`(`db_updated_at`) USING BTREE,
  INDEX `idx_event_uuid`(`event_uuid`) USING BTREE,
  INDEX `idx_event_type`(`event_type`, `svc_name`) USING BTREE,
  INDEX `idx_create_at`(`create_at`) USING BTREE,
  INDEX `idx_expire_at`(`expire_at`) USING BTREE,
  INDEX `idx_next_try_time`(`next_try_time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '事件发件箱存档 support by cap4j\n@I;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of __achrived_event
-- ----------------------------

-- ----------------------------
-- Table structure for __event
-- ----------------------------
DROP TABLE IF EXISTS `__event`;
CREATE TABLE `__event`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `event_uuid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '事件uuid',
  `svc_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '服务',
  `event_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '事件类型',
  `data` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '事件数据',
  `data_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '事件数据类型',
  `exception` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '事件发送异常',
  `expire_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '过期时间',
  `create_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `event_state` int(11) NOT NULL DEFAULT 0 COMMENT '分发状态',
  `last_try_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '上次尝试时间',
  `next_try_time` datetime(0) NOT NULL DEFAULT '0001-01-01 00:00:00' COMMENT '下次尝试时间',
  `tried_times` int(11) NOT NULL DEFAULT 0 COMMENT '已尝试次数',
  `try_times` int(11) NOT NULL DEFAULT 0 COMMENT '尝试次数',
  `version` int(11) NOT NULL DEFAULT 0,
  `db_created_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `db_updated_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_db_created_at`(`db_created_at`) USING BTREE,
  INDEX `idx_db_updated_at`(`db_updated_at`) USING BTREE,
  INDEX `idx_event_uuid`(`event_uuid`) USING BTREE,
  INDEX `idx_event_type`(`event_type`, `svc_name`) USING BTREE,
  INDEX `idx_create_at`(`create_at`) USING BTREE,
  INDEX `idx_expire_at`(`expire_at`) USING BTREE,
  INDEX `idx_next_try_time`(`next_try_time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '事件发件箱 support by cap4j\n@I;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of __event
-- ----------------------------

-- ----------------------------
-- Table structure for __locker
-- ----------------------------
DROP TABLE IF EXISTS `__locker`;
CREATE TABLE `__locker`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '锁名称',
  `pwd` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '锁密码',
  `lock_at` datetime(0) NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '锁获取时间',
  `unlock_at` datetime(0) NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '锁释放时间',
  `version` bigint(20) UNSIGNED NOT NULL DEFAULT 0,
  `db_created_at` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `db_updated_at` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uniq_name`(`name`) USING BTREE,
  INDEX `idx_db_created_at`(`db_created_at`) USING BTREE,
  INDEX `idx_db_updated_at`(`db_updated_at`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '锁 support by cap4j\n@I;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of __locker
-- ----------------------------

-- ----------------------------
-- Table structure for admin_user
-- ----------------------------
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user`  (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `refresh_token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '刷新令牌',
  `login_expiry_date` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '过期时间',
  `created_at` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表\r\n @Spe;\r\n @Fac;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_user
-- ----------------------------
INSERT INTO `admin_user` VALUES (104540666628931584, 'moxeiii', '15976781430', '11111111', NULL, NULL, '2024-11-15 11:27:17', 0);

-- ----------------------------
-- Table structure for admin_user_permission
-- ----------------------------
DROP TABLE IF EXISTS `admin_user_permission`;
CREATE TABLE `admin_user_permission`  (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `admin_user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `permission_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限编码',
  `permission_remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户权限表\r\n @P=admin_user;\r\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_user_permission
-- ----------------------------
INSERT INTO `admin_user_permission` VALUES (104540666834452480, 104540666628931584, 'ADMIN_USER_EDIT', '更新管理员用户信息');

-- ----------------------------
-- Table structure for admin_user_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_user_role`;
CREATE TABLE `admin_user_role`  (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `admin_user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户角色表\r\n @P=admin_user;\r\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_user_role
-- ----------------------------
INSERT INTO `admin_user_role` VALUES (104540666842841088, 104540666628931584, 104539741835231232, 'admin');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `created_at` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表\r\n @Spe;\r\n @Fac;\r\n @DE=RoleInfoChanged|RolePermissionChanged;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (104539741835231232, 'normal', '管理员', '2024-11-15 11:23:37');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  `permission_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限编码',
  `permission_remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色权限表\r\n @P=role;\r\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES (104539741860397056, 104539741835231232, 'ADMIN_USER_EDIT', '更新管理员用户信息');
INSERT INTO `role_permission` VALUES (104564750569963520, 104539741835231232, 'ADMIN_USER_VIEW', '查询管理员用户');
INSERT INTO `role_permission` VALUES (104564750632878080, 104539741835231232, 'ADMIN_USER_UPDATE_ROLES', '更新管理员用户角色');
INSERT INTO `role_permission` VALUES (104564750632878081, 104539741835231232, 'ADMIN_USER_UPDATE_PASSWORD', '更新管理员用户密码');
INSERT INTO `role_permission` VALUES (104564750632878082, 104539741835231232, 'ADMIN_USER_DELETE', '删除管理员用户');
INSERT INTO `role_permission` VALUES (104564750632878083, 104539741835231232, 'ADMIN_USER_CREATE', '创建管理员用户');

SET FOREIGN_KEY_CHECKS = 1;
