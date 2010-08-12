package net.sb.gecomp.web.delegates.classifiche;

import java.util.HashMap;
import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.Gara;
import net.sb.gecomp.commons.model.view.CategoriaView;
import net.sb.gecomp.commons.model.view.ClassificaGaraView;
import net.sb.gecomp.commons.model.view.ClassificaView;
import net.sb.gecomp.commons.model.view.GaraView;
import net.sb.gecomp.commons.model.view.PrestazioneView;
import net.sb.gecomp.web.delegates.categorie.CategoriaDelegate;
import net.sb.gecomp.web.delegates.classifiche.societa.ClassificaSocietaDelegate;
import net.sb.gecomp.web.delegates.classifiche.societa.ClassificaSocietaPunteggioDecrescenteDelegate;
import net.sb.gecomp.web.delegates.iscrizioni.IscrizioneDelegate;
import net.sb.gecomp.web.delegates.prestazioni.PrestazioneDelegate;


public class ClassificaGaraDelegate extends ClassificaDelegate {

	private CategoriaDelegate categoriaDelegate = new CategoriaDelegate();
	private IscrizioneDelegate iscrizioneDelegate = new IscrizioneDelegate();
	private PrestazioneDelegate prestazioneDelegate = new PrestazioneDelegate();
	private ClassificaSocietaDelegate classificaSocietaDelegate = new ClassificaSocietaPunteggioDecrescenteDelegate();
	
	public ClassificaView getClassifica(Gara gara) throws GeCompException {
		ClassificaGaraView classificaGara = new ClassificaGaraView();
		classificaGara.setGara(new GaraView(gara));
		classificaGara.setCategorie(categoriaDelegate.list(classificaGara.getGara()));
		classificaGara.setIscritti(iscrizioneDelegate.list(classificaGara.getGara()));
		classificaGara.setClassificaGenerale(prestazioneDelegate.list(classificaGara.getGara()));
		
		HashMap<CategoriaView, List<PrestazioneView>> classificheCategorie = new HashMap<CategoriaView, List<PrestazioneView>>();
		for (CategoriaView cat : classificaGara.getCategorie()) {
			classificheCategorie.put(cat, prestazioneDelegate.list(classificaGara.getGara(),cat));
		}
		classificaGara.setClassificheCategorie(classificheCategorie);
		
		classificaGara.setClassificaSocieta(classificaSocietaDelegate.getClassifica(classificaGara.getGara()));
		
		return classificaGara;
	}

}
