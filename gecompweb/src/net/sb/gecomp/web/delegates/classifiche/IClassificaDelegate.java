package net.sb.gecomp.web.delegates.classifiche;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.Gara;
import net.sb.gecomp.commons.model.view.ClassificaView;


public interface IClassificaDelegate {

	ClassificaView getClassifica(Gara gara) throws GeCompException;

}