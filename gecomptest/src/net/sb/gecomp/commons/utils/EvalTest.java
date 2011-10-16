package net.sb.gecomp.commons.utils;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EvalTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsNumeric() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsNotNumeric() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsDouble() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsNotDouble() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsNull() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsNotNull() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsEmptyString() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsNotEmptyString() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsEmptyCollection() {
		Collection coll = null;
		
		assertTrue(Eval.isEmpty(coll));
		
		coll = new ArrayList();
		assertTrue(Eval.isEmpty(coll));
		
	}

	@Test
	public void testIsNotEmptyCollection() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsObjectObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsIgnoreCase() {
		fail("Not yet implemented");
	}

}
