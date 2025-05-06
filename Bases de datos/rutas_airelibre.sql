-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema rutas_airelibre
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema rutas_airelibre
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `rutas_airelibre` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `rutas_airelibre` ;

-- -----------------------------------------------------
-- Table `rutas_airelibre`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rutas_airelibre`.`usuarios` (
  `cod_usu` INT NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `nombre` VARCHAR(25) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  `fecha_nac` DATE NOT NULL,
  `rol` ENUM('administrador', 'diseñador', 'profesor', 'alumno', 'usuario_registrado') NOT NULL,
  `validado` TINYINT NOT NULL,
  PRIMARY KEY (`cod_usu`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rutas_airelibre`.`rutas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rutas_airelibre`.`rutas` (
  `id_ruta` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(25) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NOT NULL,
  `fecha` DATE NOT NULL,
  `latitud_ini` DOUBLE NOT NULL,
  `longitud_ini` DOUBLE NOT NULL,
  `latitud_fin` DOUBLE NOT NULL,
  `longitud_fin` DOUBLE NOT NULL,
  `distancia` INT NOT NULL,
  `desnivel_acumulado` INT NOT NULL,
  `latitud_max` DOUBLE NOT NULL,
  `longitud_max` DOUBLE NOT NULL,
  `duracion` INT NOT NULL,
  `clasificacion` ENUM('circular', 'lineal') CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NOT NULL,
  `tipo_terreno` TINYINT NOT NULL,
  `nivel_riesgo` TINYINT NOT NULL,
  `nivel_esfuerzo` TINYINT NOT NULL,
  `indicaciones` TINYINT NOT NULL,
  `accesib_inclusiv` TINYINT NOT NULL,
  `familiar` TINYINT NOT NULL,
  `url_gpx` TEXT CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NOT NULL,
  `estado_ruta_validada` TINYINT NOT NULL,
  `recomendaciones` TEXT CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NOT NULL,
  `zona_geografica` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NOT NULL,
  `valo_media` DOUBLE NOT NULL,
  `usuarios_cod_usu` INT NOT NULL,
  PRIMARY KEY (`id_ruta`),
  INDEX `fk_rutas_usuarios1_idx` (`usuarios_cod_usu` ASC) VISIBLE,
  CONSTRAINT `fk_rutas_usuarios1`
    FOREIGN KEY (`usuarios_cod_usu`)
    REFERENCES `rutas_airelibre`.`usuarios` (`cod_usu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_as_ci;


-- -----------------------------------------------------
-- Table `rutas_airelibre`.`actividades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rutas_airelibre`.`actividades` (
  `id_actividad` INT NOT NULL,
  `nom_actividad` VARCHAR(25) NOT NULL,
  `descripcion` VARCHAR(125) NOT NULL,
  `rutas_id_ruta` INT NOT NULL,
  PRIMARY KEY (`id_actividad`),
  INDEX `fk_actividades_rutas1_idx` (`rutas_id_ruta` ASC) VISIBLE,
  CONSTRAINT `fk_actividades_rutas1`
    FOREIGN KEY (`rutas_id_ruta`)
    REFERENCES `rutas_airelibre`.`rutas` (`id_ruta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rutas_airelibre`.`calendario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rutas_airelibre`.`calendario` (
  `id_calendar` INT NOT NULL,
  `fecha` DATE NOT NULL,
  `recomendaciones` VARCHAR(125) NOT NULL,
  `usuarios_cod_usu` INT NOT NULL,
  `rutas_id_ruta` INT NOT NULL,
  PRIMARY KEY (`id_calendar`),
  INDEX `fk_calendario_usuarios1_idx` (`usuarios_cod_usu` ASC) VISIBLE,
  INDEX `fk_calendario_rutas1_idx` (`rutas_id_ruta` ASC) VISIBLE,
  CONSTRAINT `fk_calendario_usuarios1`
    FOREIGN KEY (`usuarios_cod_usu`)
    REFERENCES `rutas_airelibre`.`usuarios` (`cod_usu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_calendario_rutas1`
    FOREIGN KEY (`rutas_id_ruta`)
    REFERENCES `rutas_airelibre`.`rutas` (`id_ruta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rutas_airelibre`.`puntospeligro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rutas_airelibre`.`puntospeligro` (
  `id_trackpoint` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(25) NOT NULL,
  `num_orden` INT NOT NULL,
  `latitud` DOUBLE NOT NULL,
  `longitud` DOUBLE NOT NULL,
  `elevacion` DOUBLE NOT NULL,
  `timestamp` VARCHAR(45) NOT NULL,
  `descripcion` TEXT NOT NULL,
  `km` DOUBLE NOT NULL,
  `nivel_gravedad` TINYINT NOT NULL,
  `descripcion_gravedad` TEXT NOT NULL,
  `rutas_id_ruta` INT NOT NULL,
  PRIMARY KEY (`id_trackpoint`),
  INDEX `fk_puntospeligro_rutas1_idx` (`rutas_id_ruta` ASC) VISIBLE,
  CONSTRAINT `fk_puntospeligro_rutas1`
    FOREIGN KEY (`rutas_id_ruta`)
    REFERENCES `rutas_airelibre`.`rutas` (`id_ruta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rutas_airelibre`.`foto_pp`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rutas_airelibre`.`foto_pp` (
  `id_foto` INT NOT NULL,
  `url` TEXT CHARACTER SET 'armscii8' NOT NULL,
  `descripcion` VARCHAR(125) NOT NULL,
  `puntospeligro_id_trackpoint` INT NOT NULL,
  PRIMARY KEY (`id_foto`),
  INDEX `fk_foto_pp_puntospeligro1_idx` (`puntospeligro_id_trackpoint` ASC) VISIBLE,
  CONSTRAINT `fk_foto_pp_puntospeligro1`
    FOREIGN KEY (`puntospeligro_id_trackpoint`)
    REFERENCES `rutas_airelibre`.`puntospeligro` (`id_trackpoint`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rutas_airelibre`.`puntosinteres`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rutas_airelibre`.`puntosinteres` (
  `id_trackpoint` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `num_orden` INT NOT NULL,
  `latitud` DOUBLE NOT NULL,
  `longitud` DOUBLE NOT NULL,
  `elevacion` DOUBLE NOT NULL,
  `timestamp` TEXT NOT NULL,
  `tipo` ENUM('histórico-arqueológico') NOT NULL,
  `descripcion` VARCHAR(125) NOT NULL,
  `caract_especiales` VARCHAR(125) NOT NULL,
  `rutas_id_ruta` INT NOT NULL,
  PRIMARY KEY (`id_trackpoint`),
  INDEX `fk_puntosinteres_rutas1_idx` (`rutas_id_ruta` ASC) VISIBLE,
  CONSTRAINT `fk_puntosinteres_rutas1`
    FOREIGN KEY (`rutas_id_ruta`)
    REFERENCES `rutas_airelibre`.`rutas` (`id_ruta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rutas_airelibre`.`fotos_pi`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rutas_airelibre`.`fotos_pi` (
  `id_foto` INT NOT NULL,
  `url` TEXT NOT NULL,
  `descripcion` VARCHAR(125) NOT NULL,
  `puntosinteres_id_trackpoint` INT NOT NULL,
  PRIMARY KEY (`id_foto`),
  INDEX `fk_fotos_pi_puntosinteres_idx` (`puntosinteres_id_trackpoint` ASC) VISIBLE,
  CONSTRAINT `fk_fotos_pi_puntosinteres`
    FOREIGN KEY (`puntosinteres_id_trackpoint`)
    REFERENCES `rutas_airelibre`.`puntosinteres` (`id_trackpoint`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rutas_airelibre`.`periodos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rutas_airelibre`.`periodos` (
  `id_periodo` INT NOT NULL,
  `nom_periodo` VARCHAR(25) NOT NULL,
  `descrip` VARCHAR(125) NOT NULL,
  PRIMARY KEY (`id_periodo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rutas_airelibre`.`resenas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rutas_airelibre`.`resenas` (
  `id_resena` INT NOT NULL,
  `text_resena` VARCHAR(45) NOT NULL,
  `rutas_id_ruta` INT NOT NULL,
  `usuarios_cod_usu` INT NOT NULL,
  PRIMARY KEY (`id_resena`),
  INDEX `fk_reseñas_rutas1_idx` (`rutas_id_ruta` ASC) VISIBLE,
  INDEX `fk_reseñas_usuarios1_idx` (`usuarios_cod_usu` ASC) VISIBLE,
  CONSTRAINT `fk_reseñas_rutas1`
    FOREIGN KEY (`rutas_id_ruta`)
    REFERENCES `rutas_airelibre`.`rutas` (`id_ruta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reseñas_usuarios1`
    FOREIGN KEY (`usuarios_cod_usu`)
    REFERENCES `rutas_airelibre`.`usuarios` (`cod_usu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rutas_airelibre`.`valoraciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rutas_airelibre`.`valoraciones` (
  `id_valo` INT NOT NULL,
  `id_usu` INT NOT NULL,
  `dificultad` TINYINT NOT NULL,
  `belleza` TINYINT NOT NULL,
  `interes_cultu` TINYINT NOT NULL,
  `texto_valo` TEXT NOT NULL,
  `fecha` DATE NOT NULL,
  `es_valo_tecnica` TINYINT NOT NULL,
  `texto_valo_tecnica` TEXT NULL,
  `usuarios_cod_usu` INT NOT NULL,
  `rutas_id_ruta` INT NOT NULL,
  PRIMARY KEY (`id_valo`),
  INDEX `fk_valoraciones_usuarios1_idx` (`usuarios_cod_usu` ASC) VISIBLE,
  INDEX `fk_valoraciones_rutas1_idx` (`rutas_id_ruta` ASC) VISIBLE,
  CONSTRAINT `fk_valoraciones_usuarios1`
    FOREIGN KEY (`usuarios_cod_usu`)
    REFERENCES `rutas_airelibre`.`usuarios` (`cod_usu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_valoraciones_rutas1`
    FOREIGN KEY (`rutas_id_ruta`)
    REFERENCES `rutas_airelibre`.`rutas` (`id_ruta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rutas_airelibre`.`rutas_has_periodos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rutas_airelibre`.`rutas_has_periodos` (
  `rutas_id_ruta` INT NOT NULL,
  `periodos_id_periodo` INT NOT NULL,
  PRIMARY KEY (`rutas_id_ruta`, `periodos_id_periodo`),
  INDEX `fk_rutas_has_periodos_periodos1_idx` (`periodos_id_periodo` ASC) VISIBLE,
  INDEX `fk_rutas_has_periodos_rutas1_idx` (`rutas_id_ruta` ASC) VISIBLE,
  CONSTRAINT `fk_rutas_has_periodos_rutas1`
    FOREIGN KEY (`rutas_id_ruta`)
    REFERENCES `rutas_airelibre`.`rutas` (`id_ruta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rutas_has_periodos_periodos1`
    FOREIGN KEY (`periodos_id_periodo`)
    REFERENCES `rutas_airelibre`.`periodos` (`id_periodo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_as_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
