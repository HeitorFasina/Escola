-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: b2no9qi14ndhhpe0o9w2-mysql.services.clever-cloud.com:3306
-- Generation Time: Dec 07, 2022 at 05:05 AM
-- Server version: 8.0.22-13
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `b2no9qi14ndhhpe0o9w2`
--

-- --------------------------------------------------------

--
-- Table structure for table `aquisicoes`
--

CREATE TABLE `aquisicoes` (
  `ID_AQUISICAO` int NOT NULL,
  `ID_REQUISICAO` int NOT NULL,
  `nome_vestibular` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `DATA_INICIO` date NOT NULL,
  `DATA_FIM` date NOT NULL,
  `descricao` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `autor` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `id_autor` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `ID` int NOT NULL,
  `nome` varchar(50) NOT NULL,
  `usuario` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `senha` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`ID`, `nome`, `usuario`, `senha`) VALUES
(1, 'Heitor', 'gibson', '827ccb0eea8a706c4c34a16891f84e7b'),
(2, 'Heitor', 'gibson', '01cfcd4f6b8770febfb40cb906715822'),
(3, 'Heitor Fasina', 'hector', '4e65790041f1d82c540bae8341246dd5'),
(4, 'Graciete', 'graefoda', 'ea5936e874b23b9ecbe1d32e1368dd8e');

-- --------------------------------------------------------

--
-- Table structure for table `requisicoes`
--

CREATE TABLE `requisicoes` (
  `ID_REQUISICAO` int NOT NULL,
  `nome_vestibular` varchar(50) NOT NULL,
  `DATA_INICIO` date NOT NULL,
  `DATA_FIM` date NOT NULL,
  `descricao` varchar(300) DEFAULT NULL,
  `autor` varchar(50) NOT NULL,
  `id_autor` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `aquisicoes`
--
ALTER TABLE `aquisicoes`
  ADD PRIMARY KEY (`ID_AQUISICAO`),
  ADD UNIQUE KEY `ID_REQUISICAO` (`ID_REQUISICAO`),
  ADD UNIQUE KEY `id_autor` (`id_autor`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `requisicoes`
--
ALTER TABLE `requisicoes`
  ADD PRIMARY KEY (`ID_REQUISICAO`),
  ADD UNIQUE KEY `id_autor` (`id_autor`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `aquisicoes`
--
ALTER TABLE `aquisicoes`
  MODIFY `ID_AQUISICAO` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `ID` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `requisicoes`
--
ALTER TABLE `requisicoes`
  MODIFY `ID_REQUISICAO` int NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
