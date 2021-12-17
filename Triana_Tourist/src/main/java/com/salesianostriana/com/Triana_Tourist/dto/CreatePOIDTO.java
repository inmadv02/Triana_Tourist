package com.salesianostriana.com.Triana_Tourist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor @NoArgsConstructor
public class CreatePOIDTO {

    private String location;

    private String description;
    private LocalDate date;
    private String coverPhoto, photo2, photo3;
}
