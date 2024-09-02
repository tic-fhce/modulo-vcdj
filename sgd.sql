-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-08-2024 a las 09:49:26
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sgd2`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno_libre`
--

CREATE TABLE `alumno_libre` (
  `id` int(11) NOT NULL,
  `cif` bigint(20) DEFAULT NULL,
  `d_respaldo` varchar(255) DEFAULT NULL,
  `d_solicitud` varchar(255) DEFAULT NULL,
  `r_respaldo` varchar(255) DEFAULT NULL,
  `r_solicitud` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `tramite_id` varchar(255) DEFAULT NULL,
  `d_proy_resolucion` varchar(255) DEFAULT NULL,
  `r_proy_resolucion` varchar(255) DEFAULT NULL,
  `d_resolucion` varchar(255) DEFAULT NULL,
  `c_proy_resolucion` varchar(255) DEFAULT NULL,
  `c_resolucion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aprobacion_perfil`
--

CREATE TABLE `aprobacion_perfil` (
  `id` int(11) NOT NULL,
  `tramite_id` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `modalidad` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `cif` bigint(20) DEFAULT NULL,
  `c_proyecto_resolucion_perfil` varchar(255) DEFAULT NULL,
  `c_resolucion_perfil` varchar(255) DEFAULT NULL,
  `c_solicitud_aprobacion_perfil` varchar(255) DEFAULT NULL,
  `d_carta_institucion` varchar(255) DEFAULT NULL,
  `d_conclusion_estudios` varchar(255) DEFAULT NULL,
  `d_nota_director` varchar(255) DEFAULT NULL,
  `d_nota_tutor` varchar(255) DEFAULT NULL,
  `d_perfil_grado` varchar(255) DEFAULT NULL,
  `d_proyecto_resolucion_perfil` varchar(255) DEFAULT NULL,
  `d_record_academico` varchar(255) DEFAULT NULL,
  `d_resolucion_perfil` varchar(255) DEFAULT NULL,
  `d_solicitud_aprobacion_perfil` varchar(255) DEFAULT NULL,
  `r_carta_institucion` varchar(255) DEFAULT NULL,
  `r_conclusion_estudios` varchar(255) DEFAULT NULL,
  `r_nota_director` varchar(255) DEFAULT NULL,
  `r_nota_tutor` varchar(255) DEFAULT NULL,
  `r_perfil_grado` varchar(255) DEFAULT NULL,
  `r_record_academico` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id` varchar(255) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id`, `nombre`) VALUES
('AC', 'ACADEMICO'),
('AD', 'ADMINISTRATIVO'),
('FN', 'FINANCIERO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `certificado_conclusion`
--

CREATE TABLE `certificado_conclusion` (
  `id` int(11) NOT NULL,
  `c_certificado_conclusion` varchar(255) DEFAULT NULL,
  `cif` bigint(20) DEFAULT NULL,
  `d_cedula_identidad` varchar(255) DEFAULT NULL,
  `d_certificado_unico` varchar(255) DEFAULT NULL,
  `d_certificado_conclusion` varchar(255) DEFAULT NULL,
  `d_valorada` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `tramite_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `certificado_unico`
--

CREATE TABLE `certificado_unico` (
  `id` int(11) NOT NULL,
  `cif` bigint(20) DEFAULT NULL,
  `d_cedula_identidad` varchar(255) DEFAULT NULL,
  `d_certificado_unico` varchar(255) DEFAULT NULL,
  `d_valorada` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `tramite_id` varchar(255) DEFAULT NULL,
  `c_certificado_unico` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `concurso_doc_interinos`
--

CREATE TABLE `concurso_doc_interinos` (
  `id` int(11) NOT NULL,
  `c_informe_conv` varchar(255) DEFAULT NULL,
  `c_nota_vic` varchar(255) DEFAULT NULL,
  `cif` bigint(20) DEFAULT NULL,
  `d_informe_conv` varchar(255) DEFAULT NULL,
  `d_nota_vic` varchar(255) DEFAULT NULL,
  `d_respaldo` varchar(255) DEFAULT NULL,
  `d_solicitud` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `tramite_id` varchar(255) DEFAULT NULL,
  `c_informe_obs` varchar(255) DEFAULT NULL,
  `d_informe_obs` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `convalidacion_01`
--

CREATE TABLE `convalidacion_01` (
  `id` int(11) NOT NULL,
  `cif` bigint(20) DEFAULT NULL,
  `d_cedula_identidad` varchar(255) DEFAULT NULL,
  `d_nota_director` varchar(255) DEFAULT NULL,
  `d_record_academico` varchar(255) DEFAULT NULL,
  `r_cedula_identidad` varchar(255) DEFAULT NULL,
  `r_nota_director` varchar(255) DEFAULT NULL,
  `r_record_academico` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `tramite_id` varchar(255) DEFAULT NULL,
  `c_informe_convalidacion` varchar(255) DEFAULT NULL,
  `d_informe_convalidacion` varchar(255) DEFAULT NULL,
  `r_informe_convalidacion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `convalidacion_02`
--

CREATE TABLE `convalidacion_02` (
  `id` int(11) NOT NULL,
  `c_informe_convalidacion` varchar(255) DEFAULT NULL,
  `c_proy_resolucion` varchar(255) DEFAULT NULL,
  `c_resolucion` varchar(255) DEFAULT NULL,
  `cif` bigint(20) DEFAULT NULL,
  `d_cedula_identidad` varchar(255) DEFAULT NULL,
  `d_contenidos_analiticos` varchar(255) DEFAULT NULL,
  `d_formulario_convalidacion` varchar(255) DEFAULT NULL,
  `d_informe_convalidacion` varchar(255) DEFAULT NULL,
  `d_nota_director` varchar(255) DEFAULT NULL,
  `d_proy_resolucion` varchar(255) DEFAULT NULL,
  `d_record_academico_carrera_origen` varchar(255) DEFAULT NULL,
  `d_resolucion` varchar(255) DEFAULT NULL,
  `r_cedula_identidad` varchar(255) DEFAULT NULL,
  `r_contenidos_analiticos` varchar(255) DEFAULT NULL,
  `r_formulario_convalidacion` varchar(255) DEFAULT NULL,
  `r_nota_director` varchar(255) DEFAULT NULL,
  `r_proy_resolucion` varchar(255) DEFAULT NULL,
  `r_record_academico_carrera_origen` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `tramite_id` varchar(255) DEFAULT NULL,
  `r_informe_convalidacion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `convocatoria`
--

CREATE TABLE `convocatoria` (
  `id` int(11) NOT NULL,
  `tramite_id` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `cif` bigint(20) DEFAULT NULL,
  `d_convocatoria` varchar(255) DEFAULT NULL,
  `r_convocatoria` varchar(255) DEFAULT NULL,
  `c_convocatoria` varchar(255) DEFAULT NULL,
  `d_nota_atencion` varchar(255) DEFAULT NULL,
  `c_nota_atencion` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `nueva_variable` varchar(255) DEFAULT NULL,
  `c_certificacion_carga_horaria` varchar(255) DEFAULT NULL,
  `d_certificacion_carga_horaria` varchar(255) DEFAULT NULL,
  `r_certificacion_carga_horaria` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `designacion_doc_interinos`
--

CREATE TABLE `designacion_doc_interinos` (
  `id` int(11) NOT NULL,
  `c_proy_resolucion` varchar(255) DEFAULT NULL,
  `c_resolucion` varchar(255) DEFAULT NULL,
  `cif` bigint(20) DEFAULT NULL,
  `d_faltantes` varchar(255) DEFAULT NULL,
  `d_proy_resolucion` varchar(255) DEFAULT NULL,
  `d_resolucion` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `tramite_id` varchar(255) DEFAULT NULL,
  `r_proy_resolucion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `designacion_tribunal`
--

CREATE TABLE `designacion_tribunal` (
  `id` int(11) NOT NULL,
  `tramite_id` varchar(255) DEFAULT NULL,
  `aprobacion_perfil_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `cif` bigint(20) DEFAULT NULL,
  `c_proyecto_resolucion_tribunal` varchar(255) DEFAULT NULL,
  `c_resolucion_tribunal` varchar(255) DEFAULT NULL,
  `d_carta_conclusion_institucion` varchar(255) DEFAULT NULL,
  `d_nota_suficiencia_tutor` varchar(255) DEFAULT NULL,
  `d_proyecto_resolucion_tribunal` varchar(255) DEFAULT NULL,
  `d_resolucion_tribunal` varchar(255) DEFAULT NULL,
  `d_trabajo_grado` varchar(255) DEFAULT NULL,
  `r_carta_conclusion_institucion` varchar(255) DEFAULT NULL,
  `r_nota_suficiencia_tutor` varchar(255) DEFAULT NULL,
  `r_trabajo_grado` varchar(255) DEFAULT NULL,
  `c_solicitud_tribunal` varchar(255) DEFAULT NULL,
  `d_solicitud_tribunal` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `flujo`
--

CREATE TABLE `flujo` (
  `id` int(11) NOT NULL,
  `flujo` varchar(255) DEFAULT NULL,
  `proceso` varchar(255) DEFAULT NULL,
  `proceso_sig` varchar(255) DEFAULT NULL,
  `formulario` varchar(255) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `tiempo` int(11) DEFAULT NULL,
  `categoria_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `flujo`
--

INSERT INTO `flujo` (`id`, `flujo`, `proceso`, `proceso_sig`, `formulario`, `role_id`, `tiempo`, `categoria_id`) VALUES
(832, 'F1', 'P1', 'P2', 'INSCRIPCIONES DE ASIGNATURAS DE ALUMNOS LIBRES', 7, 12, 'AC'),
(833, 'F1', 'P2', 'P3', 'Deriva a URAF para la revisión y verificación', 3, 12, 'AC'),
(834, 'F1', 'P3', NULL, 'Verificación de documentos', 4, 12, 'AC'),
(835, 'F1', 'P4', 'P5', 'Recepción de documentos', 3, 12, 'AC'),
(836, 'F1', 'P5', 'P6', 'Revisa y aprueba, se envia al HCF', 11, 12, 'AC'),
(837, 'F1', 'P6', 'P7', ' Emisión de la Resolución de alumno libre', 1, 12, 'AC'),
(838, 'F1', 'P7', 'P8-Fin', 'Recibe resolución de alumno libre', 3, 12, 'AC'),
(839, 'F1', 'P8-Fin', 'Fin', 'RESOLUCION DE ALUMNO LIBRE', 7, 12, 'AC'),
(840, 'F1', 'P9', 'P3', 'Observado y corregir', 7, 12, 'AC'),
(841, '', '', '', '', NULL, NULL, NULL),
(842, 'F2', 'P1', 'P2', 'INSCRIPCIÓN DE MATERIAS EXTRA', 7, 12, 'AC'),
(843, 'F2', 'P2', 'P3', 'Deriva a URAF para la revisión y verificación', 3, 12, 'AC'),
(844, 'F2', 'P3', NULL, ' Verificación de prerrequisitos', 4, 12, 'AC'),
(845, 'F2', 'P4', 'P5', ' Emite aval para tomar materias extra', 11, 12, 'AC'),
(846, 'F2', 'P5', 'P6-Fin', 'Notifica y comunica al estudiante', 3, 12, 'AC'),
(847, 'F2', 'P6-Fin', 'Fin', 'INSCRIPCIÓN DE MATERIAS EXTRA', 7, 12, 'AC'),
(848, 'F2', 'P7', 'P3', 'Observado y corregir', 7, 12, 'AC'),
(849, '', '', '', '', NULL, NULL, NULL),
(850, 'F3', 'P1', 'P2', 'CONVALIDACIÓN DE MATERIAS DE PLAN A PLAN', 7, 12, 'AC'),
(851, 'F3', 'P2', 'P3', 'Remite a URAF para su verificacion', 3, 12, 'AC'),
(852, 'F3', 'P3', NULL, 'Validación de documentos', 4, 12, 'AC'),
(853, 'F3', 'P4', 'P5', 'Verifica las materias que se pueden convalidar', 4, 12, 'AC'),
(854, 'F3', 'P5', NULL, 'Revisión de Informe', 3, 12, 'AC'),
(855, 'F3', 'P6', 'P7', 'Firma informe de convalidación', 3, 12, 'AC'),
(856, 'F3', 'P7', 'P8', 'Firma informe de convalidación', 2, 12, 'AC'),
(857, 'F3', 'P8', 'P9-Fin', 'Revisión de firmas y migración de datos al sistema SSA', 4, 12, 'AC'),
(858, 'F3', 'P9-Fin', 'Fin', 'CONVALIDACIÓN DE MATERIAS DE PLAN A PLAN', 7, 12, 'AC'),
(859, 'F3', 'P10', 'P3', 'Correccion de errores', 7, 12, 'AC'),
(860, '', '', '', '', NULL, 12, 'AC'),
(861, 'F4', 'P1', 'P2', 'CONVALIDACIÓN  DE MATERIAS DE OTRAS CARRERAS', 7, 12, 'AC'),
(862, 'F4', 'P2', 'P3', 'Recepción y remite a URAF para su verificación', 3, 12, 'AC'),
(863, 'F4', 'P3', NULL, 'Validación de documentos', 4, 12, 'AC'),
(864, 'F4', 'P4', 'P5', 'Validado por Kardex', 3, 12, 'AC'),
(865, 'F4', 'P5', 'P6', 'Revision de documentos', 10, 12, 'AC'),
(866, 'F4', 'P6', 'P7', 'Elaboración de proyecto de resolución', 3, 12, 'AC'),
(867, 'F4', 'P7', NULL, 'Revisa y aprueba la resolucion', 11, 12, 'AC'),
(868, 'F4', 'P8', 'P9', 'Elaboración de Resolución de Convalidación', 1, 12, 'AC'),
(869, 'F4', 'P9', 'P10-Fin', 'Recepción de Resolución de Convalidación', 3, 12, 'AC'),
(870, 'F4', 'P10-Fin', 'Fin', 'CONVALIDACIÓN  DE MATERIAS DE OTRAS CARRERAS', 7, 12, 'AC'),
(871, 'F4', 'P11', 'P3', 'Corrección de errores', 7, 12, 'AC'),
(872, '', '', '', '', NULL, 12, 'AC'),
(873, 'F5', 'P1', 'P2', 'CERTIFICADO ÚNICO DE CALIFICACIONES', NULL, 12, 'AC'),
(874, 'F5', 'P2', 'P3', 'Llenado del Certificado', 4, 12, 'AC'),
(875, 'F5', 'P3', 'P4', 'Firma el Certificado', 3, 12, 'AC'),
(876, 'F5', 'P4', 'P5', 'Firma el Certificado', 1, 12, 'AC'),
(877, 'F5', 'P5', 'P6-Fin', 'Verificación de firmas', 4, 12, 'AC'),
(878, 'F5', 'P6-Fin', 'Fin', 'CERTIFICADO ÚNICO DE CALIFICACIONES', 7, 12, 'AC'),
(879, '', '', '', '', NULL, 12, 'AC'),
(880, 'F6', 'P1', 'P2', 'CERTIFICADO DE CONCLUSIÓN DE ESTUDIOS', NULL, 12, 'AC'),
(881, 'F6', 'P2', 'P3', 'Validación de documentos', 4, 12, 'AC'),
(882, 'F6', 'P3', 'P4', 'Firma el Certificado', 3, 12, 'AC'),
(883, 'F6', 'P4', 'P5', 'Firma el Certificado', 1, 12, 'AC'),
(884, 'F6', 'P5', 'P6-Fin', 'Recepción de informe', 4, 12, 'AC'),
(885, 'F6', 'P6-Fin', 'Fin', 'CERTIFICADO DE CONCLUSIÓN DE ESTUDIOS', NULL, 12, 'AC'),
(886, 'F6', NULL, NULL, '', NULL, 12, 'AC'),
(887, 'F6', NULL, NULL, NULL, NULL, 12, 'AC'),
(888, '', '', '', '', NULL, 12, 'AC'),
(889, 'F7', 'P1', 'P2', 'LLENADO DE GAR  PARA DEFENSA (Gestiones Deriva a dirección)', NULL, 12, 'AC'),
(890, 'F7', 'P2', 'P3', 'Coordina con URAF fecha y hora de defensa', 3, 12, 'AC'),
(891, 'F7', 'P3', 'P4', ' Firma de GAR', 1, 12, 'AC'),
(892, 'F7', 'P4', 'P5-Fin', 'Notificacion pago de valores derecho defensa', 7, 12, 'AC'),
(893, 'F7', 'P5-Fin', 'Fin', 'Gestiones Recive y revisa', NULL, 12, 'AC'),
(894, '', '', '', '', NULL, 12, 'AC'),
(895, 'F8', 'P1', 'P2', 'CONVOCATORIA DE CONCURSO DE MERITOS PARA DOCENTES INTERINOS', 3, 12, 'AC'),
(896, 'F8', 'P2', 'P3', 'Emite certificación carga horaria', 14, 12, 'AC'),
(897, 'F8', 'P3', 'P4', 'Remite tramite mas la convocatoria a CAF', 3, 12, 'AC'),
(898, 'F8', 'P4', NULL, 'Aprueba la emisión de convocatoria', 2, 12, 'AC'),
(899, 'F8', 'P5', 'P6', 'Homologa la Resolución ', 1, 12, 'AC'),
(900, 'F8', 'P6', 'P7', 'Ajuste de fechas a la convocatoria y se envía a Vicerrectorado', 3, 12, 'AC'),
(901, 'F8', 'P7', NULL, 'SECRETARIA VICERRECTORADO', 13, 12, 'AC'),
(902, 'F8', 'P8', 'P9-Fin', 'Firma la Resolución ', 13, 12, 'AC'),
(903, 'F8', 'P9-Fin', 'Fin', 'Recibe el trámite y procede a publicar', 3, 12, 'AC'),
(904, '', '', NULL, '', NULL, 12, 'AC'),
(905, '', '', '', '', NULL, 12, 'AC'),
(906, '', '', '', '', NULL, 12, 'AC'),
(907, 'F9', 'P1', 'P2', 'CONCURSO DE MERITOS DE DOCENTES INTERINOS', 10, 12, 'AC'),
(908, 'F9', 'P2', 'P3', 'Remite con Nota los files presentados a las carreras', 6, 12, 'AC'),
(909, 'F9', 'P3', 'P4', 'Recibe y remite a la Comisión para revisión de documentos', 3, 12, 'AC'),
(910, 'F9', 'P4', 'P5', 'Revisa y evalúa los documentos presentados', 10, 12, 'AC'),
(911, 'F9', 'P5', 'P6', 'Dispone Fecha para reclamos a resultados publicados', 3, 12, 'AC'),
(912, 'F9', 'P6', 'P7-Fin', 'Subsana observaciones', 10, 12, 'AC'),
(913, 'F9', ' P7-Fin', ' Fin', 'Recepción de informe final', 3, 12, 'AC'),
(914, '', '', '', '', 1, 12, 'AC'),
(915, 'F10', 'P1', 'P2', 'DESIGNACION DE DOCENTES INTERINOS', 3, 12, 'AC'),
(916, 'F10', 'P2', 'P3', 'Adjunta documentos complementarios', 6, 12, 'AC'),
(917, 'F10', 'P3', 'P4', 'Prepara proyecto de Resolucion', 3, 12, 'AC'),
(918, 'F10', 'P4', NULL, 'Revisa y deriva la designación del personal docente', 2, 12, 'AC'),
(919, '', 'P5', 'P6-Fin', 'Homologa la designación del personal docente', 1, 12, 'AC'),
(920, 'F11', 'P6-Fin', 'Fin', 'Recibe la Resolución HCF', 3, 12, 'AC'),
(921, 'F11', '', ' ', '', NULL, 12, 'AC'),
(922, 'F11', '', '', '', 1, 12, 'AC'),
(923, 'F11', '', '', '', 3, 12, 'AC'),
(924, 'F11', 'P1', 'P2', 'DESIGNACION DE DOCENTES INVITADOS', NULL, 12, 'AC'),
(925, 'F11', 'P2', NULL, 'Revisa y deriva para la elaboración de la Resolución', NULL, 12, 'AC'),
(926, 'F11', 'P3', 'P4-Fin', 'Homologa la designación de docentes invitados', NULL, 12, 'AC'),
(927, 'F11', 'P4-Fin', 'Fin', 'Recibe la Resolución', NULL, 12, 'AC'),
(928, 'F11', '', '', '', NULL, 12, 'AC'),
(929, '', '', '', '', NULL, 12, 'AC'),
(930, 'F12', 'P1', 'P2', 'CONCURSO DE MÉRITOS Y EXAMEN DE COMPETENCIA PARA DOCENTES CONTRATADOS (pendiente)', NULL, 12, 'AC'),
(931, 'F12', '', '', '', NULL, 12, 'AC'),
(932, 'F12', '', '', '', NULL, 12, 'AC'),
(933, 'F12', '', '', '', NULL, 12, 'AC'),
(934, 'F12', '', '', '', NULL, 12, 'AC'),
(935, 'F12', '', '', '', NULL, 12, 'AC'),
(936, 'F12', '', '', '', NULL, 12, 'AC'),
(937, 'F12', '', '', '', NULL, 12, 'AC'),
(938, 'F12', '', '', '', NULL, 12, 'AC'),
(939, 'F12', '', '', '', NULL, 12, 'AC'),
(940, 'F12', '', '', '', NULL, 12, 'AC'),
(941, 'F12', '', '', '', NULL, 12, 'AC'),
(942, '', '', '', '', NULL, 12, 'AC'),
(943, 'F13', 'P1', 'P2', 'DESIGNACIÓN DE DOCENTES CONTRATADOS PARA PASAR A CATEGORIA TITULAR (pendiente)', 3, 12, 'AC'),
(944, 'F13', '', '', '', NULL, 12, 'AC'),
(945, 'F13', '', '', '', NULL, 12, 'AC'),
(946, 'F13', '', '', '', NULL, 12, 'AC'),
(947, 'F13', '', '', '', NULL, 12, 'AC'),
(948, 'F13', '', '', '', NULL, 12, 'AC'),
(949, 'F13', '', '', '', NULL, 12, 'AC'),
(950, 'F13', '', '', '', NULL, 12, 'AC'),
(951, 'F13', '', '', '', NULL, 12, 'AC'),
(952, 'F13', '', '', '', NULL, 12, 'AC'),
(953, 'F13', '', '', '', NULL, 12, 'AC'),
(954, 'F13', '', '', '', NULL, 12, 'AC'),
(955, '', '', '', '', NULL, 12, 'AC'),
(956, 'F14', 'P1', 'P2', 'PAGO DE DOCENTES - PARTES DE ASISTENCIA', NULL, 12, 'AC'),
(957, 'F14', 'P2', 'P3', 'Firma', 3, 12, 'AC'),
(958, 'F14', 'P3', 'P4', 'Firma', 2, 12, 'AC'),
(959, 'F14', 'P4', 'P5-Fin', 'Firma', NULL, 12, 'AC'),
(960, 'F14', 'P5-Fin', 'Fin', 'Se envia a personal docente', NULL, 12, 'AC'),
(961, '', '', '', '', NULL, 12, 'AC'),
(962, 'F15', 'P1', 'P2', 'CONVOCATORIA A AUXILIARES DE DOCENCIA', 3, 12, 'AC'),
(963, 'F15', 'P2', 'P3', 'Confirma la carga horaria', NULL, 12, 'AC'),
(964, 'F15', 'P3', 'P4', 'Proyecto de Resolución', 3, 12, 'AC'),
(965, 'F15', 'P4', NULL, 'Recibe, revisa y remite al HCF para su aprobación', 2, 12, 'AC'),
(966, 'F15', 'P5', 'P6', 'Homologa la Resolución', 1, 12, 'AC'),
(967, 'F15', 'P6', 'P7', 'Recibe el trámite y remite a bienestar social', 3, 12, 'AC'),
(968, 'F15', 'P7', NULL, 'Verifica y revisa la Convocatoria', NULL, 12, 'AC'),
(969, 'F15', 'P8', 'P9-Fin', 'Firma del Rector(a)', NULL, 12, 'AC'),
(970, 'F15', 'P9-Fin', 'Fin', 'Publica la Convocatoria', 3, 12, 'AC'),
(971, '', '', '', '', NULL, 12, 'AC'),
(972, 'F16', 'P1', 'P2', 'DESIGNACIÓN DE AUXILIARES  DE DOCENCIA POR INVITACIÓN', 3, 12, 'AC'),
(973, 'F16', 'P2', 'P3', 'Envía el listado de estudiantes con promedios altos', 4, 12, 'AC'),
(974, 'F16', 'P3', 'P4', 'Selecciona al estudiante con mayor promedio', 3, 12, 'AC'),
(975, 'F16', 'P4', NULL, 'Confirmacion', 7, 12, 'AC'),
(976, 'F16', 'P5', 'P6', 'Elabora el proyecto de Resolución de designación', 3, 12, 'AC'),
(977, 'F16', 'P6', NULL, 'Revisa y deriva al HCF', 2, 12, 'AC'),
(978, 'F16', 'P7', 'P8', 'Homologa la Resolución de Designación del estudiante invitado', 1, 12, 'AC'),
(979, 'F16', 'P8', 'P9-Fin', 'Remite el trámite a Becas Académicas para su registro', 3, 12, 'AC'),
(980, 'F16', 'P9-Fin', 'Fin', 'Entrega Memorándum al estudiante ', 7, 12, 'AC'),
(981, 'F16', 'P10', 'Fin', '', NULL, 12, 'AC'),
(982, 'F16', '', '', '', NULL, 12, 'AC'),
(983, '', '', '', '', NULL, 12, 'AC'),
(984, 'F17', 'P1', 'P2', 'PARTES DE ASISTENCIA AUXILIARES', NULL, 12, 'AC'),
(985, 'F17', 'P2', 'P3-Fin', 'Firma', 2, 12, 'AC'),
(986, 'F17', 'P3-Fin', 'Fin', 'Firma', NULL, 12, 'AC'),
(987, 'F17', '', '', '', NULL, 12, 'AC'),
(988, '', '', '', '', NULL, 12, 'AC'),
(989, 'F18', 'P1', 'P2', 'APROBACIÓN DE PERFIL DE GRADO', 7, 12, 'AC'),
(990, 'F18', 'P2', 'P3', 'Recepción de documentos y VoBo Director', 3, 12, 'AC'),
(991, 'F18', 'P3', NULL, 'Aprobación de la solicitud de Perfil de Grado', 11, 12, 'AC'),
(992, 'F18', 'P4', 'P5', 'Elaboración de Proyecto de Resolución y nota de atencion a la solicitud de Perfil de Grado', 3, 12, 'AC'),
(993, 'F18', 'P5', 'P6', 'Aprobación de la solicitud de Perfil de Grado', 2, 12, 'AC'),
(994, 'F18', 'P6', 'P7', 'Elaboración de Resolución a la solicitud de Perfil de Grado', 1, 12, 'AC'),
(995, 'F18', 'P7', 'P8-Fin', 'Recepción y entrega de Resolución de Perfil de Grado al Estudiante', 3, 12, 'AC'),
(996, 'F18', 'P8-Fin', 'P10', 'RESOLUCIÓN DE PERFIL DE GRADO', 7, 12, 'AC'),
(997, 'F18', 'P9', 'P3', 'Corrección de errores', 7, 12, 'AC'),
(998, '', '', '', '', NULL, 12, 'AC'),
(999, 'F19', 'P1', 'P2', 'DESIGNACIÓN DE TRIBUNAL REVISOR DE GRADO', 7, 12, 'AC'),
(1000, 'F19', 'P2', 'P3', 'Recepción de documentos y VoBo Director', 3, 12, 'AC'),
(1001, 'F19', 'P3', NULL, 'Aprobación del Trabajo de Grado', 11, 12, 'AC'),
(1002, 'F19', 'P4', 'P5', 'Elaboración de Proyecto de Resolución y nota de atencion a la solicitud de Designacion de Tribunal de Grado', 3, 12, 'AC'),
(1003, 'F19', 'P5', 'P6', 'Aprobación del Trabajo de Grado', 2, 12, 'AC'),
(1004, 'F19', 'P6', 'P7', 'Elaboración de Resolución de Designación de Tribunal de Grado', 1, 12, 'AC'),
(1005, 'F19', 'P7', 'P8-Fin', 'Recepción y entrega de Resolución de Tibunal de Grado al Estudiante', 3, 12, 'AC'),
(1006, 'F19', 'P8-Fin', 'P10', 'RESOLUCIÓN DE DESIGNACIÓN DE TRIBUNAL REVISOR DE GRADO', 7, 12, 'AC'),
(1007, 'F19', 'P9', 'P3', 'Corrección de errores', 7, 12, 'AC'),
(1008, '', '', '', '', NULL, 12, 'AC'),
(1009, 'F20', 'P1', 'P2', 'DESIGNACION DE RESPONSABLE DE CAJA CHICA', 3, 12, 'AC'),
(1010, 'F20', 'P2', 'P3', 'Aprueba y remite a HCF', 11, 12, 'AC'),
(1011, 'F20', 'P3', 'P4', 'Aprueba los montos y responsible de caja chica', 1, 12, 'AC'),
(1012, 'F20', 'P4', NULL, 'Revisa los documentos adjuntos y procede a la apertura', NULL, 12, 'AC'),
(1013, 'F20', 'P5-Fin', 'Fin', 'Entrega memorandum de designacion de responsible de caja chica', 3, 12, 'AC'),
(1014, 'F20', 'P6', 'P4', 'Subsana observaciones', 3, 12, 'AC'),
(1015, '', '', '', '', NULL, 12, 'AC'),
(1016, 'F21', 'P1', 'P2', 'ADMINISTRACIÓN DE CAJA CHICA', NULL, 12, 'AC'),
(1017, 'F21', 'P2', 'P3', 'Recepción de documentos', 1, 12, 'AC'),
(1018, 'F21', 'P3', NULL, 'Revision de documentos', NULL, 12, 'AC'),
(1019, 'F21', 'P4-Fin', 'Fin', 'Registro a su sistema y lo archivan', NULL, 12, 'AC'),
(1020, 'F21', 'P5', 'P3', ' Subsana observaciones', NULL, 12, 'AC'),
(1021, '', '', '', '', NULL, 12, 'AC'),
(1022, 'F22', 'P1', 'P2', 'DESIGNACIÓN DE RESPONSABLE DE FONDO ROTATORIO', 3, 12, 'AC'),
(1023, 'F22', 'P2', 'P3', 'Aprueba y remite a HCF', 11, 12, 'AC'),
(1024, 'F22', 'P3', 'P4', 'Aprueba los montos y responsible de fondo rotatorio', 1, 12, 'AC'),
(1025, 'F22', 'P4', NULL, 'Revisa los documentos adjuntos y procede a la apertura', NULL, 12, 'AC'),
(1026, 'F22', 'P5-Fin', 'Fin', 'Entrega memorandum de designacion de responsible de fondo rotatorio', 3, 12, 'AC'),
(1027, 'F22', 'P6', 'P4', 'Subsana observaciones', 3, 12, 'AC'),
(1028, '', '', '', '', NULL, 12, 'AC'),
(1029, 'F23', 'P1', 'P2', 'ADMINISTRACIÓN DE FONDO ROTATORIO  ', NULL, 12, 'AC'),
(1030, 'F23', 'P2', 'P3', 'Recepción de documentos', 1, 12, 'AC'),
(1031, 'F23', 'P3', NULL, 'Revision de documentos', NULL, 12, 'AC'),
(1032, 'F23', 'P4-Fin', 'Fin', 'Registro a su sistema y lo archivan', NULL, 12, 'AC'),
(1033, 'F23', 'P5', 'P3', 'Subsana observaciones', NULL, 12, 'AC'),
(1034, '', '', '', '', NULL, 12, 'AC'),
(1035, 'F24', 'P1', 'P2', 'CAMBIO DE MODALIDAD DE GRADUACIÓN', 7, 12, 'AC'),
(1036, 'F24', 'P2', 'P3', 'Recepción de documentos y VoBo Director', 3, 12, 'AC'),
(1037, 'F24', 'P3', NULL, 'Aprobación del Cambio de Modalidad de Graduación', 11, 12, 'AC'),
(1038, 'F24', 'P4', 'P5', 'Elaboración de Proyecto de Resolución y nota de atencion a la solicitud de Cambio de Modalidad de Graduación', 3, 12, 'AC'),
(1039, 'F24', 'P5', 'P6', 'Aprobación del Cambio de Modalidad de Graduación', 2, 12, 'AC'),
(1040, 'F24', 'P6', 'P7', 'Anular y Elaborar la Resolución de Perfil de Grado por Cambio de Modalidad de Graduación', 1, 12, 'AC'),
(1041, 'F24', 'P7', 'P8-Fin', 'Recepción y entrega de la Nueva Resolución de Perfil de Grado al Estudiante', 3, 12, 'AC'),
(1042, 'F24', 'P8-Fin', 'P10', 'CAMBIO DE MODALIDAD DE GRADUACIÓN', 7, 12, 'AC'),
(1043, 'F24', 'P9', 'P3', 'Corrección de errores', 7, 12, 'AC'),
(1044, '', '', '', '', NULL, 12, 'AC'),
(1045, 'F25', 'P1', 'P2', 'POSTGRADO APROBACIÓN DE PERFIL', NULL, 12, 'AC'),
(1046, 'F25', 'P2', 'P3', 'Recibe la solicitud y remite al HCF con Nota de Atención', 3, 12, 'AC'),
(1047, 'F25', 'P3', 'P4', 'Emite Resolución', 1, 12, 'AC'),
(1048, 'F25', 'P4', 'P5', 'Recibe y remite al Postgrado de carrera', 3, 12, 'AC'),
(1049, 'F25', 'P5', 'P6-Fin', 'Notifica la entrega de la Resolución al Postgraduante', NULL, 12, 'AC'),
(1050, 'F25', 'P6-Fin', 'Fin', 'Descarga resolución', 7, 12, 'AC'),
(1051, '', '', '', '', NULL, 12, 'AC'),
(1052, 'F26', 'P1', 'P2', 'POSTGRADO NOMBRAMIENTO DE TRIBUNAL DE TESIS', NULL, 12, 'AC'),
(1053, 'F26', 'P2', 'P3', 'Solicita a dirección de carrera la aprobación de Tribunal de Tesis', NULL, 12, 'AC'),
(1054, 'F26', 'P3', 'P4', 'Recibe la solicitud y remite al HCF con Nota de Atención', 3, 12, 'AC'),
(1055, 'F26', 'P4', 'P5', 'Aprueba y homologa la Resolución', 1, 12, 'AC'),
(1056, 'F26', 'P5', 'P6', 'Recibe y remite al Postgrado de carrera', 3, 12, 'AC'),
(1057, 'F26', 'P6', 'P7-Fin', 'Notifica a los docentes  nombrados para tribunal de la Tesis', NULL, 12, 'AC'),
(1058, 'F26', 'P7-Fin', 'Fin', 'Entrega copia de Resolucion', 7, 12, 'AC'),
(1059, '', '', '', '', NULL, 12, 'AC'),
(1060, 'F27', 'P1', 'P2', 'MAESTRIA TERMINAL - INSCRIPCIONES', NULL, 12, 'AC'),
(1061, 'F27', 'P2', NULL, 'Registro de documentos y verificación según convocatoria', 4, 12, 'AC'),
(1062, 'F27', 'P3', 'P2', 'Corrección de documentos', 7, 12, 'AC'),
(1063, 'F27', 'P4', 'P5', 'Elabora listas para habilitar los pagos de postulantes', 4, 12, 'AC'),
(1064, 'F27', 'P5', 'P6-Fin', 'Habilita acceso al sistema SIA, SSA', 4, 12, 'AC'),
(1065, 'F27', 'P6-Fin', 'Fin', 'Listas de los postulantes', 3, 12, 'AC'),
(1066, '', '', '', '', NULL, 12, 'AC'),
(1067, 'F28', 'P1', 'P2', 'MAESTRIA TERMINAL - CERTIFICADO DE CALIFICACIONES Y CONCLUSIÓN DE ESTUDIOS', NULL, 12, 'AC'),
(1068, 'F28', 'P2', 'P3', 'Llenado de certificados y Informe de conclusión de estudios', 4, 12, 'AC'),
(1069, 'F28', 'P3', 'P4', 'Firma de certificados', 3, 12, 'AC'),
(1070, 'F28', 'P4', 'P5', 'Firma de certificados', 1, 12, 'AC'),
(1071, 'F28', 'P5', 'P6-Fin', 'Recepción de certificados', 4, 12, 'AC'),
(1072, 'F28', 'P6-Fin', 'Fin', 'Descarga de certificados', 7, 12, 'AC'),
(1073, '', '', '', '', NULL, 12, 'AC'),
(1074, 'F29', 'P1', 'P2', 'MAESTRIA TERMINAL - LLENADO DE GAR  PARA DEFENSA', NULL, 12, 'AC'),
(1075, 'F29', 'P2', 'P3', 'Coordina con kardex fecha y hora de defensa', 3, 12, 'AC'),
(1076, 'F29', 'P3', 'P4-Fin', 'Firma de GAR', 1, 12, 'AC'),
(1077, 'F29', 'P4-Fin', 'Fin', 'Recive y revisa ', NULL, 12, 'AC'),
(1078, 'F29', '', '', '', NULL, 12, 'AC'),
(1079, '', '', '', '', NULL, 12, 'AC'),
(1080, 'F30', 'P1', 'P2', 'MAESTRIA TERMINAL - ELABORACIÓN DE ACTAS DE DEFENSA PARA DEFENSA DE TESIS', NULL, 12, 'AC'),
(1081, 'F30', 'P2', 'P3-Fin', 'Elabora el Acta de defensa de la Tesis y entrega a Director', 4, 12, 'AC'),
(1082, 'F30', 'P3-Fin', 'Fin', 'Se da lectura al Acta a la conclusión de la defensa', 3, 12, 'AC'),
(1083, 'F30', '', '', '', NULL, 12, 'AC'),
(1084, '', '', '', '', NULL, 12, 'AC'),
(1085, 'F31', 'P1', 'P2', 'POSTGRADO AUTOFINANCIADO - INSCRIPCIONES', NULL, 12, 'AC'),
(1086, 'F31', 'P2', NULL, 'Registro de documentos y verificación según convocatoria', 4, 12, 'AC'),
(1087, 'F31', 'P3', 'P2', 'Corrección de documentos', 7, 12, 'AC'),
(1088, 'F31', 'P4', 'P5', 'Elabora listas para habilitar los pagos de postulantes', 4, 12, 'AC'),
(1089, 'F31', 'P5', 'P6-Fin', 'Habilita acceso al sistema SIA, SSA', 4, 12, 'AC'),
(1090, 'F31', 'P6-Fin', 'Fin', 'Listas de los postulantes', 3, 12, 'AC'),
(1091, '', '', '', '', NULL, 12, 'AC'),
(1092, 'F32', 'P1', 'P2', 'POSTGRADO AUTOFINANCIADO - CERTIFICADO DE CALIFICACIONES Y CONCLUSIÓN DE ESTUDIOS', NULL, 12, 'AC'),
(1093, 'F32', 'P2', 'P3', 'Llenado de certificados y Informe de conclusión de estudios', 4, 12, 'AC'),
(1094, 'F32', 'P3', 'P4', 'Firma de certificados', 3, 12, 'AC'),
(1095, 'F32', 'P4', 'P5', 'Firma de certificados', 1, 12, 'AC'),
(1096, 'F32', 'P5', 'P6-Fin', 'Recepción de certificados', 4, 12, 'AC'),
(1097, 'F32', 'P6-Fin', 'Fin', 'Descarga de certificados', 7, 12, 'AC'),
(1098, '', '', '', '', NULL, 12, 'AC'),
(1099, 'F33', 'P1', 'P2', 'POSTGRADO AUTOFINANCIADO - LLENADO DE GAR  PARA DEFENSA', NULL, 12, 'AC'),
(1100, 'F33', 'P2', 'P3', 'Coordina con kardex fecha y hora de defensa', 3, 12, 'AC'),
(1101, 'F33', 'P3', 'P4-Fin', 'Firma de GAR', 1, 12, 'AC'),
(1102, 'F33', 'P4-Fin', 'Fin', 'Recive y revisa ', NULL, 12, 'AC'),
(1103, 'F33', '', '', '', NULL, 12, 'AC'),
(1104, '', '', '', '', NULL, 12, 'AC'),
(1105, 'F34', 'P1', 'P2', 'POSTGRADO AUTOFINANCIADO - ELABORACIÓN DE ACTAS DE DEFENSA PARA DEFENSA DE TESIS', NULL, 12, 'AC'),
(1106, 'F34', 'P2', 'P3-Fin', 'Elabora el Acta de defensa de la Tesis y entrega a Director', 4, 12, 'AC'),
(1107, 'F34', 'P3-Fin', 'Fin', 'Se da lectura al Acta a la conclusión de la defensa', 3, 12, 'AC'),
(1108, 'F34', '', '', '', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materia_extra`
--

CREATE TABLE `materia_extra` (
  `id` int(11) NOT NULL,
  `c_aval` varchar(255) DEFAULT NULL,
  `cif` bigint(20) DEFAULT NULL,
  `d_aval` varchar(255) DEFAULT NULL,
  `d_respaldo` varchar(255) DEFAULT NULL,
  `d_solicitud` varchar(255) DEFAULT NULL,
  `r_respaldo` varchar(255) DEFAULT NULL,
  `r_solicitud` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `tramite_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `procesocond`
--

CREATE TABLE `procesocond` (
  `id` int(11) NOT NULL,
  `flujo` varchar(255) DEFAULT NULL,
  `proceso` varchar(255) DEFAULT NULL,
  `si` varchar(255) DEFAULT NULL,
  `no` varchar(255) DEFAULT NULL,
  `flujo_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `procesocond`
--

INSERT INTO `procesocond` (`id`, `flujo`, `proceso`, `si`, `no`, `flujo_id`) VALUES
(1, 'F1', 'P3', 'P4', 'P9', NULL),
(2, 'F2', 'P3', 'P4', 'P7', NULL),
(3, 'F3', 'P3', 'P4', 'P10', NULL),
(4, 'F3', 'P5', 'P6', 'P4', NULL),
(5, 'F4', 'P3', 'P4', 'P11', NULL),
(6, 'F4', 'P7', 'P8', 'P6', NULL),
(7, 'F5', 'P2', 'P3', 'P8', NULL),
(8, 'F8', 'P4', 'P5', 'P3', NULL),
(9, 'F8', 'P7', 'P8', 'P3', NULL),
(10, 'F10', 'P4', 'P5', 'P3', NULL),
(11, 'F11', 'P2', 'P3', 'P1', NULL),
(12, 'F15', 'P4', 'P5', 'P3', NULL),
(13, 'F15', 'P7', 'P8', 'P3', NULL),
(14, 'F16', 'P4', 'P5', 'Fin', NULL),
(15, 'F16', 'P6', 'P7', 'P5', NULL),
(16, 'F18', 'P3', 'P4', 'P9', NULL),
(17, 'F19', 'P3', 'P4', 'P9', NULL),
(18, 'F20', 'P4', 'P5-Fin', 'P6', NULL),
(19, 'F21', 'P3', 'P4-Fin', 'P5', NULL),
(20, 'F22', 'P4', 'P5-Fin', 'P6', NULL),
(21, 'F23', 'P3', 'P4-Fin', 'P5', NULL),
(22, 'F24', 'P3', 'P4', 'P9', NULL),
(23, 'F27', 'P2', 'P4', 'P3', NULL),
(24, 'F31', 'P2', 'P4', 'P3', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(250) DEFAULT NULL,
  `codigo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `role`
--

INSERT INTO `role` (`id`, `name`, `codigo`) VALUES
(1, 'DECANATO', 'DC'),
(2, 'VICEDECANATO', 'VDC'),
(3, 'DIRECCION', 'DIR'),
(4, 'KARDEX', 'RA'),
(5, 'HCF', NULL),
(6, 'DOCENTE', 'DC'),
(7, 'ESTUDIANTE', 'ES'),
(10, 'COMISION_CONVALIDACION', NULL),
(11, 'CONSEJO_CARRERA', 'CC'),
(12, 'ADMINISTRADOR', NULL),
(13, 'VICERRECTORADO', NULL),
(14, 'PERSONAL_DOCENTE', 'PD');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seguimiento`
--

CREATE TABLE `seguimiento` (
  `id` int(11) NOT NULL,
  `tramite_id` varchar(255) DEFAULT NULL,
  `flujo` varchar(255) DEFAULT NULL,
  `proceso` varchar(255) DEFAULT NULL,
  `fecha_fin` datetime(6) DEFAULT NULL,
  `fecha_inicio` datetime(6) DEFAULT NULL,
  `carrera` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `activo` varchar(6) DEFAULT 'true',
  `comentario` varchar(255) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `tiempo` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tramite`
--

CREATE TABLE `tramite` (
  `id` varchar(255) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `flujo` varchar(255) DEFAULT NULL,
  `proceso` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `carrera` varchar(255) DEFAULT NULL,
  `estado` varchar(50) DEFAULT 'pendiente',
  `creacion` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Disparadores `tramite`
--
DELIMITER $$
CREATE TRIGGER `generate_tramite_id` BEFORE INSERT ON `tramite` FOR EACH ROW BEGIN
    DECLARE new_numero INT;
    DECLARE new_categoria VARCHAR(50);
    DECLARE new_rol VARCHAR(20);

    -- Obtener la categoría desde la tabla FLUJO
    SELECT categoria_id INTO new_categoria FROM flujo WHERE flujo = NEW.flujo LIMIT 1;

     -- Obtener el siguiente número correlativo para la carrera
    SELECT secuencia + 1 INTO new_numero FROM unidad WHERE id = NEW.carrera;

    -- Actualizar la secuencia en la tabla UNIDAD
    UPDATE unidad SET secuencia = new_numero WHERE id = NEW.carrera;

    -- Obtener el rol del usuario desde las tablas user_role y role
    SELECT r.codigo INTO new_rol
    FROM user_role ur
    JOIN role r ON ur.role_id = r.id
    WHERE ur.user_id = NEW.user_id
    LIMIT 1;

    -- Construir el nuevo ID
    SET NEW.id = CONCAT(new_categoria, '-', NEW.carrera, '-', new_numero, '-', new_rol);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `unidad`
--

CREATE TABLE `unidad` (
  `id` varchar(255) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `secuencia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `unidad`
--

INSERT INTO `unidad` (`id`, `nombre`, `secuencia`) VALUES
('CED', 'CIENCIAS EDUCACION', 0),
('CIN', 'CIENCIAS INFORMACION', 0),
('CN', 'CINE', 0),
('FHCE', 'FACULTATIVO', 0),
('FIL', 'FILOSOFIA', 1),
('HIS', 'HISTORIA', 0),
('LIN', 'LINGUISTICA', 0),
('LIT', 'LITERATURA', 0),
('PSI', 'PSICOLOGIA', 11),
('TUR', 'TURISMO', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `cif` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `password`, `username`, `cif`) VALUES
(1, '$2a$10$Oi68QjMLGMWIjaxhBO3KxOECc.f9xKllIg0xCxyfNfsxMgxOYrS2G', 'decanato', '22205200200'),
(2, '$2a$10$Yw.03AgAHS7qObelG3.adedve/VXDtLke0aOOlYD/awxF7kfD3j2G', 'vicedecanato', '22205200201'),
(3, '$2a$10$tLtFHMGuzKEvZmUzjRXKbuzUAd7dqs0Sa35tDERm5bIJNzq8jHJvi', 'direccion', NULL),
(4, '$2a$10$LGA9qy2LQCKpDlLYuTk00uX4WoV1o6lFPKCYxV8TyG7EtIpEM0.Ue', 'kardex', NULL),
(5, '$2a$10$7DaRIiPPO8PWEXlWkU92X.aAws1TAe/InMg6tndSK04PQlRfTDOPO', 'hcf', NULL),
(7, '$2a$10$qVjwTo0DNxV3/tzUgwsGgeNsvzgzoHMuP1joaMtEAbM/ZaWCl3Eai', 'estudiante1', NULL),
(8, '$2a$10$rCggV2vGw1.DtqUND9y.fOBr3J4m0jajQP5p9LhwkgvuKh0p87nKe', 'estudiante2', NULL),
(13, '$2a$10$0.E8FUfb.zqUK4vRNvaeX.T4cN6j5HWOgDGs.ckG3MCSUF7cHrx8q', 'comision', NULL),
(14, '$2a$10$0.E8FUfb.zqUK4vRNvaeX.T4cN6j5HWOgDGs.ckG3MCSUF7cHrx8q', 'consejocarrera', NULL),
(15, '$2a$10$0.E8FUfb.zqUK4vRNvaeX.T4cN6j5HWOgDGs.ckG3MCSUF7cHrx8q', 'kardexHis', NULL),
(16, '$2a$10$0.E8FUfb.zqUK4vRNvaeX.T4cN6j5HWOgDGs.ckG3MCSUF7cHrx8q', 'admin', NULL),
(17, '$2a$10$0.E8FUfb.zqUK4vRNvaeX.T4cN6j5HWOgDGs.ckG3MCSUF7cHrx8q', 'vicerrectorado', NULL),
(23, '$2a$10$PuhZDTAarRat9Qc4rHywRObUJhKLWG1IPxtlFgvlGFN/W.IOMbj0a', 'abraham', '22205200202'),
(25, '$2a$10$XGYkQNpZvq3ee9BIOEKEi.QglqjIpV9mBEf75LpkYZcRtmxWARL0m', 'docente', '22409200800'),
(26, '$2a$10$kz5Ed/EgLi0V7c1bXfolgeLq5eH8oYx5AQMQYK.8wBMTir15bgvc6', 'personaldocente', '22409200801');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user_role`
--

CREATE TABLE `user_role` (
  `id` int(11) NOT NULL,
  `role_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `unidad_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `user_role`
--

INSERT INTO `user_role` (`id`, `role_id`, `user_id`, `unidad_id`) VALUES
(1, 1, 1, 'FHCE'),
(2, 2, 2, 'FHCE'),
(3, 3, 3, 'PSI'),
(4, 4, 4, 'PSI'),
(6, 7, 7, 'FIL'),
(7, 7, 8, 'PSI'),
(8, 5, 5, 'PSI'),
(9, 10, 13, 'PSI'),
(10, 11, 14, 'PSI'),
(11, 4, 15, 'HIS'),
(12, 12, 16, 'FHCE'),
(13, 13, 17, 'FHCE'),
(16, 7, 23, 'HIS'),
(18, 6, 25, 'PSI'),
(19, 14, 26, 'FHCE');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumno_libre`
--
ALTER TABLE `alumno_libre`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK2e6vxwdr4xn6fhae9yba75eya` (`tramite_id`);

--
-- Indices de la tabla `aprobacion_perfil`
--
ALTER TABLE `aprobacion_perfil`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKgithrelj07f6jqt32v08yi26j` (`tramite_id`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `certificado_conclusion`
--
ALTER TABLE `certificado_conclusion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKoopqyqi52iwb3dmifrjioeg3u` (`tramite_id`);

--
-- Indices de la tabla `certificado_unico`
--
ALTER TABLE `certificado_unico`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKbwayi0glvke7v0n0n8p33s072` (`tramite_id`);

--
-- Indices de la tabla `concurso_doc_interinos`
--
ALTER TABLE `concurso_doc_interinos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3lumgufapjd81c0ouamsdq36n` (`tramite_id`);

--
-- Indices de la tabla `convalidacion_01`
--
ALTER TABLE `convalidacion_01`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKpaiy29jloos8dovnrg54802pr` (`tramite_id`);

--
-- Indices de la tabla `convalidacion_02`
--
ALTER TABLE `convalidacion_02`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKabocb17afmjeyqh6x00sbf21n` (`tramite_id`);

--
-- Indices de la tabla `convocatoria`
--
ALTER TABLE `convocatoria`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK9f4hycnf4d4lrgrjvsrqeft7l` (`tramite_id`);

--
-- Indices de la tabla `designacion_doc_interinos`
--
ALTER TABLE `designacion_doc_interinos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKa62gkjl85lrf3moqvwkpkxeju` (`tramite_id`);

--
-- Indices de la tabla `designacion_tribunal`
--
ALTER TABLE `designacion_tribunal`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKwyenk2vfyx5yv1crsjldvjm0` (`aprobacion_perfil_id`),
  ADD KEY `FK8j80bx8p4dopl2idfrdpq0jtv` (`tramite_id`);

--
-- Indices de la tabla `flujo`
--
ALTER TABLE `flujo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKhv71llqfjqtg38cwhi5w7yypr` (`role_id`),
  ADD KEY `FKgepa53lh0p2y3c4a2m5cn1ri` (`categoria_id`);

--
-- Indices de la tabla `materia_extra`
--
ALTER TABLE `materia_extra`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3e70jaq9nxb3a0ku0u3n88ik2` (`tramite_id`);

--
-- Indices de la tabla `procesocond`
--
ALTER TABLE `procesocond`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK6l54v1q5j7j52ht6mxd92o1bg` (`flujo_id`);

--
-- Indices de la tabla `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `seguimiento`
--
ALTER TABLE `seguimiento`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKbvi7cvnu273yleyo6mx0f755l` (`role_id`),
  ADD KEY `FK6mfsaf4u29gkqttjaqdapgx49` (`user_id`),
  ADD KEY `FKrad87cfwfv0v2irva16p2u401` (`tramite_id`);

--
-- Indices de la tabla `tramite`
--
ALTER TABLE `tramite`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `unidad`
--
ALTER TABLE `unidad`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKsb8bbouer5wak8vyiiy4pf2bx` (`username`);

--
-- Indices de la tabla `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  ADD KEY `FK859n2jvi8ivhui0rl0esws6o` (`user_id`),
  ADD KEY `FK68tt9hxk8ogvuuyqg87q473sv` (`unidad_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumno_libre`
--
ALTER TABLE `alumno_libre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `aprobacion_perfil`
--
ALTER TABLE `aprobacion_perfil`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `certificado_conclusion`
--
ALTER TABLE `certificado_conclusion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `certificado_unico`
--
ALTER TABLE `certificado_unico`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `concurso_doc_interinos`
--
ALTER TABLE `concurso_doc_interinos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `convalidacion_01`
--
ALTER TABLE `convalidacion_01`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `convalidacion_02`
--
ALTER TABLE `convalidacion_02`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `convocatoria`
--
ALTER TABLE `convocatoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `designacion_doc_interinos`
--
ALTER TABLE `designacion_doc_interinos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `designacion_tribunal`
--
ALTER TABLE `designacion_tribunal`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `flujo`
--
ALTER TABLE `flujo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1109;

--
-- AUTO_INCREMENT de la tabla `materia_extra`
--
ALTER TABLE `materia_extra`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `procesocond`
--
ALTER TABLE `procesocond`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de la tabla `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `seguimiento`
--
ALTER TABLE `seguimiento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT de la tabla `user_role`
--
ALTER TABLE `user_role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alumno_libre`
--
ALTER TABLE `alumno_libre`
  ADD CONSTRAINT `FK2e6vxwdr4xn6fhae9yba75eya` FOREIGN KEY (`tramite_id`) REFERENCES `tramite` (`id`);

--
-- Filtros para la tabla `aprobacion_perfil`
--
ALTER TABLE `aprobacion_perfil`
  ADD CONSTRAINT `FKgithrelj07f6jqt32v08yi26j` FOREIGN KEY (`tramite_id`) REFERENCES `tramite` (`id`);

--
-- Filtros para la tabla `certificado_conclusion`
--
ALTER TABLE `certificado_conclusion`
  ADD CONSTRAINT `FKoopqyqi52iwb3dmifrjioeg3u` FOREIGN KEY (`tramite_id`) REFERENCES `tramite` (`id`);

--
-- Filtros para la tabla `certificado_unico`
--
ALTER TABLE `certificado_unico`
  ADD CONSTRAINT `FKbwayi0glvke7v0n0n8p33s072` FOREIGN KEY (`tramite_id`) REFERENCES `tramite` (`id`);

--
-- Filtros para la tabla `concurso_doc_interinos`
--
ALTER TABLE `concurso_doc_interinos`
  ADD CONSTRAINT `FK3lumgufapjd81c0ouamsdq36n` FOREIGN KEY (`tramite_id`) REFERENCES `tramite` (`id`);

--
-- Filtros para la tabla `convalidacion_01`
--
ALTER TABLE `convalidacion_01`
  ADD CONSTRAINT `FKpaiy29jloos8dovnrg54802pr` FOREIGN KEY (`tramite_id`) REFERENCES `tramite` (`id`);

--
-- Filtros para la tabla `convalidacion_02`
--
ALTER TABLE `convalidacion_02`
  ADD CONSTRAINT `FKabocb17afmjeyqh6x00sbf21n` FOREIGN KEY (`tramite_id`) REFERENCES `tramite` (`id`);

--
-- Filtros para la tabla `convocatoria`
--
ALTER TABLE `convocatoria`
  ADD CONSTRAINT `FK9f4hycnf4d4lrgrjvsrqeft7l` FOREIGN KEY (`tramite_id`) REFERENCES `tramite` (`id`);

--
-- Filtros para la tabla `designacion_doc_interinos`
--
ALTER TABLE `designacion_doc_interinos`
  ADD CONSTRAINT `FKa62gkjl85lrf3moqvwkpkxeju` FOREIGN KEY (`tramite_id`) REFERENCES `tramite` (`id`);

--
-- Filtros para la tabla `designacion_tribunal`
--
ALTER TABLE `designacion_tribunal`
  ADD CONSTRAINT `FK8j80bx8p4dopl2idfrdpq0jtv` FOREIGN KEY (`tramite_id`) REFERENCES `tramite` (`id`),
  ADD CONSTRAINT `FKwyenk2vfyx5yv1crsjldvjm0` FOREIGN KEY (`aprobacion_perfil_id`) REFERENCES `aprobacion_perfil` (`id`);

--
-- Filtros para la tabla `flujo`
--
ALTER TABLE `flujo`
  ADD CONSTRAINT `FKgepa53lh0p2y3c4a2m5cn1ri` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`),
  ADD CONSTRAINT `FKhv71llqfjqtg38cwhi5w7yypr` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);

--
-- Filtros para la tabla `materia_extra`
--
ALTER TABLE `materia_extra`
  ADD CONSTRAINT `FK3e70jaq9nxb3a0ku0u3n88ik2` FOREIGN KEY (`tramite_id`) REFERENCES `tramite` (`id`);

--
-- Filtros para la tabla `procesocond`
--
ALTER TABLE `procesocond`
  ADD CONSTRAINT `FK6l54v1q5j7j52ht6mxd92o1bg` FOREIGN KEY (`flujo_id`) REFERENCES `flujo` (`id`);

--
-- Filtros para la tabla `seguimiento`
--
ALTER TABLE `seguimiento`
  ADD CONSTRAINT `FK6mfsaf4u29gkqttjaqdapgx49` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKbvi7cvnu273yleyo6mx0f755l` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  ADD CONSTRAINT `FKrad87cfwfv0v2irva16p2u401` FOREIGN KEY (`tramite_id`) REFERENCES `tramite` (`id`);

--
-- Filtros para la tabla `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FK68tt9hxk8ogvuuyqg87q473sv` FOREIGN KEY (`unidad_id`) REFERENCES `unidad` (`id`),
  ADD CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);

DELIMITER $$
--
-- Eventos
--
CREATE DEFINER=`root`@`localhost` EVENT `updateTramiteStatus` ON SCHEDULE EVERY 1 SECOND STARTS '2024-05-15 21:55:17' ON COMPLETION NOT PRESERVE ENABLE DO BEGIN
    -- Decrementar el tiempo en la columna fecha_hora
    UPDATE seguimiento
    SET tiempo = DATE_SUB(tiempo, INTERVAL 1 SECOND)
    WHERE estado = 'pendiente' AND tiempo > CURRENT_TIMESTAMP;

    -- Actualizar estado y fecha fin cuando el tiempo se agote
    UPDATE seguimiento
    SET estado = 'fuera de plazo', fecha_fin = CURRENT_TIMESTAMP
    WHERE estado = 'pendiente' AND tiempo <= CURRENT_TIMESTAMP;

    -- Identificar los trámites asociados a seguimientos fuera de plazo
    UPDATE tramite t
    SET estado = 'fuera de plazo'
    WHERE t.id IN (
        -- Subconsulta para obtener los trámites asociados a seguimientos fuera de plazo
        SELECT DISTINCT s.tramite_id
        FROM seguimiento s
        WHERE s.estado = 'fuera de plazo'
    );
END$$

DELIMITER ;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
