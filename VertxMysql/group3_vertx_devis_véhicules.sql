-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: group3_vertx
-- ------------------------------------------------------
-- Server version	5.7.12-log

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
-- Table structure for table `devis_véhicules`
--

DROP TABLE IF EXISTS `devis_véhicules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `devis_véhicules` (
  `id_devis_habitation` int(11) NOT NULL,
  `nom` varchar(45) DEFAULT NULL,
  `prenom` varchar(45) DEFAULT NULL,
  `nom_devis` varchar(45) DEFAULT NULL,
  `marque` varchar(45) DEFAULT NULL,
  `modele` varchar(45) DEFAULT NULL,
  `carburant` varchar(45) DEFAULT NULL,
  `chevaux` int(11) DEFAULT NULL,
  `date_permis` datetime DEFAULT NULL,
  `nombre_accident` int(11) DEFAULT NULL,
  `bonus_malus` varchar(45) DEFAULT NULL,
  `conducteur_principal` varchar(45) DEFAULT NULL,
  `conducteur_secondaire` varchar(45) DEFAULT NULL,
  `dors_garage` int(11) DEFAULT NULL,
  `adresse` varchar(45) DEFAULT NULL,
  `resume_devis` varchar(45) DEFAULT NULL,
  `tous_risques` varchar(45) DEFAULT NULL,
  `au_tier` int(11) DEFAULT NULL,
  `montant_devis` int(11) DEFAULT NULL,
  `id_user_habitation` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_devis_habitation`),
  KEY `id_user_idx` (`id_user_habitation`),
  CONSTRAINT `id_user_habitation` FOREIGN KEY (`id_user_habitation`) REFERENCES `user` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `devis_véhicules`
--

LOCK TABLES `devis_véhicules` WRITE;
/*!40000 ALTER TABLE `devis_véhicules` DISABLE KEYS */;
/*!40000 ALTER TABLE `devis_véhicules` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-11 19:02:57
