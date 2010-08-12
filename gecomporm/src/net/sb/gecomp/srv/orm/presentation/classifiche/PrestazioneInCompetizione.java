package net.sb.gecomp.srv.orm.presentation.classifiche;

import java.util.List;

import net.sb.gecomp.commons.model.Atleta;
import net.sb.gecomp.commons.model.Competizione;
import net.sb.gecomp.commons.model.Gara;
import net.sb.gecomp.srv.orm.ibatis.DbManagerFactory;


public class PrestazioneInCompetizione {

	private Atleta atleta;
	private Competizione competizione;
	private List<Gara> gareSostenute;
	private long valoreMisuraTotale;
	private boolean ritirato;
	private boolean squalificato;
	private String note;
	
	public Atleta getAtleta() {
		return atleta;
	}
	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}
	public Competizione getCompetizione() {
		return competizione;
	}
	public void setCompetizione(Competizione competizione) {
		this.competizione = competizione;
	}
	public List<Gara> getGareSostenute() {
		return gareSostenute;
	}
	public void setGareSostenute(List<Gara> gareSostenute) {
		this.gareSostenute = gareSostenute;
	}
	public long getValoreMisuraTotale() {
		return valoreMisuraTotale;
	}
	public void setValoreMisuraTotale(long valoreMisuraTotale) {
		this.valoreMisuraTotale = valoreMisuraTotale;
	}
	public boolean isRitirato() {
		return ritirato;
	}
	public void setRitirato(boolean ritirato) {
		this.ritirato = ritirato;
	}
	public boolean isSqualificato() {
		return squalificato;
	}
	public void setSqualificato(boolean squalificato) {
		this.squalificato = squalificato;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		
		buf.append("[");

		buf.append("atleta="+getAtleta()).append(",");
		buf.append("competizione="+getCompetizione()).append(",");
		buf.append("n gare="+getGareSostenute().size()).append(",");
		buf.append("note="+getNote()).append(",");
		buf.append("ritirato="+isRitirato()).append(",");
		buf.append("squalificato="+isSqualificato()).append(",");
		buf.append("tempo="+DbManagerFactory.getInstance().getPrestazioneDao().getTempo(getValoreMisuraTotale()));

		buf.append("]");
		return buf.toString();
	}
	
	
}
