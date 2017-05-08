/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1@root
Source Server Version : 50087
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50087
File Encoding         : 65001

Date: 2017-05-08 13:51:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'Dubbo');
INSERT INTO `user` VALUES ('2', 'Zookeeper');
INSERT INTO `user` VALUES ('3', 'Druid');
INSERT INTO `user` VALUES ('4', 'SpringBoot');
INSERT INTO `user` VALUES ('5', 'RESTful');
INSERT INTO `user` VALUES ('6', 'Hessian');
INSERT INTO `user` VALUES ('7', 'Mybatis');
INSERT INTO `user` VALUES ('8', 'Apache CXF');
INSERT INTO `user` VALUES ('9', 'WebService');
INSERT INTO `user` VALUES ('10', 'RMI');
INSERT INTO `user` VALUES ('11', 'test');
