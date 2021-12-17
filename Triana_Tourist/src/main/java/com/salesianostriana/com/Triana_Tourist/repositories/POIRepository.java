package com.salesianostriana.com.Triana_Tourist.repositories;

import com.salesianostriana.com.Triana_Tourist.model.POI;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface POIRepository extends JpaRepository<POI, Long> {


    List<POI> findPOIByCategoria(String categoria);
}
