package net.sb.gecomp.commons.services;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.Atleta;

public interface IAtletaService extends IService<Atleta> {

	Atleta save(Atleta atleta) throws GeCompSrvException;

	Atleta get(Long id) throws GeCompSrvException;

}