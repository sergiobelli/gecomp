package org.sbelli.gecomp.console.classifiche.delegates;

import net.sb.gecomp.exceptions.GeCompException;

import org.sbelli.gecomp.console.bridges.view.ClassificaView;
import org.sbelli.gecomp.orm.model.Gara;

public interface IClassificaDelegate {

	ClassificaView getClassifica(Gara gara) throws GeCompException;

}