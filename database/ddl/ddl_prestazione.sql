-- --------------------------------------------------------

--
-- Struttura della tabella `prestazione`
--

CREATE TABLE IF NOT EXISTS `prestazione` (
  `ID_PRESTAZIONE` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `ISCRIZIONE` int(11) unsigned NOT NULL,
  `TIPO_PRESTAZIONE` int(11) unsigned NOT NULL,
  `TIPO_MISURA` int(11) unsigned NOT NULL,
  `VALORE_MISURA` int(11) unsigned NOT NULL,
  PRIMARY KEY `PRESTAZIONE_KEY` (`ID_PRESTAZIONE`,`ISCRIZIONE`),
  UNIQUE  KEY `PRESTAZIONE_KEY` (`ID_PRESTAZIONE`,`ISCRIZIONE`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2517 ;