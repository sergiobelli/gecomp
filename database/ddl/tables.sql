-- phpMyAdmin SQL Dump
-- version 3.2.0.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generato il: 29 lug, 2010 at 02:52 PM
-- Versione MySQL: 5.1.36
-- Versione PHP: 5.3.0

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Database: `gecomp`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `atleta`
--

CREATE TABLE IF NOT EXISTS `atleta` (
  `ID_ATLETA` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `COGNOME` varchar(255) NOT NULL,
  `NOME` varchar(255) NOT NULL,
  `SESSO` varchar(1) NOT NULL,
  `ANNO_NASCITA` varchar(4) NOT NULL,
  `SOCIETA_APPARTENENZA` int(11) unsigned NOT NULL,
  PRIMARY KEY (`ID_ATLETA`),
  UNIQUE KEY `ID_ATLETA` (`ID_ATLETA`),
  KEY `ID_ATLETA_2` (`ID_ATLETA`),
  KEY `fk_societa` (`SOCIETA_APPARTENENZA`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=112 ;

-- --------------------------------------------------------

--
-- Struttura della tabella `categoria`
--

CREATE TABLE IF NOT EXISTS `categoria` (
  `ID_CATEGORIA` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `NOME_CATEGORIA` varchar(255) NOT NULL,
  `SESSO` varchar(1) NOT NULL,
  `ANNO_PARTENZA` varchar(4) NOT NULL,
  `ANNO_FINE` varchar(4) NOT NULL,
  PRIMARY KEY (`ID_CATEGORIA`),
  UNIQUE KEY `ID_CATEGORIA` (`ID_CATEGORIA`),
  KEY `ID_CATEGORIA_2` (`ID_CATEGORIA`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=23 ;

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
  PRIMARY KEY (`ID_GARA`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=48 ;

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
  PRIMARY KEY (`ID_ISCRIZIONE`,`GARA`,`ATLETA`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2519 ;

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
  PRIMARY KEY (`ID_PRESTAZIONE`),
  UNIQUE KEY `ID_PRESTAZIONE` (`ID_PRESTAZIONE`),
  KEY `ID_PRESTAZIONE_2` (`ID_PRESTAZIONE`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2517 ;

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

-- --------------------------------------------------------

--
-- Struttura della tabella `societa`
--

CREATE TABLE IF NOT EXISTS `societa` (
  `ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `CODICE_FIDAL` varchar(5) NOT NULL DEFAULT '',
  `DENOMINAZIONE` varchar(255) NOT NULL,
  `TELEFONO_SEDE` varchar(50) DEFAULT '',
  `LOCALITA_SEDE` varchar(255) DEFAULT '',
  `FAX` varchar(50) DEFAULT '',
  `EMAIL` varchar(255) DEFAULT '',
  `SITO` varchar(255) DEFAULT '',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COMMENT='latin1_swedish_ci' AUTO_INCREMENT=34 ;

-- --------------------------------------------------------

--
-- Struttura della tabella `tipo_misura`
--

CREATE TABLE IF NOT EXISTS `tipo_misura` (
  `ID_TIPO_MISURA` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `DESCRIZIONE` varchar(255) NOT NULL,
  `UNITA_MISURA` varchar(255) NOT NULL,
  `MODALITA_COMPARAZIONE` int(11) unsigned NOT NULL,
  PRIMARY KEY (`ID_TIPO_MISURA`),
  UNIQUE KEY `ID_TIPO_MISURA` (`ID_TIPO_MISURA`),
  KEY `ID_TIPO_MISURA_2` (`ID_TIPO_MISURA`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

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

-- --------------------------------------------------------

--
-- Struttura della tabella `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `ID_USER` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(255) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  PRIMARY KEY (`ID_USER`,`USERNAME`,`PASSWORD`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;
