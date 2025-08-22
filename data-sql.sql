-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.32-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.10.0.7000
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for test-webservice-hanafi
CREATE DATABASE IF NOT EXISTS `test-webservice-hanafi` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci */;
USE `test-webservice-hanafi`;

-- Dumping structure for table test-webservice-hanafi.status
CREATE TABLE IF NOT EXISTS `status` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table test-webservice-hanafi.status: ~2 rows (approximately)
INSERT INTO `status` (`id`, `name`) VALUES
	(0, 'SUCCESS'),
	(1, 'FAILED');

-- Dumping structure for table test-webservice-hanafi.transactions
CREATE TABLE IF NOT EXISTS `transactions` (
  `id` int(11) NOT NULL,
  `productID` varchar(10) NOT NULL,
  `productName` varchar(100) NOT NULL,
  `amount` int(11) NOT NULL DEFAULT 0,
  `customerName` varchar(100) NOT NULL,
  `status` int(11) NOT NULL,
  `transactionDate` datetime NOT NULL,
  `createBy` varchar(100) NOT NULL,
  `createOn` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `status` (`status`),
  CONSTRAINT `transactions_ibfk_1` FOREIGN KEY (`status`) REFERENCES `status` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table test-webservice-hanafi.transactions: ~12 rows (approximately)
INSERT INTO `transactions` (`id`, `productID`, `productName`, `amount`, `customerName`, `status`, `transactionDate`, `createBy`, `createOn`) VALUES
	(1372, '10001', 'Test 1', 1000, 'abc', 0, '2022-07-10 11:14:52', 'abc', '2022-07-10 11:14:52'),
	(1373, '10002', 'Test 2', 2000, 'abc', 0, '2022-07-11 13:14:52', 'abc', '2022-07-10 13:14:52'),
	(1374, '10001', 'Test 1', 1000, 'abc', 0, '2022-08-10 12:14:52', 'abc', '2022-07-10 12:14:52'),
	(1375, '10002', 'Test 2', 1000, 'abc', 1, '2022-08-10 13:10:52', 'abc', '2022-07-10 13:10:52'),
	(1376, '10001', 'Test 1', 1000, 'abc', 0, '2022-08-10 13:11:52', 'abc', '2022-07-10 13:11:52'),
	(1377, '10002', 'Test 2', 2000, 'abc', 0, '2022-08-12 13:14:52', 'abc', '2022-07-10 13:14:52'),
	(1378, '10001', 'Test 1', 1000, 'abc', 0, '2022-08-12 14:11:52', 'abc', '2022-07-10 14:11:52'),
	(1379, '10002', 'Test 2', 1000, 'abc', 1, '2022-09-13 11:14:52', 'abc', '2022-07-10 11:14:52'),
	(1380, '10001', 'Test 1', 1000, 'abc', 0, '2022-09-13 13:14:52', 'abc', '2022-07-10 13:14:52'),
	(1381, '10002', 'Test 2', 2000, 'abc', 0, '2022-09-14 09:11:52', 'abc', '2022-07-10 09:11:52'),
	(1382, '10001', 'Test 1', 1000, 'abc', 0, '2022-09-14 10:14:52', 'abc', '2022-07-10 10:14:52'),
	(1383, '10002', 'Test 2', 1000, 'abc', 1, '2022-08-15 13:14:52', 'abc', '2022-07-10 13:14:52');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
