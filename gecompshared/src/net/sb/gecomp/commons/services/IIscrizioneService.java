package net.sb.gecomp.commons.services;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.Competizione;
import net.sb.gecomp.commons.model.Gara;
import net.sb.gecomp.commons.model.Iscrizione;

@WebService
public interface IIscrizioneService extends IService<Iscrizione> {

	Iscrizione save(@WebParam(name="iscrizione") Iscrizione iscrizione) throws GeCompSrvException;

	Iscrizione get(@WebParam(name="id") Long id) throws GeCompSrvException;

	List<Iscrizione> list4Gara(@WebParam(name="gara") Gara gara) throws GeCompSrvException;

	List<Iscrizione> list4Competizione(@WebParam(name="competizione") Competizione competizione) throws GeCompSrvException;

	void delete(@WebParam(name="id") Long id) throws GeCompSrvException;

	List<Iscrizione> list() throws GeCompSrvException;

}