-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-06-2024 a las 05:57:42
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

--
-- Volcado de datos para la tabla `alumno_libre`
--

INSERT INTO `alumno_libre` (`id`, `cif`, `d_respaldo`, `d_solicitud`, `r_respaldo`, `r_solicitud`, `user_id`, `tramite_id`, `d_proy_resolucion`, `r_proy_resolucion`, `d_resolucion`, `c_proy_resolucion`, `c_resolucion`) VALUES
(1, NULL, 'respaldo.pdf', 'solicitud.pdf', 'correcto', 'correcto', 7, 'AC-FIL-16-ES', 'proy_resolucion.pdf', NULL, 'resolucion.pdf', '1GMWtEsNoxwRq6hJSVgTFo351rnUthFkl', '11JEI9Fi2AejQxDAFr32qDPAxYsZDCqj8');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aprobacion_perfil`
--

CREATE TABLE `aprobacion_perfil` (
  `id` int(11) NOT NULL,
  `tramite_id` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `cif` bigint(20) DEFAULT NULL,
  `modalidad` varchar(255) DEFAULT NULL,
  `c_proyecto_resolucion_perfil` varchar(255) DEFAULT NULL,
  `c_resolucion_perfil` varchar(255) DEFAULT NULL,
  `c_solicitud_aprobacion_perfil` varchar(255) DEFAULT NULL,
  `d_conclusion_estudios` varchar(255) DEFAULT NULL,
  `d_nota_director` varchar(255) DEFAULT NULL,
  `d_nota_tutor` varchar(255) DEFAULT NULL,
  `d_perfil_grado` varchar(255) DEFAULT NULL,
  `d_proyecto_resolucion_perfil` varchar(255) DEFAULT NULL,
  `d_record_academico` varchar(255) DEFAULT NULL,
  `d_resolucion_perfil` varchar(255) DEFAULT NULL,
  `d_solicitud_aprobacion_perfil` varchar(255) DEFAULT NULL,
  `d_carta_institucion` varchar(255) DEFAULT NULL,
  `r_carta_institucion` varchar(255) DEFAULT NULL,
  `r_conclusion_estudios` varchar(255) DEFAULT NULL,
  `r_nota_director` varchar(255) DEFAULT NULL,
  `r_nota_tutor` varchar(255) DEFAULT NULL,
  `r_perfil_grado` varchar(255) DEFAULT NULL,
  `r_record_academico` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `aprobacion_perfil`
--

INSERT INTO `aprobacion_perfil` (`id`, `tramite_id`, `user_id`, `cif`, `modalidad`, `c_proyecto_resolucion_perfil`, `c_resolucion_perfil`, `c_solicitud_aprobacion_perfil`, `d_conclusion_estudios`, `d_nota_director`, `d_nota_tutor`, `d_perfil_grado`, `d_proyecto_resolucion_perfil`, `d_record_academico`, `d_resolucion_perfil`, `d_solicitud_aprobacion_perfil`, `d_carta_institucion`, `r_carta_institucion`, `r_conclusion_estudios`, `r_nota_director`, `r_nota_tutor`, `r_perfil_grado`, `r_record_academico`) VALUES
(5, 'AC-FIL-14-ES', 7, NULL, 'Tesis', '1FZnW0el7pMTLaIyC_j_DS35exyxrewFt', '1Ps-i4j5b178FihID7c8mpaHtYJG22j_D', NULL, 'conclusion_estudios.pdf', 'nota_director.pdf', 'nota_tutor.pdf', 'perfil_grado.pdf', 'proyecto_resolucion_perfil.pdf', 'record_academico.pdf', 'resolucion_perfil.pdf', NULL, NULL, NULL, 'correcto', 'correcto', 'correcto', 'correcto', 'correcto');

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

--
-- Volcado de datos para la tabla `certificado_conclusion`
--

INSERT INTO `certificado_conclusion` (`id`, `c_certificado_conclusion`, `cif`, `d_cedula_identidad`, `d_certificado_unico`, `d_certificado_conclusion`, `d_valorada`, `user_id`, `tramite_id`) VALUES
(1, '1QyYvpgmD8-S9RMgqHfAse-oNqBAys-cz', NULL, 'cedula_identidad.pdf', 'certificado_unico.pdf', 'certificado_conclusion.pdf', 'valorada.pdf', 7, 'AC-FIL-21-ES');

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

--
-- Volcado de datos para la tabla `certificado_unico`
--

INSERT INTO `certificado_unico` (`id`, `cif`, `d_cedula_identidad`, `d_certificado_unico`, `d_valorada`, `user_id`, `tramite_id`, `c_certificado_unico`) VALUES
(1, NULL, 'cedula_identidad.pdf', 'certificado_unico.pdf', 'valorada.pdf', 7, 'AC-FIL-20-ES', '1uznv60VR56FUmj8ORfGqVlu9Vda6ZT9g');

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

--
-- Volcado de datos para la tabla `convalidacion_01`
--

INSERT INTO `convalidacion_01` (`id`, `cif`, `d_cedula_identidad`, `d_nota_director`, `d_record_academico`, `r_cedula_identidad`, `r_nota_director`, `r_record_academico`, `user_id`, `tramite_id`, `c_informe_convalidacion`, `d_informe_convalidacion`, `r_informe_convalidacion`) VALUES
(1, NULL, 'cedula_identidad.pdf', 'nota_director.pdf', 'record_academico.pdf', 'correcto', 'correcto', 'correcto', 7, 'AC-FIL-18-ES', '1tz9YJhi3YjqhJJJ8i5p94wd62AhHEvL6', 'informe_convalidacion.pdf', 'correcto');

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

--
-- Volcado de datos para la tabla `convalidacion_02`
--

INSERT INTO `convalidacion_02` (`id`, `c_informe_convalidacion`, `c_proy_resolucion`, `c_resolucion`, `cif`, `d_cedula_identidad`, `d_contenidos_analiticos`, `d_formulario_convalidacion`, `d_informe_convalidacion`, `d_nota_director`, `d_proy_resolucion`, `d_record_academico_carrera_origen`, `d_resolucion`, `r_cedula_identidad`, `r_contenidos_analiticos`, `r_formulario_convalidacion`, `r_nota_director`, `r_proy_resolucion`, `r_record_academico_carrera_origen`, `user_id`, `tramite_id`, `r_informe_convalidacion`) VALUES
(1, '1uWYqlClr-j7xazsZVpwBsRoP4RrhHnF9', '1Jon5zKt0gXyKYDZJJINH6qXC7zeWAlnx', '19JPljLF4SjDzp6IweNkdpJWRGnvQ5q2k', NULL, 'cedula_identidad.pdf', 'contenidos_analiticos.pdf', 'formulario_convalidacion.pdf', 'informe_convalidacion.pdf', 'nota_director.pdf', 'proy_resolucion.pdf', 'record_academico_carrera_origen.pdf', 'resolucion.pdf', 'correcto', 'correcto', 'correcto', 'correcto', 'correcto', 'correcto', 7, 'AC-FIL-19-ES', 'correcto');

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
  `tipo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `convocatoria`
--

INSERT INTO `convocatoria` (`id`, `tramite_id`, `user_id`, `cif`, `d_convocatoria`, `r_convocatoria`, `c_convocatoria`, `d_nota_atencion`, `c_nota_atencion`, `tipo`) VALUES
(3, 'AC-FIL-15-DIR', 3, NULL, 'convocatoria.pdf', 'correcto', '160HR5PbAYkiIY_QXZ3yMNUByzBnTHZ9f', 'nota_atencion.pdf', '1fRk3ZhjeRf39I3YlBHZ-Y01pspn8klv6', 'DOCENTE(S) INVESTIGADOR(ES) INTERINO(S)');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `designacion_tribunal`
--

