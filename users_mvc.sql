-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-07-2023 a las 05:21:00
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `users_mvc`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `client`
--

CREATE TABLE `client` (
  `Id` int(11) NOT NULL,
  `FirstName` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `LastName` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `BirthDate` date DEFAULT NULL,
  `Active` bit(1) DEFAULT NULL,
  `TypeId` smallint(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `client`
--

INSERT INTO `client` (`Id`, `FirstName`, `LastName`, `BirthDate`, `Active`, `TypeId`) VALUES
(1, 'Andrés', 'Cortés', '2000-01-01', b'1', 1),
(2, 'Nicolas', 'Aguilera', '1980-02-25', b'1', 2),
(3, 'Haiver', 'De Lopez', '1980-02-25', b'1', 3),
(4, 'Sergio', 'Castro', '2005-08-25', b'1', 4),
(5, 'Jhon', 'Botero', '1999-12-25', b'1', 5),
(6, 'Carlos', 'Gaviria', '1952-08-01', b'1', 6),
(7, 'Roger', 'Federer', '1989-08-01', b'1', 1),
(8, 'Thom', 'York', '1952-05-01', b'1', 1),
(9, 'Gustavo', 'Cerati', '1952-08-01', b'1', 4),
(10, 'Diego', 'Cortés', '1997-08-01', b'1', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `client_type`
--

CREATE TABLE `client_type` (
  `Id` smallint(6) NOT NULL,
  `Name` varchar(100) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `Active` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `client_type`
--

INSERT INTO `client_type` (`Id`, `Name`, `Active`) VALUES
(1, 'Frecuente', b'1'),
(2, 'Espontaneo', b'1'),
(3, 'Peligroso', b'1'),
(4, 'Sospechoso', b'1'),
(5, 'Pide fiado', b'1'),
(6, 'Paga con billetes falsos', b'1');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `Id_UNIQUE` (`Id`),
  ADD KEY `FK_client_type_idx` (`TypeId`);

--
-- Indices de la tabla `client_type`
--
ALTER TABLE `client_type`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `Id_UNIQUE` (`Id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `client`
--
ALTER TABLE `client`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `FK_client_type` FOREIGN KEY (`TypeId`) REFERENCES `client_type` (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
