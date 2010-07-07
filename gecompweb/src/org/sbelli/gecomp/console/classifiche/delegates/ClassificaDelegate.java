package org.sbelli.gecomp.console.classifiche.delegates;

import org.sbelli.gecomp.console.bridges.view.ClassificaView;
import org.sbelli.gecomp.orm.model.Gara;

public abstract class ClassificaDelegate implements IClassificaDelegate {

	public abstract ClassificaView getClassifica(Gara gara);

}
