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

 Date: 21/12/2024 14:48:05
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
-- Records of __achrived_event
-- ----------------------------

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
-- Records of __archived_saga
-- ----------------------------

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
-- Records of __archived_saga_process
-- ----------------------------

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
-- Records of __event
-- ----------------------------

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
-- Records of __locker
-- ----------------------------
INSERT INTO `__locker` VALUES (1, 'saga_compense[only4-KSP-cap4j]', 'ShRxtmAb', '2024-12-15 21:03:00', '2024-12-15 21:03:00', 0, '2024-11-17 04:55:00', '2024-12-15 13:03:00');

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
-- Records of __saga
-- ----------------------------

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
-- Records of __saga_process
-- ----------------------------

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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表\r\n @Spe;\r\n @Fac;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_user
-- ----------------------------

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
-- Records of admin_user_permission
-- ----------------------------

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
-- Records of admin_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标题',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '描述',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
  `cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文章封面',
  `appendix` int(0) NULL DEFAULT NULL COMMENT '文章附件',
  `state` int(0) NOT NULL COMMENT '文章状态@T=ArticleState;@E=0:PRIVATE|1:PUBLISH|2:BANNED;',
  `sticky_flag` tinyint(1) NOT NULL COMMENT '置顶标识',
  `comment_flag` tinyint(1) NOT NULL COMMENT '评论功能标识',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章\n @Fac;\n @DE=CreatedArticle|UpdatedArticleLikes|UpdatedArticleFavorites|LikedArticle|UnlikedArticle|CreatedArticleComment|DeletedArticleComment|LikedArticleComment|UnlikedArticleComment|UpdatedArticleCommentLikes;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article
-- ----------------------------

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
-- Records of article_author
-- ----------------------------

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
-- Records of article_category
-- ----------------------------

-- ----------------------------
-- Table structure for article_comment
-- ----------------------------
DROP TABLE IF EXISTS `article_comment`;
CREATE TABLE `article_comment`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `article_id` bigint(0) NOT NULL COMMENT '文章ID',
  `parent_id` bigint(0) NOT NULL COMMENT '父评论ID',
  `author_id` bigint(0) NOT NULL COMMENT '评论用户ID',
  `author_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '评论用户名',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
  `sticky_flag` tinyint(1) NOT NULL COMMENT '置顶标识',
  `create_at` timestamp(0) NOT NULL COMMENT '评论时间',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章评论\n @P=article;\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_comment
-- ----------------------------

-- ----------------------------
-- Table structure for article_comment_like
-- ----------------------------
DROP TABLE IF EXISTS `article_comment_like`;
CREATE TABLE `article_comment_like`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `comment_id` bigint(0) NOT NULL COMMENT '评论ID',
  `member_id` bigint(0) NOT NULL COMMENT '点赞用户ID',
  `create_at` timestamp(0) NOT NULL COMMENT '点赞时间',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章评论点赞\n @P=article_comment;\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_comment_like
-- ----------------------------

-- ----------------------------
-- Table structure for article_comment_statistics
-- ----------------------------
DROP TABLE IF EXISTS `article_comment_statistics`;
CREATE TABLE `article_comment_statistics`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `comment_id` bigint(0) NOT NULL COMMENT '文章评论ID',
  `likes` bigint(0) NOT NULL COMMENT '点赞数',
  `comment_replies` int(0) NOT NULL COMMENT '评论回复数',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章评论\n @P=article_comment;\n @C=One;\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_comment_statistics
-- ----------------------------

-- ----------------------------
-- Table structure for article_favorite_record
-- ----------------------------
DROP TABLE IF EXISTS `article_favorite_record`;
CREATE TABLE `article_favorite_record`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `favorite_id` bigint(0) NOT NULL COMMENT '收藏夹ID',
  `article_id` bigint(0) NOT NULL COMMENT '文章ID',
  `create_at` timestamp(0) NOT NULL COMMENT '收藏时间',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会员收藏记录\n @P=favorite;\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_favorite_record
-- ----------------------------

-- ----------------------------
-- Table structure for article_favorite_statistics
-- ----------------------------
DROP TABLE IF EXISTS `article_favorite_statistics`;
CREATE TABLE `article_favorite_statistics`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `favorite_id` bigint(0) NOT NULL COMMENT '收藏夹ID',
  `articles` bigint(0) NOT NULL COMMENT '文章数',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '收藏夹统计\n @P=favorite;\n @C=One;\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_favorite_statistics
-- ----------------------------

-- ----------------------------
-- Table structure for article_like
-- ----------------------------
DROP TABLE IF EXISTS `article_like`;
CREATE TABLE `article_like`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `article_id` bigint(0) NOT NULL COMMENT '文章ID',
  `member_id` bigint(0) NOT NULL COMMENT '点赞用户ID',
  `like_time` timestamp(0) NOT NULL COMMENT '点赞时间',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章点赞\n @P=article;\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_like
