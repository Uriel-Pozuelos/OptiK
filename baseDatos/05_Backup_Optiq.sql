-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: optiqalumnos
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `accesorio`
--

DROP TABLE IF EXISTS `accesorio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accesorio` (
  `idAccesorio` int NOT NULL AUTO_INCREMENT,
  `idProducto` int NOT NULL,
  PRIMARY KEY (`idAccesorio`),
  KEY `fk_accesorio_producto` (`idProducto`),
  CONSTRAINT `fk_accesorio_producto` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accesorio`
--

LOCK TABLES `accesorio` WRITE;
/*!40000 ALTER TABLE `accesorio` DISABLE KEYS */;
INSERT INTO `accesorio` VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(9,8),(17,17),(18,18),(19,19),(20,20);
/*!40000 ALTER TABLE `accesorio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `armazon`
--

DROP TABLE IF EXISTS `armazon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `armazon` (
  `idArmazon` int NOT NULL AUTO_INCREMENT,
  `idProducto` int NOT NULL,
  `modelo` varchar(129) NOT NULL,
  `color` varchar(65) NOT NULL,
  `dimensiones` varchar(33) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `fotografia` longtext NOT NULL,
  PRIMARY KEY (`idArmazon`),
  KEY `fk_armazon_producto` (`idProducto`),
  CONSTRAINT `fk_armazon_producto` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `armazon`
--

LOCK TABLES `armazon` WRITE;
/*!40000 ALTER TABLE `armazon` DISABLE KEYS */;
INSERT INTO `armazon` VALUES (7,7,'x96','blanco','12x12','es un lindo armazon de lentes','foto'),(8,8,'m09','gris','12x12','es un lindo armazon de lentes','foto.jpg'),(9,9,'m09','azul','12x12','es un lindo armazon de lentes','foto.jpg'),(10,10,'m09','marron','12x12','es un lindo armazon de lentes','foto.jpg'),(11,11,'M0P','morado','12x12','es un lindo armazon de lentes','foto.jpg'),(12,12,'M0P','negro','12x12','es un lindo armazon de lentes','foto.jpg'),(13,13,'M0P','rosa','12x12','es un lindo armazon de lentes','foto.jpg'),(14,14,'M0P','rosa,morado','12x12','es un lindo armazon de lentes','foto.jpg'),(15,15,'M0P','transparente','12x12','es un lindo armazon de lentes','foto.jpg');
/*!40000 ALTER TABLE `armazon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bitacora`
--

DROP TABLE IF EXISTS `bitacora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bitacora` (
  `idBitacora` int NOT NULL AUTO_INCREMENT,
  `idConductor` int NOT NULL,
  `fecha` datetime DEFAULT NULL,
  `placa` varchar(20) DEFAULT NULL,
  `lastTicket` int DEFAULT NULL,
  PRIMARY KEY (`idBitacora`),
  KEY `bitacora` (`idConductor`),
  CONSTRAINT `bitacora_ibfk_1` FOREIGN KEY (`idConductor`) REFERENCES `conductor` (`idConductor`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bitacora`
--

LOCK TABLES `bitacora` WRITE;
/*!40000 ALTER TABLE `bitacora` DISABLE KEYS */;
INSERT INTO `bitacora` VALUES (2,1,'2022-11-09 14:32:26','bhsah78',123);
/*!40000 ALTER TABLE `bitacora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `idCliente` int NOT NULL AUTO_INCREMENT,
  `idPersona` int NOT NULL,
  `numeroUnico` varchar(65) NOT NULL DEFAULT '',
  `estatus` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`idCliente`),
  KEY `fk_cliente_persona` (`idPersona`),
  CONSTRAINT `fk_cliente_persona` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (28,28,'fd378d94333706723599251f1fb2c9eb',1),(29,29,'6h378d940307c67h3599l51f1fb2c9eb',1),(30,30,'6hb78d9d9407c6hh35v0l51f1fb5c90l',1),(31,31,'6hb78d0d9407c67h35v0l51f1fb5c90l',0),(32,32,'6hb70d0d9407c67h35v0l51f1fb5c90l',0),(33,33,'6hb70d0d9407c67h35v0l51f1fb5c90l',0),(34,34,'6hp70dld9407h67h98v0l51f1fb5c90l',0),(35,35,'6hp70dld9407h67h98v0l51f1fb5c90l',0);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compra` (
  `idCompra` int NOT NULL AUTO_INCREMENT,
  `idEmpleado` int NOT NULL,
  PRIMARY KEY (`idCompra`),
  KEY `fk_compra_empleado` (`idEmpleado`),
  CONSTRAINT `fk_compra_empleado` FOREIGN KEY (`idEmpleado`) REFERENCES `empleado` (`idEmpleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra_producto`
--

DROP TABLE IF EXISTS `compra_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compra_producto` (
  `idCompra` int NOT NULL,
  `idProducto` int NOT NULL,
  `precioUnitario` double NOT NULL,
  `cantidad` int NOT NULL,
  KEY `fk_compraproducto_compra` (`idCompra`),
  KEY `fk_compraproducto_producto` (`idProducto`),
  CONSTRAINT `fk_compraproducto_compra` FOREIGN KEY (`idCompra`) REFERENCES `compra` (`idCompra`),
  CONSTRAINT `fk_compraproducto_producto` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra_producto`
--

LOCK TABLES `compra_producto` WRITE;
/*!40000 ALTER TABLE `compra_producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `compra_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conductor`
--

DROP TABLE IF EXISTS `conductor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `conductor` (
  `idConductor` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) DEFAULT NULL,
  `ape_paterno` varchar(40) DEFAULT NULL,
  `ape_materno` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`idConductor`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conductor`
--

LOCK TABLES `conductor` WRITE;
/*!40000 ALTER TABLE `conductor` DISABLE KEYS */;
INSERT INTO `conductor` VALUES (1,'jose','gomez','perez');
/*!40000 ALTER TABLE `conductor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `idEmpleado` int NOT NULL AUTO_INCREMENT,
  `idPersona` int NOT NULL,
  `idUsuario` int NOT NULL,
  `numeroUnico` varchar(65) NOT NULL DEFAULT '',
  `estatus` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`idEmpleado`),
  KEY `fk_empleado_persona` (`idPersona`),
  KEY `fk_empleado_usuario` (`idUsuario`),
  CONSTRAINT `fk_empleado_persona` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`),
  CONSTRAINT `fk_empleado_usuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (1,6,4,'f8eb22b3aa2302cd95dbf89be1914e0c',0),(2,9,7,'fd378d94333706723599251f1fb2c0eb',0),(3,10,8,'1fb8df4f7569f08c5469f0eb2f624a1e',0),(4,11,9,'b31a622cbf7ec7031db13f6b3cc71cc3',1),(5,12,10,'6f5c767cc47630a4a476ba71ba3524e1',0),(6,13,11,'fe73ea70b466b82fd468defc0d47ded4',1),(7,14,12,'35c2fff8768b3228b30582d126e4ea03',1),(8,15,13,'f4275c5e581093de4afa8a685901ddf1',0),(9,18,16,'3b64e55531f682df38f13b0ee015e653',0),(10,20,18,'59085499ef319d0acd0733e094774d80',0),(11,21,19,'878ba1d4c18100c4845e13f13548f6a1',0),(12,22,20,'87504c790c4fee2733ce5c79c3b5df25',0),(13,23,21,'3aa905b5749d463fae3256ac0f2706d8',0),(14,37,26,'31998c8469edbf01d2542df52a86648c',0),(15,38,27,'9a1ad8ddcd56acee97bd58891c622f82',1),(16,42,31,'aa421e5a7b0bc6325e352124f303eecf',0),(17,44,33,'3d786852143f90ad370b52295b0b5c96',1),(18,47,36,'ba5dca8800e034f00b461b830ac6fb00',0),(19,48,37,'0e4e513a88aaeb540a83748e86b18408',1),(20,49,38,'0811b370c4bc8cc384707fec82beca04',1),(21,50,39,'11f8b01af70320c9103da92b0270e35d',1),(22,53,42,'91346a205663e6fa5ed0c94a7b8bab9d',0),(23,54,43,'1660084c26f0d7bc8afd63fb77e9e8d9',1);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examen_vista`
--

DROP TABLE IF EXISTS `examen_vista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `examen_vista` (
  `idExamenVista` int NOT NULL AUTO_INCREMENT,
  `clave` varchar(48) DEFAULT '',
  `idEmpleado` int NOT NULL,
  `idCliente` int NOT NULL,
  `idGraduacion` int NOT NULL,
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`idExamenVista`),
  KEY `fk_examenvista_empleado` (`idEmpleado`),
  KEY `fk_examenvista_cliente` (`idCliente`),
  KEY `fk_examenvista_graduacion` (`idGraduacion`),
  CONSTRAINT `fk_examenvista_cliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`),
  CONSTRAINT `fk_examenvista_empleado` FOREIGN KEY (`idEmpleado`) REFERENCES `empleado` (`idEmpleado`),
  CONSTRAINT `fk_examenvista_graduacion` FOREIGN KEY (`idGraduacion`) REFERENCES `graduacion` (`idGraduacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examen_vista`
--

LOCK TABLES `examen_vista` WRITE;
/*!40000 ALTER TABLE `examen_vista` DISABLE KEYS */;
/*!40000 ALTER TABLE `examen_vista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `graduacion`
--

DROP TABLE IF EXISTS `graduacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `graduacion` (
  `idGraduacion` int NOT NULL AUTO_INCREMENT,
  `esferaod` double NOT NULL DEFAULT '0',
  `esferaoi` double NOT NULL DEFAULT '0',
  `cilindrood` int NOT NULL DEFAULT '0',
  `cilindrooi` int NOT NULL DEFAULT '0',
  `ejeoi` int NOT NULL DEFAULT '0',
  `ejeod` int NOT NULL DEFAULT '0',
  `dip` varchar(13) NOT NULL DEFAULT '0 / 0',
  PRIMARY KEY (`idGraduacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `graduacion`
--

LOCK TABLES `graduacion` WRITE;
/*!40000 ALTER TABLE `graduacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `graduacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lente_contacto`
--

DROP TABLE IF EXISTS `lente_contacto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lente_contacto` (
  `idLenteContacto` int NOT NULL AUTO_INCREMENT,
  `idProducto` int NOT NULL,
  `keratometria` int NOT NULL DEFAULT '0',
  `fotografia` longtext NOT NULL,
  PRIMARY KEY (`idLenteContacto`),
  KEY `fk_lentecontacto_producto` (`idProducto`),
  CONSTRAINT `fk_lentecontacto_producto` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lente_contacto`
--

LOCK TABLES `lente_contacto` WRITE;
/*!40000 ALTER TABLE `lente_contacto` DISABLE KEYS */;
INSERT INTO `lente_contacto` VALUES (1,31,60,'foto.jpg'),(2,32,60,'foto.jpg'),(3,33,60,'foto.jpg'),(4,34,60,'foto.jpg'),(5,35,60,'foto.jpg'),(6,36,60,'foto.jpg'),(7,37,60,'foto.jpg'),(8,38,60,'foto.jpg'),(9,39,60,'foto.jpg'),(10,40,60,'foto.jpg'),(11,41,60,'foto.jpg'),(12,42,60,'foto.jpg');
/*!40000 ALTER TABLE `lente_contacto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `material` (
  `idMaterial` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(129) NOT NULL DEFAULT '',
  `precioCompra` double NOT NULL DEFAULT '0',
  `precioVenta` double NOT NULL DEFAULT '0',
  `estatus` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`idMaterial`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
INSERT INTO `material` VALUES (1,'Cr',0,0,1),(2,'Cristal',0,0,1),(3,'Polarizado',0,0,1),(4,'Policarbonato',0,0,1),(5,'antireflejo',0,0,0),(6,'Cuarzo',0,0,0),(7,'carbono',0,0,0),(8,'plastico',0,0,0);
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `idPersona` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellidoPaterno` varchar(40) NOT NULL,
  `apellidoMaterno` varchar(40) NOT NULL DEFAULT '',
  `genero` varchar(2) NOT NULL DEFAULT 'O',
  `fechaNacimiento` date NOT NULL,
  `calle` varchar(129) NOT NULL DEFAULT '',
  `numero` varchar(20) NOT NULL DEFAULT '',
  `colonia` varchar(40) NOT NULL DEFAULT '',
  `cp` varchar(25) NOT NULL DEFAULT '',
  `ciudad` varchar(40) NOT NULL DEFAULT '',
  `estado` varchar(40) NOT NULL DEFAULT '',
  `telcasa` varchar(20) NOT NULL DEFAULT '',
  `telmovil` varchar(20) NOT NULL DEFAULT '',
  `email` varchar(129) NOT NULL DEFAULT '',
  PRIMARY KEY (`idPersona`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'Administrador','-','-','O','1901-01-01','','','','','','','','',''),(2,'Administrador','-','-','O','1901-01-01','','','','','','','','',''),(3,'Administrador','-','-','O','1901-01-01','','','','','','','','',''),(4,'Administrador','-','-','O','1901-01-01','','','','','','','','',''),(5,'Administrador','-','-','O','1901-01-01','','','','','','','','',''),(6,'Administrador','-','-','O','1901-01-01','','','','','','','','',''),(7,'Adminaistrador','-','-','O','1901-01-01','a','a','a','a','a','a','a','a','a'),(8,'Adminaitrador','-','-','O','1901-01-01','a','a','a','a','a','a','a','a','a'),(9,'Adminaitrador','-','-','O','1901-01-01','a','a','a','a','a','a','a','a','a'),(10,'Uriel','Hernandez','Garcia','M','1901-01-01','Calle 1','123','Colonia 1','12345','Ciudad 1','','1234567890','1234567890','urieher'),(11,'Ivan','Mancilla','Ulloa','','1901-01-01','Hermenegildo Bustos','921','Jardines de la Pradera','37570','Leon','Guanajuato','4777060950','47732347482','21000403@utleon.edu.mx'),(12,'Ivan','Mancilla','Ulloa','H','1901-01-01','Hermenegildo Bustos','921','Jardines de la Pradera','37570','Leon','Guanajuato','4777060950','47732347482','21000s403@utleon.edu.mx'),(13,'Abril','Guerrero','Torres','M','1901-01-01','av. palma','123','angular','343556','Guanajuato','Guanajuato','4271252416','4271252416','abril@gmail.com'),(14,'raquel','mendez','gutierrez','F','1901-01-01','guana','56','guana','767978','Guanajuato','Guanajuato','7898978','34788','raquel@gmail.com'),(15,'gustavo','','','M','1901-01-01','','','','','','','','',''),(16,'jose','','','M','1901-01-01','','','','','','','','',''),(17,'jose','','','M','1901-01-01','','','','','','','','',''),(18,'jose','jkjJ','hjj','M','1901-01-01','fhgf','67','fggf','ghfh78','jgfhgh','hfghf','676','677','fgh@gmail.com'),(19,'karol','','','M','1901-01-01','','','','','','','','',''),(20,'liz','n','n','F','1901-01-01','j','1','j','k','k','k','1','1','j'),(21,'KOLL','j','j','M','1901-01-01','1','1','1','1','1','1','1','1','1'),(22,'a','s','d','M','1901-01-01','9','7','7','7','g','l','','7','a@a.com'),(23,'hgg','2','2','M','1901-01-01','2','2','2','2','2','2','22','2','2'),(24,'hgg','2','2','M','1901-01-01','2','2','2','2','2','2','22','2','2'),(25,'hgg','2','2','M','1901-01-01','2','2','2','2','2','2','22','2','2'),(26,'','','','M','1901-01-01','','','','','','','','',''),(28,'jonathan','rodriguez','hernandez','M','2003-02-03','santa clara','145','hacienda','36126','silao','guanajuato','472592426','4721592416','urieher@gmail.com'),(29,'brenda esmeralda','gutierrez','perez','F','2003-07-27','freco','139','fresno','36126','silao','guanajuato','4721809016','4721592416','es.bren.27.p@gmail.com'),(30,'Andres','Caudillo','Hernandez','M','2003-01-05','bajio','7','bajio','36120','silao','guanajuato','4720909123','4721991006','caduAnp@gmail.com'),(31,'Melisa','Caudillo','Hernandez','M','2007-09-15','bajio','7','bajio','36120','silao','guanajuato','4720909123','4721991006','meli@gmail.com'),(32,'Daniela','Caudillo','Hernandez','F','2004-08-05','bajio','7','bajio','36120','silao','guanajuato','4720109423','4723961006','dani_09@gmail.com'),(33,'Gustavo','Pallares','Fernandez','O','2000-01-01','leon','9','leon','46120','leon','guanajuato','4770099423','4773961226','Gustares@gmail.com'),(34,'Sandra','Pallares','Fernandez','O','1998-04-09','leon','9','leon','46120','leon','guanajuato','4770099423','4773961226','SanPaNan@gmail.com'),(35,'Monica','Pallares','Fernandez','O','2005-04-09','leon','9','leon','46120','leon','guanajuato','4770099423','4773961226','9090909@gmail.com'),(36,'Daniel','perez','rojas','O','1901-01-01','','','','','','','','',''),(37,'Juan Manuel','perez','rojas','O','1901-01-01','23','santa maria','leon','210909','leon','guanajuato','4771234567','4771234567','pepe@gmail'),(38,'Maria','perez','rojas','O','1901-01-01','23','santa maria','leon','210909','leon','guanajuato','4771234567','4771234567','pepe@gmail'),(39,'Maria','perez','rojas','O','1901-01-01','23','89','leon','210909','leon','guanajuato','4771234567','4771234567','Maria@gmail'),(40,'Maria','perez','rojas','O','1901-01-01','23','89','leon','210909','leon','guanajuato','4771234567','4771234567','Maria@gmail'),(41,'Juan Manuel','perez','rojas','O','1901-01-01','23','','leon','210909','leon','guanajuato','4771234567','4771234567','pepe@gmail'),(42,'Ana','Kar','Pez','F','1901-01-01','Calle 2','123','Centro','90000','Lop','Guanajuato','47777777','477777777','correoana@gmail.com'),(43,'Lizbeth','garnica','negrete','F','1901-01-01','23','santa maria','leon','210909','leon','guanajuato','4771234567','4771234567','pepe@gmail'),(44,'Liz','Garnica','Negrete','F','1901-01-01','santa maria','23','leon','210909','leon','Estado de México','4771234567','4771234567','pepe@gmail.com'),(45,'k','k','k','M','1901-01-01','2','2','2','2','2','2','1','2','2'),(46,'nose','l','l','O','1901-01-01','l','','l','l','l','l','','','l'),(47,'Arturo','qwer','wew','M','1901-01-01','ewe','13','ewe','12','ddss','','34','34','ewe'),(48,'carmen','Urtado','ui','M','1901-01-01','qwert','23','ty','123f','sas','Guanajuato','23','23','nose@gmail.com'),(49,'Dalio','pers','sasa','M','1991-01-01','sa','12','12','12','12','12','123','123','nose@gmail.cmo'),(50,'Vanessa','Leon','Rodriguez','F','2022-11-16','calle','1','no','123','no','Ciudad de México','21000014','21000014','21@gmail.com'),(51,'Vanessa','Leon','Rodriguez','F','1901-01-01','calle','1','no','123','no','nk','21000014','21000014','21@gmail.com'),(52,'Vanessa','Leon','Rodriguez','F','1901-01-01','calle','1','no','123','no','nk','21000014','21000014','21@gmail.com'),(53,'armosl','d','d','M','1901-01-01','sanra','67','no','90','Leon','Guanajuato','234','343','nose@gmail.com'),(54,'Vanessa','Leon','Rodriguez','F','1901-01-01','calle','1','no','123','no','Ciudad de México','21000014','21000014','21@gmail.com'),(55,'Vanessa','Leon','Rodriguez','F','1901-01-01','calle','1','no','123','no','Ciudad de México','21000014','21000014','21@gmail.com');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `presupuesto`
--

DROP TABLE IF EXISTS `presupuesto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `presupuesto` (
  `idPresupuesto` int NOT NULL AUTO_INCREMENT,
  `idExamenVista` int NOT NULL,
  `clave` varchar(65) DEFAULT NULL,
  PRIMARY KEY (`idPresupuesto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `presupuesto`
--

LOCK TABLES `presupuesto` WRITE;
/*!40000 ALTER TABLE `presupuesto` DISABLE KEYS */;
/*!40000 ALTER TABLE `presupuesto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `presupuesto_lentes`
--

DROP TABLE IF EXISTS `presupuesto_lentes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `presupuesto_lentes` (
  `idPresupuestoLentes` int NOT NULL AUTO_INCREMENT,
  `idPresupuesto` int NOT NULL,
  `alturaOblea` int NOT NULL DEFAULT '0',
  `idTipoMica` int NOT NULL,
  `idMaterial` int NOT NULL,
  `idArmazon` int NOT NULL,
  PRIMARY KEY (`idPresupuestoLentes`),
  KEY `fk_presupuestolentes_presupuesto` (`idPresupuesto`),
  KEY `fk_presupuestolentes_tipomica` (`idTipoMica`),
  KEY `fk_presupuestolentes_material` (`idMaterial`),
  KEY `fk_presupuestolentes_armazon` (`idArmazon`),
  CONSTRAINT `fk_presupuestolentes_armazon` FOREIGN KEY (`idArmazon`) REFERENCES `armazon` (`idArmazon`),
  CONSTRAINT `fk_presupuestolentes_material` FOREIGN KEY (`idMaterial`) REFERENCES `material` (`idMaterial`),
  CONSTRAINT `fk_presupuestolentes_presupuesto` FOREIGN KEY (`idPresupuesto`) REFERENCES `presupuesto` (`idPresupuesto`),
  CONSTRAINT `fk_presupuestolentes_tipomica` FOREIGN KEY (`idTipoMica`) REFERENCES `tipo_mica` (`idTipoMica`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `presupuesto_lentes`
--

LOCK TABLES `presupuesto_lentes` WRITE;
/*!40000 ALTER TABLE `presupuesto_lentes` DISABLE KEYS */;
/*!40000 ALTER TABLE `presupuesto_lentes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `presupuesto_lentes_tratamientos`
--

DROP TABLE IF EXISTS `presupuesto_lentes_tratamientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `presupuesto_lentes_tratamientos` (
  `idPresupuestoLentes` int NOT NULL,
  `idTratamiento` int NOT NULL,
  KEY `fk_presupuesto_presupuestolentes` (`idPresupuestoLentes`),
  KEY `fk_presupuesto_tratamiento` (`idTratamiento`),
  CONSTRAINT `fk_presupuesto_presupuestolentes` FOREIGN KEY (`idPresupuestoLentes`) REFERENCES `presupuesto_lentes` (`idPresupuestoLentes`),
  CONSTRAINT `fk_presupuesto_tratamiento` FOREIGN KEY (`idTratamiento`) REFERENCES `tratamiento` (`idTratamiento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `presupuesto_lentes_tratamientos`
--

LOCK TABLES `presupuesto_lentes_tratamientos` WRITE;
/*!40000 ALTER TABLE `presupuesto_lentes_tratamientos` DISABLE KEYS */;
/*!40000 ALTER TABLE `presupuesto_lentes_tratamientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `presupuesto_lentescontacto`
--

DROP TABLE IF EXISTS `presupuesto_lentescontacto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `presupuesto_lentescontacto` (
  `idPresupuestoLentesContacto` int NOT NULL AUTO_INCREMENT,
  `idExamenVista` int NOT NULL,
  `idLenteContacto` int NOT NULL,
  `clave` varchar(65) DEFAULT NULL,
  PRIMARY KEY (`idPresupuestoLentesContacto`),
  KEY `fk_presupuestolentescontacto_examenvista` (`idExamenVista`),
  KEY `fk_presupuestolentescontacto_lentecontacto` (`idLenteContacto`),
  CONSTRAINT `fk_presupuestolentescontacto_examenvista` FOREIGN KEY (`idExamenVista`) REFERENCES `examen_vista` (`idExamenVista`),
  CONSTRAINT `fk_presupuestolentescontacto_lentecontacto` FOREIGN KEY (`idLenteContacto`) REFERENCES `lente_contacto` (`idLenteContacto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `presupuesto_lentescontacto`
--

LOCK TABLES `presupuesto_lentescontacto` WRITE;
/*!40000 ALTER TABLE `presupuesto_lentescontacto` DISABLE KEYS */;
/*!40000 ALTER TABLE `presupuesto_lentescontacto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `idProducto` int NOT NULL AUTO_INCREMENT,
  `codigoBarras` varchar(65) NOT NULL DEFAULT '',
  `nombre` varchar(255) NOT NULL,
  `marca` varchar(129) NOT NULL,
  `precioCompra` double NOT NULL DEFAULT '0',
  `precioVenta` double NOT NULL DEFAULT '0',
  `existencias` int NOT NULL DEFAULT '1',
  `estatus` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`idProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'123','lente','joff',23,50,5,1),(2,'1235','mica','joff',28,50,5,1),(3,'123578','color','miracle',50,100,9,1),(4,'123578676','funda','xio',100,150,2,1),(5,'1234578676','funda brillante','xio',150,220,2,1),(6,'1234578676','limpiador','xioma',150,220,2,0),(7,'128978676','armazon blanco','army',120,200,2,1),(8,'128978679','armazon gris','army',120,200,2,1),(9,'128978679','armazon azul','army',120,200,2,1),(10,'128978679','armazon marron','army',120,200,2,1),(11,'128938679','armazon morado','army',120,200,2,1),(12,'128938679','armazon simple','army',120,200,0,0),(13,'138938669','armazon rosa','army',120,200,0,0),(14,'138938669','armazon mariposa','army',120,200,0,0),(15,'138938669','armazon transparente','army',120,200,0,0),(16,'1934501676','funda animada','xio',200,250,0,0),(17,'1934501676','funda animada','xio',200,250,0,0),(18,'1934501676','funda roja','xio',50,70,0,0),(19,'1030501676','limpiador blanco','xio',50,70,0,0),(20,'1030501676','limpiador gris','xio',150,170,0,0),(21,'90378378','solucion 1','soluciones maria',50,70,7,0),(22,'10370378','solucion 2','soluciones maria',50,70,7,0),(23,'11340378','solucion 3','soluciones maria',50,70,7,0),(24,'11340379','solucion 4','soluciones maria',50,70,7,0),(25,'11340380','solucion 4','soluciones maria',50,70,7,0),(26,'11340381','solucion 6','soluciones maria',50,70,7,0),(27,'11340382','solucion 7','soluciones maria',50,70,7,0),(28,'11340382','solucion 8','soluciones maria',50,70,7,0),(29,'11340382','solucion 9','soluciones maria',50,70,7,0),(30,'11340383','solucion 10','soluciones maria',50,70,7,0),(31,'11340384','lente azul','eyeSoul',550,770,9,1),(32,'11340385','lente verde','eyeSoul',550,770,9,1),(33,'11340386','lente natural','eyeSoul',550,770,9,1),(34,'11340387','lente contacto','eyeSoul',550,770,9,1),(35,'11340388','lente contacto azul','eyeSoul',550,770,9,1),(36,'11340389','lente contacto naranja','eyeSoul',550,770,9,1),(37,'11340390','lente contacto l','eyeSoul',550,770,9,1),(38,'11340390','lente contacto l','eyeSoul',550,770,9,0),(39,'113403901','lente contacto gris','eyeSoul',550,770,9,0),(40,'113403901','lente contacto gris','eyeSoul',550,770,9,0),(41,'113403902','lente contacto simple','eyeSoul',550,770,9,0),(42,'113403903','lente contacto morado','eyeSoul',550,770,9,0);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solucion`
--

DROP TABLE IF EXISTS `solucion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `solucion` (
  `idSolucion` int NOT NULL AUTO_INCREMENT,
  `idProducto` int NOT NULL,
  `estatus` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`idSolucion`),
  KEY `fk_solucion_producto` (`idProducto`),
  CONSTRAINT `fk_solucion_producto` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solucion`
--

LOCK TABLES `solucion` WRITE;
/*!40000 ALTER TABLE `solucion` DISABLE KEYS */;
INSERT INTO `solucion` VALUES (1,21,1),(2,22,1),(3,23,1),(4,24,1),(5,25,1),(6,26,0),(7,27,0),(8,28,0),(9,29,0),(10,30,0);
/*!40000 ALTER TABLE `solucion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_mica`
--

DROP TABLE IF EXISTS `tipo_mica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_mica` (
  `idTipoMica` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(129) NOT NULL DEFAULT '',
  `precioCompra` double NOT NULL DEFAULT '0',
  `precioVenta` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`idTipoMica`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_mica`
--

LOCK TABLES `tipo_mica` WRITE;
/*!40000 ALTER TABLE `tipo_mica` DISABLE KEYS */;
INSERT INTO `tipo_mica` VALUES (1,'Bifocal',0,0),(2,'Monofocal',0,0),(3,'Progresivo',0,0);
/*!40000 ALTER TABLE `tipo_mica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tratamiento`
--

DROP TABLE IF EXISTS `tratamiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tratamiento` (
  `idTratamiento` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(129) NOT NULL DEFAULT '',
  `precioCompra` double NOT NULL DEFAULT '0',
  `precioVenta` double NOT NULL DEFAULT '0',
  `estatus` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`idTratamiento`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tratamiento`
--

LOCK TABLES `tratamiento` WRITE;
/*!40000 ALTER TABLE `tratamiento` DISABLE KEYS */;
INSERT INTO `tratamiento` VALUES (1,'Antireflejante básico',0,0,1),(2,'Blue free',0,0,1),(3,'Entintado',0,0,1),(4,'Fotocromático',0,0,1);
/*!40000 ALTER TABLE `tratamiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(129) NOT NULL,
  `contrasenia` varchar(129) NOT NULL,
  `rol` varchar(25) NOT NULL DEFAULT 'Empleado',
  `lastToken` varchar(65) NOT NULL DEFAULT '',
  `dateLastToken` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Administrador','','Administrador','token','2022-10-13 15:20:17'),(4,'Adminstrador','','Adminitrador','token','2022-10-13 15:21:52'),(7,'Adminsrador','','Adminitrador','token','2022-10-13 15:23:05'),(8,'urieher@gmail.com','123456','Administrador','token','2022-10-18 10:15:17'),(9,'Diego','admin','Usuario','token','2022-10-20 10:17:13'),(10,'Diedsgo','admin','Empleado','token','2022-10-20 22:48:46'),(11,'Abril','123456','Usuario','token','2022-10-20 23:00:26'),(12,'Raquel','676756','Administrador','token','2022-10-21 11:19:01'),(13,'','','Administrador','token','2022-10-21 11:20:19'),(16,'jiose','899','Administrador','token','2022-10-21 11:32:47'),(18,'k','k','Administrador','token','2022-10-21 12:09:40'),(19,'1','1','Usuario','token','2022-10-21 12:23:52'),(20,'op','po','Administrador','token','2022-10-21 12:47:04'),(21,'2','2','Administrador','token','2022-10-21 13:12:37'),(26,'Pepe','909090','Administrador','token','2022-11-04 09:37:38'),(27,'mari','909090','Administrador','token','2022-11-04 09:37:56'),(31,'anakar','12345','Usuario','token','2022-11-04 12:12:19'),(33,'lizbeth','Poke89Hui','Administrador','token','2022-11-04 12:22:51'),(36,'fds','dss','Administrador','token','2022-11-05 13:53:54'),(37,'Marce','123','Usuario','token','2022-11-05 14:34:11'),(38,'dalia','sas','Administrador','token','2022-11-05 14:57:01'),(39,'vanesp','Contyr90nhi','Administrador','token','2022-11-07 20:12:23'),(42,'Fernol','Aztraseneca98','Administrador','token','2022-11-07 21:29:09'),(43,'vanesa','Contyr90nhi','Administrador','token','2022-11-08 09:04:39');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `v_bitacora`
--

DROP TABLE IF EXISTS `v_bitacora`;
/*!50001 DROP VIEW IF EXISTS `v_bitacora`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_bitacora` AS SELECT 
 1 AS `idBitacora`,
 1 AS `nombre`,
 1 AS `ape_paterno`,
 1 AS `ape_materno`,
 1 AS `fecha`,
 1 AS `placa`,
 1 AS `lastTicket`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_lentecontacto`
--

DROP TABLE IF EXISTS `v_lentecontacto`;
/*!50001 DROP VIEW IF EXISTS `v_lentecontacto`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_lentecontacto` AS SELECT 
 1 AS `idLenteContacto`,
 1 AS `idProducto`,
 1 AS `keratometria`,
 1 AS `fotografia`,
 1 AS `codigoBarras`,
 1 AS `nombre`,
 1 AS `marca`,
 1 AS `precioCompra`,
 1 AS `precioVenta`,
 1 AS `existencias`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_lentecontacto_inactivos`
--

DROP TABLE IF EXISTS `v_lentecontacto_inactivos`;
/*!50001 DROP VIEW IF EXISTS `v_lentecontacto_inactivos`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_lentecontacto_inactivos` AS SELECT 
 1 AS `idLenteContacto`,
 1 AS `idProducto`,
 1 AS `keratometria`,
 1 AS `fotografia`,
 1 AS `codigoBarras`,
 1 AS `nombre`,
 1 AS `marca`,
 1 AS `precioCompra`,
 1 AS `precioVenta`,
 1 AS `existencias`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta` (
  `idVenta` int NOT NULL AUTO_INCREMENT,
  `idEmpleado` int NOT NULL,
  `clave` varchar(69) NOT NULL,
  PRIMARY KEY (`idVenta`),
  UNIQUE KEY `clave` (`clave`),
  KEY `fk_venta_empleado` (`idEmpleado`),
  CONSTRAINT `fk_venta_empleado` FOREIGN KEY (`idEmpleado`) REFERENCES `empleado` (`idEmpleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta_presupuesto`
--

DROP TABLE IF EXISTS `venta_presupuesto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta_presupuesto` (
  `idVenta` int NOT NULL,
  `idPresupuesto` int NOT NULL,
  `cantidad` int NOT NULL DEFAULT '1',
  `precioUnitario` double NOT NULL,
  `descuento` double NOT NULL,
  KEY `fk_ventapl_venta` (`idVenta`),
  KEY `fk_venta_presupuesto` (`idPresupuesto`),
  CONSTRAINT `fk_venta_presupuesto` FOREIGN KEY (`idPresupuesto`) REFERENCES `presupuesto` (`idPresupuesto`),
  CONSTRAINT `fk_ventapl_venta` FOREIGN KEY (`idVenta`) REFERENCES `venta` (`idVenta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta_presupuesto`
--

LOCK TABLES `venta_presupuesto` WRITE;
/*!40000 ALTER TABLE `venta_presupuesto` DISABLE KEYS */;
/*!40000 ALTER TABLE `venta_presupuesto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta_producto`
--

DROP TABLE IF EXISTS `venta_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta_producto` (
  `idVenta` int NOT NULL,
  `idProducto` int NOT NULL,
  `cantidad` int NOT NULL DEFAULT '1',
  `precioUnitario` double NOT NULL,
  `descuento` double NOT NULL,
  KEY `fk_ventasolucion_venta` (`idVenta`),
  KEY `fk_ventaproducto_producto` (`idProducto`),
  CONSTRAINT `fk_ventaproducto_producto` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`),
  CONSTRAINT `fk_ventasolucion_venta` FOREIGN KEY (`idVenta`) REFERENCES `venta` (`idVenta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta_producto`
--

LOCK TABLES `venta_producto` WRITE;
/*!40000 ALTER TABLE `venta_producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `venta_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `vista_accesorios`
--

DROP TABLE IF EXISTS `vista_accesorios`;
/*!50001 DROP VIEW IF EXISTS `vista_accesorios`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vista_accesorios` AS SELECT 
 1 AS `idAccesorio`,
 1 AS `idProducto`,
 1 AS `codigoBarras`,
 1 AS `nombre`,
 1 AS `marca`,
 1 AS `precioCompra`,
 1 AS `precioVenta`,
 1 AS `existencias`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vista_accesorios_inactivos`
--

DROP TABLE IF EXISTS `vista_accesorios_inactivos`;
/*!50001 DROP VIEW IF EXISTS `vista_accesorios_inactivos`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vista_accesorios_inactivos` AS SELECT 
 1 AS `idAccesorio`,
 1 AS `idProducto`,
 1 AS `codigoBarras`,
 1 AS `nombre`,
 1 AS `marca`,
 1 AS `precioCompra`,
 1 AS `precioVenta`,
 1 AS `existencias`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vista_armazon`
--

DROP TABLE IF EXISTS `vista_armazon`;
/*!50001 DROP VIEW IF EXISTS `vista_armazon`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vista_armazon` AS SELECT 
 1 AS `idArmazon`,
 1 AS `idProducto`,
 1 AS `modelo`,
 1 AS `color`,
 1 AS `dimensiones`,
 1 AS `descripcion`,
 1 AS `fotografia`,
 1 AS `codigoBarras`,
 1 AS `nombre`,
 1 AS `marca`,
 1 AS `precioVenta`,
 1 AS `precioCompra`,
 1 AS `existencias`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vista_armazon_inactivos`
--

DROP TABLE IF EXISTS `vista_armazon_inactivos`;
/*!50001 DROP VIEW IF EXISTS `vista_armazon_inactivos`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vista_armazon_inactivos` AS SELECT 
 1 AS `idArmazon`,
 1 AS `modelo`,
 1 AS `color`,
 1 AS `dimensiones`,
 1 AS `descripcion`,
 1 AS `fotografia`,
 1 AS `codigoBarras`,
 1 AS `nombre`,
 1 AS `marca`,
 1 AS `precioVenta`,
 1 AS `precioCompra`,
 1 AS `existencias`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vista_clientes`
--

DROP TABLE IF EXISTS `vista_clientes`;
/*!50001 DROP VIEW IF EXISTS `vista_clientes`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vista_clientes` AS SELECT 
 1 AS `idCliente`,
 1 AS `nombre`,
 1 AS `apellidoPaterno`,
 1 AS `apellidoMaterno`,
 1 AS `genero`,
 1 AS `fechaNacimiento`,
 1 AS `calle`,
 1 AS `numero`,
 1 AS `colonia`,
 1 AS `cp`,
 1 AS `ciudad`,
 1 AS `estado`,
 1 AS `telcasa`,
 1 AS `telmovil`,
 1 AS `email`,
 1 AS `numeroUnico`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vista_clientes_inactivos`
--

DROP TABLE IF EXISTS `vista_clientes_inactivos`;
/*!50001 DROP VIEW IF EXISTS `vista_clientes_inactivos`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vista_clientes_inactivos` AS SELECT 
 1 AS `idCliente`,
 1 AS `nombre`,
 1 AS `apellidoPaterno`,
 1 AS `apellidoMaterno`,
 1 AS `genero`,
 1 AS `fechaNacimiento`,
 1 AS `calle`,
 1 AS `numero`,
 1 AS `colonia`,
 1 AS `cp`,
 1 AS `ciudad`,
 1 AS `estado`,
 1 AS `telcasa`,
 1 AS `telmovil`,
 1 AS `email`,
 1 AS `numeroUnico`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vista_empleados`
--

DROP TABLE IF EXISTS `vista_empleados`;
/*!50001 DROP VIEW IF EXISTS `vista_empleados`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vista_empleados` AS SELECT 
 1 AS `idEmpleado`,
 1 AS `idPersona`,
 1 AS `idUsuario`,
 1 AS `nombre`,
 1 AS `apellidoPaterno`,
 1 AS `apellidoMaterno`,
 1 AS `genero`,
 1 AS `fechaNacimiento`,
 1 AS `calle`,
 1 AS `numero`,
 1 AS `colonia`,
 1 AS `cp`,
 1 AS `ciudad`,
 1 AS `estado`,
 1 AS `telcasa`,
 1 AS `telmovil`,
 1 AS `email`,
 1 AS `contrasenia`,
 1 AS `nombreU`,
 1 AS `rol`,
 1 AS `numeroUnico`,
 1 AS `estatus`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vista_empleados_inactivos`
--

DROP TABLE IF EXISTS `vista_empleados_inactivos`;
/*!50001 DROP VIEW IF EXISTS `vista_empleados_inactivos`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vista_empleados_inactivos` AS SELECT 
 1 AS `idEmpleado`,
 1 AS `nombre`,
 1 AS `apellidoPaterno`,
 1 AS `apellidoMaterno`,
 1 AS `genero`,
 1 AS `fechaNacimiento`,
 1 AS `calle`,
 1 AS `numero`,
 1 AS `colonia`,
 1 AS `cp`,
 1 AS `ciudad`,
 1 AS `estado`,
 1 AS `telcasa`,
 1 AS `telmovil`,
 1 AS `email`,
 1 AS `contrasenia`,
 1 AS `nombreUsuario`,
 1 AS `rol`,
 1 AS `numeroUnico`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vista_examen_vista`
--

DROP TABLE IF EXISTS `vista_examen_vista`;
/*!50001 DROP VIEW IF EXISTS `vista_examen_vista`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vista_examen_vista` AS SELECT 
 1 AS `idExamenVista`,
 1 AS `clave`,
 1 AS `idEmpleado`,
 1 AS `idCliente`,
 1 AS `idGraduacion`,
 1 AS `esferaod`,
 1 AS `esferaoi`,
 1 AS `cilindrood`,
 1 AS `cilindrooi`,
 1 AS `ejeoi`,
 1 AS `ejeod`,
 1 AS `dip`,
 1 AS `fecha`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vista_material`
--

DROP TABLE IF EXISTS `vista_material`;
/*!50001 DROP VIEW IF EXISTS `vista_material`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vista_material` AS SELECT 
 1 AS `idMaterial`,
 1 AS `nombre`,
 1 AS `precioCompra`,
 1 AS `precioVenta`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vista_material_inactivos`
--

DROP TABLE IF EXISTS `vista_material_inactivos`;
/*!50001 DROP VIEW IF EXISTS `vista_material_inactivos`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vista_material_inactivos` AS SELECT 
 1 AS `idMaterial`,
 1 AS `nombre`,
 1 AS `precioCompra`,
 1 AS `precioVenta`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vista_soluciones`
--

DROP TABLE IF EXISTS `vista_soluciones`;
/*!50001 DROP VIEW IF EXISTS `vista_soluciones`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vista_soluciones` AS SELECT 
 1 AS `idSolucion`,
 1 AS `idProducto`,
 1 AS `estatus`,
 1 AS `codigoBarras`,
 1 AS `nombre`,
 1 AS `marca`,
 1 AS `precioCompra`,
 1 AS `precioVenta`,
 1 AS `existencias`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vista_soluciones_inactivos`
--

DROP TABLE IF EXISTS `vista_soluciones_inactivos`;
/*!50001 DROP VIEW IF EXISTS `vista_soluciones_inactivos`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vista_soluciones_inactivos` AS SELECT 
 1 AS `idSolucion`,
 1 AS `idProducto`,
 1 AS `estatus`,
 1 AS `codigoBarras`,
 1 AS `nombre`,
 1 AS `marca`,
 1 AS `precioCompra`,
 1 AS `precioVenta`,
 1 AS `existencias`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vista_tratamiento`
--

DROP TABLE IF EXISTS `vista_tratamiento`;
/*!50001 DROP VIEW IF EXISTS `vista_tratamiento`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vista_tratamiento` AS SELECT 
 1 AS `idTratamiento`,
 1 AS `nombre`,
 1 AS `precioCompra`,
 1 AS `precioVenta`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping events for database 'optiqalumnos'
--

--
-- Dumping routines for database 'optiqalumnos'
--
/*!50003 DROP PROCEDURE IF EXISTS `activarEmpleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `activarEmpleado`(IN var_idEmpleado INT)
BEGIN
    UPDATE empleado SET estatus = 1 WHERE idEmpleado = var_idEmpleado;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizarEmpleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizarEmpleado`(    /* Datos Personales */
                                    IN    var_nombre          VARCHAR(64),    --  1
                                    IN    var_apellidoPaterno VARCHAR(64),    --  2
                                    IN    var_apellidoMaterno VARCHAR(64),    --  3
                                    IN  var_genero          VARCHAR(2),     --  4
                                    IN  var_fechaNacimiento VARCHAR(11),    --  5
                                    IN    var_calle           VARCHAR(129),   --  6
                                    IN  var_numero          VARCHAR(20),    --  7
                                    IN  var_colonia         VARCHAR(40),    --  8
                                    IN  var_cp              VARCHAR(25),    --  9
                                    IN  var_ciudad          VARCHAR(40),    -- 10
                                    IN  var_estado          VARCHAR(40),    -- 11
                                    IN    var_telcasa         VARCHAR(20),    -- 12
                                    IN    var_telmovil        VARCHAR(20),    -- 13
                                    IN    var_email           VARCHAR(129),   -- 14
                                   
                                    /* Datos de Usuario */
                                    IN    var_nombreUsuario   VARCHAR(129),   -- 15
                                    IN    var_contrasenia     VARCHAR(129),   -- 16
                                    IN    var_rol             VARCHAR(25),    -- 17                                   
                                   
                                    /* Valores de Retorno */
                                    in    var_idPersona       INT,            -- 18
                                    in    var_idUsuario       INT,            -- 19
                                    in    var_idEmpleado      INT,            -- 20
                                    in    var_numeroUnico     VARCHAR(65)   -- 21
                )
