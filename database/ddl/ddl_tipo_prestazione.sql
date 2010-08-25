-- --------------------------------------------------------

--
-- Struttura della tabella `tipo_prestazione`
--

CREATE TABLE IF NOT EXISTS `tipo_prestazione` (
  `ID_TIPO_PRESTAZIONE` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `DESCRIZIONE` varchar(255) NOT NULL,
  PRIMARY KEY (`ID_TIPO_PRESTAZIONE`),
  UNIQUE KEY `ID_TIPO_PRESTAZIONE` (`ID_TIPO_PRESTAZIONE`),
  KEY `ID_TIPO_PRESTAZIONE_2` (`ID_TIPO_PRESTAZIONE`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;