/*
Navicat MySQL Data Transfer

Source Server         : 192.168.3.190
Source Server Version : 50721
Source Host           : 127.0.0.1:3306
Source Database       : gtl_oa

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-06-11 11:58:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '名字',
  `resourceType` int(10) DEFAULT NULL COMMENT '类型菜单还是按钮，0属于菜单，1属于按钮',
  `url` varchar(255) DEFAULT NULL COMMENT '访问地址',
  `permission` varchar(255) DEFAULT NULL COMMENT '权限标识',
  `pid` int(10) DEFAULT NULL COMMENT '上级编号',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `state` varchar(255) DEFAULT NULL COMMENT '状态 0是关闭1是开启',
  `belong` int(10) DEFAULT NULL COMMENT '0true,1false是否是一级菜单',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', '系统管理', '0', null, null, '0', 'fa-desktop', '1', '1', null);
INSERT INTO `sys_permission` VALUES ('2', '用户添加', '0', '../menu/index', 'index', '1', 'fa-group', '1', '0', null);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL COMMENT '角色标识程序中判断使用,如"admin"',
  `description` varchar(255) DEFAULT NULL COMMENT '角色名字,UI界面显示使用',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', '管理员', '拥有至高无上的权利');
INSERT INTO `sys_role` VALUES ('2', 'Vip', 'Vip会员', '只有充钱你才会变得更强');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `role_id` int(10) unsigned DEFAULT NULL COMMENT '角色id',
  `permission_id` int(10) unsigned DEFAULT NULL COMMENT '权限id',
  KEY `role_id` (`role_id`) USING BTREE,
  KEY `permission` (`permission_id`) USING BTREE,
  CONSTRAINT `sys_role_permission_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sys_role_permission_ibfk_2` FOREIGN KEY (`permission_id`) REFERENCES `sys_permission` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '1');
INSERT INTO `sys_role_permission` VALUES ('1', '2');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT '' COMMENT '用户名',
  `password` varchar(255) DEFAULT '' COMMENT '密码',
  `account` varchar(255) DEFAULT '' COMMENT '登录账号:这里采用手机号或者是用户名登录',
  `age` int(10) DEFAULT NULL COMMENT '年龄',
  `sex` int(10) DEFAULT NULL COMMENT '性别:0为男，1为女',
  `state` int(10) DEFAULT NULL COMMENT '用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `datetime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '登录时间',
  `rolelist` varchar(255) DEFAULT NULL COMMENT '用户对应的角色',
  `perminsStrlist` varchar(255) DEFAULT NULL COMMENT '备用',
  `note1` varchar(255) DEFAULT NULL COMMENT '备用',
  `note2` varchar(255) DEFAULT NULL COMMENT '备用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `account` (`account`) USING BTREE,
  KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('11', '赵德柱', '202cb962ac59075b964b07152d234b70', '12345678910', null, null, null, null, '2018-05-30 10:22:37', null, null, null, null);
INSERT INTO `sys_user` VALUES ('14', '叶良辰', '202cb962ac59075b964b07152d234b70', '12346597810', null, null, null, null, '2018-05-30 10:22:58', null, null, null, null);
INSERT INTO `sys_user` VALUES ('15', '王德柱', '202cb962ac59075b964b07152d234b70', '12345672910', null, null, null, null, '2018-05-30 10:22:44', null, null, null, null);
INSERT INTO `sys_user` VALUES ('16', '李德柱', '202cb962ac59075b964b07152d234b70', '11111111111', null, null, null, null, '2018-05-30 10:22:50', null, null, null, null);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` int(10) unsigned NOT NULL COMMENT '用户id',
  `role_id` int(10) unsigned NOT NULL COMMENT '角色id',
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `role_id` (`role_id`) USING BTREE,
  CONSTRAINT `sys_user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sys_user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关系对应表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('11', '1');
INSERT INTO `sys_user_role` VALUES ('14', '2');
