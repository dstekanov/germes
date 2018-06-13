package org.itsimulator.germes.app.model.entity.geography;

import org.itsimulator.germes.app.model.entity.transport.TransportType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Contains unit-tests to check functionality of {@link City} class
 *
 * @author Morenets
 */
public class CityTest {
	private City city;

	@Before
	public void setup() {
		city = new City("Lviv");
	}

	@Test
	public void testAddValidStationSuccess() {
		Station station = city.addStation(TransportType.AUTO);

		assertTrue(containsStation(city, station));
		assertEquals(city, station.getCity());
	}

	@Test(expected = NullPointerException.class)
	public void testAddStationNullTransportTypeFailure() {
		city.addStation(null);

		fail();
	}

	@Test
	public void testRemoveStationSuccess() {
		Station station = city.addStation(TransportType.AUTO);

		city.removeStation(station);

		assertTrue(city.getStations().isEmpty());
	}

	@Test(expected = NullPointerException.class)
	public void testRemoveNullStationFailure() {
		city.removeStation(null);

		fail();
	}

	private boolean containsStation(City city, Station station) {
		return city.getStations().contains(station);
	}

}
