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

 Date: 23/11/2024 11:50:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
  `admin_user_id` bigint(0) NULL DEFAULT NULL COMMENT '用户ID',
  `permission_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限编码',
  `permission_remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限备注',
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
  `admin_user_id` bigint(0) NULL DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(0) NULL DEFAULT NULL COMMENT '角色ID',
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名',
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
  `arthor_id` bigint(0) NULL DEFAULT NULL COMMENT '作者ID',
  `state` int(0) NULL DEFAULT NULL COMMENT '文章状态@T=ArticleState;@E=0:INIT;',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '内容',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标题',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `price` bigint(0) NULL DEFAULT NULL COMMENT '价格',
  `del_flag` tinyint(1) NULL DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article
-- ----------------------------

-- ----------------------------
-- Table structure for article_comment
-- ----------------------------
DROP TABLE IF EXISTS `article_comment`;
CREATE TABLE `article_comment`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `article_id` bigint(0) NULL DEFAULT NULL COMMENT '文章ID',
  `author_id` bigint(0) NULL DEFAULT NULL COMMENT '作者ID',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '内容',
  `del_flag` tinyint(1) NULL DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章评论' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_comment
-- ----------------------------

-- ----------------------------
-- Table structure for article_comment_like
-- ----------------------------
DROP TABLE IF EXISTS `article_comment_like`;
CREATE TABLE `article_comment_like`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `customer_id` bigint(0) NULL DEFAULT NULL COMMENT '消费者ID',
  `comments` bigint(0) NULL DEFAULT NULL COMMENT '评论ID',
  `del_flag` tinyint(1) NULL DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_comment_like
-- ----------------------------

-- ----------------------------
-- Table structure for article_comment_statistics
-- ----------------------------
DROP TABLE IF EXISTS `article_comment_statistics`;
CREATE TABLE `article_comment_statistics`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `likes` bigint(0) NULL DEFAULT NULL COMMENT '点赞数',
  `reports` bigint(0) NULL DEFAULT NULL COMMENT '举报数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '@P=article_comment;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_comment_statistics
-- ----------------------------

-- ----------------------------
-- Table structure for article_like
-- ----------------------------
DROP TABLE IF EXISTS `article_like`;
CREATE TABLE `article_like`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `customer_id` bigint(0) NULL DEFAULT NULL COMMENT '消费者ID',
  `article_id` bigint(0) NULL DEFAULT NULL COMMENT '文章ID',
  `del_flag` tinyint(1) NULL DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_like
-- ----------------------------

-- ----------------------------
-- Table structure for article_statistics
-- ----------------------------
DROP TABLE IF EXISTS `article_statistics`;
CREATE TABLE `article_statistics`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `likes` bigint(0) NULL DEFAULT NULL COMMENT '点赞数',
  `reports` bigint(0) NULL DEFAULT NULL COMMENT '举报数',
  `comments` bigint(0) NULL DEFAULT NULL COMMENT '评论数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '@P=article;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_statistics
-- ----------------------------

-- ----------------------------
-- Table structure for block
-- ----------------------------
DROP TABLE IF EXISTS `block`;
CREATE TABLE `block`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `block_id` bigint(0) NULL DEFAULT NULL COMMENT '拉黑人ID',
  `blocked_id` bigint(0) NULL DEFAULT NULL COMMENT '被拉黑人ID',
  `del_flag` tinyint(0) NULL DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '拉黑' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of block
