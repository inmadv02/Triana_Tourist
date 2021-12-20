package com.salesianostriana.com.Triana_Tourist.controller;

import com.salesianostriana.com.Triana_Tourist.dto.POI.CreatePOIDTO;
import com.salesianostriana.com.Triana_Tourist.dto.POI.GetPOIDTO;
import com.salesianostriana.com.Triana_Tourist.dto.Route.CreateRouteDTO;
import com.salesianostriana.com.Triana_Tourist.dto.Route.GetRouteDTO;
import com.salesianostriana.com.Triana_Tourist.model.POI;
import com.salesianostriana.com.Triana_Tourist.services.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/route")
public class RouteController {

    private final RouteService routeService;

    @GetMapping("/")
    public ResponseEntity<List<GetRouteDTO>> todasLasRoutes(){

        List<GetRouteDTO> lista = routeService.findAllRoutes();

        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetRouteDTO> unaRuta(@PathVariable Long id){

        GetRouteDTO routeDTO = routeService.findOne(id);
        return ResponseEntity.ok().body(routeDTO);
    }


    @PostMapping("/")
    public ResponseEntity<CreateRouteDTO> nuevaRuta (@Valid @RequestBody CreateRouteDTO dto){

        routeService.addRoute(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CreateRouteDTO> editarRoute(@Valid @RequestBody CreateRouteDTO dto, @PathVariable Long id){

        routeService.editRoute(dto, id);
        return ResponseEntity.ok().body(dto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarRoute(@PathVariable Long id){
        routeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/poi/{id2}")
    public ResponseEntity<GetRouteDTO> agregarPOI(@Valid @PathVariable Long id, @PathVariable Long id2){

        routeService.addPuntoInteres(id, id2);
        return ResponseEntity.ok().body(routeService.findOne(id));
    }

    @DeleteMapping("/{id}/poi/{id2}")
    public ResponseEntity<?> borrarPOI(@PathVariable Long id, @PathVariable Long id2){

        routeService.deletePOI(id, id2);
        return ResponseEntity.noContent().build();
    }

}
