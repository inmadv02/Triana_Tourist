package com.salesianostriana.com.Triana_Tourist.dto;

import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class GetPOIDTO {

    private String location;

    private String description;
    private LocalDate date;
    private String coverPhoto, photo2, photo3;

}
