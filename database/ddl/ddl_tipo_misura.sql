-- --------------------------------------------------------

--
-- Struttura della tabella `tipo_misura`
--

CREATE TABLE IF NOT EXISTS `tipo_misura` (
  `ID_TIPO_MISURA` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `DESCRIZIONE` varchar(255) NOT NULL,
  `UNITA_MISURA` varchar(255) NOT NULL,
  `MODALITA_COMPARAZIONE` int(11) unsigned NOT NULL,
  `FLG_VALIDITA` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`ID_TIPO_MISURA`),
  UNIQUE KEY `ID_TIPO_MISURA` (`ID_TIPO_MISURA`),
  KEY `ID_TIPO_MISURA_2` (`ID_TIPO_MISURA`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;