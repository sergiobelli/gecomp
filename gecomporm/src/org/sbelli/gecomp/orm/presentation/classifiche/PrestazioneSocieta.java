package org.sbelli.gecomp.orm.presentation.classifiche;

import java.util.List;

import org.sbelli.gecomp.orm.model.Atleta;
import org.sbelli.gecomp.orm.model.Societa;

public class PrestazioneSocieta {

	private Societa societa;
	private long tempo;
	private List<Atleta> atleti;
	private int numeroAtleti;
	
	
	public Societa getSocieta() {
		return societa;
	}
	public void setSocieta(Societa societa) {
		this.societa = societa;
	}
	public long getTempo() {
		return tempo;
	}
	public void setTempo(long tempo) {
		this.tempo = tempo;
	}
	public List<Atleta> getAtleti() {
		return atleti;
	}
	public void setAtleti(List<Atleta> atleti) {
		this.atleti = atleti;
	}
	public int getNumeroAtleti() {
		return numeroAtleti;
	}
	public void setNumeroAtleti(int numeroAtleti) {
		this.numeroAtleti = numeroAtleti;
	}
	
	
}
