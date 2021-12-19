package com.salesianostriana.com.Triana_Tourist.dto.POI;

import com.salesianostriana.com.Triana_Tourist.model.Category;
import com.salesianostriana.com.Triana_Tourist.validation.multiple.annotations.NotRepeatedPhotos;
import com.salesianostriana.com.Triana_Tourist.validation.simple.annotations.LocationFormatMatch;
import com.salesianostriana.com.Triana_Tourist.validation.simple.annotations.PhotoUrlFormat;
import com.salesianostriana.com.Triana_Tourist.validation.simple.annotations.UniquePOI;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
@NotRepeatedPhotos.List({
        @NotRepeatedPhotos(
                photoUrl1 = "coverPhoto",
                photoUrl2 = "photo2",
                photoUrl3 = "photo3",
                message = "{poi.foto.repeat}"
        )
})
public class GetPOIDTO {

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


    private Category category;


}
