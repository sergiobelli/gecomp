package org.sbelli.gecomp.console.classifiche.delegates;

import java.util.HashMap;
import java.util.List;

import net.sb.gecomp.exceptions.GeCompException;

import org.sbelli.gecomp.console.bridges.view.CategoriaView;
import org.sbelli.gecomp.console.bridges.view.ClassificaGaraView;
import org.sbelli.gecomp.console.bridges.view.ClassificaView;
import org.sbelli.gecomp.console.bridges.view.GaraView;
import org.sbelli.gecomp.console.bridges.view.PrestazioneView;
import org.sbelli.gecomp.console.categorie.delegates.CategoriaDelegate;
import org.sbelli.gecomp.console.classifiche.delegates.societa.ClassificaSocietaDelegate;
import org.sbelli.gecomp.console.classifiche.delegates.societa.ClassificaSocietaPunteggioDecrescenteDelegate;
import org.sbelli.gecomp.console.iscrizioni.delegates.IscrizioneDelegate;
import org.sbelli.gecomp.console.prestazioni.delegates.PrestazioneDelegate;
import org.sbelli.gecomp.orm.model.Gara;

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
