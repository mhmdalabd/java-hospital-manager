-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 29, 2019 at 02:15 AM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.1.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java`
--

-- --------------------------------------------------------

--
-- Table structure for table `blood`
--

CREATE TABLE `blood` (
  `id` int(111) NOT NULL,
  `name` varchar(191) NOT NULL,
  `qty` int(111) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `blood`
--

INSERT INTO `blood` (`id`, `name`, `qty`) VALUES
(1, 'A+', 234),
(2, 'A-', 654),
(5, 'B+', 172),
(6, 'B-', 83),
(7, 'AB+', 192),
(8, 'AB-', 165),
(9, 'O+', 324),
(10, 'O-', 202);

-- --------------------------------------------------------

--
-- Table structure for table `blood_order`
--

CREATE TABLE `blood_order` (
  `id` int(111) NOT NULL,
  `blood_id` int(111) NOT NULL,
  `qty` int(111) NOT NULL,
  `patient_id` int(111) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `branch`
--

CREATE TABLE `branch` (
  `id` int(111) NOT NULL,
  `name` varchar(191) NOT NULL,
  `city` varchar(191) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `branch`
--

INSERT INTO `branch` (`id`, `name`, `city`) VALUES
(1, 'Beirut', ''),
(2, 'Tripoli', ''),
(3, 'Saida', ''),
(4, 'Tyre', ''),
(5, 'Bekaa', ''),
(6, 'Akkar', '');

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `id` int(111) NOT NULL,
  `name` varchar(191) NOT NULL,
  `spec` varchar(191) NOT NULL,
  `branch_id` int(111) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`id`, `name`, `spec`, `branch_id`) VALUES
(13, 'Fares Alhasan', 'Heart', 2),
(14, 'Monir Nadam', 'Heart', 3),
(15, 'Bashar Naasan', 'Children', 5),
(16, 'Samer Shaker', 'Lorem', 5),
(17, 'Ahmad Idrees', 'Ears', 2);

-- --------------------------------------------------------

--
-- Table structure for table `doctor_patient`
--

CREATE TABLE `doctor_patient` (
  `id` int(111) NOT NULL,
  `doctor_id` int(111) NOT NULL,
  `patient_id` int(111) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctor_patient`
--

INSERT INTO `doctor_patient` (`id`, `doctor_id`, `patient_id`) VALUES
(32, 13, 13),
(33, 14, 13),
(34, 14, 14),
(35, 16, 12),
(36, 13, 11);

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `id` int(111) NOT NULL,
  `name` varchar(191) NOT NULL,
  `phone` varchar(191) NOT NULL,
  `branch_id` int(111) DEFAULT NULL,
  `blood_id` int(111) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`id`, `name`, `phone`, `branch_id`, `blood_id`) VALUES
(11, 'Samir Ismail', '09837762', NULL, 10),
(12, 'Hassan Mhna', '93838322', NULL, 2),
(13, 'Fares Abbad', '92938384', NULL, 5),
(14, 'Ismaeel Halabi', '234234234', NULL, 6),
(15, 'Fadi Easa', '01334243', NULL, 5),
(17, 'Anas Taim', '3242342', NULL, 9);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `blood`
--
ALTER TABLE `blood`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `blood_order`
--
ALTER TABLE `blood_order`
  ADD PRIMARY KEY (`id`),
  ADD KEY `blood` (`blood_id`),
  ADD KEY `patient_blood` (`patient_id`);

--
-- Indexes for table `branch`
--
ALTER TABLE `branch`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `dBranch` (`branch_id`);

--
-- Indexes for table `doctor_patient`
--
ALTER TABLE `doctor_patient`
  ADD PRIMARY KEY (`id`),
  ADD KEY `doctor` (`doctor_id`),
  ADD KEY `patient` (`patient_id`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`id`),
  ADD KEY `branch` (`branch_id`),
  ADD KEY `blood_patient` (`blood_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `blood`
--
ALTER TABLE `blood`
  MODIFY `id` int(111) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `blood_order`
--
ALTER TABLE `blood_order`
  MODIFY `id` int(111) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `branch`
--
ALTER TABLE `branch`
  MODIFY `id` int(111) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `id` int(111) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `doctor_patient`
--
ALTER TABLE `doctor_patient`
  MODIFY `id` int(111) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT for table `patient`
--
ALTER TABLE `patient`
  MODIFY `id` int(111) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `blood_order`
--
ALTER TABLE `blood_order`
  ADD CONSTRAINT `blood` FOREIGN KEY (`blood_id`) REFERENCES `blood` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `patient_blood` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `doctor`
--
ALTER TABLE `doctor`
  ADD CONSTRAINT `dBranch` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`id`);

--
-- Constraints for table `doctor_patient`
--
ALTER TABLE `doctor_patient`
  ADD CONSTRAINT `doctor` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `patient` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `patient`
--
ALTER TABLE `patient`
  ADD CONSTRAINT `blood_patient` FOREIGN KEY (`blood_id`) REFERENCES `blood` (`id`),
  ADD CONSTRAINT `branch` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
