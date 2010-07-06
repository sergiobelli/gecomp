package org.sbelli.gecomp.console.bridges.view;

import java.util.HashMap;

import org.sbelli.gecomp.orm.model.Societa;

public class ClassificaSocietaView {

	private HashMap<Societa,Integer> classificaSocietaIscritte;
	private HashMap<Societa,Integer> classificaSocietaClassificate;
	private HashMap<Societa,Integer> classificaSocietaPunteggio;
	
	public ClassificaSocietaView() {}
	public ClassificaSocietaView(
			HashMap<Societa, Integer> classificaSocietaIscritte,
			HashMap<Societa, Integer> classificaSocietaClassificate,
			HashMap<Societa, Integer> classificaSocietaPunteggio) {
		super();
		this.classificaSocietaIscritte = classificaSocietaIscritte;
		this.classificaSocietaClassificate = classificaSocietaClassificate;
		this.classificaSocietaPunteggio = classificaSocietaPunteggio;
	}


	public HashMap<Societa, Integer> getClassificaSocietaIscritte() {
		return classificaSocietaIscritte;
	}

	public void setClassificaSocietaIscritte(
			HashMap<Societa, Integer> classificaSocietaIscritte) {
		this.classificaSocietaIscritte = classificaSocietaIscritte;
	}

	public HashMap<Societa, Integer> getClassificaSocietaClassificate() {
		return classificaSocietaClassificate;
	}

	public void setClassificaSocietaClassificate(
			HashMap<Societa, Integer> classificaSocietaClassificate) {
		this.classificaSocietaClassificate = classificaSocietaClassificate;
	}

	public HashMap<Societa, Integer> getClassificaSocietaPunteggio() {
		return classificaSocietaPunteggio;
	}

	public void setClassificaSocietaPunteggio(
			HashMap<Societa, Integer> classificaSocietaPunteggio) {
		this.classificaSocietaPunteggio = classificaSocietaPunteggio;
	}

	
	
	

	
	
}
