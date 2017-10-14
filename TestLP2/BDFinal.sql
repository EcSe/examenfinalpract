USE test;

DROP DATABASE IF EXISTS BDExFinal;


CREATE DATABASE BDExFinal;

USE BDExFinal;

CREATE TABLE TBEspecialidad(
Codigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
Descripcion VARCHAR(50),
Costo DECIMAL(6,2)
);

CREATE TABLE TBMedico(
Codigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
CodigoEspecialidad INT NOT NULL,
Nombre VARCHAR(50) NOT NULL,
Turno VARCHAR(20),
FOREIGN KEY(CodigoEspecialidad) REFERENCES TBEspecialidad(Codigo)
);

CREATE TABLE TBCita(
Codigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
CodigoMedico INT NOT NULL,
CodigoEspecialidad INT NOT NULL,
FechaCita Date,
Costo DECIMAL(6,2),
FOREIGN KEY(CodigoMedico) REFERENCES TBMedico(Codigo),
FOREIGN KEY(CodigoEspecialidad) REFERENCES TBEspecialidad(Codigo)
);

INSERT INTO TBEspecialidad VALUES(null,'Dermatologia',25);
INSERT INTO TBEspecialidad VALUES(null,'Ginecologia',30);
INSERT INTO TBEspecialidad VALUES(null,'Medicina General',20);

INSERT INTO TBMedico VALUES(null,1,'Julio Torres','Mañana');
INSERT INTO TBMedico VALUES(null,1,'Camila Cardenas','Tarde');
INSERT INTO TBMedico VALUES(null,2,'Luis Castro','Mañana');
INSERT INTO TBMedico VALUES(null,2,'Miguel Huamán','Tarde');
INSERT INTO TBMedico VALUES(null,3,'Julio Fajardo','Mañana');
INSERT INTO TBMedico VALUES(null,3,'Moises Quispe','Tarde');




DELIMITER $$
CREATE PROCEDURE sp_reservarCita (
IN codigoMedico INT, IN fechaCita Date, OUT msj VARCHAR(30)
)

BEGIN
DECLARE codEsp INT;
DECLARE cost DECIMAL(6,2);
DECLARE exit handler for sqlexception
  BEGIN
    -- ERROR
    SET msj = 'ERROR AL PAGAR';
    ROLLBACK;
END;

START TRANSACTION;    
    SET codEsp = (SELECT CodigoEspecialidad FROM TBMedico WHERE Codigo = codigoMedico);
    SET cost = (SELECT Costo FROM TBEspecialidad WHERE Codigo = codEsp);
    INSERT INTO TBCita VALUES(null,codigoMedico,codEsp,fechaCita, cost ) ;
    
COMMIT;
SET msj = 'EXITO';
END
$$
DELIMITER ;
call sp_reservarCita(1,'2016/10/15',@msj);




SELECT * FROM TBMedico;
SELECT * FROM TBCita;


