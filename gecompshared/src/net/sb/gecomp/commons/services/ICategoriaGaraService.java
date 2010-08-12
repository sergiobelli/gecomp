package net.sb.gecomp.commons.services;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.CategoriaGara;
import net.sb.gecomp.commons.model.Gara;

public interface ICategoriaGaraService extends IService<CategoriaGara> {

	List<CategoriaGara> list(Gara gara) throws GeCompSrvException;;

}