CREATE TABLE `designacion_tribunal` (
  `id` int(11) NOT NULL,
  `tramite_id` varchar(255) DEFAULT NULL,
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
  `r_trabajo_grado` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `designacion_tribunal`
--

INSERT INTO `designacion_tribunal` (`id`, `tramite_id`, `user_id`, `cif`, `c_proyecto_resolucion_tribunal`, `c_resolucion_tribunal`, `d_carta_conclusion_institucion`, `d_nota_suficiencia_tutor`, `d_proyecto_resolucion_tribunal`, `d_resolucion_tribunal`, `d_trabajo_grado`, `r_carta_conclusion_institucion`, `r_nota_suficiencia_tutor`, `r_trabajo_grado`) VALUES
(1, 'AC-FIL-14-ES', 7, NULL, '1T-u0Gs-CiB8ZjE2KisXhs7oJlrCtq6VJ', '1ERQlmdoVlfb6ci9qjemGd7TirqrWQPGt', NULL, 'nota_suficiencia_tutor.pdf', 'proyecto_resolucion_tribunal.pdf', 'resolucion_tribunal.pdf', 'trabajo_grado.pdf', NULL, NULL, NULL);

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
(1, 'F1', 'P1', 'P2', 'INSCRIPCIONES DE ASIGNATURAS DE ALUMNOS LIBRES', 7, 12, 'AC'),
(2, 'F1', 'P2', 'P3', 'Deriva a URAF para la revisión y verificación', 3, 12, 'AC'),
(3, 'F1', 'P3', NULL, 'Verificación de documentos', 4, 12, 'AC'),
(4, 'F1', 'P4', 'P5', 'Recepción de documentos', 3, 12, 'AC'),
(5, 'F1', 'P5', 'P6', 'Revisa y aprueba, se envia al HCF', 11, 12, 'AC'),
(6, 'F1', 'P6', 'P7', ' Emisión de la Resolución de alumno libre', 1, 12, 'AC'),
(7, 'F1', 'P7', 'P8-Fin', 'Recibe resolución de alumno libre', 3, 12, 'AC'),
(8, 'F1', 'P8-Fin', 'Fin', 'RESOLUCION DE ALUMNO LIBRE', 7, 12, 'AC'),
(9, 'F1', 'P9', 'P3', 'Observado y corregir', 7, 12, 'AC'),
(10, '', '', '', '', NULL, NULL, NULL),
(11, 'F2', 'P1', 'P2', 'INSCRIPCIÓN DE MATERIAS EXTRA', 7, 12, 'AC'),
(12, 'F2', 'P2', 'P3', 'Deriva a URAF para la revisión y verificación', 3, 12, 'AC'),
(13, 'F2', 'P3', NULL, ' Verificación de prerrequisitos', 4, 12, 'AC'),
(14, 'F2', 'P4', 'P5', ' Emite aval para tomar materias extra', 11, 12, 'AC'),
(15, 'F2', 'P5', 'P6-Fin', 'Notifica y comunica al estudiante', 3, 12, 'AC'),
(16, 'F2', 'P6-Fin', 'Fin', 'INSCRIPCIÓN DE MATERIAS EXTRA', 7, 12, 'AC'),
(17, 'F2', 'P7', 'P3', 'Observado y corregir', 7, 12, 'AC'),
(18, '', '', '', '', NULL, NULL, NULL),
(19, 'F3', 'P1', 'P2', 'CONVALIDACIÓN DE MATERIAS DE PLAN A PLAN', 7, 12, 'AC'),
(20, 'F3', 'P2', 'P3', 'Remite a URAF para su verificacion', 3, 12, 'AC'),
(21, 'F3', 'P3', NULL, 'Validación de documentos', 4, 12, 'AC'),
(22, 'F3', 'P4', 'P5', 'Verifica las materias que se pueden convalidar', 4, 12, 'AC'),
(23, 'F3', 'P5', NULL, 'Revisión de Informe', 3, 12, 'AC'),
(24, 'F3', 'P6', 'P7', 'Firma informe de convalidación', 3, 12, 'AC'),
(25, 'F3', 'P7', 'P8', 'Firma informe de convalidación', 2, 12, 'AC'),
(26, 'F3', 'P8', 'P9-Fin', 'Revisión de firmas y migración de datos al sistema SSA', 4, 12, 'AC'),
(27, 'F3', 'P9-Fin', 'Fin', 'CONVALIDACIÓN DE MATERIAS DE PLAN A PLAN', 7, 12, 'AC'),
(28, 'F3', 'P10', 'P3', 'Correccion de errores', 7, 12, 'AC'),
(29, '', '', '', '', NULL, 12, 'AC'),
(30, 'F4', 'P1', 'P2', 'CONVALIDACIÓN  DE MATERIAS DE OTRAS CARRERAS', 7, 12, 'AC'),
(31, 'F4', 'P2', 'P3', 'Recepción y remite a URAF para su verificación', 3, 12, 'AC'),
(32, 'F4', 'P3', NULL, 'Validación de documentos', 4, 12, 'AC'),
(33, 'F4', 'P4', 'P5', 'Validado por Kardex', 3, 12, 'AC'),
(34, 'F4', 'P5', 'P6', 'Revision de documentos', 10, 12, 'AC'),
(35, 'F4', 'P6', 'P7', 'Elaboración de proyecto de resolución', 3, 12, 'AC'),
(36, 'F4', 'P7', NULL, 'Revisa y aprueba la resolucion', 11, 12, 'AC'),
(37, 'F4', 'P8', 'P9', 'Elaboración de Resolución de Convalidación', 1, 12, 'AC'),
(38, 'F4', 'P9', 'P10-Fin', 'Recepción de Resolución de Convalidación', 3, 12, 'AC'),
(39, 'F4', 'P10-Fin', 'Fin', 'CONVALIDACIÓN  DE MATERIAS DE OTRAS CARRERAS', 7, 12, 'AC'),
(40, 'F4', 'P11', 'P3', 'Corrección de errores', 7, 12, 'AC'),
(41, '', '', '', '', NULL, 12, 'AC'),
(42, 'F5', 'P1', 'P2', 'CERTIFICADO ÚNICO DE CALIFICACIONES', 7, 12, 'AC'),
(43, 'F5', 'P2', 'P3', 'Llenado del Certificado', 4, 12, 'AC'),
(44, 'F5', 'P3', 'P4', 'Firma el Certificado', 3, 12, 'AC'),
(45, 'F5', 'P4', 'P5', 'Firma el Certificado', 1, 12, 'AC'),
(46, 'F5', 'P5', 'P6-Fin', 'Verificación de firmas', 4, 12, 'AC'),
(47, 'F5', 'P6-Fin', 'Fin', 'CERTIFICADO ÚNICO DE CALIFICACIONES', 7, 12, 'AC'),
(48, '', '', '', '', NULL, 12, 'AC'),
(49, 'F6', 'P1', 'P2', 'CERTIFICADO DE CONCLUSIÓN DE ESTUDIOS', 7, 12, 'AC'),
(50, 'F6', 'P2', 'P3', 'Validación de documentos', 4, 12, 'AC'),
(51, 'F6', 'P3', 'P4', 'Firma el Certificado', 3, 12, 'AC'),
(52, 'F6', 'P4', 'P5', 'Firma el Certificado', 1, 12, 'AC'),
(53, 'F6', 'P5', 'P6-Fin', 'Recepción de informe', 4, 12, 'AC'),
(54, 'F6', 'P6-Fin', 'Fin', 'CERTIFICADO DE CONCLUSIÓN DE ESTUDIOS', 7, 12, 'AC'),
(55, 'F6', NULL, NULL, '', NULL, 12, 'AC'),
(56, 'F6', NULL, NULL, NULL, NULL, 12, 'AC'),
(57, '', '', '', '', NULL, 12, 'AC'),
(58, 'F7', 'P1', 'P2', 'LLENADO DE GAR  PARA DEFENSA (Gestiones Deriva a dirección)', NULL, 12, 'AC'),
(59, 'F7', 'P2', 'P3', 'Coordina con URAF fecha y hora de defensa', 3, 12, 'AC'),
(60, 'F7', 'P3', 'P4', ' Firma de GAR', 1, 12, 'AC'),
(61, 'F7', 'P4', 'P5-Fin', 'Notificacion pago de valores derecho defensa', 7, 12, 'AC'),
(62, 'F7', 'P5-Fin', 'Fin', 'Gestiones Recive y revisa', NULL, 12, 'AC'),
(63, '', '', '', '', NULL, 12, 'AC'),
(64, 'F8', 'P1', 'P2', 'CONVOCATORIA DE CONCURSO DE MERITOS PARA DOCENTES INTERINOS', 3, 12, 'AC'),
(65, 'F8', 'P2', NULL, 'Aprueba la emisión de convocatoria', 11, 12, 'AC'),
(66, 'F8', 'P3', 'P4', 'Homologa la Resolución', 1, 12, 'AC'),
(67, 'F8', 'P4', 'P5', 'Recibe el trámite y envía a secretaría Académica de Vicerrectorado', 3, 12, 'AC'),
(68, 'F8', 'P5', NULL, 'SECRETARIA VICERRECTORADO', 13, 12, 'AC'),
(69, 'F8', 'P6-Fin', 'Fin', 'CONVOCATORIA DE CONCURSO DE MERITOS PARA DOCENTES INTERINOS', 3, 12, 'AC'),
(70, '', '', '', '', NULL, 12, 'AC'),
(71, 'F9', 'P1', 'P2', 'CONCURSO DE MERITOS DE DOCENTES INTERINOS', NULL, 12, 'AC'),
(72, 'F9', 'P2', 'P3', 'Remite con Nota los files presentados a las carreras', 2, 12, 'AC'),
(73, 'F9', 'P3', 'P4', 'Recibe y remite a la Comisión para revisión de documentos', 3, 12, 'AC'),
(74, 'F9', 'P4', 'P5', 'Revisa y evalúa los documentos presentados', NULL, 12, 'AC'),
(75, 'F9', 'P5', 'P6', 'Dispone Fecha para reclamos a resultados publicados', 3, 12, 'AC'),
(76, 'F9', 'P6', 'P7-Fin', 'Subsana observaciones', NULL, 12, 'AC'),
(77, 'F9', 'P7-Fin', 'Fin', 'Recepción de informe final', 3, 12, 'AC'),
(78, '', '', '', '', NULL, 12, 'AC'),
(79, 'F10', 'P1', 'P2', 'DESIGNACION DE DOCENTES INTERINOS', 3, 12, 'AC'),
(80, 'F10', 'P2', NULL, 'Revisa y deriva la designación del personal docente', 2, 12, 'AC'),
(81, 'F10', 'P3', 'P4-Fin', 'Homologa la designación del personal docente', 1, 12, 'AC'),
(82, 'F10', 'P4-Fin', 'Fin', 'Recibe la Resolución HCF', 3, 12, 'AC'),
(83, 'F10', '', '', '', NULL, 12, 'AC'),
(84, 'F10', '', '', '', NULL, 12, 'AC'),
(85, 'F10', '', '', '', NULL, 12, 'AC'),
(86, 'F10', '', '', '', NULL, 12, 'AC'),
(87, 'F10', '', '', '', NULL, 12, 'AC'),
(88, '', '', '', '', NULL, 12, 'AC'),
(89, 'F11', 'P1', 'P2', 'DESIGNACION DE DOCENTES INVITADOS', 3, 12, 'AC'),
(90, 'F11', 'P2', NULL, 'Revisa y deriva para la elaboración de la Resolución', 2, 12, 'AC'),
(91, 'F11', 'P3', 'P4-Fin', 'Homologa la designación de docentes invitados', 1, 12, 'AC'),
(92, 'F11', 'P4-Fin', 'Fin', 'Recibe la Resolución', 3, 12, 'AC'),
(93, 'F11', '', '', '', NULL, 12, 'AC'),
(94, 'F11', '', '', '', NULL, 12, 'AC'),
(95, 'F11', '', '', '', NULL, 12, 'AC'),
(96, 'F11', '', '', '', NULL, 12, 'AC'),
(97, 'F11', '', '', '', NULL, 12, 'AC'),
(98, '', '', '', '', NULL, 12, 'AC'),
(99, 'F12', 'P1', 'P2', 'CONCURSO DE MÉRITOS Y EXAMEN DE COMPETENCIA PARA DOCENTES CONTRATADOS (pendiente)', 11, 12, 'AC'),
(100, 'F12', '', '', '', NULL, 12, 'AC'),
(101, 'F12', '', '', '', NULL, 12, 'AC'),
(102, 'F12', '', '', '', NULL, 12, 'AC'),
(103, 'F12', '', '', '', NULL, 12, 'AC'),
(104, 'F12', '', '', '', NULL, 12, 'AC'),
(105, 'F12', '', '', '', NULL, 12, 'AC'),
(106, 'F12', '', '', '', NULL, 12, 'AC'),
(107, 'F12', '', '', '', NULL, 12, 'AC'),
(108, 'F12', '', '', '', NULL, 12, 'AC'),
(109, 'F12', '', '', '', NULL, 12, 'AC'),
(110, 'F12', '', '', '', NULL, 12, 'AC'),
(111, '', '', '', '', NULL, 12, 'AC'),
(112, 'F13', 'P1', 'P2', 'DESIGNACIÓN DE DOCENTES CONTRATADOS PARA PASAR A CATEGORIA TITULAR (pendiente)', 3, 12, 'AC'),
(113, 'F13', '', '', '', NULL, 12, 'AC'),
(114, 'F13', '', '', '', NULL, 12, 'AC'),
(115, 'F13', '', '', '', NULL, 12, 'AC'),
(116, 'F13', '', '', '', NULL, 12, 'AC'),
(117, 'F13', '', '', '', NULL, 12, 'AC'),
(118, 'F13', '', '', '', NULL, 12, 'AC'),
(119, 'F13', '', '', '', NULL, 12, 'AC'),
(120, 'F13', '', '', '', NULL, 12, 'AC'),
(121, 'F13', '', '', '', NULL, 12, 'AC'),
(122, 'F13', '', '', '', NULL, 12, 'AC'),
(123, 'F13', '', '', '', NULL, 12, 'AC'),
(124, '', '', '', '', NULL, 12, 'AC'),
(125, 'F14', 'P1', 'P2', 'PAGO DE DOCENTES - PARTES DE ASISTENCIA', NULL, 12, 'AC'),
(126, 'F14', 'P2', 'P3', 'Firma', 3, 12, 'AC'),
(127, 'F14', 'P3', 'P4', 'Firma', 2, 12, 'AC'),
(128, 'F14', 'P4', 'P5-Fin', 'Firma', NULL, 12, 'AC'),
(129, 'F14', 'P5-Fin', 'Fin', 'Se envia a personal docente', NULL, 12, 'AC'),
(130, '', '', '', '', NULL, 12, 'AC'),
(131, 'F15', 'P1', 'P2', 'CONVOCATORIA A AUXILIARES DE DOCENCIA', 3, 12, 'AC'),
(132, 'F15', 'P2', 'P3', 'Confirma la carga horaria', NULL, 12, 'AC'),
(133, 'F15', 'P3', 'P4', 'Proyecto de Resolución', 3, 12, 'AC'),
(134, 'F15', 'P4', NULL, 'Recibe, revisa y remite al HCF para su aprobación', 2, 12, 'AC'),
(135, 'F15', 'P5', 'P6', 'Homologa la Resolución', 1, 12, 'AC'),
(136, 'F15', 'P6', 'P7', 'Recibe el trámite y remite a bienestar social', 3, 12, 'AC'),
(137, 'F15', 'P7', NULL, 'Verifica y revisa la Convocatoria', NULL, 12, 'AC'),
(138, 'F15', 'P8', 'P9-Fin', 'Firma del Rector(a)', NULL, 12, 'AC'),
(139, 'F15', 'P9-Fin', 'Fin', 'Publica la Convocatoria', 3, 12, 'AC'),
(140, '', '', '', '', NULL, 12, 'AC'),
(141, 'F16', 'P1', 'P2', 'DESIGNACIÓN DE AUXILIARES  DE DOCENCIA POR INVITACIÓN', 3, 12, 'AC'),
(142, 'F16', 'P2', 'P3', 'Envía el listado de estudiantes con promedios altos', 4, 12, 'AC'),
(143, 'F16', 'P3', 'P4', 'Selecciona al estudiante con mayor promedio', 3, 12, 'AC'),
(144, 'F16', 'P4', NULL, 'Confirmacion', 7, 12, 'AC'),
(145, 'F16', 'P5', 'P6', 'Elabora el proyecto de Resolución de designación', 3, 12, 'AC'),
(146, 'F16', 'P6', NULL, 'Revisa y deriva al HCF', 2, 12, 'AC'),
(147, 'F16', 'P7', 'P8', 'Homologa la Resolución de Designación del estudiante invitado', 1, 12, 'AC'),
(148, 'F16', 'P8', 'P9-Fin', 'Remite el trámite a Becas Académicas para su registro', 3, 12, 'AC'),
(149, 'F16', 'P9-Fin', 'Fin', 'Entrega Memorándum al estudiante ', 7, 12, 'AC'),
(150, 'F16', 'P10', 'Fin', '', NULL, 12, 'AC'),
(151, 'F16', '', '', '', NULL, 12, 'AC'),
(152, '', '', '', '', NULL, 12, 'AC'),
(153, 'F17', 'P1', 'P2', 'PARTES DE ASISTENCIA AUXILIARES', NULL, 12, 'AC'),
(154, 'F17', 'P2', 'P3-Fin', 'Firma', 2, 12, 'AC'),
(155, 'F17', 'P3-Fin', 'Fin', 'Firma', NULL, 12, 'AC'),
(156, 'F17', '', '', '', NULL, 12, 'AC'),
(157, '', '', '', '', NULL, 12, 'AC'),
(158, 'F18', 'P1', 'P2', 'APROBACIÓN DE PERFIL DE GRADO', 7, 12, 'AC'),
(159, 'F18', 'P2', 'P3', 'Recepción de documentos', 3, 12, 'AC'),
(160, 'F18', 'P3', NULL, 'Revisión de Perfil de grado', 11, 12, 'AC'),
(161, 'F18', 'P4', 'P5', 'Solicitud de Aprobación de Perfil con Resolucion', 11, 12, 'AC'),
(162, 'F18', 'P5', 'P6', 'Homologa la Resolución', 1, 12, 'AC'),
(163, 'F18', 'P6', 'P7-Fin', 'Recepción de Resolución', 3, 12, 'AC'),
(164, 'F18', 'P7-Fin', 'P9', 'RESOLUCIÓN DE PERFIL DE GRADO', 7, 12, 'AC'),
(165, 'F18', 'P8', 'P3', 'Correccion de errores', 7, 12, 'AC'),
(166, '', '', '', '', NULL, 12, 'AC'),
(167, 'F18', 'P9', 'P10', 'DESIGNACIÓN DE TRIBUNAL REVISOR DE GRADO', 7, 12, 'AC'),
(168, 'F18', 'P10', 'P11', 'Recepción de solicitud', 3, 12, 'AC'),
(169, 'F18', 'P11', 'P12', 'Resolución de aprobación y designación', 11, 12, 'AC'),
(170, 'F18', 'P12', 'P13', 'Homologa la Resolución ', 1, 12, 'AC'),
(171, 'F18', 'P13', 'P14-Fin', 'Recepción de Resolución', 3, 12, 'AC'),
(172, 'F18', 'P14-Fin', 'Fin', 'DESIGNACIÓN DE TRIBUNAL REVISOR DE GRADO', 7, 12, 'AC'),
(173, '', '', '', '', NULL, 12, 'AC'),
(174, 'F20', 'P1', 'P2', 'DESIGNACION DE RESPONSABLE DE CAJA CHICA', 3, 12, 'AC'),
(175, 'F20', 'P2', 'P3', 'Aprueba y remite a HCF', 11, 12, 'AC'),
(176, 'F20', 'P3', 'P4', 'Aprueba los montos y responsible de caja chica', 1, 12, 'AC'),
(177, 'F20', 'P4', NULL, 'Revisa los documentos adjuntos y procede a la apertura', NULL, 12, 'AC'),
(178, 'F20', 'P5-Fin', 'Fin', 'Entrega memorandum de designacion de responsible de caja chica', 3, 12, 'AC'),
(179, 'F20', 'P6', 'P4', 'Subsana observaciones', 3, 12, 'AC'),
(180, '', '', '', '', NULL, 12, 'AC'),
(181, 'F21', 'P1', 'P2', 'ADMINISTRACIÓN DE CAJA CHICA', NULL, 12, 'AC'),
(182, 'F21', 'P2', 'P3', 'Recepción de documentos', 1, 12, 'AC'),
(183, 'F21', 'P3', NULL, 'Revision de documentos', NULL, 12, 'AC'),
(184, 'F21', 'P4-Fin', 'Fin', 'Registro a su sistema y lo archivan', NULL, 12, 'AC'),
(185, 'F21', 'P5', 'P3', ' Subsana observaciones', NULL, 12, 'AC'),
(186, '', '', '', '', NULL, 12, 'AC'),
(187, 'F22', 'P1', 'P2', 'DESIGNACIÓN DE RESPONSABLE DE FONDO ROTATORIO', 3, 12, 'AC'),
(188, 'F22', 'P2', 'P3', 'Aprueba y remite a HCF', 11, 12, 'AC'),
(189, 'F22', 'P3', 'P4', 'Aprueba los montos y responsible de fondo rotatorio', 1, 12, 'AC'),
(190, 'F22', 'P4', NULL, 'Revisa los documentos adjuntos y procede a la apertura', NULL, 12, 'AC'),
(191, 'F22', 'P5-Fin', 'Fin', 'Entrega memorandum de designacion de responsible de fondo rotatorio', 3, 12, 'AC'),
(192, 'F22', 'P6', 'P4', 'Subsana observaciones', 3, 12, 'AC'),
(193, '', '', '', '', NULL, 12, 'AC'),
(194, 'F23', 'P1', 'P2', 'ADMINISTRACIÓN DE FONDO ROTATORIO  ', NULL, 12, 'AC'),
(195, 'F23', 'P2', 'P3', 'Recepción de documentos', 1, 12, 'AC'),
(196, 'F23', 'P3', NULL, 'Revision de documentos', NULL, 12, 'AC'),
(197, 'F23', 'P4-Fin', 'Fin', 'Registro a su sistema y lo archivan', NULL, 12, 'AC'),
(198, 'F23', 'P5', 'P3', 'Subsana observaciones', NULL, 12, 'AC'),
(199, '', '', '', '', NULL, 12, 'AC'),
(200, 'F24', 'P1', 'P2', 'CAMBIO DE MODALIDAD DE GRADUACIÓN', 7, 12, 'AC'),
(201, 'F24', 'P2', 'P3', 'Recepción de la solicitud, remite al Consejo', 3, 12, 'AC'),
(202, 'F24', 'P3', NULL, 'Analiza y revisa', 11, 12, 'AC'),
(203, 'F24', 'P4', 'P5', 'Solicitud de Cambio de modalidad de Graduacion', 11, 12, 'AC'),
(204, 'F24', 'P5', 'P6', 'Anula la anterior Resolución y se homologa la nueva Resolución', 1, 12, 'AC'),
(205, 'F24', 'P6', 'P7-Fin', 'Recepción de Resolución', 3, 12, 'AC'),
(206, 'F24', 'P7-Fin', 'Fin', 'Entrega', 7, 12, 'AC'),
(207, 'F24', 'P8', 'P3', 'Corrección de errores', 7, 12, 'AC'),
(208, '', '', '', '', NULL, 12, 'AC'),
(209, 'F25', 'P1', 'P2', 'POSTGRADO APROBACIÓN DE PERFIL', NULL, 12, 'AC'),
(210, 'F25', 'P2', 'P3', 'Recibe la solicitud y remite al HCF con Nota de Atención', 3, 12, 'AC'),
(211, 'F25', 'P3', 'P4', 'Emite Resolución', 1, 12, 'AC'),
(212, 'F25', 'P4', 'P5', 'Recibe y remite al Postgrado de carrera', 3, 12, 'AC'),
(213, 'F25', 'P5', 'P6-Fin', 'Notifica la entrega de la Resolución al Postgraduante', NULL, 12, 'AC'),
(214, 'F25', 'P6-Fin', 'Fin', 'Descarga resolución', 7, 12, 'AC'),
(215, '', '', '', '', NULL, 12, 'AC'),
(216, 'F26', 'P1', 'P2', 'POSTGRADO NOMBRAMIENTO DE TRIBUNAL DE TESIS', NULL, 12, 'AC'),
(217, 'F26', 'P2', 'P3', 'Solicita a dirección de carrera la aprobación de Tribunal de Tesis', NULL, 12, 'AC'),
(218, 'F26', 'P3', 'P4', 'Recibe la solicitud y remite al HCF con Nota de Atención', 3, 12, 'AC'),
(219, 'F26', 'P4', 'P5', 'Aprueba y homologa la Resolución', 1, 12, 'AC'),
(220, 'F26', 'P5', 'P6', 'Recibe y remite al Postgrado de carrera', 3, 12, 'AC'),
(221, 'F26', 'P6', 'P7-Fin', 'Notifica a los docentes  nombrados para tribunal de la Tesis', NULL, 12, 'AC'),
(222, 'F26', 'P7-Fin', 'Fin', 'Entrega copia de Resolucion', 7, 12, 'AC'),
(223, '', '', '', '', NULL, 12, 'AC'),
(224, 'F27', 'P1', 'P2', 'MAESTRIA TERMINAL - INSCRIPCIONES', NULL, 12, 'AC'),
(225, 'F27', 'P2', NULL, 'Registro de documentos y verificación según convocatoria', 4, 12, 'AC'),
(226, 'F27', 'P3', 'P2', 'Corrección de documentos', 7, 12, 'AC'),
(227, 'F27', 'P4', 'P5', 'Elabora listas para habilitar los pagos de postulantes', 4, 12, 'AC'),
(228, 'F27', 'P5', 'P6-Fin', 'Habilita acceso al sistema SIA, SSA', 4, 12, 'AC'),
(229, 'F27', 'P6-Fin', 'Fin', 'Listas de los postulantes', 3, 12, 'AC'),
(230, '', '', '', '', NULL, 12, 'AC'),
(231, 'F28', 'P1', 'P2', 'MAESTRIA TERMINAL - CERTIFICADO DE CALIFICACIONES Y CONCLUSIÓN DE ESTUDIOS', NULL, 12, 'AC'),
(232, 'F28', 'P2', 'P3', 'Llenado de certificados y Informe de conclusión de estudios', 4, 12, 'AC'),
(233, 'F28', 'P3', 'P4', 'Firma de certificados', 3, 12, 'AC'),
(234, 'F28', 'P4', 'P5', 'Firma de certificados', 1, 12, 'AC'),
(235, 'F28', 'P5', 'P6-Fin', 'Recepción de certificados', 4, 12, 'AC'),
(236, 'F28', 'P6-Fin', 'Fin', 'Descarga de certificados', 7, 12, 'AC'),
(237, '', '', '', '', NULL, 12, 'AC'),
(238, 'F29', 'P1', 'P2', 'MAESTRIA TERMINAL - LLENADO DE GAR  PARA DEFENSA', NULL, 12, 'AC'),
(239, 'F29', 'P2', 'P3', 'Coordina con kardex fecha y hora de defensa', 3, 12, 'AC'),
(240, 'F29', 'P3', 'P4-Fin', 'Firma de GAR', 1, 12, 'AC'),
(241, 'F29', 'P4-Fin', 'Fin', 'Recive y revisa ', NULL, 12, 'AC'),
(242, 'F29', '', '', '', NULL, 12, 'AC'),
(243, '', '', '', '', NULL, 12, 'AC'),
(244, 'F30', 'P1', 'P2', 'MAESTRIA TERMINAL - ELABORACIÓN DE ACTAS DE DEFENSA PARA DEFENSA DE TESIS', NULL, 12, 'AC'),
(245, 'F30', 'P2', 'P3-Fin', 'Elabora el Acta de defensa de la Tesis y entrega a Director', 4, 12, 'AC'),
(246, 'F30', 'P3-Fin', 'Fin', 'Se da lectura al Acta a la conclusión de la defensa', 3, 12, 'AC'),
(247, 'F30', '', '', '', NULL, 12, 'AC'),
(248, '', '', '', '', NULL, 12, 'AC'),
(249, 'F31', 'P1', 'P2', 'POSTGRADO AUTOFINANCIADO - INSCRIPCIONES', NULL, 12, 'AC'),
(250, 'F31', 'P2', NULL, 'Registro de documentos y verificación según convocatoria', 4, 12, 'AC'),
(251, 'F31', 'P3', 'P2', 'Corrección de documentos', 7, 12, 'AC'),
(252, 'F31', 'P4', 'P5', 'Elabora listas para habilitar los pagos de postulantes', 4, 12, 'AC'),
(253, 'F31', 'P5', 'P6-Fin', 'Habilita acceso al sistema SIA, SSA', 4, 12, 'AC'),
(254, 'F31', 'P6-Fin', 'Fin', 'Listas de los postulantes', 3, 12, 'AC'),
(255, '', '', '', '', NULL, 12, 'AC'),
(256, 'F32', 'P1', 'P2', 'POSTGRADO AUTOFINANCIADO - CERTIFICADO DE CALIFICACIONES Y CONCLUSIÓN DE ESTUDIOS', NULL, 12, 'AC'),
(257, 'F32', 'P2', 'P3', 'Llenado de certificados y Informe de conclusión de estudios', 4, 12, 'AC'),
(258, 'F32', 'P3', 'P4', 'Firma de certificados', 3, 12, 'AC'),
(259, 'F32', 'P4', 'P5', 'Firma de certificados', 1, 12, 'AC'),
(260, 'F32', 'P5', 'P6-Fin', 'Recepción de certificados', 4, 12, 'AC'),
(261, 'F32', 'P6-Fin', 'Fin', 'Descarga de certificados', 7, 12, 'AC'),
(262, '', '', '', '', NULL, 12, 'AC'),
(263, 'F33', 'P1', 'P2', 'POSTGRADO AUTOFINANCIADO - LLENADO DE GAR  PARA DEFENSA', NULL, 12, 'AC'),
(264, 'F33', 'P2', 'P3', 'Coordina con kardex fecha y hora de defensa', 3, 12, 'AC'),
(265, 'F33', 'P3', 'P4-Fin', 'Firma de GAR', 1, 12, 'AC'),
(266, 'F33', 'P4-Fin', 'Fin', 'Recive y revisa ', NULL, 12, 'AC'),
(267, 'F33', '', '', '', NULL, 12, 'AC'),
(268, '', '', '', '', NULL, 12, 'AC'),
(269, 'F34', 'P1', 'P2', 'POSTGRADO AUTOFINANCIADO - ELABORACIÓN DE ACTAS DE DEFENSA PARA DEFENSA DE TESIS', NULL, 12, 'AC'),
(270, 'F34', 'P2', 'P3-Fin', 'Elabora el Acta de defensa de la Tesis y entrega a Director', 4, 12, 'AC'),
(271, 'F34', 'P3-Fin', 'Fin', 'Se da lectura al Acta a la conclusión de la defensa', 3, 12, 'AC'),
(272, 'F34', '', '', '', NULL, NULL, NULL);

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

--
-- Volcado de datos para la tabla `materia_extra`
--

INSERT INTO `materia_extra` (`id`, `c_aval`, `cif`, `d_aval`, `d_respaldo`, `d_solicitud`, `r_respaldo`, `r_solicitud`, `user_id`, `tramite_id`) VALUES
(1, '1D_uYl_U5cqkEUSkWfCikyybqBYOvuHhM', NULL, 'aval.pdf', 'respaldo.pdf', 'solicitud.pdf', 'correcto', 'correcto', 7, 'AC-FIL-17-ES');

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
(8, 'F8', 'P2', 'P3', 'P1', NULL),
(9, 'F8', 'P5', 'P6-Fin', 'P1', NULL),
(10, 'F10', 'P2', 'P3', 'P1', NULL),
(11, 'F11', 'P2', 'P3', 'P1', NULL),
(12, 'F15', 'P4', 'P5', 'P3', NULL),
(13, 'F15', 'P7', 'P8', 'P3', NULL),
(14, 'F16', 'P4', 'P5', 'Fin', NULL),
(15, 'F16', 'P6', 'P7', 'P5', NULL),
(16, 'F18', 'P3', 'P4', 'P8', NULL),
(17, 'F20', 'P4', 'P5-Fin', 'P6', NULL),
(18, 'F21', 'P3', 'P4-Fin', 'P5', NULL),
(19, 'F22', 'P4', 'P5-Fin', 'P6', NULL),
(20, 'F23', 'P3', 'P4-Fin', 'P5', NULL),
(21, 'F24', 'P3', 'P4', 'P8', NULL),
(22, 'F27', 'P2', 'P4', 'P3', NULL),
(23, 'F31', 'P2', 'P4', 'P3', NULL);

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
(13, 'VICERRECTORADO', NULL);

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

--
-- Volcado de datos para la tabla `seguimiento`
--

INSERT INTO `seguimiento` (`id`, `tramite_id`, `flujo`, `proceso`, `fecha_fin`, `fecha_inicio`, `carrera`, `estado`, `activo`, `comentario`, `role_id`, `user_id`, `tiempo`) VALUES
(61, 'AC-FIL-14-ES', 'F18', 'P1', '2024-06-17 10:55:17.000000', '2024-06-16 20:40:26.000000', 'FIL', 'terminado', 'true', '', 7, 7, '2024-06-17 08:34:38.000000'),
(62, 'AC-FIL-14-ES', 'F18', 'P2', '2024-06-17 11:08:30.000000', '2024-06-17 10:55:17.000000', 'FIL', 'terminado', 'true', '', 3, 3, '2024-06-17 22:43:28.000000'),
(63, 'AC-FIL-14-ES', 'F18', 'P3', '2024-06-17 11:12:21.000000', '2024-06-17 11:08:30.000000', 'FIL', 'observado', 'true', '', 11, 14, '2024-06-17 23:04:39.000000'),
(64, 'AC-FIL-14-ES', 'F18', 'P8', '2024-06-17 20:40:40.000000', '2024-06-17 11:12:21.000000', 'FIL', 'terminado', 'true', 'consejo carrera', 7, 7, '2024-06-17 23:01:11.000000'),
(66, 'AC-FIL-14-ES', 'F18', 'P3', '2024-06-17 22:09:12.000000', '2024-06-17 20:40:40.000000', 'FIL', 'terminado', 'true', 'correccion de datos del estudiante', 11, 14, '2024-06-18 08:40:40.000000'),
(67, 'AC-FIL-14-ES', 'F18', 'P4', '2024-06-17 22:12:24.000000', '2024-06-17 22:09:12.000000', 'FIL', 'terminado', 'true', '', 11, 14, '2024-06-18 10:09:12.000000'),
(68, 'AC-FIL-14-ES', 'F18', 'P5', '2024-06-19 11:05:19.000000', '2024-06-17 22:12:24.000000', 'FHCE', 'terminado', 'true', '', 1, 1, '2024-06-18 10:12:24.000000'),
(69, 'AC-FIL-14-ES', 'F18', 'P6', '2024-06-19 11:06:47.000000', '2024-06-19 11:05:19.000000', 'FIL', 'terminado', 'true', '', 3, 3, '2024-06-19 23:05:19.000000'),
(70, 'AC-FIL-14-ES', 'F18', 'P7-Fin', '2024-06-19 11:06:47.000000', '2024-06-19 11:06:47.000000', 'FIL', 'terminado', 'true', '', 7, 7, '2024-06-19 23:06:47.000000'),
(71, 'AC-FIL-14-ES', 'F18', 'P9', '2024-06-19 11:09:22.000000', '2024-06-19 11:07:45.000000', 'FIL', 'terminado', 'true', '', 7, 7, '2024-06-19 23:07:45.000000'),
(72, 'AC-FIL-14-ES', 'F18', 'P10', '2024-06-19 11:12:53.000000', '2024-06-19 11:09:22.000000', 'FIL', 'terminado', 'true', '', 3, 3, '2024-06-19 23:09:22.000000'),
(73, 'AC-FIL-14-ES', 'F18', 'P11', '2024-06-19 11:15:11.000000', '2024-06-19 11:12:53.000000', 'FIL', 'terminado', 'true', '', 11, 14, '2024-06-19 23:12:53.000000'),
(74, 'AC-FIL-14-ES', 'F18', 'P12', '2024-06-19 11:19:27.000000', '2024-06-19 11:15:11.000000', 'FHCE', 'terminado', 'true', '', 1, 1, '2024-06-19 23:15:11.000000'),
(75, 'AC-FIL-14-ES', 'F18', 'P13', '2024-06-19 11:20:04.000000', '2024-06-19 11:19:27.000000', 'FIL', 'terminado', 'true', '', 3, 3, '2024-06-19 23:19:27.000000'),
(76, 'AC-FIL-14-ES', 'F18', 'P14-Fin', '2024-06-19 11:20:04.000000', '2024-06-19 11:20:04.000000', 'FIL', 'terminado', 'true', '', 7, 7, '2024-06-19 23:20:04.000000'),
(77, 'AC-FIL-15-DIR', 'F8', 'P1', '2024-06-19 11:33:43.000000', '2024-06-19 11:27:13.000000', 'FIL', 'observado', 'true', '', 3, 3, '2024-06-19 23:27:13.000000'),
(78, 'AC-FIL-15-DIR', 'F8', 'P2', '2024-06-19 11:38:12.000000', '2024-06-19 11:33:43.000000', 'FIL', 'observado', 'true', '', 11, 14, '2024-06-19 23:33:43.000000'),
(79, 'AC-FIL-15-DIR', 'F8', 'P1', '2024-06-19 11:38:35.000000', '2024-06-19 11:38:12.000000', 'FIL', 'observado', 'true', 'observado', 3, 3, '2024-06-19 23:38:12.000000'),
(80, 'AC-FIL-15-DIR', 'F8', 'P2', '2024-06-19 11:39:29.000000', '2024-06-19 11:38:35.000000', 'FIL', 'terminado', 'true', 'corregido', 11, 14, '2024-06-19 23:38:35.000000'),
(81, 'AC-FIL-15-DIR', 'F8', 'P3', '2024-06-19 11:44:34.000000', '2024-06-19 11:39:29.000000', 'FHCE', 'terminado', 'true', '', 1, 1, '2024-06-19 23:39:29.000000'),
(82, 'AC-FIL-15-DIR', 'F8', 'P4', '2024-06-19 11:45:32.000000', '2024-06-19 11:44:34.000000', 'FIL', 'terminado', 'true', '', 3, 3, '2024-06-19 23:44:34.000000'),
(83, 'AC-FIL-15-DIR', 'F8', 'P5', '2024-06-19 11:49:31.000000', '2024-06-19 11:45:32.000000', 'FHCE', 'terminado', 'true', '', 13, 17, '2024-06-19 23:45:32.000000'),
(85, 'AC-FIL-15-DIR', 'F8', 'P6-Fin', '2024-06-19 11:49:31.000000', '2024-06-19 11:49:31.000000', 'FIL', 'terminado', 'true', '', 3, 3, '2024-06-19 23:49:31.000000'),
(86, 'AC-FIL-16-ES', 'F1', 'P1', '2024-06-19 14:44:37.000000', '2024-06-19 12:02:16.000000', 'FIL', 'terminado', 'true', '', 7, 7, '2024-06-20 00:02:16.000000'),
(87, 'AC-FIL-16-ES', 'F1', 'P2', '2024-06-19 14:53:30.000000', '2024-06-19 14:44:37.000000', 'FIL', 'terminado', 'true', '', 3, 3, '2024-06-20 02:44:37.000000'),
(88, 'AC-FIL-16-ES', 'F1', 'P3', '2024-06-19 14:54:59.000000', '2024-06-19 14:48:05.000000', 'FIL', 'observado', 'true', '', 4, 4, '2024-06-20 02:48:05.000000'),
(90, 'AC-FIL-16-ES', 'F1', 'P9', '2024-06-19 14:58:36.000000', '2024-06-19 14:54:59.000000', 'FIL', 'terminado', 'true', 'observado', 7, 7, '2024-06-20 02:54:59.000000'),
(91, 'AC-FIL-16-ES', 'F1', 'P3', '2024-06-19 14:58:53.000000', '2024-06-19 14:58:36.000000', 'FIL', 'terminado', 'true', 'correccion de documentos', 4, 4, '2024-06-20 02:58:36.000000'),
(92, 'AC-FIL-16-ES', 'F1', 'P4', '2024-06-19 15:13:55.000000', '2024-06-19 14:58:53.000000', 'FIL', 'terminado', 'true', '', 3, 3, '2024-06-20 02:58:53.000000'),
(93, 'AC-FIL-16-ES', 'F1', 'P5', '2024-06-19 15:51:09.000000', '2024-06-19 15:13:55.000000', 'FIL', 'terminado', 'true', '', 11, 14, '2024-06-20 03:13:55.000000'),
(94, 'AC-FIL-16-ES', 'F1', 'P6', '2024-06-19 15:55:44.000000', '2024-06-19 15:51:09.000000', 'FHCE', 'terminado', 'true', '', 1, 1, '2024-06-20 03:51:09.000000'),
(95, 'AC-FIL-16-ES', 'F1', 'P7', '2024-06-19 15:57:14.000000', '2024-06-19 15:55:44.000000', 'FIL', 'terminado', 'true', '', 3, 3, '2024-06-20 03:55:44.000000'),
(96, 'AC-FIL-16-ES', 'F1', 'P8-Fin', '2024-06-19 15:57:14.000000', '2024-06-19 15:57:14.000000', 'FIL', 'terminado', 'true', '', 7, 7, '2024-06-20 03:57:14.000000'),
(97, 'AC-FIL-17-ES', 'F2', 'P1', '2024-06-19 16:24:03.000000', '2024-06-19 16:09:39.000000', 'FIL', 'terminado', 'true', '', 7, 7, '2024-06-20 04:09:39.000000'),
(98, 'AC-FIL-17-ES', 'F2', 'P2', '2024-06-19 16:25:16.000000', '2024-06-19 16:24:03.000000', 'FIL', 'terminado', 'true', '', 3, 3, '2024-06-20 04:24:03.000000'),
(99, 'AC-FIL-17-ES', 'F2', 'P3', '2024-06-19 16:32:06.000000', '2024-06-19 16:25:16.000000', 'FIL', 'observado', 'true', '', 4, 4, '2024-06-20 04:25:16.000000'),
(101, 'AC-FIL-17-ES', 'F2', 'P7', '2024-06-19 16:32:23.000000', '2024-06-19 16:32:06.000000', 'FIL', 'terminado', 'true', 'observado', 7, 7, '2024-06-20 04:32:06.000000'),
(102, 'AC-FIL-17-ES', 'F2', 'P3', '2024-06-19 16:32:40.000000', '2024-06-19 16:32:23.000000', 'FIL', 'terminado', 'true', 'correccion de documentos', 4, 4, '2024-06-20 04:32:23.000000'),
(103, 'AC-FIL-17-ES', 'F2', 'P4', '2024-06-19 18:18:21.000000', '2024-06-19 16:32:40.000000', 'FIL', 'terminado', 'true', '', 11, 14, '2024-06-20 04:32:40.000000'),
(104, 'AC-FIL-17-ES', 'F2', 'P5', '2024-06-19 18:20:42.000000', '2024-06-19 18:18:21.000000', 'FIL', 'terminado', 'true', '', 3, 3, '2024-06-20 06:18:21.000000'),
(105, 'AC-FIL-17-ES', 'F2', 'P6-Fin', '2024-06-19 18:20:42.000000', '2024-06-19 18:20:42.000000', 'FIL', 'terminado', 'true', '', 7, 7, '2024-06-20 06:20:42.000000'),
(106, 'AC-FIL-18-ES', 'F3', 'P1', '2024-06-19 19:16:27.000000', '2024-06-19 18:22:18.000000', 'FIL', 'terminado', 'true', '', 7, 7, '2024-06-20 06:22:18.000000'),
(107, 'AC-FIL-18-ES', 'F3', 'P2', '2024-06-19 19:21:17.000000', '2024-06-19 19:16:27.000000', 'FIL', 'terminado', 'true', '', 3, 3, '2024-06-20 07:16:27.000000'),
(108, 'AC-FIL-18-ES', 'F3', 'P3', '2024-06-19 19:23:19.000000', '2024-06-19 19:21:17.000000', 'FIL', 'observado', 'true', '', 4, 4, '2024-06-20 07:21:17.000000'),
(109, 'AC-FIL-18-ES', 'F3', 'P10', '2024-06-19 19:25:36.000000', '2024-06-19 19:23:19.000000', 'FIL', 'terminado', 'true', '', 7, 7, '2024-06-20 07:23:19.000000'),
(110, 'AC-FIL-18-ES', 'F3', 'P3', '2024-06-19 20:06:04.000000', '2024-06-19 19:25:36.000000', 'FIL', 'terminado', 'true', 'correccion de documentos', 4, 4, '2024-06-20 07:25:36.000000'),
(116, 'AC-FIL-18-ES', 'F3', 'P4', '2024-06-19 20:24:21.000000', '2024-06-19 20:06:04.000000', 'FIL', 'observado', 'true', '', 4, 4, '2024-06-20 08:06:04.000000'),
(117, 'AC-FIL-18-ES', 'F3', 'P5', '2024-06-19 20:27:05.000000', '2024-06-19 20:24:21.000000', 'FIL', 'observado', 'true', '', 3, 3, '2024-06-20 08:24:21.000000'),
(118, 'AC-FIL-18-ES', 'F3', 'P4', '2024-06-19 20:36:12.000000', '2024-06-19 20:27:05.000000', 'FIL', 'terminado', 'true', 'observado', 4, 4, '2024-06-20 08:27:05.000000'),
(119, 'AC-FIL-18-ES', 'F3', 'P5', '2024-06-19 21:10:29.000000', '2024-06-19 20:36:12.000000', 'FIL', 'terminado', 'true', '', 3, 3, '2024-06-20 08:36:12.000000'),
(121, 'AC-FIL-18-ES', 'F3', 'P6', '2024-06-19 21:11:40.000000', '2024-06-19 21:10:29.000000', 'FIL', 'terminado', 'true', '', 3, 3, '2024-06-20 09:10:29.000000'),
(122, 'AC-FIL-18-ES', 'F3', 'P7', '2024-06-19 21:13:00.000000', '2024-06-19 21:11:40.000000', 'FHCE', 'terminado', 'true', '', 2, 2, '2024-06-20 09:11:40.000000'),
(123, 'AC-FIL-18-ES', 'F3', 'P8', '2024-06-19 21:16:04.000000', '2024-06-19 21:13:00.000000', 'FIL', 'terminado', 'true', '', 4, 4, '2024-06-20 09:13:00.000000'),
(124, 'AC-FIL-18-ES', 'F3', 'P9-Fin', '2024-06-19 21:16:04.000000', '2024-06-19 21:16:04.000000', 'FIL', 'terminado', 'true', '', 7, 7, '2024-06-20 09:16:04.000000'),
(125, 'AC-FIL-19-ES', 'F4', 'P1', '2024-06-19 21:32:59.000000', '2024-06-19 21:19:26.000000', 'FIL', 'terminado', 'true', '', 7, 7, '2024-06-20 09:19:26.000000'),
(126, 'AC-FIL-19-ES', 'F4', 'P2', '2024-06-19 21:34:31.000000', '2024-06-19 21:32:59.000000', 'FIL', 'terminado', 'true', '', 3, 3, '2024-06-20 09:32:59.000000'),
(127, 'AC-FIL-19-ES', 'F4', 'P3', '2024-06-19 21:35:58.000000', '2024-06-19 21:34:31.000000', 'FIL', 'observado', 'true', '', 4, 4, '2024-06-20 09:34:31.000000'),
(128, 'AC-FIL-19-ES', 'F4', 'P11', '2024-06-19 21:37:07.000000', '2024-06-19 21:35:58.000000', 'FIL', 'terminado', 'true', 'observado', 7, 7, '2024-06-20 09:35:58.000000'),
(129, 'AC-FIL-19-ES', 'F4', 'P3', '2024-06-19 21:37:37.000000', '2024-06-19 21:37:07.000000', 'FIL', 'terminado', 'true', 'correccion de documentos', 4, 4, '2024-06-20 09:37:07.000000'),
(130, 'AC-FIL-19-ES', 'F4', 'P4', '2024-06-19 21:40:11.000000', '2024-06-19 21:37:37.000000', 'FIL', 'terminado', 'true', '', 3, 3, '2024-06-20 09:37:37.000000'),
(131, 'AC-FIL-19-ES', 'F4', 'P5', '2024-06-19 22:04:20.000000', '2024-06-19 21:40:11.000000', 'FIL', 'terminado', 'true', '', 10, 13, '2024-06-20 09:40:11.000000'),
(134, 'AC-FIL-19-ES', 'F4', 'P6', '2024-06-19 22:04:41.000000', '2024-06-19 22:04:20.000000', 'FIL', 'terminado', 'true', '', 3, 3, '2024-06-20 10:04:20.000000'),
(135, 'AC-FIL-19-ES', 'F4', 'P7', '2024-06-19 22:21:55.000000', '2024-06-19 22:04:41.000000', 'FIL', 'terminado', 'true', '', 11, 14, '2024-06-20 10:04:41.000000'),
(136, 'AC-FIL-19-ES', 'F4', 'P8', '2024-06-19 22:28:27.000000', '2024-06-19 22:21:55.000000', 'FHCE', 'terminado', 'true', '', 1, 1, '2024-06-20 10:21:55.000000'),
(137, 'AC-FIL-19-ES', 'F4', 'P9', '2024-06-19 22:30:40.000000', '2024-06-19 22:28:27.000000', 'FIL', 'terminado', 'true', '', 3, 3, '2024-06-20 10:28:27.000000'),
(138, 'AC-FIL-19-ES', 'F4', 'P10-Fin', '2024-06-19 22:30:40.000000', '2024-06-19 22:30:40.000000', 'FIL', 'terminado', 'true', '', 7, 7, '2024-06-20 10:30:40.000000'),
(139, 'AC-FIL-20-ES', 'F5', 'P1', '2024-06-19 23:00:30.000000', '2024-06-19 22:33:44.000000', 'FIL', 'terminado', 'true', '', 7, 7, '2024-06-20 10:33:44.000000'),
(140, 'AC-FIL-20-ES', 'F5', 'P2', '2024-06-19 23:10:40.000000', '2024-06-19 23:00:30.000000', 'FIL', 'terminado', 'true', '', 4, 4, '2024-06-20 11:00:30.000000'),
(141, 'AC-FIL-20-ES', 'F5', 'P3', '2024-06-19 23:14:34.000000', '2024-06-19 23:10:40.000000', 'FIL', 'terminado', 'true', '', 3, 3, '2024-06-20 11:10:40.000000'),
(142, 'AC-FIL-20-ES', 'F5', 'P4', '2024-06-19 23:15:08.000000', '2024-06-19 23:14:34.000000', 'FHCE', 'terminado', 'true', '', 1, 1, '2024-06-20 11:14:34.000000'),
(143, 'AC-FIL-20-ES', 'F5', 'P5', '2024-06-19 23:15:57.000000', '2024-06-19 23:15:08.000000', 'FIL', 'terminado', 'true', '', 4, 4, '2024-06-20 11:15:08.000000'),
(144, 'AC-FIL-20-ES', 'F5', 'P6-Fin', '2024-06-19 23:15:57.000000', '2024-06-19 23:15:57.000000', 'FIL', 'terminado', 'true', '', 7, 7, '2024-06-20 11:15:57.000000'),
(145, 'AC-FIL-21-ES', 'F6', 'P1', '2024-06-19 23:29:16.000000', '2024-06-19 23:16:37.000000', 'FIL', 'terminado', 'true', '', 7, 7, '2024-06-20 11:16:37.000000'),
(146, 'AC-FIL-21-ES', 'F6', 'P2', '2024-06-19 23:47:28.000000', '2024-06-19 23:29:16.000000', 'FIL', 'terminado', 'true', '', 4, 4, '2024-06-20 11:29:16.000000'),
(147, 'AC-FIL-21-ES', 'F6', 'P3', '2024-06-19 23:49:13.000000', '2024-06-19 23:47:28.000000', 'FIL', 'terminado', 'true', '', 3, 3, '2024-06-20 11:47:28.000000'),
(148, 'AC-FIL-21-ES', 'F6', 'P4', '2024-06-19 23:49:42.000000', '2024-06-19 23:49:13.000000', 'FHCE', 'terminado', 'true', '', 1, 1, '2024-06-20 11:49:13.000000'),
(149, 'AC-FIL-21-ES', 'F6', 'P5', '2024-06-19 23:50:32.000000', '2024-06-19 23:49:42.000000', 'FIL', 'terminado', 'true', '', 4, 4, '2024-06-20 11:49:42.000000'),
(150, 'AC-FIL-21-ES', 'F6', 'P6-Fin', '2024-06-19 23:50:32.000000', '2024-06-19 23:50:32.000000', 'FIL', 'terminado', 'true', '', 7, 7, '2024-06-20 11:50:32.000000');

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
-- Volcado de datos para la tabla `tramite`
--

INSERT INTO `tramite` (`id`, `user_id`, `flujo`, `proceso`, `tipo`, `carrera`, `estado`, `creacion`) VALUES
('AC-FIL-14-ES', 7, 'F18', 'P14-Fin', 'APROBACIÓN DE PERFIL DE GRADO', 'FIL', 'terminado', '2024-06-16 20:40:26.000000'),
('AC-FIL-15-DIR', 3, 'F8', 'P6-Fin', 'CONVOCATORIA DE CONCURSO DE MERITOS PARA DOCENTES INTERINOS', 'FIL', 'terminado', '2024-06-19 11:27:13.000000'),
('AC-FIL-16-ES', 7, 'F1', 'P8-Fin', 'INSCRIPCIONES DE ASIGNATURAS DE ALUMNOS LIBRES', 'FIL', 'terminado', '2024-06-19 12:02:16.000000'),
('AC-FIL-17-ES', 7, 'F2', 'P6-Fin', 'INSCRIPCIÓN DE MATERIAS EXTRA', 'FIL', 'terminado', '2024-06-19 16:09:39.000000'),
('AC-FIL-18-ES', 7, 'F3', 'P9-Fin', 'CONVALIDACIÓN DE MATERIAS DE PLAN A PLAN', 'FIL', 'terminado', '2024-06-19 18:22:18.000000'),
('AC-FIL-19-ES', 7, 'F4', 'P10-Fin', 'CONVALIDACIÓN  DE MATERIAS DE OTRAS CARRERAS', 'FIL', 'terminado', '2024-06-19 21:19:26.000000'),
('AC-FIL-20-ES', 7, 'F5', 'P6-Fin', 'CERTIFICADO ÚNICO DE CALIFICACIONES', 'FIL', 'terminado', '2024-06-19 22:33:44.000000'),
('AC-FIL-21-ES', 7, 'F6', 'P6-Fin', 'CERTIFICADO DE CONCLUSIÓN DE ESTUDIOS', 'FIL', 'terminado', '2024-06-19 23:16:37.000000');

--
-- Disparadores `tramite`
--
DELIMITER $$
CREATE TRIGGER `generate_tramite_id` BEFORE INSERT ON `tramite` FOR EACH ROW BEGIN
    DECLARE new_numero INT;
    DECLARE new_categoria VARCHAR(50);
    DECLARE new_rol VARCHAR(20);

    -- Obtener la categoría desde la tabla FLUJO
    SELECT categoria_id INTO new_categoria FROM FLUJO WHERE flujo = NEW.flujo LIMIT 1;

     -- Obtener el siguiente número correlativo para la carrera
    SELECT secuencia + 1 INTO new_numero FROM UNIDAD WHERE id = NEW.carrera;

    -- Actualizar la secuencia en la tabla UNIDAD
    UPDATE UNIDAD SET secuencia = new_numero WHERE id = NEW.carrera;

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
('AM', 'ADULTO MAYOR', 0),
('CED', 'CIENCIAS EDUCACION', 0),
('CIN', 'CIENCIAS INFORMACION', 0),
('CN', 'CINE', 0),
('FHCE', 'FACULTATIVO', 0),
('FIL', 'FILOSOFIA', 21),
('HIS', 'HISTORIA', 0),
('LIN', 'LINGUISTICA', 0),
('LIT', 'LITERATURA', 0),
('PSI', 'PSICOLOGIA', 0),
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
(6, '$2a$10$QJduUkKEFwRQ.z6E6mKiHuPbGMs5scF8uzrVmAEUiqfyDfeLO6MLu', 'docente1', NULL),
(7, '$2a$10$qVjwTo0DNxV3/tzUgwsGgeNsvzgzoHMuP1joaMtEAbM/ZaWCl3Eai', 'estudiante1', NULL),
(8, '$2a$10$rCggV2vGw1.DtqUND9y.fOBr3J4m0jajQP5p9LhwkgvuKh0p87nKe', 'estudiante2', NULL),
(13, '$2a$10$0.E8FUfb.zqUK4vRNvaeX.T4cN6j5HWOgDGs.ckG3MCSUF7cHrx8q', 'comision', NULL),
(14, '$2a$10$0.E8FUfb.zqUK4vRNvaeX.T4cN6j5HWOgDGs.ckG3MCSUF7cHrx8q', 'consejocarrera', NULL),
(15, '$2a$10$0.E8FUfb.zqUK4vRNvaeX.T4cN6j5HWOgDGs.ckG3MCSUF7cHrx8q', 'kardexHis', NULL),
(16, '$2a$10$0.E8FUfb.zqUK4vRNvaeX.T4cN6j5HWOgDGs.ckG3MCSUF7cHrx8q', 'admin', NULL),
(17, '$2a$10$0.E8FUfb.zqUK4vRNvaeX.T4cN6j5HWOgDGs.ckG3MCSUF7cHrx8q', 'vicerrectorado', NULL),
(23, '$2a$10$PuhZDTAarRat9Qc4rHywRObUJhKLWG1IPxtlFgvlGFN/W.IOMbj0a', 'abraham', '22205200202');

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
(3, 3, 3, 'FIL'),
(4, 4, 4, 'FIL'),
(5, 6, 6, 'FIL'),
(6, 7, 7, 'FIL'),
(7, 7, 8, 'FIL'),
(8, 5, 5, 'FIL'),
(9, 10, 13, 'FIL'),
(10, 11, 14, 'FIL'),
(11, 4, 15, 'HIS'),
(12, 12, 16, 'FHCE'),
(13, 13, 17, 'FHCE'),
(16, 7, 23, 'HIS');

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
-- Indices de la tabla `designacion_tribunal`
--
ALTER TABLE `designacion_tribunal`
  ADD PRIMARY KEY (`id`),
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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `aprobacion_perfil`
--
ALTER TABLE `aprobacion_perfil`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `designacion_tribunal`
--
ALTER TABLE `designacion_tribunal`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `flujo`
--
ALTER TABLE `flujo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=273;

--
-- AUTO_INCREMENT de la tabla `materia_extra`
--
ALTER TABLE `materia_extra`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `procesocond`
--
ALTER TABLE `procesocond`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `seguimiento`
--
ALTER TABLE `seguimiento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=151;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de la tabla `user_role`
--
ALTER TABLE `user_role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

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
-- Filtros para la tabla `designacion_tribunal`
--
ALTER TABLE `designacion_tribunal`
  ADD CONSTRAINT `FK8j80bx8p4dopl2idfrdpq0jtv` FOREIGN KEY (`tramite_id`) REFERENCES `tramite` (`id`);

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
