-- Script SQL de la base Supdeco Dakar (H2/MySQL compatible)
DROP TABLE IF EXISTS note; DROP TABLE IF EXISTS inscription; DROP TABLE IF EXISTS cours; DROP TABLE IF EXISTS etudiant;
CREATE TABLE etudiant (id BIGINT AUTO_INCREMENT PRIMARY KEY, matricule VARCHAR(30) NOT NULL UNIQUE, prenom VARCHAR(80) NOT NULL, nom VARCHAR(80) NOT NULL, email VARCHAR(150) NOT NULL, telephone VARCHAR(30), filiere VARCHAR(100));
CREATE TABLE cours (id BIGINT AUTO_INCREMENT PRIMARY KEY, code VARCHAR(30) NOT NULL UNIQUE, intitule VARCHAR(150) NOT NULL, enseignant VARCHAR(120), credits INT NOT NULL);
CREATE TABLE inscription (id BIGINT AUTO_INCREMENT PRIMARY KEY, date_inscription DATE NOT NULL, statut VARCHAR(20) NOT NULL, etudiant_id BIGINT NOT NULL, cours_id BIGINT NOT NULL, UNIQUE(etudiant_id,cours_id), FOREIGN KEY(etudiant_id) REFERENCES etudiant(id), FOREIGN KEY(cours_id) REFERENCES cours(id));
CREATE TABLE note (id BIGINT AUTO_INCREMENT PRIMARY KEY, valeur DECIMAL(4,2) NOT NULL, coefficient DECIMAL(4,2) NOT NULL, evaluation VARCHAR(100), inscription_id BIGINT NOT NULL, FOREIGN KEY(inscription_id) REFERENCES inscription(id));
INSERT INTO etudiant(matricule,prenom,nom,email,telephone,filiere) VALUES ('ETU-2026-001','Awa','Diop','awa.diop@supdeco.sn','770000000','Management'),('ETU-2026-002','Moussa','Fall','moussa.fall@supdeco.sn','771111111','Informatique');
INSERT INTO cours(code,intitule,enseignant,credits) VALUES ('JEE301','Technologie JEE','M. Ndiaye',4),('BD302','Bases de données','Mme Sarr',3);
INSERT INTO inscription(date_inscription,statut,etudiant_id,cours_id) VALUES (CURRENT_DATE,'ACTIVE',1,1),(CURRENT_DATE,'ACTIVE',2,2);
INSERT INTO note(valeur,coefficient,evaluation,inscription_id) VALUES (15.5,2,'Projet final',1),(14,1,'Examen',1),(16,2,'Contrôle continu',2);
