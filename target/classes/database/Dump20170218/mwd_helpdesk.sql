-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mwd
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `helpdesk`
--

DROP TABLE IF EXISTS `helpdesk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `helpdesk` (
  `ID` int(11) NOT NULL,
  `FName` varchar(45) NOT NULL,
  `LName` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `SeverityID` int(11) DEFAULT NULL,
  `DepartmentID` int(11) DEFAULT NULL,
  `StatusID` int(11) DEFAULT NULL,
  `EmployeeID` int(11) DEFAULT NULL,
  `Comments` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK1_idx` (`StatusID`),
  KEY `FK2_idx` (`DepartmentID`),
  KEY `FK3_idx` (`EmployeeID`),
  KEY `FK4_idx` (`SeverityID`),
  CONSTRAINT `FK1` FOREIGN KEY (`StatusID`) REFERENCES `status` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK2` FOREIGN KEY (`DepartmentID`) REFERENCES `department` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK3` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK4` FOREIGN KEY (`SeverityID`) REFERENCES `severity` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `helpdesk`
--

LOCK TABLES `helpdesk` WRITE;
/*!40000 ALTER TABLE `helpdesk` DISABLE KEYS */;
INSERT INTO `helpdesk` VALUES (1,'test1','test1','test1@mail.ru',1,1,1,2,'test1'),(2,'Kuba','Akaev','new@mail.ru',2,4,3,3,'не работает мышь');
/*!40000 ALTER TABLE `helpdesk` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-18 18:20:27
