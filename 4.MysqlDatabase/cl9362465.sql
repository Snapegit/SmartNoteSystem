-- MySQL dump 10.13  Distrib 5.7.31, for Linux (x86_64)
--
-- Host: localhost    Database: cl9362465
-- ------------------------------------------------------
-- Server version	5.7.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `cl9362465`
--

/*!40000 DROP DATABASE IF EXISTS `cl9362465`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `cl9362465` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `cl9362465`;

--
-- Table structure for table `bijibiaoqian`
--

DROP TABLE IF EXISTS `bijibiaoqian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bijibiaoqian` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `biaoqian` varchar(200) DEFAULT NULL COMMENT '标签',
  PRIMARY KEY (`id`),
  UNIQUE KEY `biaoqian` (`biaoqian`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 COMMENT='笔记标签';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bijibiaoqian`
--

LOCK TABLES `bijibiaoqian` WRITE;
/*!40000 ALTER TABLE `bijibiaoqian` DISABLE KEYS */;
INSERT INTO `bijibiaoqian` VALUES (51,'2024-01-21 14:42:50','标签1'),(52,'2024-01-21 14:42:50','标签2'),(53,'2024-01-21 14:42:50','标签3'),(54,'2024-01-21 14:42:50','标签4'),(55,'2024-01-21 14:42:50','标签5'),(56,'2024-01-21 14:42:50','标签6');
/*!40000 ALTER TABLE `bijibiaoqian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bijifenlei`
--

DROP TABLE IF EXISTS `bijifenlei`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bijifenlei` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `bijifenlei` varchar(200) NOT NULL COMMENT '笔记分类',
  PRIMARY KEY (`id`),
  UNIQUE KEY `bijifenlei` (`bijifenlei`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COMMENT='笔记分类';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bijifenlei`
--

LOCK TABLES `bijifenlei` WRITE;
/*!40000 ALTER TABLE `bijifenlei` DISABLE KEYS */;
INSERT INTO `bijifenlei` VALUES (41,'2024-01-21 14:42:50','笔记分类1'),(42,'2024-01-21 14:42:50','笔记分类2'),(43,'2024-01-21 14:42:50','笔记分类3'),(44,'2024-01-21 14:42:50','笔记分类4'),(45,'2024-01-21 14:42:50','笔记分类5'),(46,'2024-01-21 14:42:50','笔记分类6');
/*!40000 ALTER TABLE `bijifenlei` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bijixinxi`
--

DROP TABLE IF EXISTS `bijixinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bijixinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `bijimingcheng` varchar(200) DEFAULT NULL COMMENT '笔记名称',
  `bijifenlei` varchar(200) DEFAULT NULL COMMENT '笔记分类',
  `bijibiaoqian` varchar(200) DEFAULT NULL COMMENT '笔记标签',
  `fengmian` longtext COMMENT '封面',
  `jianshu` longtext COMMENT '简述',
  `yinpin` longtext COMMENT '音频',
  `bijineirong` longtext COMMENT '笔记内容',
  `fabushijian` datetime DEFAULT NULL COMMENT '发布时间',
  `yonghuzhanghao` varchar(200) DEFAULT NULL COMMENT '用户账号',
  `yonghuxingming` varchar(200) DEFAULT NULL COMMENT '用户姓名',
  `storeupnum` int(11) DEFAULT NULL COMMENT '收藏数量',
  `clicktime` datetime DEFAULT NULL COMMENT '最近点击时间',
  `clicknum` int(11) DEFAULT NULL COMMENT '点击次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1705848844819 DEFAULT CHARSET=utf8 COMMENT='笔记信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bijixinxi`
--

LOCK TABLES `bijixinxi` WRITE;
/*!40000 ALTER TABLE `bijixinxi` DISABLE KEYS */;
INSERT INTO `bijixinxi` VALUES (61,'2024-01-21 14:42:50','笔记名称1','笔记分类1','笔记标签1','file/bijixinxiFengmian1.jpg,file/bijixinxiFengmian2.jpg,file/bijixinxiFengmian3.jpg','简述1','','笔记内容1','2024-01-21 22:42:50','用户账号1','用户姓名1',1,'2024-01-21 22:42:50',1),(62,'2024-01-21 14:42:50','笔记名称2','笔记分类2','笔记标签2','file/bijixinxiFengmian2.jpg,file/bijixinxiFengmian3.jpg,file/bijixinxiFengmian4.jpg','简述2','','笔记内容2','2024-01-21 22:42:50','用户账号2','用户姓名2',2,'2024-01-21 22:42:50',2),(63,'2024-01-21 14:42:50','笔记名称3','笔记分类3','笔记标签3','file/bijixinxiFengmian3.jpg,file/bijixinxiFengmian4.jpg,file/bijixinxiFengmian5.jpg','简述3','','笔记内容3','2024-01-21 22:42:50','用户账号3','用户姓名3',3,'2024-01-21 22:42:50',3),(64,'2024-01-21 14:42:50','笔记名称4','笔记分类4','笔记标签4','file/bijixinxiFengmian4.jpg,file/bijixinxiFengmian5.jpg,file/bijixinxiFengmian6.jpg','简述4','','笔记内容4','2024-01-21 22:42:50','用户账号4','用户姓名4',4,'2024-01-21 22:42:50',4),(65,'2024-01-21 14:42:50','笔记名称5','笔记分类5','笔记标签5','file/bijixinxiFengmian5.jpg,file/bijixinxiFengmian6.jpg,file/bijixinxiFengmian7.jpg','简述5','','笔记内容5','2024-01-21 22:42:50','用户账号5','用户姓名5',5,'2024-01-21 22:42:50',5),(66,'2024-01-21 14:42:50','笔记名称6','笔记分类6','笔记标签6','file/bijixinxiFengmian6.jpg,file/bijixinxiFengmian7.jpg,file/bijixinxiFengmian8.jpg','简述6','','笔记内容6','2024-01-21 22:42:50','用户账号6','用户姓名6',6,'2024-01-21 22:42:50',6),(1705848844818,'2024-01-21 14:54:04','名称','笔记分类1','标签2','file/1705848829379.jpg','简述','file/1705848837804.mp3','<p>详情</p>','2024-01-21 22:53:28','用户账号1','用户姓名1',0,NULL,0);
/*!40000 ALTER TABLE `bijixinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='配置文件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` VALUES (1,'swiper1','file/swiperPicture1.jpg'),(2,'swiper2','file/swiperPicture2.jpg'),(3,'swiper3','file/swiperPicture3.jpg');
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discussbijixinxi`
--

DROP TABLE IF EXISTS `discussbijixinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discussbijixinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `avatarurl` longtext COMMENT '头像',
  `nickname` varchar(200) DEFAULT NULL COMMENT '用户名',
  `content` longtext NOT NULL COMMENT '评论内容',
  `reply` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='笔记信息评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discussbijixinxi`
--

LOCK TABLES `discussbijixinxi` WRITE;
/*!40000 ALTER TABLE `discussbijixinxi` DISABLE KEYS */;
/*!40000 ALTER TABLE `discussbijixinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `menujson` longtext COMMENT '菜单',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='菜单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'2024-01-21 14:42:50','[{\"backMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-vip\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"笔记标签\",\"menuJump\":\"列表\",\"tableName\":\"bijibiaoqian\"}],\"fontClass\":\"icon-common43\",\"menu\":\"笔记标签管理\",\"unicode\":\"&#xef27;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-camera\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"轮播图\",\"menuJump\":\"列表\",\"tableName\":\"config\"}],\"fontClass\":\"icon-common37\",\"menu\":\"轮播图管理\",\"unicode\":\"&#xeea4;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-qrcode\",\"buttons\":[\"查看\",\"删除\",\"修改\"],\"menu\":\"笔记信息\",\"menuJump\":\"列表\",\"tableName\":\"bijixinxi\"}],\"fontClass\":\"icon-common18\",\"menu\":\"笔记信息管理\",\"unicode\":\"&#xedff;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-goods\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"用户\",\"menuJump\":\"列表\",\"tableName\":\"yonghu\"}],\"fontClass\":\"icon-user7\",\"menu\":\"用户管理\",\"unicode\":\"&#xef9d;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-newshot\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"笔记分类\",\"menuJump\":\"列表\",\"tableName\":\"bijifenlei\"}],\"fontClass\":\"icon-common14\",\"menu\":\"笔记分类管理\",\"unicode\":\"&#xedfb;\"}],\"frontMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-camera\",\"buttons\":[\"查看\"],\"menu\":\"笔记信息\",\"menuJump\":\"列表\",\"tableName\":\"bijixinxi\"}],\"menu\":\"笔记信息管理\"}],\"hasBackLogin\":\"是\",\"hasBackRegister\":\"否\",\"hasFrontLogin\":\"否\",\"hasFrontRegister\":\"否\",\"roleName\":\"管理员\",\"tableName\":\"users\"},{\"backMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-copy\",\"buttons\":[\"查看\"],\"menu\":\"我的收藏\",\"menuJump\":\"1\",\"tableName\":\"storeup\"}],\"fontClass\":\"icon-common43\",\"menu\":\"我的收藏管理\",\"unicode\":\"&#xef27;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-qrcode\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"查看评论\"],\"menu\":\"笔记信息\",\"menuJump\":\"列表\",\"tableName\":\"bijixinxi\"}],\"fontClass\":\"icon-common18\",\"menu\":\"笔记信息管理\",\"unicode\":\"&#xedff;\"}],\"frontMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-camera\",\"buttons\":[\"查看\"],\"menu\":\"笔记信息\",\"menuJump\":\"列表\",\"tableName\":\"bijixinxi\"}],\"menu\":\"笔记信息管理\"}],\"hasBackLogin\":\"否\",\"hasBackRegister\":\"否\",\"hasFrontLogin\":\"是\",\"hasFrontRegister\":\"是\",\"roleName\":\"用户\",\"tableName\":\"yonghu\"}]');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storeup`
--

DROP TABLE IF EXISTS `storeup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storeup` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) DEFAULT NULL COMMENT 'refid',
  `tablename` varchar(200) DEFAULT NULL COMMENT '表名',
  `name` varchar(200) NOT NULL COMMENT '名称',
  `picture` longtext NOT NULL COMMENT '图片',
  `type` varchar(200) DEFAULT NULL COMMENT '类型(1:收藏,21:赞,22:踩,31:竞拍参与,41:关注)',
  `inteltype` varchar(200) DEFAULT NULL COMMENT '推荐类型',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='我的收藏';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storeup`
--

LOCK TABLES `storeup` WRITE;
/*!40000 ALTER TABLE `storeup` DISABLE KEYS */;
/*!40000 ALTER TABLE `storeup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='token表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES (1,31,'用户账号1','yonghu','用户','c4da7eqnk9jlf9rezd6ybztdbaykaxsd','2024-01-21 14:53:17','2024-01-21 15:53:17'),(2,1,'admin','users','管理员','anwe5pb8geano0tsgr1pktbexkge19d6','2024-01-21 14:54:15','2024-01-21 15:54:16');
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `username` varchar(200) NOT NULL COMMENT '用户名',
  `password` varchar(200) NOT NULL COMMENT '密码',
  `role` varchar(200) DEFAULT NULL COMMENT '角色',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='管理员';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'2024-01-21 14:42:50','admin','admin','管理员');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yonghu`
--

DROP TABLE IF EXISTS `yonghu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yonghu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yonghuzhanghao` varchar(200) NOT NULL COMMENT '用户账号',
  `yonghumima` varchar(200) NOT NULL COMMENT '用户密码',
  `yonghuxingming` varchar(200) NOT NULL COMMENT '用户姓名',
  `touxiang` longtext COMMENT '头像',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `shoujihaoma` varchar(200) DEFAULT NULL COMMENT '手机号码',
  PRIMARY KEY (`id`),
  UNIQUE KEY `yonghuzhanghao` (`yonghuzhanghao`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yonghu`
--

LOCK TABLES `yonghu` WRITE;
/*!40000 ALTER TABLE `yonghu` DISABLE KEYS */;
INSERT INTO `yonghu` VALUES (31,'2024-01-21 14:42:50','用户账号1','123456','用户姓名1','file/yonghuTouxiang1.jpg','男','19819881111'),(32,'2024-01-21 14:42:50','用户账号2','123456','用户姓名2','file/yonghuTouxiang2.jpg','男','19819881112'),(33,'2024-01-21 14:42:50','用户账号3','123456','用户姓名3','file/yonghuTouxiang3.jpg','男','19819881113'),(34,'2024-01-21 14:42:50','用户账号4','123456','用户姓名4','file/yonghuTouxiang4.jpg','男','19819881114'),(35,'2024-01-21 14:42:50','用户账号5','123456','用户姓名5','file/yonghuTouxiang5.jpg','男','19819881115'),(36,'2024-01-21 14:42:50','用户账号6','123456','用户姓名6','file/yonghuTouxiang6.jpg','男','19819881116');
/*!40000 ALTER TABLE `yonghu` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-28 12:59:43
