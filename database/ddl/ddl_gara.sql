-- --------------------------------------------------------

--
-- Struttura della tabella `gara`
--

CREATE TABLE IF NOT EXISTS `gara` (
  `ID_GARA` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `COMPETIZIONE` int(11) unsigned NOT NULL,
  `NOME` varchar(255) NOT NULL,
  `DESCRIZIONE` varchar(255) NOT NULL,
  `DATA` date NOT NULL,
  `DISTANZA` float unsigned NOT NULL,
  `TIPO_MISURA` int(11) NOT NULL,
  `NUMERO_ASSOLUTI_MASCHILE` int(11) unsigned NOT NULL,
  `NUMERO_ASSOLUTI_FEMMINILE` int(11) unsigned NOT NULL,
  PRIMARY KEY (`ID_GARA`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=48 ;