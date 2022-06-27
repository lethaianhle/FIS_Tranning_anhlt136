-- MySQL dump 10.13  Distrib 5.7.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: test_db
-- ------------------------------------------------------
-- Server version	5.7.34-log

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
-- Dumping data for table `criminal_case`
--

LOCK TABLES `criminal_case` WRITE;
/*!40000 ALTER TABLE `criminal_case` DISABLE KEYS */;
INSERT INTO `criminal_case` VALUES (1,'2022-06-27 19:24:09','2022-06-27 19:24:09',1,'DetailedDesc1','Notes1','NUMBER1','ShortDesc1','COLD','UNCATEGORIZED',1),(2,'2022-06-27 19:24:09','2022-06-27 19:24:09',1,'DetailedDesc2','Notes2','NUMBER2','ShortDesc2','DISMISSED','INFRACTION',1),(3,'2022-06-27 19:24:09','2022-06-27 19:24:09',1,'DetailedDesc3','Notes3','NUMBER3','ShortDesc3','IN_COURT','MISDEMEANOR',2);
/*!40000 ALTER TABLE `criminal_case` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `detective`
--

LOCK TABLES `detective` WRITE;
/*!40000 ALTER TABLE `detective` DISABLE KEYS */;
INSERT INTO `detective` VALUES (1,'2022-06-27 19:24:09','2022-06-27 19:24:09',1,_binary '\0','BND1','JUNIOR','RETIRED',1),(2,'2022-06-27 19:24:09','2022-06-27 19:24:09',1,_binary '\0','BND2','CHIEF_INSPECTOR','ACTIVE',2),(3,'2022-06-27 19:24:09','2022-06-27 19:24:09',1,_binary '\0','BND3','SENIOR','UNDER_INVESTIGATION',3);
/*!40000 ALTER TABLE `detective` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `evidence`
--

LOCK TABLES `evidence` WRITE;
/*!40000 ALTER TABLE `evidence` DISABLE KEYS */;
INSERT INTO `evidence` VALUES (1,'2022-06-27 19:24:09','2022-06-27 19:24:09',1,_binary '\0','ItemName1','Notes1','NUMBER1',1,1),(2,'2022-06-27 19:24:09','2022-06-27 19:24:09',1,_binary '\0','ItemName2','Notes2','NUMBER2',1,1),(3,'2022-06-27 19:24:09','2022-06-27 19:24:09',1,_binary '\0','ItemName3','Notes3','NUMBER3',2,3);
/*!40000 ALTER TABLE `evidence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'2022-06-27 19:24:09','2022-06-27 19:24:09',1,'PersonFirstName1','2022-06-27 19:24:09','PersonLastName1','123','person1'),(2,'2022-06-27 19:24:09','2022-06-27 19:24:09',1,'PersonFirstName2','2022-06-27 19:24:09','PersonLastName2','123','person2'),(3,'2022-06-27 19:24:09','2022-06-27 19:24:09',1,'PersonFirstName3','2022-06-27 19:24:09','PersonLastName3','123','person3');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `storage`
--

LOCK TABLES `storage` WRITE;
/*!40000 ALTER TABLE `storage` DISABLE KEYS */;
INSERT INTO `storage` VALUES (1,'2022-06-27 19:24:09','2022-06-27 19:24:09',1,'Location Testing1','LocationName1'),(2,'2022-06-27 19:24:09','2022-06-27 19:24:09',1,'Location Testing2','LocationName2'),(3,'2022-06-27 19:24:09','2022-06-27 19:24:09',1,'Location Testing3','LocationName3');
/*!40000 ALTER TABLE `storage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `trackentry`
--

LOCK TABLES `trackentry` WRITE;
/*!40000 ALTER TABLE `trackentry` DISABLE KEYS */;
INSERT INTO `trackentry` VALUES (1,'2022-06-27 19:24:09','2022-06-27 19:24:09',1,'RETRIEVED','2022-06-27 19:24:09',NULL,1,1),(2,'2022-06-27 19:24:09','2022-06-27 19:24:09',1,'RETRIEVED','2022-06-27 19:24:09',NULL,1,3),(3,'2022-06-27 19:24:09','2022-06-27 19:24:09',1,'RETRIEVED','2022-06-27 19:24:09',NULL,2,1);
/*!40000 ALTER TABLE `trackentry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `working_detective_case`
--

LOCK TABLES `working_detective_case` WRITE;
/*!40000 ALTER TABLE `working_detective_case` DISABLE KEYS */;
INSERT INTO `working_detective_case` VALUES (1,2),(1,3),(2,1),(2,2),(2,3),(3,1);
/*!40000 ALTER TABLE `working_detective_case` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-28  2:26:38
