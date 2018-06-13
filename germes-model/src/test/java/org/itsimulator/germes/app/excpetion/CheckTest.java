package org.itsimulator.germes.app.excpetion;

import org.itsimulator.germes.app.infra.exception.flow.InvalidParameterException;
import org.itsimulator.germes.app.infra.util.Checks;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckTest {

	@Test
	public void testCheckParameterGetException() {
		try {
			Checks.checkParameter(false, "test");
			fail();
		} catch (InvalidParameterException ex) {
			assertEquals(ex.getMessage(), "test");
		}
	}

	@Test
	public void testCheckParameterNoException() {
		Checks.checkParameter(true, "test");
		assertTrue(true);
	}
}
