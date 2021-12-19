package com.salesianostriana.com.Triana_Tourist.controller;


import com.salesianostriana.com.Triana_Tourist.dto.Category.CreateCategoryDTO;
import com.salesianostriana.com.Triana_Tourist.dto.Category.GetCategoryDTO;
import com.salesianostriana.com.Triana_Tourist.dto.POI.CreatePOIDTO;
import com.salesianostriana.com.Triana_Tourist.dto.POI.GetPOIDTO;
import com.salesianostriana.com.Triana_Tourist.model.Category;
import com.salesianostriana.com.Triana_Tourist.model.POI;
import com.salesianostriana.com.Triana_Tourist.services.POIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/poi")
public class POIController {

    private final POIService poiService;

    @GetMapping("/")
    public ResponseEntity<List<GetPOIDTO>> todasLosPOI(){

        List<GetPOIDTO> lista = poiService.findAllPOI();

        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetPOIDTO> unPuntoDeInteres(@PathVariable Long id){

        GetPOIDTO poi = poiService.findOne(id);
        return ResponseEntity.ok().body(poi);
    }


    @PostMapping("/")
    public ResponseEntity<CreatePOIDTO> nuevoPOI (@Valid @RequestBody CreatePOIDTO dto){

        poiService.addPOI(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GetPOIDTO> editarPOI(@Valid @RequestBody GetPOIDTO dto, @PathVariable Long id){

        poiService.editPOI(dto, id);
        return ResponseEntity.ok().body(dto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarPOI(@PathVariable Long id){
        poiService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
