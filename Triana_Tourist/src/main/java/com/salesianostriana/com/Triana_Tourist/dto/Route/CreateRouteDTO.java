package com.salesianostriana.com.Triana_Tourist.dto.Route;

import com.salesianostriana.com.Triana_Tourist.validation.simple.annotations.UniqueRoute;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRouteDTO {

    @UniqueRoute
    @NotNull(message = "{category.name.null}")
    @NotBlank(message = "{category.name.empty}")
    private String name;
}
