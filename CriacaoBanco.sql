//Cria o banco de dados chamado 'sattra2'
create database `sattra2`;

//Cria a tabela chamada 'pessoa'
CREATE TABLE `pessoa` (
	`ID` INT(11) NOT NULL AUTO_INCREMENT,
	`nome` TINYTEXT NOT NULL,
	`CPF` VARCHAR(11) NOT NULL,
	`telefone` TINYTEXT NULL DEFAULT NULL,
	`email` TINYTEXT NULL DEFAULT NULL,
	`cep` VARCHAR(9) NOT NULL,
	`localidade` TINYTEXT NOT NULL,
	`bairro` TINYTEXT NOT NULL,
	`logradouro` TINYTEXT NOT NULL,
	`numero` TINYTEXT NOT NULL,
	`complemento` TINYTEXT NULL DEFAULT NULL,
	`uf` VARCHAR(4) NOT NULL,
	`observacoes` TEXT NULL DEFAULT NULL,
	PRIMARY KEY (`ID`),
	UNIQUE INDEX `CPF` (`CPF`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=13
;