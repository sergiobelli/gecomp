package net.sb.gecomp.console.categorie.controllers;

import static org.junit.Assert.fail;
import net.sb.gecomp.exceptions.GeCompException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sbelli.gecomp.console.bridges.view.CategoriaView;
import org.sbelli.gecomp.orm.model.Categoria;

public class CategoriaControllerTest {

	private Categoria categoria;
	private CategoriaController4Test controller;
	
	private static final String WRONG_FORMAT = "XXX";
	private static final String EMPTY = "";
	private static final String NULL = null;
	private static final String CORRECT_FORMAT_FIRST = "1981";
	private static final String CORRECT_FORMAT_SECOND = "1982";
	
	@Before
	public void setUp() throws Exception {
		categoria = new CategoriaView();
		controller = new CategoriaController4Test();
	}

	@After
	public void tearDown() throws Exception {}

	
	
	@Test
	public void testChecksAnnoPartenza() throws GeCompException {
		categoria.setAnnoPartenza(CORRECT_FORMAT_FIRST);
		controller.checksAnnoPartenza(categoria);
	}
	
	@Test(expected= GeCompException.class)
	public void testChecksAnnoPartenza_wrongFormat() throws GeCompException {
		categoria.setAnnoPartenza(WRONG_FORMAT);
		controller.checksAnnoPartenza(categoria);
	}

	@Test(expected= GeCompException.class)
	public void testChecksAnnoPartenza_empty() throws GeCompException {
		categoria.setAnnoPartenza(EMPTY);
		controller.checksAnnoPartenza(categoria);
	}
	
	@Test(expected= GeCompException.class)
	public void testChecksAnnoPartenza_null() throws GeCompException {
		categoria.setAnnoPartenza(NULL);
		controller.checksAnnoPartenza(categoria);
	}
	
	@Test
	public void testChecksAnnoFine() throws GeCompException {
		categoria.setAnnoFine(CORRECT_FORMAT_FIRST);
		controller.checksAnnoFine(categoria);
	}

	@Test(expected= GeCompException.class)
	public void testChecksAnnoFine_wrongFormat() throws GeCompException {
		categoria.setAnnoFine(WRONG_FORMAT);
		controller.checksAnnoFine(categoria);
	}

	@Test(expected= GeCompException.class)
	public void testChecksAnnoFine_empty() throws GeCompException {
		categoria.setAnnoFine(EMPTY);
		controller.checksAnnoFine(categoria);
	}
	
	@Test(expected= GeCompException.class)
	public void testChecksAnnoFine_null() throws GeCompException {
		categoria.setAnnoFine(NULL);
		controller.checksAnnoFine(categoria);
	}
	
	@Test
	public void testChecksCongruenzaDate() {
		fail("Not yet implemented");
	}

}
