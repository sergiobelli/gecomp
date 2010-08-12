package net.sb.gecomp.commons.services;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.Competizione;
import net.sb.gecomp.commons.model.Gara;

public interface IGaraService extends IService<Gara> {
	
	List<Gara> list (Competizione competizione) throws GeCompSrvException;
	
}
