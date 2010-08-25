-- --------------------------------------------------------

--
-- Struttura della tabella `categoria`
--

CREATE TABLE IF NOT EXISTS `categoria` (
  `ID_CATEGORIA` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `NOME_CATEGORIA` varchar(255) NOT NULL,
  `SESSO` varchar(1) NOT NULL,
  `ANNO_PARTENZA` varchar(4) NOT NULL,
  `ANNO_FINE` varchar(4) NOT NULL,
  PRIMARY KEY (`ID_CATEGORIA`),
  UNIQUE KEY `ID_CATEGORIA` (`ID_CATEGORIA`),
  KEY `ID_CATEGORIA_2` (`ID_CATEGORIA`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=23 ;