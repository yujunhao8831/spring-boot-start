/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50716
 Source Host           : localhost
 Source Database       : blog

 Target Server Type    : MySQL
 Target Server Version : 50716
 File Encoding         : utf-8

 Date: 05/25/2017 10:03:38 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `history`
-- ----------------------------
DROP TABLE IF EXISTS `history`;
CREATE TABLE `history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `action` varchar(12) DEFAULT NULL COMMENT '操作类型',
  `action_status` varchar(12) DEFAULT NULL COMMENT '操作状态',
  `ip_address` varchar(64) DEFAULT NULL COMMENT '地址',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `table_state` varchar(8) DEFAULT NULL COMMENT '表状态',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='历史记录';

-- ----------------------------
--  Table structure for `note`
-- ----------------------------
DROP TABLE IF EXISTS `note`;
CREATE TABLE `note` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) DEFAULT NULL COMMENT '作者',
  `title` varchar(128) DEFAULT NULL COMMENT '标题',
  `subtitle` varchar(128) DEFAULT NULL COMMENT '副标题',
  `content` text COMMENT '内容',
  `type` varchar(8) DEFAULT NULL COMMENT '类型NOTE:笔记，ARTICLE:文章)【默认:NOTE】 ',
  `category` varchar(12) DEFAULT NULL COMMENT '类别',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `table_state` varchar(8) DEFAULT NULL COMMENT '表状态',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='笔记';

-- ----------------------------
--  Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_name` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `role_name_code` varchar(32) DEFAULT NULL COMMENT '角色名称core',
  `description` varchar(128) DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `AK_role_role_name_code_uk` (`role_name_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(32) DEFAULT NULL COMMENT '用户名',
  `password` varchar(128) DEFAULT NULL COMMENT '密码',
  `nick_name` varchar(128) DEFAULT NULL COMMENT '昵称',
  `email` varchar(128) DEFAULT NULL COMMENT '电子邮箱',
  `phone` varchar(18) DEFAULT NULL COMMENT '手机号码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `table_state` varchar(8) DEFAULT NULL COMMENT '表状态',
  `user_state` varchar(8) DEFAULT NULL COMMENT '账户状态',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `AK_user_email_uk` (`email`),
  UNIQUE KEY `AK_user_phone_uk` (`phone`),
  UNIQUE KEY `user_username_uk_index` (`username`),
  UNIQUE KEY `user_nick_name_uk_index` (`nick_name`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1', '1', '123456', '3', null, null, '2017-05-11 23:03:27', '2017-05-25 09:50:10', null, null, null), ('2', '2', '123456', '5be6bcdc-d4dd-4c99-8eed-e8e3e150abf7', null, null, '2017-05-11 23:37:03', '2017-05-25 09:50:10', null, null, null), ('3', '3', '123456', '720d5d06-95eb-45e4-96e7-510bda74ae42', null, null, '2017-05-11 23:37:03', '2017-05-25 09:50:10', null, null, null), ('4', '5966536112692103123', '123456', '46059b94-c544-41a3-bd08-7dfe57b476e8', null, null, '2017-05-11 23:37:03', '2017-05-25 09:50:10', null, null, null), ('5', '2446258122855630025', '123456', '188567a2-02a4-4000-91ba-23d475a6ac34', null, null, '2017-05-11 23:37:03', '2017-05-25 09:50:10', null, null, null), ('6', '8276925629724183971', '123456', '39d80063-0292-4391-996c-ee025eb3264a', null, null, '2017-05-11 23:37:03', '2017-05-25 09:50:10', null, null, null), ('7', '4436465832247112798', '123456', '03922095-5ee6-4413-a9e0-3271e80518d8', null, null, '2017-05-11 23:37:03', '2017-05-25 09:50:10', null, null, null), ('8', '4297661440557676292', '123456', '5a151333-e53a-4cd9-9696-d72c8f3719ee', null, null, '2017-05-11 23:37:03', '2017-05-25 09:50:10', null, null, null), ('9', '648158439918817333', '123456', 'ec14cfc6-15b5-49ff-85e3-15f6a901cf0f', null, null, '2017-05-11 23:37:03', '2017-05-25 09:50:10', null, null, null), ('10', '157824080102649570', '123456', 'a63be16a-e887-4bb7-a9e3-f8169b955e0e', null, null, '2017-05-11 23:37:03', '2017-05-25 09:50:10', null, null, null), ('11', '688224696742307874', '123456', '7ab1a8cd-afc1-491e-99d9-06d506dbaaad', null, null, '2017-05-11 23:37:03', '2017-05-25 09:50:10', null, null, null), ('12', '4743468034139635580', '123456', 'c5d48712-cd67-4380-baaa-6dc54ac8ecdd', null, null, '2017-05-11 23:37:03', '2017-05-25 09:50:10', null, null, null), ('13', '5191184274765466998', '123456', 'bfb29bcd-521c-4faf-a10e-55cac85158dc', null, null, '2017-05-11 23:37:03', '2017-05-25 09:50:10', null, null, null), ('14', '9073185272192239027', '123456', 'c296c213-92e1-4764-a43d-54e85dfb767e', null, null, '2017-05-11 23:37:03', '2017-05-25 09:50:10', null, null, null), ('15', '8420478560064902241', '123456', 'f7e175db-1f7b-4834-a764-f20af8686083', null, null, '2017-05-11 23:37:03', '2017-05-25 09:50:10', null, null, null), ('16', '1215720473536267808', '123456', '03bc06a9-6485-4ed3-92cf-2f35621ed221', null, null, '2017-05-11 23:37:03', '2017-05-25 09:50:10', null, null, null), ('17', '3573104143288470180', '123456', '5247f5e5-d1bd-4822-ba97-8e0fe9e245a4', null, null, '2017-05-11 23:37:03', '2017-05-25 09:50:10', null, null, null), ('18', '7645796470108489589', '123456', '5e332c1c-6072-406b-bde6-c0d1970a6574', null, null, '2017-05-11 23:37:03', '2017-05-25 09:50:10', null, null, null), ('19', '5203533346629044231', '123456', '702c5c60-f43c-4643-a135-39ba3d447755', null, null, '2017-05-11 23:37:03', '2017-05-25 09:50:10', null, null, null), ('20', '4259598280904527614', '123456', '3ecdc787-d782-4212-83c8-a073639fe3d5', null, null, '2017-05-11 23:37:03', '2017-05-25 09:50:10', null, null, null), ('21', '3419694625317569076', '123456', '5ff90426-16c7-495d-ab6f-c9b1d1f9320d', null, null, '2017-05-11 23:37:03', '2017-05-25 09:50:10', null, null, null), ('22', '906769666764613256', '123456', '83b97cf8-4fab-4684-888a-5d786d0c8048', null, null, '2017-05-11 23:37:03', '2017-05-25 09:50:10', null, null, null), ('23', '978375303112741143', '123456', '8da42b4e-66d6-4bd0-9200-7695d163b888', null, null, '2017-05-11 23:37:03', '2017-05-25 09:50:10', null, null, null), ('24', '8188670866219087088', '123456', 'cbb9794c-9ff3-4063-b047-ce4335a4eb6e', null, null, '2017-05-11 23:37:03', '2017-05-25 09:50:10', null, null, null), ('25', '5253684546645681694', '123456', '6957ad92-1d30-46c0-b0a3-bcffd05fe195', null, null, '2017-05-11 23:37:03', '2017-05-25 09:50:10', null, null, null), ('26', '6697869631062473499', '123456', '0af15802-53c9-4e27-a16d-b1d0570194c3', null, null, '2017-05-11 23:37:03', '2017-05-25 09:50:10', null, null, null), ('27', '5352605144417615565', '123456', '2fb45f39-7334-4dd8-8598-7619b1823eca', null, null, '2017-05-11 23:37:03', '2017-05-25 09:50:10', null, null, null), ('28', '5847605475736710701', '123456', '12ed9624-87f4-4705-9d83-8ea4755dcbf4', null, null, '2017-05-11 23:37:03', '2017-05-25 09:50:10', null, null, null), ('29', '1456821586629283590', '123456', 'b679d55e-a87d-4c54-a003-8dc8b7a10c3c', null, null, '2017-05-11 23:37:03', '2017-05-25 09:50:10', null, null, null), ('30', '382989508125154872', '123456', '6dfbf227-52c5-40fd-8e5a-951a3f96d7af', null, null, '2017-05-11 23:37:03', '2017-05-25 09:50:10', null, null, null), ('31', '5014499600824359015', '123456', '8887c358-fa3d-4b27-af86-d73c77c2f560', null, null, '2017-05-11 23:37:03', '2017-05-25 09:50:10', null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色中间表';

SET FOREIGN_KEY_CHECKS = 1;
