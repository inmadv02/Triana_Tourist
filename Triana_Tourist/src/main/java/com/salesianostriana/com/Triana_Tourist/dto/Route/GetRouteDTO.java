package com.salesianostriana.com.Triana_Tourist.dto.Route;

import com.salesianostriana.com.Triana_Tourist.validation.simple.annotations.UniqueRoute;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetRouteDTO {

    @UniqueRoute
    @NotBlank
    @NotNull
    private String name;

    @UniqueElements
    private List<String> poi = new ArrayList<>();
}
