
DROP TABLE IF EXISTS posta_oseba;

DROP TABLE IF EXISTS oseba;

DROP TABLE IF EXISTS posta;

CREATE TABLE `posta` (  `koda` varchar(255) NOT NULL,  `naziv` varchar(255) DEFAULT NULL,  PRIMARY KEY (`koda`) ) DEFAULT CHARSET=utf8;

CREATE TABLE `oseba` (  `id` int(11) NOT NULL AUTO_INCREMENT,  `datumVpisa` datetime DEFAULT NULL,  `email` varchar(255) DEFAULT NULL,  `ime` varchar(255) DEFAULT NULL,  `priimek` varchar(255) DEFAULT NULL,  `bivalisce_koda` varchar(255) DEFAULT NULL,  PRIMARY KEY (`id`),  KEY (`bivalisce_koda`),  FOREIGN KEY (`bivalisce_koda`) REFERENCES `posta` (`koda`)) DEFAULT CHARSET=utf8;