package net.sb.gecomp.commons.services;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.Categoria;
import net.sb.gecomp.commons.model.Gara;
import net.sb.gecomp.commons.model.Iscrizione;
import net.sb.gecomp.commons.model.Prestazione;

public interface IPrestazioneService extends IService<Prestazione> {

	List<Prestazione> list(Gara gara) throws GeCompSrvException;

	List<Prestazione> list(Gara gara, Categoria categoria, Boolean conAssoluti) throws GeCompSrvException;

	Prestazione get(Iscrizione iscrizione) throws GeCompSrvException;
}
