-- --------------------------------------------------------

--
-- Struttura della tabella `iscrizione`
--

CREATE TABLE IF NOT EXISTS `iscrizione` (
  `ID_ISCRIZIONE` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `GARA` int(11) NOT NULL,
  `ATLETA` int(11) NOT NULL,
  `NUMERO_PETTORALE` int(11) DEFAULT NULL,
  `COMPETITIVO` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY `ISCRIZIONE_KEY`  (`ID_ISCRIZIONE`,`GARA`,`ATLETA`),--aggiungere a papa'
  UNIQUE  KEY `ISCRIZIONE_KEY`  (`ID_ISCRIZIONE`,`GARA`,`ATLETA`),--aggiungere a papa'
  UNIQUE  KEY `GARA_ATLETA_KEY` (`GARA`,`ATLETA`),--aggiungere a papa'
  UNIQUE  KEY `GARA_PETTORALE_KEY` (`GARA`,`NUMERO_PETTORALE`)--aggiungere a papa'
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2519 ;