package com.salesianostriana.com.Triana_Tourist.services;

import com.salesianostriana.com.Triana_Tourist.dto.POI.CreatePOIDTO;
import com.salesianostriana.com.Triana_Tourist.dto.POI.GetPOIDTO;
import com.salesianostriana.com.Triana_Tourist.dto.POI.POIDTOConverter;
import com.salesianostriana.com.Triana_Tourist.dto.Route.CreateRouteDTO;
import com.salesianostriana.com.Triana_Tourist.dto.Route.GetRouteDTO;
import com.salesianostriana.com.Triana_Tourist.dto.Route.RouteDTOConverter;
import com.salesianostriana.com.Triana_Tourist.error.tiposErrores.EntityNotFoundException;
import com.salesianostriana.com.Triana_Tourist.error.tiposErrores.ListEntityNotFoundException;
import com.salesianostriana.com.Triana_Tourist.model.POI;
import com.salesianostriana.com.Triana_Tourist.model.Route;
import com.salesianostriana.com.Triana_Tourist.repositories.RouteRepository;
import com.salesianostriana.com.Triana_Tourist.services.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RouteService extends BaseService<Route, Long, RouteRepository> {

    private final RouteRepository repository;
    private final RouteDTOConverter converter;
    private final POIService poiService;
    private final POIDTOConverter poidtoConverter;

    public List<GetRouteDTO> findAllRoutes() throws ListEntityNotFoundException {

        List<Route> lista = repository.findAll();

        if(lista.isEmpty()){
            throw new ListEntityNotFoundException(Route.class);
        }
        else {
            return lista.stream().map(converter::routeTORouteDTO).collect(Collectors.toList());
        }
    }

    public GetRouteDTO findOne(Long id) throws EntityNotFoundException {

        Optional<Route> route = repository.findById(id);

        if (route.isEmpty()){
            throw new EntityNotFoundException(id, Route.class);
        }
        else  {
            GetRouteDTO dto = converter.routeTORouteDTO(route.get());
            return dto;
        }
    }

    public Route addRoute(CreateRouteDTO r) {

        Route route = converter.createRoute(r);

        repository.save(route);

        return route;
    }

    public Route editRoute(GetRouteDTO dto, Long id) {

        Optional<Route> route = repository.findById(id);

        if(route.isEmpty()){
            throw new EntityNotFoundException(id, Route.class);
        }

        return route.map(r -> {
            r.setName(dto.getName());
            r.setPuntosInteres(new ArrayList<>());
            repository.save(r);
            return r;
        }).get();


    }

    public void delete(Long id){

        Optional<Route> route = repository.findById(id);

        if(route.isEmpty()){
            throw new EntityNotFoundException(id, Route.class);
        }

        repository.delete(route.get());

    }

    public Route addPuntoInteres(Long id, Long id2) {

        Route route = repository.findById(id).get();
        GetPOIDTO poi = poiService.findOne(id2);

        if(route.getId() == null){
            throw new EntityNotFoundException(id, Route.class);
        }

        if(id2==null){
            throw new EntityNotFoundException(id, POI.class);
        }

        POI poi2 = poidtoConverter.dtoToPOI(poi);

        route.addPOI(poi2);

        poiService.save(poi2);
        repository.save(route);


        return route;
    }

    public void deletePOI(Long id, Long id2){

        Optional<Route> route = repository.findById(id);
        GetPOIDTO poi = poiService.findOne(id2);

        if(route.isEmpty()){
            throw new EntityNotFoundException(id, Route.class);
        }

        POI poi2 = poidtoConverter.dtoToPOI(poi);
        route.get().removePOI(poi2);

    }

}
