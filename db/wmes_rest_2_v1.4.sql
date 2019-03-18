CREATE DATABASE  IF NOT EXISTS `wmes2` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `wmes2`;
-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: wmes2
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `clients` (
  `client_id` int(11) NOT NULL AUTO_INCREMENT,
  `client_name` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`client_id`),
  KEY `FKtiuqdledq2lybrds2k3rfqrv4` (`user_id`),
  CONSTRAINT `FKtiuqdledq2lybrds2k3rfqrv4` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `items` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_code` varchar(255) DEFAULT NULL,
  `item_name` varchar(255) DEFAULT NULL,
  `item_type` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`item_id`),
  KEY `FKft8pmhndq1kntvyfaqcybhxvx` (`user_id`),
  CONSTRAINT `FKft8pmhndq1kntvyfaqcybhxvx` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES (1,'234242342','Input1','input',2),(2,'234234234','Input2','input',2),(3,'454535354','Output1','output',2),(4,'3453453','Output2','output',2);
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_description` varchar(255) DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `FKm2dep9derpoaehshbkkatam3v` (`client_id`),
  KEY `FK32ql8ubntj5uh44ph9659tiih` (`user_id`),
  CONSTRAINT `FK32ql8ubntj5uh44ph9659tiih` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FKm2dep9derpoaehshbkkatam3v` FOREIGN KEY (`client_id`) REFERENCES `clients` (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projects`
--

DROP TABLE IF EXISTS `projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `projects` (
  `project_id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(255) DEFAULT NULL,
  `project_status` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`project_id`),
  KEY `FKhswfwa3ga88vxv1pmboss6jhm` (`user_id`),
  CONSTRAINT `FKhswfwa3ga88vxv1pmboss6jhm` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects`
--

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
INSERT INTO `projects` VALUES (2,'testo prova',0,2),(3,'descrizione prova',0,2),(4,'testo prova',0,2);
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projects_templates`
--

DROP TABLE IF EXISTS `projects_templates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `projects_templates` (
  `project_id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`project_id`),
  KEY `FKsncda5jy668rom92kka45sr4h` (`user_id`),
  CONSTRAINT `FKsncda5jy668rom92kka45sr4h` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects_templates`
--

LOCK TABLES `projects_templates` WRITE;
/*!40000 ALTER TABLE `projects_templates` DISABLE KEYS */;
/*!40000 ALTER TABLE `projects_templates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resources`
--

DROP TABLE IF EXISTS `resources`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `resources` (
  `resource_id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_name` varchar(255) DEFAULT NULL,
  `resource_pass` varchar(255) DEFAULT NULL,
  `resource_username` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`resource_id`),
  KEY `FKcoba1blh4w96p6n34i4xfoiyp` (`user_id`),
  CONSTRAINT `FKcoba1blh4w96p6n34i4xfoiyp` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resources`
--

