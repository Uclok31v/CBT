-- MySQL dump 10.13  Distrib 8.0.16, for osx10.14 (x86_64)
--
-- Host: localhost    Database: cbt
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `answer` (
  `answer_id` int(11) NOT NULL AUTO_INCREMENT,
  `datetime` datetime NOT NULL,
  `user_id` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `question_id` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `answer` tinyint(1) NOT NULL,
  `correctness` tinyint(1) NOT NULL,
  PRIMARY KEY (`answer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `question` (
  `question_id` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `text` text COLLATE utf8mb4_general_ci NOT NULL,
  `choice_1` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `choice_2` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `choice_3` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `choice_4` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `correct` tinyint(1) NOT NULL,
  `role_1` tinyint(1) NOT NULL,
  `role_2` tinyint(1) NOT NULL,
  `role_3` tinyint(1) NOT NULL,
  `role_4` tinyint(1) NOT NULL,
  `role_5` tinyint(1) NOT NULL,
  `role_6` tinyint(1) NOT NULL,
  `role_7` tinyint(1) NOT NULL,
  `role_8` tinyint(1) NOT NULL,
  `role_9` tinyint(1) NOT NULL,
  `pattern` tinyint(1) NOT NULL,
  `owner` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `user_id` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `user_name` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `password` text COLLATE utf8mb4_general_ci NOT NULL,
  `administrator` tinyint(1) NOT NULL,
  `role_1` tinyint(1) NOT NULL,
  `role_2` tinyint(1) NOT NULL,
  `role_3` tinyint(1) NOT NULL,
  `role_4` tinyint(1) NOT NULL,
  `role_5` tinyint(1) NOT NULL,
  `role_6` tinyint(1) NOT NULL,
  `role_7` tinyint(1) NOT NULL,
  `role_8` tinyint(1) NOT NULL,
  `role_9` tinyint(1) NOT NULL,
  `times` int(11) NOT NULL,
  `result` tinyint(1) DEFAULT NULL,
  `percentage` float DEFAULT NULL,
  `datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-28 22:03:12
