package org.itsimulator.germes.app.service.impl;

import org.itsimulator.germes.app.infra.util.CommonUtil;
import org.itsimulator.germes.app.model.entity.geography.City;
import org.itsimulator.germes.app.model.entity.geography.Station;
import org.itsimulator.germes.app.model.search.criteria.StationCriteria;
import org.itsimulator.germes.app.model.search.criteria.range.RangeCriteria;
import org.itsimulator.germes.app.service.GeographicService;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Default implementation of the {@link GeographicService}
 * @author Morenets
 *
 */
public class GeographicServiceImpl implements GeographicService {
	/**
	 * Internal list of cities
	 */
	private final List<City> cities;

	/**
	 * Auto-increment counter for entity id generation
	 */
	private int counter = 0;

	public GeographicServiceImpl() {
		cities = new ArrayList<>();
	}

	@Override
	public List<City> findCities() {
		return CommonUtil.getSafeList(cities);
	}

	@Override
	public void saveCity(City city) {
		if (! cities.contains(city)) {
			city.setId(++ counter);
			cities.add(city);
		}
	}

	@Override
	public Optional<City> findCityById(int id) {
		return cities.stream().filter(city -> city.getId() == id).findFirst();
	}

	@Override
	public List<Station> searchStations(StationCriteria criteria, RangeCriteria rangeCriteria) {
		Set<Station> stations = new HashSet<>();
		for (City city: cities) {
			stations.addAll(city.getStations());
		}

		return stations.stream().filter((station) -> station.match(criteria)).collect(Collectors.toList());
	}

}
