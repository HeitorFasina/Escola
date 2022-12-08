-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: b2no9qi14ndhhpe0o9w2-mysql.services.clever-cloud.com:3306
-- Generation Time: Dec 08, 2022 at 06:38 PM
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
  `link` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `autor` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `id_autor` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `requisicoes`
--

CREATE TABLE `requisicoes` (
  `ID_REQUISICAO` int NOT NULL,
  `nome_vestibular` varchar(50) NOT NULL,
  `DATA_INICIO` date NOT NULL,
  `DATA_FIM` date NOT NULL,
  `link` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `autor` varchar(50) NOT NULL,
  `id_autor` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `requisicoes`
--

INSERT INTO `requisicoes` (`ID_REQUISICAO`, `nome_vestibular`, `DATA_INICIO`, `DATA_FIM`, `link`, `autor`, `id_autor`) VALUES
(1, 'Unicamp', '2022-08-10', '2022-09-11', 'https://www.comvest.unicamp.br', 'Heitor Fasina', 2);

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

CREATE TABLE `usuarios` (
  `ID` int NOT NULL,
  `privilegio` varchar(5) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `usuario` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `senha` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`ID`, `privilegio`, `nome`, `usuario`, `senha`) VALUES
(1, 'admin', 'Admin', 'admin', '21232f297a57a5a743894a0e4a801fc3'),                -- senha: admin
(2, 'user', 'Heitor Fasina', 'heitor.fasina', '827ccb0eea8a706c4c34a16891f84e7b'); -- senha: 12345

--
-- Indexes for dumped tables
--

--
-- Indexes for table `aquisicoes`
--
ALTER TABLE `aquisicoes`
  ADD PRIMARY KEY (`ID_AQUISICAO`),
  ADD UNIQUE KEY `ID_REQUISICAO` (`ID_REQUISICAO`);

--
-- Indexes for table `requisicoes`
--
ALTER TABLE `requisicoes`
  ADD PRIMARY KEY (`ID_REQUISICAO`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `aquisicoes`
--
ALTER TABLE `aquisicoes`
  MODIFY `ID_AQUISICAO` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `requisicoes`
--
ALTER TABLE `requisicoes`
  MODIFY `ID_REQUISICAO` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `ID` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
