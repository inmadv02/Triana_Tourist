package com.salesianostriana.com.Triana_Tourist.dto.Route;

import com.salesianostriana.com.Triana_Tourist.dto.Category.CreateCategoryDTO;

import com.salesianostriana.com.Triana_Tourist.model.Route;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RouteDTOConverter {

    public Route createRoute(CreateRouteDTO c){
        return new Route(
                c.getName()
        );
    }

    public GetRouteDTO routeTORouteDTO(Route r){

        List<String> poisList = r.getPuntosInteres().stream().map(p -> p.getName()).collect(Collectors.toList());

        return GetRouteDTO
                .builder()
                .id(r.getId())
                .name(r.getName())
                .poi(poisList)
                .build();
    }

}
