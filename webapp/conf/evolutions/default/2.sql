/*
 Navicat Premium Data Transfer

 Source Server         : 1-localhost
 Source Server Type    : MySQL
 Source Server Version : 50529
 Source Host           : localhost
 Source Database       : iziproject

 Target Server Type    : MySQL
 Target Server Version : 50529
 File Encoding         : utf-8

 Date: 02/24/2014 17:42:15 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Records of `account`
-- ----------------------------
BEGIN;
INSERT INTO `account` VALUES ('admin@email.com', 'Admin', 'secret', '1', '/resource/upload/no_avatar_20_20.png');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
