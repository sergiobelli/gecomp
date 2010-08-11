package net.sb.gecomp.web.delegates.classifiche;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.web.bridges.view.ClassificaView;

import org.sbelli.gecomp.orm.model.Gara;

public interface IClassificaDelegate {

	ClassificaView getClassifica(Gara gara) throws GeCompException;

}