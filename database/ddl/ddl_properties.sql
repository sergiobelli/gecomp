-- --------------------------------------------------------

--
-- Struttura della tabella `properties`
--

CREATE TABLE IF NOT EXISTS `properties` (
  `ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `CHIAVE` varchar(255) NOT NULL,
  `VALORE` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;