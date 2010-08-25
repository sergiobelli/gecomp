-- --------------------------------------------------------

--
-- Struttura della tabella `societa`
--

CREATE TABLE IF NOT EXISTS `societa` (
  `ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `CODICE_FIDAL` varchar(5) NOT NULL DEFAULT '',
  `DENOMINAZIONE` varchar(255) NOT NULL,
  `TELEFONO_SEDE` varchar(50) DEFAULT '',
  `LOCALITA_SEDE` varchar(255) DEFAULT '',
  `FAX` varchar(50) DEFAULT '',
  `EMAIL` varchar(255) DEFAULT '',
  `SITO` varchar(255) DEFAULT '',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COMMENT='latin1_swedish_ci' AUTO_INCREMENT=34 ;