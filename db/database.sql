-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-05-2023 a las 14:47:54
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `olddatabase`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dialogos`
--

CREATE TABLE `dialogos` (
  `COD_dialogo` int(11) NOT NULL,
  `dialogo` mediumtext NOT NULL,
  `COD_personaje` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `dialogos`
--

INSERT INTO `dialogos` (`COD_dialogo`, `dialogo`, `COD_personaje`) VALUES
(1, 'Se trata de Nancy. Es compañera de clase de Helen y Marleene. Se ha mudado desde Colorado este septiembre y ha causado un gran revuelo entre los chicos del instituto.', 1),
(2, 'Hay mucha sangre, y el vestido está completamente manchado debido a las múltiples puñaladas que ha recibido la chica.', 1),
(3, 'Parece el arma homicida. Es uno de los cuchillos de la cocina del campamento, de eso no hay duda.', 1),
(4, 'No se ven pisadas, y está completamente manchado de sangre, quien lo hizo ha sido bastante cuidadoso con no dejar rastro.', 1),
(5, 'Es la  cabaña de las chicas. En ella duermen también Helen y Marleene... El director va a tener que reubicarlas después de esto.', 1),
(6, 'Hay muestras de forcejeo, tiene una de las uñas rotas, probablemente haya conseguido arañar a su agresor.', 1),
(7, 'Bienvenido al campamento The Otter. Espero que estés preparado para dos semanas de diversión. Tus compañeros ya están ubicados en sus cabañas. La tuya es la cabaña número 7, puedes ir a acomodarte si quieres .', 8),
(8, 'Hey, pensé que ya no llegabas. ¿Qué tal el viaje?', 3),
(9, 'He hablado con Marleene para hacer una fogata esta noche y contar historias. Nos vemos esta noche.', 3),
(10, '¡Hey! Se me ha hecho eterno no verte, y eso que sólo ha pasado un mes desde que nos dieron las vacaciones de verano. ¿cómo estas?', 2),
(11, '¿Descansar? Eso es para los viejos, esta noche hay hoguera y vamos a contar historias, hasta Helen se ha animado a venir', 2),
(12, 'Te veo esta noche entonces', 2),
(13, 'Vale, pues os voy a contar mi historia: Había un anciano señor en una vieja casa no muy lejos de aquí. El reloj de cucú de aquel hombre marcó las 22:00 de la noche, mientras este apagaba las lámparas de aceite alrededor de su casa para ir a dormir, había sido un día muy pesado. Poco después de que el reloj diera las 22:00 de la noche, cuando ya había ido a dormir, se escuchó tocar la puerta.- TOC, TOC, TOC-. \nAlgo extrañado, encendió la lámpara de la mesa de noche, y fue destinado a abrir la puerta. Y al abrirla, alcanzó a ver por el brillo que emanaba su lámpara, a una niña de no más de 7 años, totalmente quemada.', 3),
(14, 'Que horror', 2),
(15, 'Voy a seguir: El viejo señor cerró la puerta de un golpe, cerró las ventanas y se acostó a dormir. Al día siguiente, exactamente a la misma hora sucedió lo mismo cuando ya se estaba acomodando para dormir.', 3),
(16, 'Fue por eso que al día siguiente se lo comentó, a un amigo que vivía cerca de su casa, y este le recomendó ir a una señora espiritista que vivía a las afueras del pueblo. ', 3),
(17, 'Salió tempranito, cuando a lo lejos divisó el tarantín rojo donde hacía su trabajo aquella vieja bruja. Al entrar, a la señora le dió una fuerte corazonada cuando vio entrar a Demetrio, pero no le hizo caso.', 3),
(18, '-Bienvenido, ¿qué desea?- Preguntó Madame lalou a Demetrio. Éste contó lo que le sucedía, y ésta comenzó a llorar. Le dijo que esa niña era su sobrina, que había muerto en un incendio a las 22:08 de la noche, ella estaba dormida, y tenía sed.', 3),
(19, 'Toda su familia murió en ese incendio, pero es el alma de mi sobrina María la que vaga, pidiendo un poco de agua. Demetrio aún con los pelos erizados, preguntó:  Y no hay forma alguna de hacer que se vaya?, que no me moleste mas?', 3),
(20, 'Sí, sí hay una forma - Dijo la anciana  Cuando la niña se aparezca de nuevo por su casa, sencillamente ábrale la puerta y dele un poco de agua, es la única forma de que deje de molestarlo.', 3),
(21, 'Ese día, Demetrio padeció un escalofrío constante a lo largo de su cuerpo. El reloj, dió las 22:00. ¡Faltaban 8 minutos!, Demetrio se ponía las manos en la cabeza y sudaba a litros. De repente, se escuchó el crujir de la paja seca, y&& TOC, TOC, TOC.', 3),
(22, 'Demetrio brincó, corrió a la cocina, y tomó agua fresca en un tarro que ya tenía preparado para ese momento. Abrió la puerta. Y ahí estaba, aquel cuerpo casi amorfo a causa de las llamas que la cobijaron aquella noche, a aquella misma hora. -¡¡¡Agua!!!, por favor, ¡¡agua!!, ¡¡AGUA!!-Suplicó la niña.', 3),
(23, 'Ya con el tarro en la mano y sin pensarlo dos veces, Demetrio le sirvió agua, la cual la niña bebió en un segundo. -¡¡Más, por favor!!- Le dijo la niña de nuevo.', 3),
(24, 'Este le sirvió de nuevo. En los ojos de la pequeña niña, Demetrio distinguió perfectamente, como si fuera una película, el momento en el que la niña se quemaba, un frío intenso heló la piel de Demetrio, y en los ojos de la infante, aún se reflejaba el momento de su tragedia. ', 3),
(25, 'Ya acabado el tarro, la niña se volteó y se fue, atravesando los matorrales, atravesando el bosque como si flotara, hasta que se perdió de los ojos de aquel asustado hombre. Se volteó y se acostó, su cama se encontraba hirviendo!!!, como si fuera el infierno propio.', 3),
(26, 'Al parecer una noche de 1951, una de las prostitutas que ejercían su labor en un prostíbulo no muy lejos de aquí, apareció muerta en su cama con una puñalada en el vientre. El FBI, después de realizar sus investigaciones concluyeron en que se trataba de algo súper raro.', 4),
(27, 'Lo siento chicos, no me encuentro bien, me voy a ir a la cama', 2),
(28, 'Descansa, ya habrá más noches para contar historias.', 4),
(29, 'Bueno, sigo con la historia:  Nadie oyó los gritos de la mujer mientras era asesinada. En sus manos había heridas producidas por la hoja de un cuchillo y todo aparentaba como si hubiera sido ella misma la que se lo hubiera clavado. Los forenses determinaron un suicidio y algo más: la prostituta estaba embarazada.', 4),
(30, 'Dos años después todo parecía haberse olvidado, pero la habitación donde murió la joven no volvió a ser utilizada por ninguna de las otras prostitutas. El dueño del local, mandó cerrar con llave la habitación y nadie entró allí durante varios meses. En verano de 1953, una mujer de unos 30 años llegó al prostíbulo.', 4),
(31, 'Como aquella noche, todo estaba lleno y claro, el dueño no tuvo más remedio que abrirle la habitación de la otra prostituta muerta dos años antes&', 4),
(32, '&Cuando abrieron la puerta& en las paredes alguien había dibujado caras con llorando desfiguradas, también había cruces y animales como lechuzas, gatos y ratones muertos colgando del techo con cuerdas&. El dueño del local, viendo aquello, le dijo a la nueva mujer que durmiera con una compañera y a la mañana siguiente mandó limpiar y  pintar el cuarto.', 4),
(33, 'Sin embargo, las caras de lamento volvían a aparecer una, y otra y otra y otra vez en la pared. La voz se empezó a correr por la ciudad y un mal día Carlos tuvo que cerrar su negocio y se marchó de la ciudad. Desde entonces la casa permaneció en ruinas hasta que fue derribada.', 4),
(34, 'Yo no creo en estas cosas, la verdad, pero he de decir que nos pasó una cosa bastante extraña volviendo de vacaciones a Connecticut cuando nos encontramos un hombre vestido de blanco haciendo autostop en medio de la carretera. ', 5),
(35, 'Mi madre dijo de parar a recogerlo y mi padre siguió conduciendo diciéndole que cómo íbamos a recoger a un extraño. El caso es que mi madre lo consiguió convencer y, paramos un poco después de rebasarle, y al mirar no había nadie.', 5),
(36, 'Pues yo creo que era una aparición de alguien que se habría muerto en la carretera y nunca pudo llegar a casa& En fin& Deberíamos ir yéndonos a dormir, que se está haciendo tarde.', 3),
(37, 'Todo empezó una tarde de agosto, hace un par de años, yo acababa de cumplir dieciséis años y estaba de picnic con los amigos de mi pueblo de la sierra.', 6),
(38, 'Éramos cinco o así, y a eso de las ocho y media de la tarde, cuando empieza a oscurecer, a uno de mis compañeros se le ocurrió la idea de hacer una ouija.', 6),
(39, 'Yo me quería largar de allí cuanto antes y me fui con otro de los colegas un poco más lejos de dónde estaban ellos con la ouija.', 6),
(40, 'Al volver los dos hacia el lugar donde se produjo la supuesta invocación, el resto de mis compañeros nos advirtieron que habían contactado con un espíritu de una mujer, que les había dicho que tendríamos problemas para volver de vuelta a casa.', 6),
(41, 'Dos de mis amigos bajaron en la moto y avisaron a mi primo para que viniera a recogernos al resto. Cuando vino mi primo con su coche nos montamos y prácticamente nada más arrancar, el motor se paró.', 6),
(42, 'Los que íbamos con él, nos miramos, mi primo volvió a arrancar el coche& y se para de nuevo& y así hasta cuatro veces.', 6),
(43, 'Conseguimos arrancar y salir de allí con muy mal cuerpo, y cuando íbamos camino al pueblo notamos que ganábamos velocidad con demasiada facilidad y de repente el coche se frenó de nuevo en seco y el coche quedó atravesado en la carretera.', 6),
(44, 'Eso es mentira seguro', 4),
(45, 'No lo es, te lo juro, estaba allí y aquello dio muy mal rollo', 6),
(46, 'Espera, he visto una sombra', 4),
(47, 'La historia que voy a contar le pasó a mi padre cuando era joven, o eso me ha contado. Tenía 19 años y vivía en Francia, en una casa bastante grande que estaba a las afueras.', 2),
(48, 'Mi padre tiene dos hermanas más pequeñas y la más pequeña de los tres tenía 6 años y solía subir a jugar a la buhardilla con las muñecas.', 2),
(49, 'Un día empezó a decirle a mi padre que cuando subía a jugar siempre oía ruidos como si tirasen como una pelota y rodase por el suelo, pero que luego nunca veía nada. Mi padre le quitaba importancia puesto que pensaba que eran las típicas imaginaciones de una niña, pero mi tía insistía en que se oían ruidos sin verse nada.', 2),
(50, 'Mi padre se lo contó a mi abuelo y viendo que mi tía dejó de subir allí a jugar decidieron comprobar un día si era cierto que se oían esos ruidos extraños. ', 2),
(51, 'Subieron arriba, se colocaron uno a cada lado de la buhardilla con una linterna cada uno y todo apagado y si oían algo encender las linternas para ver si verdaderamente había algo allí que provocase los ruidos.', 2),
(52, 'Permanecieron un buen rato allí parados esperando, y de repente, verdaderamente se empezaron a oír ruidos como los que había mencionado mi tía.', 2),
(53, 'Un sonido como si tirasen una nuez desde arriba del todo y cayera rodando por el suelo, y en ese momento encendieron las linternas pero no consiguieron ver nada, de manera que las apagaron y esperaron otra vez pensando que habían llegado tarde a encenderlas y que sería alguna rata o algun animal que se habría colado.', 2),
(54, 'Estuvieron así un buen rato sin conseguir ver nada, pero oyendo los ruidos que cada vez eran más frecuentes, y al final desistieron y bajaron.', 2),
(55, 'La historia quedó ahí y pasaron varios días, uno de ellos le dijo mi abuelo a mi padre que tenía que bajar al pozo a por agua porque no había.', 2),
(56, 'Estaba bastante oscuro y mi padre un poco asustado me dijo que bajó de todos modos. Así que bajó, y empezó a subirle cubos de agua a mi abuelo, hasta que sintió cómo una presencia detrás de él le respiraba cerca.', 2),
(57, 'Mi padre se giró rápidamente para ver si veía algo y oyó cómo unas voces suplicaban que se fueran de allí, que no pretendían hacerles daño, pero que ésa era su casa y habían muerto allí y no se iban a ir.', 2),
(58, 'Mi padre empezó a gritarle a mi abuelo que por favor le subiese mientras comenzó a ver dos personas que se aparecían mientras le suplicaban que se alejaran de allí.', 2),
(59, 'En cuanto ahorraron un poco se marcharon y la dejaron vacía como ellos pidieron. Mi padre me contó esta historia hace ya muchos años, yo al principio no creía que estas cosas pudieran ser ciertas, pero creo que mi padre no me mentiría en algo así& la verdad&', 2),
(60, 'Esa puerta no debería estar abierta, vamos a entrar a ver qué ha pasado', 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `episodio`
--

CREATE TABLE `episodio` (
  `NUM_episodio` int(11) NOT NULL,
  `nombreEpisodio` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `episodio`
--

INSERT INTO `episodio` (`NUM_episodio`, `nombreEpisodio`) VALUES
(1, 'Prólogo'),
(2, 'Episodio 1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `imagenes`
--

CREATE TABLE `imagenes` (
  `COD_imagen` int(11) NOT NULL,
  `num_episodio` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `Path` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `interaccionimagen`
--

CREATE TABLE `interaccionimagen` (
  `COD_intIMG` int(11) NOT NULL,
  `num_episodio` int(11) NOT NULL,
  `COD_imagen` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `interaccionsonido`
--

CREATE TABLE `interaccionsonido` (
  `COD_intPNJ` int(11) NOT NULL,
  `num_episodio` int(11) NOT NULL,
  `nombrePNJ` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `interaccionsonido2`
--

CREATE TABLE `interaccionsonido2` (
  `COD_intSonido` int(11) NOT NULL,
  `num_episodio` int(11) NOT NULL,
  `COD_sonido` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partidas_guardadas`
