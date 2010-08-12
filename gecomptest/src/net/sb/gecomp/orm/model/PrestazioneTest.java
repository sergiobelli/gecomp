package net.sb.gecomp.orm.model;

import java.util.Set;
import java.util.TreeSet;

import junit.framework.TestCase;
import net.sb.gecomp.commons.model.Competizione;
import net.sb.gecomp.commons.model.Gara;
import net.sb.gecomp.commons.model.Iscrizione;
import net.sb.gecomp.commons.model.Prestazione;
import net.sb.gecomp.commons.model.TipoMisura;
import net.sb.gecomp.commons.model.TipoPrestazione;

public class PrestazioneTest extends TestCase {

	private TipoPrestazione tp_VALIDA = null;
	private TipoPrestazione tp_RITIRO = null;
	private TipoPrestazione tp_SQUALIFICA = null;
	private TipoPrestazione tp_NON_CLASSIFICATO = null;
	private TipoPrestazione tp_NON_PARTECIPATO = null;

	private TipoMisura tm = null;
	
	private Gara gara = null;
	private Iscrizione iscrizione = null;
	
	protected void setUp() throws Exception {
		super.setUp();
		tp_VALIDA = new TipoPrestazione(TipoPrestazione.VALIDA,null);
		tp_RITIRO = new TipoPrestazione(TipoPrestazione.RITIRO,null);
		tp_SQUALIFICA = new TipoPrestazione(TipoPrestazione.SQUALIFICA,null);
		tp_NON_CLASSIFICATO = new TipoPrestazione(TipoPrestazione.NON_CLASSIFICATO,null);
		tp_NON_PARTECIPATO = new TipoPrestazione(TipoPrestazione.NON_PARTECIPATO,null);
		
		tm = new TipoMisura("xxx","metri",TipoMisura.MISURAZIONE_DISCENDENTE);
		
		gara = new Gara();
		gara.setCompetizione(new Competizione());
		
		iscrizione = new Iscrizione();
		iscrizione.setGara(gara);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	
	public void testCompare() {
		Set<Prestazione> insieme = new TreeSet<Prestazione>();
		insieme.add(new Prestazione(iscrizione,tp_NON_CLASSIFICATO, tm, null));
		insieme.add(new Prestazione(iscrizione,tp_VALIDA, tm, 3l));
		insieme.add(new Prestazione(iscrizione,tp_VALIDA, tm, 2l));
		insieme.add(new Prestazione(iscrizione,tp_SQUALIFICA, tm, null));
		insieme.add(new Prestazione(iscrizione,tp_VALIDA, tm, 1l));
		insieme.add(new Prestazione(iscrizione,tp_NON_PARTECIPATO, tm, null));
		insieme.add(new Prestazione(iscrizione,tp_VALIDA, tm, -1l));
		insieme.add(new Prestazione(iscrizione,tp_NON_PARTECIPATO, tm, null));
		insieme.add(new Prestazione(iscrizione,tp_RITIRO, tm, null));
		
		for (Prestazione p : insieme){
			System.out.println(p.getValoreMisura() + " " + p.getTipoPrestazione().getIdTipoPrestazione());
		}
	}
	
}
