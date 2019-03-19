/*
Navicat MySQL Data Transfer

Source Server         : MySql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : aimee_blog

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-01-28 15:12:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for action
-- ----------------------------
DROP TABLE IF EXISTS `action`;
CREATE TABLE `action` (
  `action_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`action_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of action
-- ----------------------------

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_address_id` int(11) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`address_id`),
  KEY `FK_Reference_4` (`parent_address_id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`parent_address_id`) REFERENCES `address` (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `article_id` int(11) NOT NULL AUTO_INCREMENT,
  `article_state_id` int(11) DEFAULT NULL,
  `article_public_id` int(11) DEFAULT NULL,
  `author_id` int(11) DEFAULT NULL,
  `source_id` int(11) DEFAULT NULL,
  `article_group_id` int(11) DEFAULT NULL,
  `article_title` varchar(30) DEFAULT NULL,
  `article_content` text,
  `spend_time` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `second_title` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`article_id`),
  KEY `FK_Reference_12` (`author_id`),
  KEY `FK_Reference_22` (`source_id`),
  KEY `FK_Reference_24` (`article_group_id`),
  KEY `FK_Reference_6` (`article_state_id`),
  KEY `FK_Reference_7` (`article_public_id`),
  CONSTRAINT `FK_Reference_12` FOREIGN KEY (`author_id`) REFERENCES `visitor` (`visitor_id`),
  CONSTRAINT `FK_Reference_22` FOREIGN KEY (`source_id`) REFERENCES `source` (`source_id`),
  CONSTRAINT `FK_Reference_24` FOREIGN KEY (`article_group_id`) REFERENCES `article_group` (`article_group_id`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`article_state_id`) REFERENCES `article_state` (`article_state_id`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`article_public_id`) REFERENCES `article_public` (`article_public_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', null, null, '1', null, '1', '细谈开源软件', '# 支撑起整个互联网时代的 7 款开源软件\n\n[TOCM]\n\n[TOC]\n\n开源软件现在成为整个互联网时代的支撑技术，你可能已经无法离开由开源软件构建起来的网络世界了。下面我们就来看看一些最重要的开源技术。\n\n### 为互联网而生的操作系统linux\n\nLinux是一款免费的操作系统，诞生于1991年，用户可以通过网络或其他途径免费获得，并可以任意修改其源代码。\n\n#### linux A\n\n它能运行主要的UNIX工具软件、应用程序和网络协议。它支持32位和64位硬件。Linux继承了Unix以网络为核心的设计思想，是一个性能稳 定的多用户网络操作系统。这个系统是由全世界各地的成千上万的程序员设计和实现的。其目的是建立不受任何商品化软件的版权制约的、全世界都能自由使用的 Unix兼容产品。\n\n#### Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading\n\n#### Test link heading [linux B](https://github.com/pandao/editor.md)   Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading, Test link heading, [linux B](https://github.com/pandao/editor.md)  Test link heading\n\n##### linux B-1\n\n###### linux B-1-1\n\n###### linux B-1-2\n\n##### linux B-2\n\n###### linux B-2-1\n\n###### linux B-2-2\n\n#支撑起整个互联网时代的 7 款开源软件-2\n\nLinux可以说是已经无处不在，像Android手机就是以Linux为基础开发的，世界上大多的超级计算机也都采用的Linux系统，大多数的 数据中心使用Linux作为其支撑操作系统。谷歌、百度、淘宝等都通过Linuxt提供了我们每天用的互联网服务。Linux在航空控制系统中也扮演着重 要角色。\n\n###加密互联网的安全协议OpenSSL\n\nOpenSSL是套开放源代码的软件库包，实现了SSL与TLS协议。OpenSSL可以说是一个基于密码学的安全开发包，囊括了主要的密码算法、常用的密钥和证书封装管理功能以及SSL协议，并提供了丰富的应用程序供测试或其它目的使用。\n\n也可以说OpenSSL是网络通信提供安全及数据完整性的一种安全协议，SSL可以在Internet上提供秘密性传输，能使用户/服务器应用之间的通信不被攻击者窃听。OpenSSL被网银、在线支付、电商网站、门户网站、电子邮件等重要网站广泛使用。\n\n去年OpenSSL爆出安全漏洞，因为其应用如此之广，该漏洞爆出让整个互联网都为之震颤。\n\n### 互联网的记忆——MySQL\n\nMySQL是一个开源的小型的数据库管理系统，原开发者为瑞典的MySQL AB公司，该公司于2008年被Sun公司收购。2009年，甲骨文公司（Oracle）收购Sun公司，MySQL成为Oracle旗下产品。\n\n很多信息都是存在数据库里面的，很多工程师在开发一些的小型项目时都会采用这个MySQL数据库。MySQL为C、C++、JAVA、PHP等多重 编程语言提供了API接口。而且支持windows、Mac、Linux等多种系统。这种广泛的支持使其得到更多开发者的青睐，MySQL是开发者需要掌 握的数据库之一。\n\nMysql最初为小型应用而开发，但现在的Mysql已经不是一个小型数据库了。基本上所有的互联网公司都会使用这个数据库系统，一些金融交易也会 采用Mysql作为数据库引擎。Mysql通过相应的调优既可以支撑大规模的访问，又可以保证数据安全性，已经成为威胁传统商业数据库系统的重要力量。\n\n### 万能开发工具Eclipse\n\nEclipse 是一个开放源代码的、基于Java的可扩展开发平台。Eclipse最初由OTI和IBM两家公司的IDE产品开发组创建，起始于1999年4月。目前由 IBM牵头，围绕着Eclipse项目已经发展成为了一个庞大的Eclipse联盟，有150多家软件公司参与到Eclipse项目中，其中包括 Borland、Rational Software、Red Hat及Sybase等。\n\n就其本身而言，它只是一个框架和一组服务，用于通过插件组件构建开发环境。很多Java编程软件都是在Eclipse平台开发的，还有包括 Oracle在内的许多大公司也纷纷加入了该项目，并宣称Eclipse将来能成为可进行任何语言开发的IDE集大成者，使用者只需下载各种语言的插件即 可。\n\nEclipse并不是一个直接服务于消费者的产品，它更像一个工匠手中万用工具，用Eclipse开发者可以打造出各种充满创造性的服务来满足最终用户的需求。\n\n### 互联网的门卫Apache\n\nApache HTTP Server（简称Apache）是Apache软件基金会的一个开放源码的网页服务器，可以在大多数计算机操作系统中运行，由于其多平台和安全性被广泛 使用，也是最流行的Web服务器端软件之一，市场占有率达60%左右。它快速、可靠并且可通过简单的API扩展，它可以和各种解释器配合使用，包括 PHP/Perl/Python等。\n\nApache就像一个负责的门卫，管理着服务器数据的进出。每当你在你的地址栏里输入 http://XXX.com 的时候，在遥远的远端，很有可能正是一台跑着Apache的服务器，将你需要的信息传输给浏览器。\n\n###大数据的心脏Hadoop\n\nHadoop 是一个能够对大量数据进行分布式处理的软件框架，由Apache基金会开发。用户可以在不了解分布式底层细节的情况下，开发分布式程序。Hadoop 一 直帮助解决各种问题，包括超大型数据集的排序和大文件的搜索。它还是各种搜索引擎的核心，比如 Amazon 的 A9 和用于查找酒信息 的 Able Grape 垂直搜索引擎。阿里巴巴集团在商品推荐、用户行为分析、信用计算领域也都有hadoop的应用。\n\n在“大数据”已经成为潮流的当下，Hadoop已经成为最主要的一项技术。可以毫不夸张的说，没有Hadoop，就没有大多数的大数据应用。可以说对一个不知道Hadoop的程序员而言，你已经out了。\n\n\n#### Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading\n\n#### Test link heading [linux B](https://github.com/pandao/editor.md)   Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading, Test link heading, [linux B](https://github.com/pandao/editor.md)  Test link heading\n\n##### linux B-1\n\n###### linux B-1-1\n\n###### linux B-1-2\n\n##### linux B-2\n\n###### linux B-2-1\n\n###### linux B-2-2\n\n### 互联网的“排版引擎”WebKit\n\n说是浏览器内核，其实“排版引擎”更容易理解一些。通过服务器传输给浏览器的信息只是一串乱糟糟的文本。要看到我们平时看到精美的网友，需要浏览器内核对这些文本进行解析，将枯燥的描述“画”成美丽的浏览界面。\n\nWebKit 是一个开源的浏览器引擎，与之相应的引擎有 Gecko（Mozilla Firefox 等使用的排版引擎）和 Trident（也称为 MSHTML，IE 使用的排版引擎）。根据 StatCounter 的浏览器市场份额调查，于2012年11月，Webkit 市占超过了 40%，它已经成为拥有最大市场份额的 排版引擎，超越了 Internet Explorer 所使用的Trident 及 Firefox 所使用的 Gecko 引擎，并且 WebKit 份额正在逐年增加。\n\n目前几乎所有网站和网银已经逐渐支持 WebKit 。WebKit 内核在手机上的应用也十分广泛，例如苹果的 Safari 、谷歌的 Chrome 浏览器都是基于这个框架来开发的。\n\n### 小结\n\n很多人可能尚未意识到，我们使用的电脑中运行有开源软件，手机中运行有开源软件，家里的电视也运行有开源软件，甚至小小的数码产品中也运行有开源软件，尤其是互联网服务器端软件，几乎全部是开源软件。毫不夸张地说，开源软件已经渗透到了我们日常生活的方方面面。\n\n稿源：[钛媒体](http://www.tmtpost.com/194306.html)', '5', '2018-11-17 08:49:52', '天气晴，貌似基本成型了，心情还不错');

-- ----------------------------
-- Table structure for article_group
-- ----------------------------
DROP TABLE IF EXISTS `article_group`;
CREATE TABLE `article_group` (
  `article_group_id` int(11) NOT NULL AUTO_INCREMENT,
  `visitor_id` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`article_group_id`),
  KEY `FK_Reference_23` (`visitor_id`),
  CONSTRAINT `FK_Reference_23` FOREIGN KEY (`visitor_id`) REFERENCES `visitor` (`visitor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_group
-- ----------------------------
INSERT INTO `article_group` VALUES ('1', '1', '生活', '2018-11-10 11:26:44');
INSERT INTO `article_group` VALUES ('2', '1', '技术', '2018-11-10 11:26:59');
INSERT INTO `article_group` VALUES ('3', '1', 'java', '2018-11-15 14:36:29');
INSERT INTO `article_group` VALUES ('4', '1', 'C#', '2018-11-15 14:38:26');
INSERT INTO `article_group` VALUES ('5', '1', 'Python', '2018-11-15 14:39:54');
INSERT INTO `article_group` VALUES ('6', '1', 'GO', '2018-11-15 15:07:06');
INSERT INTO `article_group` VALUES ('7', '1', 'C++', '2018-11-15 15:10:08');
INSERT INTO `article_group` VALUES ('8', '1', 'Ruby', '2018-11-15 15:12:29');

-- ----------------------------
-- Table structure for article_public
-- ----------------------------
DROP TABLE IF EXISTS `article_public`;
CREATE TABLE `article_public` (
  `article_public_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`article_public_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_public
-- ----------------------------

-- ----------------------------
-- Table structure for article_state
-- ----------------------------
DROP TABLE IF EXISTS `article_state`;
CREATE TABLE `article_state` (
  `article_state_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`article_state_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_state
-- ----------------------------

-- ----------------------------
-- Table structure for assist
-- ----------------------------
DROP TABLE IF EXISTS `assist`;
CREATE TABLE `assist` (
  `assist_id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` int(11) DEFAULT NULL,
  `discuss_id` int(11) DEFAULT NULL,
  `visitor_id` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`assist_id`),
  KEY `FK_Reference_19` (`article_id`),
  KEY `FK_Reference_20` (`discuss_id`),
  KEY `FK_Reference_21` (`visitor_id`),
  CONSTRAINT `FK_Reference_19` FOREIGN KEY (`article_id`) REFERENCES `article` (`article_id`),
  CONSTRAINT `FK_Reference_20` FOREIGN KEY (`discuss_id`) REFERENCES `discuss` (`discuss_id`),
  CONSTRAINT `FK_Reference_21` FOREIGN KEY (`visitor_id`) REFERENCES `visitor` (`visitor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of assist
-- ----------------------------

-- ----------------------------
-- Table structure for attention
-- ----------------------------
DROP TABLE IF EXISTS `attention`;
CREATE TABLE `attention` (
  `attention_id` int(11) NOT NULL AUTO_INCREMENT,
  `owner_visitor_id` int(11) DEFAULT NULL,
  `attention_visiton_id` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`attention_id`),
  KEY `FK_Reference_25` (`owner_visitor_id`),
  KEY `FK_Reference_26` (`attention_visiton_id`),
  CONSTRAINT `FK_Reference_25` FOREIGN KEY (`owner_visitor_id`) REFERENCES `visitor` (`visitor_id`),
  CONSTRAINT `FK_Reference_26` FOREIGN KEY (`attention_visiton_id`) REFERENCES `visitor` (`visitor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attention
-- ----------------------------

-- ----------------------------
-- Table structure for blog_level
-- ----------------------------
DROP TABLE IF EXISTS `blog_level`;
CREATE TABLE `blog_level` (
  `blog_level_id` int(11) NOT NULL AUTO_INCREMENT,
  `level_group_id` int(11) DEFAULT NULL,
  `name` varchar(15) DEFAULT NULL,
  `integral` char(10) DEFAULT NULL,
  PRIMARY KEY (`blog_level_id`),
  KEY `FK_Reference_31` (`level_group_id`),
  CONSTRAINT `FK_Reference_31` FOREIGN KEY (`level_group_id`) REFERENCES `level_group` (`level_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_level
-- ----------------------------

-- ----------------------------
-- Table structure for discuss
-- ----------------------------
DROP TABLE IF EXISTS `discuss`;
CREATE TABLE `discuss` (
  `discuss_id` int(11) NOT NULL AUTO_INCREMENT,
  `visitor_id` int(11) DEFAULT NULL,
  `article_id` int(11) DEFAULT NULL,
  `parent_discuss_id` int(11) DEFAULT NULL,
  `read_state_id` int(11) DEFAULT NULL,
  `content` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`discuss_id`),
  KEY `FK_Reference_15` (`visitor_id`),
  KEY `FK_Reference_16` (`article_id`),
  KEY `FK_Reference_17` (`parent_discuss_id`),
  KEY `FK_Reference_18` (`read_state_id`),
  CONSTRAINT `FK_Reference_15` FOREIGN KEY (`visitor_id`) REFERENCES `visitor` (`visitor_id`),
  CONSTRAINT `FK_Reference_16` FOREIGN KEY (`article_id`) REFERENCES `article` (`article_id`),
  CONSTRAINT `FK_Reference_17` FOREIGN KEY (`parent_discuss_id`) REFERENCES `discuss` (`discuss_id`),
  CONSTRAINT `FK_Reference_18` FOREIGN KEY (`read_state_id`) REFERENCES `read_state` (`read_state_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of discuss
-- ----------------------------

-- ----------------------------
-- Table structure for info
-- ----------------------------
DROP TABLE IF EXISTS `info`;
CREATE TABLE `info` (
  `info_id` int(11) NOT NULL AUTO_INCREMENT,
  `visitor_id` int(11) DEFAULT NULL,
  `address_id` int(11) DEFAULT NULL,
  `real_name` varchar(20) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `QQ` varchar(20) DEFAULT NULL,
  `wechar_pay` varchar(300) DEFAULT NULL,
  `wechar_friend` varchar(300) DEFAULT NULL,
  `ali_pay` varchar(300) DEFAULT NULL,
  `ali_friend` varchar(300) DEFAULT NULL,
  `telphone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`info_id`),
  KEY `FK_Reference_3` (`visitor_id`),
  KEY `FK_Reference_5` (`address_id`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`visitor_id`) REFERENCES `visitor` (`visitor_id`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of info
-- ----------------------------

-- ----------------------------
-- Table structure for integral
-- ----------------------------
DROP TABLE IF EXISTS `integral`;
CREATE TABLE `integral` (
  `integral_id` int(11) NOT NULL AUTO_INCREMENT,
  `visitor_id` int(11) DEFAULT NULL,
  `level_group_id` int(11) DEFAULT NULL,
  `value` int(11) DEFAULT NULL,
  PRIMARY KEY (`integral_id`),
  KEY `FK_Reference_29` (`visitor_id`),
  KEY `FK_Reference_30` (`level_group_id`),
  CONSTRAINT `FK_Reference_29` FOREIGN KEY (`visitor_id`) REFERENCES `visitor` (`visitor_id`),
  CONSTRAINT `FK_Reference_30` FOREIGN KEY (`level_group_id`) REFERENCES `level_group` (`level_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of integral
-- ----------------------------

-- ----------------------------
-- Table structure for level_group
-- ----------------------------
DROP TABLE IF EXISTS `level_group`;
CREATE TABLE `level_group` (
  `level_group_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`level_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of level_group
-- ----------------------------

-- ----------------------------
-- Table structure for login_info
-- ----------------------------
DROP TABLE IF EXISTS `login_info`;
CREATE TABLE `login_info` (
  `login_info_id` int(11) NOT NULL AUTO_INCREMENT,
  `visitor_id` int(11) DEFAULT NULL,
  `login_time` datetime DEFAULT NULL,
  `ip` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`login_info_id`),
  KEY `FK_Reference_2` (`visitor_id`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`visitor_id`) REFERENCES `visitor` (`visitor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=150 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login_info
-- ----------------------------
INSERT INTO `login_info` VALUES ('1', null, '2018-11-07 16:14:38', '192.168.0.26');
INSERT INTO `login_info` VALUES ('2', null, '2018-11-07 17:30:41', '192.168.0.120');
INSERT INTO `login_info` VALUES ('3', null, '2018-11-08 16:36:54', '192.168.0.26');
INSERT INTO `login_info` VALUES ('4', null, '2018-11-08 16:37:17', '192.168.0.26');
INSERT INTO `login_info` VALUES ('5', null, '2018-11-08 16:38:38', '192.168.0.26');
INSERT INTO `login_info` VALUES ('6', null, '2018-11-08 16:38:49', '192.168.0.26');
INSERT INTO `login_info` VALUES ('7', null, '2018-11-08 16:41:15', '192.168.0.26');
INSERT INTO `login_info` VALUES ('8', null, '2018-11-08 16:42:15', '192.168.0.26');
INSERT INTO `login_info` VALUES ('9', null, '2018-11-08 16:42:29', '192.168.0.26');
INSERT INTO `login_info` VALUES ('10', null, '2018-11-08 16:42:44', '192.168.0.28');
INSERT INTO `login_info` VALUES ('11', null, '2018-11-08 16:44:53', '192.168.0.26');
INSERT INTO `login_info` VALUES ('12', null, '2018-11-08 17:38:30', '192.168.0.26');
INSERT INTO `login_info` VALUES ('13', null, '2018-11-09 09:05:18', '192.168.0.26');
INSERT INTO `login_info` VALUES ('14', null, '2018-11-09 09:05:16', '192.168.0.26');
INSERT INTO `login_info` VALUES ('15', null, '2018-11-09 09:05:36', '192.168.0.26');
INSERT INTO `login_info` VALUES ('16', null, '2018-11-09 09:08:38', '192.168.0.26');
INSERT INTO `login_info` VALUES ('17', null, '2018-11-09 09:15:29', '192.168.0.26');
INSERT INTO `login_info` VALUES ('18', null, '2018-11-09 09:17:34', '192.168.0.26');
INSERT INTO `login_info` VALUES ('19', null, '2018-11-09 09:21:59', '192.168.0.26');
INSERT INTO `login_info` VALUES ('20', null, '2018-11-09 09:59:20', '192.168.0.26');
INSERT INTO `login_info` VALUES ('21', null, '2018-11-09 09:59:57', '192.168.0.26');
INSERT INTO `login_info` VALUES ('22', null, '2018-11-09 10:00:11', '192.168.0.26');
INSERT INTO `login_info` VALUES ('23', null, '2018-11-09 11:03:15', '192.168.0.26');
INSERT INTO `login_info` VALUES ('24', null, '2018-11-09 11:09:01', '192.168.0.26');
INSERT INTO `login_info` VALUES ('25', null, '2018-11-09 11:16:34', '192.168.0.26');
INSERT INTO `login_info` VALUES ('26', null, '2018-11-09 11:37:44', '192.168.0.26');
INSERT INTO `login_info` VALUES ('27', null, '2018-11-09 11:42:46', '192.168.0.26');
INSERT INTO `login_info` VALUES ('28', null, '2018-11-09 11:48:42', '192.168.0.26');
INSERT INTO `login_info` VALUES ('29', null, '2018-11-09 11:52:15', '192.168.0.26');
INSERT INTO `login_info` VALUES ('30', null, '2018-11-09 11:55:05', '192.168.0.26');
INSERT INTO `login_info` VALUES ('31', null, '2018-11-09 12:00:14', '192.168.0.26');
INSERT INTO `login_info` VALUES ('32', null, '2018-11-09 12:00:48', '192.168.0.26');
INSERT INTO `login_info` VALUES ('33', null, '2018-11-09 13:01:29', '192.168.0.26');
INSERT INTO `login_info` VALUES ('34', null, '2018-11-09 13:01:31', '192.168.0.26');
INSERT INTO `login_info` VALUES ('35', null, '2018-11-09 13:03:24', '192.168.0.26');
INSERT INTO `login_info` VALUES ('36', null, '2018-11-09 13:03:28', '192.168.0.26');
INSERT INTO `login_info` VALUES ('37', null, '2018-11-09 13:04:23', '192.168.0.26');
INSERT INTO `login_info` VALUES ('38', null, '2018-11-09 13:19:35', '192.168.0.26');
INSERT INTO `login_info` VALUES ('39', null, '2018-11-09 13:36:54', '192.168.0.26');
INSERT INTO `login_info` VALUES ('40', null, '2018-11-09 15:17:29', '192.168.0.26');
INSERT INTO `login_info` VALUES ('41', null, '2018-11-09 15:19:10', '192.168.0.26');
INSERT INTO `login_info` VALUES ('42', null, '2018-11-09 15:24:49', '192.168.0.26');
INSERT INTO `login_info` VALUES ('43', null, '2018-11-09 15:33:34', '192.168.0.26');
INSERT INTO `login_info` VALUES ('44', null, '2018-11-09 16:20:41', '192.168.0.26');
INSERT INTO `login_info` VALUES ('45', null, '2018-11-09 16:31:34', '192.168.0.26');
INSERT INTO `login_info` VALUES ('46', null, '2018-11-09 16:49:58', '192.168.0.26');
INSERT INTO `login_info` VALUES ('47', null, '2018-11-09 17:26:25', '192.168.0.26');
INSERT INTO `login_info` VALUES ('48', null, '2018-11-10 08:45:53', '192.168.0.26');
INSERT INTO `login_info` VALUES ('49', null, '2018-11-10 08:53:21', '192.168.0.26');
INSERT INTO `login_info` VALUES ('50', null, '2018-11-10 09:12:31', '192.168.0.26');
INSERT INTO `login_info` VALUES ('51', null, '2018-11-10 11:06:53', '192.168.0.26');
INSERT INTO `login_info` VALUES ('52', null, '2018-11-10 11:18:27', '192.168.0.26');
INSERT INTO `login_info` VALUES ('53', null, '2018-11-10 14:41:54', '192.168.0.26');
INSERT INTO `login_info` VALUES ('54', null, '2018-11-10 15:02:34', '192.168.0.26');
INSERT INTO `login_info` VALUES ('55', null, '2018-11-10 15:03:26', '192.168.0.26');
INSERT INTO `login_info` VALUES ('56', null, '2018-11-10 15:08:49', '192.168.0.26');
INSERT INTO `login_info` VALUES ('57', null, '2018-11-10 15:11:50', '192.168.0.26');
INSERT INTO `login_info` VALUES ('58', null, '2018-11-10 15:19:59', '192.168.0.26');
INSERT INTO `login_info` VALUES ('59', null, '2018-11-10 15:20:38', '192.168.0.26');
INSERT INTO `login_info` VALUES ('60', null, '2018-11-10 16:57:58', '192.168.0.26');
INSERT INTO `login_info` VALUES ('61', '1', '2018-11-12 10:07:57', '192.168.0.26');
INSERT INTO `login_info` VALUES ('62', '1', '2018-11-12 10:08:35', '192.168.0.26');
INSERT INTO `login_info` VALUES ('63', '1', '2018-11-12 16:50:52', '192.168.0.26');
INSERT INTO `login_info` VALUES ('64', null, '2018-11-14 09:37:41', '192.168.0.26');
INSERT INTO `login_info` VALUES ('65', null, '2018-11-14 10:27:38', '192.168.0.26');
INSERT INTO `login_info` VALUES ('66', '1', '2018-11-14 10:27:41', '192.168.0.26');
INSERT INTO `login_info` VALUES ('67', null, '2018-11-14 10:29:50', '192.168.0.26');
INSERT INTO `login_info` VALUES ('68', '1', '2018-11-14 10:29:51', '192.168.0.26');
INSERT INTO `login_info` VALUES ('69', null, '2018-11-14 10:30:12', '192.168.0.26');
INSERT INTO `login_info` VALUES ('70', '1', '2018-11-14 10:30:13', '192.168.0.26');
INSERT INTO `login_info` VALUES ('71', null, '2018-11-14 10:31:26', '192.168.0.26');
INSERT INTO `login_info` VALUES ('72', '1', '2018-11-14 10:31:26', '192.168.0.26');
INSERT INTO `login_info` VALUES ('73', null, '2018-11-14 10:38:24', '192.168.0.26');
INSERT INTO `login_info` VALUES ('74', '1', '2018-11-14 10:38:25', '192.168.0.26');
INSERT INTO `login_info` VALUES ('75', null, '2018-11-14 10:41:46', '192.168.0.26');
INSERT INTO `login_info` VALUES ('76', '1', '2018-11-14 10:41:47', '192.168.0.26');
INSERT INTO `login_info` VALUES ('77', null, '2018-11-14 10:49:02', '192.168.0.26');
INSERT INTO `login_info` VALUES ('78', null, '2018-11-14 10:49:06', '192.168.0.26');
INSERT INTO `login_info` VALUES ('79', null, '2018-11-14 10:51:24', '192.168.0.26');
INSERT INTO `login_info` VALUES ('80', null, '2018-11-14 10:53:25', '192.168.0.26');
INSERT INTO `login_info` VALUES ('81', null, '2018-11-14 10:53:29', '192.168.0.26');
INSERT INTO `login_info` VALUES ('82', null, '2018-11-14 10:54:27', '192.168.0.26');
INSERT INTO `login_info` VALUES ('83', '1', '2018-11-14 10:54:27', '192.168.0.26');
INSERT INTO `login_info` VALUES ('84', null, '2018-11-14 10:54:51', '192.168.0.26');
INSERT INTO `login_info` VALUES ('85', '1', '2018-11-14 10:54:51', '192.168.0.26');
INSERT INTO `login_info` VALUES ('86', null, '2018-11-14 10:55:10', '192.168.0.26');
INSERT INTO `login_info` VALUES ('87', null, '2018-11-14 10:55:25', '192.168.0.26');
INSERT INTO `login_info` VALUES ('88', '1', '2018-11-14 10:55:25', '192.168.0.26');
INSERT INTO `login_info` VALUES ('89', null, '2018-11-14 10:58:21', '192.168.0.26');
INSERT INTO `login_info` VALUES ('90', null, '2018-11-14 11:43:41', '192.168.0.26');
INSERT INTO `login_info` VALUES ('91', null, '2018-11-14 13:16:27', '192.168.0.26');
INSERT INTO `login_info` VALUES ('92', '1', '2018-11-14 13:36:17', '192.168.0.26');
INSERT INTO `login_info` VALUES ('93', '1', '2018-11-15 08:47:44', '192.168.0.26');
INSERT INTO `login_info` VALUES ('94', '1', '2018-11-15 08:49:26', '192.168.0.26');
INSERT INTO `login_info` VALUES ('95', '1', '2018-11-15 09:20:55', '192.168.0.26');
INSERT INTO `login_info` VALUES ('96', null, '2018-11-15 09:21:05', '192.168.0.26');
INSERT INTO `login_info` VALUES ('97', null, '2018-11-15 10:39:02', '192.168.0.26');
INSERT INTO `login_info` VALUES ('98', '1', '2018-11-15 10:43:56', '192.168.0.26');
INSERT INTO `login_info` VALUES ('99', '1', '2018-11-15 10:45:54', '192.168.0.26');
INSERT INTO `login_info` VALUES ('100', '1', '2018-11-15 13:40:28', '192.168.0.26');
INSERT INTO `login_info` VALUES ('101', null, '2018-11-15 14:25:53', '192.168.0.26');
INSERT INTO `login_info` VALUES ('102', '1', '2018-11-15 15:06:27', '192.168.0.26');
INSERT INTO `login_info` VALUES ('103', '1', '2018-11-15 15:21:35', '192.168.0.26');
INSERT INTO `login_info` VALUES ('104', null, '2018-11-15 15:28:40', '192.168.0.26');
INSERT INTO `login_info` VALUES ('105', null, '2018-11-15 15:28:47', '192.168.0.26');
INSERT INTO `login_info` VALUES ('106', '1', '2018-11-15 17:32:46', '192.168.0.26');
INSERT INTO `login_info` VALUES ('107', '1', '2018-11-16 08:31:13', '192.168.0.26');
INSERT INTO `login_info` VALUES ('108', null, '2018-11-16 08:38:31', '192.168.0.26');
INSERT INTO `login_info` VALUES ('109', null, '2018-11-16 08:46:16', '192.168.0.26');
INSERT INTO `login_info` VALUES ('110', '1', '2018-11-16 09:04:40', '192.168.0.26');
INSERT INTO `login_info` VALUES ('111', null, '2018-11-16 13:17:21', '192.168.0.26');
INSERT INTO `login_info` VALUES ('112', '1', '2018-11-16 13:52:35', '192.168.0.26');
INSERT INTO `login_info` VALUES ('113', null, '2018-11-16 13:54:16', '192.168.0.26');
INSERT INTO `login_info` VALUES ('114', null, '2018-11-16 13:54:22', '192.168.0.26');
INSERT INTO `login_info` VALUES ('115', null, '2018-11-16 13:57:14', '192.168.0.26');
INSERT INTO `login_info` VALUES ('116', null, '2018-11-16 13:57:22', '192.168.0.26');
INSERT INTO `login_info` VALUES ('117', null, '2018-11-16 14:24:36', '192.168.0.26');
INSERT INTO `login_info` VALUES ('118', null, '2018-11-16 14:24:41', '192.168.0.26');
INSERT INTO `login_info` VALUES ('119', '1', '2018-11-16 15:25:47', '192.168.0.26');
INSERT INTO `login_info` VALUES ('120', '1', '2018-11-16 16:13:38', '192.168.0.26');
INSERT INTO `login_info` VALUES ('121', '1', '2018-11-16 16:16:28', '192.168.0.26');
INSERT INTO `login_info` VALUES ('122', '1', '2018-11-16 16:18:36', '192.168.0.26');
INSERT INTO `login_info` VALUES ('123', null, '2018-11-16 16:18:41', '192.168.0.26');
INSERT INTO `login_info` VALUES ('124', null, '2018-11-16 17:12:30', '192.168.0.26');
INSERT INTO `login_info` VALUES ('125', null, '2018-11-16 17:13:44', '192.168.0.26');
INSERT INTO `login_info` VALUES ('126', null, '2018-11-17 08:47:55', '192.168.0.26');
INSERT INTO `login_info` VALUES ('127', '1', '2018-11-17 13:34:44', '192.168.0.26');
INSERT INTO `login_info` VALUES ('128', '1', '2018-11-17 13:35:21', '192.168.0.26');
INSERT INTO `login_info` VALUES ('129', '1', '2018-11-17 13:35:27', '192.168.0.26');
INSERT INTO `login_info` VALUES ('130', '1', '2018-11-17 13:35:46', '192.168.0.26');
INSERT INTO `login_info` VALUES ('131', null, '2018-11-17 14:00:18', '192.168.0.26');
INSERT INTO `login_info` VALUES ('132', '1', '2018-11-17 14:01:43', '192.168.0.26');
INSERT INTO `login_info` VALUES ('133', null, '2018-11-17 14:04:42', '192.168.0.26');
INSERT INTO `login_info` VALUES ('134', '1', '2018-11-17 14:04:48', '192.168.0.26');
INSERT INTO `login_info` VALUES ('135', '1', '2018-11-17 14:05:01', '192.168.0.26');
INSERT INTO `login_info` VALUES ('136', '1', '2018-11-17 14:05:09', '192.168.0.26');
INSERT INTO `login_info` VALUES ('137', null, '2018-11-17 14:05:47', '192.168.0.26');
INSERT INTO `login_info` VALUES ('138', '1', '2018-11-17 14:10:32', '192.168.0.26');
INSERT INTO `login_info` VALUES ('139', '1', '2018-11-17 14:10:49', '192.168.0.26');
INSERT INTO `login_info` VALUES ('140', null, '2018-11-17 14:26:18', '192.168.0.26');
INSERT INTO `login_info` VALUES ('141', null, '2018-11-17 14:39:57', '192.168.0.26');
INSERT INTO `login_info` VALUES ('142', null, '2018-11-17 14:45:05', '192.168.0.26');
INSERT INTO `login_info` VALUES ('143', '1', '2018-11-17 15:32:36', '192.168.0.26');
INSERT INTO `login_info` VALUES ('144', '2', '2018-11-17 15:36:17', '192.168.0.26');
INSERT INTO `login_info` VALUES ('145', '2', '2018-11-17 15:38:45', '192.168.0.26');
INSERT INTO `login_info` VALUES ('146', null, '2018-11-21 09:14:20', '192.168.0.26');
INSERT INTO `login_info` VALUES ('147', '2', '2018-11-21 09:14:25', '192.168.0.26');
INSERT INTO `login_info` VALUES ('148', null, '2019-01-28 15:09:53', '192.168.0.26');
INSERT INTO `login_info` VALUES ('149', '1', '2019-01-28 15:09:55', '192.168.0.26');

-- ----------------------------
-- Table structure for read_log
-- ----------------------------
DROP TABLE IF EXISTS `read_log`;
CREATE TABLE `read_log` (
  `read_log_id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` int(11) DEFAULT NULL,
  `visitor_id` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`read_log_id`),
  KEY `FK_Reference_27` (`article_id`),
  KEY `FK_Reference_28` (`visitor_id`),
  CONSTRAINT `FK_Reference_27` FOREIGN KEY (`article_id`) REFERENCES `article` (`article_id`),
  CONSTRAINT `FK_Reference_28` FOREIGN KEY (`visitor_id`) REFERENCES `visitor` (`visitor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of read_log
-- ----------------------------
INSERT INTO `read_log` VALUES ('54', '1', null, '2018-11-17 08:49:57');
INSERT INTO `read_log` VALUES ('55', '1', null, '2018-11-17 13:34:58');
INSERT INTO `read_log` VALUES ('56', '1', null, '2018-11-17 13:36:03');
INSERT INTO `read_log` VALUES ('57', '1', null, '2018-11-17 14:46:02');
INSERT INTO `read_log` VALUES ('58', '1', null, '2018-11-17 14:46:13');
INSERT INTO `read_log` VALUES ('59', '1', null, '2018-11-17 14:46:15');
INSERT INTO `read_log` VALUES ('60', '1', null, '2019-01-28 15:10:07');

-- ----------------------------
-- Table structure for read_state
-- ----------------------------
DROP TABLE IF EXISTS `read_state`;
CREATE TABLE `read_state` (
  `read_state_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`read_state_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of read_state
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for role_action
-- ----------------------------
DROP TABLE IF EXISTS `role_action`;
CREATE TABLE `role_action` (
  `role_action_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `action_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`role_action_id`),
  KEY `FK_Reference_10` (`role_id`),
  KEY `FK_Reference_11` (`action_id`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`action_id`) REFERENCES `action` (`action_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_action
-- ----------------------------

-- ----------------------------
-- Table structure for source
-- ----------------------------
DROP TABLE IF EXISTS `source`;
CREATE TABLE `source` (
  `source_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`source_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of source
-- ----------------------------

-- ----------------------------
-- Table structure for visitor
-- ----------------------------
DROP TABLE IF EXISTS `visitor`;
CREATE TABLE `visitor` (
  `visitor_id` int(11) NOT NULL AUTO_INCREMENT,
  `visitor_state_id` int(11) DEFAULT NULL,
  `login_name` varchar(20) DEFAULT NULL,
  `salt` varchar(100) DEFAULT NULL,
  `login_password` varchar(100) DEFAULT NULL,
  `nick_name` varchar(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `manifesto` varchar(300) DEFAULT NULL,
  `head_url` varchar(300) DEFAULT NULL,
  `introduction` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`visitor_id`),
  KEY `FK_Reference_1` (`visitor_state_id`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`visitor_state_id`) REFERENCES `visitor_state` (`visitor_state_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of visitor
-- ----------------------------
INSERT INTO `visitor` VALUES ('1', null, 'sanbowla', null, 'gddTnP8do8nduYEjp7P8EreFMuerlPzW+sevayr5kL0Mba0K881Jmg==', 'Aimee Chang', '2018-11-10 11:12:46', '冉萌', '../images/avatar.jpg', '哒（dā）兜（dǒu）~');
INSERT INTO `visitor` VALUES ('2', null, 'pythoner', null, 'gddTnP8do8nduYEjp7P8EreFMuerlPzW+sevayr5kL0Mba0K881Jmg==', 'Pythoner', '2018-11-17 15:34:23', null, '../images/default.jpg', null);

-- ----------------------------
-- Table structure for visitor_role
-- ----------------------------
DROP TABLE IF EXISTS `visitor_role`;
CREATE TABLE `visitor_role` (
  `visitor_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `visitor_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`visitor_role_id`),
  KEY `FK_Reference_8` (`visitor_id`),
  KEY `FK_Reference_9` (`role_id`),
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`visitor_id`) REFERENCES `visitor` (`visitor_id`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of visitor_role
-- ----------------------------

-- ----------------------------
-- Table structure for visitor_state
-- ----------------------------
DROP TABLE IF EXISTS `visitor_state`;
CREATE TABLE `visitor_state` (
  `visitor_state_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`visitor_state_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of visitor_state
-- ----------------------------

drop table if exists photo_album;


drop table if exists photo;


drop table if exists photo_album_read_log;


drop table if exists photo_album_discuss;


drop table if exists photo_discuss;

/*==============================================================*/
/* Table: photo_album                                           */
/*==============================================================*/
create table photo_album
(
   photo_album_id       int not null auto_increment,
   owner_id             int,
   photo_album_name     varchar(20),
	 photo_album_abstract varchar(100),
   create_date          datetime,
   primary key (photo_album_id)
);

