package net.sb.gecomp.web.delegates;

import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.web.bridges.GenericBridge;
import net.sb.gecomp.web.bridges.atleti.AtletaBridge;
import net.sb.gecomp.web.bridges.categorie.CategoriaBridge;
import net.sb.gecomp.web.bridges.competizione.CompetizioneBridge;
import net.sb.gecomp.web.bridges.gare.GaraBridge;
import net.sb.gecomp.web.bridges.iscrizioni.IscrizioneBridge;
import net.sb.gecomp.web.bridges.prestazioni.PrestazioneBridge;
import net.sb.gecomp.web.bridges.properties.PropertiesBridge;
import net.sb.gecomp.web.bridges.societa.SocietaBridge;
import net.sb.gecomp.web.bridges.tipimisure.TipoMisuraBridge;
import net.sb.gecomp.web.bridges.tipiprestazione.TipoPrestazioneBridge;
import net.sb.gecomp.web.delegates.atleti.AtletaDelegate;
import net.sb.gecomp.web.delegates.categorie.CategoriaDelegate;
import net.sb.gecomp.web.delegates.competizione.CompetizioneDelegate;
import net.sb.gecomp.web.delegates.gare.GaraDelegate;
import net.sb.gecomp.web.delegates.iscrizioni.IscrizioneDelegate;
import net.sb.gecomp.web.delegates.prestazioni.PrestazioneDelegate;
import net.sb.gecomp.web.delegates.properties.PropertiesDelegate;
import net.sb.gecomp.web.delegates.societa.SocietaDelegate;
import net.sb.gecomp.web.delegates.tipimisure.TipoMisuraDelegate;
import net.sb.gecomp.web.delegates.tipiprestazione.TipoPrestazioneDelegate;
import net.sb.gecomp.web.utils.context.GecompContextFactory;

import org.apache.log4j.Logger;

public abstract class GenericDelegate implements IGenericDaoDelegate {
	
	protected Logger logger = Logger.getLogger(this.getClass().getName());
	
	private GenericBridge bridge;
	public GenericBridge getBridge() {
		if (Eval.isNull(bridge)) {
			if (this instanceof AtletaDelegate) {
				setBridge((AtletaBridge)GecompContextFactory.getContext().getBean("atletaBridge"));
			} else if (this instanceof CategoriaDelegate) {
				setBridge((CategoriaBridge)GecompContextFactory.getContext().getBean("categoriaBridge"));
			} else if (this instanceof CompetizioneDelegate) {
				setBridge((CompetizioneBridge)GecompContextFactory.getContext().getBean("competizioneBridge"));
			} else if (this instanceof GaraDelegate) {
				setBridge((GaraBridge)GecompContextFactory.getContext().getBean("garaBridge"));
			} else if (this instanceof IscrizioneDelegate) {
				setBridge((IscrizioneBridge)GecompContextFactory.getContext().getBean("iscrizioneBridge"));
			} else if (this instanceof PrestazioneDelegate) {
				setBridge((PrestazioneBridge)GecompContextFactory.getContext().getBean("prestazioneBridge"));
			} else if (this instanceof PropertiesDelegate) {
				setBridge((PropertiesBridge)GecompContextFactory.getContext().getBean("propertiesBridge"));
			} else if (this instanceof SocietaDelegate) {
				setBridge((SocietaBridge)GecompContextFactory.getContext().getBean("societaBridge"));
			} else if (this instanceof TipoMisuraDelegate) {
				setBridge((TipoMisuraBridge)GecompContextFactory.getContext().getBean("tipoMisuraBridge"));
			} else if (this instanceof TipoPrestazioneDelegate) {
				setBridge((TipoPrestazioneBridge)GecompContextFactory.getContext().getBean("tipoPrestazioneBridge"));
			}
		}
		return bridge;
	}
	public void setBridge(GenericBridge bridge) {this.bridge = bridge;}
}
