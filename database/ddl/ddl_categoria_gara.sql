-- --------------------------------------------------------

--
-- Struttura della tabella `categoria_gara`
--

CREATE TABLE IF NOT EXISTS `categoria_gara` (
  `ID_CATEGORIA_GARA` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `CATEGORIA` int(11) unsigned NOT NULL,
  `GARA` int(11) unsigned NOT NULL,
  PRIMARY KEY (`ID_CATEGORIA_GARA`),
  UNIQUE KEY `ID_CATEGORIA_GARA` (`ID_CATEGORIA_GARA`),
  KEY `ID_CATEGORIA_GARA_2` (`ID_CATEGORIA_GARA`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=322 ;