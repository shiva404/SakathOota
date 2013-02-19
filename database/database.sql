-- MySQL dump 10.13  Distrib 5.5.16, for osx10.5 (i386)
--
-- Host: localhost    Database: sakathoota
-- ------------------------------------------------------
-- Server version	5.5.16

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
-- Current Database: `sakathoota`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `sakathoota` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `sakathoota`;

--
-- Table structure for table `feed`
--

DROP TABLE IF EXISTS `feed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feed` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  `emotion_id` tinyint(4) DEFAULT NULL,
  `location_id` int(11) DEFAULT NULL,
  `menu_item_id` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feed`
--

LOCK TABLES `feed` WRITE;
/*!40000 ALTER TABLE `feed` DISABLE KEYS */;
INSERT INTO `feed` VALUES (1,3,1,2,7,NULL,NULL,NULL),(2,3,1,2,7,NULL,NULL,NULL),(3,3,1,2,7,NULL,NULL,NULL),(4,3,1,2,7,NULL,NULL,NULL),(5,3,1,2,7,NULL,NULL,NULL),(6,3,1,2,7,NULL,NULL,NULL),(7,3,1,2,7,NULL,NULL,NULL),(8,3,1,2,7,NULL,NULL,NULL),(9,3,1,2,7,NULL,NULL,NULL),(10,3,1,2,7,NULL,NULL,NULL),(11,3,1,2,7,NULL,NULL,NULL);
/*!40000 ALTER TABLE `feed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `items` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `type` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES (1,'chicken biryani',2);
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locations`
--

DROP TABLE IF EXISTS `locations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `locations` (
  `location_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `landmark` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `street` varchar(300) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `fb_loc_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locations`
--

LOCK TABLES `locations` WRITE;
/*!40000 ALTER TABLE `locations` DISABLE KEYS */;
INSERT INTO `locations` VALUES (3,'Hoskerehalli',77.5406636,12.9338294,NULL,NULL,'','Bangalore',212960442072005),(6,'PES Institute of Technology',77.536588622629,12.934541361153,NULL,NULL,'100 Feet Ring Road;Banashankari - III Stage','Bangalore',160974543956177),(7,'The Bay',77.68086785,12.926065483333,NULL,NULL,'','Bangalore',220349984657323),(8,'RMZ Ecospace',77.680630482,12.926561743293,NULL,NULL,'Outer Ring Road, Bellandur','Bangalore',211177125564412),(9,'Sports Cafe SH17',77.53181,12.92927,NULL,NULL,'Bangalore - Mysore Highway','Bangalore',113584562026875),(10,'PESIT Creative Team',77.533866521651,12.936154088444,NULL,NULL,'','Bangalore',273543549355794),(11,'NICE ring road',77.5410565,12.9324415,NULL,NULL,'','Bangalore',244674982221837),(12,'Udupi Gardens',77.610037339179,12.916234150318,NULL,NULL,'Udupigardens, 16th Main 2nd Stg','Bangalore',153960144664183),(13,'Jcubez',77.56394547576,12.925864477753,NULL,NULL,'banshankari','Bangalore',172119086173936),(14,'Cuppa',77.54379856005,12.930450313589,NULL,NULL,'','Bangalore',217557021621540);
/*!40000 ALTER TABLE `locations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu_items`
--

DROP TABLE IF EXISTS `menu_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu_items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `location_id` int(11) DEFAULT NULL,
  `menu_item_id` int(11) DEFAULT NULL,
  `awesome_count` int(11) DEFAULT NULL,
  `okay_count` int(11) DEFAULT NULL,
  `bad_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu_items`
--

LOCK TABLES `menu_items` WRITE;
/*!40000 ALTER TABLE `menu_items` DISABLE KEYS */;
INSERT INTO `menu_items` VALUES (1,7,1,1,0,0);
/*!40000 ALTER TABLE `menu_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `txtweb_phones`
--

DROP TABLE IF EXISTS `txtweb_phones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `txtweb_phones` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone_number` varchar(45) DEFAULT NULL,
  `encoded_number` varchar(45) DEFAULT NULL,
  `active` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `txtweb_phones`
--

LOCK TABLES `txtweb_phones` WRITE;
/*!40000 ALTER TABLE `txtweb_phones` DISABLE KEYS */;
INSERT INTO `txtweb_phones` VALUES (1,'ads','adb',1);
/*!40000 ALTER TABLE `txtweb_phones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `fb_id` bigint(20) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `dob` datetime DEFAULT NULL,
  `gender` int(2) DEFAULT NULL,
  `food_pref` int(2) DEFAULT NULL,
  `fb_access_token` varchar(200) DEFAULT NULL,
  `fb_acc_tok_expires_on` bigint(20) DEFAULT NULL,
  `apn_device_token` varchar(100) DEFAULT NULL,
  `android_token` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'something@nothing.com',NULL,'2013-01-20 20:43:38',NULL,'shiva',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'shiva.n404@gmail.com','2013-01-23 14:06:17','2013-02-18 21:23:34',100001609165007,'Shiva Kumar',NULL,'1989-08-13 00:00:00',1,0,'AAAGNxAItAjIBADIt3ymGdDbreNF33uiI5NzrEAKGxez1tl3AFPPzRqCAKZCytBT1ZBg9goEQNZAw2ZCUQho80RYoYQCFmeyxb6DeeC2PnwZDZD',1362091839221,'42f38072e61bc15aa0d7bc596616403e20a3d230028657b448df514c7c4bfe07',NULL),(4,'sakkathoota@gmail.com','2013-01-29 20:37:00','2013-01-29 20:37:00',100005009113735,'Sakkath Oota',NULL,'1985-07-11 00:00:00',2,0,'AAAGNxAItAjIBALzZBT9bIFJIaJLP0sy7ZCDCzIbHHyNiK5ESx4ThZCbepTko85KyAss9xuLulfxszIYZCmTjJyAHLTk2sPV2Yu0hVCnp7gZDZD',1360361044600,NULL,NULL),(5,'shivakumar.pesit@gmail.com','2013-02-18 21:34:36','2013-02-18 21:34:36',1683517251,'Shiva Kumar',NULL,'1989-08-13 00:00:00',1,0,'AAAGNxAItAjIBAFOvTB1dZBAmxSezd5ZB8JZA8iVqNOnVGnBZC4dQUDDYKuCshp0QBAZC7JppfVNLKXC8D7LKpUG1dk1DRAypt13ZA9MuZCuDwZDZD',1362092502124,NULL,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER user_create BEFORE INSERT ON users 
FOR EACH ROW
SET NEW.create_date = NOW() , NEW.update_date = NOW() */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER user_update BEFORE UPDATE ON users 
FOR EACH ROW
SET NEW.update_date = NOW() */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-02-19 20:02:00
