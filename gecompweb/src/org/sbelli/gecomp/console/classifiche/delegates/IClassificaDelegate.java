package org.sbelli.gecomp.console.classifiche.delegates;

import org.sbelli.gecomp.console.bridges.view.ClassificaView;
import org.sbelli.gecomp.orm.model.Gara;

public interface IClassificaDelegate {

	ClassificaView getClassifica(Gara gara);

}