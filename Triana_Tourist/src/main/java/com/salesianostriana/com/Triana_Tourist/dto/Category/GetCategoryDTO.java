package com.salesianostriana.com.Triana_Tourist.dto.Category;

import com.salesianostriana.com.Triana_Tourist.validation.simple.annotations.UniqueCategory;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetCategoryDTO {

    private Long id;

    @NotNull(message = "{category.name.null}")
    @NotBlank(message = "{category.name.empty}")
    @UniqueCategory
    private String name;
}
