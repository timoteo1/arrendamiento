-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-05-2022 a las 21:12:47
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `myhotel`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `automovil`
--

CREATE TABLE `automovil` (
  `AUTOMOVIL_ID` int(10) NOT NULL,
  `TIPO` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `PUERTAS` decimal(6,0) NOT NULL,
  `PASAJEROS` decimal(6,0) NOT NULL,
  `CAPACIDAD_MALETERO` decimal(10,0) NOT NULL,
  `PATENTE_AUTOMOVIL` varchar(10) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `automovil`
--

INSERT INTO `automovil` (`AUTOMOVIL_ID`, `TIPO`, `PUERTAS`, `PASAJEROS`, `CAPACIDAD_MALETERO`, `PATENTE_AUTOMOVIL`) VALUES
(2, 'auto', '5', '4', '1000', 'ABC 1523'),
(3, 'auto', '5', '4', '1000', 'ABC 127');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `camion`
--

CREATE TABLE `camion` (
  `CAMION_ID` int(10) NOT NULL,
  `TIPO` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `TONELAJE` decimal(10,0) NOT NULL,
  `EJES` decimal(2,0) NOT NULL,
  `PATENTE_CAMION` varchar(10) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mantenciones`
--

CREATE TABLE `mantenciones` (
  `MANTENCIONES_ID` int(10) NOT NULL,
  `KM` decimal(10,0) NOT NULL,
  `DETALLE` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `PATENTE_MANTENCION` varchar(10) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `mantenciones`
--

INSERT INTO `mantenciones` (`MANTENCIONES_ID`, `KM`, `DETALLE`, `PATENTE_MANTENCION`) VALUES
(2, '10000', 'cambio de filtro y aceite', 'ABC 125'),
(3, '20000', 'cambio de filtro y aceite 2', 'ABC 125');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculo`
--

CREATE TABLE `vehiculo` (
  `VEHICULO_ID` int(2) NOT NULL,
  `PATENTE` varchar(10) COLLATE utf8_spanish2_ci NOT NULL,
  `MODELO` decimal(5,0) NOT NULL,
  `ANIO` decimal(5,0) NOT NULL,
  `KILOMETRAJE` decimal(10,0) NOT NULL,
  `MARCA` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `CILINDRADA` decimal(5,0) NOT NULL,
  `FECHA_INGRESO` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `vehiculo`
--

INSERT INTO `vehiculo` (`VEHICULO_ID`, `PATENTE`, `MODELO`, `ANIO`, `KILOMETRAJE`, `MARCA`, `CILINDRADA`, `FECHA_INGRESO`) VALUES
(6, 'ABC 125', '2115', '2018', '50000', '', '1000', '2022-05-22'),
(7, 'ABC 1523', '2115', '2018', '50000', '', '1000', '2022-05-22'),
(8, 'ABC 126', '2115', '2018', '50000', 'Nissan', '1000', '2022-05-23'),
(9, 'ABC 127', '2115', '2018', '50000', 'Nissan', '1000', '2022-05-23');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `automovil`
--
ALTER TABLE `automovil`
  ADD PRIMARY KEY (`AUTOMOVIL_ID`),
  ADD KEY `PATENTE_AUTOMOVIL` (`PATENTE_AUTOMOVIL`);

--
-- Indices de la tabla `camion`
--
ALTER TABLE `camion`
  ADD PRIMARY KEY (`CAMION_ID`),
  ADD KEY `PATENTE_CAMION` (`PATENTE_CAMION`);

--
-- Indices de la tabla `mantenciones`
--
ALTER TABLE `mantenciones`
  ADD PRIMARY KEY (`MANTENCIONES_ID`),
  ADD KEY `PATENTE_MANTENCION` (`PATENTE_MANTENCION`);

--
-- Indices de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD PRIMARY KEY (`VEHICULO_ID`),
  ADD UNIQUE KEY `PATENTE` (`PATENTE`),
  ADD UNIQUE KEY `PATENTE_2` (`PATENTE`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `automovil`
--
ALTER TABLE `automovil`
  MODIFY `AUTOMOVIL_ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `camion`
--
ALTER TABLE `camion`
  MODIFY `CAMION_ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `mantenciones`
--
ALTER TABLE `mantenciones`
  MODIFY `MANTENCIONES_ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  MODIFY `VEHICULO_ID` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `automovil`
--
ALTER TABLE `automovil`
  ADD CONSTRAINT `automovil_ibfk_1` FOREIGN KEY (`PATENTE_AUTOMOVIL`) REFERENCES `vehiculo` (`PATENTE`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `camion`
--
ALTER TABLE `camion`
  ADD CONSTRAINT `camion_ibfk_1` FOREIGN KEY (`PATENTE_CAMION`) REFERENCES `vehiculo` (`PATENTE`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `mantenciones`
--
ALTER TABLE `mantenciones`
  ADD CONSTRAINT `mantenciones_ibfk_1` FOREIGN KEY (`PATENTE_MANTENCION`) REFERENCES `vehiculo` (`PATENTE`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
