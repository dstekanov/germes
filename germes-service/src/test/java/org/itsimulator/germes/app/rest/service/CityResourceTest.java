package org.itsimulator.germes.app.rest.service;

import org.glassfish.jersey.test.JerseyTest;
import org.itsimulator.germes.app.rest.service.config.JerseyConfig;
import org.junit.Test;

import javax.ws.rs.core.Application;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CityResourceTest extends JerseyTest {

	@Override
	protected Application configure() {
		return new JerseyConfig();
	}

	@Test
	public void testFindCitiesSuccess() {
		List<?> cities = target("cities").request().get(List.class);
		assertNotNull(cities);

		assertTrue(String.format("Cities contains only: %s", cities), cities.contains("Odessa"));
		assertTrue(String.format("Cities contains only: %s", cities), cities.contains("Kiyv"));

	}
}
