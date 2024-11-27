-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-11-2024 a las 21:17:36
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.0.28

CREATE DATABASE IF NOT EXISTS `sgd`;
USE `sgd`;

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
  `c_resolucion` varchar(255) DEFAULT NULL,
  `f_proy_resolucion` varchar(255) DEFAULT NULL,
  `f_resolucion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aprobacion_perfil`
--

CREATE TABLE `aprobacion_perfil` (
  `id` int(11) NOT NULL,
  `tramite_id` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `cambio_resolucion` varchar(255) DEFAULT NULL,
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
  `d_record_academico` varchar(255) DEFAULT NULL,
  `d_proyecto_resolucion_perfil` varchar(255) DEFAULT NULL,
  `d_resolucion_perfil` varchar(255) DEFAULT NULL,
  `r_nota_director` varchar(255) DEFAULT NULL,
  `d_solicitud_aprobacion_perfil` varchar(255) DEFAULT NULL,
  `r_carta_institucion` varchar(255) DEFAULT NULL,
  `r_conclusion_estudios` varchar(255) DEFAULT NULL,
  `r_nota_tutor` varchar(255) DEFAULT NULL,
  `r_perfil_grado` varchar(255) DEFAULT NULL,
  `r_record_academico` varchar(255) DEFAULT NULL,
  `tutor` varchar(255) DEFAULT NULL,
  `f_proyecto_resolucion_perfil` varchar(255) DEFAULT NULL,
  `f_resolucion_perfil` varchar(255) DEFAULT NULL,
  `f_solicitud_aprobacion_perfil` varchar(255) DEFAULT NULL,
  `d_nota_renuncia_tutor` varchar(255) DEFAULT NULL,
  `r_nota_renuncia_tutor` varchar(255) DEFAULT NULL
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
  `tramite_id` varchar(255) DEFAULT NULL,
  `f_certificado_conclusion` varchar(255) DEFAULT NULL,
  `r_cedula_identidad` varchar(255) DEFAULT NULL,
  `r_certificado_unico` varchar(255) DEFAULT NULL,
  `r_valorada` varchar(255) DEFAULT NULL
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
  `c_certificado_unico` varchar(255) DEFAULT NULL,
  `f_certificado_unico` varchar(255) DEFAULT NULL
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
  `r_informe_convalidacion` varchar(255) DEFAULT NULL,
  `f_informe_convalidacion` varchar(255) DEFAULT NULL
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
  `r_informe_convalidacion` varchar(255) DEFAULT NULL,
  `f_informe_convalidacion` varchar(255) DEFAULT NULL,
  `f_proy_resolucion` varchar(255) DEFAULT NULL,
  `f_resolucion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `conv_aux_docencia`
--

CREATE TABLE `conv_aux_docencia` (
  `id` int(11) NOT NULL,
  `c_certificacion_carga_horaria` varchar(255) DEFAULT NULL,
  `c_convocatoria` varchar(255) DEFAULT NULL,
  `c_nota_atencion` varchar(255) DEFAULT NULL,
  `cif` bigint(20) DEFAULT NULL,
  `d_certificacion_carga_horaria` varchar(255) DEFAULT NULL,
  `d_convocatoria` varchar(255) DEFAULT NULL,
  `d_nota_atencion` varchar(255) DEFAULT NULL,
  `f_certificacion_carga_horaria` varchar(255) DEFAULT NULL,
  `f_convocatoria` varchar(255) DEFAULT NULL,
  `f_nota_atencion` varchar(255) DEFAULT NULL,
  `r_certificacion_carga_horaria` varchar(255) DEFAULT NULL,
  `r_convocatoria` varchar(255) DEFAULT NULL,
  `tramite_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `conv_doc_contratados`
--

CREATE TABLE `conv_doc_contratados` (
  `id` int(11) NOT NULL,
  `tramite_id` varchar(255) DEFAULT NULL,
  `cif` bigint(20) DEFAULT NULL,
  `d_certificacion_carga_horaria` varchar(255) DEFAULT NULL,
  `d_convocatoria` varchar(255) DEFAULT NULL,
  `d_nota_atencion` varchar(255) DEFAULT NULL,
  `c_certificacion_carga_horaria` varchar(255) DEFAULT NULL,
  `c_convocatoria` varchar(255) DEFAULT NULL,
  `c_nota_atencion` varchar(255) DEFAULT NULL,
  `f_certificacion_carga_horaria` varchar(255) DEFAULT NULL,
  `f_convocatoria` varchar(255) DEFAULT NULL,
  `f_nota_atencion` varchar(255) DEFAULT NULL,
  `r_certificacion_carga_horaria` varchar(255) DEFAULT NULL,
  `r_convocatoria` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `conv_doc_interinos`
--

CREATE TABLE `conv_doc_interinos` (
  `id` int(11) NOT NULL,
  `tramite_id` varchar(255) DEFAULT NULL,
  `cif` bigint(20) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `d_convocatoria` varchar(255) DEFAULT NULL,
  `d_certificacion_carga_horaria` varchar(255) DEFAULT NULL,
  `d_nota_atencion` varchar(255) DEFAULT NULL,
  `r_convocatoria` varchar(255) DEFAULT NULL,
  `r_certificacion_carga_horaria` varchar(255) DEFAULT NULL,
  `c_convocatoria` varchar(255) DEFAULT NULL,
  `c_certificacion_carga_horaria` varchar(255) DEFAULT NULL,
  `c_nota_atencion` varchar(255) DEFAULT NULL,
  `f_certificacion_carga_horaria` varchar(255) DEFAULT NULL,
  `f_convocatoria` varchar(255) DEFAULT NULL,
  `f_nota_atencion` varchar(255) DEFAULT NULL
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
  `d_solicitud_tribunal` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `f_proyecto_resolucion_tribunal` varchar(255) DEFAULT NULL,
  `f_resolucion_tribunal` varchar(255) DEFAULT NULL,
  `f_solicitud_tribunal` varchar(255) DEFAULT NULL
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
  `categoria_id` varchar(255) DEFAULT NULL,
  `procesocond_id` int(11) DEFAULT NULL,
  `habilitado` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `flujo`
--

INSERT INTO `flujo` (`id`, `flujo`, `proceso`, `proceso_sig`, `formulario`, `role_id`, `tiempo`, `categoria_id`, `procesocond_id`, `habilitado`) VALUES
(1, 'F1', 'P1', 'P2', 'INSCRIPCIONES DE ASIGNATURAS DE ALUMNOS LIBRES', 7, 12, 'AC', NULL, 'true'),
(2, 'F1', 'P2', 'P3', 'Deriva a URAF para la revisión y verificación', 3, 12, 'AC', NULL, NULL),
(3, 'F1', 'P3', NULL, 'Verificación de documentos', 4, 12, 'AC', 1, NULL),
(4, 'F1', 'P4', 'P5', 'Recepción de documentos', 3, 12, 'AC', NULL, NULL),
(5, 'F1', 'P5', 'P6', 'Revisa y aprueba', 11, 12, 'AC', NULL, NULL),
(6, 'F1', 'P6', 'P7', ' Emisión de la Resolución de alumno libre', 1, 12, 'AC', NULL, NULL),
(7, 'F1', 'P7', 'P8-Fin', 'Recibe resolución de alumno libre', 3, 12, 'AC', NULL, NULL),
(8, 'F1', 'P8-Fin', 'Fin', 'RESOLUCION DE ALUMNO LIBRE', 7, 12, 'AC', NULL, NULL),
(9, 'F1', 'P9', 'P3', 'Observado y corregir', 7, 12, 'AC', NULL, NULL),
(10, 'F2', 'P1', 'P2', 'INSCRIPCIÓN DE MATERIAS EXTRA', 7, 12, 'AC', NULL, 'true'),
(11, 'F2', 'P2', 'P3', 'Deriva a URAF para la revisión y verificación', 3, 12, 'AC', NULL, NULL),
(12, 'F2', 'P3', NULL, ' Verificación de prerrequisitos', 4, 12, 'AC', 2, NULL),
(13, 'F2', 'P4', 'P5', ' Emite aval para tomar materias extra', 11, 12, 'AC', NULL, NULL),
(14, 'F2', 'P5', 'P6-Fin', 'Notifica y comunica al estudiante', 3, 12, 'AC', NULL, NULL),
(15, 'F2', 'P6-Fin', 'Fin', 'INSCRIPCIÓN DE MATERIAS EXTRA', 7, 12, 'AC', NULL, NULL),
(16, 'F2', 'P7', 'P3', 'Observado y corregir', 7, 12, 'AC', NULL, NULL),
(17, 'F3', 'P1', 'P2', 'CONVALIDACIÓN DE MATERIAS DE PLAN A PLAN', 7, 12, 'AC', NULL, 'true'),
(18, 'F3', 'P2', 'P3', 'Remite a URAF para su verificacion', 3, 12, 'AC', NULL, NULL),
(19, 'F3', 'P3', NULL, 'Validación de documentos', 4, 12, 'AC', 3, NULL),
(20, 'F3', 'P4', 'P5', 'Verifica las materias que se pueden convalidar', 4, 12, 'AC', NULL, NULL),
(21, 'F3', 'P5', 'P6', 'Firma informe de convalidación', 3, 12, 'AC', NULL, NULL),
(22, 'F3', 'P6', 'P7', 'Revisa y aprueba la convalidación', 11, 12, 'AC', NULL, NULL),
(23, 'F3', 'P7', 'P8', 'Firma informe de convalidación', 2, 12, 'AC', NULL, NULL),
(24, 'F3', 'P8', 'P9-Fin', 'Revisión de firmas y migración de datos al sistema SSA', 4, 12, 'AC', NULL, NULL),
(25, 'F3', 'P9-Fin', 'Fin', 'CONVALIDACIÓN DE MATERIAS DE PLAN A PLAN', 7, 12, 'AC', NULL, NULL),
(26, 'F3', 'P10', 'P3', 'Correccion de errores', 7, 12, 'AC', NULL, NULL),
(27, 'F4', 'P1', 'P2', 'CONVALIDACIÓN  DE MATERIAS DE OTRAS CARRERAS', 7, 12, 'AC', NULL, 'true'),
(28, 'F4', 'P2', 'P3', 'Recepción y remite a URAF para su verificación', 3, 12, 'AC', NULL, NULL),
(29, 'F4', 'P3', NULL, 'Validación de documentos', 4, 12, 'AC', 4, NULL),
(30, 'F4', 'P4', 'P5', 'Revision y evaluación de documentos', 10, 12, 'AC', NULL, NULL),
(31, 'F4', 'P5', 'P6', 'Elaboración de proyecto de resolución', 3, 12, 'AC', NULL, NULL),
(32, 'F4', 'P6', NULL, 'Revisa y aprueba el proyecto de resolucion', 11, 12, 'AC', 5, NULL),
(33, 'F4', 'P7', 'P8', 'Trata y aprueba el proyecto de resolucion', 2, 12, 'AC', NULL, NULL),
(34, 'F4', 'P8', 'P9', 'Elaboración de Resolución de Convalidación', 1, 12, 'AC', NULL, NULL),
(35, 'F4', 'P9', 'P10-Fin', 'Recepción de Resolución de Convalidación', 3, 12, 'AC', NULL, NULL),
(36, 'F4', 'P10-Fin', 'Fin', 'CONVALIDACIÓN  DE MATERIAS DE OTRAS CARRERAS', 7, 12, 'AC', NULL, NULL),
(37, 'F4', 'P11', 'P3', 'Corrección de errores', 7, 12, 'AC', NULL, NULL),
(39, 'F5', 'P1', 'P2', 'CERTIFICADO ÚNICO DE CALIFICACIONES', 7, 12, 'AC', NULL, 'true'),
(40, 'F5', 'P2', 'P3', 'Llenado del Certificado', 4, 12, 'AC', NULL, NULL),
(41, 'F5', 'P3', 'P4', 'Firma el Certificado', 3, 12, 'AC', NULL, NULL),
(42, 'F5', 'P4', 'P5', 'Firma el Certificado', 1, 12, 'AC', NULL, NULL),
(43, 'F5', 'P5', 'P6-Fin', 'Verificación de firmas', 4, 12, 'AC', NULL, NULL),
(44, 'F5', 'P6-Fin', 'Fin', 'CERTIFICADO ÚNICO DE CALIFICACIONES', 7, 12, 'AC', NULL, NULL),
(45, 'F6', 'P1', 'P2', 'CERTIFICADO DE CONCLUSIÓN DE ESTUDIOS', 7, 12, 'AC', NULL, 'true'),
(46, 'F6', 'P2', NULL, 'Validación de documentos', 4, 12, 'AC', 6, NULL),
(47, 'F6', 'P3', 'P4', 'Llenado de Cerrtificado', 4, 12, 'AC', NULL, NULL),
(48, 'F6', 'P4', 'P5', 'Firma el Certificado', 3, 12, 'AC', NULL, NULL),
(49, 'F6', 'P5', 'P6', 'Firma el Certificado', 1, 12, 'AC', NULL, NULL),
(50, 'F6', 'P6', 'P7-Fin', 'Verificacion de firmas', 4, 12, 'AC', NULL, NULL),
(51, 'F6', 'P7-Fin', 'Fin', 'CERTIFICADO DE CONCLUSIÓN DE ESTUDIOS', 7, 12, 'AC', NULL, NULL),
(52, 'F6', 'P8', 'P2', 'Correccion de documentos', 7, 12, 'AC', NULL, NULL),
(53, 'F7', 'P1', 'P2', 'CONVOCATORIA DE CONCURSO DE MERITOS PARA DOCENTES INTERINOS', 3, 12, 'AC', NULL, 'true'),
(54, 'F7', 'P2', 'P3', 'Emite certificación carga horaria', 14, 12, 'AC', NULL, NULL),
(55, 'F7', 'P3', 'P4', 'Remite tramite mas la convocatoria a CC', 3, 12, 'AC', NULL, NULL),
(56, 'F7', 'P4', NULL, 'Aprueba la emisión de convocatoria', 11, 12, 'AC', 7, NULL),
(57, 'F7', 'P5', 'P6', 'Trata y aprueba la emisión de convocatoria', 2, 12, 'AC', NULL, NULL),
(58, 'F7', 'P6', 'P7', 'Homologa la Resolución ', 1, 12, 'AC', NULL, NULL),
(59, 'F7', 'P7', 'P8', 'Remite a secretaria de vicerrectorado', 3, 12, 'AC', NULL, NULL),
(60, 'F7', 'P8', NULL, 'SECRETARIA VICERRECTORADO', 13, 12, 'AC', 8, NULL),
(61, 'F7', 'P9', 'P10', 'Firma la Convocatoria', 3, 12, 'AC', NULL, NULL),
(62, 'F7', 'P10', 'P11', 'Firma la Convocatoria', 1, 12, 'AC', NULL, NULL),
(63, 'F7', 'P11', 'P12-Fin', 'Firma la Convocatoria', 13, 12, 'AC', NULL, NULL),
(64, 'F7', 'P12-Fin', 'Fin', 'Publicar: CONVOCATORIA DE CONCURSO DE MERITOS PARA DOCENTES INTERINOS', 3, 12, 'AC', NULL, NULL),
(65, 'F7', 'P13', 'P8', 'Subsana  observaciones de la convocatoria y ajuste de fechas', 3, 12, 'AC', NULL, NULL),
(66, 'F8', 'P1', 'P2', 'DESIGNACIÓN COMISION EVALUADORA DE DOCENTES INTERINOS', 3, 12, 'AC', NULL, 'false'),
(67, 'F8', 'P2', 'P3', 'Lista de mejores estudiantes', 4, 12, 'AC', NULL, NULL),
(68, 'F8', 'P3', 'P4', 'Designación de docentes y estudiantes', 3, 12, 'AC', NULL, NULL),
(69, 'F8', 'P4', NULL, 'Aprobación de la designación de comisión evaluadora', 11, 12, 'AC', 9, NULL),
(70, 'F8', 'P5', 'P6', 'Trata y aprueba la designación', 2, 12, 'AC', NULL, NULL),
(71, 'F8', 'P6', 'P7-Fin', 'Realiza la Resolución ', 1, 12, 'AC', NULL, NULL),
(72, 'F8', 'P7-Fin', 'Fin', 'Publica: COMISION EVALUADORA DE DOCENTES INTERINOS', 3, 12, 'AC', NULL, NULL),
(73, 'F9', 'P1', 'P2', 'CONCURSO DE MERITOS DE DOCENTES INTERINOS', 6, 12, 'AC', NULL, 'false'),
(74, 'F9', 'P2', 'P3', 'Remite con Nota los files presentados a las carreras', 2, 12, 'AC', NULL, NULL),
(75, 'F9', 'P3', 'P4', 'Recibe y remite a la Comisión para revisión de documentos', 3, 12, 'AC', NULL, NULL),
(76, 'F9', 'P4', 'P5', 'Revisa y evalúa los documentos presentados', 16, 12, 'AC', NULL, NULL),
(77, 'F9', 'P5', 'P6', 'Establece tiempo de impugnación', 3, 12, 'AC', NULL, NULL),
(78, 'F9', 'P6', 'P7-Fin', 'Recibe impugnaciones de Docentes', 10, 12, 'AC', NULL, NULL),
(79, 'F9', 'P7-Fin', ' in', 'Publicación de Resusltados: CONCURSO DE MERITOS DE DOCENTES INTERINOS', 3, 12, 'AC', NULL, NULL),
(80, 'F10', 'P1', 'P2', 'DESIGNACION DE DOCENTES INTERINOS', 3, 12, 'AC', NULL, 'false'),
(81, 'F10', 'P2', 'P3', 'Adjunta documentos complementarios', 6, 12, 'AC', NULL, NULL),
(82, 'F10', 'P3', 'P4', 'Prepara proyecto de Resolucion', 3, 12, 'AC', NULL, NULL),
(83, 'F10', 'P4', 'P5', 'Revisa y deriva la designación del personal docente', 11, 12, 'AC', 10, NULL),
(84, 'F10', 'P5', 'P6', 'Trata y aprueba la Designación del Docente', 2, 12, 'AC', 10, NULL),
(85, 'F10', 'P6', 'P7-Fin', 'Elabora la resolución de Designación Docente', 1, 12, 'AC', 10, NULL),
(86, 'F10', 'P7-Fin', 'Fin', 'Recibe y remite a PERSONAL DOCENTE', 3, 12, 'AC', 10, NULL),
(87, 'F11', 'P1', 'P2', 'DESIGNACIÓN DE DOCENTES INVITADOS', 3, 12, 'AC', NULL, 'false'),
(88, 'F11', 'P2', 'P3', 'Acepta invitación y carga los Documentos solicitados', 6, 12, 'AC', NULL, NULL),
(89, 'F11', 'P3', 'P4', 'Prepara proyecto de Resolución', 3, 12, 'AC', NULL, NULL),
(90, 'F11', 'P4', 'P5', 'Revisa y deriva la Designación del Docente', 11, 12, 'AC', NULL, NULL),
(91, 'F11', 'P5', 'P6', 'Trata y aprueba la Designación del Docente', 2, 12, 'AC', NULL, 'true'),
(92, 'F11', 'P6', 'P7-Fin', 'Elabora la Resolución de Designación Docente', 1, 12, 'AC', 11, NULL),
(93, 'F11', 'P7-Fin', 'Fin', 'Recibe y remite a PERSONAL DOCENTE', 3, 12, 'AC', NULL, NULL),
(94, 'F12', 'P1', 'P2', 'CONVOCATORIA DE CONCURSO DE MERITOS PARA DOCENTES CONTRATADOS', 3, 12, 'AC', NULL, 'true'),
(95, 'F12', 'P2', 'P3', 'Emite certificación carga horaria', 14, 12, 'AC', NULL, NULL),
(96, 'F12', 'P3', 'P4', 'Elabora convocatoria de acuerto a Resolución HCU ', 3, 12, 'AC', NULL, NULL),
(97, 'F12', 'P4', NULL, 'Aprueba la emisión de convocatoria', 11, 12, 'AC', 10, NULL),
(98, 'F12', 'P5', 'P6', 'Trata y aprueba la emisión de convocatoria', 2, 12, 'AC', NULL, NULL),
(99, 'F12', 'P6', 'P7', 'Homologa la Resolución ', 1, 12, 'AC', NULL, NULL),
(100, 'F12', 'P7', 'P8', 'Remite a secretaria de vicerrectorado', 3, 12, 'AC', NULL, NULL),
(101, 'F12', 'P8', NULL, 'SECRETARIA VICERRECTORADO', 13, 12, 'AC', 11, NULL),
(102, 'F12', 'P9', 'P10', 'Firma la Convocatoria', 3, 12, 'AC', NULL, NULL),
(103, 'F12', 'P10', 'P11', 'Firma la Convocatoria', 1, 12, 'AC', NULL, NULL),
(104, 'F12', 'P11', 'P12-Fin', 'Firma la Convocatoria', 13, 12, 'AC', NULL, NULL),
(105, 'F12', 'P12-Fin', 'Fin', 'Publicar: CONVOCATORIA DE CONCURSO DE MERITOS PARA DOCENTES INTERINOS', 3, 12, 'AC', NULL, NULL),
(106, 'F12', 'P13', 'P8', 'Subsana  observaciones de la convocatoria y ajuste de fechas', 3, 12, 'AC', NULL, NULL),
(107, 'F13', 'P1', 'P2', 'DESIGNACIÓN DE DOCENTES CONTRATADOS PARA PASAR A CATEGORIA TITULAR (pendiente)', 3, 12, 'AC', NULL, 'false'),
(108, 'F13', '', '', '', NULL, 12, 'AC', NULL, NULL),
(109, 'F13', '', '', '', NULL, 12, 'AC', NULL, NULL),
(110, 'F13', '', '', '', NULL, 12, 'AC', NULL, NULL),
(111, 'F13', '', '', '', NULL, 12, 'AC', NULL, NULL),
(112, 'F13', '', '', '', NULL, 12, 'AC', NULL, NULL),
(113, 'F13', '', '', '', NULL, 12, 'AC', NULL, NULL),
(114, 'F13', '', '', '', NULL, 12, 'AC', NULL, NULL),
(115, 'F13', '', '', '', NULL, 12, 'AC', NULL, NULL),
(116, 'F13', '', '', '', NULL, 12, 'AC', NULL, NULL),
(117, 'F13', '', '', '', NULL, 12, 'AC', NULL, NULL),
(118, 'F13', '', '', '', NULL, 12, 'AC', NULL, NULL),
(119, 'F14', 'P1', 'P2', 'CONVOCATORIA AUXILIARES DE DOCENCIA', 3, 12, 'AC', NULL, 'true'),
(120, 'F14', 'P2', 'P3', 'Emite la Certificacion de carga horaria', 15, 12, 'AC', NULL, NULL),
(121, 'F14', 'P3', 'P4', 'Proyecto de Resolución', 3, 12, 'AC', NULL, NULL),
(122, 'F14', 'P4', NULL, 'Revisa y aprueba la convocatoria', 11, 12, 'AC', 12, NULL),
(123, 'F14', 'P5', 'P6', 'Trata y aprueba la convocatoria', 2, 12, 'AC', NULL, NULL),
(124, 'F14', 'P6', 'P7', 'Realiza la Resolución', 1, 12, 'AC', NULL, NULL),
(125, 'F14', 'P7', 'P8', 'Verificación y Remitir a bienestar social', 3, 12, 'AC', 13, NULL),
(126, 'F14', 'P8', 'P9', 'Firma de bienestar social', 15, 12, 'AC', NULL, NULL),
(127, 'F14', 'P9', 'P10-Fin', 'Firma de Vicerrectorado', 13, 12, 'AC', NULL, NULL),
(128, 'F14', 'P10-Fin', 'Fin', 'Publica: CONVOCATORIA AUXILIARES DE DOCENCIA', 3, 12, 'AC', NULL, NULL),
(129, 'F15', 'P1', 'P2', 'DESIGNACIÓN COMISION DE EVALUACIÓN DE AUXILIARES DE DOCENCIA', 3, 12, 'AC', NULL, 'false'),
(130, 'F15', 'P2', 'P3', 'Lista de mejores estudiantes', 4, 12, 'AC', NULL, NULL),
(131, 'F15', 'P3', 'P4', 'Designación de docentes y estudiantes', 3, 12, 'AC', NULL, NULL),
(132, 'F15', 'P4', NULL, 'Aprobación de la designación de comisión evaluadora', 11, 12, 'AC', 13, NULL),
(133, 'F15', 'P5', 'P6', 'Trata y aprueba la designación', 2, 12, 'AC', NULL, NULL),
(134, 'F15', 'P6', 'P7-Fin', 'Realiza la Resolución ', 1, 12, 'AC', NULL, NULL),
(135, 'F15', 'P7-Fin', 'Fin', 'Publica: COMISION DE EVALUACIÓN DE AUXILIARES DE DOCENCIA', 3, 12, 'AC', NULL, NULL),
(136, 'F16', 'P1', 'P2', 'CONCURSO DE MERITOS AUXILIARES DE DOCENCIA', 7, 12, 'AC', NULL, 'false'),
(137, 'F16', 'P2', 'P3', 'Remite con Nota los files presentados a las carreras', 2, 12, 'AC', NULL, NULL),
(138, 'F16', 'P3', 'P4', 'Recibe y remite a la Comisión para revisión de documentos', 3, 12, 'AC', NULL, NULL),
(139, 'F16', 'P4', 'P5', 'Revisa y evalúa los documentos presentados', 17, 12, 'AC', NULL, NULL),
(140, 'F16', 'P5', 'P6', 'Establece tiempo de impugnación', 3, 12, 'AC', NULL, NULL),
(141, 'F16', 'P6', 'P7-Fin', 'Recibe impugnaciones de Docentes', 10, 12, 'AC', NULL, NULL),
(142, 'F16', 'P7-Fin', ' in', 'Publicación de Resusltados: CONCURSO DE MERITOS DE DOCENTES INTERINOS', 3, 12, 'AC', NULL, NULL),
(143, 'F17', 'P1', 'P2', 'DESIGNACION DE AUXILIARES DE DOCENCIA', 3, 12, 'AC', NULL, 'false'),
(144, 'F17', 'P2', 'P3', 'Adjunta documentos complementarios', 7, 12, 'AC', NULL, NULL),
(145, 'F17', 'P3', 'P4', 'Prepara proyecto de Resolucion', 3, 12, 'AC', NULL, NULL),
(146, 'F17', 'P4', 'P5', 'Revisa y deriva la designación del Estudiante', 11, 12, 'AC', 10, NULL),
(147, 'F17', 'P5', 'P6', 'Trata y aprueba la Designación del Estudiante', 2, 12, 'AC', 10, NULL),
(148, 'F17', 'P6', 'P7-Fin', 'Elabora la resolución de Designación del Estudiante', 1, 12, 'AC', 10, NULL),
(149, 'F17', 'P7-Fin', 'Fin', 'Recibe y remite a BIENESTAR SOCIAL', 3, 12, 'AC', 10, NULL),
(150, 'F18', 'P1', 'P2', 'DESIGNACIÓN DE AUXILIARES DE DOCENCIA POR INVITACIÓN', 3, 12, 'AC', NULL, 'false'),
(151, 'F18', 'P2', 'P3', 'Envía el listado de estudiantes con promedios altos', 4, 12, 'AC', NULL, NULL),
(152, 'F18', 'P3', 'P4', 'Selecciona al estudiante con mayor promedio', 3, 12, 'AC', NULL, NULL),
(153, 'F18', 'P4', NULL, 'Invitacion a auxiliar de Docencia', 7, 12, 'AC', 14, NULL),
(154, 'F18', 'P5', 'P6', 'Elabora el proyecto de Resolución de designación', 3, 12, 'AC', NULL, 'true'),
(155, 'F18', 'P6', 'P7', 'Revisa y deriva la Designación del Estudiante', 11, 12, 'AC', NULL, 'true'),
(156, 'F18', 'P7', 'P8', 'Trata y aprueba la designación del Estudiante', 2, 12, 'AC', NULL, 'true'),
(157, 'F18', 'P8', 'P9-Fin', 'Resolución de Designación del estudiante invitado', 1, 12, 'AC', 11, NULL),
(158, 'F18', 'P9-Fin', 'Fin', 'Recibe y remite a BIENESTAR SOCIAL', 3, 12, 'AC', NULL, NULL),
(159, 'F18', 'P10-Fin', 'Fin', 'Invitación rechazada', 3, 12, 'AC', NULL, NULL),
(160, 'F19', 'P1', 'P2', 'APROBACIÓN DE PERFIL DE GRADO', 7, 12, 'AC', NULL, 'true'),
(161, 'F19', 'P2', 'P3', 'Recepción de documentos', 3, 12, 'AC', NULL, NULL),
(162, 'F19', 'P3', NULL, 'Aprobación de la solicitud de Perfil de Grado', 11, 12, 'AC', 15, NULL),
(163, 'F19', 'P4', 'P5', 'Elaboración de Proyecto de Resolución y nota de atencion a la solicitud de Perfil de Grado', 3, 12, 'AC', NULL, NULL),
(164, 'F19', 'P5', 'P6', 'Aprobación de la solicitud de Perfil de Grado', 2, 12, 'AC', NULL, NULL),
(165, 'F19', 'P6', 'P7', 'Elaboración de Resolución a la solicitud de Perfil de Grado', 1, 12, 'AC', NULL, NULL),
(166, 'F19', 'P7', 'P8-Fin', 'Recepción y entrega de Resolución de Perfil de Grado al Estudiante', 3, 12, 'AC', NULL, NULL),
(167, 'F19', 'P8-Fin', 'P10', 'RESOLUCIÓN DE PERFIL DE GRADO', 7, 12, 'AC', NULL, NULL),
(168, 'F19', 'P9', 'P3', 'Corrección de errores', 7, 12, 'AC', NULL, NULL),
(169, 'F20', 'P1', 'P2', 'DESIGNACIÓN DE TRIBUNAL REVISOR DE GRADO', 7, 12, 'AC', NULL, 'true'),
(170, 'F20', 'P2', 'P3', 'Recepción de documentos', 3, 12, 'AC', NULL, NULL),
(171, 'F20', 'P3', NULL, 'Aprobación del Trabajo de Grado', 11, 12, 'AC', 16, NULL),
(172, 'F20', 'P4', 'P5', 'Elaboración de Proyecto de Resolución y nota de atencion a la solicitud de Designacion de Tribunal de Grado', 3, 12, 'AC', NULL, NULL),
(173, 'F20', 'P5', 'P6', 'Aprobación del Trabajo de Grado', 2, 12, 'AC', NULL, NULL),
(174, 'F20', 'P6', 'P7', 'Elaboración de Resolución de Designación de Tribunal de Grado', 1, 12, 'AC', NULL, NULL),
(175, 'F20', 'P7', 'P8-Fin', 'Recepción y entrega de Resolución de Tibunal de Grado al Estudiante', 3, 12, 'AC', NULL, NULL),
(176, 'F20', 'P8-Fin', 'P10', 'RESOLUCIÓN DE DESIGNACIÓN DE TRIBUNAL REVISOR DE GRADO', 7, 12, 'AC', NULL, NULL),
(177, 'F20', 'P9', 'P3', 'Corrección de errores', 7, 12, 'AC', NULL, NULL),
(178, 'F21', 'P1', 'P2', 'CAMBIO DE MODALIDAD, TITULO o TUTOR DE GRADO', 7, 12, 'AC', NULL, 'true'),
(179, 'F21', 'P2', 'P3', 'Recepción de documentos', 3, 12, 'AC', NULL, NULL),
(180, 'F21', 'P3', NULL, 'Aprobación del Cambio de Modalidad de Graduación', 11, 12, 'AC', 17, NULL),
(181, 'F21', 'P4', 'P5', 'Elaboración de Proyecto de Resolución y nota de atencion a la solicitud de Cambio de Modalidad de Graduación', 3, 12, 'AC', NULL, NULL),
(182, 'F21', 'P5', 'P6', 'Aprobación del Cambio de Modalidad de Graduación', 2, 12, 'AC', NULL, NULL),
(183, 'F21', 'P6', 'P7', 'Anular y Elaborar la Resolución de Perfil de Grado por Cambio de Modalidad de Graduación', 1, 12, 'AC', NULL, NULL),
(184, 'F21', 'P7', 'P8-Fin', 'Recepción y entrega de la Nueva Resolución de Perfil de Grado al Estudiante', 3, 12, 'AC', NULL, NULL),
(185, 'F21', 'P8-Fin', 'P10', 'CAMBIO DE MODALIDAD, TITULO o TUTOR DE GRADO', 7, 12, 'AC', NULL, NULL),
(186, 'F21', 'P9', 'P3', 'Corrección de errores', 7, 12, 'AC', NULL, NULL);

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
  `tramite_id` varchar(255) DEFAULT NULL,
  `f_aval` varchar(255) DEFAULT NULL
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
  `no` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `procesocond`
--

INSERT INTO `procesocond` (`id`, `flujo`, `proceso`, `si`, `no`) VALUES
(1, 'F1', 'P3', 'P4', 'P9'),
(2, 'F2', 'P3', 'P4', 'P7'),
(3, 'F3', 'P3', 'P4', 'P10'),
(4, 'F4', 'P3', 'P4', 'P11'),
(5, 'F4', 'P6', 'P7', 'P5'),
(6, 'F6', 'P2', 'P3', 'P8'),
(7, 'F7', 'P4', 'P5', 'P3'),
(8, 'F7', 'P7', 'P9', 'P13'),
(9, 'F8', 'P4', 'P5', 'P3'),
(10, 'F12', 'P4', 'P5', 'P3'),
(11, 'F12', 'P7', 'P9', 'P13'),
(12, 'F14', 'P4', 'P5', 'P3'),
(13, 'F15', 'P4', 'P5', 'P3'),
(14, 'F18', 'P4', 'P5', 'P10-Fin'),
(15, 'F19', 'P3', 'P4', 'P9'),
(16, 'F20', 'P3', 'P4', 'P9'),
(17, 'F21', 'P3', 'P4', 'P9');

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
(10, 'COMISION_CONVALIDACION', 'CCV'),
(11, 'CONSEJO_CARRERA', 'CC'),
(12, 'ADMINISTRADOR', NULL),
(13, 'VICERRECTORADO', NULL),
(14, 'PERSONAL_DOCENTE', 'PD'),
(15, 'BIENESTAR_SOCIAL', 'BS'),
(16, 'COMISION_EVALUACION_DOCENTE', 'CED'),
(17, 'COMISION_EVALUACION_ESTUDIANTE', 'CEE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seguimiento`
--

CREATE TABLE `seguimiento` (
  `id` int(11) NOT NULL,
  `tramite_id` varchar(255) DEFAULT NULL,
  `flujo_id` int(11) DEFAULT NULL,
  `usuario_rol_id` int(11) DEFAULT NULL,
  `fecha_fin` datetime(6) DEFAULT NULL,
  `fecha_inicio` datetime(6) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `comentario` varchar(255) DEFAULT NULL,
  `tiempo` datetime(6) DEFAULT NULL,
  `visto` varchar(6) DEFAULT 'false'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tramite`
--

CREATE TABLE `tramite` (
  `id` varchar(255) NOT NULL,
  `carrera` varchar(255) DEFAULT NULL,
  `creacion` datetime(6) DEFAULT NULL,
  `estado` varchar(50) DEFAULT 'pendiente',
  `flujo` varchar(255) DEFAULT NULL,
  `proceso` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Disparadores `tramite`
--
DELIMITER $$
CREATE TRIGGER `generate_tramite_id` BEFORE INSERT ON `tramite` FOR EACH ROW BEGIN
    DECLARE new_numero INT;

     -- Obtener el siguiente número correlativo para la carrera
    SELECT secuencia + 1 INTO new_numero FROM unidad WHERE id = NEW.carrera;

    -- Actualizar la secuencia en la tabla UNIDAD
    UPDATE unidad SET secuencia = new_numero WHERE id = NEW.carrera;

    -- Construir el nuevo ID
    SET NEW.id = CONCAT('FHCE-', NEW.carrera, '-', new_numero);
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
('CE', 'CIENCIAS EDUCACION', 0),
('CI', 'CIENCIAS INFORMACION', 0),
('CN', 'CINE', 0),
('FHCE', 'FACULTATIVO', 0),
('FIL', 'FILOSOFIA', 0),
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
(7, '$2a$10$qVjwTo0DNxV3/tzUgwsGgeNsvzgzoHMuP1joaMtEAbM/ZaWCl3Eai', 'estudiante1', NULL),
(8, '$2a$10$rCggV2vGw1.DtqUND9y.fOBr3J4m0jajQP5p9LhwkgvuKh0p87nKe', 'estudiante2', NULL),
(13, '$2a$10$0.E8FUfb.zqUK4vRNvaeX.T4cN6j5HWOgDGs.ckG3MCSUF7cHrx8q', 'comision', NULL),
(14, '$2a$10$0.E8FUfb.zqUK4vRNvaeX.T4cN6j5HWOgDGs.ckG3MCSUF7cHrx8q', 'consejocarrera', NULL),
(15, '$2a$10$0.E8FUfb.zqUK4vRNvaeX.T4cN6j5HWOgDGs.ckG3MCSUF7cHrx8q', 'kardexHis', NULL),
(16, '$2a$10$0.E8FUfb.zqUK4vRNvaeX.T4cN6j5HWOgDGs.ckG3MCSUF7cHrx8q', 'admin', NULL),
(17, '$2a$10$0.E8FUfb.zqUK4vRNvaeX.T4cN6j5HWOgDGs.ckG3MCSUF7cHrx8q', 'vicerrectorado', NULL),
(23, '$2a$10$PuhZDTAarRat9Qc4rHywRObUJhKLWG1IPxtlFgvlGFN/W.IOMbj0a', 'abraham', '22205200202'),
(25, '$2a$10$XGYkQNpZvq3ee9BIOEKEi.QglqjIpV9mBEf75LpkYZcRtmxWARL0m', 'docente', '22409200800'),
(26, '$2a$10$kz5Ed/EgLi0V7c1bXfolgeLq5eH8oYx5AQMQYK.8wBMTir15bgvc6', 'personaldocente', '22409200801'),
(27, '$2a$10$X0/T2BUVKhFehIlIim2rNOrO1vs0W4x3npyVF4vi4aWzzYDCQwSsq', 'bienestarsocial', '22409200802'),
(28, '$2a$10$aZKbCyDy6Kp1xXlotnLa.eswdJaPXNJyHX2Rq4YgiYKWGNk7cUK5.', 'comisiondocente', '22409200803'),
(29, '$2a$10$zvb.7T8UVWnMFqH75kCe.eJA2Om2D.XJiqY.5Pz3V4fTKy.sD6w7a', 'comisionestudiante', '22409200804'),
(30, '$2a$10$NvwgcvJckzDqUwXl0UMnVeNKhYgG.QGgnKushgh4AjL7ckzR2IZBi', 'estudiante3', '22409200805'),
(31, '$2a$10$Rd1.M1.F2h7aNKbFJRnsaudDmzzlzXt7VHyMClzUsRKSAHebUt1LG', 'estudiante4', '22409200806'),
(32, '$2a$10$5tZLA2UuqV9.DF/CFSzjLe5xGW7A67nLXtL9L4114rhJOAPP1sFnO', 'estudiante5', '22409200807'),
(33, '$2a$10$Zzxg6STDmSo9EI3/k3k1Qu3YiNilep6XEavUIsFATL1C6b29b9FMe', 'estudiante6', '22409200808'),
(34, '$2a$10$FqiPQoKax7MOrpKpJmtbQ.kwt.24HHMSm8PubAY3d1CgZlliHn3Ta', 'estudiante7', '22409200809'),
(35, '$2a$10$T88LIRqw6sHIpWzsFcFGzuQmpOIGnpE2Y.jaIHR6G5u7xa.NIlJga', 'estudiante8', '22409200810'),
(36, '$2a$10$uU9W9vdjJ8rBF9RdMc/xge1o7Cy1FEGsmEg1n68yvlg0EgzqvCU2u', 'estudiante9', '22409200811'),
(37, '$2a$10$hM0GyaGYcl1AgzKQVs6UOOdZ8cFif8mwu9X6edf5ev.qYlK7R5cGO', 'estudiante10', '22409200812'),
(38, '$2a$10$RnJR3yZr1KLMKqzfqGxwveWl0SRQwuzXhCamBxdPhxtz7O6Jjcsre', 'estudiante11', '22409200813'),
(39, '$2a$10$bUcniZ5M45v5.TPF27t8AOWDNA7bIhFwKuOtiugvmKM65X5tMGucO', 'estudiante12', '22409200814'),
(40, '$2a$10$bfFVPZU.y4DpLHM/bIP0quNKWc9AzyLCPyiD7T57otmKCVblUUL/G', 'estudiante13', '22409200815'),
(41, '$2a$10$.5LuTyOkLDGQ3P0RCplXD.UrrnefJI0J7IpqT12FlfV2E4oM1do26', 'estudiante14', '22409200816'),
(42, '$2a$10$2bLAYVGELgFxkl/mA7grl.oNXKoOj5.JTWwiDlTHrNRrHRDXJ.gii', 'estudiante15', '22409200817'),
(43, '$2a$10$U.uzEK5vG4SxPyj.lFlSHOtvdJyoizjQSrKaX5FM882W3nvH8w6Mu', 'estudiante16', '22409200818'),
(44, '$2a$10$Y98ENbhzB5cQBJKag6jk8eboDQxNW1ncjL9zOqcLg7SJRzySp/ipi', 'estudiante17', '22409200819'),
(45, '$2a$10$gG761hlveC4fWiQnxJ9sGer7YZIuss.NBsU2xVQcl1NYXV0q7F6.6', 'estudiante18', '22409200820'),
(46, '$2a$10$7dbSgyz5wiDXO5N5vWxmRepaNfu2RsTfwCw7jrkEYB08SGGpT1izq', 'estudiante19', '22409200821'),
(47, '$2a$10$yU6N8TPL/1KHsrHaPZUIwOX7Zg8PHL3L06Rfa7CVZpQi56n4ckOhe', 'estudiante20', '22409200822'),
(48, '$2a$10$Jz.3xH/wD78VXP5w2lBs.e61SiHzJv7fyI4pgQGkRwbjhuqj6dS9S', 'estudiante21', '22409200823'),
(49, '$2a$10$1neTf4hjvdNpAToQX.vXXep6z4ENCPqSW3K5Zn2chpqa0wypjpnEW', 'estudiante22', '22409200824'),
(50, '$2a$10$qDDJHYRMJ8Rcxm/6/zSsEe0fnAi7/liAfvGbdsGcBre2YgRVx2l4S', 'estudiante23', '22409200825');

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
(3, 3, 3, 'CI'),
(4, 4, 4, 'CI'),
(6, 7, 7, 'CI'),
(7, 7, 8, 'CI'),
(8, 5, 5, 'CI'),
(9, 10, 13, 'CI'),
(10, 11, 14, 'CI'),
(11, 4, 15, 'HIS'),
(12, 12, 16, 'FHCE'),
(13, 13, 17, 'FHCE'),
(16, 7, 23, 'HIS'),
(18, 6, 25, 'CI'),
(19, 14, 26, 'FHCE'),
(20, 15, 27, 'FHCE'),
(21, 16, 28, 'CI'),
(22, 17, 29, 'CI'),
(23, 7, 30, 'CI'),
(24, 7, 31, 'CI'),
(25, 7, 32, 'CI'),
(26, 7, 33, 'CI'),
(27, 7, 34, 'CI'),
(28, 7, 35, 'CI'),
(29, 7, 36, 'CI'),
(30, 7, 37, 'CI'),
(31, 7, 38, 'CI'),
(32, 7, 39, 'CI'),
(33, 7, 40, 'CI'),
(34, 7, 41, 'CI'),
(35, 7, 42, 'CI'),
(36, 7, 43, 'CI'),
(37, 7, 44, 'CI'),
(38, 7, 45, 'CI'),
(39, 7, 46, 'CI'),
(40, 7, 47, 'CI'),
(41, 7, 48, 'CI'),
(42, 7, 49, 'CI'),
(43, 7, 50, 'CI');

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
-- Indices de la tabla `conv_aux_docencia`
--
ALTER TABLE `conv_aux_docencia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3e8jp00wiuakyutg6a3vohh0l` (`tramite_id`);

--
-- Indices de la tabla `conv_doc_contratados`
--
ALTER TABLE `conv_doc_contratados`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3aasn7ucav5kjq8c17epc669w` (`tramite_id`);

--
-- Indices de la tabla `conv_doc_interinos`
--
ALTER TABLE `conv_doc_interinos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK15xubqy3e4og2fcjqflxg1o0g` (`tramite_id`);

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
  ADD KEY `FKgepa53lh0p2y3c4a2m5cn1ri` (`categoria_id`),
  ADD KEY `FK19icaga8qsyello6sylmv7ecy` (`procesocond_id`);

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
  ADD PRIMARY KEY (`id`);

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
  ADD KEY `FKrad87cfwfv0v2irva16p2u401` (`tramite_id`),
  ADD KEY `FKg9jkiyw7cqa0wwc1ru67ragrg` (`usuario_rol_id`),
  ADD KEY `FKsmmhqyj7mgc4rgs1q6xcbi9u1` (`flujo_id`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16228;

--
-- AUTO_INCREMENT de la tabla `certificado_conclusion`
--
ALTER TABLE `certificado_conclusion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `certificado_unico`
--
ALTER TABLE `certificado_unico`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `concurso_doc_interinos`
--
ALTER TABLE `concurso_doc_interinos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `convalidacion_01`
--
ALTER TABLE `convalidacion_01`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `convalidacion_02`
--
ALTER TABLE `convalidacion_02`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `conv_aux_docencia`
--
ALTER TABLE `conv_aux_docencia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `conv_doc_contratados`
--
ALTER TABLE `conv_doc_contratados`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `conv_doc_interinos`
--
ALTER TABLE `conv_doc_interinos`
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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=187;

--
-- AUTO_INCREMENT de la tabla `materia_extra`
--
ALTER TABLE `materia_extra`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `procesocond`
--
ALTER TABLE `procesocond`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `seguimiento`
--
ALTER TABLE `seguimiento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT de la tabla `user_role`
--
ALTER TABLE `user_role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

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
-- Filtros para la tabla `conv_aux_docencia`
--
ALTER TABLE `conv_aux_docencia`
  ADD CONSTRAINT `FK3e8jp00wiuakyutg6a3vohh0l` FOREIGN KEY (`tramite_id`) REFERENCES `tramite` (`id`);

--
-- Filtros para la tabla `conv_doc_contratados`
--
ALTER TABLE `conv_doc_contratados`
  ADD CONSTRAINT `FK3aasn7ucav5kjq8c17epc669w` FOREIGN KEY (`tramite_id`) REFERENCES `tramite` (`id`);

--
-- Filtros para la tabla `conv_doc_interinos`
--
ALTER TABLE `conv_doc_interinos`
  ADD CONSTRAINT `FK15xubqy3e4og2fcjqflxg1o0g` FOREIGN KEY (`tramite_id`) REFERENCES `tramite` (`id`);

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
  ADD CONSTRAINT `FK19icaga8qsyello6sylmv7ecy` FOREIGN KEY (`procesocond_id`) REFERENCES `procesocond` (`id`),
  ADD CONSTRAINT `FKgepa53lh0p2y3c4a2m5cn1ri` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`),
  ADD CONSTRAINT `FKhv71llqfjqtg38cwhi5w7yypr` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);

--
-- Filtros para la tabla `materia_extra`
--
ALTER TABLE `materia_extra`
  ADD CONSTRAINT `FK3e70jaq9nxb3a0ku0u3n88ik2` FOREIGN KEY (`tramite_id`) REFERENCES `tramite` (`id`);

--
-- Filtros para la tabla `seguimiento`
--
ALTER TABLE `seguimiento`
  ADD CONSTRAINT `FKg9jkiyw7cqa0wwc1ru67ragrg` FOREIGN KEY (`usuario_rol_id`) REFERENCES `user_role` (`id`),
  ADD CONSTRAINT `FKrad87cfwfv0v2irva16p2u401` FOREIGN KEY (`tramite_id`) REFERENCES `tramite` (`id`),
  ADD CONSTRAINT `FKsmmhqyj7mgc4rgs1q6xcbi9u1` FOREIGN KEY (`flujo_id`) REFERENCES `flujo` (`id`);

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
