-- --------------------------------------------------------

--
-- Struttura della tabella `atleta`
--

CREATE TABLE IF NOT EXISTS `atleta` (
  `ID_ATLETA` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `COGNOME` varchar(255) NOT NULL,
  `NOME` varchar(255) NOT NULL,
  `SESSO` varchar(1) NOT NULL,
  `ANNO_NASCITA` varchar(4) NOT NULL,
  `SOCIETA_APPARTENENZA` int(11) unsigned NOT NULL,
  PRIMARY KEY (`ID_ATLETA`),
  UNIQUE KEY `ID_ATLETA` (`ID_ATLETA`),
  KEY `ID_ATLETA_2` (`ID_ATLETA`),
  KEY `fk_societa` (`SOCIETA_APPARTENENZA`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=112 ;