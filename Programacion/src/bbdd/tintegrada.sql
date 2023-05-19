-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-05-2023 a las 09:23:45
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tintegrada`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compañias`
--

CREATE TABLE `compañias` (
  `Ncom` varchar(20) NOT NULL,
  `cobertura` varchar(50) NOT NULL,
  `formaPago` varchar(50) NOT NULL,
  `telcom` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `compañias`
--

INSERT INTO `compañias` (`Ncom`, `cobertura`, `formaPago`, `telcom`) VALUES
('MasMovil', 'COBERTURA', 'Tarjeta de crédito o débito, o transferencia', '900835766'),
('Movistar', 'COBERTURA', 'Tarjeta de crédito o débito', '900600253'),
('Orange', 'COBERTURA', 'Tarjeta de crédito o por transferencia', '1471'),
('Pepephone', 'COBERTURA', 'Tarjeta de credito o por transferencia', '1706'),
('Vodafone', 'COBERTURA', 'Tarjeta de crédito o débito', '900926689'),
('Yazztel', 'COBERTURA', 'Tarjeta o por transferencia', '1565'),
('Yoigo', 'COBERTURA', 'Tarjeta de crédito o débito', '622');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ofertas`
--

CREATE TABLE `ofertas` (
  `Ncom` varchar(20) NOT NULL,
  `lineas` int(11) NOT NULL,
  `precio` decimal(8,2) NOT NULL,
  `Ngigas` int(11) NOT NULL,
  `regalos` varchar(200) DEFAULT NULL,
  `Nofer` int(11) NOT NULL,
  `permanencia` int(11) NOT NULL,
  `Nmegas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ofertas`
--

INSERT INTO `ofertas` (`Ncom`, `lineas`, `precio`, `Ngigas`, `regalos`, `Nofer`, `permanencia`, `Nmegas`) VALUES
('Movistar', 1, 33.90, 1000, 'null', 1, 1, 600),
('Orange', 1, 30.95, 100, 'null', 2, 2, 500),
('Yazztel', 1, 28.95, 90, 'null', 3, 1, 300),
('Yoigo', 1, 47.00, 1000, 'null', 4, 2, 1000),
('Pepephone', 1, 50.90, 300, 'null', 5, 0, 800);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `precontrato`
--

CREATE TABLE `precontrato` (
  `DNIusuario` varchar(9) NOT NULL,
  `Nofer` int(11) NOT NULL,
  `Ncom` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `precontrato`
--

INSERT INTO `precontrato` (`DNIusuario`, `Nofer`, `Ncom`) VALUES
('12345678A', 1, 'Movistar'),
('23456789A', 2, 'Orange'),
('34557891A', 3, 'Yazztel'),
('34567891A', 4, 'Yoigo'),
('34567895A', 5, 'Pepephone');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarifa`
--

CREATE TABLE `tarifa` (
  `Ncom` varchar(20) NOT NULL,
  `M300` decimal(8,2) DEFAULT NULL,
  `M500` decimal(8,2) DEFAULT NULL,
  `M600` decimal(8,2) DEFAULT NULL,
  `M800` decimal(8,2) DEFAULT NULL,
  `G1` decimal(8,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tarifa`
--

INSERT INTO `tarifa` (`Ncom`, `M300`, `M500`, `M600`, `M800`, `G1`) VALUES
('Movistar', 29.90, NULL, 33.90, NULL, 43.90),
('Yoigo', 32.00, NULL, 42.00, NULL, 47.00),
('Yazztel', 28.95, NULL, 32.95, NULL, 33.95),
('Pepephone', NULL, 42.90, NULL, 50.90, NULL),
('MasMovil', 24.99, NULL, 29.99, NULL, 34.99),
('Orange', NULL, NULL, 30.40, NULL, 41.30);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `DNI` varchar(9) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`DNI`, `nombre`, `apellidos`, `telefono`, `correo`, `password`) VALUES
('12345678A', 'German', 'Martin Fernandez', '678 34 69 74', 'ger@gmail.com', '1234'),
('23456789A', 'Alejandro', 'Tenorio', '645 76 34 23', 'teno@gmail.com', '1234'),
('34557891A', 'Ilias', 'Amezou', '666 23 67 34', 'ilias@gmail.com', '1234'),
('34567891A', 'Oscar', 'Garcia Otermin', '685 45 56 64', 'oscar@gmail.com', '1234'),
('34567895A', 'Diego', 'Rodriguez', '678 98 23 24', 'diego@gmail.com', '1234');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
