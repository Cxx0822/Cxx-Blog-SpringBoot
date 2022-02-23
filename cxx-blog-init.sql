-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cxx_blog
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `blog`
--
use cxx_blog;
DROP TABLE IF EXISTS `blog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blog` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL COMMENT '文章标题',
  `description` longtext NOT NULL COMMENT '文字描述',
  `content` longtext NOT NULL COMMENT '文章正文',
  `views` int NOT NULL COMMENT '文章浏览次数',
  `words` int NOT NULL COMMENT '文章字数',
  `status` tinyint DEFAULT NULL COMMENT '文章状态（是否公开）',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog`
--

LOCK TABLES `blog` WRITE;
/*!40000 ALTER TABLE `blog` DISABLE KEYS */;
/*!40000 ALTER TABLE `blog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blog_type`
--

DROP TABLE IF EXISTS `blog_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blog_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `blog_id` bigint DEFAULT NULL,
  `type_id` int DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog_type`
--

LOCK TABLES `blog_type` WRITE;
/*!40000 ALTER TABLE `blog_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `blog_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blog_user`
--

DROP TABLE IF EXISTS `blog_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blog_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `blog_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog_user`
--

LOCK TABLES `blog_user` WRITE;
/*!40000 ALTER TABLE `blog_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `blog_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `qq` varchar(255) DEFAULT NULL COMMENT 'qq号',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `content` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `avator` varchar(255) DEFAULT NULL COMMENT '头像',
  `ip` varchar(255) DEFAULT NULL COMMENT 'ip地址',
  `website` varchar(255) DEFAULT NULL COMMENT '个人网站',
  `blog_id` bigint DEFAULT NULL COMMENT '博客id',
  `is_admin_comment` int DEFAULT NULL COMMENT '博主是否回复',
  `is_published` bit(1) DEFAULT NULL COMMENT '是否公开',
  `parent_comment_id` bigint DEFAULT NULL COMMENT '父评论id',
  `parent_comment_nickname` varchar(255) DEFAULT NULL COMMENT '父评论昵称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `path` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `component` varchar(255) DEFAULT NULL,
  `redirect` varchar(255) DEFAULT NULL,
  `hidden` smallint DEFAULT NULL,
  `always_show` smallint DEFAULT NULL,
  `parent_id` int DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'/maintainSysPermission','maintainSysPermission','layout',NULL,0,1,0,'2022-02-21 15:55:45','2022-02-21 15:55:45'),(2,'maintainUser','maintainUser','permission_user',NULL,0,0,1,'2022-02-21 15:56:08','2022-02-21 15:56:08'),(3,'maintainRole','maintainRole','permission_role',NULL,0,0,1,'2022-02-21 15:56:28','2022-02-21 15:56:28');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu_meta`
--

