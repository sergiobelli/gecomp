-- --------------------------------------------------------

--
-- Struttura della tabella `competizione`
--

CREATE TABLE IF NOT EXISTS `competizione` (
  `ID_COMPETIZIONE` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `DATA_INIZIO` date NOT NULL,
  `DATA_FINE` date NOT NULL,
  `NOME` varchar(255) NOT NULL,
  `DESCRIZIONE` text,
  `SOCIETA_ORGANIZZATRICE` int(11) unsigned NOT NULL,
  PRIMARY KEY (`ID_COMPETIZIONE`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;