BEGIN
    DECLARE v_fecha DATE;
    SET v_fecha = STR_TO_DATE(var_fechaNacimiento, '%d/%m/%Y');
    
    UPDATE persona SET nombre = var_nombre, apellidoPaterno = var_apellidoPaterno, apellidoMaterno = var_apellidoMaterno, genero = var_genero, fechaNacimiento = v_fecha, calle = var_calle, numero = var_numero, colonia = var_colonia, cp = var_cp, ciudad = var_ciudad, estado = var_estado, telcasa = var_telcasa, telmovil = var_telmovil, email = var_email WHERE idPersona = var_idPersona;
    
    UPDATE usuario SET nombre = var_nombreUsuario, contrasenia = var_contrasenia, rol = var_rol WHERE idUsuario = var_idUsuario;
    
    UPDATE empleado SET numeroUnico = var_numeroUnico WHERE idEmpleado = var_idEmpleado;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `bitacora` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `bitacora`(
							in v_idConductor int,
                            in v_placa varchar(20),
                            in v_numero int
)
begin
insert into bitacora(idConductor,fecha,placa,lastTicket) values(v_idConductor,now(),v_placa,v_numero);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminarEmpleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminarEmpleado`(IN var_idEmpleado INT)
BEGIN
    UPDATE empleado SET estatus = 0 WHERE idEmpleado = var_idEmpleado;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `generarCodigoUnicoEmpleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `generarCodigoUnicoEmpleado`(
    IN v_apePaterno VARCHAR(32),				-- 1
    IN v_apeMaterno VARCHAR(32),				-- 2
    OUT v_numeroUnico VARCHAR(65)				-- 3
)
BEGIN
	DECLARE v_timestamp VARCHAR(32);
	SET v_numeroUnico = LEFT(v_apePaterno,2);
    IF length(v_apeMaterno) != 0 THEN
		SET v_numeroUnico = CONCAT(v_numeroUnico, LEFT(v_apeMaterno,1));
	ELSE 
		SET v_numeroUnico = CONCAT(v_numeroUnico, 'x');
	END IF;
    SET v_numeroUnico = upper(v_numeroUnico);
	SET v_timestamp = CAST(unix_timestamp() AS CHAR);
    SET v_numeroUnico = CONCAT(v_numeroUnico, v_timestamp);
    SET v_numeroUnico = md5(v_numeroUnico);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertarEmpleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarEmpleado`(    /* Datos Personales */
                                    IN    var_nombre          VARCHAR(64),    --  1
                                    IN    var_apellidoPaterno VARCHAR(64),    --  2
                                    IN    var_apellidoMaterno VARCHAR(64),    --  3
                                    IN  var_genero          VARCHAR(2),     --  4
                                    IN  var_fechaNacimiento VARCHAR(11),    --  5
                                    IN    var_calle           VARCHAR(129),   --  6
                                    IN  var_numero          VARCHAR(20),    --  7
                                    IN  var_colonia         VARCHAR(40),    --  8
                                    IN  var_cp              VARCHAR(25),    --  9
                                    IN  var_ciudad          VARCHAR(40),    -- 10
                                    IN  var_estado          VARCHAR(40),    -- 11
                                    IN    var_telcasa         VARCHAR(20),    -- 12
                                    IN    var_telmovil        VARCHAR(20),    -- 13
                                    IN    var_email           VARCHAR(129),   -- 14
                                   
                                    /* Datos de Usuario */
                                    IN    var_nombreUsuario   VARCHAR(129),   -- 15
                                    IN    var_contrasenia     VARCHAR(129),   -- 16
                                    IN    var_rol             VARCHAR(25),    -- 17                                   
                                   
                                    /* Valores de Retorno */
                                    OUT    var_idPersona       INT,            -- 18
                                    OUT    var_idUsuario       INT,            -- 19
                                    OUT    var_idEmpleado      INT,            -- 20
                                    OUT    var_numeroUnico     VARCHAR(65),    -- 21
                                    OUT var_lastToken       VARCHAR(65)     -- 22
                )
BEGIN
    DECLARE v_fecha DATE;
	SET v_fecha = STR_TO_DATE('01/01/1901 00:00:00', '%d/%m/%Y %H:%i:%S');
 	SET var_lastToken = "token";
    INSERT INTO persona(nombre,apellidoPaterno,apellidoMaterno,genero,fechaNacimiento,calle,numero,colonia,cp,ciudad,estado,telcasa,telmovil,email)
    VALUES(var_nombre,var_apellidoPaterno,var_apellidoMaterno,var_genero,v_fecha,var_calle,var_numero,var_colonia,var_cp,var_ciudad,var_estado,var_telcasa,var_telmovil,var_email);
    SET var_idPersona = LAST_INSERT_ID();
    INSERT INTO usuario(nombre,contrasenia,rol,lastToken)
    VALUES(var_nombreUsuario,var_contrasenia,var_rol,var_lastToken);
    SET var_idUsuario = LAST_INSERT_ID();

    CALL generarCodigoUnicoEmpleado(var_apellidoPaterno,var_apellidoMaterno,var_numeroUnico);

    INSERT INTO empleado(idPersona,idUsuario,numeroUnico)
    VALUES(var_idPersona,var_idUsuario,var_numeroUnico);
    SET var_idEmpleado = LAST_INSERT_ID();
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `v_bitacora`
--

/*!50001 DROP VIEW IF EXISTS `v_bitacora`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_bitacora` AS select `b`.`idBitacora` AS `idBitacora`,`c`.`nombre` AS `nombre`,`c`.`ape_paterno` AS `ape_paterno`,`c`.`ape_materno` AS `ape_materno`,`b`.`fecha` AS `fecha`,`b`.`placa` AS `placa`,`b`.`lastTicket` AS `lastTicket` from (`bitacora` `b` join `conductor` `c` on((`b`.`idConductor` = `c`.`idConductor`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_lentecontacto`
--

/*!50001 DROP VIEW IF EXISTS `v_lentecontacto`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_lentecontacto` AS select `lc`.`idLenteContacto` AS `idLenteContacto`,`p`.`idProducto` AS `idProducto`,`lc`.`keratometria` AS `keratometria`,`lc`.`fotografia` AS `fotografia`,`p`.`codigoBarras` AS `codigoBarras`,`p`.`nombre` AS `nombre`,`p`.`marca` AS `marca`,`p`.`precioCompra` AS `precioCompra`,`p`.`precioVenta` AS `precioVenta`,`p`.`existencias` AS `existencias` from (`lente_contacto` `lc` join `producto` `p` on((`p`.`idProducto` = `lc`.`idProducto`))) where (`p`.`estatus` = 1) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_lentecontacto_inactivos`
--

/*!50001 DROP VIEW IF EXISTS `v_lentecontacto_inactivos`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_lentecontacto_inactivos` AS select `lc`.`idLenteContacto` AS `idLenteContacto`,`p`.`idProducto` AS `idProducto`,`lc`.`keratometria` AS `keratometria`,`lc`.`fotografia` AS `fotografia`,`p`.`codigoBarras` AS `codigoBarras`,`p`.`nombre` AS `nombre`,`p`.`marca` AS `marca`,`p`.`precioCompra` AS `precioCompra`,`p`.`precioVenta` AS `precioVenta`,`p`.`existencias` AS `existencias` from (`lente_contacto` `lc` join `producto` `p` on((`p`.`idProducto` = `lc`.`idProducto`))) where (`p`.`estatus` = 0) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vista_accesorios`
--

/*!50001 DROP VIEW IF EXISTS `vista_accesorios`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_accesorios` AS select `a`.`idAccesorio` AS `idAccesorio`,`p`.`idProducto` AS `idProducto`,`p`.`codigoBarras` AS `codigoBarras`,`p`.`nombre` AS `nombre`,`p`.`marca` AS `marca`,`p`.`precioCompra` AS `precioCompra`,`p`.`precioVenta` AS `precioVenta`,`p`.`existencias` AS `existencias` from (`producto` `p` join `accesorio` `a` on((`p`.`idProducto` = `a`.`idProducto`))) where (`p`.`estatus` = 1) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vista_accesorios_inactivos`
--

/*!50001 DROP VIEW IF EXISTS `vista_accesorios_inactivos`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_accesorios_inactivos` AS select `a`.`idAccesorio` AS `idAccesorio`,`p`.`idProducto` AS `idProducto`,`p`.`codigoBarras` AS `codigoBarras`,`p`.`nombre` AS `nombre`,`p`.`marca` AS `marca`,`p`.`precioCompra` AS `precioCompra`,`p`.`precioVenta` AS `precioVenta`,`p`.`existencias` AS `existencias` from (`producto` `p` join `accesorio` `a` on((`p`.`idProducto` = `a`.`idProducto`))) where (`p`.`estatus` = 0) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vista_armazon`
--

/*!50001 DROP VIEW IF EXISTS `vista_armazon`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_armazon` AS select `a`.`idArmazon` AS `idArmazon`,`a`.`idProducto` AS `idProducto`,`a`.`modelo` AS `modelo`,`a`.`color` AS `color`,`a`.`dimensiones` AS `dimensiones`,`a`.`descripcion` AS `descripcion`,`a`.`fotografia` AS `fotografia`,`p`.`codigoBarras` AS `codigoBarras`,`p`.`nombre` AS `nombre`,`p`.`marca` AS `marca`,`p`.`precioVenta` AS `precioVenta`,`p`.`precioCompra` AS `precioCompra`,`p`.`existencias` AS `existencias` from (`armazon` `a` join `producto` `p` on((`a`.`idProducto` = `p`.`idProducto`))) where (`p`.`estatus` = 1) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vista_armazon_inactivos`
--

/*!50001 DROP VIEW IF EXISTS `vista_armazon_inactivos`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_armazon_inactivos` AS select `a`.`idArmazon` AS `idArmazon`,`a`.`modelo` AS `modelo`,`a`.`color` AS `color`,`a`.`dimensiones` AS `dimensiones`,`a`.`descripcion` AS `descripcion`,`a`.`fotografia` AS `fotografia`,`p`.`codigoBarras` AS `codigoBarras`,`p`.`nombre` AS `nombre`,`p`.`marca` AS `marca`,`p`.`precioVenta` AS `precioVenta`,`p`.`precioCompra` AS `precioCompra`,`p`.`existencias` AS `existencias` from (`armazon` `a` join `producto` `p` on((`a`.`idProducto` = `p`.`idProducto`))) where (`p`.`estatus` = 0) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vista_clientes`
--

/*!50001 DROP VIEW IF EXISTS `vista_clientes`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_clientes` AS select `c`.`idCliente` AS `idCliente`,`p`.`nombre` AS `nombre`,`p`.`apellidoPaterno` AS `apellidoPaterno`,`p`.`apellidoMaterno` AS `apellidoMaterno`,`p`.`genero` AS `genero`,`p`.`fechaNacimiento` AS `fechaNacimiento`,`p`.`calle` AS `calle`,`p`.`numero` AS `numero`,`p`.`colonia` AS `colonia`,`p`.`cp` AS `cp`,`p`.`ciudad` AS `ciudad`,`p`.`estado` AS `estado`,`p`.`telcasa` AS `telcasa`,`p`.`telmovil` AS `telmovil`,`p`.`email` AS `email`,`c`.`numeroUnico` AS `numeroUnico` from (`cliente` `c` join `persona` `p` on((`c`.`idPersona` = `p`.`idPersona`))) where (`c`.`estatus` = 1) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vista_clientes_inactivos`
--

/*!50001 DROP VIEW IF EXISTS `vista_clientes_inactivos`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_clientes_inactivos` AS select `c`.`idCliente` AS `idCliente`,`p`.`nombre` AS `nombre`,`p`.`apellidoPaterno` AS `apellidoPaterno`,`p`.`apellidoMaterno` AS `apellidoMaterno`,`p`.`genero` AS `genero`,`p`.`fechaNacimiento` AS `fechaNacimiento`,`p`.`calle` AS `calle`,`p`.`numero` AS `numero`,`p`.`colonia` AS `colonia`,`p`.`cp` AS `cp`,`p`.`ciudad` AS `ciudad`,`p`.`estado` AS `estado`,`p`.`telcasa` AS `telcasa`,`p`.`telmovil` AS `telmovil`,`p`.`email` AS `email`,`c`.`numeroUnico` AS `numeroUnico` from (`cliente` `c` join `persona` `p` on((`c`.`idPersona` = `p`.`idPersona`))) where (`c`.`estatus` = 0) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vista_empleados`
--

/*!50001 DROP VIEW IF EXISTS `vista_empleados`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_empleados` AS select `e`.`idEmpleado` AS `idEmpleado`,`p`.`idPersona` AS `idPersona`,`u`.`idUsuario` AS `idUsuario`,`p`.`nombre` AS `nombre`,`p`.`apellidoPaterno` AS `apellidoPaterno`,`p`.`apellidoMaterno` AS `apellidoMaterno`,`p`.`genero` AS `genero`,`p`.`fechaNacimiento` AS `fechaNacimiento`,`p`.`calle` AS `calle`,`p`.`numero` AS `numero`,`p`.`colonia` AS `colonia`,`p`.`cp` AS `cp`,`p`.`ciudad` AS `ciudad`,`p`.`estado` AS `estado`,`p`.`telcasa` AS `telcasa`,`p`.`telmovil` AS `telmovil`,`p`.`email` AS `email`,`u`.`contrasenia` AS `contrasenia`,`u`.`nombre` AS `nombreU`,`u`.`rol` AS `rol`,`e`.`numeroUnico` AS `numeroUnico`,`e`.`estatus` AS `estatus` from ((`empleado` `e` join `persona` `p` on((`e`.`idPersona` = `p`.`idPersona`))) join `usuario` `u` on((`e`.`idUsuario` = `u`.`idUsuario`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vista_empleados_inactivos`
--

/*!50001 DROP VIEW IF EXISTS `vista_empleados_inactivos`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_empleados_inactivos` AS select `e`.`idEmpleado` AS `idEmpleado`,`p`.`nombre` AS `nombre`,`p`.`apellidoPaterno` AS `apellidoPaterno`,`p`.`apellidoMaterno` AS `apellidoMaterno`,`p`.`genero` AS `genero`,`p`.`fechaNacimiento` AS `fechaNacimiento`,`p`.`calle` AS `calle`,`p`.`numero` AS `numero`,`p`.`colonia` AS `colonia`,`p`.`cp` AS `cp`,`p`.`ciudad` AS `ciudad`,`p`.`estado` AS `estado`,`p`.`telcasa` AS `telcasa`,`p`.`telmovil` AS `telmovil`,`p`.`email` AS `email`,`u`.`contrasenia` AS `contrasenia`,`u`.`nombre` AS `nombreUsuario`,`u`.`rol` AS `rol`,`e`.`numeroUnico` AS `numeroUnico` from ((`empleado` `e` join `persona` `p` on((`e`.`idPersona` = `p`.`idPersona`))) join `usuario` `u` on((`e`.`idUsuario` = `u`.`idUsuario`))) where (`e`.`estatus` = 0) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vista_examen_vista`
--

/*!50001 DROP VIEW IF EXISTS `vista_examen_vista`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_examen_vista` AS select `ev`.`idExamenVista` AS `idExamenVista`,`ev`.`clave` AS `clave`,`e`.`idEmpleado` AS `idEmpleado`,`c`.`idCliente` AS `idCliente`,`g`.`idGraduacion` AS `idGraduacion`,`g`.`esferaod` AS `esferaod`,`g`.`esferaoi` AS `esferaoi`,`g`.`cilindrood` AS `cilindrood`,`g`.`cilindrooi` AS `cilindrooi`,`g`.`ejeoi` AS `ejeoi`,`g`.`ejeod` AS `ejeod`,`g`.`dip` AS `dip`,`ev`.`fecha` AS `fecha` from (((`examen_vista` `ev` join `empleado` `e` on((`ev`.`idEmpleado` = `e`.`idEmpleado`))) join `cliente` `c` on((`ev`.`idCliente` = `c`.`idCliente`))) join `graduacion` `g` on((`ev`.`idGraduacion` = `g`.`idGraduacion`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vista_material`
--

/*!50001 DROP VIEW IF EXISTS `vista_material`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_material` AS select `material`.`idMaterial` AS `idMaterial`,`material`.`nombre` AS `nombre`,`material`.`precioCompra` AS `precioCompra`,`material`.`precioVenta` AS `precioVenta` from `material` where (`material`.`estatus` = 1) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vista_material_inactivos`
--

/*!50001 DROP VIEW IF EXISTS `vista_material_inactivos`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_material_inactivos` AS select `material`.`idMaterial` AS `idMaterial`,`material`.`nombre` AS `nombre`,`material`.`precioCompra` AS `precioCompra`,`material`.`precioVenta` AS `precioVenta` from `material` where (`material`.`estatus` = 0) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vista_soluciones`
--

/*!50001 DROP VIEW IF EXISTS `vista_soluciones`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_soluciones` AS select `s`.`idSolucion` AS `idSolucion`,`s`.`idProducto` AS `idProducto`,`s`.`estatus` AS `estatus`,`p`.`codigoBarras` AS `codigoBarras`,`p`.`nombre` AS `nombre`,`p`.`marca` AS `marca`,`p`.`precioCompra` AS `precioCompra`,`p`.`precioVenta` AS `precioVenta`,`p`.`existencias` AS `existencias` from (`solucion` `s` join `producto` `p` on((`s`.`idProducto` = `p`.`idProducto`))) where (`s`.`estatus` = 1) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vista_soluciones_inactivos`
--

/*!50001 DROP VIEW IF EXISTS `vista_soluciones_inactivos`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_soluciones_inactivos` AS select `s`.`idSolucion` AS `idSolucion`,`s`.`idProducto` AS `idProducto`,`s`.`estatus` AS `estatus`,`p`.`codigoBarras` AS `codigoBarras`,`p`.`nombre` AS `nombre`,`p`.`marca` AS `marca`,`p`.`precioCompra` AS `precioCompra`,`p`.`precioVenta` AS `precioVenta`,`p`.`existencias` AS `existencias` from (`solucion` `s` join `producto` `p` on((`s`.`idProducto` = `p`.`idProducto`))) where (`s`.`estatus` = 0) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vista_tratamiento`
--

/*!50001 DROP VIEW IF EXISTS `vista_tratamiento`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_tratamiento` AS select `tratamiento`.`idTratamiento` AS `idTratamiento`,`tratamiento`.`nombre` AS `nombre`,`tratamiento`.`precioCompra` AS `precioCompra`,`tratamiento`.`precioVenta` AS `precioVenta` from `tratamiento` where (`tratamiento`.`estatus` = 1) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-16  9:44:52