DROP TABLE IF EXISTS `menu_meta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu_meta` (
  `id` int NOT NULL AUTO_INCREMENT,
  `menu_id` int DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `no_cache` smallint DEFAULT NULL,
  `affix` smallint DEFAULT NULL,
  `breadcrumb` smallint DEFAULT NULL,
  `active_menu` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu_meta`
--

LOCK TABLES `menu_meta` WRITE;
/*!40000 ALTER TABLE `menu_meta` DISABLE KEYS */;
INSERT INTO `menu_meta` VALUES (1,1,'管理系统权限','lock',0,0,0,NULL,'2022-02-21 15:57:49','2022-02-21 15:57:49'),(2,2,'维护用户','userManage',0,0,0,NULL,'2022-02-21 15:58:01','2022-02-21 15:58:01'),(3,3,'维护角色','roleManage',0,0,0,NULL,'2022-02-21 15:58:07','2022-02-21 15:58:07');
/*!40000 ALTER TABLE `menu_meta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operation`
--

DROP TABLE IF EXISTS `operation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `operation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `operation_name` varchar(255) DEFAULT NULL,
  `operation_description` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operation`
--

LOCK TABLES `operation` WRITE;
/*!40000 ALTER TABLE `operation` DISABLE KEYS */;
INSERT INTO `operation` VALUES (1,'create','增加操作','2022-02-21 15:58:39','2022-02-21 15:58:39'),(2,'update','更新操作','2022-02-21 15:58:47','2022-02-21 15:58:47'),(3,'delete','删除操作','2022-02-21 15:58:55','2022-02-21 15:58:55'),(4,'assignUserRole','分配用户角色操作','2022-02-21 15:59:04','2022-02-21 15:59:04'),(5,'assignRoleMenu','分配角色资源操作','2022-02-21 15:59:11','2022-02-21 15:59:11');
/*!40000 ALTER TABLE `operation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(255) DEFAULT NULL,
  `permission_description` varchar(255) DEFAULT NULL,
  `resource_id` int DEFAULT NULL,
  `operation_id` int DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
INSERT INTO `permission` VALUES (1,'createUser','创建用户',1,1,'2022-02-21 16:00:20','2022-02-21 16:00:20'),(2,'updateUser','更新用户',1,2,'2022-02-21 16:00:34','2022-02-21 16:00:34'),(3,'deleteUser','删除用户',1,3,'2022-02-21 16:00:46','2022-02-21 16:00:46'),(4,'assignUserRole','分配用户角色',1,4,'2022-02-21 16:01:01','2022-02-21 16:01:01'),(5,'createRole','创建角色',2,1,'2022-02-21 16:01:33','2022-02-21 16:01:33'),(6,'updateRole','更新角色',2,2,'2022-02-21 16:01:45','2022-02-21 16:01:45'),(7,'deleteRole','删除角色',2,3,'2022-02-21 16:02:01','2022-02-21 16:02:01'),(8,'assignRoleMenu','分配角色资源',2,5,'2022-02-21 16:02:12','2022-02-21 16:02:12'),(9,'assignRolePermission','分配角色操作',2,6,'2022-02-21 16:02:22','2022-02-21 16:02:22');
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resource`
--

DROP TABLE IF EXISTS `resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resource` (
  `id` int NOT NULL AUTO_INCREMENT,
  `resource_name` varchar(255) DEFAULT NULL,
  `resource_description` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resource`
--

LOCK TABLES `resource` WRITE;
/*!40000 ALTER TABLE `resource` DISABLE KEYS */;
INSERT INTO `resource` VALUES (1,'user','用户资源','2022-02-21 16:02:53','2022-02-21 16:02:53'),(2,'role','角色资源','2022-02-21 16:03:00','2022-02-21 16:03:00');
/*!40000 ALTER TABLE `resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  `role_description` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'admin','超级管理员','2022-02-21 15:53:35','2022-02-21 15:53:35'),(2,'editor','用户权限管理员','2022-02-21 15:53:59','2022-02-21 15:53:59'),(3,'common','普通用户','2022-02-21 15:54:12','2022-02-21 15:54:12');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_menu`
--

DROP TABLE IF EXISTS `role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_menu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_id` int DEFAULT NULL,
  `menu_id` int DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_menu`
--

LOCK TABLES `role_menu` WRITE;
/*!40000 ALTER TABLE `role_menu` DISABLE KEYS */;
INSERT INTO `role_menu` VALUES (1,1,1,'2022-02-21 16:03:47','2022-02-21 16:03:47'),(2,1,2,'2022-02-21 16:03:48','2022-02-21 16:03:48'),(3,1,3,'2022-02-21 16:03:50','2022-02-21 16:03:50'),(4,2,1,'2022-02-21 16:03:53','2022-02-21 16:03:53'),(5,2,2,'2022-02-21 16:03:55','2022-02-21 16:03:55'),(6,2,3,'2022-02-21 16:03:56','2022-02-21 16:03:56');
/*!40000 ALTER TABLE `role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_permission`
--

DROP TABLE IF EXISTS `role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_permission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_id` int DEFAULT NULL,
  `permission_id` int DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_permission`
--

LOCK TABLES `role_permission` WRITE;
/*!40000 ALTER TABLE `role_permission` DISABLE KEYS */;
INSERT INTO `role_permission` VALUES (1,1,1,'2022-02-21 16:04:46','2022-02-21 16:04:46'),(2,1,2,'2022-02-21 16:04:47','2022-02-21 16:04:47'),(3,1,3,'2022-02-21 16:04:49','2022-02-21 16:04:49'),(4,1,4,'2022-02-21 16:04:51','2022-02-21 16:04:51'),(5,1,5,'2022-02-21 16:04:54','2022-02-21 16:04:54'),(6,1,6,'2022-02-21 16:04:57','2022-02-21 16:04:57'),(7,1,7,'2022-02-21 16:04:59','2022-02-21 16:04:59'),(8,1,8,'2022-02-21 16:05:01','2022-02-21 16:05:01'),(9,1,9,'2022-02-21 16:05:03','2022-02-21 16:05:03'),(10,2,4,'2022-02-21 16:05:18','2022-02-21 16:05:18'),(11,2,5,'2022-02-21 16:05:20','2022-02-21 16:05:20'),(12,2,6,'2022-02-21 16:05:22','2022-02-21 16:05:22'),(13,2,7,'2022-02-21 16:05:24','2022-02-21 16:05:24'),(14,2,8,'2022-02-21 16:05:27','2022-02-21 16:05:27'),(15,2,9,'2022-02-21 16:05:29','2022-02-21 16:05:29');
/*!40000 ALTER TABLE `role_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type`
--

DROP TABLE IF EXISTS `type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type_name` varchar(255) NOT NULL COMMENT '类别名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type`
--

LOCK TABLES `type` WRITE;
/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` VALUES (1,'C++学习','2022-02-11 16:32:06','2022-02-11 16:32:06'),(2,'Linux系统','2022-02-11 16:32:13','2022-02-11 16:32:13'),(3,'MATLAB','2022-02-11 16:32:22','2022-02-11 16:32:22'),(4,'NAO开发与应用','2022-02-22 16:36:16','2022-02-22 16:36:16'),(5,'NAO高尔夫比赛','2022-02-22 16:36:27','2022-02-22 16:36:27'),(6,'Python','2022-02-22 16:37:59','2022-02-22 16:37:59'),(7,'ROS开发与应用','2022-02-22 16:38:57','2022-02-22 16:38:57'),(8,'Web前端开发与应用','2022-02-22 16:39:09','2022-02-22 16:39:09'),(9,'Web开发与应用','2022-02-22 16:39:20','2022-02-22 16:39:20'),(10,'医疗服务机器人','2022-02-22 16:39:30','2022-02-22 16:39:30'),(11,'工业机器人视觉','2022-02-22 16:39:44','2022-02-22 16:39:44'),(12,'机器学习','2022-02-22 16:39:54','2022-02-22 16:39:54'),(13,'杂项','2022-02-22 16:40:00','2022-02-22 16:40:00'),(14,'毕业论文','2022-02-22 16:40:05','2022-02-22 16:40:05'),(15,'深度学习','2022-02-22 16:40:09','2022-02-22 16:40:09'),(16,'SLAM建图算法','2022-02-22 16:41:14','2022-02-22 16:41:14'),(17,'Unity开发与应用','2022-02-22 16:41:24','2022-02-22 16:41:24');
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `salt` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `status` int DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Cxx','05acc9da44c66ec9dd05cb68b4b8ef3c','Jr&N0e^I',NULL,NULL,NULL,NULL,'2022-02-10 20:22:36','2022-02-10 20:22:36'),(2,'Pjm','5f12dbedc7e96d3401048301ed581252','qkg&tHd1',NULL,NULL,NULL,NULL,'2022-02-21 15:52:47','2022-02-21 15:52:47'),(3,'cxx2','05f05b5b4c945180ef0a21e85775420d','IzyxIUwq',NULL,NULL,NULL,NULL,'2022-02-21 16:06:13','2022-02-21 16:06:13');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL,
  `role_id` int DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1,1,'2022-02-21 16:07:46','2022-02-21 16:07:46'),(2,2,2,'2022-02-21 16:07:49','2022-02-21 16:07:49'),(3,3,3,'2022-02-21 16:07:54','2022-02-21 16:07:54');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visit_log`
--

DROP TABLE IF EXISTS `visit_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visit_log` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `uuid` varchar(36) DEFAULT NULL COMMENT '访客标识码',
  `uri` varchar(255) DEFAULT NULL COMMENT '请求接口',
  `method` varchar(255) DEFAULT NULL COMMENT '请求方式',
  `param` varchar(2000) DEFAULT NULL COMMENT '请求参数',
  `behavior` varchar(255) DEFAULT NULL COMMENT '访问行为',
  `content` varchar(255) DEFAULT NULL COMMENT '访问内容',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `ip` varchar(255) DEFAULT NULL COMMENT 'ip',
  `ip_source` varchar(255) DEFAULT NULL COMMENT 'ip来源',
  `os` varchar(255) DEFAULT NULL COMMENT '操作系统',
  `browser` varchar(255) DEFAULT NULL COMMENT '浏览器',
  `times` int DEFAULT NULL COMMENT '请求耗时ms',
  `user_agent` varchar(2000) DEFAULT NULL COMMENT '用户代理',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visit_log`
--

LOCK TABLES `visit_log` WRITE;
/*!40000 ALTER TABLE `visit_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `visit_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visitor`
--

DROP TABLE IF EXISTS `visitor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visitor` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `uuid` varchar(36) DEFAULT NULL COMMENT '访客标识码',
  `ip` varchar(255) DEFAULT NULL COMMENT 'ip',
  `ip_source` varchar(255) DEFAULT NULL COMMENT 'ip来源',
  `os` varchar(255) DEFAULT NULL COMMENT '操作系统',
  `browser` varchar(255) DEFAULT NULL COMMENT '浏览器',
  `pv` int DEFAULT NULL COMMENT '访问页数统计',
  `user_agent` varchar(2000) DEFAULT NULL COMMENT '用户代理',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visitor`
--

LOCK TABLES `visitor` WRITE;
/*!40000 ALTER TABLE `visitor` DISABLE KEYS */;
/*!40000 ALTER TABLE `visitor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-22 17:16:46
