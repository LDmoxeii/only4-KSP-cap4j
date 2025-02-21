/*
 Navicat Premium Data Transfer

 Source Server         : only4-ksp-capj4
 Source Server Type    : MySQL
 Source Server Version : 80033
 Source Host           : localhost:3306
 Source Schema         : only4-ksp-cap4j

 Target Server Type    : MySQL
 Target Server Version : 80033
 File Encoding         : 65001

 Date: 21/02/2025 16:30:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for __achrived_event
-- ----------------------------
DROP TABLE IF EXISTS `__achrived_event`;
CREATE TABLE `__achrived_event`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `event_uuid` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '事件uuid',
  `svc_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '服务',
  `event_type` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '事件类型',
  `data` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '事件数据',
  `data_type` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '事件数据类型',
  `exception` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '事件发送异常',
  `expire_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '过期时间',
  `create_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `event_state` int(0) NOT NULL DEFAULT 0 COMMENT '分发状态',
  `last_try_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '上次尝试时间',
  `next_try_time` datetime(0) NOT NULL DEFAULT '0001-01-01 00:00:00' COMMENT '下次尝试时间',
  `tried_times` int(0) NOT NULL DEFAULT 0 COMMENT '已尝试次数',
  `try_times` int(0) NOT NULL DEFAULT 0 COMMENT '尝试次数',
  `version` int(0) NOT NULL DEFAULT 0,
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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '事件发件箱存档 support by cap4j\n@I;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for __archived_saga
-- ----------------------------
DROP TABLE IF EXISTS `__archived_saga`;
CREATE TABLE `__archived_saga`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `saga_uuid` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'SAGA uuid',
  `svc_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '服务',
  `saga_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'SAGA类型',
  `param` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '参数',
  `param_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '参数类型',
  `result` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '结果',
  `result_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '结果类型',
  `exception` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '执行异常',
  `expire_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '过期时间',
  `create_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `saga_state` int(0) NOT NULL DEFAULT 0 COMMENT '执行状态@E=0:INIT:init|-1:EXECUTING:executing|-2:CANCEL:cancel|-3:EXPIRED:expired|-4:EXHAUSTED:exhausted|-9:EXCEPTION:exception|1:EXECUTED:executed;@T=SagaState;',
  `last_try_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '上次尝试时间',
  `next_try_time` datetime(0) NOT NULL DEFAULT '0001-01-01 00:00:00' COMMENT '下次尝试时间',
  `tried_times` int(0) NOT NULL DEFAULT 0 COMMENT '已尝试次数',
  `try_times` int(0) NOT NULL DEFAULT 0 COMMENT '尝试次数',
  `version` int(0) NOT NULL DEFAULT 0,
  `db_created_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `db_updated_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_db_created_at`(`db_created_at`) USING BTREE,
  INDEX `idx_db_updated_at`(`db_updated_at`) USING BTREE,
  INDEX `idx_saga_uuid`(`saga_uuid`) USING BTREE,
  INDEX `idx_saga_type`(`saga_type`, `svc_name`) USING BTREE,
  INDEX `idx_create_at`(`create_at`) USING BTREE,
  INDEX `idx_expire_at`(`expire_at`) USING BTREE,
  INDEX `idx_next_try_time`(`next_try_time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'SAGA事务(存档) support by cap4j\n@I;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for __archived_saga_process
-- ----------------------------
DROP TABLE IF EXISTS `__archived_saga_process`;
CREATE TABLE `__archived_saga_process`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `saga_id` bigint(0) NOT NULL DEFAULT 0,
  `process_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'SAGA处理环节代码',
  `param` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '参数',
  `param_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '参数类型',
  `result` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '结果',
  `result_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '结果类型',
  `exception` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '执行异常',
  `process_state` int(0) NOT NULL DEFAULT 0 COMMENT '执行状态@E=0:INIT:init|-1:EXECUTING:executing|-9:EXCEPTION:exception|1:EXECUTED:executed;@T=SagaProcessState;',
  `create_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `last_try_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '上次尝试时间',
  `tried_times` int(0) NOT NULL DEFAULT 0 COMMENT '尝试次数',
  `db_created_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `db_updated_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_db_created_at`(`db_created_at`) USING BTREE,
  INDEX `idx_db_updated_at`(`db_updated_at`) USING BTREE,
  INDEX `idx_saga_id`(`saga_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'SAGA事务-子环节(存档) support by cap4j\n@I;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for __event
-- ----------------------------
DROP TABLE IF EXISTS `__event`;
CREATE TABLE `__event`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `event_uuid` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '事件uuid',
  `svc_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '服务',
  `event_type` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '事件类型',
  `data` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '事件数据',
  `data_type` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '事件数据类型',
  `exception` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '事件发送异常',
  `expire_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '过期时间',
  `create_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `event_state` int(0) NOT NULL DEFAULT 0 COMMENT '分发状态',
  `last_try_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '上次尝试时间',
  `next_try_time` datetime(0) NOT NULL DEFAULT '0001-01-01 00:00:00' COMMENT '下次尝试时间',
  `tried_times` int(0) NOT NULL DEFAULT 0 COMMENT '已尝试次数',
  `try_times` int(0) NOT NULL DEFAULT 0 COMMENT '尝试次数',
  `version` int(0) NOT NULL DEFAULT 0,
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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '事件发件箱 support by cap4j\n@I;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for __locker
-- ----------------------------
DROP TABLE IF EXISTS `__locker`;
CREATE TABLE `__locker`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '锁名称',
  `pwd` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '锁密码',
  `lock_at` datetime(0) NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '锁获取时间',
  `unlock_at` datetime(0) NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '锁释放时间',
  `version` bigint(0) UNSIGNED NOT NULL DEFAULT 0,
  `db_created_at` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `db_updated_at` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uniq_name`(`name`) USING BTREE,
  INDEX `idx_db_created_at`(`db_created_at`) USING BTREE,
  INDEX `idx_db_updated_at`(`db_updated_at`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '锁 support by cap4j\n@I;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for __saga
-- ----------------------------
DROP TABLE IF EXISTS `__saga`;
CREATE TABLE `__saga`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `saga_uuid` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'SAGA uuid',
  `svc_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '服务',
  `saga_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'SAGA类型',
  `param` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '参数',
  `param_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '参数类型',
  `result` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '结果',
  `result_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '结果类型',
  `exception` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '执行异常',
  `expire_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '过期时间',
  `create_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `saga_state` int(0) NOT NULL DEFAULT 0 COMMENT '执行状态@E=0:INIT:init|-1:EXECUTING:executing|-2:CANCEL:cancel|-3:EXPIRED:expired|-4:EXHAUSTED:exhausted|-9:EXCEPTION:exception|1:EXECUTED:executed;@T=SagaState;',
  `last_try_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '上次尝试时间',
  `next_try_time` datetime(0) NOT NULL DEFAULT '0001-01-01 00:00:00' COMMENT '下次尝试时间',
  `tried_times` int(0) NOT NULL DEFAULT 0 COMMENT '已尝试次数',
  `try_times` int(0) NOT NULL DEFAULT 0 COMMENT '尝试次数',
  `version` int(0) NOT NULL DEFAULT 0,
  `db_created_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `db_updated_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_db_created_at`(`db_created_at`) USING BTREE,
  INDEX `idx_db_updated_at`(`db_updated_at`) USING BTREE,
  INDEX `idx_saga_uuid`(`saga_uuid`) USING BTREE,
  INDEX `idx_saga_type`(`saga_type`, `svc_name`) USING BTREE,
  INDEX `idx_create_at`(`create_at`) USING BTREE,
  INDEX `idx_expire_at`(`expire_at`) USING BTREE,
  INDEX `idx_next_try_time`(`next_try_time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'SAGA事务 support by cap4j\n@I;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for __saga_process
-- ----------------------------
DROP TABLE IF EXISTS `__saga_process`;
CREATE TABLE `__saga_process`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `saga_id` bigint(0) NOT NULL DEFAULT 0,
  `process_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'SAGA处理环节代码',
  `param` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '参数',
  `param_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '参数类型',
  `result` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '结果',
  `result_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '结果类型',
  `exception` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '执行异常',
  `process_state` int(0) NOT NULL DEFAULT 0 COMMENT '执行状态@E=0:INIT:init|-1:EXECUTING:executing|-9:EXCEPTION:exception|1:EXECUTED:executed;@T=SagaProcessState;',
  `create_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `last_try_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '上次尝试时间',
  `tried_times` int(0) NOT NULL DEFAULT 0 COMMENT '尝试次数',
  `db_created_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `db_updated_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_db_created_at`(`db_created_at`) USING BTREE,
  INDEX `idx_db_updated_at`(`db_updated_at`) USING BTREE,
  INDEX `idx_saga_id`(`saga_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'SAGA事务-子环节 support by cap4j\n@I;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for admin_user
-- ----------------------------
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `refresh_token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '刷新令牌',
  `login_expiry_date` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '过期时间',
  `created_at` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `del_flag` tinyint(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表\n @Fac;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for admin_user_permission
-- ----------------------------
DROP TABLE IF EXISTS `admin_user_permission`;
CREATE TABLE `admin_user_permission`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `admin_user_id` bigint(0) NOT NULL COMMENT '用户ID',
  `permission_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限编码',
  `permission_remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限备注',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户权限表\r\n @P=admin_user;\r\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for admin_user_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_user_role`;
CREATE TABLE `admin_user_role`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `admin_user_id` bigint(0) NOT NULL COMMENT '用户ID',
  `role_id` bigint(0) NOT NULL COMMENT '角色ID',
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户角色表\r\n @P=admin_user;\r\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标题',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '描述',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
  `cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '文章封面',
  `appendix` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '文章附件',
  `price` bigint(0) NOT NULL DEFAULT 0 COMMENT '文章价格',
  `visibility` tinyint(0) NOT NULL DEFAULT 0 COMMENT '文章状态@T=ArticleVisibility;@E=0:PRIVATE|1:PUBLISH|2:BANNED;',
  `sticky_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '置顶标识',
  `comment_flag` tinyint(1) NOT NULL DEFAULT 1 COMMENT '评论功能标识',
  `banned_at` timestamp(0) NULL DEFAULT NULL COMMENT '封禁时间',
  `ban_duration` int(0) NOT NULL DEFAULT 0 COMMENT '封禁时间',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章\n @Fac;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for article_author
-- ----------------------------
DROP TABLE IF EXISTS `article_author`;
CREATE TABLE `article_author`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `article_id` bigint(0) NOT NULL COMMENT '文章ID',
  `author_id` bigint(0) NOT NULL COMMENT '作者ID',
  `author_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '作者名',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章作者\n @P=article;\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for article_category
-- ----------------------------
DROP TABLE IF EXISTS `article_category`;
CREATE TABLE `article_category`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `article_id` bigint(0) NOT NULL COMMENT '文章ID',
  `category_id` bigint(0) NOT NULL COMMENT '分类ID',
  `category_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '分类名',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章分类\n @P=article;\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for article_comment
-- ----------------------------
DROP TABLE IF EXISTS `article_comment`;
CREATE TABLE `article_comment`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `article_id` bigint(0) NOT NULL COMMENT '文章ID',
  `author_id` bigint(0) NOT NULL COMMENT '作者ID',
  `author_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '作者名',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
  `sticky_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '置顶标识',
  `create_at` timestamp(0) NOT NULL COMMENT '评论时间',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章评论\n @Fac;\n @DE=ArticleCommentCreated;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for article_comment_like
-- ----------------------------
DROP TABLE IF EXISTS `article_comment_like`;
CREATE TABLE `article_comment_like`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `article_comment_id` bigint(0) NOT NULL COMMENT '评论ID',
  `member_id` bigint(0) NOT NULL COMMENT '点赞用户ID',
  `create_at` timestamp(0) NOT NULL COMMENT '点赞时间',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章评论点赞\n @Fac;\n @VO;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for article_comment_reply
-- ----------------------------
DROP TABLE IF EXISTS `article_comment_reply`;
CREATE TABLE `article_comment_reply`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `article_comment_id` bigint(0) NOT NULL COMMENT '文章评论ID',
  `author_id` bigint(0) NOT NULL COMMENT '作者ID',
  `author_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '作者名',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
  `create_at` timestamp(0) NOT NULL COMMENT '创建时间',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `article_comment_reply_id_index`(`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章评论回复\n @Fac;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for article_comment_reply_statistics
-- ----------------------------
DROP TABLE IF EXISTS `article_comment_reply_statistics`;
CREATE TABLE `article_comment_reply_statistics`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `article_comment_reply_id` bigint(0) NOT NULL COMMENT '文章评论回复ID',
  `like_count` int(0) NOT NULL COMMENT '点赞数',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `article_comment_reply_statistics_id_index`(`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章评论回复统计\n @P=article_comment_reply;\n @L=true;\n @C=One;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for article_comment_statistics
-- ----------------------------
DROP TABLE IF EXISTS `article_comment_statistics`;
CREATE TABLE `article_comment_statistics`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `article_comment_id` bigint(0) NOT NULL COMMENT '文章评论ID',
  `like_count` int(0) NOT NULL DEFAULT 0 COMMENT '点赞数',
  `reply_count` int(0) NOT NULL DEFAULT 0 COMMENT '评论回复数',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章评论\n @P=article_comment;\n @C=One;\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for article_like
-- ----------------------------
DROP TABLE IF EXISTS `article_like`;
CREATE TABLE `article_like`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `article_id` bigint(0) NOT NULL COMMENT '文章ID',
  `member_id` bigint(0) NOT NULL COMMENT '用户ID',
  `create_at` timestamp(0) NOT NULL COMMENT '创建时间',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章点赞\n @Fac;\n @VO;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for article_statistics
-- ----------------------------
DROP TABLE IF EXISTS `article_statistics`;
CREATE TABLE `article_statistics`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `article_id` bigint(0) NOT NULL COMMENT '文章ID',
  `like_count` int(0) NOT NULL DEFAULT 0 COMMENT '点赞数',
  `favorite_count` int(0) NOT NULL DEFAULT 0 COMMENT '文章收藏数',
  `comment_count` int(0) NOT NULL DEFAULT 0 COMMENT '评论数',
  `view_count` int(0) NOT NULL DEFAULT 0 COMMENT '文章浏览量',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章统计\n @P=article;\n @C=One;\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for article_tag
-- ----------------------------
DROP TABLE IF EXISTS `article_tag`;
CREATE TABLE `article_tag`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `article_id` bigint(0) NOT NULL COMMENT '文章ID',
  `tag_id` bigint(0) NOT NULL COMMENT '标签ID',
  `tag_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标签名',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章标签\n @P=article;\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for block_member
-- ----------------------------
DROP TABLE IF EXISTS `block_member`;
CREATE TABLE `block_member`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `member_id` bigint(0) NOT NULL COMMENT '会员ID',
  `other_id` bigint(0) NOT NULL COMMENT '拉黑会员ID',
  `other_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '拉黑会员名',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '拉黑会员\n @P=member;\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `ref_count` int(0) NOT NULL DEFAULT 0 COMMENT '引用次数',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '分类   \n @Fac;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for check_in
-- ----------------------------
DROP TABLE IF EXISTS `check_in`;
CREATE TABLE `check_in`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `member_id` bigint(0) NOT NULL COMMENT '用户ID',
  `create_at` timestamp(0) NOT NULL COMMENT '创建时间',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会员签到记录 \n @Fac;\n @VO;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for favorites
-- ----------------------------
DROP TABLE IF EXISTS `favorites`;
CREATE TABLE `favorites`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `member_id` bigint(0) NOT NULL COMMENT '会员ID',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '默认收藏夹' COMMENT '收藏夹名',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '描述',
  `default_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '默认标识',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会员收藏夹\n @P=member;\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for favorites_article
-- ----------------------------
DROP TABLE IF EXISTS `favorites_article`;
CREATE TABLE `favorites_article`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `favorites_id` bigint(0) NOT NULL COMMENT '收藏夹ID',
  `article_id` bigint(0) NOT NULL COMMENT '文章ID',
  `create_at` timestamp(0) NOT NULL COMMENT '收藏时间',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会员收藏记录\n @P=favorites;\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for favorites_statistics
-- ----------------------------
DROP TABLE IF EXISTS `favorites_statistics`;
CREATE TABLE `favorites_statistics`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `favorites_id` bigint(0) NOT NULL COMMENT '收藏夹ID',
  `article_count` int(0) NOT NULL DEFAULT 0 COMMENT '文章数',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '收藏夹统计\n @P=favorites;\n @C=One;\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for follow_member
-- ----------------------------
DROP TABLE IF EXISTS `follow_member`;
CREATE TABLE `follow_member`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `member_id` bigint(0) NOT NULL COMMENT '会员ID',
  `other_id` bigint(0) NOT NULL COMMENT '关注会员ID',
  `other_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '关注会员名',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '关注会员\n @P=member;\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '帐号',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '密码',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '手机号',
  `nick_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '昵称',
  `signature` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '个性签名',
  `level` int(0) NOT NULL DEFAULT 0 COMMENT '等级',
  `balance` bigint(0) NOT NULL DEFAULT 0 COMMENT '余额',
  `ban_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '封禁标识',
  `banned_at` timestamp(0) NULL DEFAULT NULL COMMENT '封禁时间',
  `ban_duration` int(0) NOT NULL DEFAULT 0 COMMENT '封禁时长',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会员\n @Fac;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for member_statistics
-- ----------------------------
DROP TABLE IF EXISTS `member_statistics`;
CREATE TABLE `member_statistics`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `member_id` bigint(0) NOT NULL COMMENT '会员ID',
  `rank` int(0) NOT NULL DEFAULT 0 COMMENT '等级分',
  `like_count` int(0) NOT NULL DEFAULT 0 COMMENT '点赞数',
  `fan_count` int(0) NOT NULL DEFAULT 0 COMMENT '粉丝数',
  `report_count` int(0) NOT NULL DEFAULT 0 COMMENT '举报数',
  `following_count` int(0) NOT NULL DEFAULT 0 COMMENT '关注数',
  `work_count` int(0) NOT NULL DEFAULT 0 COMMENT '作品数',
  `view_count` int(0) NOT NULL COMMENT '播放量',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  `stardust_count` int(0) NOT NULL DEFAULT 0 COMMENT '星尘数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会员统计\n @P=member;\n @C=One;\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `amount` int(0) NOT NULL COMMENT '订单金额',
  `price` int(0) NOT NULL COMMENT '实付金额',
  `state` tinyint(0) NOT NULL DEFAULT 0 COMMENT '状态',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单\n @Fac;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `created_at` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表\n @Spe;\n @Fac;\n @DE=UpdatedRolePermissions|UpdatedRoleInfo;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `role_id` bigint(0) NULL DEFAULT NULL COMMENT '角色ID',
  `permission_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限编码',
  `permission_remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限备注',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色权限表\n @P=role;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for star
-- ----------------------------
DROP TABLE IF EXISTS `star`;
CREATE TABLE `star`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `member_id` bigint(0) NOT NULL COMMENT '星主ID',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '星球名',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '星球描述',
  `amount` bigint(0) NOT NULL DEFAULT 0 COMMENT '星球价格',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '星球\n @Fac;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for star_comment
-- ----------------------------
DROP TABLE IF EXISTS `star_comment`;
CREATE TABLE `star_comment`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `star_id` bigint(0) NOT NULL COMMENT '星球ID',
  `stardust_id` bigint(0) NOT NULL COMMENT '星尘ID',
  `stardust_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '星尘名',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '评论内容',
  `create_at` timestamp(0) NOT NULL COMMENT '评论时间',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '星球评论\n @P=star;\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for star_comment_like
-- ----------------------------
DROP TABLE IF EXISTS `star_comment_like`;
CREATE TABLE `star_comment_like`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `star_comment_id` bigint(0) NOT NULL COMMENT '星球评论ID',
  `star_id` bigint(0) NOT NULL COMMENT '星球ID',
  `stardust_id` bigint(0) NOT NULL COMMENT '星尘ID',
  `create_at` timestamp(0) NOT NULL COMMENT '点赞时间',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '星球评论点赞\n @Fac;\n @VO;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for star_comment_statistics
-- ----------------------------
DROP TABLE IF EXISTS `star_comment_statistics`;
CREATE TABLE `star_comment_statistics`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `star_comment_id` bigint(0) NOT NULL COMMENT '星球评论ID',
  `like_count` int(0) NOT NULL DEFAULT 0 COMMENT '点赞数',
  `comment_count` int(0) NOT NULL DEFAULT 0 COMMENT '子评论数',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '星球评论统计\n @P=star_comment;\n @C=One;\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for star_like
-- ----------------------------
DROP TABLE IF EXISTS `star_like`;
CREATE TABLE `star_like`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `star_id` bigint(0) NOT NULL COMMENT '星球ID',
  `stardust_id` bigint(0) NOT NULL COMMENT '星尘ID',
  `create_at` timestamp(0) NOT NULL COMMENT '点赞时间',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '星球点赞\n @Fac;\n @VO;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for star_statistic
-- ----------------------------
DROP TABLE IF EXISTS `star_statistic`;
CREATE TABLE `star_statistic`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `star_id` bigint(0) NOT NULL COMMENT '星球ID',
  `like_count` int(0) NOT NULL DEFAULT 0 COMMENT '星球点赞数',
  `comment_count` int(0) NOT NULL DEFAULT 0 COMMENT '星球评论数',
  `stardust_count` int(0) NOT NULL DEFAULT 0 COMMENT '星尘数',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '星球统计\n @P=star;\n @C=One;\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for stardust
-- ----------------------------
DROP TABLE IF EXISTS `stardust`;
CREATE TABLE `stardust`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `star_id` bigint(0) NOT NULL COMMENT '星球ID',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '星尘名',
  `create_at` timestamp(0) NOT NULL COMMENT '吸引时间',
  `del_at` timestamp(0) NOT NULL DEFAULT '1970-01-01 00:00:01' COMMENT '逃逸时间',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '星尘\n @P=star;\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标签名',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标签描述',
  `icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '标签图标',
  `ref_count` int(0) NOT NULL DEFAULT 0 COMMENT '引用次数',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '标签\n @Fac;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for view_history
-- ----------------------------
DROP TABLE IF EXISTS `view_history`;
CREATE TABLE `view_history`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `member_id` bigint(0) NOT NULL COMMENT '会员ID',
  `article_id` bigint(0) NOT NULL COMMENT '文章ID',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会员历史记录\n @Fac;\n @VO;' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