-- ----------------------------

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '帐号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `balance` bigint(0) NULL DEFAULT NULL COMMENT '余额',
  `nick_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `signature` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '个性签名',
  `grade` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '等级',
  `del_flag` tinyint(1) NULL DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '消费者' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------

-- ----------------------------
-- Table structure for customer_permission
-- ----------------------------
DROP TABLE IF EXISTS `customer_permission`;
CREATE TABLE `customer_permission`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `permission_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限编码',
  `permission_remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '@P=customer;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer_permission
-- ----------------------------

-- ----------------------------
-- Table structure for customer_role
-- ----------------------------
DROP TABLE IF EXISTS `customer_role`;
CREATE TABLE `customer_role`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `role_id` bigint(0) NULL DEFAULT NULL COMMENT '角色ID',
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '@P=customer;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer_role
-- ----------------------------

-- ----------------------------
-- Table structure for customer_statistics
-- ----------------------------
DROP TABLE IF EXISTS `customer_statistics`;
CREATE TABLE `customer_statistics`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `rank` bigint(0) NULL DEFAULT NULL COMMENT '经验',
  `likes` bigint(0) NULL DEFAULT NULL COMMENT '点赞数',
  `fans` bigint(0) NULL DEFAULT NULL COMMENT '粉丝数',
  `reports` bigint(0) NULL DEFAULT NULL COMMENT '举报数',
  `follows` bigint(0) NULL DEFAULT NULL COMMENT '关注数',
  `works` bigint(0) NULL DEFAULT NULL COMMENT '作品数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '@P=customer;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer_statistics
-- ----------------------------

-- ----------------------------
-- Table structure for favorite_article
-- ----------------------------
DROP TABLE IF EXISTS `favorite_article`;
CREATE TABLE `favorite_article`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `favorites_id` bigint(0) NULL DEFAULT NULL COMMENT '收藏夹ID',
  `article_id` bigint(0) NULL DEFAULT NULL COMMENT '文章ID',
  `del_flag` tinyint(1) NULL DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of favorite_article
-- ----------------------------

-- ----------------------------
-- Table structure for favorites
-- ----------------------------
DROP TABLE IF EXISTS `favorites`;
CREATE TABLE `favorites`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `customer_id` bigint(0) NULL DEFAULT NULL COMMENT '消费者ID',
  `title` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标题',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `state` int(0) NULL DEFAULT NULL COMMENT '收藏夹状态@T=FavoritesState;@E=0:INIT;',
  `def` tinyint(1) NULL DEFAULT NULL COMMENT '默认标识',
  `del_flag` tinyint(1) NULL DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '收藏夹' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of favorites
-- ----------------------------

-- ----------------------------
-- Table structure for follow
-- ----------------------------
DROP TABLE IF EXISTS `follow`;
CREATE TABLE `follow`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `follow_id` bigint(0) NULL DEFAULT NULL COMMENT '关注人ID',
  `followed_id` bigint(0) NULL DEFAULT NULL COMMENT '被关注人ID',
  `del_flag` tinyint(1) NULL DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '关注' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of follow
-- ----------------------------

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `serial` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '流水号',
  `customer_id` bigint(0) NULL DEFAULT NULL COMMENT '消费者ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
  `type` int(0) NULL DEFAULT NULL COMMENT '类型@T=OrderType;@E=0:INIT;',
  `state` int(0) NULL DEFAULT NULL COMMENT '订单状态@T=OrderState;@E=0:INIT;',
  `price` bigint(0) NULL DEFAULT NULL COMMENT '总价格',
  `actual_price` bigint(0) NULL DEFAULT NULL COMMENT '实付价格',
  `pay_time` timestamp(0) NULL DEFAULT NULL COMMENT '支付时间',
  `is_paid` tinyint(1) NULL DEFAULT NULL COMMENT '支付标识',
  `del_flag` tinyint(1) NULL DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单' ROW_FORMAT = Dynamic;

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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表\r\n @Spe;\r\n @Fac;\r\n @DE=RoleInfoChanged|RolePermissionChanged;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (105305049361547264, 'admin', '管理员', '2024-11-17 14:04:40');
INSERT INTO `role` VALUES (105709573049942016, 'normal', '普通用户', '2024-11-18 16:52:06');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `role_id` bigint(0) NULL DEFAULT NULL COMMENT '角色ID',
  `permission_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限编码',
  `permission_remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色权限表\r\n @P=role;\r\n @L=true;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES (105305049487376384, 105305049361547264, 'ADMIN_USER_EDIT', '更新管理员用户信息');
INSERT INTO `role_permission` VALUES (105709573280628736, 105709573049942016, 'ADMIN_USER_EDIT', '更新管理员用户信息');

-- ----------------------------
-- Table structure for star
-- ----------------------------
DROP TABLE IF EXISTS `star`;
CREATE TABLE `star`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `master_id` bigint(0) NULL DEFAULT NULL COMMENT '星主ID',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '星球名',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `price` bigint(20) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '价格',
  `del_flag` tinyint(1) NULL DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '星球' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of star
-- ----------------------------

-- ----------------------------
-- Table structure for star_comment
-- ----------------------------
DROP TABLE IF EXISTS `star_comment`;
CREATE TABLE `star_comment`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `article_id` bigint(0) NULL DEFAULT NULL COMMENT '文章ID',
  `author_id` bigint(0) NULL DEFAULT NULL COMMENT '作者ID',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '星球评论' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of star_comment
-- ----------------------------

-- ----------------------------
-- Table structure for star_comment_like
-- ----------------------------
DROP TABLE IF EXISTS `star_comment_like`;
CREATE TABLE `star_comment_like`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `customer_id` bigint(0) NULL DEFAULT NULL COMMENT '消费者ID',
  `comment_id` int(0) NULL DEFAULT NULL COMMENT '评论ID',
  `del_flag` tinyint(1) NULL DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of star_comment_like
-- ----------------------------

-- ----------------------------
-- Table structure for star_comment_statistics
-- ----------------------------
DROP TABLE IF EXISTS `star_comment_statistics`;
CREATE TABLE `star_comment_statistics`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `likes` bigint(0) NULL DEFAULT NULL COMMENT '点赞数',
  `reports` bigint(0) NULL DEFAULT NULL COMMENT '举报数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '@P=star_comment;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of star_comment_statistics
-- ----------------------------

-- ----------------------------
-- Table structure for star_statistics
-- ----------------------------
DROP TABLE IF EXISTS `star_statistics`;
CREATE TABLE `star_statistics`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `stardust` bigint(0) NULL DEFAULT NULL COMMENT '星尘',
  `comments` bigint(0) NULL DEFAULT NULL COMMENT '评论数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '@P=star;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of star_statistics
-- ----------------------------

-- ----------------------------
-- Table structure for stardust
-- ----------------------------
DROP TABLE IF EXISTS `stardust`;
CREATE TABLE `stardust`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `star_id` bigint(0) NULL DEFAULT NULL COMMENT '星球ID',
  `customer_id` bigint(0) NULL DEFAULT NULL COMMENT '消费者ID',
  `del_flag` tinyint(1) NULL DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '星尘' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stardust
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
