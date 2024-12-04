/*
 Navicat Premium Data Transfer

 Source Server         : HelloWorld
 Source Server Type    : MySQL
 Source Server Version : 80033 (8.0.33)
 Source Host           : localhost:3306
 Source Schema         : opinionwatchmaster

 Target Server Type    : MySQL
 Target Server Version : 80033 (8.0.33)
 File Encoding         : 65001

 Date: 04/12/2024 22:58:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for opinion_data
-- ----------------------------
DROP TABLE IF EXISTS `opinion_data`;
CREATE TABLE `opinion_data`  (
  `id` bigint NOT NULL COMMENT '自增主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `uuid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'UUID',
  `source` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '舆情来源',
  `key_word_list` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '关键词列表',
  `like_count` int(10) UNSIGNED ZEROFILL NOT NULL COMMENT '点赞数',
  `comment_count` int(10) UNSIGNED ZEROFILL NOT NULL COMMENT '评论数',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '文本内容',
  `ext_data` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '额外数据',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uniq_uuid`(`uuid` ASC) USING BTREE,
  INDEX `idx_source`(`source` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
