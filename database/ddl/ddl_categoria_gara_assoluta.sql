-- --------------------------------------------------------

--
-- Struttura della tabella `categoria_gara_assoluta`
--

CREATE TABLE IF NOT EXISTS `categoria_gara_assoluta` (
  `ID_CATEGORIA_GARA_ASSOLUTA` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `ID_CATEGORIA_GARA` int(11) unsigned NOT NULL,
  `NUMERO_POSIZIONI` int(11) unsigned NOT NULL,
  PRIMARY KEY (`ID_CATEGORIA_GARA_ASSOLUTA`),
  UNIQUE KEY `ID_CATEGORIA_GARA_ASSOLUTA` (`ID_CATEGORIA_GARA_ASSOLUTA`),
  KEY `ID_CATEGORIA_GARA_ASSOLUTA_2` (`ID_CATEGORIA_GARA_ASSOLUTA`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=226 ;