--

CREATE TABLE `partidas_guardadas` (
  `slot1` varchar(45) DEFAULT NULL,
  `slot2` varchar(45) DEFAULT NULL,
  `slot3` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `partidas_guardadas`
--

INSERT INTO `partidas_guardadas` (`slot1`, `slot2`, `slot3`) VALUES
('Prologue', 'Ep1', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personajes`
--

CREATE TABLE `personajes` (
  `COD_personaje` int(11) NOT NULL,
  `num_episodio` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `personajes`
--

INSERT INTO `personajes` (`COD_personaje`, `num_episodio`, `nombre`) VALUES
(1, 1, 'Narrador'),
(2, 1, 'Marlene'),
(3, 1, 'John'),
(4, 1, 'Travis'),
(5, 1, 'Helen'),
(6, 1, 'Chang'),
(7, 1, 'Karen'),
(8, 1, 'Monitor');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pnj`
--

CREATE TABLE `pnj` (
  `nombre` varchar(45) NOT NULL,
  `num_episodio` int(11) NOT NULL,
  `seleccionado` tinyint(4) NOT NULL,
  `vida` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sonido`
--

CREATE TABLE `sonido` (
  `COD_sonido` int(11) NOT NULL,
  `num_episodio` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `Path` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `nombreUsuario` varchar(45) NOT NULL,
  `NUM_episodio` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `partida_guardada` longblob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `dialogos`
--
ALTER TABLE `dialogos`
  ADD PRIMARY KEY (`COD_dialogo`),
  ADD KEY `COD_personaje_idx` (`COD_personaje`);

--
-- Indices de la tabla `episodio`
--
ALTER TABLE `episodio`
  ADD PRIMARY KEY (`NUM_episodio`);

--
-- Indices de la tabla `imagenes`
--
ALTER TABLE `imagenes`
  ADD PRIMARY KEY (`COD_imagen`),
  ADD KEY `numEpisodio4_idx` (`num_episodio`);

--
-- Indices de la tabla `interaccionimagen`
--
ALTER TABLE `interaccionimagen`
  ADD PRIMARY KEY (`COD_intIMG`),
  ADD KEY `numEpisodio6_idx` (`num_episodio`),
  ADD KEY `COD_Imagen_idx` (`COD_imagen`);

--
-- Indices de la tabla `interaccionsonido`
--
ALTER TABLE `interaccionsonido`
  ADD PRIMARY KEY (`COD_intPNJ`),
  ADD KEY `numEpisodio2_idx` (`num_episodio`);

--
-- Indices de la tabla `interaccionsonido2`
--
ALTER TABLE `interaccionsonido2`
  ADD PRIMARY KEY (`COD_intSonido`),
  ADD KEY `numEpisodio7_idx` (`num_episodio`),
  ADD KEY `Cod_sonido_idx` (`COD_sonido`);

--
-- Indices de la tabla `personajes`
--
ALTER TABLE `personajes`
  ADD PRIMARY KEY (`COD_personaje`),
  ADD KEY `numepisodio4_idx` (`num_episodio`);

--
-- Indices de la tabla `pnj`
--
ALTER TABLE `pnj`
  ADD PRIMARY KEY (`nombre`),
  ADD KEY `num_episodio_idx` (`num_episodio`);

--
-- Indices de la tabla `sonido`
--
ALTER TABLE `sonido`
  ADD PRIMARY KEY (`COD_sonido`),
  ADD KEY `numepisodio3_idx` (`num_episodio`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`nombreUsuario`),
  ADD KEY `NUM_episodio_idx` (`NUM_episodio`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `dialogos`
--
ALTER TABLE `dialogos`
  MODIFY `COD_dialogo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

--
-- AUTO_INCREMENT de la tabla `episodio`
--
ALTER TABLE `episodio`
  MODIFY `NUM_episodio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `personajes`
--
ALTER TABLE `personajes`
  MODIFY `COD_personaje` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `dialogos`
--
ALTER TABLE `dialogos`
  ADD CONSTRAINT `COD_personaje` FOREIGN KEY (`COD_personaje`) REFERENCES `personajes` (`COD_personaje`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `interaccionimagen`
--
ALTER TABLE `interaccionimagen`
  ADD CONSTRAINT `COD_Imagen` FOREIGN KEY (`COD_imagen`) REFERENCES `imagenes` (`COD_imagen`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `numEpisodio6` FOREIGN KEY (`num_episodio`) REFERENCES `episodio` (`NUM_episodio`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `interaccionsonido`
--
ALTER TABLE `interaccionsonido`
  ADD CONSTRAINT `numEpisodio2` FOREIGN KEY (`num_episodio`) REFERENCES `episodio` (`NUM_episodio`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `interaccionsonido2`
--
ALTER TABLE `interaccionsonido2`
  ADD CONSTRAINT `Cod_sonido` FOREIGN KEY (`COD_sonido`) REFERENCES `sonido` (`COD_sonido`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `numEpisodio7` FOREIGN KEY (`num_episodio`) REFERENCES `episodio` (`NUM_episodio`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `personajes`
--
ALTER TABLE `personajes`
  ADD CONSTRAINT `numepisodio4` FOREIGN KEY (`num_episodio`) REFERENCES `episodio` (`NUM_episodio`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `pnj`
--
ALTER TABLE `pnj`
  ADD CONSTRAINT `num_episodio` FOREIGN KEY (`num_episodio`) REFERENCES `episodio` (`NUM_episodio`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `sonido`
--
ALTER TABLE `sonido`
  ADD CONSTRAINT `numepisodio3` FOREIGN KEY (`num_episodio`) REFERENCES `episodio` (`NUM_episodio`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `numEepisodio` FOREIGN KEY (`NUM_episodio`) REFERENCES `episodio` (`NUM_episodio`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
