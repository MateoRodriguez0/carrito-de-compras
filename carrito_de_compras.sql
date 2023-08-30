-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 25-08-2023 a las 20:44:28
-- Versión del servidor: 8.0.31
-- Versión de PHP: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `carrito de compras`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

DROP TABLE IF EXISTS `categorias`;
CREATE TABLE IF NOT EXISTS `categorias` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(35) DEFAULT NULL,
  `descripcion` text,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`Id`, `nombre`, `descripcion`) VALUES
(1, 'Vehículos', 'Automóviles, motocicletas y vehículos en general.'),
(2, 'Supermercado', 'Productos alimenticios y de consumo diario.'),
(3, 'Tecnología', 'Dispositivos electrónicos y tecnológicos.'),
(4, 'Electrodomésticos', 'Electrodomésticos para el hogar.'),
(5, 'Hogar y Muebles', 'Muebles y decoración para el hogar.'),
(6, 'Deportes y Fitness', 'Equipos y accesorios para deportes y actividad física.'),
(7, 'Belleza y Cuidado Personal', 'Productos y tratamientos de belleza y cuidado personal.'),
(8, 'Accesorios para Vehículos', 'Accesorios y piezas para vehículos.'),
(9, 'Herramientas', 'Herramientas y equipos para diversos usos.'),
(10, 'Construcción', 'Materiales y productos para la construcción.'),
(11, 'Inmuebles', 'Compra, venta y alquiler de propiedades e inmuebles.'),
(12, 'Compra Internacional', 'Productos importados y compras internacionales.'),
(13, 'Moda', 'Ropa, calzado y accesorios de moda.'),
(14, 'Juegos y Juguetes', 'Juegos, juguetes y entretenimiento.'),
(15, 'Bebés', 'Productos y artículos para bebés.'),
(16, 'Productos Sustentables', 'Productos amigables con el medio ambiente.'),
(17, 'Salud y Equipamiento Médico', 'Equipos y productos para la salud y cuidado médico.'),
(18, 'Industrias y Oficinas', 'Equipos y suministros para industrias y oficinas.'),
(19, 'Servicios', 'Diversos servicios ofrecidos por profesionales y empresas.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos en carrito`
--

DROP TABLE IF EXISTS `productos en carrito`;
CREATE TABLE IF NOT EXISTS `productos en carrito` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `IdProducto_Stock` int NOT NULL,
  `IdCliente` int NOT NULL,
  `cantidad seleccionada` int NOT NULL,
  `fecha de agregado` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`Id`),
  KEY `fk_IdProducto_Stock` (`IdProducto_Stock`),
  KEY `Fk_idCliente` (`IdCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos en stock`
--

DROP TABLE IF EXISTS `productos en stock`;
CREATE TABLE IF NOT EXISTS `productos en stock` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `descripcion` text,
  `IdCategoria` int NOT NULL,
  `precio` double DEFAULT NULL,
  `cantidad disponible` int NOT NULL,
  `IdVendedor` int NOT NULL,
  `fecha de publicacion` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`Id`),
  KEY `FK_IdCategoria` (`IdCategoria`),
  KEY `FK_IdUsuario` (`IdVendedor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`Id`, `nombre`) VALUES
(1, 'Cliente'),
(2, 'Vendedor');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `nombre de usuario` varchar(20) NOT NULL,
  `correo electronico` varchar(50) NOT NULL,
  `password` varchar(15) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `fecha de nacimiento` date NOT NULL,
  `IdRol` int NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `correo electronico` (`correo electronico`),
  KEY `IdRol` (`IdRol`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `productos en carrito`
--
ALTER TABLE `productos en carrito`
  ADD CONSTRAINT `Fk_idCliente` FOREIGN KEY (`IdCliente`) REFERENCES `usuarios` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Fk_idProducto_Stock` FOREIGN KEY (`IdProducto_Stock`) REFERENCES `productos en stock` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `productos en stock`
--
ALTER TABLE `productos en stock`
  ADD CONSTRAINT `FK_IdCategoria` FOREIGN KEY (`IdCategoria`) REFERENCES `categorias` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_IdUsuario` FOREIGN KEY (`IdVendedor`) REFERENCES `usuarios` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`IdRol`) REFERENCES `roles` (`Id`) ON DELETE RESTRICT ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