-- ----------------------------

-- ----------------------------
-- Table structure for article_statistics
-- ----------------------------
DROP TABLE IF EXISTS `article_statistics`;
CREATE TABLE `article_statistics`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `article_id` bigint(0) NOT NULL COMMENT '文章ID',
  `likes` bigint(0) NOT NULL COMMENT '点赞数',
  `favorites` int(0) NOT NULL COMMENT '文章收藏数',
  `comments` bigint(0) NOT NULL COMMENT '评论数',
  `views` int(0) NOT NULL COMMENT '文章浏览量',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章统计\n @P=article;\n @C=One;\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_statistics
-- ----------------------------

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
-- Records of article_tag
-- ----------------------------

-- ----------------------------
-- Table structure for block_member
-- ----------------------------
DROP TABLE IF EXISTS `block_member`;
CREATE TABLE `block_member`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `member_id` bigint(0) NOT NULL COMMENT '会员ID',
  `block_member_id` bigint(0) NOT NULL COMMENT '拉黑会员ID',
  `block_member_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '拉黑会员名',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '拉黑会员\n @P=member;\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of block_member
-- ----------------------------

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '分类名',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '分类\n @Fac;\n @DE=UpdatedCategoryInfo;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------

-- ----------------------------
-- Table structure for favorite
-- ----------------------------
DROP TABLE IF EXISTS `favorite`;
CREATE TABLE `favorite`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `member_id` bigint(0) NOT NULL COMMENT '会员ID',
  `favorite_id` bigint(0) NOT NULL COMMENT '收藏夹ID',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会员收藏夹\n @P=member;\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of favorite
-- ----------------------------

-- ----------------------------
-- Table structure for follow_member
-- ----------------------------
DROP TABLE IF EXISTS `follow_member`;
CREATE TABLE `follow_member`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `member_id` bigint(0) NOT NULL COMMENT '会员ID',
  `follow_member_id` bigint(0) NOT NULL COMMENT '关注会员ID',
  `follow_member_name` int(0) NULL DEFAULT NULL COMMENT '关注会员名',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '关注会员\n @P=member;\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of follow_member
-- ----------------------------

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '帐号',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `nick_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `signature` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '个性签名',
  `level` int(0) NULL DEFAULT NULL COMMENT '等级',
  `balance` bigint(0) NULL DEFAULT NULL COMMENT '余额',
  `ban_flag` tinyint(1) NOT NULL COMMENT '封禁标识',
  `ban_time` timestamp(0) NULL DEFAULT NULL COMMENT '封禁时间',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会员\n @Fac;\n @DE=UpdatedMemberInfo|SignedIn|UpdatedMemberRank|FollowedMember|UnFollowedMember|FavoritedArticle|UnFavoritedArticle|CalculatedWillReceiveRanks|RegisteredMemberByPassword|RegisteredMemberByPhone|UpdatedMemberLikes;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of member
-- ----------------------------

-- ----------------------------
-- Table structure for member_like_record
-- ----------------------------
DROP TABLE IF EXISTS `member_like_record`;
CREATE TABLE `member_like_record`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `member_id` bigint(0) NOT NULL COMMENT '会员ID',
  `article_id` bigint(0) NOT NULL COMMENT '文章ID',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会员点赞记录\n @P=member;\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of member_like_record
-- ----------------------------

-- ----------------------------
-- Table structure for member_permission
-- ----------------------------
DROP TABLE IF EXISTS `member_permission`;
CREATE TABLE `member_permission`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `member_id` bigint(0) NOT NULL COMMENT '会员ID',
  `permission_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限码',
  `permission_mark` int(0) NOT NULL COMMENT '权限备注',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会员权限\n @P=member;\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of member_permission
-- ----------------------------

-- ----------------------------
-- Table structure for member_star
-- ----------------------------
DROP TABLE IF EXISTS `member_star`;
CREATE TABLE `member_star`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `member_id` bigint(0) NOT NULL COMMENT '会员ID',
  `star_id` bigint(0) NOT NULL COMMENT '星球ID',
  `star_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '星球名',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会员星球\n @P=member;\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of member_star
-- ----------------------------

-- ----------------------------
-- Table structure for member_statistics
-- ----------------------------
DROP TABLE IF EXISTS `member_statistics`;
CREATE TABLE `member_statistics`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `member_id` bigint(0) NOT NULL COMMENT '会员ID',
  `rank` int(0) NOT NULL COMMENT '等级分',
  `likes` int(0) NOT NULL COMMENT '点赞数',
  `fans` int(0) NOT NULL COMMENT '粉丝数',
  `reports` int(0) NOT NULL COMMENT '举报数',
  `followings` int(0) NOT NULL COMMENT '关注数',
  `works` int(0) NOT NULL COMMENT '作品数',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会员统计\n @P=member;\n @C=One;\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of member_statistics
