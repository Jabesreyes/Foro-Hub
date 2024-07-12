CREATE TABLE topicos (
     id INT AUTO_INCREMENT PRIMARY KEY,
     titulo VARCHAR(255) NOT NULL,
     mensaje TEXT NOT NULL,
     fecha_creacion DATETIME NOT NULL,
     status ENUM('ABIERTO', 'CERRADO') NOT NULL,
     autor VARCHAR(255) NOT NULL,
     curso VARCHAR(255) NOT NULL
);