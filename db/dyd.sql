-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-01-2019 a las 21:54:17
-- Versión del servidor: 10.1.37-MariaDB
-- Versión de PHP: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dyd`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `armaduras`
--

CREATE TABLE `armaduras` (
  `id_armaduras` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `precio` int(11) NOT NULL,
  `boni_CA` int(11) NOT NULL,
  `boni_defensa` int(11) NOT NULL,
  `penalizador` int(11) NOT NULL,
  `fallo_conjuro` varchar(50) NOT NULL,
  `velocidad` varchar(50) NOT NULL,
  `peso` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `armaduras`
--

INSERT INTO `armaduras` (`id_armaduras`, `nombre`, `precio`, `boni_CA`, `boni_defensa`, `penalizador`, `fallo_conjuro`, `velocidad`, `peso`) VALUES
(1, 'Acolchada', 5, 1, 8, 0, '5%', '30\'', '10'),
(2, 'Cuero', 10, 2, 6, 0, '10%', '30\'', '15'),
(3, 'Cuero Tachonado', 25, 3, 5, 0, '15%', '30\'', '20'),
(4, 'Camisote de mallas', 100, 4, 4, 0, '20%', '30\'', '25'),
(5, 'Pieles', 15, 3, 4, 0, '20%', '30\'', '25'),
(6, 'Cota de Escamas', 50, 4, 3, 0, '20%', '20\'', '25'),
(7, 'Coraza', 200, 5, 2, 0, '25%', '20\'', '30'),
(8, 'Armadura Laminada', 200, 6, 0, 0, '40%', '20\'', '45'),
(9, 'Cota de Bandas', 250, 6, 0, 0, '35%', '20', '45'),
(10, 'Armadura de placas', 600, 7, 0, 0, '40%', '20', '50'),
(11, 'Armadura Completa', 1500, 8, 1, 0, '35%', '20\'', '50'),
(12, 'Broquel o Rodela', 15, 1, 0, 0, '5%', '20%', '6'),
(13, 'Escudo ligero de madera', 3, 1, 0, 0, '5%', '0', '10'),
(14, 'Escudo pesado de madera', 7, 2, 0, 0, '15%', '0', '15'),
(15, 'Escudo pesado de acero', 20, 2, 0, 0, '50%', '0', '50'),
(16, 'Escudo paves', 30, 4, 0, 0, '50%', '0', '50'),
(17, 'Guantelete de sujeccion', 8, 0, 0, 0, '50%', '0', '5'),
(18, 'Puas para armadura', 8, 0, 0, 0, '25%', '0', '5'),
(19, 'Puas para escudo', 10, 0, 0, 0, '25%', '0', '10');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `armas`
--

CREATE TABLE `armas` (
  `id_armas` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `precio` int(11) NOT NULL,
  `danio` varchar(50) NOT NULL,
  `critico` varchar(50) NOT NULL,
  `distancia` varchar(50) NOT NULL,
  `peso` int(11) NOT NULL,
  `tipo_danio` varchar(50) NOT NULL,
  `artefacto` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `armas`
--

INSERT INTO `armas` (`id_armas`, `nombre`, `precio`, `danio`, `critico`, `distancia`, `peso`, `tipo_danio`, `artefacto`) VALUES
(1, 'Guantelete', 2, '1d3', '20x2', '-', 1, 'Contundente', '-'),
(2, 'Daga', 2, '1d4', '19-20x2', '10', 1, 'Cortante/Perforante', '-'),
(3, 'Hoz', 6, '1d6', '20x2', '-', 2, 'Cortante', '-'),
(4, 'Maza Ligera', 5, '1d6', '20x2', '-', 4, 'Contundente', '-'),
(5, 'Puñal', 1, '1d4', '20x3', '-', 1, 'Perforante', '-'),
(6, 'Clava', 8, '1d6', '20x2', '10\'', 3, 'Contudente', '-'),
(7, 'Maza de Armas', 8, '1d6', '20x2', '-', 6, 'Contundente/Perforante', '-'),
(8, 'Maza Pesada', 12, '1d8', '20x2', '-', 8, 'Contudente', '-'),
(9, 'Lanza Corta', 1, '1d4', '20x2', '20\'', 3, 'Perforante', '-'),
(10, 'Bastón', 0, '1d6/1d4', '20x2', '-', 4, 'Contundente', '-'),
(11, 'Lanza', 2, '1d8', '20x3', '10\'', 4, 'Perforante', '-'),
(13, 'Ballesta Ligera', 12, '1d8', '19-20x2', '80\'', 4, 'Perforante', '-'),
(14, 'Ballesta Pesada', 20, '1d10', '19-20x2', '120\'', 8, 'Perforante', '-'),
(15, 'Honda', 8, '1d4', '20x2', '50\'', 0, 'Contundente', '-'),
(16, 'Cimitarra', 12, '1d6', '18-20x2', '-', 4, 'Cortante', '-'),
(17, 'Espada Larga', 15, '1d6', '19-20x2', '-', 4, 'Cortante', '-'),
(18, 'Estoque', 20, '1d6', '18-20x2', '-', 5, 'Perforante', '-'),
(19, 'Hacha de Batalla', 12, '1d8', '20x3', '-', 6, 'Cortante', '-'),
(20, 'Mangual', 8, '1d8', '20x2', '-', 5, 'Contundente', '-'),
(21, 'Martillo de Guerra', 12, '1d8', '20x3', '5', 0, 'Contundente', '-'),
(22, 'Pico Pesado', 8, '1d4', '20x4', '-', 6, 'Perforante', '-'),
(23, 'Tridente', 15, '1d8', '20x2', '10\'', 4, 'Perforante', '-'),
(24, 'Alabarda', 10, '1d10', '20x3', '-', 12, 'Cortante', '-'),
(25, 'Alfajon', 75, '2d6', '20x3', '-', 8, 'Cortante', '-'),
(26, 'Espadon', 50, '1d10', '19-20x2', '-', 10, 'Cortante', '-'),
(27, 'Gran Clava', 5, '1d10', '20x2', '-', 8, 'Contundente', '-'),
(28, 'Gran Hacha', 20, '1d12', '20x3', '-', 12, 'Cortante', '-'),
(29, 'Guadaña', 18, '2d4', '20x4', '-', 10, 'Cortante o Perforante', '-'),
(30, 'Lanza de Caballeria', 10, '1d8', '20x3', '-', 10, 'Perforante', '-'),
(31, 'Mangual pesado', 15, '1d10', '19-20x2', '-', 10, 'Contundente', '-'),
(32, 'Ronca', 10, '2d4', '20x3', '-', 10, 'Perforante', '-'),
(33, 'Arco Corto', 30, '1d6', '20x3', '60\'', 2, 'Perforante', '-'),
(34, 'Arco corto compuesto', 75, '1d6', '20x3', '70\'', 5, 'Perforante', '-'),
(35, 'Arco Largo', 75, '1d8', '20x3', '100\'', 4, 'Perforante', '-'),
(36, 'Arco largo Compuesto', 100, '1d8', '20x3', '110\'', 5, 'Perforante', '-'),
(37, 'Kama', 2, '1d6', '20x2', '-', 12, 'Perforante', '-'),
(38, 'Nunchaku', 2, '1d6', '20x2', '-', 6, 'Perforante', '-'),
(39, 'Sai', 1, '1d3', '20x2', '10\'', 5, 'Perforante', '-'),
(40, 'Siagham', 3, '1d4', '20x2', '-', 8, 'Perforante', '-'),
(41, 'Espada Bastarda', 35, '1d10', '19-20x2', '-', 2, 'Cortante', '-'),
(42, 'Hacha de guerra Enana', 30, '1d10', '19-20x2', '-', 8, 'Cortante', '-'),
(43, 'Espada de Dos Hojas', 150, '1d8/1d8', '20x3', '-', 10, 'Cortante', '-'),
(44, 'Hacha doble Orca', 60, '1d8/1d8', '20x3', '-', 15, 'Cortante', '-'),
(45, 'Mangual Doble', 90, '1d8/1d8', '20x3', '-', 10, 'Contundente', '-'),
(46, 'Balleste de Mano', 100, '1d4', '19-20x2', '30\'', 2, 'Perforante', '-'),
(47, 'Ballesta de Repeticion Ligera', 250, '1d8', '19-20x2', '30\'', 2, 'Perforante', '-'),
(48, 'Shuriken', 1, '1d4', '20x2', '10\'', 1, 'Perforante', '-');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `experiencia`
--

CREATE TABLE `experiencia` (
  `id_experiencia` int(12) NOT NULL,
  `nivel_personaje` int(12) NOT NULL,
  `vd1` varchar(120) NOT NULL,
  `vd2` varchar(120) NOT NULL,
  `vd3` varchar(120) NOT NULL,
  `vd4` varchar(120) NOT NULL,
  `vd5` varchar(120) NOT NULL,
  `vd6` varchar(120) NOT NULL,
  `vd7` varchar(120) NOT NULL,
  `vd8` varchar(120) NOT NULL,
  `vd9` varchar(120) NOT NULL,
  `vd10` varchar(120) NOT NULL,
  `vd11` varchar(120) NOT NULL,
  `vd12` varchar(120) NOT NULL,
  `vd13` varchar(120) NOT NULL,
  `vd14` varchar(120) NOT NULL,
  `vd15` varchar(120) NOT NULL,
  `vd16` varchar(120) NOT NULL,
  `vd17` varchar(120) NOT NULL,
  `vd18` varchar(120) NOT NULL,
  `vd19` varchar(120) NOT NULL,
  `vd20` varchar(120) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `experiencia`
--

INSERT INTO `experiencia` (`id_experiencia`, `nivel_personaje`, `vd1`, `vd2`, `vd3`, `vd4`, `vd5`, `vd6`, `vd7`, `vd8`, `vd9`, `vd10`, `vd11`, `vd12`, `vd13`, `vd14`, `vd15`, `vd16`, `vd17`, `vd18`, `vd19`, `vd20`) VALUES
(1, 1, '300', '600', '900', '1350', '1800', '2700', '3600', '5400', '7200', '10000', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*'),
(2, 4, '300', '600', '800', '1200', '1500', '2250', '3000', '4500', '6000', '9600', '12800', '*', '*', '*', '*', '*', '*', '*', '*', '*'),
(3, 5, '300', '500', '750', '1000', '1500', '2250', '3000', '4500', '6000', '9000', '12000', '18000', '*', '*', '*', '*', '*', '*', '*', '*'),
(4, 6, '300', '450', '600', '900', '1200', '1800', '2100', '3150', '4200', '6300', '10800', '14400', '21600', '*', '*', '*', '*', '*', '*', '*'),
(5, 7, '263', '394', '525', '700', '1050', '1400', '2100', '3150', '4200', '6300', '8400', '12600', '16800', '25200', '*', '*', '*', '*', '*', '*'),
(6, 8, '200', '300', '450', '600', '800', '1200', '1600', '2400', '3600', '4800', '7200', '9600', '14400', '19200', '28800', '**', '**', '**', '**', '**'),
(7, 9, '*', '225', '338', '603', '900', '1300', '1800', '2700', '4050', '5400', '8100', '10800', '16200', '21600', '324000', '**', '**', '**', '**', '*'),
(8, 10, '*', '*', '*', '*', '*', '250', '375', '563', '750', '1000', '1500', '2000', '3000', '4500', '6000', '9000', '12000', '18000', '**', '**'),
(9, 11, '*', '*', '*', '*', '*', '619', '825', '1100', '1650', '2200', '3300', '4950', '6600', '9900', '13200', '19800', '26400', '39600', '**', '**'),
(10, 12, '*', '*', '*', '*', '*', '450', '675', '900', '1200', '1800', '2400', '3600', '5400', '7200', '10800', '14400', '21600', '28800', '43200', '**'),
(11, 13, '*', '*', '*', '*', '*', '*', '350', '525', '788', '1050', '1959', '2600', '3900', '5850', '7800', '11700', '15600', '23400', '31200', '46800'),
(12, 14, '*', '*', '*', '*', '*', '*', '350', '525', '788', '1050', '1400', '2100', '2800', '4200', '6300', '8400', '12600', '16800', '25200', '33660'),
(13, 15, '*', '*', '*', '*', '*', '*', '*', '*', '375', '563', '844', '1125', '1500', '2250', '3200', '4800', '7200', '9600', '14400', '19200'),
(14, 16, '*', '*', '*', '*', '*', '*', '*', '*', '400', '425', '900', '1200', '1600', '2400', '3200', '4800', '7200', '9600', '14400', '19200'),
(15, 17, '*', '*', '*', '*', '*', '*', '*', '*', '*', '425', '638', '956', '1275', '1700', '2550', '3400', '5100', '7650', '10200', '15300'),
(16, 18, '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '638', '956', '1275', '1700', '2550', '3400', '5100', '7650', '10200', '15300'),
(17, 19, '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '475', '713', '1069', '1425', '1900', '2850', '3800', '5700', '8550'),
(18, 20, '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '500', '750', '1000', '1500', '2000', '3000', '4000', '6000');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `objetos_basicos`
--

CREATE TABLE `objetos_basicos` (
  `id_objetos` int(11) NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `precio` int(11) NOT NULL,
  `peso` int(11) NOT NULL,
  `danio` varchar(50) NOT NULL,
  `curacion` varchar(50) NOT NULL,
  `descripcion` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `objetos_basicos`
--

INSERT INTO `objetos_basicos` (`id_objetos`, `nombre`, `precio`, `peso`, `danio`, `curacion`, `descripcion`) VALUES
(1, 'Abrojos', 1, 2, '-', '-', '-'),
(2, 'Aceite', 1, 1, '-', '-', '-'),
(3, 'Aguja de costura', 1, 0, '-', '-', '-'),
(4, 'Antorcha', 1, 1, '-', '-', '-'),
(5, 'Anzuelo', 1, 0, '-', '-', '-'),
(6, 'Aparejo de poleas', 5, 5, '-', '-', '-'),
(7, 'Ariete portatil', 10, 20, '-', '-', '-'),
(8, 'Barril', 2, 30, '-', '-', '-'),
(9, 'Botella de vino', 2, 0, '-', '-', '-'),
(10, 'Botija', 3, 9, '-', '-', '-'),
(11, 'Cadena', 30, 2, '-', '-', '-'),
(12, 'Calamo', 1, 0, '-', '-', '-'),
(13, 'Catalejo', 1000, 1, '-', '-', '-'),
(14, 'Cerradura', 20, 1, '-', '-', 'Sencilla'),
(15, 'Cerradura', 40, 1, '-', '-', 'Corriente'),
(16, 'Cerradura', 80, 1, '-', '-', 'Calidad'),
(18, 'Cofre', 2, 25, '-', '-', '-'),
(19, 'Cesto', 4, 0, '-', '-', '-'),
(20, 'Cuerda de Cañamo', 1, 10, '-', '-', '-'),
(21, 'Cuerda de Seda', 10, 5, '-', '-', '-'),
(22, 'Escalera de mano', 5, 20, '-', '-', '-'),
(23, 'Estuche', 1, 1, '-', '-', '-'),
(24, 'Frasco', 3, 0, '-', '-', '-'),
(25, 'Garfio de escalada', 1, 4, '-', '-', '-'),
(26, 'Acido', 10, 1, '-', '-', '-'),
(27, 'Agua Bendita', 25, 1, '-', '-', '-'),
(28, 'Ahumareda', 20, 1, '-', '-', '-'),
(29, 'Antorcha siempreardiente', 110, 1, '-', '-', '-'),
(30, 'Bolsa de maraña', 50, 4, '-', '-', '-'),
(31, 'Cetro solar', 2, 1, '-', '-', '-'),
(32, 'Contraveneno', 50, 0, '-', '-', '-'),
(33, 'Fuego de alquimia', 20, 1, '-', '-', '-'),
(33, 'Piedra de trueno', 30, 1, '-', '-', '-'),
(34, 'Ramita yesquera', 1, 0, '-', '-', '-'),
(35, 'Acebo y muerdago', 0, 0, '-', '-', '-'),
(36, 'Balanza de mercader', 2, 1, '-', '-', '-'),
(37, 'Herramientas de gran calidad', 50, 1, '-', '-', '-'),
(38, 'Herramientas para artesano', 5, 5, '-', '-', '-'),
(39, 'Herramientas de ladron', 30, 1, '-', '-', '-'),
(40, 'Herramientas de GC ladron', 100, 3, '-', '-', '-'),
(41, 'Laboratorio de alquimia', 500, 40, '-', '-', '-'),
(42, 'Intrumento musical', 5, 3, '-', '-', '-'),
(43, 'I.musical de GC', 100, 3, '-', '-', '-'),
(44, 'Libro de conjuros', 15, 3, '-', '-', '-'),
(45, 'Lupa', 100, 0, '-', '-', '-'),
(46, 'Material de disfraz', 50, 8, '-', '-', '-'),
(47, 'Material de escalada', 80, 5, '-', '-', '-'),
(48, 'Alforjas', 4, 8, '-', '-', '-'),
(49, 'Bardas', 150, 6, '-', '-', '-'),
(50, 'Bocado y brida', 2, 1, '-', '-', '-'),
(1, 'Abrojos', 1, 2, '-', '-', '-'),
(2, 'Aceite', 1, 1, '-', '-', '-'),
(3, 'Aguja de costura', 1, 0, '-', '-', '-'),
(4, 'Antorcha', 1, 1, '-', '-', '-'),
(5, 'Anzuelo', 1, 0, '-', '-', '-'),
(6, 'Aparejo de poleas', 5, 5, '-', '-', '-'),
(7, 'Ariete portatil', 10, 20, '-', '-', '-'),
(8, 'Barril', 2, 30, '-', '-', '-'),
(9, 'Botella de vino', 2, 0, '-', '-', '-'),
(10, 'Botija', 3, 9, '-', '-', '-'),
(11, 'Cadena', 30, 2, '-', '-', '-'),
(12, 'Calamo', 1, 0, '-', '-', '-'),
(13, 'Catalejo', 1000, 1, '-', '-', '-'),
(14, 'Cerradura', 20, 1, '-', '-', 'Sencilla'),
(15, 'Cerradura', 40, 1, '-', '-', 'Corriente'),
(16, 'Cerradura', 80, 1, '-', '-', 'Calidad'),
(17, 'Cerradura', 150, 1, '-', '-', 'Asombrosa'),
(18, 'Cofre', 2, 25, '-', '-', '-'),
(19, 'Cesto', 4, 0, '-', '-', '-'),
(20, 'Cuerda de Cañamo', 1, 10, '-', '-', '-'),
(21, 'Cuerda de Seda', 10, 5, '-', '-', '-'),
(22, 'Escalera de mano', 5, 20, '-', '-', '-'),
(23, 'Estuche', 1, 1, '-', '-', '-'),
(24, 'Frasco', 3, 0, '-', '-', '-'),
(25, 'Garfio de escalada', 1, 4, '-', '-', '-'),
(26, 'Acido', 10, 1, '-', '-', '-'),
(27, 'Agua Bendita', 25, 1, '-', '-', '-'),
(28, 'Ahumareda', 20, 1, '-', '-', '-'),
(29, 'Antorcha siempreardiente', 110, 1, '-', '-', '-'),
(30, 'Bolsa de maraña', 50, 4, '-', '-', '-'),
(31, 'Cetro solar', 2, 1, '-', '-', '-'),
(32, 'Contraveneno', 50, 0, '-', '-', '-'),
(33, 'Fuego de alquimia', 20, 1, '-', '-', '-'),
(33, 'Piedra de trueno', 30, 1, '-', '-', '-'),
(34, 'Ramita yesquera', 1, 0, '-', '-', '-'),
(35, 'Acebo y muerdago', 0, 0, '-', '-', '-'),
(36, 'Balanza de mercader', 2, 1, '-', '-', '-'),
(37, 'Herramientas de gran calidad', 50, 1, '-', '-', '-'),
(38, 'Herramientas para artesano', 5, 5, '-', '-', '-'),
(39, 'Herramientas de ladron', 30, 1, '-', '-', '-'),
(40, 'Herramientas de GC ladron', 100, 3, '-', '-', '-'),
(41, 'Laboratorio de alquimia', 500, 40, '-', '-', '-'),
(42, 'Intrumento musical', 5, 3, '-', '-', '-'),
(43, 'I.musical de GC', 100, 3, '-', '-', '-'),
(44, 'Libro de conjuros', 15, 3, '-', '-', '-'),
(45, 'Lupa', 100, 0, '-', '-', '-'),
(46, 'Material de disfraz', 50, 8, '-', '-', '-'),
(47, 'Material de escalada', 80, 5, '-', '-', '-'),
(48, 'Alforjas', 4, 8, '-', '-', '-'),
(49, 'Bardas', 150, 6, '-', '-', '-'),
(50, 'Bocado y brida', 2, 1, '-', '-', '-'),
(51, 'Burro o mulo', 80, 0, '-', '-', '-'),
(52, 'Caballo ligero', 75, 0, '-', '-', '-'),
(53, 'Caballo pesado', 200, 0, '-', '-', '-'),
(54, 'Cagallo de guerra', 400, 0, '-', '-', '-'),
(55, 'Cuadras', 5, 0, '-', '-', '-'),
(56, 'Forraje', 5, 0, '-', '-', '-'),
(57, 'Perro de monta', 150, 0, '-', '-', '-'),
(58, 'Perro guardian', 25, 0, '-', '-', '-'),
(59, 'Silla Albarda', 5, 15, '-', '-', '-'),
(60, 'Silla Militar', 20, 30, '-', '-', '-'),
(61, 'Silla De Montar', 10, 25, '-', '-', '-'),
(62, 'Aguila Buscadora', 500, 0, '-', '-', '-'),
(63, 'Halcon de Presa', 750, 0, '-', '-', '-'),
(64, 'Bote de remos', 50, 100, '-', '-', '-'),
(65, 'Carreta', 34, 400, '-', '-', '-'),
(66, 'Carro', 15, 200, '-', '-', '-'),
(67, 'Carruaje', 100, 600, '-', '-', '-'),
(68, 'Chalupa', 3000, 0, '-', '-', '-'),
(69, 'Galera', 30000, 0, '-', '-', '-'),
(70, 'Nave Larga', 10000, 0, '-', '-', '-'),
(72, 'Trineo', 20, 300, '-', '-', '-'),
(71, 'Navio de Guerra', 35000, 5000, '-', '-', '-'),
(72, 'Trineo', 20, 300, '-', '-', '-'),
(73, 'Velero', 10000, 0, '-', '-', '-'),
(74, 'Empleado Entrenado', 50, 0, '-', '-', '-'),
(75, 'Diligencia', 3, 0, '-', '-', '-'),
(76, 'Mensajero', 2, 0, '-', '-', '-'),
(77, 'Pocion Leve', 50, 1, '-', '1d8', 'Cura al que lo toma'),
(78, 'Pocion Moderada', 150, 1, '-', '2d8', 'Cura al que lo toma'),
(79, 'Pocion Grave', 250, 1, '-', '3d8', 'Cura al que lo toma'),
(80, 'Pocion Critica', 450, 1, '-', '4d8', 'Cura al que lo toma'),
(81, 'Pocion Ignea', 600, 1, '6d6', '-', 'Causa un area de 20 pies a los enemigos'),
(82, 'Pocion Sanar', 750, 1, '-', '120', 'Sana casi toda la vida al que lo toma'),
(83, 'Muerte subita', 50000, 1, 'CD:32', '-', 'Tira de voluntad para no/si morir'),
(84, 'Veneno Arania', 650, 1, '4d4', '-', 'Causa un veneno a los enemigos'),
(85, 'Mata-Lobos', 1500, 1, 'CD:Fortaleza: 32', '-', 'Debe superar una tirada de foraleza para no ser hombre lobo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `objeto_maravilloso`
--

CREATE TABLE `objeto_maravilloso` (
  `id_objeto_maravilloso` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `precio` int(11) NOT NULL,
  `peso` int(11) NOT NULL,
  `tipo_de_objeto` varchar(50) NOT NULL,
  `descripcion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personaje_npc`
--

CREATE TABLE `personaje_npc` (
  `id_npc` int(11) NOT NULL,
  `fuerza` int(11) NOT NULL,
  `bon_fuerza` int(11) NOT NULL,
  `destreza` int(11) NOT NULL,
  `bon_destreza` int(11) NOT NULL,
  `constitucion` int(11) NOT NULL,
  `bon_constitucion` int(11) NOT NULL,
  `inteligencia` int(11) NOT NULL,
  `bon_inteligencia` int(11) NOT NULL,
  `sabiduria` int(11) NOT NULL,
  `bon_sabiduria` int(11) NOT NULL,
  `carisma` int(11) NOT NULL,
  `bon_carisma` int(11) NOT NULL,
  `pg` int(11) NOT NULL,
  `ca` int(11) NOT NULL,
  `iniciativa` int(11) NOT NULL,
  `ataque_base` int(11) NOT NULL,
  `armas` int(11) NOT NULL,
  `armaduras` int(11) NOT NULL,
  `habilidades` int(11) NOT NULL,
  `aptitudes` int(11) NOT NULL,
  `tipo_personaje` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesiones`
--

CREATE TABLE `profesiones` (
  `id_profesion` int(11) NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `rama` int(11) NOT NULL,
  `tipo_profesion` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `armaduras`
--
ALTER TABLE `armaduras`
  ADD PRIMARY KEY (`id_armaduras`);

--
-- Indices de la tabla `armas`
--
ALTER TABLE `armas`
  ADD PRIMARY KEY (`id_armas`);

--
-- Indices de la tabla `experiencia`
--
ALTER TABLE `experiencia`
  ADD PRIMARY KEY (`id_experiencia`);

--
-- Indices de la tabla `objeto_maravilloso`
--
ALTER TABLE `objeto_maravilloso`
  ADD PRIMARY KEY (`id_objeto_maravilloso`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `experiencia`
--
ALTER TABLE `experiencia`
  MODIFY `id_experiencia` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
