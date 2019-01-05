CREATE DATABASE  IF NOT EXISTS `laspalmeras` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `laspalmeras`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: laspalmeras
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cargo` (
  `idCargo` int(2) NOT NULL AUTO_INCREMENT,
  `Cargo` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`idCargo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `idCategoria` int(3) NOT NULL AUTO_INCREMENT,
  `Categoria` varchar(16) NOT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `idCliente` int(10) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(25) DEFAULT NULL,
  `Apellido` varchar(25) DEFAULT NULL,
  `Direccion` varchar(75) DEFAULT NULL,
  `DUI` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compra` (
  `idCompra` int(6) NOT NULL AUTO_INCREMENT,
  `idProveedor` int(5) DEFAULT NULL,
  `Fecha` date DEFAULT NULL,
  `Representante` varchar(50) DEFAULT NULL,
  `DUI` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`idCompra`),
  KEY `idProveedor` (`idProveedor`),
  CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`idProveedor`) REFERENCES `proveedor` (`idProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `detallecompra`
--

DROP TABLE IF EXISTS `detallecompra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detallecompra` (
  `idDetalleCompra` int(6) NOT NULL AUTO_INCREMENT,
  `idCompra` int(6) DEFAULT NULL,
  `idProducto` int(6) DEFAULT NULL,
  `idFechaVencimiento` int(11) DEFAULT NULL,
  `Cantidad` int(5) DEFAULT NULL,
  `PrecioUnitario` double(5,2) DEFAULT NULL,
  PRIMARY KEY (`idDetalleCompra`),
  KEY `idCompra` (`idCompra`),
  KEY `idProducto` (`idProducto`),
  KEY `idFechaVencimiento` (`idFechaVencimiento`),
  CONSTRAINT `detallecompra_ibfk_1` FOREIGN KEY (`idCompra`) REFERENCES `compra` (`idCompra`),
  CONSTRAINT `detallecompra_ibfk_2` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`),
  CONSTRAINT `detallecompra_ibfk_3` FOREIGN KEY (`idFechaVencimiento`) REFERENCES `fechavencimiento` (`idFechavencimiento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `detalleventa`
--

DROP TABLE IF EXISTS `detalleventa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalleventa` (
  `idDetalleVenta` int(25) NOT NULL AUTO_INCREMENT,
  `idProducto` int(6) DEFAULT NULL,
  `idVenta` int(10) DEFAULT NULL,
  `idFechaVencimiento` int(11) DEFAULT NULL,
  `Cantidad` int(5) DEFAULT NULL,
  `Descuento` double(4,2) DEFAULT NULL,
  PRIMARY KEY (`idDetalleVenta`),
  KEY `idProducto` (`idProducto`),
  KEY `idVenta` (`idVenta`),
  KEY `idFechaVencimiento` (`idFechaVencimiento`),
  CONSTRAINT `detalleventa_ibfk_1` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`),
  CONSTRAINT `detalleventa_ibfk_2` FOREIGN KEY (`idVenta`) REFERENCES `venta` (`idVenta`),
  CONSTRAINT `detalleventa_ibfk_3` FOREIGN KEY (`idFechaVencimiento`) REFERENCES `fechavencimiento` (`idFechavencimiento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `estadousuario`
--

DROP TABLE IF EXISTS `estadousuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estadousuario` (
  `idEstado` int(5) NOT NULL AUTO_INCREMENT,
  `idUsuario` int(5) DEFAULT NULL,
  `Estado` char(1) DEFAULT NULL,
  `inicioLaboral` date NOT NULL,
  `finLaboral` date DEFAULT NULL,
  PRIMARY KEY (`idEstado`),
  KEY `idUsuario` (`idUsuario`),
  CONSTRAINT `estadousuario_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `fechavencimiento`
--

DROP TABLE IF EXISTS `fechavencimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fechavencimiento` (
  `idFechavencimiento` int(11) NOT NULL AUTO_INCREMENT,
  `fechavencimiento` date NOT NULL,
  PRIMARY KEY (`idFechavencimiento`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `historialsalario`
--

DROP TABLE IF EXISTS `historialsalario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historialsalario` (
  `idHistorial` int(5) NOT NULL AUTO_INCREMENT,
  `idEstado` int(5) DEFAULT NULL,
  `AumentoParcial` double(4,2) DEFAULT NULL,
  PRIMARY KEY (`idHistorial`),
  KEY `idEstado` (`idEstado`),
  CONSTRAINT `historialsalario_ibfk_1` FOREIGN KEY (`idEstado`) REFERENCES `estadousuario` (`idEstado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Temporary view structure for view `inventario`
--

DROP TABLE IF EXISTS `inventario`;
/*!50001 DROP VIEW IF EXISTS `inventario`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `inventario` AS SELECT 
 1 AS `idDetalleCompra`,
 1 AS `idProducto`,
 1 AS `idFechavencimiento`,
 1 AS `fechavencimiento`,
 1 AS `Compra`,
 1 AS `Venta`,
 1 AS `Existencia`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `marca`
--

DROP TABLE IF EXISTS `marca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marca` (
  `idMarca` int(4) NOT NULL AUTO_INCREMENT,
  `Marca` varchar(16) NOT NULL,
  PRIMARY KEY (`idMarca`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `idProducto` int(6) NOT NULL AUTO_INCREMENT,
  `idCategoria` int(3) DEFAULT NULL,
  `idMarca` int(4) DEFAULT NULL,
  `Producto` varchar(60) NOT NULL,
  `Descripcion` varchar(60) DEFAULT NULL,
  `Precio` double(5,2) DEFAULT NULL,
  PRIMARY KEY (`idProducto`),
  KEY `idCategoria` (`idCategoria`),
  KEY `idMarca` (`idMarca`),
  CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`),
  CONSTRAINT `producto_ibfk_2` FOREIGN KEY (`idMarca`) REFERENCES `marca` (`idMarca`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedor` (
  `idProveedor` int(5) NOT NULL AUTO_INCREMENT,
  `Proveedor` varchar(50) DEFAULT NULL,
  `Direccion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol` (
  `idRol` int(1) NOT NULL AUTO_INCREMENT,
  `Rol` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `telefono`
--

DROP TABLE IF EXISTS `telefono`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `telefono` (
  `idTelefono` int(5) NOT NULL AUTO_INCREMENT,
  `idUsuario` int(5) DEFAULT NULL,
  `idCliente` int(10) DEFAULT NULL,
  `idProveedor` int(5) DEFAULT NULL,
  `Telefono` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idTelefono`),
  KEY `idUsuario` (`idUsuario`),
  KEY `idCliente` (`idCliente`),
  KEY `idProveedor` (`idProveedor`),
  CONSTRAINT `telefono_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`),
  CONSTRAINT `telefono_ibfk_2` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`),
  CONSTRAINT `telefono_ibfk_3` FOREIGN KEY (`idProveedor`) REFERENCES `proveedor` (`idProveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idUsuario` int(5) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(25) DEFAULT NULL,
  `Apellido` varchar(25) DEFAULT NULL,
  `DUI` varchar(11) DEFAULT NULL,
  `idRol` int(1) DEFAULT NULL,
  `idCargo` int(2) DEFAULT NULL,
  `Salario` double(6,2) DEFAULT NULL,
  `nUsuario` varchar(16) DEFAULT NULL,
  `uPassword` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `idRol` (`idRol`),
  KEY `idCargo` (`idCargo`),
  CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`idRol`) REFERENCES `rol` (`idRol`),
  CONSTRAINT `usuario_ibfk_2` FOREIGN KEY (`idCargo`) REFERENCES `cargo` (`idCargo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venta` (
  `idVenta` int(10) NOT NULL AUTO_INCREMENT,
  `idCliente` int(10) DEFAULT NULL,
  `idUsuario` int(5) DEFAULT NULL,
  `Fecha` datetime NOT NULL,
  `NULA` char(1) DEFAULT NULL,
  PRIMARY KEY (`idVenta`),
  KEY `idUsuario` (`idUsuario`),
  KEY `idCliente` (`idCliente`),
  CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`),
  CONSTRAINT `venta_ibfk_2` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=145 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping events for database 'laspalmeras'
--

--
-- Dumping routines for database 'laspalmeras'
--
/*!50003 DROP FUNCTION IF EXISTS `login` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `login`( usser varchar(20), pssword varchar(20)) RETURNS tinyint(1)
Begin
declare Luser varchar(20);
Select (idUsuario) into Luser from usuario where nUsuario=usser;
	if(Luser>0)then
			if(Select idUsuario from usuario where idUsuario=Luser and uPassword=pssword)then
				return 1;
            else
				return 0;
            End if;
    else
		return 0;
    End if;
End ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizarProd` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizarProd`(in pidProducto int,in pidCategoria int,in pidMarca int, in pproducto varchar(60),
								in pdescripcion varchar(60),in pprecio double(5,2),out x int)
begin
declare lidp int;
select count(*) into lidp from laspalmeras1.producto where producto.idProducto=pidProducto;
if(lidp!=0)then
	update laspalmeras1.producto
    set idCategoria=pidCategoria,idMarca=pidMarca,Producto=pproducto,Descripcion=pdescripcion,Precio=pprecio
    where producto.idProducto=pidProducto;
    commit;
    set x=1;
else if(lidp=0)then
	set x=0;
end if;
end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addUser` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addUser`(IN Uname varchar(25), IN ULname varchar(25), UDUI varchar(11),IN Urole varchar(20), IN Uposition varchar(20),
IN Usalary double(6,2), IN Usser varchar(16), IN Upassword varchar(15), IN Ustart date,
OUT MSG varchar(100))
Begin
declare Lrole int;
declare Lposition int;
declare Luser varchar(20);
declare Ldui varchar(11);
declare LidU int;
Select (idRol) into Lrole from rol where rol=Urole;
Select (idCargo) into Lposition from cargo where cargo=Uposition;
	if(Uname!=null and Ulname!=null and UDUI!=null and Urole!=null and Uposition!=null and Usalary!=null
    and Usser!=null and Upassword!=null and Ustart!=null)then
		Select (idUsuario) into Luser from usuario where nUsuario=Usser;
		Select (idUsuario) into Ldui from usuario where dui=UDUI;
        if(idUsuario>0)then
			Set MSG='El usuario no puede ser repetido';
		else
			if(Ldui>0)then
				Set MSG='El usuario ya existe';
			else
				Insert into usuario values(Uname, ULname, UDUI, Lrole, Lposition, Usalary, Usser, Upassword);
				Select (idUsuario) into LidU from usuario order by idUsuario desc limit 1;
                Insert into estadousuario values (LidU, 1, now());
                Set MSG='Usuario ingresado con exito';
			End if;
        End if;
    else
		Set MSG='Los campos no pueden quedar vacios';
    End if;
End ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `compra` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `compra`(IN Provider varchar(50),IN Direction varchar(50),
IN Phone varchar(10),
IN Representative varchar(50),IN DUI varchar(11),
IN Category int(3),IN Brand int(4), IN Product varchar(60),IN Description varchar(60),IN Price double(5,2),
IN Quantity int(5),IN unitPrice double(5,2),IN expirationDate date,OUT MSG varchar(100))
Begin
declare LidP int;
declare LnP varchar(50);
declare LidC int;
declare LidPd int;
Set LnP='%'+Provider+'%';
	if(Provider=null)then
		Set MSG='El campo representante no puede estar vacio';
	else
#Verificamos si el proveedor existe de caso contrario lo agregamos
#la dirección no la validamos si es nula ya que si existe no se necesitará
		Select (idProveedor) into LidP from Proveedor where Proveedor like LnP;
        if(LidP<0)then
			Insert into Proveedor values (Provider, Direction);
            Insert into Telefono (idProveedor, Telefono) values (LidP, Phone);
		else
#Validamos e ingresamos la compra
			if(Dates!=null, Representative!=null, DUI!=null)then
				Insert into Compra values (LidP, NOW(), Representative, DUI);
#Validamos e ingresamos el producto
				if(Category!=null and Brand!=null and Product!=null and Description!=null and Price!=null)then
					Insert into Producto values (Category, Brand, Product, Description, Price);
#Validamos e ingresamos el detalle de compra
					Select (idCompra) into LidC from Compra order by idCompra desc limit 1;
                    Select (idProducto) into LidPd from Producto order by idProducto desc limit 1;
                    if(Quantity!=null and unitPrice!=null and expirationDate!=null)then
						Insert into detallecompra values (LidC, LidPd, Quantity, unitPrice, expirationDate);
					else
						Set MSG='Compra no finalizada, revise los campos';
                    End if;
				else
					Set MSG='Los campos de producto no son correctos';
                End if;
			else
				Set MSG='Compra no finalizada, revise los campos';
            End if;
        End if;
    End if;
End ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `detalleventa` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `detalleventa`(IN pidprod int(5),IN pidventa int(5),IN pcantidad int(5), OUT bandera int(2))
begin
declare lidventa int;
select count(*) into lidventa from laspalmeras.venta where exists(select idVenta from laspalmeras.venta where venta.idVenta=pidventa) limit 1;
if(lidventa>0)then
	insert into laspalmeras.detalleventa(idProducto,idVenta,Cantidad) values(pidprod,pidventa,pcantidad);
	set bandera=1;
    #se hace la insercion y se manda 1 en bandera para confirmar
else if(lidventa=0)then
	set bandera=0;
    #por algun motivo no se encuentra la venta se manda 0 en bandera
end if;
end if;
End ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GenerarCompra` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `GenerarCompra`(in pidprov int(5),in pfecha date,in prepresentante varchar(50),in pdui varchar(11),out midcompra int)
begin 
declare Lidcompra int;
declare LidProv int;
	select count(*) into LidProv from laspalmeras1.proveedor where proveedor.idProveedor=pidprov limit 1;
if(LidProv=1)then
		insert into laspalmeras1.Compra(idProveedor,Fecha,Representante,dui) 
					values(pidprov,pfecha,prepresentante,pdui);
		select max(compra.idCompra) into LidCompra from laspalmeras1.compra;
       set midcompra=LidCompra;
else if(LidProv=0)then
		set midcompra=-1;
end if;
end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GenerarDCompra` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `GenerarDCompra`(in pidcompra int,in pidproducto int,in pcantidad int,
								in ppreciou double(5,2),in pidfechaVencimiento int,out x int)
begin
declare LIdprod int;
declare LIdComp int;
select count(*) into LIdprod from laspalmeras1.producto where producto.idProducto=pidproducto;
select count(*) into LIdComp from  laspalmeras1.compra where compra.idCompra=pidcompra;
if((LIdprod=1)and(LIdComp=1))then
	insert into detallecompra(idCompra,idProducto,idFechaVencimiento,Cantidad,PrecioUnitario)
		values(pidcompra,pidproducto,pidfechaVencimiento,pcantidad,ppreciou);
        set x=1;
else if((LIdprod=0)or(LIdComp=0))then
		set x =0;
end if;
end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertcategoria` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertcategoria`(in pcat varchar(16),out bandera int,out codigo int)
begin
declare Lcat int;
declare Lcatn int;
declare Lcatm int;
select count(*) into Lcat from laspalmeras1.categoria where categoria.Categoria=pcat;
if(Lcat=0)then
	insert into laspalmeras1.categoria(Categoria)values(pcat);
    select max(categoria.idCategoria) into Lcatn from laspalmeras1.categoria;
    set bandera =1;
    set codigo = Lcatn;
else if(Lcat=1)then
	select categoria.idCategoria into Lcatm from laspalmeras1.categoria where categoria.Categoria=pcat;
	set bandera =0;
	set codigo =Lcatm;
end if;
end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertfechaVencimiento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertfechaVencimiento`(in pfechavenc varchar(50), out bandera int,out mfechavenc int)
begin 
declare Lfv int;
declare Lmfv int;
select count(*) into lfv from laspalmeras1.fechavencimiento fv where fv.fechavencimiento=pfechavenc;
if(lfv=0)then
	insert into laspalmeras1.fechavencimiento(fechavencimiento)
			values(pfechavenc);
	select fechavencimiento.idFechavencimiento into Lmfv from laspalmeras1.fechavencimiento  where fechavencimiento.fechavencimiento=pfechavenc;
    set bandera=1;
    set mfechavenc=lmfv;
else if(lfv=1)then
	select fechavencimiento.idFechavencimiento into Lmfv from laspalmeras1.fechavencimiento  where fechavencimiento.fechavencimiento=pfechavenc;
    set bandera=0;
    set mfechavenc=lmfv;
end if;
end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertmarca` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertmarca`(in pmarca varchar(16),out bandera int,out codigo int)
begin
declare Lmarca int;
declare Lmarcan int;
declare idm int;
select count(*) into Lmarca from laspalmeras1.marca where marca.Marca=pmarca;
if(Lmarca=0)then
insert into laspalmeras1.marca(Marca)
		values(pmarca);
		select max(marca.idMarca) into Lmarcan from laspalmeras1.marca;
        set bandera=1;
        set codigo=Lmarcan;
else if(Lmarca=1)then
		select marca.idMarca into idm from laspalmeras1.marca where marca.Marca=pmarca;
		set bandera =0;
        set codigo= idm;
end if;
end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertProd` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertProd`(in pidcat int,in pidmarca int,in pproducto varchar(60),in pdescripcion varchar(60),in pprecio double(5,2),out minsert int)
begin
	declare lidcat int;
    declare lidmarca int;
    declare lidprodn int;
select count(*) into lidcat from laspalmeras1.categoria where categoria.idCategoria=pidcat;
select count(*) into lidmarca from laspalmeras1.marca where marca.idMarca=pidmarca;
if((lidcat=1)and(lidmarca=1))then
insert into laspalmeras1.producto(idCategoria,idMarca,Producto,Descripcion,Precio)
		values(pidcat,pidmarca,pproducto,pdescripcion,pprecio);
	select max(producto.idProducto) into lidprodn from laspalmeras1.producto;
	set minsert = lidprodn;
else if((lidcat=0)or(lidmarca=0))then
	set minsert = -1;
end if;
end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertproveedor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertproveedor`(in pproveedor varchar(50),in pdireccion varchar(50),out bandera int,out codigo int)
begin
declare Lprov int;
declare Lprovn int;
select count(*) into Lprov from laspalmeras1.proveedor where proveedor.Proveedor=pproveedor;
if(Lprov=0)then
	insert into laspalmeras1.proveedor(Proveedor,Direccion) values(pproveedor,pdireccion);
    select max(proveedor.idProveedor) into Lprovn from laspalmeras1.proveedor;
    set bandera=1;
    set codigo=Lprovn;
else if(Lprov=1)then
	select proveedor.idProveedor into Lprovn from laspalmeras1.proveedor where proveedor.Proveedor=pproveedor;
    set bandera =0;
    set codigo=Lprovn;
end if;
end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `inserttelefono` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `inserttelefono`(in pidU int,in pidcli int,in idprov int,in ptel varchar(10),out bandera int)
begin
if(pidU!=0)then
	insert into laspalmeras1.telefono(idUsuario,Telefono)
		values(pidU,ptel);
	set bandera =1; 
else if(pidcli!=0)then
	insert into laspalmeras1.telefono(idCliente,Telefono)
		values(pidcli,ptel);	
	set bandera =1;
else if(idprov!=0)then
	insert into laspalmeras1.telefono(idProveedor,Telefono)
		values(pidprov,ptel);	
	set bandera =1;
else 
	set bandera =0;
end if;
end if;
end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `venta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `venta`(in pidc int(5), IN pidempleado int(5),IN piva double(5,2),IN pdesc double(4,2),
	OUT idventx int(5))
Begin
	insert into laspalmeras.venta(idCliente,idUsuario,Fecha,IVA,Descuento,nula) values(pidc,pidempleado,now(),piva,pdesc,0);
	set idventx = LAST_INSERT_ID();
End ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `inventario`
--

/*!50001 DROP VIEW IF EXISTS `inventario`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `inventario` AS select `cc`.`idDetalleCompra` AS `idDetalleCompra`,`cc`.`idProducto` AS `idProducto`,`cc`.`idFechaVencimiento` AS `idFechavencimiento`,`ff`.`fechavencimiento` AS `fechavencimiento`,`cc`.`Cantidad` AS `Compra`,(case when (sum(`vv`.`Cantidad`) is not null) then sum(`vv`.`Cantidad`) else 0 end) AS `Venta`,(`cc`.`Cantidad` - (case when (sum(`vv`.`Cantidad`) is not null) then sum(`vv`.`Cantidad`) else 0 end)) AS `Existencia` from ((`detallecompra` `cc` left join `detalleventa` `vv` on((`cc`.`idFechaVencimiento` = `vv`.`idFechaVencimiento`))) left join `fechavencimiento` `ff` on((`cc`.`idFechaVencimiento` = `ff`.`idFechavencimiento`))) group by `cc`.`idDetalleCompra` order by `ff`.`fechavencimiento` desc */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-04 23:08:02
