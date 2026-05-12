DROP TABLE IF EXISTS Inscribe CASCADE;
DROP TABLE IF EXISTS Imparte CASCADE;
DROP TABLE IF EXISTS Incluye CASCADE;
DROP TABLE IF EXISTS Requiere CASCADE;
DROP TABLE IF EXISTS Estudiantes CASCADE;
DROP TABLE IF EXISTS Profesores CASCADE;
DROP TABLE IF EXISTS Asignaturas CASCADE;
DROP TABLE IF EXISTS Carreras CASCADE;

CREATE TABLE Carreras (
    id_carr SERIAL PRIMARY KEY,
    nom_carr VARCHAR(50) NOT NULL,
    reg_calif VARCHAR(50)
);

CREATE TABLE Asignaturas (
    cod_a SERIAL PRIMARY KEY,
    nom_a VARCHAR(50) NOT NULL,
    int_h INT,                
    creditos NUMERIC(4,2)    
);

CREATE TABLE Profesores (
    id_p SERIAL PRIMARY KEY,
    nom_p VARCHAR(50) NOT NULL,
    dir_p VARCHAR(50),
    tel_p VARCHAR(20) unique,
    profesion VARCHAR(50)
);

CREATE TABLE Estudiantes (
    cod_e SERIAL PRIMARY KEY,
    nom_e VARCHAR(50) NOT NULL,
    dir_e VARCHAR(50),
    tel_e VARCHAR(20)unique,
    fech_nac DATE,
    id_carr INT,
    CONSTRAINT fk_estudiante_carrera FOREIGN KEY (id_carr) REFERENCES Carreras(id_carr)
);


CREATE TABLE Requiere (
    cod_a INT,
    cod_a_r INT,
    PRIMARY KEY (cod_a, cod_a_r),
    CONSTRAINT fk_asignatura FOREIGN KEY (cod_a) REFERENCES Asignaturas(cod_a),
    CONSTRAINT fk_prerrequisito FOREIGN KEY (cod_a_r) REFERENCES Asignaturas(cod_a)
);

CREATE TABLE Incluye (
    id_carr INT,   
    cod_a INT,
    PRIMARY KEY (id_carr, cod_a),
    CONSTRAINT fk_incluye_carrera FOREIGN KEY (id_carr) REFERENCES Carreras(id_carr),
    CONSTRAINT fk_incluye_asignatura FOREIGN KEY (cod_a) REFERENCES Asignaturas(cod_a)
);

CREATE TABLE Imparte (
    id_p INT,
    cod_a INT,
    grupo VARCHAR(10),
    horario VARCHAR(50),
    PRIMARY KEY (id_p, cod_a, grupo),
    CONSTRAINT fk_imparte_profesor FOREIGN KEY (id_p) REFERENCES Profesores(id_p),
    CONSTRAINT fk_imparte_asignatura FOREIGN KEY (cod_a) REFERENCES Asignaturas(cod_a)
);

CREATE TABLE Inscribe (
    cod_e INT,
    cod_a INT,
    id_p INT,
    grupo VARCHAR(10),
    n1 NUMERIC(4,2) CHECK (n1 >= 0 AND n1 <= 5.0), 
    n2 NUMERIC(4,2) CHECK (n1 >= 0 AND n1 <= 5.0),
    n3 NUMERIC(4,2) CHECK (n1 >= 0 AND n1 <= 5.0),
    PRIMARY KEY (cod_e, cod_a, id_p, grupo),
    CONSTRAINT fk_inscribe_estudiante FOREIGN KEY (cod_e) REFERENCES Estudiantes(cod_e),
    CONSTRAINT fk_inscribe_imparte FOREIGN KEY (id_p, cod_a, grupo) REFERENCES Imparte(id_p, cod_a, grupo)
);

CREATE VIEW vw_notas_definitivas AS
SELECT 
    cod_e, cod_a, id_p, grupo, n1, n2, n3,
    (n1 * 0.35 + n2 * 0.35 + n3 * 0.30) AS definitiva
FROM Inscribe;