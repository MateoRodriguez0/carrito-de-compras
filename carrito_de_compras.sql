-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 19-09-2023 a las 16:26:07
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `productos en carrito`
--

INSERT INTO `productos en carrito` (`Id`, `IdProducto_Stock`, `IdCliente`, `cantidad seleccionada`, `fecha de agregado`) VALUES
(5, 10, 10, 1, '2023-09-12 00:00:00'),
(7, 113, 10, 1, '2023-09-12 00:00:00'),
(8, 136, 10, 3, '2023-09-12 00:00:00'),
(9, 114, 10, 3, '2023-09-12 00:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos en stock`
--

DROP TABLE IF EXISTS `productos en stock`;
CREATE TABLE IF NOT EXISTS `productos en stock` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `descripcion` text,
  `IdCategoria` int NOT NULL,
  `precio` double DEFAULT NULL,
  `cantidad disponible` int NOT NULL,
  `IdVendedor` int NOT NULL,
  `fecha de publicacion` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`Id`),
  KEY `FK_IdCategoria` (`IdCategoria`),
  KEY `FK_IdUsuario` (`IdVendedor`)
) ENGINE=InnoDB AUTO_INCREMENT=147 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `productos en stock`
--

INSERT INTO `productos en stock` (`Id`, `nombre`, `descripcion`, `IdCategoria`, `precio`, `cantidad disponible`, `IdVendedor`, `fecha de publicacion`) VALUES
(10, 'Xiaomi Redmi Note 12 Pro+ ', 'Dispositivo desbloqueado para que elijas la compañía telefónica que prefieras.\r\nCompatible con redes 5G.\r\nPantalla AMOLED de 6.67\".\r\nTiene 3 cámaras traseras de 200Mpx/8Mpx/2Mpx.\r\nCámara delantera de 16Mpx.\r\nProcesador MediaTek Dimensity 1080 Octa-Core de 2.6GHz con 8GB de RAM.\r\nBatería de 5000mAh.\r\nMemoria interna de 256GB.\r\nResistente a las salpicaduras.\r\nCon sensor de huella dactilar.\r\nResistente al polvo.', 3, 1354900, 53, 9, '2023-08-08 00:00:00'),
(112, 'Samsung Galaxy A34 5G', '5G 128 GB awesome graphite 6 GB RAM.\r\nDispositivo desbloqueado para que elijas la compañía telefónica que prefieras.\r\nCompatible con redes 5G.\r\nPantalla Super AMOLED de 6.6\".\r\nTiene 3 cámaras traseras de 48Mpx/8Mpx/5Mpx.\r\nCámara delantera de 13Mpx.\r\nProcesador Mediatek MT6877V Dimensity 1080 Octa-Core de 2.6GHz con 6GB de RAM.\r\nBatería de 5000mAh.\r\nMemoria interna de 128GB.\r\nResistente al agua.\r\nCon reconocimiento facial y sensor de huella dactilar.\r\nResistente al polvo.', 3, 1034900, 15, 9, '2023-08-23 09:50:45'),
(113, 'Apple iPhone 14 (128 GB) - Morado', 'Pantalla Super Retina XDR de 6.1 pulgadas.(1)\r\nSistema avanzado de cámaras para tomar mejores fotos en cualquier condición de luz.\r\nModo Cine ahora en 4K Dolby Vision de hasta 30cps.\r\nModo Acción para lograr videos estables, aún con cámara en mano.\r\nDetección de Choques(2), una funcionalidad de seguridad que pide ayuda cuando tú no puedes.\r\nBatería para todo el día y hasta 26 horas de reproducción de vídeo.(3)\r\nA15 Bionic, con GPU e 5 núcleos para un rendimiento fuera de serie. Red 5G ultrarrápida.(4)\r\nCeramic Shield y resistencia al agua, características de durabilidad líderes en la industria.(5)\r\niOS 16 ofrece aún más opciones de personalización y más formas de comunicarse y compartir.(6)', 3, 3600405, 13, 9, '2023-07-10 09:50:45'),
(114, 'Moto G22 128 GB', 'pearl white 4 GB RAM.\r\nDispositivo desbloqueado para que elijas la compañía telefónica que prefieras.\r\nPantalla IPS de 6.5\".\r\nTiene 4 cámaras traseras de 50Mpx/8Mpx/2Mpx/2Mpx.\r\nCámara delantera de 16Mpx.\r\nProcesador Mediatek MT6765V/CB Helio G37 Octa-Core de 2.3GHz con 4GB de RAM.\r\nBatería de 5000mAh.\r\nMemoria interna de 128GB.\r\nResistente a las salpicaduras.\r\nCon reconocimiento facial y sensor de huella dactilar.', 3, 553388, 25, 9, '2023-09-01 09:50:45'),
(115, 'Xiaomi Pocophone Poco X5', 'Pro 5G Dual SIM 256 GB negro 8 GB RAM.\r\nDispositivo desbloqueado para que elijas la compañía telefónica que prefieras.\r\nCompatible con redes 5G.\r\nPantalla AMOLED de 6.67\".\r\nTiene 3 cámaras traseras de 108Mpx/8Mpx/2Mpx.\r\nCámara delantera de 16Mpx.\r\nProcesador Snapdragon 778G Octa-Core de 2.4GHz con 8GB de RAM.\r\nBatería de 5000mAh.\r\nMemoria interna de 256GB.\r\nResistente al agua.\r\nCon reconocimiento facial y sensor de huella dactilar.\r\nResistente al polvo.', 3, 1214900, 42, 9, '2023-05-10 09:50:45'),
(116, 'Apple iPhone 13 (128 GB) - Azul', 'Pantalla Super Retina XDR de 6.1 pulgadas1\r\nModo Cine con baja profundidad de campo y cambios de enfoque automáticos en tus videos\r\nSistema avanzado de dos cámaras de 12 MP (gran angular y ultra gran angular) con Estilos Fotográficos, HDR Inteligente 4, modo Noche y grabación de video 4K HDR en Dolby Vision\r\nCámara frontal TrueDepth de 12 MP con modo Noche y grabación de video 4K HDR en Dolby Vision\r\nChip A15 Bionic para un rendimiento fuera de serie\r\nHasta 19 horas de reproducción de video2\r\nDiseño resistente con Ceramic Shield\r\nResistencia al agua IP68, líder en la industria3\r\niOS 15 con nuevas funcionalidades para aprovechar tu iPhone al máximo4\r\nCompatibilidad con accesorios MagSafe, que se acoplan fácilmente a tu iPhone y permiten una carga inalámbrica más rápida5', 3, 3269900, 50, 9, '2023-09-04 09:50:45'),
(117, 'Cicatricure Crema Antiarrugas', '60 G + Ant - g a $419\r\nCicatricure Crema Facial Antiarrugas Antiedad 60 G + Antimanchas Antiarrugas Antiedad 50 G\r\n* [ VISIBLEMENTE MÁS JOVEN ] Reduce arrugas y líneas de expresión visiblemente en 4 semanas, promoviendo la producción de colágeno y reafirmando el contorno del rostro.\r\n* [ 12 BENEFICIOS EN UNO ] Crema antiarrugas de cuidado dermatológico que hidrata mientras contrarresta los signos del envejecimiento prematuro.\r\n* [ FÓRMULA POTENCIADA ] Con Q-Acetyl 10 y 10 veces más péptidos que otras.\r\n* [ CIENCIA DERMATOLÓGICA ] Ciencia que derivó en todo un accidente científico. Al utilizar Cicatricure Gel en cicatrices en el rostro, se descubrió que también mejoraba notablemente arrugas y líneas de expresión. A partir de ahí, nuestros expertos mejoraro\r\n* [ TEXTURA LIVIANA ] Aplica diariamente, por la mañana y por la noche, sobre la piel limpia, en cara, cuello y escote con movimientos ascendentes.\r\n* [ ADMINISTRACIÓN ] Tópica. Aplique diariamente, por la mañana y por la noche, sobre la piel limpia en cara, cuello y escote con movimientos ascendentes.\r\n* [ CREMA ANTIMANCHAS ] Cicatricure crema anti manchas ayuda a disminuir y reducir las manchas del rostro en 4 semans\r\n* [ INGREDIENTES ] PH Resorcinol, potente activo que regula produccion de melanina\r\n* [ TRIPLE ACCION ] Antimanchas, antioxidante y unifica el tono de la pie\r\n* [ MODO USO ] Aplicar diariamente 2 veces al día, después de limpiar el\r\nrostro, cuello y escote.', 7, 92256, 1000, 9, '2023-06-15 09:50:45'),
(118, 'Hidratante Facial NEUTROGENA', 'Hydro Boost 50 ML.\r\nHidratante facial NEUTROGENA® HYDROBOOST® Water gel con Ácido Hialurónico que renueva los niveles de agua en la piel y fortalece subarrera natural.\r\nPara piel todo tipo de piel.\r\nGel hidratante, humectante, renovadora con aplicación de día/noche.\r\nEs un cosmético hipoalergénico.\r\nDermatológicamente testeado.\r\nIdeal para el cuidado de la piel de tu rostro.', 7, 44380, 132, 9, '2023-07-21 09:50:45'),
(119, 'Combo Nivea Celullar Luminous', 'Antimanchas Rutina Completa.\r\n\r\nPRODUCTO:\r\n\r\nNombre: Combo NIVEA Celullar Luminous ANTIMANCHAS RUTINA COMPLETA\r\nMarca: Nivea\r\n\r\nDESCRIPCIÓN:\r\n\r\nCombo NIVEA Celullar Luminous ANTIMANCHAS RUTINA COMPLETA\r\n\r\nMÁS DETALLES:\r\n\r\nPeso del paquete: 0.01 kg\r\nCondición: Nuevo\r\nEAN: 4005900786470\r\nGTIN: 4005900786470\r\nSKU: 4005900786470RC2', 7, 165800, 70, 9, '2023-05-18 09:50:45'),
(120, 'Acondicionador Elvive Oleo Ext', ' mL a $36Acondicionador Elvive Oleo Extraordinario 370ml\r\n\r\nAcondicionador Óleo Extarordinario con 6 Óleos de Flores preciosas y sin sal brinda nutrición y brillo intenso para una suavidad y ligereza excepcional. 100% Botella Reciclada.\r\n\r\nENVÍOS FULL:\r\nSi necesitas factura, te recomendamos ingresar tus datos jurídicos en tu cuenta de Mercado Libre antes de finalizar la compra. En caso de no contar con esta información, tu pedido será procesado con una boleta a nombre de persona natural, y no podrás realizar cambios una vez listo el documento.\r\n\r\nVENTAS ACORDADAS:\r\nRecuerda que en las ventas bajo la modalidad \"Acuerdo en la entrega\", el costo de envío es responsabilidad del comprador.\r\nTe invitamos a contactar a nuestros asistentes en línea para obtener información detallada sobre los costos asociados.', 7, 13105, 38, 9, '2022-12-23 09:50:45'),
(121, 'Tio Nacho Shampoo Engrosador', ' [ ENGROSADOR ] Aumenta el diámetro de cada cabello dando una apariencia de hasta 33,000 cabellos más.\r\n* [ ANTI-CAÍDA ] Fortalece el cabello evitando la caída por quiebre en tan solo 1 mes.\r\n* [ FÓRMULA NATURAL ] Jalea Real + Extracto de Ortiga + el componente exclusivo Capilgross.\r\n* [ REALMENTE NATURAL ] Revitalización de la raíz a las puntas.\r\n* [ USO DIARIO ] Aplique el producto sobre cabello mojado con un ligero masaje en el cuero cabelludo con las yemas de los dedos.Para mejores resultados se recomienda utilizar toda la línea Tío Nacho Engrosador.\r\n* [ GARANTIZADO ] Cabello visiblemente más abundante y más grueso a partir de los 28 días.\r\nPara mejores resultados, usa la línea completa Shampoo + Acondicionador + Tratamiento', 7, 33530, 16, 9, '2023-07-18 09:50:45'),
(122, 'Llanta Hifly Vigorous', 'AT601 LT 255/70R16 111 T\r\n¿Vas a esperar a que tu llanta se desgaste para cambiarla? Puedes evitar alargar la vida útil de una vieja cubierta y apostar a tu tranquilidad. Encuentra la mejor tracción, dirección y confort con tu Hifly AT601.\r\n\r\nEstabilidad y control\r\nGracias a su buen agarre, presenta un desempeño óptimo asegurado y se adapta a la usabilidad de tu vehículo.\r\n\r\nAlta eficiencia\r\nEstá preparada para maximizar la eficiencia del combustible; su ligereza y la combinación de sus materiales te garantizarán un óptimo rendimiento en tus viajes.\r\n\r\nLa seguridad que buscabas\r\nApta para todo terreno, adhiriéndose con gran fuerza. Ideal para asfalto, tierra, arena o piedras, usa una mayor fuerza de tracción y evita que nuestro vehículo patine.', 8, 444500, 10, 9, '2023-03-14 09:50:45'),
(123, 'Llanta Yokohama BluEarth', '-Es ES32 P 205/55R16 91 H\r\n¿Vas a esperar a que tu llanta se desgaste para cambiarla? Puedes evitar alargar la vida útil de una vieja cubierta y apostar a tu tranquilidad. Encuentra la mejor tracción, dirección y confort con tu Yokohama ES32.\r\n\r\nEstabilidad y control\r\nGracias a su buen agarre, presenta un desempeño óptimo asegurado y se adapta a la usabilidad de tu vehículo.\r\n\r\nAlta eficiencia\r\nEstá preparada para maximizar la eficiencia del combustible; su ligereza y la combinación de sus materiales te garantizarán un óptimo rendimiento en tus viajes.\r\n\r\nLa seguridad que buscabas\r\nApta para circular sobre asfalto sin presentar desgaste e ideal para alcanzar grandes velocidades. Posee una excelente capacidad para adherirse a terrenos secos y mojados. A su vez, ofrece una tracción silenciosa y contribuye al consumo razonable de combustible.\r\n\r\nIdeal para tu vehículo\r\nEs silenciosa y duradera con buena adherencia en carretera. Está caracterizada por su estabilidad en línea recta al garantizar un confort de conducción. Se destaca por ser apta para vehículos utilitarios y compactos.', 8, 550000, 50, 9, '2023-09-01 09:50:45'),
(124, 'Cascos Moto Integral Ich', 'Certificado 501 Gratis Placas.\r\nCASCO CERTIFICADO DOT CON VISOR OSCURO , VISOR TRANSPARENTE Y PLACAS\r\n\r\n\r\nPRODUCTO DE ALTA ROTACIÓN , ¡SOLICÍTALO ANTES DE QUE SE AGOTE!!\r\n\r\nPRECIO SOLO POR TIEMPO LIMITADO\r\n\r\n\r\nnota : Los cascos en colores y negro solo disponibles con visor adicional oscuro\r\n\r\n\r\nnota : negro disponible con visor azul , dorado o plata\r\n\r\n\r\n\r\nESTIMADO/A CLIENTE LAS PLACAS SON UN OBSEQUIO FAVOR ENVIARLAS SI CUENTAS CON ELLAS, CUANDO EL PAGO SE ENCUENTRE ACREDITADO EN EL DETALLE DE TU COMPRA DE LO CONTRARIO ESTE OBSEQUIO NO ES ENVIADO YA QUE DEBEMOS CUMPLIR CON LOS TIEMPOS DE ENTREGA EXIGIDOS POR EL SISTEMA. (LAS PLACAS SE ENVÍAN DENTRO DEL CASCO)\r\n\r\n\r\n\r\nIMPORTANTE\r\n\r\nSegún el artículo 9 (capitulo IV) de la ley 2251 de 2022 , se modifica el mencionado artículo 96 del código de tránsito y específicamente el numeral 5 dice que “ el conductor y el acompañante deberán portar siempre el casco de seguridad , conforme a la reglamentación que expida el ministerio de transporte . en todo casco, no se podrá exigir que el casco contenga el numero de placa correspondiente al vehículo en que se moviliza.\r\n\r\n\r\nEspecificaciones de producto\r\n\r\nEl ICH 501 es el casco integral certificado de ICH, está homologado por la norma técnica DOT Americana y la colombiana NTC 4533, brindándote total seguridad al momento de manejar tu moto gracias a su composición de termoplástico de gran resistencia y el poliestireno expandido de alta densidad. El ICH 501 tiene cubrimiento interno en tele jersylon . Cuenta además con cámaras de ventilación en la parte superior, frontal y trasera para que siempre conduzcas fresco. Por último, este casco tiene hebilla micrométrica como sistema de retención para que siempre esté bien asegurado.\r\n\r\nEspecificaciones Técnicas\r\n\r\nCoraza Fabricado en ABS (Termoplástico de alta resistencia).\r\nInterior EPS (Poliestireno expandido) de alta densidad.\r\nAcolchado\r\n\r\nCompuesto por tejidos y espumas antialérgicas en las zonas en contacto con el rostro y cabeza, decorado con sesgoen diferentes colores y aplicación de fibras sintéticas durables en las zonas de apoyo o propensas a la humedad.\r\n\r\n\r\n\r\nFrontal superior, frontal inferior.\r\n\r\nSistema de retención\r\n\r\nHebilla tipo micrométrica.\r\n\r\nPintura\r\n\r\nCon protección UV y recubrimiento en barniz.\r\n\r\nNorma\r\n\r\nPeso:\r\n\r\nRES 1737 / NTC 4533. DOT.\r\n\r\n1380 +/- 50\r\n', 8, 140712, 35, 9, '2023-09-01 09:50:45'),
(125, 'Mesa Para Tv Tunez Wengue', 'Mesa para TV Tunez, Wengue\r\n\r\nMesa para TV de 70\".\r\nElaborado en Madera aglomerada MDP, recubierta con láminas melamínicas de excelente calidad, en color Wengue.\r\n\r\nSus medidas son:\r\nAlto: 47 cm\r\nAncho: 160 cm\r\nFondo: 35 cm\r\n\r\n*INFORMACION IMPORTANTE - LEER HASTA EL FINAL!\r\n\r\n* Tenemos envíos totalmente gratis a ciudades principales e intermedias (zona urbana), consulta el listado completo de envíos en la última imagen de la publicación, si estás ubicado en otro municipio puedes preguntarnos por la cobertura.\r\n* Tiempo de entrega APROXIMADO: 3 a 8 días hábiles.\r\n\r\n*Importante: Consulta la cobertura de envíos en las últimas imágenes.\r\n\r\n----------\r\n* Este producto llega desarmado, Incluye instructivo de fácil armado con todas las instrucciones, el cliente debe armarlo siguiendo el manual paso a paso (No incluye destornilladores ni herramientas caseras básicas necesarias para armar.)\r\n* Recomendamos que antes de armar el producto revise muy bien todas las piezas y verifique que estén en buen estado, luego de ser entregado el cliente cuenta con máximo 5 días para reclamaciones por averías causadas por el transporte.\r\n*Recuerda que, si alguna pieza llega en mal estado, esta tiene cambio, puedes comunicarte con nuestras líneas de servicio al cliente.\r\n----------\r\nLínea LowCost\r\nMuebles para armar: son productos con diseños modernos y medidas estándar de fábrica, se fabrican en volumen, utilizamos materiales de calidad, esto permite ofrecer precios increíbles, llegan empacados en caja y requieren ser armados por nuestros clientes, cuentan con garantía y manejamos diseños modernos.\r\n----------\r\n\r\n*NO INCLUYE: Estas imágenes son ambientadas, su compra no incluye: accesorios, electrodomésticos, objetos decorativos, instalación, grifería, ni ningún otro producto que hace parte de la ambientación. El tono del color de la imagen es ambientado y podría tener alguna variación leve.\r\n----------\r\n\r\nMATERIALES: Madera aglomerada estándar y recubrimiento melaminico, es un tablero de partículas de madera, para aplicaciones de interior en ambiente seco.\r\nVentajas: excelente resistencia a la ralladura, fricción y manipulación, buena resistencia al contacto con objetos calientes, fácil de limpiar. Es mucho más ecológica, ya que las siembras son destinadas para éste uso.\r\n----------\r\n\r\n*GARANTÍA: 3 años en madera -1 año en los herrajes (((EN CASO DE SER COCIDAS O MUEBLES DE BAÑO SON 1 AÑO EN MADERA Y 1 AÑO EN HERRAJES)))) (Por defectos del producto, no aplica por desgaste causado por el uso o mala manipulación, no es resistente al agua), Luego de recibido el producto el cliente cuenta con máximo 5 días para reclamaciones por averías causadas por el transporte.\r\n*Recuerda que, si alguna pieza llega en mal estado, esta tiene cambio, puedes comunicarte con nuestras líneas de servicio al cliente.\r\n----------\r\n\r\n* RECOMENDACIONES: El mueble debe ser utilizado en interiores, evitar los rayos de sol constantes en el mueble, evite el contacto directo con agua porque puede afectar las propiedades de la madera, limpie con un trapo seco y lustrador de muebles, los elementos metálicos del mueble como bisagras, patas, manijas y otros, deben de ser limpiados con un trapo ligeramente húmedo para remover el polvo. En caso necesario utilice jabones neutros, por ejemplo, el jabón de baño, siempre levante el mueble entre 2 personas, no permita que los niños manipulen el mueble, puede volcarse y lastimarlos.', 5, 199900, 5, 9, '2023-07-28 09:50:45'),
(126, 'Pack Tratamiento Caída Del Cab', 'Minoxidil Forte Colmed\r\nRecibes Pack de 3 Unidades Minoxidil Forte 5% Colmed 100Ml c/u, Registro Sanitario: 2021M-0020005.\r\n\r\nTratamiento para prevenir y controlar la caída del cabello', 7, 129000, 26, 9, '2023-09-03 09:50:45'),
(127, 'Sofacama Porto En Tela Dicosta', 'SOFACAMA PORTO EN TELA DICOSTA\r\n\r\nEl Sofacama Porto gracias a su diseño capitoneado, brinda una sensación única de elegancia y comodidad. Se encuentra fabricado en una fuerte estructura de madera, con espuma de alta densidad, forrado en tela poliéster de excelente calidad, tela brioni en el espaldar y en la base del asiento. Su diseño cuenta con sistema reclinable de 3 posiciones.\r\n\r\nDIMENSIONES:\r\n\r\n• SOFACAMA ABIERTO: 182cm ancho x 106cm largo x 45 cm alto.\r\n• SOFACAMA (sofá) 182cm ancho x 85 cm largo x 85cm alto\r\n\r\nProducto de excelente calidad y 100% garantía de satisfacción.\r\n\r\nGarantizamos el envío a cualquier ciudad del país, el cargo del envío va por cuenta del comprador.\r\n\r\nValor del envío coordinar con el vendedor.\r\n\r\nSomos Mercado Lideres con más de 1.200 Comedores vendidos, excelente reputación y comentarios positivos de nuestros clientes.\r\n\r\n*La foto ha sido ambientada; la compra incluye 1 Sofacama e instructivos de armado y limpieza. No incluye elementos decorativos.\r\n\r\nTiempos de fabricación y entrega: 11 a 13 días hábiles de fabricación una vez confirmada la compra, 2 a 5 días hábiles de entrega.\r\n\r\n¿Qué esperas para que haga parte de tu hogar?\r\n\r\n¿Tienes alguna duda? Pregúntanos lo que quieras saber.', 5, 897900, 8, 9, '2023-04-21 09:50:45'),
(128, 'Mesa De Noche Der/izq ', 'Color Blanco M01396\r\nNOCHERO DERECHO O IZQUIERDO MADERKIT M01396 COLOR BLANCO\r\n\r\nCARACTERÍSTICAS PRINCIPALES\r\n\r\nCOLOR: BLANCO\r\nMedidas: 48 cm Ancho x 46 cm Alto x 36 cm Fondo\r\nAtributos: 1 cajón 1 compartimiento inferior 1 base superior con aplique metálico, Manija metálica. Este producto puede ser armado para el lado Derecho o Izquierdo según se requiera.\r\nMaterial: Fabricado en Madera Aglomerada (MDP) y Cubierta en Melamínico. Producto listo para armar (Requiere proceso de armado).\r\n\r\nEmpaque: Empacado en 1 cajas que contienen: piezas en aglomerado, kit de herrajes, manual y certificado de garantía.\r\n\r\nObservación: El precio no incluye ningún accesorio y/o elemento que no se describa en los atributos. La foto de este producto ha sido ambientada, el color presentado en la fotografía es una aproximación al color real.\r\n\r\nGarantía: Nuestros muebles tienen garantía de 5 AÑOS sobre las piezas de aglomerado\r\ny 1 AÑO sobre los accesorios\r\n\r\nEntrega: Despachamos en máximo 3 días hábiles después de confirmado el pago. Entregamos en el transcurso de los 8 días hábiles..\r\n\r\nCosto de envío: Si este producto no cuenta con envío gratis te invitamos a consultar la imagen con el listado de destinos a los cuales te obsequiamos el costo del envío. Si la ciudad de destino no se encuentra en el listado te invitamos a consultar el valor de envío antes de generar la compra.\r\n\r\nDatos para envío: Requerimos de los siguientes datos a fin de tramitar la facturación y el despacho:\r\n\r\n- Número de cédula para facturación.\r\n- Nombre completo\r\n- Número de teléfono fijo y/o celular\r\n- Correo electrónico\r\n- Dirección de envío (indicar barrio, apto, bloque, manzana, etc)\r\n- Ciudad (Consultar cobertura en la imagen con listado de destinos)\r\n- Nombre y número de celular de quien recibe', 5, 159900, 200, 9, '2023-05-27 09:50:45'),
(129, 'Clóset RTA ', 'A Muebles Bariloche color wengue con 6 puertas batientes.\r\n\r\nRTA Muebles es una empresa que busca ofrecer productos únicos, de excelente calidad, con precios competitivos y diseños innovadores y funcionales. Esta marca cumple con los estándares internacionales de calidad, ya que utiliza tecnología de punta, elabora sus productos con los mejores tableros de madera y aporta exclusividad con sus diseños y la delicada selección de accesorios y herrajes. ¡Sin dudas, sus muebles son una gran opción!', 5, 699900, 731, 9, '2023-09-07 09:50:45'),
(130, 'Kit De Pesas', 'Juego De Pesas Termoforrad\r\n¡LOGRA TUS OBJETIVOS CON EL KIT DE MANCUERNAS VERSÁTIL MARCA MAGNUX Y DIVERSIFICA TUS ENTRENOS!\r\n\r\nAhora realizar tu rutina de ejercicio será más fácil, ya que cuentas con uno de los mejores set de mancuernas calidad/precio.\r\n\r\nEl entrenamiento con pesas es uno de los deportes de fuerza más eficaces, es muy bueno en el área de la salud, para el buen estado físico y también para la rehabilitación.\r\n\r\nLos músculos se fortalecen y simultáneamente se moldean con el uso de las pesas. Por lo tanto, un entrenamiento de pesas no tiene sólo un efecto deportivo sino también un efecto estético. Con el entrenamiento de pesas la grasa corporal se reduce más eficientemente que, por ejemplo, con el ciclismo, la natación o las salidas a correr.\r\n\r\nTe presentamos nuestro set de mancuernas de 20 KG con barra ergonómica y cierres en forma de estrella.\r\n\r\nPODRÁS TENER:\r\n• Un entrenamiento profesional de pesas en casa.\r\n• Barras de pesas sólidas con una unión para convertir las 2 mancuernas en una barra larga y poder trabajar otros músculos.\r\n• Superficies de agarre antideslizantes de aprox. 40 cm cada una.\r\n• Cierres de rosca/cierres de estrella con anillos plásticos para asegurar que los discos de pesas estén siempre firmemente unidos a las barras.\r\n• Asas antideslizantes - esto evitará que las manos se deslicen durante el entrenamiento. Cada una de las barras tienen dos roscas trapeciales robustas (para una fijación segura de los discos)\r\n• Discos de pesas termo forrados en plástico para proteger el suelo y la integridad estructural del disco (de esta manera, se evita también el ruido molesto cuando las pesas son puestas en el suelo).\r\n\r\nEn total son 12 discos, TODO SUMA 20KG.\r\n4 Discos de 2 KG\r\n4 Discos de 1.5 KG\r\n4 Discos de 1.25 KG\r\n4 Seguros de Estrella\r\n2 Mancuernas Antideslizantes (barras cortas, que juntas forman de 30- 35 cm APROXIMADAMENTE) + la barra conectora larga APROX de 50 cm. Todo mediría de 80-90 cms APROX (Pesa 1 kg)', 6, 107900, 100, 9, '2023-08-27 09:50:45'),
(131, 'Rueda Abdominal', 'Rodil--> INVERSIONES JPA <--\r\n\r\n--> Somos una empresa comercializadora de diferentes productos tanto para el hogar como para tu lugar de trabajo, con más de 5 años de experiencia en el Mercado.\r\n\r\nLa rueda AB es una herramienta simple y efectiva para ayudarlo a obtener abdominales planos y firmes. Sus dos ruedas brindan más estabilidad, la gruesa alfombra que se ofrece evitará el dolor de rodilla y el ejercicio le permite fortalecer todos los músculos centrales de la parte superior del cuerpo. Se puede usar fácilmente en cualquier tipo de superficie, mangos sólidos y antideslizantes.\r\n\r\nCARACTERÍSTICAS:\r\n* Estable, fuerte, ligero y duradero.\r\n* Dispositivo de entrenamiento compacto que ahorra espacio para entrenamientos que requieren poco espacio.\r\n* Mangos con espuma acolchada - Para mayor comodidad y un agarre firme.\r\n* Diseñado para trabajar varios músculos a la vez: abdominales / pectorales / espalda / hombros / bíceps.\r\n\r\nINCLUYE:\r\n* Rodillo de ejercicio abdominal AB\r\n* Alfombrilla ergonómica\r\n\r\nEl color se entrega a disponibilidad de stock de inventario.\r\n\r\n**Para Bogotá entregamos el mismo día, si realizas el pago antes de la 2 pm de Lunes a Viernes y Sábados hasta las 12 m, eligiendo \"Domicilio Rápido\" como método de entrega.\r\n\r\nGARANTÍA:\r\n**Si necesitas aplicar una garantía con nosotros, dejanos un mensaje por interno en el detalle de la compra y con mucho gusto te ayudaremos con la correspondiente devolución y cambio de una forma mucho más oportuna. Recuerda que debe estar en las condiciones que se recibió el producto, empaque original, con sus accesorios completos y sin rayas ni manchas.\r\n\r\nGarantía del vendedor: 30 díaslo Grueso Con Mango Antideslizante', 6, 37315, 55, 9, '2023-07-28 09:50:45'),
(132, 'Silla Banca De Musculacion', 'Banco Para Pesas Abdominales Plegable Multiposición\r\n\r\nAlgunos de estos ejercicios requieren algún tipo de barra o mancuerna que esta compra no incluye. Puedes entrenar:\r\n\r\nABDOMEN\r\nLUMBAR\r\nALGUNOS EJERCICIOS DE PECHO\r\nHOMBRO\r\nEjercicio dorsal\r\nEntre otros que en tu creatividad puedas hacer\r\nBanco para trabajos de resistencia Plegable\r\nMultiangular\r\nCojinería indeformable.\r\n\r\nFunciones:\r\n* Inclinado\r\n* Declinado\r\n* Recto\r\n* Plano', 6, 427.9, 50, 9, '2023-08-28 09:50:45'),
(133, 'Trampolin Brincolin', 'Para Niños Con RedLleva contigo este trampolín. Ubicalo en el jardín o en el patio para que todos disfruten de horas de juego y actividades física, cuenta con lona elástica con estructura metálica, resortes resistentes y cubiertos por un forro fabricado con materiales plásticos de gran calidad y resistencia, mientras que el aro posee una cobertura de espuma anti impacto.\r\nTrampolín de 140 cm de ancho.\r\nPeso máximo que soporta: 50 kg.\r\n\r\nEl mejor regalo para los niños en Navidad.\r\n\r\nJuega y disfruta: con un diametro del area de saltar de 100 cm, da la posibilidad de que, por ejemplo: esten 3 niños de 4 años de 16 kg cada uno.\r\n\r\nUn producto de calidad:\r\nNuestra marca se preocupa por entregar productos de calidad. Por esto, cuenta con cubierta de marco, resortes alta resistencia, postes extra acolchados con foam para evitar golpes y anillo de fibra de vidrio flexible para red. Está elaborado con lona de alto impacto resistente a rayos UV y al agua.\r\n\r\nSeguro y cómodo:\r\nNuestro trampolín tiene un diseño que busca reducir el riesgo de lesiones. La cama elástica, tiene diseño amplio, que aumenta el área utilizada para saltar. Marco construido de acero galvanizado. Cuenta como malla de protección con cremallera y costuras reforzadas que buscan aumentar la seguridad de los más pequeños.\r\n\r\nGuarda las instrucciones para que sea armable y desarmable.\r\n\r\nTodos nuestros artículos, accesorios y equipo deportivo están fabricados con materiales de gran calidad, resistentes y durables. ¡Diversión en movimiento para toda la familia! Puedes encontrar variedad de trampolines y colores en nuestra tienda oficial virtual.\r\n\r\nEste es un producto deportivo y no es un juguete.\r\n\r\n*Trampolín rojo: El color del borde del trampolín rojo NO se puede escoger. Puede llegar amarillo o rojo. Depende de disponibilidad al momento en el que realizamos el envío.\r\n', 14, 345900, 400, 9, '2023-08-29 09:50:45'),
(134, 'Cartas X54 Pokémon ', 'Metalizadas Coleccionables\r\n\r\npaquete de tarjetas de juguete para regalo\r\nde excelente calidad\r\nCon terminaciones metalizadas con excelente brillo\r\nTodas las cartas en español\r\nNo se repiten.\r\n54 Cartas Coleccionables\r\n1. Esta tarjeta de dibujos animados está hecha de material nuevo de PVC de alta calidad. Impermeable y más duradero que las tarjetas ordinarias. Diseños grabados láser y chapado en oro para un brillo de lujo único! Esta es una obra de arte rara\r\n2. Amplía tu colección, construye una nueva baraja o vuelve a entrar en el juego y revive tu colección con nuestro juego de tarjetas TCG de 55 cartas.\r\n3. Tus hijos saltarán de alegría en sus cumpleaños cuando los sorprendas con nuestras tarjetas de papel de oro PC\r\n4. Estas tarjetas no son tarjetas oficiales\r\n\r\nGarantía del vendedor: 1 meses', 14, 35750, 300, 9, '2023-07-30 09:50:45'),
(135, 'Lanzador Dardos', 'Hawk Eye 16 Dardos Xshot\r\n¡Ejercita una visión de precisión con el lanzador de dardos X-Shot Excel Hawk Eye! Este blaster lleva la práctica de tiro al siguiente nivel. ¡Use el visor desmontable y el mecanismo de acción de bombeo para disparar con precisión desde una distancia de hasta 27 m / 90 pies! El mango de agarre táctil estabiliza tu disparo para que puedas disparar con precisión, mientras que el almacenamiento adicional de dardos garantiza que siempre estés listo para disparar tu próxima ronda. Nunca pierdas la oportunidad de atacar con el X-Shot Hawk Eye. Precisión: el lanzador de dardos X-Shot Excel Hawk Eye viene con un alcance desmontable y un mango de agarre táctico para disparar con precisión.\r\nPotencia de disparo: ¡Golpea objetivos con precisión desde una distancia de hasta 27 m / 90 pies!\r\nBloqueo y carga: el ojo de halcón tiene un mecanismo único de ruptura y carga para cargar un solo dardo. Hay un almacenamiento adicional de 4 dardos en la parte trasera.\r\n16 dardos: el lanzador X-Shot Excel Hawk Eye viene con 16 dardos para mantenerte cargado durante toda la batalla.\r\nMedidas del producto: 58*5*22\r\n\r\nGarantía del vendedor: 1 meses', 14, 84900, 200, 9, '2023-08-31 09:50:45'),
(136, 'Concreto Aislante Termico. Trans', 'CONCRETO AISLANTE TERMICO. (REFRACTARIOS DE COLOMBIA)\r\nEs una mezcla seca de materiales refractarios, aditivos aglutinantes y reactivos que genera burbujas de aire, desarrollada con alto porcentaje de alúmina. Listo para solo adicionar agua dándole 2 día de fraguado como mínimo. Ideal para aplicaciones en donde la temperatura no exceda 1500°centígrados. Es un producto especial para preparar concretos con requerimiento aislante térmico. La baja conductividad térmica reduce la cantidad de calor almacenado en las piezas del horno y la que pasa a través de ellas, reduciendo significativamente el consumo de energía.\r\nAplicaciones:\r\nElaboración de concreto aislante térmico para fundir piezas.\r\nElaboración de concreto aislante térmico para recubrimientos exteriores e interiores.\r\nInstrucciones de uso:\r\nTener en cuenta las recomendaciones de seguridad impresas en el empaque.\r\nPor cada bulto de 25 kg agregar 10 litros de agua mas o menos según la aplicación hasta obtener una mezcla homogénea. Para luego vaciar en moldes o realizar el recubrimiento.\r\nCaracterística técnicas:\r\nCada bulto de 25kg preparado tiene un rendimiento de 17.000cm3 (17 litro).\r\nTiempo de fraguado inicial (primera rigidización.) ocurre entre 2 días.\r\nMáximo tamaño del grano: 10 mm\r\n\r\nResistencia A La Compresión:\r\n(MPa) 18.0-20.0\r\nDensidad Volumétrica:\r\n(kg/m3)\r\n128\r\nConductividad térmica:\r\n0,075 W/mk\r\n\r\nFICHA TÉCNICA\r\nAl2O3: 37,6%\r\nSiO2: 41,7%\r\nFe2O3: 1,8%\r\nTiO2: 1,9%\r\nCaO: 5,0%\r\nMgO: 0,8%\r\nAlcalis: 2,7%\r\nAire: 8,5\r\n\r\n\r\n\r\n\r\n\r\nMERCADO ENVIO\r\n\r\nMercado Libre facilita nuestros envíos, por cada paquete de 20 kg o 40kg debe realizar el pago del envió.', 10, 78000, 5000, 9, '2023-09-01 00:00:00'),
(137, 'Kit Regadera Cuadrada', 'Ducha Acero Inoxidable 20 X 20 Cm Mas Tubo.\r\nCARACTERÍSTICAS PRINCIPALES:\r\n• Material del Panel: Acero Inoxidable.\r\n• Regador 20 x 20 cm\r\n• Medidas del tubo niple: 40 cm (32 + 8 cm) - 1/2 Pulgada.\r\n• Apto agua para caliente y fría.\r\n• Filtro de Agua (Evita sedimentos) .\r\n• Cantidad de Chorros de agua: 81 siliconas (anti hongos)\r\n• Escudo embellecedor de pared.\r\n• Acabado: Brillante.\r\n• Panel Giratorio.\r\n• Tipo: Lluvia\r\n• No trae llave de válvula (SOLO REGADERA)', 10, 30900, 230, 9, '2023-01-21 09:50:45'),
(138, 'Pantalón Azul Mp 87100', 'Pantalon:Tiro semi medio, silueta semi ajustada,.material:Burda, color AzulPonte a la moda con nuestras prendas y sentiras la diferencia, ponlo a prueba con tu estilo y apreciaras el valor de un producto construido para durar y combinar con cualquier outfit. La moda esta al alcance de la elección de un buen accesorio, .Se pueden tramitar cambios y devoluciones por calidad, favor evitar realizar el envio de los mismos, sucios y/o alterados. No se aceptan cambios de panty, fajas, vestidos de baño y baby doll.Recomendación: Lavar a mano, usar jabón suave, no retorcer, no dejar en remojo, secar a la sombra.', 13, 49999, 36, 9, '2023-05-20 09:50:45'),
(139, 'Tenis Converse Bota Chuck', 'Taylor All Star Unisex-negro\r\nPRODUCTO:\r\n\r\nNombre: Tenis Converse Bota Chuck Taylor All Star Unisex\r\nMarca: Converse\r\n\r\nDESCRIPCIÓN:\r\n\r\nElaborado en tela de primera calidad que permite un ajuste optimo además de hacerlo una prenda con mayor flujo de aire interno haciéndolo un calzado cómodo y versátil para las actividades diarias; cuenta con un diseño clásico de la marca Converse siendo de cobertura amplia ya que cubre el tobillo así mismo añade cierre en cordones con ojales metálicos para un ajuste personalizado de igual manera Cuenta con el clásico parche con el logotipo distintivo de la estrella en forma de parche en el lateral externo en material sintético dando mayor estilo; La suela está elaborada en caucho con Patrón gráfico que brinda tracción\r\n\r\nCARACTERÍSTICAS PRINCIPALES:\r\n\r\n-Capellada en textil\r\n-Ojales metálicos\r\n-Cierre en cordones\r\n-Parche Clásico Converse\r\n-Suela en Caucho\r\n\r\nMÁS DETALLES:\r\n\r\nPeso del paquete: 1 kg\r\nModelo: M7650C\r\nMeses de garantía: 1\r\nGarantía: Por defectos de fábrica\r\nCondición: Nuevo\r\nGénero: Unisex\r\nEstilo: Urbano\r\nSKU: M7650C_6\r\n\r\n', 13, 314990, 442, 9, '2023-07-12 09:50:45'),
(140, 'Tenis De Running', 'Ua Charged Rogue 3 Para Mujer 3024888-501-6\r\n¡Hola! Estás en la tienda oficial de Under Armour Colombia. Nuestra Misión. Under Armour te hace mejor. De esta forma inspiramos a todos los atletas o apasionados por el deporte con soluciones de alto rendimiento que no sabían que necesitaban, pero después de probarlas no se pueden imaginar viviendo sin ellas. Todo lo que hacemos gira en torno al rendimiento humano, entregando lo necesario para empujarte más allá de cualquier límite. Todos los productos que creamos se hacen para hacer mejor a todos los deportistas.\r\n\r\n* ¡Hola! Estás en la tienda oficial de Under Armour Colombia. Somos la marca deportiva que te hace mejor, ¿Cómo? Inspirando a todos los atletas y apasionados por el deporte con soluciones de alto rendimiento que no sabían que necesitaban, pero después de probarlas no se pueden imaginar viviendo sin ellas. ¡No olvides revisar la guía de tallas antes de realizar tu compra!', 13, 259935, 513, 9, '2023-06-15 09:50:45'),
(141, 'Tenis Hombre Nike Air Max Sc', 'PRODUCTO:\r\n\r\nNombre: Tenis Hombre Nike Air Max Sc\r\nMarca: Nike\r\n\r\nDESCRIPCIÓN:\r\n\r\n- Modelo: CW4555-002\r\n- Nombre Articulo: Air Max Sc\r\n- Categoría: Nike Sportswear\r\n- Color: Black/White-Black\r\n- Genero: Hombre\r\n\r\nMÁS DETALLES:\r\n\r\nPeso del paquete: 2 kg\r\nMedidas: 11 cm x 28 cm x 36 cm cm\r\nModelo: CW4555-002\r\nMeses de garantía: 2\r\nGarantía: SI\r\nCondición: Nuevo\r\nColor: Gris\r\nNombre de color: Gris\r\nGénero: Masculino\r\nSKU: 117333100049', 13, 532950, 45, 9, '2023-09-06 09:50:45'),
(145, 'ejemplo', 'descripcion del producto', 6, 50000, 15, 9, '2023-09-12 00:00:00'),
(146, 'ejemplo2', 'descripcion del producto', 18, 100000, 155, 9, '2023-09-12 00:00:00');

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
  `correoElectronico` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `password` varchar(60) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `activo` int NOT NULL DEFAULT '1',
  `telefono` varchar(10) DEFAULT NULL,
  `fecha de nacimiento` date NOT NULL,
  `IdRol` int NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `correo electronico` (`correoElectronico`),
  KEY `IdRol` (`IdRol`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`Id`, `nombre`, `nombre de usuario`, `correoElectronico`, `password`, `activo`, `telefono`, `fecha de nacimiento`, `IdRol`) VALUES
(9, 'Admin', 'Admin', 'Admin@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918702', '2004-03-04', 2),
(10, 'Mateo josue Rodriguez Chico', 'Mateo', 'mateo204r@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918702', '2004-03-04', 1);

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
