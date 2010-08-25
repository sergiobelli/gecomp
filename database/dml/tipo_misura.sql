--
-- Dump dei dati per la tabella `tipo_misura`
--

INSERT INTO `tipo_misura` (`ID_TIPO_MISURA`, `DESCRIZIONE`, `UNITA_MISURA`, `MODALITA_COMPARAZIONE`, `FLG_VALIDITA`) VALUES
(1, 'Tempo', 'millisecondi', 0, 1),
(2, 'Lancio', 'metri', 1, 1),
(3, 'Salto', 'metri', 1, 1),
(4, 'Ordine di arrivo', 'posizione', 0, 1);