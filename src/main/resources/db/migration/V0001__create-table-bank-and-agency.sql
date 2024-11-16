CREATE TABLE tb_banco (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `codigo` varchar(10) DEFAULT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE tb_agencia_banco (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_banco` int(10) unsigned NOT NULL,
  `codigo` int(10) unsigned DEFAULT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `logradouro` varchar(100) DEFAULT NULL,
  `numero` varchar(10) DEFAULT NULL,
  `cep` varchar(8) DEFAULT NULL,
  `municipio_ibge` int(10) unsigned DEFAULT NULL,
  `uf` char(2) DEFAULT NULL,
  `telefone` varchar(10) DEFAULT NULL,
  `gerente` varchar(30) DEFAULT NULL,
  `contato` varchar(30) DEFAULT NULL,
  `obs` text,
  PRIMARY KEY (`id`),
  KEY `fk_banco_agencia` (`id_banco`),
  CONSTRAINT `agencia_banco_fk` FOREIGN KEY (`id_banco`) REFERENCES `tb_banco` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
