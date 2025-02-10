CREATE DATABASE  IF NOT EXISTS `control_vehiculos` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `control_vehiculos`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: control_vehiculos
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `control_vehiculos`
--

DROP TABLE IF EXISTS `control_vehiculos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `control_vehiculos` (
  `cod_control` bigint NOT NULL AUTO_INCREMENT,
  `fecha_entrada` timestamp NULL DEFAULT NULL,
  `fecha_salida` timestamp NULL DEFAULT NULL,
  `observaciones` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `id_usuario` bigint DEFAULT NULL,
  `cod_vehiculo` bigint DEFAULT NULL,
  `empresa` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `matricula` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`cod_control`),
  KEY `fk_empleado` (`id_usuario`),
  KEY `fk_vehiculo` (`cod_vehiculo`),
  CONSTRAINT `fk_empleado` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`),
  CONSTRAINT `fk_vehiculo` FOREIGN KEY (`cod_vehiculo`) REFERENCES `vehiculos` (`cod_vehiculo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `control_vehiculos`
--

LOCK TABLES `control_vehiculos` WRITE;
/*!40000 ALTER TABLE `control_vehiculos` DISABLE KEYS */;
/*!40000 ALTER TABLE `control_vehiculos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `propietarios`
--

DROP TABLE IF EXISTS `propietarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `propietarios` (
  `id_propietario` bigint NOT NULL AUTO_INCREMENT,
  `empresa` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `plazas` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `telefono` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id_propietario`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `propietarios`
--

LOCK TABLES `propietarios` WRITE;
/*!40000 ALTER TABLE `propietarios` DISABLE KEYS */;
INSERT INTO `propietarios` VALUES (1,'Alzamar','Emilio Tejera','3','600488643'),(2,'Alisios Trucks S.L.','Antonio','Parcela 400 m2','610745762'),(3,'Desatascos Alexis Gil Jorge','Alexis Gil Jorge','3','629959479'),(4,'Amado Alonso','Ambrosio Amado Alonso Mayor','4','609128750'),(5,'Nagaltrans 2008 S.L.','Iván / David','1','648716782 / 608863275'),(6,'DAF (Juan José Méndez Gil)','Juan José Méndez Gil','1','654372994'),(7,'Diodoled Canarias S.L. (Tecnosound)','Paula / Claudio / Eduardo J. Ferrer Cabrera','6','622433670 / 687363841'),(8,'Ges Transpal Canarias S.L.U.','Jezabel García Espino','3','628521054'),(9,'Definite Dirley S.L.','Juan José Peñate Vega','4','657360295'),(10,'Francisco Rodríguez León','Francisco Rodríguez León','2','607216930'),(11,'CUBA (Pedro José Ramírez Gutierrez)','Pedro José Ramírez Gutierrez','2','689691182'),(12,'ALFAMETAL','Gorka Rodríguez / Angel / Sonia','4','621261404'),(13,'Lavandería Mogán S.L.','Santiago Hernández López','5','659354783'),(14,'Aguacana','Juan Luis Guedes Vizcaíno','1','626481048'),(15,'Aguacana','Pedro Monzón Martell','1','616538959'),(16,'Aguacana','Rodolfo Santiago Gómez Yanes','1','690273654'),(17,'Aguacana','Erke Manuel Pérez García','1','661960287'),(18,'Aguacana','Christian Navarro Amador','1','672095603'),(19,'Aguas de Teror','Gustavo Santana Rivero','1','661981826'),(20,'Aguas de Teror','Misael Noel Cabrera','1','610038392'),(21,'Aguas de Teror','F. Javier Medina Sánchez','1','620420128'),(22,'Aguas de Teror','Eliovel Santana Vega','1','606264410'),(23,'Aguas de Teror','Acaimo Martín Valle','1','680450266'),(24,'Aguas de Teror','Carmelo Santana Artiles','1','661913062'),(25,'Aguas de Teror','Yeray Dávila Peña','1','646321951'),(26,'Aguas de Teror','Marcos Dávila Peña','1','617424126'),(27,'Aguas de Teror','Francisco Javier Mayor Jiménez','1','654458473'),(28,'Aguas de Teror','Eugenio Peñate Sánchez','1','619077294'),(29,'Aguas de Teror','Francisco López González','1','636867776'),(30,'Aguas de Teror','José María Reina Suárez','1','658398442'),(31,'Aguas de Teror','Miguel Ángel Santiago Melián','1','692325723'),(32,'Aguas de Teror','Alberto Cruz Marrero','1','639973611'),(33,'Aguas de Teror','Enrique Méndez Ramírez','1','656233271'),(34,'Tropical','Fran / Alexis Morales González','1','690873230'),(35,'Hormigonera','Antonio Hernández Marcial','1','616414085'),(36,'Hormigonera','Andrés Hernández Marcial','1','616538514'),(37,'Hormigonera','Francisco Hernández Marcial','1','669905123'),(38,'Hormigonera','Manuel Reyes Domínguez García','2','620812321'),(39,'Hormigonera','Alejandro Marichal Pérez','1','669862579'),(40,'Ahembo (Jufortrans Canarias S.L.)','Alejandro Álamo','4','649987853'),(41,'ISPEP (Ahembo)','Bartolomé Ramírez','4','669936557'),(42,'Ahembo (Benítez Mayor S.L.)','Juan Manuel Beniítez Jiménez','2','665273641'),(43,'Ahembo (Benítez Jiménez S.L.)','Javier Benítez Jiménez','1','645253166'),(44,'Minibuses (BUS EXPRESS PARKIN S.L.)','Francisco Ramírez Ortega','2','676533950'),(45,'Ahembo 90','Ahembo 90','1',''),(46,'SPAR (Supermercados Canarias)','Supermercados Canarias','1',''),(47,'Arístides Padrón 91','Arístides Padrón','1','');
/*!40000 ALTER TABLE `propietarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id_usuario` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `rol` enum('ROLE_ADMIN','ROLE_USER') COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `telefono` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'hong','$2a$10$XkFmMLrnMx8vXLzpIhdeIu6umB/CvWNQeO2BXuZqSAXLqWyOK.UCe','ROLE_ADMIN',NULL),(2,'usuario1','$2a$10$7HrFwOjLjJcC7ra5Op.F7O9hg4D00I/YYGdgWh0pBQM.jdNfUZATi','ROLE_USER',NULL),(3,'yaima','$2a$10$0LPDC/ae4jxjO4U1cPRcwOYdk13x2yxqFoMCFh0aQpYi2PwhYdFaW','ROLE_USER',NULL),(4,'maivis','$2a$10$4ICKfaomsIIpKVeE/nkIgu3RlNebZpuDxlNHrai/ph8K2ktwvEJH2','ROLE_USER',NULL),(5,'pedro','$2a$10$.3HNadQiatK/6n/t3lKvv.nzey1tMBz39D5FEq2eBYUuD6CWjpGaK','ROLE_ADMIN',NULL),(6,'vanesa','$2a$10$EpEDQMJl/nB0OiDKLabLUOs8nnBM75DvzT3bWj8tiAlYFyckLVjyO','ROLE_ADMIN',NULL),(7,'tania','$2a$10$VG/wobf9k2s8UEmlXvBEVOXVDOadu1ZFO2/AR9FyQkprlOB1W0QKq','ROLE_USER',NULL);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculos`
--

DROP TABLE IF EXISTS `vehiculos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehiculos` (
  `cod_vehiculo` bigint NOT NULL AUTO_INCREMENT,
  `matricula` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `num_aparcamiento` int DEFAULT NULL,
  `observaciones` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `id_propietario` bigint DEFAULT NULL,
  PRIMARY KEY (`cod_vehiculo`),
  KEY `fk_propietario` (`id_propietario`),
  CONSTRAINT `fk_propietario` FOREIGN KEY (`id_propietario`) REFERENCES `propietarios` (`id_propietario`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculos`
--

LOCK TABLES `vehiculos` WRITE;
/*!40000 ALTER TABLE `vehiculos` DISABLE KEYS */;
INSERT INTO `vehiculos` VALUES (1,'5114-KWK',73,'',1),(2,'1254-CFJ',74,'',1),(3,'3230-CPJ',75,'',1),(4,'3114 DLZ',0,'',1),(5,'4563 DZY',0,'',2),(6,'7533 MBB',0,'',2),(7,'1169 KHJ',0,'',2),(8,'6300 KHJ',57,'',3),(9,'M 4637 EP',58,'',3),(10,'1669 LFB',59,'',3),(11,'7041 HTS',83,'',4),(12,'8039 KRJ',84,'',4),(13,'3820 DHM',85,'',4),(14,'3060 CI',86,'',4),(15,'1870 JYZ',72,'',5),(16,'1537 HYJ',17,'',6),(17,'R 9945 BBP',68,'',7),(18,'1222 CFJ',69,'',7),(19,'V 1221 OR',70,'',7),(20,'R 4585 BBL',71,'',7),(21,'7837 HZN',76,'',8),(22,'0207 JZY',77,'',8),(23,'8541 HVG',80,'',8),(25,'6515 DCB',61,'',9),(26,'2490 FRN',60,'',9),(27,'3338 CVZ',62,'',9),(28,'7205 CVF',63,'',9),(29,'0998 DRK',34,'',10),(30,'0954 KTV',35,'',10),(31,'7789 FTC',15,'',11),(32,'4718 CJ',16,'',11),(33,'8569 LMF',30,'',12),(34,'7092 LZD',31,'',12),(35,'8564 MBH',32,'',12),(36,'8969 LMF',33,'',12),(37,'2289 HZC',50,'',13),(38,'5695 JJT',49,'',13),(39,'0845 JSV',48,'',13),(40,'7818 JHV',47,'',13),(41,'4444 KYK',46,'',13),(42,'9605 GHY',46,'',13),(43,'4663 CC',2,'',14),(44,'9419 BFF',5,'',15),(45,'5909 BN',4,'',16),(46,'6450 CMM',1,'',17),(47,'4349 BM',29,'',18),(48,'8841 BL',11,'',19),(49,'3532 CB',6,'',20),(50,'9294 CLV',10,'',21),(51,'2989 BL',9,'',22),(52,'2766 DBN',21,'',23),(53,'4707 BDT',7,'',24),(54,'8565 UN',14,'',25),(55,'0243 CKD',13,'',26),(56,'1881 BM',28,'',27),(57,'4188 DGK',12,'',28),(58,'8641 BY',54,'',29),(59,'8400 CC',3,'',30),(60,'7070 CG',64,'',31),(61,'2230 BG / 6556',56,'',32),(62,'6336 CF',53,'',33),(63,'8558 BU',65,'',34),(65,'0097 CF',20,'',36),(66,'3280 BNX',18,'',37),(67,'3282 BNX',19,'',35),(68,'5375 CFF',52,'',38),(69,'7589 FFY',78,'',39),(70,'2969 BG',45,'',40),(71,'9494 DDT',44,'',40),(72,'9911 CLS',51,'',40),(73,'0805 BJ',55,'',40),(74,'4946 BH',55,'',40),(75,'4892 AV',25,'',41),(76,'4890 AV',26,'',41),(77,'4891 AV',27,'',41),(78,'4889 AV',66,'',41),(79,'8559 BH',23,'',42),(80,'2554 BJ',24,'',42),(81,'5576 BJ',22,'',43),(82,'8505 JLM',87,'',44),(83,'2806 GDY',88,'',44),(84,'4338 FKL',90,'',45),(85,'0045 BL',92,'',46),(86,'0714 LHG',91,'',47),(87,'4332 CM',91,'',47),(88,'3216 HJV',91,'',47);
/*!40000 ALTER TABLE `vehiculos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-06 22:34:11
