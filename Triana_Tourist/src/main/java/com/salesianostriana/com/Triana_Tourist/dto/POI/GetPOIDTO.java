package com.salesianostriana.com.Triana_Tourist.dto.POI;

import com.salesianostriana.com.Triana_Tourist.model.Category;
import com.salesianostriana.com.Triana_Tourist.validation.multiple.annotations.NotRepeatedPhotos;
import com.salesianostriana.com.Triana_Tourist.validation.simple.annotations.LocationFormatMatch;
import com.salesianostriana.com.Triana_Tourist.validation.simple.annotations.PhotoUrlFormat;
import com.salesianostriana.com.Triana_Tourist.validation.simple.annotations.UniquePOI;
import lombok.*;
import org.hibernate.validator.constraints.URL;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
@NotRepeatedPhotos(fields = {"coverPhoto", "photo2", "photo3"})
public class GetPOIDTO {

    private Long id;

    @NotBlank(message = "{category.name.empty}")
    @UniquePOI
    private String name;

    @LocationFormatMatch
    private String location;

    private String description;
    private LocalDate date;

    @URL(message = "{poi.foto.URL}")
    @NotBlank(message = "{poi.foto.blank}")
    private String coverPhoto;


    private String photo2, photo3;


    private Category category;


}
