package net.sb.gecomp.commons.services;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.Categoria;
import net.sb.gecomp.commons.model.Competizione;
import net.sb.gecomp.commons.model.Gara;
import net.sb.gecomp.commons.model.Iscrizione;
import net.sb.gecomp.commons.model.Prestazione;

@WebService
public interface IPrestazioneService /*extends IService<Prestazione>*/ {

	List<Prestazione> list4Gara(@WebParam(name="gara") Gara gara) throws GeCompSrvException;
	
	List<Prestazione> list4Competizione(@WebParam(name="competizione") Competizione competizione) throws GeCompSrvException;

	List<Prestazione> list4GaraCategoria(
			@WebParam(name="gara") Gara gara, 
			@WebParam(name="categoria") Categoria categoria, 
			@WebParam(name="conAssoluti") Boolean conAssoluti) throws GeCompSrvException;

	Prestazione get4Iscrizione(@WebParam(name="iscrizione") Iscrizione iscrizione) throws GeCompSrvException;
	
	void delete(@WebParam(name="id") Long id) throws GeCompSrvException;

	Prestazione get(@WebParam(name="id") Long id) throws GeCompSrvException;

	Prestazione save(@WebParam(name="prestazione") Prestazione prestazione) throws GeCompSrvException;

	List<Prestazione> list() throws GeCompSrvException;
	
}
