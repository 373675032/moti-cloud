/*
Navicat MySQL Data Transfer

Source Server         : 服务器
Source Server Version : 50644
Source Host           : 47.106.183.193:3306
Source Database       : moti-cloud

Target Server Type    : MYSQL
Target Server Version : 50644
File Encoding         : 65001

Date: 2020-02-29 09:46:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `file_folder`
-- ----------------------------
DROP TABLE IF EXISTS `file_folder`;
CREATE TABLE `file_folder` (
  `file_folder_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文件夹ID',
  `file_folder_name` varchar(255) DEFAULT NULL COMMENT '文件夹名称',
  `parent_folder_id` int(11) DEFAULT '0' COMMENT '父文件夹ID',
  `file_store_id` int(11) DEFAULT NULL COMMENT '所属文件仓库ID',
  `time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`file_folder_id`)
) ENGINE=InnoDB AUTO_INCREMENT=148 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `file_store`
-- ----------------------------
DROP TABLE IF EXISTS `file_store`;
CREATE TABLE `file_store` (
  `file_store_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文件仓库ID',
  `user_id` int(11) DEFAULT NULL COMMENT '主人ID',
  `current_size` int(11) DEFAULT '0' COMMENT '当前容量（单位KB）',
  `max_size` int(11) DEFAULT '1048576' COMMENT '最大容量（单位KB）',
  PRIMARY KEY (`file_store_id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `my_file`
-- ----------------------------
DROP TABLE IF EXISTS `my_file`;
CREATE TABLE `my_file` (
  `my_file_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文件ID',
  `my_file_name` varchar(255) DEFAULT NULL COMMENT '文件名',
  `file_store_id` int(11) DEFAULT NULL COMMENT '文件仓库ID',
  `my_file_path` varchar(255) DEFAULT '/' COMMENT '文件存储路径',
  `download_time` int(11) DEFAULT '0' COMMENT '下载次数',
  `upload_time` datetime DEFAULT NULL COMMENT '上传时间',
  `parent_folder_id` int(11) DEFAULT NULL COMMENT '父文件夹ID',
  `size` int(11) DEFAULT NULL COMMENT '文件大小',
  `type` int(11) DEFAULT NULL COMMENT '文件类型',
  `postfix` varchar(255) DEFAULT NULL COMMENT '文件后缀',
  PRIMARY KEY (`my_file_id`)
) ENGINE=InnoDB AUTO_INCREMENT=204 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `open_id` varchar(255) DEFAULT NULL COMMENT '用户的openid',
  `file_store_id` int(11) DEFAULT NULL COMMENT '文件仓库ID',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `register_time` datetime DEFAULT NULL COMMENT '注册时间',
  `image_path` varchar(255) DEFAULT '' COMMENT '头像地址',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8;
