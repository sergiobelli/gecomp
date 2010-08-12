package net.sb.gecomp.commons.services;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.Competizione;
import net.sb.gecomp.commons.model.Gara;
import net.sb.gecomp.commons.model.Iscrizione;

public interface IIscrizioneService extends IService<Iscrizione> {

	Iscrizione save(Iscrizione iscrizione) throws GeCompSrvException;

	Iscrizione get(Long id) throws GeCompSrvException;

	List<Iscrizione> list(Gara gara) throws GeCompSrvException;

	List<Iscrizione> list(Competizione competizione) throws GeCompSrvException;

}