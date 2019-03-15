-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: wmes
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
  `client_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL,
  `client_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`client_id`),
  KEY `clients_user_id_fk_idx` (`user_id`),
  CONSTRAINT `clients_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES (1,28,'gaduianello'),(2,27,'salice salentino'),(5,27,'Nuovo cliente');
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `orders` (
  `order_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL,
  `client_id` int(10) unsigned NOT NULL,
  `order_description` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `order_user_id_fk_idx` (`user_id`),
  KEY `order_client_id_fk_idx` (`client_id`),
  CONSTRAINT `orders_client_id_fk` FOREIGN KEY (`client_id`) REFERENCES `clients` (`client_id`),
  CONSTRAINT `orders_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,28,1,'acqua'),(2,27,2,'vino'),(3,27,5,'Desc'),(17,27,5,'Descrizione'),(18,27,5,'dfdsf'),(19,27,5,'testprova'),(20,27,5,'orderDescription'),(21,27,2,'orderDescription'),(22,27,5,'orderDescription'),(23,27,2,'orderDescription'),(24,27,5,'test prova'),(25,27,2,'test prova'),(26,27,2,'test prova'),(27,27,5,'3333');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_templates`
--

DROP TABLE IF EXISTS `project_templates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `project_templates` (
  `project_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) unsigned NOT NULL,
  `project_name` varchar(100) NOT NULL,
  PRIMARY KEY (`project_id`),
  KEY `project_templates_user_id_fk_idx` (`user_id`),
  CONSTRAINT `project_templates_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='Table with project templates';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_templates`
--

LOCK TABLES `project_templates` WRITE;
/*!40000 ALTER TABLE `project_templates` DISABLE KEYS */;
INSERT INTO `project_templates` VALUES (5,27,'Template1'),(6,27,'Template2');
/*!40000 ALTER TABLE `project_templates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_templates_tasks`
--

DROP TABLE IF EXISTS `project_templates_tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `project_templates_tasks` (
  `project_template_id` int(10) unsigned NOT NULL,
  `task_id` int(10) unsigned NOT NULL,
  KEY `project_templates_tasks_project_templates_id_idx` (`project_template_id`),
  KEY `project_templates_tasks_task_id_fk_idx` (`task_id`),
  CONSTRAINT `project_templates_tasks_project_templates_id` FOREIGN KEY (`project_template_id`) REFERENCES `project_templates` (`project_id`),
  CONSTRAINT `project_templates_tasks_task_id_fk` FOREIGN KEY (`task_id`) REFERENCES `tasks` (`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Table to manage many to many relation between project templates and tasks';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_templates_tasks`
--

LOCK TABLES `project_templates_tasks` WRITE;
/*!40000 ALTER TABLE `project_templates_tasks` DISABLE KEYS */;
INSERT INTO `project_templates_tasks` VALUES (5,11),(6,11),(6,29);
/*!40000 ALTER TABLE `project_templates_tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projects`
--

DROP TABLE IF EXISTS `projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `projects` (
  `project_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) unsigned NOT NULL,
  `project_name` varchar(100) NOT NULL,
  `project_status` int(1) NOT NULL,
  PRIMARY KEY (`project_id`),
  KEY `projects_user_id_fk_idx` (`user_id`),
  CONSTRAINT `projects_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects`
--

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
INSERT INTO `projects` VALUES (21,27,'testo',0),(22,27,'campoprova',0);
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projects_tasks`
--

DROP TABLE IF EXISTS `projects_tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `projects_tasks` (
  `project_id` int(11) unsigned NOT NULL,
  `task_id` int(11) unsigned NOT NULL,
  KEY `Projects_tasks_project_id_idx` (`project_id`),
  KEY `projects_tasks_task_id_idx` (`task_id`),
  CONSTRAINT `projects_tasks_project_id_fk` FOREIGN KEY (`project_id`) REFERENCES `projects` (`project_id`),
  CONSTRAINT `projects_tasks_task_id` FOREIGN KEY (`task_id`) REFERENCES `tasks` (`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Connect projects to tasks';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects_tasks`
--

LOCK TABLES `projects_tasks` WRITE;
/*!40000 ALTER TABLE `projects_tasks` DISABLE KEYS */;
INSERT INTO `projects_tasks` VALUES (21,10),(21,11),(22,10),(22,11);
/*!40000 ALTER TABLE `projects_tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resources`
--

DROP TABLE IF EXISTS `resources`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `resources` (
  `resource_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) unsigned NOT NULL,
  `resource_name` varchar(45) NOT NULL,
  `resource_username` varchar(45) NOT NULL,
  `resource_pass` varchar(45) NOT NULL,
  PRIMARY KEY (`resource_id`),
  KEY `resources_user_id_fk_idx` (`user_id`),
  CONSTRAINT `resource_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resources`
--

LOCK TABLES `resources` WRITE;
/*!40000 ALTER TABLE `resources` DISABLE KEYS */;
INSERT INTO `resources` VALUES (1,27,'Nome1','user1','pass'),(4,27,'user2','user2','user2'),(5,27,'Test2323','prova2','prova2'),(6,27,'ciccio','ciccio','ciccio'),(9,27,'sdfasdfasfd','cccio','ciosdiof'),(12,27,'test','testset32424234','sdfsfd');
/*!40000 ALTER TABLE `resources` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasks`
--

DROP TABLE IF EXISTS `tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tasks` (
  `task_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL,
  `resource_id` int(11) unsigned NOT NULL,
  `task_description` varchar(45) DEFAULT NULL,
  `task_action` varchar(45) DEFAULT NULL,
  `task_input` varchar(45) DEFAULT NULL,
  `task_output` varchar(45) DEFAULT NULL,
  `task_time` int(11) DEFAULT NULL,
  `task_state` int(1) NOT NULL,
  PRIMARY KEY (`task_id`),
  KEY `user_id_fk_idx` (`user_id`),
  KEY `user_id_fka_idx` (`user_id`),
  KEY `tasks_resource_id_fk_idx` (`resource_id`),
  CONSTRAINT `task_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `tasks_resource_id_fk` FOREIGN KEY (`resource_id`) REFERENCES `resources` (`resource_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks`
--

LOCK TABLES `tasks` WRITE;
/*!40000 ALTER TABLE `tasks` DISABLE KEYS */;
INSERT INTO `tasks` VALUES (10,27,1,'Description','Action','Input','OutputTest',40,2),(11,27,1,'DescrizioneProva','sdfadsf','sdfa','sfadsfa',40,1),(29,27,5,'TaskTest','azioneTest3423','inputTest','outputTest',30,1);
/*!40000 ALTER TABLE `tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_user` varchar(50) NOT NULL,
  `user_pass` varchar(50) NOT NULL,
  `user_type` varchar(50) NOT NULL DEFAULT 'bo',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8 COMMENT='Users table contains admins and business owners';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (26,'admin','admin','admin'),(27,'user','user','bo'),(28,'prova','prova','bo');
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

-- Dump completed on 2019-03-14 14:13:49
