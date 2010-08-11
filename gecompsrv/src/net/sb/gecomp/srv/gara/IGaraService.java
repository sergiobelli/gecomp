package net.sb.gecomp.srv.gara;

import net.sb.gecomp.exceptions.GeCompSrvException;
import net.sb.gecomp.model.Gara;


public interface IGaraService {
	Gara save(Gara gara) throws GeCompSrvException;
}
