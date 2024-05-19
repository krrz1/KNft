/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : k_nft

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 31/03/2023 17:32:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bill
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `user` int(0) NULL DEFAULT NULL,
  `checkOutTime` datetime(0) NULL DEFAULT NULL,
  `totalMoney` double(20, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bill
-- ----------------------------
INSERT INTO `bill` VALUES (6, 1, '2023-03-29 15:39:44', 21.00);
INSERT INTO `bill` VALUES (7, 1, '2023-03-29 17:09:17', 21.00);
INSERT INTO `bill` VALUES (8, 1, '2023-03-29 17:09:25', 22.00);
INSERT INTO `bill` VALUES (10, 1, '2023-03-29 19:27:46', 12.00);
INSERT INTO `bill` VALUES (11, 1, '2023-03-30 13:36:25', 21.00);
INSERT INTO `bill` VALUES (12, 1, '2023-03-30 15:35:17', 21.00);
INSERT INTO `bill` VALUES (14, 2, '2023-03-30 17:04:12', 22.00);
INSERT INTO `bill` VALUES (15, 1, '2023-03-30 20:26:49', 22.00);
INSERT INTO `bill` VALUES (16, 1, '2023-03-31 11:06:27', 2.00);
INSERT INTO `bill` VALUES (17, 1, '2023-03-31 11:11:27', 22.00);
INSERT INTO `bill` VALUES (18, 1, '2023-03-31 11:11:57', 22.00);
INSERT INTO `bill` VALUES (19, 6, '2023-03-31 11:21:41', 12.00);
INSERT INTO `bill` VALUES (20, 6, '2023-03-31 11:22:20', 12.00);
INSERT INTO `bill` VALUES (21, 6, '2023-03-31 11:22:27', 12.00);
INSERT INTO `bill` VALUES (22, 6, '2023-03-31 11:22:36', 22.00);
INSERT INTO `bill` VALUES (23, 1, '2023-03-31 16:12:06', 22.00);
INSERT INTO `bill` VALUES (24, 1, '2023-03-31 16:13:27', 22.00);
INSERT INTO `bill` VALUES (26, 7, '2023-03-31 16:32:53', 22.00);

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `collectionImg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `collectionName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `price` double(10, 2) NULL DEFAULT NULL,
  `sellers` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` int(0) NOT NULL DEFAULT 0,
  `likeCount` int(0) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collection
-- ----------------------------
INSERT INTO `collection` VALUES (8, '1671221991021.jpg', '洋', 1.00, '1', 0, 0);
INSERT INTO `collection` VALUES (9, '1b99f0d4a2b9bb3943a8030906abe0be3.jpg', '洋羊二号', 2222.00, '222', 0, 0);
INSERT INTO `collection` VALUES (12, '008sy0DRly1h8wlausv1sj31vg1emh5l.jpg', '212', 222.00, '22', 0, 0);
INSERT INTO `collection` VALUES (15, 'OIP-C (1).jpg', '阿帕基', 99.00, '暗杀小队', 0, 0);
INSERT INTO `collection` VALUES (16, 'OIP-C.jfif', '鼠鼠', 22.00, '大耳贼', 0, 9);
INSERT INTO `collection` VALUES (17, 'R-C.png', 'big恐龙', 22.00, '大窟窿', 0, 2);
INSERT INTO `collection` VALUES (18, 'v2-e30e564ef0c468c5cfbe3682ac7052af_r.jpg', '大马猴', 29.00, 'krrz', 0, 0);
INSERT INTO `collection` VALUES (19, 'v2-ea21333b7048f7228e41c752f59698ad_r.jpg', '呆头鹅', 12.00, '1222', 0, 0);
INSERT INTO `collection` VALUES (21, 'OIP-C (1).jfif', '字画', 12.00, '12', 0, 0);
INSERT INTO `collection` VALUES (22, 'R-C (1).jfif', '天使猴', 12.00, '猴子', 0, 0);
INSERT INTO `collection` VALUES (23, 'v2-4a53fc4f8fcf291b2791636356423da1_r.jpg', '游戏王猴', 22.00, '12', 0, 0);
INSERT INTO `collection` VALUES (24, 'R-C (1).png', 'big狗', 2.00, '12', 0, 0);
INSERT INTO `collection` VALUES (25, 'R-C.jfif', '潮财神', 22.00, '12', 0, 0);
INSERT INTO `collection` VALUES (27, 'R-C (2).png', '猫猫猴', 12.00, '12', 0, 0);

-- ----------------------------
-- Table structure for possession_item
-- ----------------------------
DROP TABLE IF EXISTS `possession_item`;
CREATE TABLE `possession_item`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `collection` int(0) NULL DEFAULT NULL,
  `count` int(0) NULL DEFAULT 1,
  `user` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of possession_item
-- ----------------------------
INSERT INTO `possession_item` VALUES (1, 1, 2, 1);
INSERT INTO `possession_item` VALUES (6, 16, 1, 2);
INSERT INTO `possession_item` VALUES (7, 17, 1, 1);
INSERT INTO `possession_item` VALUES (11, 21, 2, 6);
INSERT INTO `possession_item` VALUES (12, 17, 1, 6);
INSERT INTO `possession_item` VALUES (13, 16, 2, 1);
INSERT INTO `possession_item` VALUES (14, 16, 1, 7);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `pwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `role` int(0) NULL DEFAULT 0,
  `balance` double(15, 2) NULL DEFAULT 0.00,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'krrz', '123', '1600753652@qq.com', 1, 1000080.00);
INSERT INTO `user` VALUES (2, 'krrz1', '123', '123@qq.com', 0, 1.00);
INSERT INTO `user` VALUES (3, 'krrz2', '123', '123@qq.com', 0, 0.00);
INSERT INTO `user` VALUES (4, 'krrz11', '123', '123@qq.com', 0, 0.00);
INSERT INTO `user` VALUES (5, 'lina', 'ok', '123@qq.com', 0, 0.00);
INSERT INTO `user` VALUES (6, 'k2', '123', '123@qq.com', 0, 9999965.00);
INSERT INTO `user` VALUES (7, 'k3', '123', '12121@qq.com', 0, 1000010.00);

SET FOREIGN_KEY_CHECKS = 1;
