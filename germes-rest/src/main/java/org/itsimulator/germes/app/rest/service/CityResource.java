package org.itsimulator.germes.app.rest.service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang3.math.NumberUtils;
import org.itsimulator.germes.app.model.entity.geography.City;
import org.itsimulator.germes.app.model.entity.transport.TransportType;
import org.itsimulator.germes.app.rest.dto.CityDTO;
import org.itsimulator.germes.app.rest.service.base.BaseResource;
import org.itsimulator.germes.app.service.GeographicService;
import org.itsimulator.germes.app.service.transform.Transformer;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("cities")
@Api("cities")
/**
 * {@link CityResource} is REST web-service that handles city-related requests
 *
 * @author Stekanov
 *
 */
public class CityResource extends BaseResource {

    /**
     * Underlying source of data
     */
    private final GeographicService service;

    /**
     * DTO <-> Entity transformer
     */
    private final Transformer transformer;

    @Inject
    public CityResource(GeographicService service, Transformer transformer) {
        this.transformer = transformer;

        this.service = service;
        City city = new City("Odessa");
        city.addStation(TransportType.AUTO);
        city.setDistrict("Odessa");
        city.setRegion("Odessa");
        service.saveCity(city);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Returns all the existing cities")
    /**
     * Returns all the existing cities
     *
     * @return
     */
    public List<CityDTO> findCities() {
        return service.findCities().stream().map((city) -> transformer.transform(city, CityDTO.class))
                .collect(Collectors.toList());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    /**
     * Saves new city instance
     *
     * @return
     */
    public void saveCity(CityDTO cityDTO) {
        service.saveCity(transformer.untransform(cityDTO, City.class));
    }

    @Path("/{cityId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Returns existing city by its identifier")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Invalid city identifier"),
            @ApiResponse(code = 404, message = "Identifier of the non-existing city")})
    /**
     * Returns city with specified identifier
     *
     * @return
     */
    public Response findCityById(@ApiParam("Unique numeric city identifier") @PathParam("cityId") final String cityId) {
        if (!NumberUtils.isNumber(cityId)) {
            return BAD_REQUEST;
        }

        Optional<City> city = service.findCitiyById(NumberUtils.toInt(cityId));
        if (!city.isPresent()) {
            return NOT_FOUND;
        }
        return ok(transformer.transform(city.get(), CityDTO.class));
    }

}