/*==============================================================*/
/* Table: photo                                                 */
/*==============================================================*/
create table photo
(
   photo_id             int not null auto_increment,
   photo_album_id       int,
	 photo_name						varchar(20),
	 photo_abstract				varchar(100),
   photo_url            varchar(200),
   create_date          datetime,
   primary key (photo_id)
);

/*==============================================================*/
/* Table: photo_album_read_log                                  */
/*==============================================================*/
create table photo_album_read_log
(
   photo_album_read_log_id int not null auto_increment,
   reader_id            int,
   photo_album_id       int,
   create_date          datetime,
   ip                   varchar(20),
   primary key (photo_album_read_log_id)
);

/*==============================================================*/
/* Table: photo_album_discuss                                   */
/*==============================================================*/
create table photo_album_discuss
(
   photo_album_disicuss_id int not null auto_increment,
   photo_album_id       int,
   discussant_id        int,
   photo_album_discuss_content varchar(200),
   create_date          datetime,
   ip                   varchar(20),
   primary key (photo_album_disicuss_id)
);

/*==============================================================*/
/* Table: photo_discuss                                         */
/*==============================================================*/
create table photo_discuss
(
   photo_disicuss_id    int not null auto_increment,
   photo_id             int,
   discussant_id        int,
   photo_discuss_content varchar(200),
   create_date          datetime,
   ip                   varchar(20),
   primary key (photo_disicuss_id)
);


alter table photo_album_discuss add constraint FK_Reference_37 foreign key (photo_album_id)
      references photo_album (photo_album_id);

alter table photo_album_discuss add constraint FK_Reference_38 foreign key (discussant_id)
      references visitor (visitor_id);

alter table photo_album_read_log add constraint FK_Reference_33 foreign key (photo_album_id)
      references photo_album (photo_album_id);

alter table photo_album_read_log add constraint FK_Reference_34 foreign key (reader_id)
      references visitor (visitor_id);

alter table photo add constraint FK_Reference_32 foreign key (photo_album_id)
      references photo_album (photo_album_id);

alter table photo_album add constraint FK_Reference_39 foreign key (owner_id)
      references visitor (visitor_id);
alter table photo_discuss add constraint FK_Reference_35 foreign key (discussant_id)
      references visitor (visitor_id);

alter table photo_discuss add constraint FK_Reference_36 foreign key (photo_id)
      references photo (photo_id);


alter table photo_album add constraint FK_Reference_40 foreign key (photo_id)
      references photo (photo_id);