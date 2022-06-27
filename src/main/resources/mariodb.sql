-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.6.8-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para mariodb
CREATE DATABASE IF NOT EXISTS `mariodb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `mariodb`;

-- Volcando estructura para tabla mariodb.faq
CREATE TABLE IF NOT EXISTS `faq` (
  `question` varchar(500) DEFAULT NULL,
  `ans` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla mariodb.faq: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `faq` DISABLE KEYS */;
INSERT INTO `faq` (`question`, `ans`) VALUES
	('How to recover a lost account?', 'Contact our tech support team and provide as much information about the issue as possible');
/*!40000 ALTER TABLE `faq` ENABLE KEYS */;

-- Volcando estructura para tabla mariodb.game
CREATE TABLE IF NOT EXISTS `game` (
  `id` varchar(50) DEFAULT NULL,
  `userId` varchar(50) DEFAULT NULL,
  `finished` tinyint(1) DEFAULT NULL,
  `points` int(11) DEFAULT NULL,
  `coins` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla mariodb.game: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
INSERT INTO `game` (`id`, `userId`, `finished`, `points`, `coins`) VALUES
	('QjZ3h370521030', 'fq3rv42rv', 0, 50, 30),
	('VlboQ09Ew76', 'fq3rv42rv', 0, 0, 0);
/*!40000 ALTER TABLE `game` ENABLE KEYS */;

-- Volcando estructura para tabla mariodb.inventory
CREATE TABLE IF NOT EXISTS `inventory` (
  `id` varchar(50) NOT NULL,
  `userId` varchar(50) NOT NULL,
  `itemId` varchar(50) NOT NULL,
  KEY `FK_inventory_user` (`userId`),
  KEY `FK_inventory_item` (`itemId`),
  CONSTRAINT `FK_inventory_item` FOREIGN KEY (`itemId`) REFERENCES `item` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_inventory_user` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla mariodb.inventory: ~8 rows (aproximadamente)
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
INSERT INTO `inventory` (`id`, `userId`, `itemId`) VALUES
	('1r3buoi2', 'fq3rv42rv', 'fq34b563o'),
	('fwaf42v24', '524efsd', 'afge56h'),
	('aqv5q5q31', 'fq3rv42rv', 'ag45bh41'),
	('BrPe7234858', '524efsd', 'fq34b563o'),
	('lW79', 'fq3rv42rv', 'afge56h'),
	('Xk_AkWviwZ3378852', 'bv6w5v5', 'fq34b563o'),
	('jtPqm6Kw3594946', 'bv6w5v5', 'afge56h'),
	('3614726576', '524efsd', 'ag45bh41');
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;

-- Volcando estructura para tabla mariodb.issue
CREATE TABLE IF NOT EXISTS `issue` (
  `date` varchar(50) DEFAULT NULL,
  `informer` varchar(50) DEFAULT NULL,
  `message` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla mariodb.issue: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `issue` DISABLE KEYS */;
INSERT INTO `issue` (`date`, `informer`, `message`) VALUES
	('string', 'Alba', 'string');
/*!40000 ALTER TABLE `issue` ENABLE KEYS */;

-- Volcando estructura para tabla mariodb.item
CREATE TABLE IF NOT EXISTS `item` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(300) NOT NULL,
  `price` int(11) NOT NULL,
  `type` varchar(100) NOT NULL,
  `damage` int(11) NOT NULL,
  `dmgReduction` int(11) NOT NULL,
  `avatar` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla mariodb.item: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` (`id`, `name`, `description`, `price`, `type`, `damage`, `dmgReduction`, `avatar`) VALUES
	('afge56h', 'Shield', 'Shinny', 100, 'Armor', 0, 20, 'images/Shield.png'),
	('ag45bh41', 'Luigi', 'Fasionn', 300, 'Skin', 0, 0, 'images/Luigi.png'),
	('fq34b563o', 'Gun', 'Ranged', 50, 'Weapon', 10, 0, 'images/Gun.png');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;

-- Volcando estructura para tabla mariodb.question
CREATE TABLE IF NOT EXISTS `question` (
  `date` varchar(50) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `message` varchar(500) DEFAULT NULL,
  `sender` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla mariodb.question: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` (`date`, `title`, `message`, `sender`) VALUES
	('string', 'string', 'string', 'string');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;

-- Volcando estructura para tabla mariodb.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `coins` int(11) DEFAULT NULL,
  `language` varchar(50) DEFAULT NULL,
  `points` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla mariodb.user: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `name`, `password`, `email`, `coins`, `language`, `points`) VALUES
	('524efsd', 'Adrian', '1234', 'adrian@upc.com', 150, 'en', 150),
	('bv6w5v5', 'Irene', '1234', 'irene@upc.com', 100, 'en', 46),
	('fq3rv42rv', 'Alba', '1234', 'alba@upc.com', 430, 'en', 50),
	('T2T4zT3GE32045502', 'Alvaro', '1234', 'alvaro@upc.com', 30, 'en', 50),
	('VMuiTTm328703260015', 'Test', '1234', 'gre', 0, 'en', 0),
	('z7aNvWW22481', 'Ferran', '1234', 'ferran@upc.com', 0, 'en', 200);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
