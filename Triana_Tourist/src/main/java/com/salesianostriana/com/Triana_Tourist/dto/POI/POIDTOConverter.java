package com.salesianostriana.com.Triana_Tourist.dto.POI;

import com.salesianostriana.com.Triana_Tourist.dto.POI.GetPOIDTO;
import com.salesianostriana.com.Triana_Tourist.model.Category;
import com.salesianostriana.com.Triana_Tourist.model.POI;
import com.salesianostriana.com.Triana_Tourist.services.CategoryService;
import com.salesianostriana.com.Triana_Tourist.services.POIService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class POIDTOConverter {

    private final CategoryService service;

    public GetPOIDTO poiTOPOIDTO(POI poi){

        return GetPOIDTO
                .builder()
                .id(poi.getId())
                .name(poi.getName())
                .location(poi.getLocation())
                .date(poi.getDate())
                .description(poi.getDescription())
                .category(poi.getCategory())
                .coverPhoto(poi.getCoverPhoto())
                .photo2(poi.getPhoto2())
                .photo3(poi.getPhoto3())
                .build();
    }

    public POI createPOI(CreatePOIDTO c){
        return POI.builder()
                .name(c.getName())
                .location(c.getLocation())
                .date(c.getDate())
                .description(c.getDescription())
                .category(service.findOne(c.getCategory()))
                .coverPhoto(c.getCoverPhoto())
                .photo2(c.getPhoto2())
                .photo3(c.getPhoto3())
                .build();
    }

    public POI dtoToPOI (GetPOIDTO poi){

        return POI.builder()
                .id(poi.getId())
                .name(poi.getName())
                .location(poi.getLocation())
                .date(poi.getDate())
                .description(poi.getDescription())
                .category(poi.getCategory())
                .coverPhoto(poi.getCoverPhoto())
                .photo2(poi.getPhoto2())
                .photo3(poi.getPhoto3())
                .build();


    }
}
