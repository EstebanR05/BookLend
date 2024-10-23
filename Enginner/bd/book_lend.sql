-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 23, 2024 at 06:29 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `book_lend`
--

-- --------------------------------------------------------

--
-- Table structure for table `inventary`
--

CREATE TABLE `inventary` (
  `id_inventary` int(11) NOT NULL,
  `name_book` varchar(45) DEFAULT NULL,
  `img` varchar(100) DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  `create_at` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `inventary`
--

INSERT INTO `inventary` (`id_inventary`, `name_book`, `img`, `author`, `create_at`) VALUES
(1, 'mil maneras de amar', 'marenas.png', 'stiven hooks', '2024-10-09'),
(2, 'mil maneras de amar', 'marenas.png', 'stiven hooks', '2024-10-09');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `inventary`
--
ALTER TABLE `inventary`
  ADD PRIMARY KEY (`id_inventary`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `inventary`
--
ALTER TABLE `inventary`
  MODIFY `id_inventary` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
