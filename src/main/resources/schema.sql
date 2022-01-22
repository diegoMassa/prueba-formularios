DROP TABLE IF EXISTS encuesta;

CREATE TABLE encuesta (
  encuesta_id INT AUTO_INCREMENT  PRIMARY KEY,
  numero_documento VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL,
  comentarios VARCHAR(1000) NOT NULL,
  marca_id INT NOT NULL,
  fecha_respuesta TIMESTAMP DEFAULT NULL
);


DROP TABLE IF EXISTS marca_pc;

CREATE TABLE marca_pc (
  marca_id INT AUTO_INCREMENT  PRIMARY KEY,
  descripcion VARCHAR(250) NOT NULL,
  estado VARCHAR(1) NOT NULL,
  fecha_creacion TIMESTAMP DEFAULT NULL
);