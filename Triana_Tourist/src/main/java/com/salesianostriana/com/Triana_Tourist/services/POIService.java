package com.salesianostriana.com.Triana_Tourist.services;

import com.salesianostriana.com.Triana_Tourist.model.POI;
import com.salesianostriana.com.Triana_Tourist.repositories.POIRepository;
import com.salesianostriana.com.Triana_Tourist.services.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class POIService extends BaseService<POI, Long, POIRepository> {
}