-- ----------------------------

-- ----------------------------
-- Table structure for member_wrok
-- ----------------------------
DROP TABLE IF EXISTS `member_wrok`;
CREATE TABLE `member_wrok`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `work_id` bigint(0) NOT NULL COMMENT '作品ID',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会员作品\n @P=member;\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of member_wrok
-- ----------------------------

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `amount` int(0) NOT NULL COMMENT '订单金额',
  `price` int(0) NOT NULL COMMENT '实付金额',
  `state` int(0) NOT NULL COMMENT '状态',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单\n @Fac;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------

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
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (115514853904351232, 'normal', '普通', '2024-12-15 18:14:47', 1);

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
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES (115514853908545536, 115514853904351232, 'ADMIN_USER_EDIT', '更新管理员用户信息', 1);
INSERT INTO `role_permission` VALUES (115518729864871936, 115514853904351232, 'ADMIN_USER_VIEW', '查询管理员用户', 1);
INSERT INTO `role_permission` VALUES (115518729898426368, 115514853904351232, 'ADMIN_USER_UPDATE_ROLES', '更新管理员用户角色', 1);
INSERT INTO `role_permission` VALUES (115518729902620672, 115514853904351232, 'ADMIN_USER_UPDATE_PASSWORD', '更新管理员用户密码', 1);
INSERT INTO `role_permission` VALUES (115518729902620673, 115514853904351232, 'ADMIN_USER_DELETE', '删除管理员用户', 1);
INSERT INTO `role_permission` VALUES (115518729902620674, 115514853904351232, 'ADMIN_USER_CREATE', '创建管理员用户', 1);

-- ----------------------------
-- Table structure for sign_in_record
-- ----------------------------
DROP TABLE IF EXISTS `sign_in_record`;
CREATE TABLE `sign_in_record`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `member_id` bigint(0) NOT NULL COMMENT '会员ID',
  `create_at` int(0) NULL DEFAULT NULL COMMENT '签到时间',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会员签到记录 \n @P=member;\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sign_in_record
-- ----------------------------

-- ----------------------------
-- Table structure for star
-- ----------------------------
DROP TABLE IF EXISTS `star`;
CREATE TABLE `star`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `member_id` bigint(0) NOT NULL COMMENT '星主ID',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '星球名',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '星球描述',
  `amount` int(0) NOT NULL COMMENT '星球价格',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '星球\n @Fac;\n @DE=CreatedStar|DeletedStar|JoinedStar|LeftStar|LikedStar|UnLikedStar|CreatedStarComment|DeletedStarComment|LikedStarComment|UnLikedStarComment;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of star
-- ----------------------------

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
-- Records of star_comment
-- ----------------------------

-- ----------------------------
-- Table structure for star_comment_like
-- ----------------------------
DROP TABLE IF EXISTS `star_comment_like`;
CREATE TABLE `star_comment_like`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `star_id` bigint(0) NOT NULL COMMENT '星球ID',
  `stardust_id` bigint(0) NOT NULL COMMENT '星尘ID',
  `create_at` timestamp(0) NOT NULL COMMENT '点赞时间',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '星球评论点赞\n @P=star_comment;\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of star_comment_like
-- ----------------------------

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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '星球点赞\n @P=star;\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of star_like
-- ----------------------------

-- ----------------------------
-- Table structure for star_statistice
-- ----------------------------
DROP TABLE IF EXISTS `star_statistice`;
CREATE TABLE `star_statistice`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `star_id` bigint(0) NOT NULL COMMENT '星球ID',
  `likes` int(0) NOT NULL COMMENT '星球点赞数',
  `comments` int(0) NOT NULL COMMENT '星球评论数',
  `stardust` int(0) NOT NULL COMMENT '星尘数',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '星球统计\n @P=star;\n @C=One;\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of star_statistice
-- ----------------------------

-- ----------------------------
-- Table structure for stardust
-- ----------------------------
DROP TABLE IF EXISTS `stardust`;
CREATE TABLE `stardust`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `star_id` bigint(0) NOT NULL COMMENT '星球ID',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '星尘名',
  `create_at` timestamp(0) NOT NULL COMMENT '吸引时间',
  `del_at` timestamp(0) NULL DEFAULT NULL COMMENT '逃逸时间',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '星尘\n @P=star;\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stardust
-- ----------------------------

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标签名',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标签描述',
  `icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标签图标',
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '标签\n @Fac;\n @DE=UpdatedTagInfo;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tag
-- ----------------------------

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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会员历史记录\n @P=member;\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of view_history
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
