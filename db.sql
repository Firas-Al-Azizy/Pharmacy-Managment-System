-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 25, 2019 at 06:41 PM
-- Server version: 5.7.24
-- PHP Version: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pharmacy2019000`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `cus_id` int(9) NOT NULL AUTO_INCREMENT,
  `cus_name` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cus_number` int(9) DEFAULT NULL,
  PRIMARY KEY (`cus_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`cus_id`, `cus_name`, `cus_number`) VALUES
(4, 'NashTaha', 772440581),
(5, 'Firas', 774077740),
(11, 'Murad', 773232132),
(13, 'Heba', 777777777),
(16, 'nnn', 1235);

-- --------------------------------------------------------

--
-- Table structure for table `dose`
--

DROP TABLE IF EXISTS `dose`;
CREATE TABLE IF NOT EXISTS `dose` (
  `dos_id` int(20) NOT NULL AUTO_INCREMENT,
  `dos_qty` varchar(10) NOT NULL,
  PRIMARY KEY (`dos_id`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dose`
--

INSERT INTO `dose` (`dos_id`, `dos_qty`) VALUES
(1, '3 ml'),
(2, '5 ml'),
(3, '10 ml'),
(4, '15 ml'),
(5, '20 ml2'),
(6, '25 ml'),
(7, '30 ml'),
(8, '37 ml'),
(9, '40 ml'),
(10, '45 ml'),
(11, '50 ml'),
(12, '55 ml'),
(13, '60 ml'),
(14, '65 ml'),
(15, '70 ml'),
(16, '75 ml'),
(17, '80 ml'),
(18, '90 ml'),
(19, '100 ml'),
(20, '150 ml'),
(21, '200 ml'),
(22, '250 ml'),
(23, '300 ml'),
(24, '350 ml'),
(25, '400 ml'),
(26, '450 ml'),
(27, '500 ml'),
(28, '750 ml'),
(29, '1000 ml'),
(30, '1250 ml'),
(31, '1500 ml'),
(32, '1750 ml'),
(33, '2000 ml'),
(34, '3 mg'),
(35, '5 mg'),
(36, '10 mg'),
(37, '15 mg'),
(38, '20 mg'),
(39, '25 mg'),
(40, '30 mg'),
(41, '35 mg'),
(42, '40 mg'),
(43, '45 mg'),
(44, '50 mg'),
(45, '55 mg'),
(46, '60 mg'),
(47, '65 mg'),
(48, '70 mg'),
(49, '75 mg'),
(50, '80 mg'),
(51, '90 mg'),
(52, '100 mg'),
(53, '150 mg'),
(54, '200 mg'),
(55, '250 mg'),
(56, '300 mg'),
(57, '350 mg'),
(58, '400 mg'),
(59, '450 mg'),
(60, '500 mg'),
(61, '750 mg'),
(62, '1000 mg'),
(63, '1250 mg'),
(64, '1500 mg'),
(65, '1750 mg'),
(66, '2000 mg'),
(67, '0.1 mg'),
(68, '0.2 mg'),
(69, '0.3 mg'),
(70, '0.4 mg'),
(71, '0.5 mg'),
(72, '0.6 mg'),
(73, '0.7 mg'),
(74, '0.8 mg'),
(75, '0.9 mg'),
(76, '1 mg'),
(77, '0.25 mg'),
(78, '0.75 mg'),
(79, '0.10 %'),
(80, '0.20 %'),
(81, '0.30 %'),
(82, '0.40 %'),
(83, '0.50 %'),
(84, '0.60 %'),
(85, '0.70 %'),
(86, '0.80 %'),
(87, '0.90 %'),
(88, '1.00 %'),
(89, '0.25 %');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
CREATE TABLE IF NOT EXISTS `employee` (
  `emp_id` int(4) NOT NULL AUTO_INCREMENT,
  `emp_fname` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `emp_lname` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `emp_pass` text COLLATE utf8_unicode_ci NOT NULL,
  `emp_dob` text COLLATE utf8_unicode_ci NOT NULL,
  `emp_salary` int(6) NOT NULL,
  `emp_phone` int(15) NOT NULL,
  `emp_sex` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `emp_position` varchar(9) COLLATE utf8_unicode_ci NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`emp_id`),
  UNIQUE KEY `EmpName` (`emp_fname`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`emp_id`, `emp_fname`, `emp_lname`, `emp_pass`, `emp_dob`, `emp_salary`, `emp_phone`, `emp_sex`, `emp_position`, `created_at`) VALUES
(1, 'Heba', 'Aldobai', '12345678', '1997-12-11 00:00:00', 500000, 777, 'Female', 'Admin', '2018-05-15 22:24:21'),
(2, 'Firas', 'Alazizy', '87654321', '1999-04-13 00:00:00', 25000, 777, 'Male', 'Manager', '2018-05-15 22:24:21'),
(3, 'Nashwan ', 'Alqershi', '11223344', '1985-05-05 00:00:00', 25000, 777, 'Male', 'Admin', '2018-05-15 22:27:32'),
(4, 'Salman', 'Alhaimary', '123654', '1993-05-01 00:00:00', 25000, 777, 'Male', 'User', '2019-05-15 04:30:54'),
(5, 'Murad', 'Alshaibany', '123654', '1993-05-01 00:00:00', 25000, 777, 'Male', 'Manager', '2019-05-15 04:34:35'),
(6, 'Nana', 'Muhammed', '123654', '5/5/1999', 50000, 777, 'Female', 'Manager', '2019-05-16 02:36:00'),
(7, 'Muhammed', 'AlRiashy', '1235321', '5/5/1999', 30000, 777, 'Male', 'User', '2019-05-16 02:46:55'),
(8, 'Nada', 'Ali', '123852', '5/12/1999', 300000, 777, 'Female', 'User', '2019-05-16 02:48:29');

-- --------------------------------------------------------

--
-- Table structure for table `form`
--

DROP TABLE IF EXISTS `form`;
CREATE TABLE IF NOT EXISTS `form` (
  `for_id` int(20) NOT NULL AUTO_INCREMENT,
  `for_name` varchar(40) NOT NULL,
  PRIMARY KEY (`for_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `form`
--

INSERT INTO `form` (`for_id`, `for_name`) VALUES
(1, 'Ampoule'),
(2, 'Vial'),
(3, 'Powder'),
(4, 'Granules'),
(5, 'Effervescent'),
(6, 'Tablet'),
(7, 'Capsules'),
(8, 'Intra Venous(IV)'),
(9, 'Intra Muscular(IM)'),
(10, 'IV_IM'),
(11, 'Intra Dermal'),
(12, 'Sub Cutaneous'),
(13, 'Intra Thecal'),
(14, 'Intra Cardiac'),
(15, 'Emulsion'),
(16, 'Solution'),
(17, 'Suspension'),
(18, 'Syrup'),
(19, 'Ointment'),
(20, 'Cream'),
(21, 'Paste'),
(22, 'Suppository'),
(23, 'Gel'),
(24, 'Patche'),
(25, 'Drop'),
(26, 'Inhalation'),
(27, 'Chew-able Tablet '),
(28, 'Injectionnn');

-- --------------------------------------------------------

--
-- Table structure for table `income`
--

DROP TABLE IF EXISTS `income`;
CREATE TABLE IF NOT EXISTS `income` (
  `inc_id` int(11) NOT NULL AUTO_INCREMENT,
  `rec_id` int(11) NOT NULL,
  `rec_code` varchar(30) NOT NULL,
  `emp_id` int(11) NOT NULL,
  `total` double NOT NULL,
  `inc_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`inc_id`),
  KEY `emp_id` (`emp_id`),
  KEY `rec_id` (`rec_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
CREATE TABLE IF NOT EXISTS `products` (
  `pro_id` int(4) NOT NULL AUTO_INCREMENT,
  `pro_name` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `sec_id` int(3) NOT NULL,
  `for_id` int(20) NOT NULL,
  `dos_id` int(20) DEFAULT NULL,
  PRIMARY KEY (`pro_id`),
  UNIQUE KEY `product-name` (`pro_name`),
  KEY `Section-id` (`sec_id`),
  KEY `for_id` (`for_id`),
  KEY `dos_id` (`dos_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`pro_id`, `pro_name`, `sec_id`, `for_id`, `dos_id`) VALUES
(1, 'paramol', 1, 6, 80),
(2, 'voltarien', 2, 10, 80),
(3, 'Ansolaineeeeeeeeee', 3, 5, 7),
(31, 'NashNosh', 5, 3, 5);

-- --------------------------------------------------------

--
-- Table structure for table `receipt`
--

DROP TABLE IF EXISTS `receipt`;
CREATE TABLE IF NOT EXISTS `receipt` (
  `rec_id` int(4) NOT NULL AUTO_INCREMENT,
  `rec_code` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `Date-Time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `emp_id` int(4) NOT NULL,
  `cus-id` int(9) NOT NULL,
  `sto_id` int(4) NOT NULL,
  `qty` int(5) NOT NULL,
  `unit-cost` double NOT NULL,
  `total-cost` double NOT NULL,
  PRIMARY KEY (`rec_id`),
  KEY `EmpID` (`emp_id`),
  KEY `customer-id` (`cus-id`),
  KEY `sto_id` (`sto_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `receipt`
--

INSERT INTO `receipt` (`rec_id`, `rec_code`, `Date-Time`, `emp_id`, `cus-id`, `sto_id`, `qty`, `unit-cost`, `total-cost`) VALUES
(1, '', '2019-05-25 02:06:01', 2, 5, 1, 2, 2500, 5000);

-- --------------------------------------------------------

--
-- Table structure for table `section`
--

DROP TABLE IF EXISTS `section`;
CREATE TABLE IF NOT EXISTS `section` (
  `sec_id` int(4) NOT NULL AUTO_INCREMENT,
  `sec_name` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`sec_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `section`
--

INSERT INTO `section` (`sec_id`, `sec_name`) VALUES
(1, 'Gastroenterology Medications'),
(2, 'Respiratory System Medications '),
(3, 'Cardiovascular-Renal System Medications'),
(4, ' Endocrine System Medications'),
(5, 'Obstetrics Gynecology & URT Disorders'),
(6, 'Chemotherapeutic Medications'),
(7, 'Antiprotozoal Drugs'),
(8, 'Nutrtion & Blood Supplements'),
(9, 'Central Nervous System Medications'),
(10, 'Oncology , Chemotherapy & ImmunoSuppressios'),
(11, 'General Central Anaesthesia'),
(12, 'Dermatology'),
(13, 'Serum & Vaccines'),
(14, 'Ophthalmology'),
(15, 'Supplements Foods & Milks');

-- --------------------------------------------------------

--
-- Table structure for table `session`
--

DROP TABLE IF EXISTS `session`;
CREATE TABLE IF NOT EXISTS `session` (
  `ses_id` int(20) NOT NULL AUTO_INCREMENT,
  `ses_start` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `ses_end` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `ses_description` text NOT NULL,
  `emp_id` int(4) NOT NULL,
  PRIMARY KEY (`ses_id`),
  KEY `EmpID` (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `session`
--

INSERT INTO `session` (`ses_id`, `ses_start`, `ses_end`, `ses_description`, `emp_id`) VALUES
(1, '2019-03-11 10:19:34', '2019-03-11 10:19:34', 'none', 3),
(2, '2019-03-11 10:19:34', '2019-03-11 10:19:34', '2 shifts', 2);

-- --------------------------------------------------------

--
-- Table structure for table `store`
--

DROP TABLE IF EXISTS `store`;
CREATE TABLE IF NOT EXISTS `store` (
  `sto_id` int(4) NOT NULL AUTO_INCREMENT,
  `pro_id` int(4) NOT NULL,
  `sup-id` int(4) NOT NULL,
  `pro_exp` text COLLATE utf8_unicode_ci NOT NULL,
  `pro_price` int(8) NOT NULL,
  `pro_qty` int(8) NOT NULL,
  `pro_total` int(16) NOT NULL,
  `pro_code` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`sto_id`),
  KEY `pro_id` (`pro_id`),
  KEY `sup-id` (`sup-id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `store`
--

INSERT INTO `store` (`sto_id`, `pro_id`, `sup-id`, `pro_exp`, `pro_price`, `pro_qty`, `pro_total`, `pro_code`) VALUES
(1, 31, 2, '2019/01/01', 2500, 5, 12500, '1564895198');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
CREATE TABLE IF NOT EXISTS `supplier` (
  `sup_id` int(4) NOT NULL AUTO_INCREMENT,
  `sup_name` varchar(40) NOT NULL,
  `sup_address` varchar(80) NOT NULL,
  `sup_phone` int(20) NOT NULL,
  PRIMARY KEY (`sup_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`sup_id`, `sup_name`, `sup_address`, `sup_phone`) VALUES
(1, 'saba pharma', 'altahrir st. next to saif high school', 778674735),
(2, 'ardh alganatin', 'altahrir st. next to saba hotel', 776659446),
(3, 'EbenHayan', 'Khawlan St,In front of AlThaorah Hospital', 734632300);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `income`
--
ALTER TABLE `income`
  ADD CONSTRAINT `income_ibfk_1` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `income_ibfk_2` FOREIGN KEY (`rec_id`) REFERENCES `receipt` (`rec_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `products_ibfk_2` FOREIGN KEY (`sec_id`) REFERENCES `section` (`sec_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `products_ibfk_6` FOREIGN KEY (`for_id`) REFERENCES `form` (`for_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `products_ibfk_7` FOREIGN KEY (`dos_id`) REFERENCES `dose` (`dos_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `receipt`
--
ALTER TABLE `receipt`
  ADD CONSTRAINT `receipt_ibfk_1` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `receipt_ibfk_7` FOREIGN KEY (`cus-id`) REFERENCES `customer` (`cus_id`),
  ADD CONSTRAINT `receipt_ibfk_8` FOREIGN KEY (`sto_id`) REFERENCES `store` (`sto_id`);

--
-- Constraints for table `session`
--
ALTER TABLE `session`
  ADD CONSTRAINT `session_ibfk_1` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `store`
--
ALTER TABLE `store`
  ADD CONSTRAINT `store_ibfk_1` FOREIGN KEY (`sup-id`) REFERENCES `supplier` (`sup_id`),
  ADD CONSTRAINT `store_ibfk_2` FOREIGN KEY (`pro_id`) REFERENCES `products` (`pro_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