LOCK TABLES `resources` WRITE;
/*!40000 ALTER TABLE `resources` DISABLE KEYS */;
INSERT INTO `resources` VALUES (1,'res1','res1','res1',2),(2,'res2','res2','res2',2);
/*!40000 ALTER TABLE `resources` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasks`
--

DROP TABLE IF EXISTS `tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tasks` (
  `task_id` int(11) NOT NULL AUTO_INCREMENT,
  `task_action` varchar(255) DEFAULT NULL,
  `task_description` varchar(255) DEFAULT NULL,
  `task_state` int(11) DEFAULT NULL,
  `task_time` int(11) DEFAULT NULL,
  `project_id` int(11) DEFAULT NULL,
  `resource_id` int(11) DEFAULT NULL,
  `father_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`task_id`),
  KEY `FKsfhn82y57i3k9uxww1s007acc` (`project_id`),
  KEY `FKoucetjmqkm50le1v0cstk6k38` (`resource_id`),
  KEY `FKfmxsg6f62v4hajohgssmnug3a` (`father_id`),
  KEY `FK6s1ob9k4ihi75xbxe2w0ylsdh` (`user_id`),
  CONSTRAINT `FK6s1ob9k4ihi75xbxe2w0ylsdh` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FKfmxsg6f62v4hajohgssmnug3a` FOREIGN KEY (`father_id`) REFERENCES `tasks` (`task_id`),
  CONSTRAINT `FKoucetjmqkm50le1v0cstk6k38` FOREIGN KEY (`resource_id`) REFERENCES `resources` (`resource_id`),
  CONSTRAINT `FKsfhn82y57i3k9uxww1s007acc` FOREIGN KEY (`project_id`) REFERENCES `projects` (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks`
--

LOCK TABLES `tasks` WRITE;
/*!40000 ALTER TABLE `tasks` DISABLE KEYS */;
INSERT INTO `tasks` VALUES (1,'Azione2','TaskModel2',0,10,NULL,2,NULL,2);
/*!40000 ALTER TABLE `tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasks_items`
--

DROP TABLE IF EXISTS `tasks_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tasks_items` (
  `task_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  KEY `FKkak911isvgmnxbyes4woiuk0f` (`item_id`),
  KEY `FKcsidonsfa24wcwrtkk49w4nwl` (`task_id`),
  CONSTRAINT `FKcsidonsfa24wcwrtkk49w4nwl` FOREIGN KEY (`task_id`) REFERENCES `tasks` (`task_id`),
  CONSTRAINT `FKkak911isvgmnxbyes4woiuk0f` FOREIGN KEY (`item_id`) REFERENCES `items` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks_items`
--

LOCK TABLES `tasks_items` WRITE;
/*!40000 ALTER TABLE `tasks_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `tasks_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasks_model`
--

DROP TABLE IF EXISTS `tasks_model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tasks_model` (
  `task_model_id` int(11) NOT NULL AUTO_INCREMENT,
  `task_model_action` varchar(255) DEFAULT NULL,
  `task_model_description` varchar(255) DEFAULT NULL,
  `task_model_state` int(11) DEFAULT NULL,
  `task_model_time` int(11) DEFAULT NULL,
  `resource_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`task_model_id`),
  KEY `FKj4orkg6sb7tgu0pgdropmarrt` (`resource_id`),
  KEY `FK21nf5uob26rkkxud6psxqsmuy` (`user_id`),
  CONSTRAINT `FK21nf5uob26rkkxud6psxqsmuy` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FKj4orkg6sb7tgu0pgdropmarrt` FOREIGN KEY (`resource_id`) REFERENCES `resources` (`resource_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks_model`
--

LOCK TABLES `tasks_model` WRITE;
/*!40000 ALTER TABLE `tasks_model` DISABLE KEYS */;
INSERT INTO `tasks_model` VALUES (1,'Azione1','Descrizione1',0,10,2,2),(2,'Azione2','TaskModel2',0,10,2,2);
/*!40000 ALTER TABLE `tasks_model` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasks_model_items`
--

DROP TABLE IF EXISTS `tasks_model_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tasks_model_items` (
  `task_model_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  KEY `FKabr753a77cq3pt7r7i4ihkvpw` (`item_id`),
  KEY `FK7px5hoic4t4uq4viiqcdctaqn` (`task_model_id`),
  CONSTRAINT `FK7px5hoic4t4uq4viiqcdctaqn` FOREIGN KEY (`task_model_id`) REFERENCES `tasks_model` (`task_model_id`),
  CONSTRAINT `FKabr753a77cq3pt7r7i4ihkvpw` FOREIGN KEY (`item_id`) REFERENCES `items` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks_model_items`
--

LOCK TABLES `tasks_model_items` WRITE;
/*!40000 ALTER TABLE `tasks_model_items` DISABLE KEYS */;
INSERT INTO `tasks_model_items` VALUES (1,2),(1,4),(2,2),(2,4);
/*!40000 ALTER TABLE `tasks_model_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasks_template`
--

DROP TABLE IF EXISTS `tasks_template`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tasks_template` (
  `task_template_id` int(11) NOT NULL AUTO_INCREMENT,
  `task_template_action` varchar(255) DEFAULT NULL,
  `task_template_description` varchar(255) DEFAULT NULL,
  `task_template_state` int(11) DEFAULT NULL,
  `task_template_time` int(11) DEFAULT NULL,
  `project_template_id` int(11) DEFAULT NULL,
  `resource_id` int(11) DEFAULT NULL,
  `father_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`task_template_id`),
  KEY `FKibd0ssudpclc0cgvnpdo33c0s` (`project_template_id`),
  KEY `FKiakhsr5brutss1x2tgmep5ad6` (`resource_id`),
  KEY `FKpdkc4nynk1smmgpvw368htqgx` (`father_id`),
  KEY `FKs3dcortlj5t9jf670xilha3w7` (`user_id`),
  CONSTRAINT `FKiakhsr5brutss1x2tgmep5ad6` FOREIGN KEY (`resource_id`) REFERENCES `resources` (`resource_id`),
  CONSTRAINT `FKibd0ssudpclc0cgvnpdo33c0s` FOREIGN KEY (`project_template_id`) REFERENCES `projects_templates` (`project_id`),
  CONSTRAINT `FKpdkc4nynk1smmgpvw368htqgx` FOREIGN KEY (`father_id`) REFERENCES `tasks_template` (`task_template_id`),
  CONSTRAINT `FKs3dcortlj5t9jf670xilha3w7` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks_template`
--

LOCK TABLES `tasks_template` WRITE;
/*!40000 ALTER TABLE `tasks_template` DISABLE KEYS */;
/*!40000 ALTER TABLE `tasks_template` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasks_template_items`
--

DROP TABLE IF EXISTS `tasks_template_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tasks_template_items` (
  `task_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  KEY `FKqggndkbm4hf6r35uf4btq83he` (`item_id`),
  KEY `FKhqcjwg8ah6sk583lf8pv07b33` (`task_id`),
  CONSTRAINT `FKhqcjwg8ah6sk583lf8pv07b33` FOREIGN KEY (`task_id`) REFERENCES `tasks_template` (`task_template_id`),
  CONSTRAINT `FKqggndkbm4hf6r35uf4btq83he` FOREIGN KEY (`item_id`) REFERENCES `items` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks_template_items`
--

LOCK TABLES `tasks_template_items` WRITE;
/*!40000 ALTER TABLE `tasks_template_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `tasks_template_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_pass` varchar(255) DEFAULT NULL,
  `user_type` varchar(255) DEFAULT NULL,
  `user_user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','admin','admin'),(2,'user','bo','user');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-18  9:42:49
