package net.sb.gecomp.web.delegates.classifiche;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.model.Gara;
import net.sb.gecomp.web.bridges.view.ClassificaView;


public abstract class ClassificaDelegate implements IClassificaDelegate {

	public abstract ClassificaView getClassifica(Gara gara) throws GeCompException;

}
