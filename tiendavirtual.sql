-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-12-2023 a las 17:07:25
-- Versión del servidor: 8.2.0
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tiendavirtual`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `ActualizarEstadoProducto` (IN `p_productolD` INT, IN `p_disponible` TINYINT)   BEGIN
    UPDATE Producto
    SET disponible = p_disponible
    WHERE productolD = p_productolD;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `AgregarProducto` (IN `p_nom_producto` VARCHAR(50), IN `p_descripcion` VARCHAR(200), IN `p_precio` DECIMAL(10,2), IN `p_stock` INT)   BEGIN
    INSERT INTO Producto (nom_producto, descripcion, precio, stock)
    VALUES (p_nom_producto, p_descripcion, p_precio, p_stock);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `BuscarProducto` (IN `p_titulo` VARCHAR(50), IN `p_categoria` VARCHAR(50))   BEGIN
    SELECT *
    FROM Producto
    WHERE nom_producto LIKE CONCAT('%', p_titulo, '%') OR
          descripcion LIKE CONCAT('%', p_categoria, '%');
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `EliminarProducto` (IN `p_productolD` INT)   BEGIN
    DELETE FROM Producto
    WHERE productolD = p_productolD;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administradores`
--

CREATE TABLE `administradores` (
  `administradorID` int NOT NULL,
  `nom_administrador` varchar(50) NOT NULL,
  `pwd_administrador` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `clientelD` int NOT NULL,
  `name` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL,
  `CorreoElectronico` varchar(50) NOT NULL,
  `acceso` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`clientelD`, `name`, `pass`, `CorreoElectronico`, `acceso`) VALUES
(5, 'manu', '1234', 'manu@gmail.com', b'0'),
(7, 'Wilgrey', '1234', 'wilgreyravelocruz@gmail.com', b'0'),
(8, 'zapato', '1234', 'zapatp@gmail.com', b'0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orden_producto`
--

CREATE TABLE `orden_producto` (
  `pedidoID` int NOT NULL,
  `productoID` int NOT NULL,
  `cantidad` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paises`
--

CREATE TABLE `paises` (
  `pais` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `pedidoID` int NOT NULL,
  `clienteID` int NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `productolD` int NOT NULL,
  `nom_producto` varchar(50) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `Cantidad` int NOT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `disponible` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`productolD`, `nom_producto`, `descripcion`, `precio`, `Cantidad`, `imagen`, `disponible`) VALUES
(1, 'Xiaomi Redmi note 9', 'telefono de la marca china xioami recomendado por su exelente caldiad precio', 13000.00, 6, 'https://xiaomioficial.pe/media/catalog/product/cache/91d455d9a08b443f40815d5c97058103/c/e/ce001xia67_portada.png', 1),
(2, 'Xiaomi redmi note 12 pro', 'Telefono de xiaomi muy recomendado', 14000.00, 10, 'https://locosphone.com/wp-content/uploads/2023/02/7dbbd2e1be5c6e0f07e2bc770c179935800x80085.png', 1),
(4, 'Samsung TV 42 Pulgadas', 'Tv inteligente prefecta para mirar streaming', 15.00, 24, 'https://tienda.claro.com.do/content/images/thumbs/0030898_smart-tv-samsung-43_550.png', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transacciones`
--

CREATE TABLE `transacciones` (
  `transaccionID` int NOT NULL,
  `pedidoID` int NOT NULL,
  `monto_total` decimal(10,2) NOT NULL,
  `estado` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ubicacion`
--

CREATE TABLE `ubicacion` (
  `direccion` varchar(100) NOT NULL,
  `ciudad` varchar(50) NOT NULL,
  `pais` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administradores`
--
ALTER TABLE `administradores`
  ADD PRIMARY KEY (`administradorID`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`clientelD`);

--
-- Indices de la tabla `orden_producto`
--
ALTER TABLE `orden_producto`
  ADD PRIMARY KEY (`pedidoID`,`productoID`),
  ADD KEY `productoID` (`productoID`);

--
-- Indices de la tabla `paises`
--
ALTER TABLE `paises`
  ADD PRIMARY KEY (`pais`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`pedidoID`),
  ADD KEY `clienteID` (`clienteID`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`productolD`);

--
-- Indices de la tabla `transacciones`
--
ALTER TABLE `transacciones`
  ADD PRIMARY KEY (`transaccionID`),
  ADD KEY `pedidoID` (`pedidoID`);

--
-- Indices de la tabla `ubicacion`
--
ALTER TABLE `ubicacion`
  ADD PRIMARY KEY (`direccion`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `administradores`
--
ALTER TABLE `administradores`
  MODIFY `administradorID` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `clientelD` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `pedidoID` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `productolD` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `transacciones`
--
ALTER TABLE `transacciones`
  MODIFY `transaccionID` int NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `orden_producto`
--
ALTER TABLE `orden_producto`
  ADD CONSTRAINT `orden_producto_ibfk_1` FOREIGN KEY (`pedidoID`) REFERENCES `pedido` (`pedidoID`),
  ADD CONSTRAINT `orden_producto_ibfk_2` FOREIGN KEY (`productoID`) REFERENCES `producto` (`productolD`);

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`clienteID`) REFERENCES `clientes` (`clientelD`);

--
-- Filtros para la tabla `transacciones`
--
ALTER TABLE `transacciones`
  ADD CONSTRAINT `transacciones_ibfk_1` FOREIGN KEY (`pedidoID`) REFERENCES `pedido` (`pedidoID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
