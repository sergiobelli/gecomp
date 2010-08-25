-- --------------------------------------------------------

--
-- Struttura della tabella `categoria_competizione`
--

CREATE TABLE IF NOT EXISTS `categoria_competizione` (
  `ID_CATEGORIA_COMPETIZIONE` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `CATEGORIA` int(11) unsigned NOT NULL,
  `COMPETIZIONE` int(11) unsigned NOT NULL,
  PRIMARY KEY (`ID_CATEGORIA_COMPETIZIONE`),
  UNIQUE KEY `ID_CATEGORIA_COMPETIZIONE` (`ID_CATEGORIA_COMPETIZIONE`),
  KEY `ID_CATEGORIA_COMPETIZIONE_2` (`ID_CATEGORIA_COMPETIZIONE`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;