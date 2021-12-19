package com.salesianostriana.com.Triana_Tourist.services;


import com.salesianostriana.com.Triana_Tourist.dto.POI.CreatePOIDTO;
import com.salesianostriana.com.Triana_Tourist.dto.POI.GetPOIDTO;
import com.salesianostriana.com.Triana_Tourist.dto.POI.POIDTOConverter;
import com.salesianostriana.com.Triana_Tourist.error.tiposErrores.EntityNotFoundException;
import com.salesianostriana.com.Triana_Tourist.error.tiposErrores.ListEntityNotFoundException;
import com.salesianostriana.com.Triana_Tourist.model.Category;
import com.salesianostriana.com.Triana_Tourist.model.POI;
import com.salesianostriana.com.Triana_Tourist.model.Route;
import com.salesianostriana.com.Triana_Tourist.repositories.CategoryRepository;
import com.salesianostriana.com.Triana_Tourist.repositories.POIRepository;
import com.salesianostriana.com.Triana_Tourist.services.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class POIService extends BaseService<POI, Long, POIRepository> {

    private final POIRepository repository;
    private final POIDTOConverter converter;
    private final CategoryRepository categoryRepository;

    public List<GetPOIDTO> findAllPOI() throws ListEntityNotFoundException {

        List<POI> lista = repository.findAll();

        if(lista.isEmpty()){
            throw new ListEntityNotFoundException(POI.class);
        }
        else {
            return lista.stream().map(converter::poiTOPOIDTO).collect(Collectors.toList());
        }
    }

    public GetPOIDTO findOne(Long id) throws EntityNotFoundException {

        Optional<POI> poi = repository.findById(id);

        if (poi.isEmpty()){
            throw new EntityNotFoundException(id, POI.class);
        }
        else  {
            GetPOIDTO poidto = converter.poiTOPOIDTO(poi.get());
            return poidto;
        }
    }

    public POI addPOI(CreatePOIDTO c) {

        POI poi = converter.createPOI(c);

        repository.save(poi);

        return poi;
    }

    public POI editPOI(GetPOIDTO poidto, Long id) {

        Optional<POI> poi = repository.findById(id);

        if(poi.isEmpty()){
            throw new EntityNotFoundException(id, POI.class);
        }

        return poi.map(p -> {
            p.setLocation(poidto.getLocation());
            p.setDescription(poidto.getDescription());
            p.setDate(poidto.getDate());
            p.setCoverPhoto(poidto.getCoverPhoto());
            p.setPhoto2(poidto.getPhoto2());
            p.setPhoto3(poidto.getPhoto3());
            repository.save(p);
            return p;
        }).get();


    }

    public void delete(Long id){

        Optional<POI> poi = repository.findById(id);

        if(poi.isEmpty()){
            throw new EntityNotFoundException(id, POI.class);
        }

        repository.delete(poi.get());

    }


}
