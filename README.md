# proj1_tecweb

Para criar database e tabela no mySQL:

CREATE DATABASE meus_dados;

USE meus_dados;

CREATE TABLE Jogos (id INT NOT NULL AUTO_INCREMENT, nome VARCHAR(32) NOT NULL, data DATE, tamanho INT(10), categoria VARCHAR(32), PRIMARY KEY (ID));


Caso queira inserir item por SQL:

INSERT INTO Jogos (nome, data, tamanho, categoria) VALUES ('Tetris','19840307', 2, 'Puzzle');
