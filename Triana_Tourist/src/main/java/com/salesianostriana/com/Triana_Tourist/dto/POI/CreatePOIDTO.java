package com.salesianostriana.com.Triana_Tourist.dto.POI;

import com.salesianostriana.com.Triana_Tourist.validation.multiple.annotations.NotRepeatedPhotos;
import com.salesianostriana.com.Triana_Tourist.validation.simple.annotations.LocationFormatMatch;
import com.salesianostriana.com.Triana_Tourist.validation.simple.annotations.PhotoUrlFormat;
import com.salesianostriana.com.Triana_Tourist.validation.simple.annotations.UniquePOI;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor @NoArgsConstructor
@NotRepeatedPhotos(fields = {"coverPhoto", "photo2", "photo3"})
public class CreatePOIDTO {

    @NotBlank(message = "{category.name.empty}")
    @UniquePOI
    private String name;

    @LocationFormatMatch
    private String location;

    private String description;
    private LocalDate date;

    @PhotoUrlFormat
    @NotBlank(message = "{poi.foto.blank}")
    private String coverPhoto;


    private String photo2, photo3;

    private Long category;
}
